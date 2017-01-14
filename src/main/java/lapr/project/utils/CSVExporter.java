/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class CSVExporter {

    /**
     * Exports Strings to html
     *
     * @param title the tab title on browser
     * @param heading1 the first title
     * @param heading2 the second title
     * @param body the body of the document
     * @param filePath the file path
     * @return true if exported
     */
    public static boolean exportStringsToCSV(String title, String heading1, String heading2, String[] body, String filePath) {
        String page;

        page = title + "\n\n" + heading1 + "\n\n" + heading2 + "\n\n";
        for (int i = 0; i < body.length; i++) {
            if (body[i] != null) {
                page += body[i] + "\n";
            }
        }
        System.out.println(page);
        Formatter out = null;
        try {
            out = new Formatter(new File(filePath));
        } catch (FileNotFoundException | NullPointerException ex) {
            if (out != null) {
                out.close();
            }
            System.err.print(ex);
            return false;

        }
        out.format("%s", page);
        out.close();
        return true;
    }

    /**
     * Exports Strings to csv
     *
     * @param title the tab title on browser
     * @param heading1 the first title
     * @param heading2 the second title
     * @param body the body of the document
     * @param filePath the file path
     * @return true if exported
     */
    public static boolean exportMultipleStringsToCSV(String title, String heading1, String heading2, String[][] body, String filePath) {

        String page;
        String data[] = new String[body[0].length];
        for (int i = 0; i < data.length; i++) {
            data[i] = "";
        }
        for (int i = 0; i < body[0].length; i++) {
            for (int j = 0; j < body.length; j++) {
                if (body[j][i] != null) {
                    data[i] += body[j][i] + "; ";
                }

            }
            data[i] += "\n";
        }
        page = title + "\n\n" + heading1 + "\n\n" + heading2 + "\n\n";

        for (int i = 0; i < data.length; i++) {
            page += data[i] + "";
        }

        System.out.println(page);

        Formatter out = null;
        try {
            out = new Formatter(new File(filePath));
        } catch (FileNotFoundException | NullPointerException ex) {
            if (out != null) {
                out.close();
            }
            System.err.print(ex);
            return false;
        }
        out.format("%s", page);
        out.close();
        return true;
    }
}
