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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.Aircraft;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.FlightPlan;
import lapr.project.model.Location;
import lapr.project.model.Location;
import lapr.project.model.Node;
import lapr.project.model.Node;
import lapr.project.model.Pattern;
import lapr.project.model.Pattern;
import lapr.project.utils.DAL;
import static lapr.project.utils.DAL.close;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class FlightDAO {

    DAL dal;

    public FlightDAO() {
        dal = new DAL();
    }
    
    public List<FlightPlan> getFlightPlanList(int projectlD) {
        List<FlightPlan> planList = new LinkedList<>();
        FlightPlan plan = null;
        Connection con = null;
        
        ResultSet rs = null;
        
        String query = "{?= call get_flightplans(?)}";
        con = dal.connect();
        
        try (CallableStatement st = con.prepareCall(query)) {
            st.setInt(2, projectlD);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            
            while (rs.next()) {
                String designator = rs.getString("flightdesignator");
                int minStopTime = rs.getInt("minstoptime");
                Airport origin = getAirportByID(rs.getInt("origin"));
                Airport dest = getAirportByID(rs.getInt("destination"));
                LinkedList<Airport> stops = getStopsList(designator);
                LinkedList<Node> waypoints = getWaypointsList(designator);
                LinkedList<Pattern> patterns = getPatternByID(designator);
                plan = new FlightPlan(designator, minStopTime, new Aircraft(), origin, dest, stops, waypoints, patterns);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
            
        }
        return planList;
    }
    
    public LinkedList<Airport> getStopsList(String fpID) {
        LinkedList<Airport> airportList = new LinkedList<Airport>();
        FlightPlan plan = null;
        Connection con = null;
        
        ResultSet rs = null;
        
        String query = "{?= call get_technicalstops(?)}";
        con = dal.connect();
        
        try (CallableStatement st = con.prepareCall(query)) {
            st.setString(2, fpID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            
            while (rs.next()) {
                int AirportID = rs.getInt("Airportid");
                Airport airport = getAirportByID(AirportID);
                
                airportList.add(airport);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
            
        }
        return airportList;
    }
    
    public LinkedList<Node> getWaypointsList(String fpID) {
        LinkedList<Node> nodes = new LinkedList<>();
        FlightPlan plan = null;
        Connection con = null;
        
        ResultSet rs = null;
        
        String query = "{?= call get_mandatorywaypoints(?)}";
        con = dal.connect();
        
        try (CallableStatement st = con.prepareCall(query)) {
            st.setString(2, fpID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            
            while (rs.next()) {
                String nodeID = rs.getString("ID");
                Node n = getNodeByID(nodeID);
                nodes.add(n);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
            
        }
        return nodes;
    }

     private Node getNodeByID(String nodeID) {
        Node node = null;
        Connection con = null;

        ResultSet rs = null;
        String query = "{?= call get_node(?)}";
        con=dal.connect();
        try (CallableStatement st = con.prepareCall(query)) {
            st.setString(2, nodeID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                double lat = rs.getDouble("latitude");
                double longitude = rs.getDouble("longitude");
                String id = rs.getString("id");
                node = new Node(id, longitude, longitude);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return node;
    }
    
    
    /**
     * Gets the pattern by ID.
     *
     * @param patternID the pattern id
     * @return the pattern object
     */
    private LinkedList<Pattern> getPatternByID(String flightDesignator) {
        Pattern pattern = null;
        LinkedList<Pattern> patternList = new LinkedList<>();
        Connection con = null;
        
        ResultSet rs = null;
        String query = "{?= call get_patterns(?)}";
        con = dal.connect();
        try (CallableStatement st = con.prepareCall(query)) {
            st.setString(2, flightDesignator);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                
                double altitude = rs.getDouble("altitude");
                double vClimb = rs.getDouble("vClimb");
                double vDesc = rs.getDouble("vDesc");
                pattern = new Pattern(altitude, vClimb, vDesc);
                patternList.add(pattern);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return patternList;
    }
    
    private Airport getAirportByID(int airportID) {
        Airport ap = null;
        Connection con = null;
        
        ResultSet rs = null;
        Map<String, Integer> map = new HashMap<>();
        con = dal.connect();
        String query = "{ ?= call get_airport(?)}";
        try (CallableStatement st2 = con.prepareCall(query)) {
            st2.setInt(2, airportID);
            st2.registerOutParameter(1, OracleTypes.CURSOR);
            st2.execute();
            rs = (ResultSet) st2.getObject(1);
            while (rs.next()) {
                int locationID = rs.getInt("LocationID");
                String IATA = rs.getString("IATA");
                String name = rs.getString("Name");
                String country = rs.getString("Country");
                String town = rs.getString("Town");
                
                Location location = getLocationByID(con, locationID);
                ap = new Airport(IATA, name, town, country, location);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ap;
    }

    /**
     * Gets location by id.
     *
     * @param locationID the location ID
     * @return the location object
     */
    private Location getLocationByID(Connection con, int locationID) {
        Location location = null;
        
        ResultSet rs = null;
        String query = "{ ?= call get_location(?)}";
        con = dal.connect();
        
        try (CallableStatement st = con.prepareCall(query)) {
            st.setInt(2, locationID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            
            while (rs.next()) {
                double latitude = rs.getDouble("Latitude");
                double longitude = rs.getDouble("Longitude");
                double altitude = rs.getDouble("Altitude");
                location = new Location(latitude, longitude, locationID);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
            
        }
        return location;
    }
    
    public boolean WriteFlightPlansToDatabase(List<FlightPlan> plans, int projectID) {
        Connection con = null;
        con = dal.connect();
        boolean ret = false;
        
        try (CallableStatement st = con.prepareCall("{call insert_flightplan(?,?,?,?,?,?)}")) {
            for (FlightPlan plan : plans) {
                
                st.setInt(1, projectID);
                st.setString(2, plan.getFlightDesignator());
                st.setInt(3, plan.getMinStopTime());
                st.setString(4, plan.getOrigin().getIATA());
                st.setString(5, plan.getDestination().getIATA());
                st.setString(6, plan.getAircraft().getRegistration());
                ret = st.execute();
                WriteStopsToDatabase(plan.getTechnicalStops(), plan.getFlightDesignator());
                WritePatternsToDatabase(con, plan.getListPattern(), plan.getFlightDesignator());
                WriteWaypointsToDatabase(plan.getMandatoryWaypoints(), plan.getFlightDesignator());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } finally {
            close(con);
        }
        return true;
    }
    
    public boolean WriteStopsToDatabase(List<Airport> stops, String fpID) {
        Connection con = null;
        con = dal.connect();
        boolean ret = false;
        
        try (CallableStatement st = con.prepareCall("{call insert_stops(?,?)}")) {
            for (Airport ap : stops) {
                st.setString(1, fpID);
                st.setString(2, ap.getIATA());
                
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
    
    public boolean WriteWaypointsToDatabase(List<Node> nodes, String fpID) {
        Connection con = null;
        con = dal.connect();
        boolean ret = false;
        
        try (CallableStatement st = con.prepareCall("{call insert_waypoint(?,?)}")) {
            for (Node n : nodes) {
                st.setString(1, fpID);
                st.setString(2, n.getId());
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
    
    private boolean WritePatternsToDatabase(Connection con, List<Pattern> plist, String fpid) {
        
        boolean ret = false;
        for (Pattern p : plist) {
            try (CallableStatement st = con.prepareCall("{call insert_pattern(?,?,?,?)}")) {
                st.setDouble(1, p.getAltitude());
                st.setDouble(2, p.getvClimb());
                st.setDouble(3, p.getvDesc());
                st.setString(4, fpid);
                ret = st.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            }
        }
        return ret;
    }
}
