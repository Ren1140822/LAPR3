/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.FlightPlan;
import lapr.project.model.Location;
import lapr.project.model.Motorization;
import lapr.project.model.Thrust_Function;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;
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
public class SimulationsListTest {
    
    public SimulationsListTest() {
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
     * Test of getSimulationsList method, of class SimulationsList.
     */
    @Test
    public void testGetSimulationsList() {
        System.out.println("getSimulationsList");
        SimulationsList instance = new SimulationsList(new SimulationsList());
        LinkedList<Simulation> expResult = new LinkedList<>();
        instance.setSimulationsList(expResult);
        LinkedList<Simulation> result = instance.getSimulationsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSimulationsList method, of class SimulationsList.
     */
    @Test
    public void testSetSimulationsList() {
        System.out.println("setSimulationsList");
        LinkedList<Simulation> list = new LinkedList<>();
        SimulationsList instance = new SimulationsList(new LinkedList<>());
        instance.setSimulationsList(list);
    }

    /**
     * Test of newSimulation method, of class SimulationsList.
     */
    @Test
    public void testNewSimulation() {
        System.out.println("newSimulation");
        SimulationsList instance = new SimulationsList();
        instance.newSimulation();
    }

    /**
     * Test of getSimulation method, of class SimulationsList.
     */
    @Test
    public void testGetSimulation() {
        System.out.println("getSimulation");
        SimulationsList instance = new SimulationsList();
        instance.newSimulation();
        Simulation expResult = instance.getSimulation();
        Simulation result = instance.getSimulation();
        assertEquals(expResult, result);
    }

    /**
     * Test of saveSimulation method, of class SimulationsList.
     */
    @Test
    public void testSaveSimulation() {     
        CabinConfiguration c =new CabinConfiguration();
        Map<String,Integer> mapOfClasses = new HashMap<>();
        mapOfClasses.put("test", 15);
        c.setMapOfClasses(mapOfClasses);
        Aircraft aircraft = new Aircraft("dsfsdg", "fdh", c, 8, new AircraftModel(
                "id", "description", "maker", "passenger", new Motorization(
                4, "motor", "motorType", 1000, 10000, 10000, 1000, 
                new Thrust_Function(100, 100, 100)), 10, 
                10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
                new LinkedList<>()));
        Airport airp1 = new Airport("opo", "porto", "porto", "portugal", new Location(10, 10, 10));
        Airport airp2 = new Airport("lis", "lisboa", "lisboa", "portugal", new Location(20, 20, 20));
        FlightPlan f = new FlightPlan("FF0001A", 10, aircraft, airp1, airp2,
                new LinkedList<>(), new LinkedList<>(),new LinkedList<>());

        System.out.println("saveSimulation1");
        SimulationsList instance = new SimulationsList();
        instance.newSimulation();
        instance.getSimulation().setFlightPlan(f);
        instance.getSimulation().createPathSimulation(TypePath.ALL);
        instance.getSimulation().setData(10, 10, 10, 10, f,10);
        boolean expResult =true;
        boolean result = instance.saveSimulation();
        assertEquals(expResult, result);
        
        System.out.println("saveSimulation2");
        SimulationsList instance2 = new SimulationsList();
        instance2.newSimulation();
        instance2.getSimulation().setFlightPlan(f);
        instance2.getSimulation().createPathSimulation(TypePath.ALL);
        instance2.getSimulation().setData(10, 7, 10, 10, f,10);
        boolean expResult2 = true;
        boolean result2 = instance2.saveSimulation();
        assertEquals(expResult2, result2);
        
    }
    
}
