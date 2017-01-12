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
import lapr.project.model.Airport;
import lapr.project.model.Airport;
import lapr.project.model.Location;
import lapr.project.model.Location;
import lapr.project.utils.DAL;
import static lapr.project.utils.DAL.close;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AirportDAO {
 DAL dal;
    public AirportDAO() {
          dal = new DAL();
    }

    /**
     * Gets the list of airports by project ID.
     *
     * @param projectID the id of the project
     * @return the list of airports
     */
    public List<Airport> getListOfAirports(String projectID) {

        List<Airport> airportList = new LinkedList<>();
        ResultSet rs = null;

        Connection con = null;
        String query = "{ ? =call get_airports(?)}";
       con = dal.connect();

        try (CallableStatement st = con.prepareCall(query)) {

            st.setString(2, projectID);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.executeQuery();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                int locationID = rs.getInt("LocationID");
                String IATA = rs.getString("IATA");
                String name = rs.getString("Name");
                String country = rs.getString("Country");
                String town = rs.getString("Town");
                Location location = getLocationByID(con, locationID);
                Airport airport = new Airport(IATA, name, town, country, location);
                airportList.add(airport);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return airportList;
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

    public boolean WriteAirportsToDatabase(List<Airport> airportList, int projectID) {
        Connection con = null;
       con = dal.connect();
        boolean ret = false;

        try (CallableStatement st = con.prepareCall("{call insert_airport(?,?,?,?,?,?,?,?)}")) {
            for (Airport airport : airportList) {
                st.setInt(1, projectID);
                st.setString(2, airport.getIATA());
                st.setString(3, airport.getName());
                st.setString(4, airport.getTown());
                st.setString(5, airport.getCountry());
                st.setDouble(6, airport.getLocation().getLatitude());
                st.setDouble(7, airport.getLocation().getLongitude());
                st.setDouble(8, airport.getLocation().getAltitude());
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
