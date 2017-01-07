package lapr.project.utils;

import java.sql.CallableStatement;
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
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.Iten;
import lapr.project.model.Location;
import lapr.project.model.Motorization;
import lapr.project.model.Node;
import lapr.project.model.Pattern;
import lapr.project.model.Segment;
import lapr.project.model.Thrust_Function;
import lapr.project.model.Wind;

/**
 *
 * @author Flavio Relvas
 */
public class DAL {

    private final String url = "jdbc:oracle:thin://@gandalf.dei.isep.ipp.pt:1521/pdborcl";
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
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
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

        List<Airport> airportList = new LinkedList<>();
        ResultSet rs = null;

        Connection con = null;
        String query = "getListOfAirports(?)";
        con = connect();

        try (CallableStatement st = con.prepareCall(query)) {
            st.setString("1", projectID);
            st.execute();
            rs = st.getResultSet();
            while (rs.next()) {
                //int locationID = rs.getInt("LocationID");
                String IATA = rs.getString("IATA");
                String name = rs.getString("Name");
                String country = rs.getString("Country");
                String town = rs.getString("Town");
                // Location location = getLocationByID(locationID);
                Airport airport = new Airport(IATA, name, town, country, new Location());
                if (airport.validate()) {
                    airportList.add(airport);
                }
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
    private Location getLocationByID(int locationID) {
        Location location = null;
        Connection con = null;

        ResultSet rs = null;
        String query = "placeholder query for location";
        con = connect();

        try (PreparedStatement st = con.prepareStatement(query)) {

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
            close(con);

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

        List<Aircraft> aircraftList = new LinkedList<>();
        ResultSet rs = null;

        Connection con = null;
        String query = "placeholder query for aircraftmodel";
        con = connect();

        try (PreparedStatement st = con.prepareStatement(query)) {

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
            close(con);

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

        ResultSet rs = null;
        Map<String, Integer> map = new HashMap<>();
        con = connect();
        String query = "placeholder query for cabin config";
        try (PreparedStatement st2 = con.prepareStatement(query)) {

            rs = st2.executeQuery();
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
     * @param aircraftModelD the aircraft model ID
     * @return the aircraft model object
     */
    private AircraftModel getAircraftModelByID(int aircraftModelD) {
        AircraftModel model = null;
        Connection con = null;

        ResultSet rs = null;
        List<Iten> itemList = new LinkedList<Iten>();
        List<Pattern> patternList = new LinkedList<Pattern>();
        String query = "placeholder query for aircraftmodel";
        con = connect();

        try (PreparedStatement st = con.prepareStatement(query)) {

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

                itemList = getItemByID(id);
                int patternID = rs.getInt("pattern");

                model = new AircraftModel(id, description, maker, type, motorization, eWeight, MTOW, maxPayload, fuelCapacity, VMO, MMO, wingArea, wingSpan, aspectRatio, e, itemList, getPatternByID(patternID));
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
        String query = "placeholder query for item";
        con = connect();
        try (PreparedStatement st = con.prepareStatement(query)) {

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
            close(con);
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

        ResultSet rs = null;
        String query = "placeholder query for item";
        con = connect();
        try (PreparedStatement st = con.prepareStatement(query)) {
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
            close(con);
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

        ResultSet rs = null;
        String query = "placeholder query for  thrust func";
        con = connect();
        try (PreparedStatement st = con.prepareStatement(query)) {

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
        String query = "placeholder query for  thrust func";
        con = connect();
        try (PreparedStatement st = con.prepareStatement(query)) {

            rs = st.executeQuery();
            while (rs.next()) {
                double thrustValue = rs.getDouble("thrust");
                double thrustMaxSpeed = rs.getDouble("thrustMaxSpeed");
                double maxSpeed = rs.getDouble("maxSpeed");
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
     * Gets the air network by project ID.
     *
     * @param projectID the id of the project
     * @return the air network
     */
    public AirNetwork getAirNetwork(String projectID) {

        AirNetwork airNetwork = new AirNetwork();
        ResultSet rs = null;

        Connection con = null;
        String query = "placeholder query";
        con = connect();

        try (PreparedStatement st = con.prepareStatement(query)) {

            rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String description = rs.getString("description");
                List<Node> nodes = getNodesListByID(id);
                List<Segment> segments = getSegmentsListByID(id, nodes);
                airNetwork.setId(id);
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
    private List<Node> getNodesListByID(String airNetworkID) {

        List<Node> nodes = new LinkedList<Node>();
        ResultSet rs = null;
        Connection con = null;
        String query = "placeholder query (airnetworkID)";
        con = connect();

        try (PreparedStatement st = con.prepareStatement(query)) {

            rs = st.executeQuery();
            while (rs.next()) {
                String nodeID = rs.getString("ID");
                double latitude = rs.getDouble("Latitude");
                double longitude = rs.getDouble("Longitude");
                Node n = new Node(url, latitude, longitude);
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
    private List<Segment> getSegmentsListByID(String airNetworkID, List<Node> nodes) {

        List<Segment> segments = new LinkedList<Segment>();
        ResultSet rs = null;

        Connection con = null;
        String query = "placeholder query (airnetworkID)";
        con = connect();
        try (PreparedStatement st = con.prepareStatement(query)) {

            rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String startNode = rs.getString("startNode");
                String endNode = rs.getString("endNode");
                Node realStartNode=null;
                Node realEndNode=null;
                for (Node n : nodes) {
                    if (startNode.equals(n.getId())) {
                        realStartNode=n;
                    }
                    if (endNode.equals(n.getId())) {
                            realEndNode=n;
                    }
                }               
                String direction = rs.getString("direction");
                Wind wind = getWindByID(id);
                int minAltSlot = rs.getInt("minAltSlot");
                int maxAltSlot = rs.getInt("maxAltSlot");
//                Segment segment = new Segment(id, startNode, endNode, direction, wind, minAltSlot, maxAltSlot);
//                segments.add(segment);
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
    private Wind getWindByID(String segmentID) {

        Wind wind = null;
        ResultSet rs = null;

        Connection con = null;
        String query = "placeholder query (segmentID)";
        con = connect();
        try (PreparedStatement st = con.prepareStatement(query)) {

            rs = st.executeQuery();
            while (rs.next()) {

                double intensity = rs.getDouble("windIntensity");
                double direction = rs.getDouble("windDirection");
                wind = new Wind(intensity, direction);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);

        }
        return wind;
    }

    public boolean WriteAircraftsToDatabase(List<Aircraft> aircraftList) {
        Connection con = null;
        con = connect();
        boolean ret = false;

        for (Aircraft aircraft : aircraftList) {
            try (CallableStatement st = con.prepareCall("insert_aircraft(?,?,?,?)")) {

                st.setString("1", aircraft.getRegistration());

                st.setString("2", aircraft.getCompany());
                st.setString("3", aircraft.getAircraftModel().getId());
                st.setInt("4", aircraft.getNrOfCrewElements());
                ret = st.execute();
                try (CallableStatement st2 = con.prepareCall("insert_cabin_config(?,?,?)")) {
                    for (String className : aircraft.getCabinConfig().getMapOfClasses().keySet()) {
                        st2.setString("1", aircraft.getRegistration());//cabin config pk
                        st2.setString("2", className);
                        st2.setInt("3", aircraft.getCabinConfig().getMapOfClasses().get(className).intValue());
                        ret = st2.execute();
                    }
                }
                try (CallableStatement st2 = con.prepareCall("insert_aircraft_model(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
                    st2.setString("1", aircraft.getAircraftModel().getId());//id
                    st2.setString("2", aircraft.getAircraftModel().getType());
                    st2.setString("3", aircraft.getAircraftModel().getDescription());
                    st2.setString("4", aircraft.getAircraftModel().getMaker());
                    st2.setDouble("5", aircraft.getAircraftModel().geteWeight());
                    st2.setDouble("6", aircraft.getAircraftModel().getMTOW());
                    st2.setDouble("7", aircraft.getAircraftModel().getMaxPayload());
                    st2.setDouble("8", aircraft.getAircraftModel().getFuelCapacity());
                    st2.setDouble("9", aircraft.getAircraftModel().getVMO());
                    st2.setDouble("10", aircraft.getAircraftModel().getMMO());
                    st2.setDouble("11", aircraft.getAircraftModel().getWingArea());
                    st2.setDouble("12", aircraft.getAircraftModel().getWingSpan());
                    st2.setDouble("13", aircraft.getAircraftModel().getAspectRatio());
                    st2.setDouble("14", aircraft.getAircraftModel().getE());
                    st2.setInt("15", aircraft.getAircraftModel().getMotorization().getNumberMotors());
                    st2.setString("16", aircraft.getAircraftModel().getMotorization().getMotor());
                    st2.setString("17", aircraft.getAircraftModel().getMotorization().getMotorType());
                    st2.setDouble("18", aircraft.getAircraftModel().getMotorization().getCruise_altitude());
                    st2.setDouble("19", aircraft.getAircraftModel().getMotorization().getCruise_speed());
                    st2.setDouble("20", aircraft.getAircraftModel().getMotorization().getTSFC());
                    st2.setDouble("21", aircraft.getAircraftModel().getMotorization().getLapse_rate_factor());
                    st2.setDouble("22", aircraft.getAircraftModel().getMotorization().getThrust_function().getThrust_0());
                    st2.setDouble("23", aircraft.getAircraftModel().getMotorization().getThrust_function().getThrustMaxSpeed());
                    st2.setDouble("24", aircraft.getAircraftModel().getMotorization().getThrust_function().getMaxSpeed());

                    ret = st2.execute();

                }

            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            } finally {
                close(con);
            }
        }
        return true;
    }

    public boolean WriteAirportsToDatabase(List<Airport> airportList) {
        Connection con = null;
        con = connect();
        boolean ret = false;

        for (Airport airport : airportList) {
            try (CallableStatement st = con.prepareCall("insert_airport(?,?,?,?,?,?)")) {

                st.setString("1", airport.getIATA());

                st.setString("2", airport.getName());
                st.setString("3", airport.getTown());
                st.setDouble("4", airport.getLocation().getLatitude());
                st.setDouble("5", airport.getLocation().getLongitude());
                st.setDouble("6", airport.getLocation().getAltitude());

                ret = st.execute();

            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            } finally {
                close(con);
            }
        }
        return true;
    }

    public boolean WriteNodesToDatabase(List<Node> nodeList) {
        Connection con = null;
        con = connect();
        boolean ret = false;

        for (Node node:nodeList) {
            try (CallableStatement st = con.prepareCall("insert_node(?,?,?)")) {
                 st.setString("1", node.getId());
                st.setDouble("2", node.getLatitude());
                st.setDouble("3", node.getLongitude());
                ret = st.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.toString());
            } finally {
                close(con);
            }
        }
        return true;
    }

    /**
     * Closes all active database resources.
     *
     * @param rs result set
     * @param ps prepared statement
     * @param conn connection
     */
    private static void close(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

}
