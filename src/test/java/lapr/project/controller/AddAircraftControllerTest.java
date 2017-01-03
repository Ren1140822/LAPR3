/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.HashMap;
import java.util.Map;
import lapr.project.model.Project;
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

    AddAircraftController instance = new AddAircraftController(p);

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

        assertEquals(instance.createAircraft(), true);
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
        AddAircraftController instance =this.instance;
        Map<String,Integer> map = new HashMap<>();
        boolean expResult = true;
        instance.createAircraft();
        boolean result = instance.setAircraftData(registration, company,map, NrOfElements);
        assertEquals(expResult, result);
   
    }

}
