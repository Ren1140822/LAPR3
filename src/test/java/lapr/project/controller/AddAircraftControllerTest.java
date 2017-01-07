/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lapr.project.model.AircraftModel;
import lapr.project.model.Motorization;
import lapr.project.model.Project;
import lapr.project.model.Thrust_Function;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddAircraftControllerTest {
    Project p = new Project();
    

    AddAircraftController instanc = new AddAircraftController(p);

    public AddAircraftControllerTest() {
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
     * Test of createAircraft method, of class AddAircraftController.
     */
    @Test
    public void testCreateAircraft() {
        System.out.println("createAircraft");

        assertEquals(instanc.createAircraft(), true);
    }

    /**
     * Test of setAircraftData method, of class AddAircraftController.
     */
    @Test
    public void testSetAircraftData() {
        System.out.println("setAircraftData");
        String registration = "asd";
        String company = "asd";
        int nrOfSeatsEcon = 10;
        int nrOfSeatsCommercial = 10;
        int NrOfElements = 10;
        AddAircraftController instance =this.instanc;
        Map<String,Integer> map = new HashMap<>();
        boolean expResult = true;
        instance.createAircraft();
        boolean result = instance.setAircraftData(registration, company,map, NrOfElements);
        assertEquals(expResult, result);
   
    }

    /**
     * Test of hasModel method, of class AddAircraftController.
     */
    @Test
    public void testHasModel() {
        System.out.println("hasModel");
        AddAircraftController instance = instanc;
        instance.model = new AircraftModel();
        boolean expResult = true;
        boolean result = instance.hasModel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAircraftModel method, of class AddAircraftController.
     */
    @Test
    public void testSetAircraftModel() {
        System.out.println("setAircraftModel");
        String aircraftModelID = "id";
        p.getAircraftModelList().setAircraftModelData("id", "efd", 
                "dfh", "passenger", 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        p.getAircraftModelList().setCdrag_function(1, 10);
        p.getAircraftModelList().setMotorization(3, "adsvzcx", "df", 10, 10, 10, 10, new Thrust_Function(1, 10, 10));
        p.getAircraftModelList().saveAircrcaftModel();
        
        AddAircraftController instance = instanc;
        boolean expResult = true;
        instance.createAircraft();
        boolean result = instance.setAircraftModel(aircraftModelID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfAircraftModels method, of class AddAircraftController.
     */
    @Test
    public void testGetListOfAircraftModels() {
        System.out.println("getListOfAircraftModels");
        AddAircraftController instance = instanc;
        List<AircraftModel> list = instance.project.getAircraftModelList().getModelList();
        LinkedList<String> expResult = new LinkedList<>();
        for (AircraftModel model : list) {
            expResult.add(model.getId());
        }
        
        List<String> result = instance.getListOfAircraftModels();
        assertEquals(expResult, result);
    }

}
