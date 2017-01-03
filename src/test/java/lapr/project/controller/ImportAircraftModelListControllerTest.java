/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import lapr.project.model.Project;
import lapr.project.model.lists.AircraftModelList;
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
public class ImportAircraftModelListControllerTest {
    
    public ImportAircraftModelListControllerTest() {
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
//
//    /**
//     * Test of importXMLAircraftModelList method, of class ImportAircraftModelListController.
//     */
//    @Test
//    public void testImportXMLAircraftModelList() throws Exception {
//        Project p = new Project();
//        System.out.println("importXMLAircraftModelList1");
//        File file = new File("src/main/resources/TestSet01_Aircraft.xml");
//        ImportAircraftModelListController instance = new ImportAircraftModelListController(p);
//        boolean expResult = true;
//        boolean result = instance.importXMLAircraftModelList(file);
//        //show in the screen imported file
//        JAXBContext context = JAXBContext.newInstance(AircraftModelList.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(instance.aircraftsModelList, System.out);
//        //end
//        assertEquals(expResult, result);
//        
//        System.out.println("importXMLAirportList2");
//        File file2 = new File("src/main/resources/Test.xml");
//        ImportAircraftModelListController instance2 = new ImportAircraftModelListController(p);        
//        boolean expResult2 = false;
//        boolean result2 = instance2.importXMLAircraftModelList(file2);
//        assertEquals(expResult2, result2);
//    }
//    
}
