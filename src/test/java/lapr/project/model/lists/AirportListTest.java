/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Airport;
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
public class AirportListTest {

    AirportList instance = new AirportList();

    public AirportListTest() {
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
     * Test of getAirportList method, of class AirportList.
     */
    @Test
    public void testGetAirportList() {
        System.out.println("getAirportList");
        AirportList instance = new AirportList();
        List<Airport> expResult = new LinkedList<Airport>();
        List<Airport> result = instance.getAirportList();
        assertEquals(expResult, result);

    }

    /**
     * Test of setAirportList method, of class AirportList.
     */
    @Test
    public void testSetAirportList() {
        System.out.println("setAirportList");
        List<Airport> airportList = new LinkedList<Airport>();
        airportList.add(new Airport());
        AirportList instance = new AirportList();
        instance.setAirportList(airportList);
        List<Airport> result = instance.getAirportList();
        assertEquals(airportList, result);

    }

    /**
     * Test of newAirport method, of class AirportList.
     */
    @Test
    public void testNewAirport() {
        System.out.println("newAirport");
        AirportList instance = new AirportList();
        instance.newAirport();
        assertTrue(instance.saveAirport()); //if saved, means it was created

    }

    /**
     * Test of setAirportData method, of class AirportList.
     */
    @Test
    public void testSetAirportData() {
        System.out.println("setAirportData");
        String IATA = "";//empty
        String name = "a";
        String town = "a";
        String country = "a";
        double latitude = 0.0;
        double longitude = 0.0;
        int altitude = 0;
        AirportList instance = new AirportList();
        instance.newAirport();
        instance.setAirportData(IATA, name, town, country, latitude, longitude, altitude);
        //has to fail, if it set was not made then it would pass because of default constructor
        assertFalse(instance.saveAirport());
    }

    /**
     * Test of saveAirport method, of class AirportList.
     */
    @Test
    public void testSaveAirport() {
        System.out.println("saveAirport");
        AirportList instance = new AirportList();
        instance.newAirport();
        assertTrue(instance.saveAirport());

    }

}
