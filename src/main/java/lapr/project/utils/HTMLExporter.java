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
    public static boolean exportMultipleStringsToHTML(String title, String heading1, String heading2, String[][] body, String filePath) {
        String page;
        String data[] = new String[body[0].length];
        for (int i = 0; i < data.length; i++) {
            data[i]="";
        }
        for (int i = 0; i < body[0].length; i++) {     
            for (int j = 0; j < body.length; j++) {
                
                    data[i] +=  "| "+body[j][i]+" |";
                   
            }
            data[i]+="<P>" ;
        }
        page = "<HTML>\n<HEAD>\n<TITLE>" + title + "</TITLE>\n</HEAD>\n<HR>\n<H1>" + heading1 + "</H1>\n<H2>" + heading2 + "</H2>\n";
        for (int i = 0; i < data.length; i++) {
            page +=  data[i]+"  ";
        }
        page +=  "<HR>\n</BODY>\n</HTML>";
        System.out.println(page);
        Formatter out = null;
        try {
            out = new Formatter(new File(filePath));
        } catch (FileNotFoundException  |NullPointerException ex) {
            out.close();
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
        } catch (FileNotFoundException |NullPointerException ex) {
            out.close();
         
            return false;
        }
        out.format("%s", page);
        out.close();
        return true;
    }
}
