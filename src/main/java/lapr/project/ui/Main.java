package lapr.project.ui;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import lapr.project.controller.DALController;
import lapr.project.model.Project;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, SQLException {
       MenuUI ui = new MenuUI();
//        DALController dalc = new DALController();
//        dalc.test(1);
    }
}
