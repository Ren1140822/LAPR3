/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import com.sun.media.jfxmedia.logging.Logger;
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
     * @param title the tab title on browser
     * @param heading1 the first title
     * @param heading2 the second title
     * @param body the body of the document
     * @param filePath the file path
     * @return  true if exported
     */
    public static boolean exportStringsToCSV(String title,String heading1,String heading2,String[]body,String filePath)
    {
        String page;
       
       
        page= title+"\n\n"+heading1+"\n\n"+heading2+"\n\n";
         for (int i = 0; i < body.length; i++) {
            page+=body[i]+"\n";
        }
        System.out.println(page);
        Formatter out=null;
        try {
            out = new Formatter(new File(filePath));
        } catch (FileNotFoundException ex) {
       
            return false;
        }
        out.format("%s", page);
        out.close();
        return true;
    }
}
