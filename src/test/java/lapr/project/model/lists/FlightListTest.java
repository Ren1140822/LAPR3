/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.FlightPlan;
import lapr.project.model.Location;
import lapr.project.model.Motorization;
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
public class FlightListTest {
    
    public FlightListTest() {
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
     * Test of newFlight method, of class FlightList.
     */
    @Test
    public void testNewFlight() {
        System.out.println("newFlight");
        FlightList instance = new FlightList();
        FlightPlan expResult = new FlightPlan();
        FlightPlan result = instance.newFlight();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class FlightList.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Aircraft a1 = new Aircraft("dsfsdg", "fdh", new CabinConfiguration(), 2, new AircraftModel(
                "id", "description", "maker", "passenger", new Motorization(), 10, 
                10, 10, 10, 10, 10, 10, 10, 10, 10, new LinkedList<>()));
        
        Airport air1 = new Airport("opo", "porto", "porto", "portugal", new Location(10, 10, 10));
        Airport air2 = new Airport("lis", "lisboa", "lisboa", "portugal", new Location(20, 20, 20));
        FlightPlan flight = new FlightPlan("FF0001A", 10, a1, air1, air2,
                new LinkedList<>(), new LinkedList<>(),new LinkedList<>());
        FlightList instance = new FlightList();
        boolean expResult = true;
        boolean result = instance.validate(flight);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveFlight method, of class FlightList.
     */
    @Test
    public void testSaveFlight() {
        System.out.println("saveFlight");
        Aircraft a1 = new Aircraft("dsfsdg", "fdh", new CabinConfiguration(), 2, new AircraftModel(
                "id", "description", "maker", "passenger", new Motorization(), 10, 
                10, 10, 10, 10, 10, 10, 10, 10, 10, new LinkedList<>()));
        
        Airport air1 = new Airport("opo", "porto", "porto", "portugal", new Location(10, 10, 10));
        Airport air2 = new Airport("lis", "lisboa", "lisboa", "portugal", new Location(20, 20, 20));
        FlightPlan flight = new FlightPlan("FF0001A", 10, a1, air1, air2,
                new LinkedList<>(), new LinkedList<>(),new LinkedList<>());
        FlightList instance = new FlightList();
        instance.validate(flight);
        boolean expResult = true;
        boolean result = instance.saveFlight(flight);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlightList method, of class FlightList.
     */
    @Test
    public void testGetFlightList() {
        System.out.println("getFlightList");
        List<FlightPlan> expResult = new LinkedList<>();
        FlightList instance = new FlightList(expResult);        
        List<FlightPlan> result = instance.getFlightList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFlightList method, of class FlightList.
     */
    @Test
    public void testSetFlightList() {
        System.out.println("setFlightList");
        FlightList instance = new FlightList();
        FlightList instance2 = new FlightList(instance);
        instance2.setFlightList(new LinkedList<FlightPlan>());
    }
    
}
