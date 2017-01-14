package lapr.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
