package lapr.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.Airport;
import lapr.project.model.Location;

/**
 *
 * @author Flavio Relvas
 */
public class DAL {

    private final String url = "jdbc:oracle:thin:@gandalf.dei.isep.ipp.pt:1521/pdborcl";
    private final String user = "LAPR3_38";
    private final String passw = "grupo38";

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passw);
        } catch (SQLException e) {
            System.err.printf(e.toString());
        }
        return conn;
    }

    /*
     try{
     con = DriverManager.getConnection(url,user,pass);
     }catch (SQLException e){
     System.err.printf(e);
     }*/
    public List<Airport> getListOfAirports(String projectID) {
        PreparedStatement st = null;
        List<Airport> airportList = new LinkedList<>();
        ResultSet rs = null;

        Connection con = null;
        try {

            String query = "placeholder query";
            con = connect();
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                int locationID = rs.getInt("LocationID");
                String IATA = rs.getString("IATA");
                String name = rs.getString("Name");
                String country = rs.getString("Country");
                String town = rs.getString("Town");
                Location location = getLocationByID(locationID);
                Airport airport = new Airport(IATA, name, town, country, location);
                if (airport.validate()) {
                    airportList.add(airport);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return airportList;
    }

    private Location getLocationByID(int locationID) {
        Location location = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            String query = "placeholder query for location";
            con = connect();
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                double latitude = rs.getDouble("Latitude");
                double longitude = rs.getDouble("Longitude");
                double altitude = rs.getDouble("Altitude");
                location = new Location(latitude, longitude, locationID);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return location;
    }
}
