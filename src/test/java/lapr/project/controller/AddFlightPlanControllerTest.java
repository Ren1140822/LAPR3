/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.Location;
import lapr.project.model.Motorization;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.Segment;
import lapr.project.model.Thrust_Function;
import lapr.project.model.Wind;
import lapr.project.model.lists.AirportList;
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
                10, 10, 10, 10, 10, 10, 10, 10, 10, new LinkedList<>()));
        
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

    /**
     * Test of getPossibleEndAirportsByAirportID method, of class AddFlightPlanController.
     */
    @Test
    public void testGetPossibleEndAirportsByAirportID() {
        System.out.println("getPossibleEndAirportsByAirportID");
        Project proj = new Project();
        Node startNode = new Node("test1", 40, 40);
        Node intNode = new Node("test2", 50, 70);
        Node endNode = new Node("test3", 40, 80);

        Wind windTest = new Wind(10, 10);
        String direction = "BIDIRECTIONAL";
        Segment segment1=new Segment("segmentTest1",startNode, endNode, direction,windTest,0,0);       
        Segment segment2=new Segment("segmentTest2", startNode, intNode, direction,windTest,0,0);
        Segment segment3=new Segment("segmentTest3", intNode, endNode, direction, windTest,0,0);

        AirNetwork airnetwork = proj.getAirNetwork();
        airnetwork.getNodeList().add(startNode);
        airnetwork.getNodeList().add(intNode);
        airnetwork.getNodeList().add(endNode);
        airnetwork.getAirNetwork().insertVertex(startNode);
        airnetwork.getAirNetwork().insertVertex(intNode);
        airnetwork.getAirNetwork().insertVertex(endNode);

        airnetwork.getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        airnetwork.getAirNetwork().insertEdge(intNode, endNode, segment3, 30);
        airnetwork.getAirNetwork().insertEdge(startNode, endNode, segment1, 20);

        Airport airport1 = new Airport("1", "", "", "", new Location(40, 40, 10));
        Airport airport2 = new Airport("2", "", "", "", new Location(50, 70, 10));
        Airport airport3 = new Airport("3", "", "", "", new Location(40, 80, 10));

        AirportList airportsList = proj.getAirportList();
        airportsList.getAirportList().add(airport1);
        airportsList.getAirportList().add(airport2);
        airportsList.getAirportList().add(airport3);

        List<Airport> expResult = new LinkedList<>();
        expResult.add(airport2);
        expResult.add(airport3);
        
        String startAir = "1";
        AddFlightPlanController instance = new AddFlightPlanController(proj);
        List<Airport> result = instance.getPossibleEndAirportsByAirportID(startAir);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPossibleEndNodesByAirportId method, of class AddFlightPlanController.
     */
    @Test
    public void testGetPossibleEndNodesByAirportId() {
        System.out.println("getPossibleEndNodesByAirportId");
        Project proj = new Project();
        Node startNode = new Node("test1", 40, 40);
        Node intNode = new Node("test2", 50, 70);
        Node endNode = new Node("test3", 40, 80);

        Wind windTest = new Wind(10, 10);
        String direction = "BIDIRECTIONAL";
        Segment segment1=new Segment("segmentTest1",startNode, endNode, direction,windTest,0,0);       
        Segment segment2=new Segment("segmentTest2", startNode, intNode, direction,windTest,0,0);
        Segment segment3=new Segment("segmentTest3", intNode, endNode, direction, windTest,0,0);

        AirNetwork airnetwork = proj.getAirNetwork();
        airnetwork.getNodeList().add(startNode);
        airnetwork.getNodeList().add(intNode);
        airnetwork.getNodeList().add(endNode);
        airnetwork.getAirNetwork().insertVertex(startNode);
        airnetwork.getAirNetwork().insertVertex(intNode);
        airnetwork.getAirNetwork().insertVertex(endNode);

        airnetwork.getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        airnetwork.getAirNetwork().insertEdge(intNode, endNode, segment3, 30);
        airnetwork.getAirNetwork().insertEdge(startNode, endNode, segment1, 20);

        Airport airport1 = new Airport("1", "", "", "", new Location(40, 40, 10));
        Airport airport2 = new Airport("2", "", "", "", new Location(50, 70, 10));
        Airport airport3 = new Airport("3", "", "", "", new Location(40, 80, 10));

        AirportList airportsList = proj.getAirportList();
        airportsList.getAirportList().add(airport1);
        airportsList.getAirportList().add(airport2);
        airportsList.getAirportList().add(airport3);

        List<Node> expResult = new LinkedList<>();
        expResult.add(intNode);
        expResult.add(endNode);
        
        String startAir = "1";
        AddFlightPlanController instance = new AddFlightPlanController(proj);
        List<Node> result = instance.getPossibleEndNodesByAirportId(startAir);
        assertEquals(expResult, result);
    }

    /**
     * Test of pattern method, of class AddFlightPlanController.
     */
    @Test
    public void testPattern() {
        System.out.println("pattern1");
        File ficheiro = new File("src/main/resources/Flight_pattern_A380_v1a.csv");
        AddFlightPlanController instance = new AddFlightPlanController(project);        
        boolean expResult = true;
        boolean result = instance.pattern(ficheiro);
        assertEquals(expResult, result);
        
        System.out.println("pattern2");
        File ficheiro2 = new File("src/main/resources/Flight_pattern_B777-200_v1a.csv");
        AddFlightPlanController instance2 = new AddFlightPlanController(project);        
        boolean expResult2 = true;
        boolean result2 = instance2.pattern(ficheiro2);
        assertEquals(expResult2, result2);
    }
    
}
