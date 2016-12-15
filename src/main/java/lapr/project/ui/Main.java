package lapr.project.ui;

import java.util.logging.Logger;
import lapr.project.utils.CSVExporter;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = Logger.getLogger("MainLog");

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
    public static void main(String[] args) {
        String s[] = new String[3];
        s[0] = "result1";
        s[1] = "result2";
        s[2] = "result3";
        try {
            CSVExporter.exportStringsToCSV("title", "heading1", "heading2", s, "D:\\html.txt");
        } catch (Exception ex) {

        }

    }
}
