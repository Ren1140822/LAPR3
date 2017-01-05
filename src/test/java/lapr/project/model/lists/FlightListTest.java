/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import lapr.project.model.FlightPlan;
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
        FlightPlan flight = new FlightPlan("FF0001A", 10, "ircraft", "OPO", "LIS",
                new LinkedList<>(), new LinkedList<>());
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
        FlightPlan flight = new FlightPlan("FF0001A", 10, "ircraft", "OPO", "LIS",
                new LinkedList<>(), new LinkedList<>());
        FlightList instance = new FlightList();
        instance.validate(flight);
        boolean expResult = true;
        boolean result = instance.saveFlight(flight);
        assertEquals(expResult, result);
    }
    
}
