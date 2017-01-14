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
public class HTMLExporter {

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
    public static boolean exportStringsToHTML(String title, String heading1, String heading2, String[] body, String filePath) {
        String page;
        String data = "";
        for (int i = 0; i < body.length; i++) {
            data += "<P>" + body[i];
        }
        page = "<HTML>\n<HEAD>\n<TITLE>" + title + "</TITLE>\n</HEAD>\n<HR>\n<H1>" + heading1 + "</H1>\n<H2>" + heading2 + "</H2>\n" + data + "<HR>\n</BODY>\n</HTML>";
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
     * Exports Strings to html
     *
     * @param title the tab title on browser
     * @param heading1 the first title
     * @param heading2 the second title
     * @param body the body of the document
     * @param filePath the file path
     * @return true if exported
     */
    public static boolean exportMultipleStringsToHTML(String title, String heading1, String heading2, String[][] body, String filePath) {

        String data[] = new String[body[0].length];
        for (int i = 0; i < data.length; i++) {
            data[i] = "";
        }
        String titles = "    <tr>\n";
        for (int i = 0; i < body.length; i++) {
            if (body[i]!=null) {
                titles += "      <th><font face=\"verdana\" color=\"black\">" + body[i][0] + "</font></th>\n";
            }
        }
        titles += "    </tr>\n";

        for (int i = 1; i < body[0].length; i++) {

            data[i - 1] += "   <tr>\n";
            for (int j = 0; j < body.length; j++) {
                if (body[j][i]!=null) {
                    data[i - 1] += "      <th><font size=\"2\" face=\"verdana\" color=\"red\">" + body[j][i] + "</font></th>\n";

                }
            }

        }
        String page = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "table  {\n"
                + "    border-collapse: collapse;\n"
                + "border-bottom: 1px solid black;"
                + "border-top: 1px solid black;"
                + "    width: 100%;\n"
                + "}\n"
                + "\n"
                + "th, td {\n"
                + "    text-align: left;\n"
                + "    padding: 8px;\n"
                + "}\n"
                + "\n"
                + "tr:nth-child(even){background-color: #f2f2f2}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>"
                + "<h2><font face=\"verdana\" color=\"green\">" + heading1 + "</font></h2>\n"
                + "<p><font size=\"2\" face=\"verdana\" color=\"red\">Below there is a table with the exported results.</font></p>\n"
                + "\n"
                + "<div style=\"overflow-x:auto;\">\n"
                + "  <table>\n"
                + titles;
        for (int i = 0; i < data.length; i++) {
            page += data[i];
        }

        page += "  </table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html>\n"
                + "";

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
