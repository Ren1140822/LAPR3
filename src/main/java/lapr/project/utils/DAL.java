package lapr.project.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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
import lapr.project.model.FlightPlan;
import lapr.project.model.Iten;
import lapr.project.model.Location;
import lapr.project.model.Motorization;
import lapr.project.model.Node;
import lapr.project.model.Pattern;
import lapr.project.model.Project;
import lapr.project.model.Segment;
import lapr.project.model.Thrust_Function;
import lapr.project.model.Wind;
import lapr.project.model.analysis.Simulation;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Flavio Relvas
 */
public class DAL {

    private static final String url = "jdbc:oracle:thin://@gandalf.dei.isep.ipp.pt:1521/pdborcl";
    private final String url2 = "jdbc:oracle:thin://@localhost:1521/pdborcl";
    private static final String user = "LAPR3_38";
    private static final String passw = "grupo38";
    private final String user2 = "orcl";
    private final String passw2 = "12345";

    public DAL() {
        //        Aircraft a = new Aircraft();
//        AircraftModel model = a.getAircraftModel();
//        List<AircraftModel> model2  = new LinkedList();
//        model2.add(model);
//        dal.WriteAircraftModelsToDatabase(model2,1);
//        List<Aircraft> list = new LinkedList();
//        list.add(a);
//       dal.WriteAircraftsToDatabase(list,1);
//       Airport ap = new Airport();
//       List<Airport> listAp = new LinkedList<>();
//       listAp.add(ap);
//       dal.WriteAirportsToDatabase(listAp,1);
        // List<Airport> listAp2 = dal.getListOfAirports("1");
//         List<Aircraft> listAc = dal.getListOfAircrafts("1");
//TEST
    }

    /**
     * Creates a connection to the database.
     *
     * @return the connection object
     */
    public Connection connect() {
        Connection con = null;
        try {

            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection(url, user, passw);
        } catch (SQLException e) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }

   

    /**
     * Closes all active database resources.
     *
     * @param rs result set
     * @param ps prepared statement
     * @param conn connection
     */
    public static void close(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

}
