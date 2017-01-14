/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class CSVExporterTest {
    boolean result;
    public CSVExporterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    public boolean isResult() {
        return result;
    }

    /**
     * Test of exportStringsToCSV method, of class CSVExporter.
     */
    @Test
    public void testExportStringsToCSV() throws FileNotFoundException {      
        System.out.println("exportStringsToCSV");
        String title = "title";
        String heading1 = "h1";
        String heading2 = "h2";
        String[] body = new String[2];
        body[0]="body0";
        body[1]= "body1";
        String filePath = "src/main/resources/testcsv.csv";
        
         CSVExporter.exportStringsToCSV(title, heading1, heading2, body, filePath);
         File file = new File("src/main/resources/testcsv.csv");
         file.deleteOnExit();
         Scanner scan = new Scanner (file);
         boolean result=false;
         while(scan.hasNext())
         {
           String test= scan.next();
             result= test.contains(title) ||   test.contains(heading1) ||  test.contains(heading2) || test.contains(body[0]) ||  test.contains(body[1]) ||  test.contains("\n");
         }
         scan.close();
         Assert.assertTrue(result);
    }

    /**
     * Test of exportMultipleStringsToCSV method, of class CSVExporter.
     */
    @Test
    public void testExportMultipleStringsToCSV() throws FileNotFoundException {
        System.out.println("exportMultipleStringsToCSV");
      String title = "title";
        String heading1 = "h1";
        String heading2 = "h2";
      String[][] body = new String[4][2];
        body[0][0] = "body00";
        body[0][1] = "body01";
        body[1][0] = "body10";
        body[1][1] = "body11";
        body[2][0] = "body20";
        body[2][1] = "body21";
        body[3][0] = "body30";
        body[3][1] = "body31";
        String filePath = "src/main/resources/testcsv2.csv";
        
         CSVExporter.exportMultipleStringsToCSV(title, heading1, heading2, body, filePath);
         File file = new File("src/main/resources/testcsv2.csv");
          file.deleteOnExit();
         Scanner scan = new Scanner (file);
         
         boolean result=false;
         while(scan.hasNext())
         {
           String test= scan.next();
            result = test.contains(title) || test.contains(heading1) || test.contains(heading2) || test.contains(body[0][0]) || test.contains(body[1][1]) ||test.contains(body[1][0]) ||test.contains(body[2][1]) || test.contains(body[2][0]) ||test.contains(body[3][0]) ||test.contains("\n") ||test.contains(body[0][1]) ||test.contains(body[3][1]);
         }
        scan.close();
         Assert.assertTrue(result);
      
    }
    
}
