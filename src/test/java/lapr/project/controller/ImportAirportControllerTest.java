/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import lapr.project.model.lists.AirportList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pedro Fernandes
 */
public class ImportAirportControllerTest {
    
    public ImportAirportControllerTest() {
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

    /**
     * Test of importXMLAirportList method, of class ImportAirportController.
     */
    @Test
    public void testImportXMLAirportList() throws Exception {
        System.out.println("importXMLAirportList1");
        File file = new File("src/main/resources/TestSet01a_Airports.xml");
        ImportAirportController instance = new ImportAirportController();        
        boolean expResult = true;
        boolean result = instance.importXMLAirportList(file);
        //show in the screen imported file
        JAXBContext context = JAXBContext.newInstance(AirportList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(instance.airportsList, System.out);
        //end
        assertEquals(expResult, result);
        
        System.out.println("importXMLAirportList2");
        File file2 = new File("src/main/resources/Test.xml");
        ImportAirportController instance2 = new ImportAirportController();        
        boolean expResult2 = false;
        boolean result2 = instance2.importXMLAirportList(file2);
        assertEquals(expResult2, result2);
    }
    
}
