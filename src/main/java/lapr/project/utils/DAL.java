package lapr.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Flavio Relvas
 */
public class DAL {

    private Connection con;
    private final String url = "jdbc:oracle:thin:@gandalf.dei.isep.ipp.pt:1521/pdborcl";
    private final String user = "LAPR3_38";
    private final String password = "grupo38";

    /*
     try{
     con = DriverManager.getConnection(url,user,pass);
     }catch (SQLException e){
     System.err.printf(e);
     }*/
    
    
    public static void getListOfAirports(int projectID)
    {
        
    }
}
