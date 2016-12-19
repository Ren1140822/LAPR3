/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import lapr.project.model.AirNetwork;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ImportNetworkControllerTest {
    
    public ImportNetworkControllerTest() {
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
     * Test of importXMLNetwork method, of class ImportNetworkController.
     */
    @Test
    public void testImportXMLNetwork() throws Exception {
        System.out.println("importXMLNetwork");
        File file = new File("src/main/resources/TestSet01a_Network.xml");
        ImportNetworkController instance = new ImportNetworkController();
        boolean expResult = true;
        boolean result = instance.importXMLNetwork(file);
        //show in the screen imported file
        JAXBContext context = JAXBContext.newInstance(AirNetwork.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(instance.network, System.out);
        //end
        assertEquals(expResult, result);
        
        System.out.println("importXMLNetwork2");
        File file2 = new File("src/main/resources/Test.xml");
        ImportNetworkController instance2 = new ImportNetworkController();
        boolean expResult2 = false;
        boolean result2 = instance2.importXMLNetwork(file2);
        assertEquals(expResult2, result2);
    }
    
}
