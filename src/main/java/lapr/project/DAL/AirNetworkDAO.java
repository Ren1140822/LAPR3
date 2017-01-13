/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.AirNetwork;
import lapr.project.model.Node;
import lapr.project.model.Segment;
import lapr.project.model.Wind;
import lapr.project.utils.DAL;
import static lapr.project.utils.DAL.close;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AirNetworkDAO {

    DAL dal;

    public AirNetworkDAO() {
        dal = new DAL();
    }

    /**
     * Gets the air network by project ID.
     *
     * @param projectID the id of the project
     * @return the air network
     */
    public AirNetwork getAirNetwork(int projectID) {

        AirNetwork airNetwork = new AirNetwork();
        ResultSet rs = null;

        Connection con = null;
        String query = "{?= call get_airnetwork(?)}";
        con = dal.connect();

        try (CallableStatement st = con.prepareCall(query)) {
            st.setInt(2, projectID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                int netID = rs.getInt("ID");
                String description = rs.getString("description");
                List<Node> nodes = getNodesListByID(netID);
                List<Segment> segments = getSegmentsListByID(netID, nodes);
                airNetwork.setId(String.valueOf(netID));
                airNetwork.setDescription(description);
                airNetwork.setNodeList(nodes);
                airNetwork.setSegmentList(segments);
                airNetwork.generateGraph();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);

        }
        return airNetwork;
    }

    /**
     * Gets a nodes list by airnetwork ID.
     *
     * @param airNetworkID the airnetwork id
     * @return the list of nodes
     */
    private List<Node> getNodesListByID(int airNetworkID) {

        List<Node> nodes = new LinkedList<Node>();
        ResultSet rs = null;
        Connection con = null;
        String query = "{?= call get_nodes(?)}";
        con = dal.connect();

        try (CallableStatement st = con.prepareCall(query)) {
            st.setInt(2, airNetworkID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                String nodeID = rs.getString("ID");
                double latitude = rs.getDouble("Latitude");
                double longitude = rs.getDouble("Longitude");
                Node n = new Node(nodeID, latitude, longitude);
                nodes.add(n);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);

        }
        return nodes;
    }

    /**
     * Gets segments list by airnetwork id.
     *
     * @param airNetworkID the airnetwork id
     * @return the segment list
     */
    private List<Segment> getSegmentsListByID(int airNetworkID, List<Node> nodes) {

        List<Segment> segments = new LinkedList<Segment>();
        ResultSet rs = null;

        Connection con = null;
        String query = "{?= call get_segments(?)}";
        con = dal.connect();
        try (CallableStatement st = con.prepareCall(query)) {
            st.setInt(2, airNetworkID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                String id = rs.getString("ID");
                String startNode = rs.getString("startnode");
                String endNode = rs.getString("ENDNODE");
                Node realStartNode = null;
                Node realEndNode = null;
                for (Node n : nodes) {
                    if (startNode.equals(n.getId())) {
                        realStartNode = n;
                    }
                    if (endNode.equals(n.getId())) {
                        realEndNode = n;
                    }
                }
                int windID = rs.getInt("windid");
                String direction = rs.getString("direction");
                Wind wind = getWindByID(windID);
                int minAltSlot = rs.getInt("minAltSlot");
                int maxAltSlot = rs.getInt("maxAltSlot");
                Segment segment = new Segment(id, realStartNode, realEndNode, direction, wind, minAltSlot, maxAltSlot);
                segments.add(segment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);

        }
        return segments;
    }

    /**
     * Gets the wind of a segment.
     *
     * @param segmentID the id of the segment
     * @return the wind object
     */
    private Wind getWindByID(int windID) {

        Wind wind = null;
        ResultSet rs = null;

        Connection con = null;
        String query = "{?= call get_wind(?)}";
        con = dal.connect();
        try (CallableStatement st = con.prepareCall(query)) {
            st.setInt(2, windID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {

                double intensity = rs.getDouble("Intensity");
                double direction = rs.getDouble("Direction");
                wind = new Wind(intensity, direction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);

        }
        return wind;
    }

    public boolean WriteAirNetworkToDatabase(int projectID, String description) {
        Connection con = null;
        con = dal.connect();
        boolean ret = false;

        try (CallableStatement st = con.prepareCall("{call insert_airnetwork(?,?)}")) {
            st.setString(1, description);
            st.setInt(2, projectID);
            ret = st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } finally {
            close(con);

        }
        return true;
    }

    public boolean WriteSegmentsToDatabase(List<Segment> segmentList, int airNetworkID) {
        Connection con = null;
        con = dal.connect();
        boolean ret = false;

        try (CallableStatement st = con.prepareCall("{call insert_segment(?,?,?,?,?,?,?,?,?)}")) {
            for (Segment seg : segmentList) {
                st.setString(1, seg.getId());
                st.setString(2, seg.getStartNode().getId());
                st.setString(3, seg.getEndNode().getId());
                st.setString(4, seg.getDirection().name());
                st.setDouble(5, seg.getMinAltSlot());
                st.setDouble(6, seg.getMaxAltSlot());
                st.setInt(7, airNetworkID);
                st.setDouble(8, seg.getWind().getWindIntensity());
                st.setDouble(9, seg.getWind().getWindDirection());
                ret = st.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } finally {
            close(con);

        }
        return ret;
    }

    public boolean WriteNodesToDatabase(List<Node> nodeList, int netID) {
        Connection con = null;
        con = dal.connect();
        boolean ret = false;

        try (CallableStatement st = con.prepareCall("{call insert_node(?,?,?,?)}")) {
            for (Node node : nodeList) {
                st.setString(1, node.getId());
                st.setDouble(2, node.getLatitude());
                st.setDouble(3, node.getLongitude());
                st.setInt(4, netID);
                ret = st.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } finally {
            close(con);
        }

        return ret;
    }

}
