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
import lapr.project.model.analysis.DatabaseResult;
import lapr.project.model.analysis.SegmentResult;
import lapr.project.model.analysis.Simulation;
import lapr.project.utils.DAL;
import static lapr.project.utils.DAL.close;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ResultDAO {

    DAL dal;

    public ResultDAO() {
        this.dal = new DAL();
    }

 
    /**
     * Gets results from database
     * @param projectID the pid
     * @return the list of db results
     */
    public List<DatabaseResult> getSimulationsByID(int projectID) {
        List<DatabaseResult> dbList = new LinkedList<>();

        ResultSet rs = null;

        Connection con = null;
        String query = "{?= call get_results(?)}";
        con = dal.connect();

        try (CallableStatement st = con.prepareCall(query)) {
            st.setInt(2, projectID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                String ID = rs.getString("SEGMENTID");
                double TAS = rs.getDouble("TAS_0");
                double altitude_0 = rs.getDouble("ALTITUDE_0");
                //double TAS_end = rs.getDouble("TAS_END");
                double altitude_end = rs.getDouble("altitude_end");
                double consumedfuel = rs.getDouble("consumedfuel");
                DatabaseResult dbR = new DatabaseResult(ID, TAS, altitude_end, altitude_end, consumedfuel);
                dbList.add(dbR);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);

        }
        return dbList;
    }

    public boolean WriteResultsDatabase(int projectID, List<Simulation> simList) {
        Connection con = null;
        con = dal.connect();
        boolean ret = false;

        try (CallableStatement st = con.prepareCall("{call insert_result(?,?,?,?,?,?,?)}")) {
            st.setInt(1, projectID);

            for (Simulation sim : simList) {
                if (sim.getEcologicResultPath().getSegments().size()>0) {
                    for (SegmentResult s : sim.getEcologicResultPath().getSegments()) {
                        st.setString(2, s.getSegment().getId());
                        st.setDouble(3, s.getTas());
                        st.setDouble(4, s.getInitialAltitude());
                        st.setDouble(5, s.getTas());
                        st.setDouble(6, s.getAltitudeFinal());
                        st.setDouble(7, s.getEnergyConsume());
                        ret = st.execute();
                    }
                }
                if (sim.getShortestResultPath().getSegments().size()>0) {
                    for (SegmentResult s : sim.getShortestResultPath().getSegments()) {
                        st.setString(2, s.getSegment().getId());
                        st.setDouble(3, s.getTas());
                        st.setDouble(4, s.getInitialAltitude());
                        st.setDouble(5, s.getTas());
                        st.setDouble(6, s.getAltitudeFinal());
                        st.setDouble(7, s.getEnergyConsume());
                        ret = st.execute();
                    }
                }
                if (sim.getFastestResultPath().getSegments().size()>0) {
                    for (SegmentResult s : sim.getFastestResultPath().getSegments()) {
                        st.setString(2, s.getSegment().getId());
                        st.setDouble(3, s.getTas());
                        st.setDouble(4, s.getInitialAltitude());
                        st.setDouble(5, s.getTas());
                        st.setDouble(6, s.getAltitudeFinal());
                        st.setDouble(7, s.getEnergyConsume());
                        ret = st.execute();
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } finally {
            close(con);

        }
        return true;
    }
}
