/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.Location;
import lapr.project.model.Motorization;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.Thrust_Function;
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
public class AddFlightPlanControllerTest {
    
    Project project = new Project();
    
    AddFlightPlanController test = new AddFlightPlanController(project);
    
    public AddFlightPlanControllerTest() {
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
     * Test of getAircraftsList method, of class AddFlightPlanController.
     */
    @Test
    public void testGetAircraftsList() {
        System.out.println("getAircraftsList");
        AddFlightPlanController instance = test;
        List<Aircraft> expResult =  project.getAircraftList().getAircraftList();
        List<Aircraft> result = instance.getAircraftsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAirportList method, of class AddFlightPlanController.
     */
    @Test
    public void testGetAirportList() {
        System.out.println("getAirportList");
        AddFlightPlanController instance = test;
        List<Airport> expResult = project.getAirportList().getAirportList();
        List<Airport> result = instance.getAirportList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNodeList method, of class AddFlightPlanController.
     */
    @Test
    public void testGetNodeList() {
        System.out.println("getNodeList");
        AddFlightPlanController instance = test;
        List<Node> expResult = project.getAirNetwork().getNodeList();
        List<Node> result = instance.getNodeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setData method, of class AddFlightPlanController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Aircraft a1 = new Aircraft("aircraft", "fdh", new CabinConfiguration(), 2, new AircraftModel(
                "id", "description", "maker", "passenger", new Motorization(), 10, 
                10, 10, 10, 10, 10, 10, 10, 10, 10, new LinkedList<>(),new LinkedList<>()));
        
        Airport air1 = new Airport("opo", "porto", "porto", "portugal", new Location(10, 10, 10));
        Airport air2 = new Airport("lis", "lisboa", "lisboa", "portugal", new Location(20, 20, 20));
        String name = "test";
        int minStopTime = 0;
        String aircraft = "aircraft";
        String origin = "opo";
        String destination = "lis";
        Object[] technicalStops = new Object[0];
        Object[] mandatoryWaypoints = new Object[0];
        project.getAircraftList().getAircraftList().add(a1);
        project.getAirportList().getAirportList().add(air1);
        project.getAirportList().getAirportList().add(air2);
        AddFlightPlanController instance = test;
        instance.setData(name, minStopTime, aircraft, origin, destination, technicalStops, mandatoryWaypoints);
    }

    /**
     * Test of saveFlightPlan method, of class AddFlightPlanController.
     */
    @Test
    public void testSaveFlightPlan() {
        System.out.println("saveFlightPlan");
        project.getAircraftModelList().setAircraftModelData("id", "efd", 
                "dfh", "passenger", 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        project.getAircraftModelList().setCdrag_function(1, 10);
        project.getAircraftModelList().setMotorization(3, "adsvzcx", "df", 10, 10, 10, 10, new Thrust_Function(1, 10, 10));
        project.getAircraftModelList().saveAircrcaftModel();
        Aircraft a1 = new Aircraft("aircraft", "fdh", new CabinConfiguration(), 2, project.getAircraftModelList().getModelList().get(0));
        
        Airport air1 = new Airport("opo", "porto", "porto", "portugal", new Location(10, 10, 10));
        Airport air2 = new Airport("lis", "lisboa", "lisboa", "portugal", new Location(20, 20, 20));
        String name = "te875";
        int minStopTime = 0;
        String aircraft = "aircraft";
        String origin = "opo";
        String destination = "lis";
        Object[] technicalStops = new Object[0];
        Object[] mandatoryWaypoints = new Object[0];
        
        project.getAircraftList().getAircraftList().add(a1);
        project.getAirportList().getAirportList().add(air1);
        project.getAirportList().getAirportList().add(air2);
        AddFlightPlanController instance = test;
        instance.setData(name, minStopTime, aircraft, origin, destination, technicalStops, mandatoryWaypoints);
        boolean expResult = true;
        boolean result = instance.saveFlightPlan();
        assertEquals(expResult, result);
    }
    
}
