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
import lapr.project.model.AircraftModel;
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
public class AircraftModelDAO {

    DAL dal;

    public AircraftModelDAO() {
        dal = new DAL();
    }

    /**
     * Gets the aircraftModel by ID.
     *
     * @param aircraftModelD the aircraftModel model ID
     * @return the aircraftModel model object
     */
    public List<AircraftModel> getAircraftModelList(int projectlD) {
        List<AircraftModel> modelList = new LinkedList<>();
        AircraftModel model = null;
        Connection con = null;

        ResultSet rs = null;
        List<Iten> itemList = new LinkedList<Iten>();
        List<Pattern> patternList = new LinkedList<Pattern>();
        String query = "{?= call get_aircraft_models(?)}";
        con = dal.connect();

        try (CallableStatement st = con.prepareCall(query)) {
            st.setInt(2, projectlD);
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
                modelList.add(model);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);

        }
        return modelList;
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

    public boolean WriteAircraftModelsToDatabase(List<AircraftModel> aircraftModelList, int projectID) {
        Connection con = null;
        con = dal.connect();

        boolean ret = false;

        try (CallableStatement st2 = con.prepareCall("{call insert_aircraft_model(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}")) {
            for (AircraftModel aircraftModel : aircraftModelList) {
                st2.setString(1, aircraftModel.getId());//id
                st2.setString(2, aircraftModel.getType());
                st2.setString(3, aircraftModel.getDescription());
                st2.setString(4, aircraftModel.getMaker());
                st2.setDouble(5, aircraftModel.geteWeight());
                st2.setDouble(6, aircraftModel.getMTOW());
                st2.setDouble(7, aircraftModel.getMaxPayload());
                st2.setDouble(8, aircraftModel.getFuelCapacity());
                st2.setDouble(9, aircraftModel.getVMO());
                st2.setDouble(10, aircraftModel.getMMO());
                st2.setDouble(11, aircraftModel.getWingArea());
                st2.setDouble(12, aircraftModel.getWingSpan());
                st2.setDouble(13, aircraftModel.getAspectRatio());
                st2.setDouble(14, aircraftModel.getE());
                st2.setInt(15, aircraftModel.getMotorization().getNumberMotors());
                st2.setString(16, aircraftModel.getMotorization().getMotor());
                st2.setString(17, aircraftModel.getMotorization().getMotorType());
                st2.setDouble(18, aircraftModel.getMotorization().getCruise_altitude());
                st2.setDouble(19, aircraftModel.getMotorization().getCruise_speed());
                st2.setDouble(20, aircraftModel.getMotorization().getTSFC());
                st2.setDouble(21, aircraftModel.getMotorization().getLapse_rate_factor());
                st2.setDouble(22, aircraftModel.getMotorization().getThrust_function().getThrust_0());
                st2.setDouble(23, aircraftModel.getMotorization().getThrust_function().getThrustMaxSpeed());
                st2.setDouble(24, aircraftModel.getMotorization().getThrust_function().getMaxSpeed());
                st2.setInt(25, projectID);
                ret = st2.execute();
                WriteItensToDatabase(con, aircraftModel.getListIten(), aircraftModel.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } finally {
            close(con);
        }

        return ret;
    }

    private boolean WriteItensToDatabase(Connection con, List<Iten> itenList, String modelid) {

        boolean ret = false;

        try (CallableStatement st = con.prepareCall("{call insert_iten(?,?,?)}")) {
            for (Iten item : itenList) {
                st.setDouble(1, item.getCdrag_0());
                st.setDouble(2, item.getSpeed());
                st.setString(3, modelid);
                ret = st.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }

        return ret;
    }
}
