/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddAircraftControllerTest {

    AddAircraftController instance = new AddAircraftController();

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
        boolean expResult = true;
        instance.createAircraft();
        boolean result = instance.setAircraftData(registration, company, nrOfSeatsEcon, nrOfSeatsCommercial, NrOfElements);
        assertEquals(expResult, result);
   
    }

}
