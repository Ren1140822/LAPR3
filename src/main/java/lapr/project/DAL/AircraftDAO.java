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
import lapr.project.model.AircraftModel;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.Iten;
import lapr.project.model.Motorization;
import lapr.project.model.Pattern;
import lapr.project.model.Thrust_Function;
import lapr.project.utils.DAL;
import static lapr.project.utils.DAL.close;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AircraftDAO {
 DAL dal;
    public AircraftDAO() {
          dal = new DAL();
    }

    /**
     * Gets the list of aircrafts by project ID.
     *
     * @param projectID the id of the project
     * @return the list of aircrafts
     */
    public List<Aircraft> getListOfAircrafts(String projectID) {

        List<Aircraft> aircraftList = new LinkedList<>();
        ResultSet rs = null;

        Connection con = null;
        String query = "{ ?= call get_aircrafts(?)}";
       con = dal.connect();

        try (CallableStatement st = con.prepareCall(query)) {
            st.setString(2, projectID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                String registration = rs.getString("Registration");
                String company = rs.getString("Company");
                CabinConfiguration cabinConfig = getCabinConfigByID(rs.getString("registration"));
                int nrOfCrewElements = rs.getInt("nrofcrewelements");
                AircraftModel aircraftModel = getAircraftModelByID(rs.getString("aircraft_modelID"));
                Aircraft aircraft = new Aircraft(registration, company, cabinConfig, nrOfCrewElements, aircraftModel);
                if (aircraft.validate()) {
                    aircraftList.add(aircraft);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAL.close(con);

        }
        return aircraftList;
    }

    /**
     * Gets a cabin configuration by ID.
     *
     * @param cabinConfigID the cabin config ID
     * @return the cabin config object
     */
    private CabinConfiguration getCabinConfigByID(String aircraftID) {
        CabinConfiguration config = null;
        Connection con = null;

        ResultSet rs = null;
        Map<String, Integer> map = new HashMap<>();
       con = dal.connect();
        String query = "{ ?= call get_cabins(?)}";
        try (CallableStatement st2 = con.prepareCall(query)) {
            st2.setString(2, aircraftID);
            st2.registerOutParameter(1, OracleTypes.CURSOR);
            st2.execute();
            rs = (ResultSet) st2.getObject(1);
            while (rs.next()) {
                String className = rs.getString("class"); //going to have multiple results from the same cabin configuration
                int classSeats = rs.getInt("nr_passengers");
                map.put(className, classSeats);

            }
            config = new CabinConfiguration(map);
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return config;
    }

    /**
     * Gets the aircraftModel by ID.
     *
     * @param aircraftModelD the aircraftModel model ID
     * @return the aircraftModel model object
     */
    private AircraftModel getAircraftModelByID(String aircraftModelD) {
        AircraftModel model = null;
        Connection con = null;

        ResultSet rs = null;
        List<Iten> itemList = new LinkedList<Iten>();
        List<Pattern> patternList = new LinkedList<Pattern>();
        String query = "{?= call get_aircraft_model(?)}";
       con = dal.connect();

        try (CallableStatement st = con.prepareCall(query)) {
            st.setString(2, aircraftModelD);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);

            while (rs.next()) {
                String id = rs.getString("id");
                String description = rs.getString("description");
                String maker = rs.getString("maker");
                String type = rs.getString("type");
                int motorizationID = rs.getInt("motorizationid");
                Motorization motorization = getMotorizationByID(motorizationID);
                double eWeight = rs.getDouble("eWeight");
                double MTOW = rs.getDouble("MTOW");
                double maxPayload = rs.getDouble("maxpayload");
                double VMO = rs.getDouble("VMO");
                double MMO = rs.getDouble("MMO");
                double fuelCapacity = rs.getDouble("fuelCapacity");
                double aspectRatio = rs.getDouble("aspect_rate");
                double wingArea = rs.getDouble("wingArea");
                double wingSpan = rs.getDouble("wingSpan");
                double e = rs.getDouble("e");

                itemList = getItemByID(id);
                //int patternID = rs.getInt("pattern");

                model = new AircraftModel(id, description, maker, type, motorization, eWeight, MTOW, maxPayload, fuelCapacity, VMO, MMO, wingArea, wingSpan, aspectRatio, e, itemList);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);

        }
        return model;
    }
    
    
       /**
     * Gets the item by ID.
     *
     * @param itemID the item id
     * @return the item object
     */
    private List<Iten> getItemByID(String aircraftModelID) {
        Iten item = null;
        List<Iten> itemList = new LinkedList<>();
        Connection con = null;
        ResultSet rs = null;
        String query = "{?= call get_itens(?)}";
       con = dal.connect();
        try (CallableStatement st = con.prepareCall(query)) {
            st.setString(2, aircraftModelID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);

            while (rs.next()) {
                double speed = rs.getDouble("speed");
                double Cdrag = rs.getDouble("cDrag_0");
                item = new Iten(speed, Cdrag);
                itemList.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return itemList;
    }
    
    
      /**
     * Gets the motorization by ID.
     *
     * @param motorizationConfigID the motorization id
     * @return the motorization object
     */
    private Motorization getMotorizationByID(int motorizationConfigID) {
        Motorization motorization = null;
        Connection con = null;

        ResultSet rs = null;
        String query = "{?= call get_motorization(?)}";
       con = dal.connect();
        try (CallableStatement st = con.prepareCall(query)) {
            st.setInt(2, motorizationConfigID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                int numberMotors = rs.getInt("number_motors");
                String motor = rs.getString("motor");
                String motorType = rs.getString("motor_Type");
                double cruise_altitude = rs.getDouble("cruise_altitude");
                double cruise_speed = rs.getDouble("cruise_Speed");
                double TSFC = rs.getDouble("TSFC");
                double lapse_rate_factor = rs.getDouble("lapse_Rate_Factor");
                int thrust_functionID = rs.getInt("thrustID");
                Thrust_Function thrust_func = getThrustFunctionByID(thrust_functionID);
                motorization = new Motorization(numberMotors, motor, motorType, cruise_altitude, cruise_speed, TSFC, lapse_rate_factor, thrust_func);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return motorization;
    }

    
        /**
     * Gets thrust function by ID.
     *
     * @param thrustFunctionID the thrust function id
     * @return the thrust function
     */
    private Thrust_Function getThrustFunctionByID(int thrustFunctionID) {
        Thrust_Function thrust = null;
        Connection con = null;

        ResultSet rs = null;
        String query = "{?= call get_thrust(?)}";
       con = dal.connect();
        try (CallableStatement st = con.prepareCall(query)) {
            st.setInt(2, thrustFunctionID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                double thrustValue = rs.getDouble("thrust_0");
                double thrustMaxSpeed = rs.getDouble("thrust_Max_Speed");
                double maxSpeed = rs.getDouble("max_Speed");
                thrust = new Thrust_Function(thrustValue, thrustMaxSpeed, maxSpeed);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return thrust;
    }
    
     public boolean WriteAircraftsToDatabase(List<Aircraft> aircraftList, int projectID) throws SQLException {
        Connection con = null;
       con = dal.connect();
        boolean ret = false;

        for (Aircraft aircraft : aircraftList) {

            try (CallableStatement st = con.prepareCall("{call insert_aircraft(?,?,?,?,?)}")) {
                st.setInt(1, projectID);
                st.setString(2, aircraft.getRegistration());

                st.setString(3, aircraft.getCompany());
                st.setString(4, aircraft.getAircraftModel().getId());
                st.setInt(5, aircraft.getNrOfCrewElements());

                ret = st.execute();

                try (CallableStatement st2 = con.prepareCall("{call insert_cabin_config(?,?,?)}")) {
                    for (String className : aircraft.getCabinConfig().getMapOfClasses().keySet()) {
                        st2.setString(1, aircraft.getRegistration());//cabin config pk
                        st2.setString(2, className);
                        st2.setInt(3, aircraft.getCabinConfig().getMapOfClasses().get(className).intValue());
                        ret = st2.execute();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            } finally {

                close(con);
            }
        }
        return ret;
    }
    
}
