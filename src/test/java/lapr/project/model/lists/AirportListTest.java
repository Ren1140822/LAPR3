/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import javafx.scene.shape.Line;
import lapr.project.model.Airport;
import lapr.project.model.Location;
import lapr.project.model.Node;
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
public class AirportListTest {

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
        AirportList instance = new AirportList(new AirportList());
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
        List<Airport> airportList = new LinkedList<>();
        airportList.add(new Airport());
        AirportList instance = new AirportList(new LinkedList<>());
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

    /**
     * Test of getAirportNode method, of class AirportList.
     */
    @Test
    public void testGetAirportNode() {
        System.out.println("getAirportNode");
        AirportList instanceTest = new AirportList();
        
        Airport airportTest1=new Airport("1", "", "", "", new Location(20,30,10));
        Airport airportTest2=new Airport("2", "", "", "", new Location(40,50,10));
        Airport airportTest3=new Airport("3", "", "", "", new Location(10,20,10));
        
        instanceTest.getAirportList().add(airportTest1);
        instanceTest.getAirportList().add(airportTest2);
        instanceTest.getAirportList().add(airportTest3);
  
        Node nodeTest=new Node("test1", 40, 50);
       
        Airport expResult = airportTest2;
        Airport result = instanceTest.getAirportNode(nodeTest);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAirportListString method, of class AirportList.
     */
    @Test
    public void testGetAirportListString() {
        System.out.println("getAirportListString");
        AirportList instance = new AirportList();
        instance.newAirport();
        instance.setAirportData("TESTE", "name", "town", "country", 10, 10, 10);
        instance.saveAirport();
        List<String> expResult = new LinkedList<>();
        for(Airport air : instance.getAirportList()){
            expResult.add(air.toString());
        }
        List<String> result = instance.getAirportListString();
        assertEquals(expResult, result);
    }

}
