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
 * @author Pedro Fernandes
 */
public class AddAirportControllerTest {
    
    public AddAirportControllerTest() {
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
     * Test of saveAirport method, of class AddAirportController.
     */
    @Test
    public void testSaveAirport() {
        System.out.println("saveAirport1");
        AddAirportController instance = new AddAirportController();
        instance.setAirportData("OPO", "Sá Carneiro", "Porto", 30.0, 50.0, 10);
        boolean expResult = true;
        boolean result = instance.saveAirport();
        assertEquals(expResult, result);
        
        System.out.println("saveAirport2");
        AddAirportController instance2 = new AddAirportController();
        instance2.setAirportData("OPO", "Sá Carneiro", "Porto", 300.0, 50.0, 10);
        boolean expResult2 = false;
        boolean result2 = instance2.saveAirport();
        assertEquals(expResult2, result2);
    }
    
    /**
     * Test of setAirportData method, of class AddAirportController.
     */
    @Test
    public void testSetAirportData() {
        System.out.println("setAirportData");
        String IATA = "OPO";
        String name = "Sá Carneiro";
        String town = "Porto";
        double latitude = 30.0;
        double longitude = 50.0;
        int altitude = 10;
        AddAirportController instance = new AddAirportController();
        instance.setAirportData(IATA, name, town, latitude, longitude, altitude);
    }
    
}
