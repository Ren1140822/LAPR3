package lapr.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.Iten;
import lapr.project.model.Location;
import lapr.project.model.Motorization;
import lapr.project.model.Pattern;
import lapr.project.model.Thrust_Function;

/**
 *
 * @author Flavio Relvas
 */
public class DAL {

    private final String url = "jdbc:oracle:thin:@gandalf.dei.isep.ipp.pt:1521/pdborcl";
    private final String user = "LAPR3_38";
    private final String passw = "grupo38";

    /**
     * Creates a connection to the database.
     *
     * @return the connection object
     */
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passw);
        } catch (SQLException e) {
              Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, e);
        }
        return conn;
    }

    /**
     * Gets the list of airports by project ID.
     *
     * @param projectID the id of the project
     * @return the list of airports
     */
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

    /**
     * Gets location by id.
     *
     * @param locationID the location ID
     * @return the location object
     */
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

    /**
     * Gets the list of aircrafts by project ID.
     *
     * @param projectID the id of the project
     * @return the list of aircrafts
     */
    public List<Aircraft> getListOfAircrafts(String projectID) {
        PreparedStatement st = null;
        List<Aircraft> aircraftList = new LinkedList<>();
        ResultSet rs = null;

        Connection con = null;
        try {

            String query = "placeholder query";
            con = connect();
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                String registration = rs.getString("Registration");
                String company = rs.getString("Company");
                CabinConfiguration cabinConfig = getCabinConfigByID(rs.getInt("cabinID"));
                int nrOfCrewElements = rs.getInt("number_elements");
                AircraftModel aircraftModel = getAircraftModelByID(rs.getInt("aircraftModelID"));
                Aircraft aircraft = new Aircraft(registration, company, cabinConfig, nrOfCrewElements, aircraftModel);
                if (aircraft.validate()) {
                    aircraftList.add(aircraft);
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
        return aircraftList;
    }

    /**
     * Gets a cabin configuration by ID.
     *
     * @param cabinConfigID the cabin config ID
     * @return the cabin config object
     */
    private CabinConfiguration getCabinConfigByID(int cabinConfigID) {
        CabinConfiguration config = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Map<String, Integer> map = new HashMap<>();
        try {

            String query = "placeholder query for cabin config";
            con = connect();
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                String className = rs.getString("class_name"); //going to have multiple results from the same cabin configuration
                int classSeats = rs.getInt("class_seats");
                map.put(className, classSeats);

            }
            config = new CabinConfiguration(map);
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
        return config;
    }

    /**
     * Gets the aircraftModel by ID.
     *
     * @param aircraftModelD the aircraft model ID
     * @return the aircraft model object
     */
    private AircraftModel getAircraftModelByID(int aircraftModelD) {
        AircraftModel model = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Iten> itemList = new LinkedList<Iten>();
        List<Pattern> patternList = new LinkedList<Pattern>();

        try {
            String query = "placeholder query for aircraftmodel";
            con = connect();
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String description = rs.getString("description");
                String maker = rs.getString("maker");
                String type = rs.getString("type");
                int motorizationID = rs.getInt("motorization");
                Motorization motorization = getMotorizationByID(motorizationID);
                double eWeight = rs.getDouble("eWeight");
                double MTOW = rs.getDouble("MTOW");
                double maxPayload = rs.getDouble("maxTakeOffWeight");
                double VMO = rs.getDouble("VMO");
                double MMO = rs.getDouble("MMO");
                double fuelCapacity = rs.getDouble("fuelCapacity");
                double aspectRatio = rs.getDouble("aspectRatio");
                double wingArea = rs.getDouble("wingArea");
                double wingSpan = rs.getDouble("wingSpan");
                double e = rs.getDouble("e");
                int itemID = rs.getInt("item");
                itemList = getItemByID(itemID);
                int patternID = rs.getInt("pattern");

                model = new AircraftModel(id, description, maker, type, motorization, eWeight, MTOW, maxPayload, fuelCapacity, VMO, MMO, wingArea, wingSpan, aspectRatio, e, itemList, getPatternByID(patternID));
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
        return model;
    }

    /**
     * Gets the item by ID.
     *
     * @param itemID the item id
     * @return the item object
     */
    private List<Iten> getItemByID(int itemID) {
        Iten item = null;
        List<Iten> itemList = new LinkedList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String query = "placeholder query for item";
            con = connect();
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                double speed = rs.getDouble("speed");
                double Cdrag = rs.getDouble("cDrag");
                item = new Iten(speed, Cdrag);
                itemList.add(item);
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
        return itemList;
    }

    /**
     * Gets the pattern by ID.
     *
     * @param patternID the pattern id
     * @return the pattern object
     */
    private List<Pattern> getPatternByID(int patternID) {
        Pattern pattern = null;
        List<Pattern> patternList = new LinkedList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String query = "placeholder query for item";
            con = connect();
            st = con.prepareStatement(query);
            rs = st.executeQuery();
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
        return patternList;
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
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            String query = "placeholder query for motorizaton";
            con = connect();
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                int numberMotors = rs.getInt("numberMotors");
                String motor = rs.getString("motor");

                String motorType = rs.getString("motorType");
                double cruise_altitude = rs.getDouble("speed");
                double cruise_speed = rs.getDouble("cruiseSpeed");
                double TSFC = rs.getDouble("TSFC");
                double lapse_rate_factor = rs.getDouble("lapseRateFactor");
                int thrust_functionID = rs.getInt("thrustFunction");
                Thrust_Function thrust_func = getThrustFunctionByID(thrust_functionID);
                motorization = new Motorization(numberMotors, motor, motorType, cruise_altitude, cruise_speed, TSFC, lapse_rate_factor, thrust_func);
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
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            String query = "placeholder query for  thrust func";
            con = connect();
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                int numberMotors = rs.getInt("numberMotors");
                String motor = rs.getString("motor");
                String motorType = rs.getString("motorType");
                double cruise_altitude = rs.getDouble("speed");
                double cruise_speed = rs.getDouble("cruiseSpeed");
                double TSFC = rs.getDouble("TSFC");
                double lapse_rate_factor = rs.getDouble("lapseRateFactor");
                int thrust_functionID = rs.getInt("thrustFunction");
                Thrust_Function thrust_func;
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
        return thrust;
    }

}
