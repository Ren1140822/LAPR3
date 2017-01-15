/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.FlightPlan;
import lapr.project.model.Location;
import lapr.project.model.Motorization;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.Segment;
import lapr.project.model.Wind;
import lapr.project.model.analysis.Path;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;
import lapr.project.model.lists.AirportList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NANA
 */
public class FlightPlanAnalysisControllerTest {
    
     private Node startNode, intNode, endNode, testNode1, testNode;
    private Wind windTest;
    private Project p;
    private AirNetwork airTest;
    private Segment seg1,seg2,seg3;
    private AirportList listTest;
    private Airport startAirport, endAirport, intAirport;
    private FlightPlan fPlan;
    private Aircraft aircraft;
    private AircraftModel aircraftModel;
    private double mass=5.40*Math.pow(10,5);
    private int timeStep=120;
    public FlightPlanAnalysisControllerTest() {
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
     * Test of newSImulation method, of class FlightPlanAnalysisController.
     */
    @Test
    public void testNewSImulation() {
        System.out.println("newSImulation");
        FlightPlanAnalysisController instance = new FlightPlanAnalysisController(new Project());
        instance.newSImulation();
    }

    /**
     * Test of convertNodeToAirport method, of class FlightPlanAnalysisController.
     */
    @Test
    public void testConvertNodeToAirport() {
        System.out.println("convertNodeToAirport");
        
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
     * Test of convertAirportToNode method, of class FlightPlanAnalysisController.
     */
    @Test
    public void testConvertAirportToNode() {
        System.out.println("convertAirportToNode");
        
        AirNetwork instance = new AirNetwork();

        Node nodeTest1 = new Node("test1", 10, 30);
        Node nodeTest2 = new Node("test2", 10, 20);
        Node nodeTest3 = new Node("test3", 40, 20);

        instance.getNodeList().add(nodeTest1);
        instance.getNodeList().add(nodeTest2);
        instance.getNodeList().add(nodeTest3);

        Airport airportTest = new Airport("", "", "", "", new Location(10, 20, 10));

        Node expResult = nodeTest2;
        Node result = instance.getAirportNode(airportTest);
        assertEquals(expResult, result); 
        
    }

    /**
     * Test of getPossibleEndAirports method, of class FlightPlanAnalysisController.
     */
    @Test
    public void testGetPossibleEndAirports() {
         System.out.println("getPossibleEndAirports");
   
        createAirNet();
        FlightPlanAnalysisController instance=new FlightPlanAnalysisController(p);
        
        LinkedList<Airport> result=new LinkedList<>();

        result.add(p.getAirportList().getAirportNode(intNode));
        result.add(p.getAirportList().getAirportNode(endNode));
       
        assertEquals(instance.getPossibleEndAirports(startNode), result);

    }

    /**
     * Test of getResult method, of class FlightPlanAnalysisController.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        TypePath type = TypePath.SHORTEST_PATH;
        p=new Project();
        
        startNode=new Node("", 10, 10);
        endNode=new Node("", 20, 20);
        double expResult = 20;
        
        Airport startAirport=new Airport("", "", "", "", new Location(10,10,10));
        Airport endAirport=new Airport("", "", "", "", new Location(20,20,20));
        
        p.getAirportList().getAirportList().add(startAirport);
        p.getAirportList().getAirportList().add(endAirport);
        
        p.getAirNetwork().getNodeList().add(startNode);
        p.getAirNetwork().getNodeList().add(endNode);
        FlightPlanAnalysisController instance = new FlightPlanAnalysisController(p);        
        
        instance.newSImulation();
        instance.createBestPathSimulation(TypePath.ALL);
        
        instance.getSimulation().getShortestResultPath().setResult(expResult);
        double result = instance.getResult(type).getResult();
        assertEquals(expResult, result,0.0);
    }

    /**
     * Test of saveSimulation method, of class FlightPlanAnalysisController.
     */
    @Test
    public void testSaveSimulation() {
        System.out.println("saveSimulation");
        p=new Project();
        createFlightPlan();
        
        FlightPlanAnalysisController instance = new FlightPlanAnalysisController(p);
        instance.newSImulation();
        Node start=new Node("",10,10);
        Node end=new Node("",20,20);
        Airport startAirport=new Airport("","","","", new Location(10,10,10));
        Airport endAirport=new Airport("","","","",new Location(20,20,20));
        
        p.getAirNetwork().getNodeList().add(start);
        p.getAirNetwork().getNodeList().add(end);
        
        p.getAirportList().getAirportList().add(startAirport);
        p.getAirportList().getAirportList().add(endAirport);
     
        instance.createBestPathSimulation(TypePath.ALL);
        CabinConfiguration cc=new CabinConfiguration();
        AircraftModel am=new AircraftModel("", "", "", "", new Motorization(), 
                1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, new LinkedList<>());
   
        instance.getSimulation().getEcologicResultPath().setResult(10);
        instance.getSimulation().getEcologicResultPath().setResultPath(new LinkedList<>());
        boolean expResult = false;
        boolean result = instance.saveSimulation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSimulation method, of class FlightPlanAnalysisController.
     */
    @Test
    public void testGetSimulation() {
        System.out.println("getSimulation");
        FindBestPathController instance = new FindBestPathController(new Project());
        Airport startAirport=new Airport();
        Airport endAirport=new Airport();
        
        Simulation expResult = new Simulation();
 
        expResult.createPathSimulation(TypePath.ALL);
        
        instance.newSImulation();
        instance.createBestPathSimulation(TypePath.ALL);
        
        Simulation result = instance.getSimulation();
        assertEquals(expResult, result);
    }
    
     
    private void createAirNet(){
        
        startNode=new Node("test1", 40, 40);
        intNode=new Node("test2", 50, 70);
        endNode=new Node("test3", 40, 80);
        testNode1=new Node("test4", 40,30);
        testNode=new Node("test5", 40, 90);

        windTest=new Wind(10,10);
        String direction="BIDIRECTIONAL";
        Segment segment1=new Segment("segmentTest1",startNode, endNode, direction,windTest,0,0);       
        Segment segment2=new Segment("segmentTest2", startNode, intNode, direction,windTest,0,0);
        Segment segment3=new Segment("segmentTest3", intNode, endNode, direction, windTest,0,0);
        Segment segment4=new Segment("segmentTest4", testNode1, testNode, direction, windTest,0,0);
        
        airTest=new AirNetwork();
        airTest.getAirNetwork().insertVertex(startNode);
        airTest.getAirNetwork().insertVertex(intNode);
        airTest.getAirNetwork().insertVertex(endNode);
        airTest.getAirNetwork().insertVertex(testNode);
        airTest.getAirNetwork().insertVertex(testNode1);

        airTest.getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        airTest.getAirNetwork().insertEdge(intNode, endNode, segment3, 30);
        airTest.getAirNetwork().insertEdge(startNode, endNode, segment1, 20); 
        airTest.getAirNetwork().insertEdge(testNode1, testNode, segment4, 5);
        
        p=new Project();
        p.setAirNetwork(airTest);
        
        p.getAirportList().getAirportList().add(new Airport("","","","",new Location(40,40,0)));
        p.getAirportList().getAirportList().add(new Airport("","","","",new Location(50,70,0)));
        p.getAirportList().getAirportList().add(new Airport("","","","",new Location(40,80,0)));  
        
        p.getAirNetwork().getNodeList().add(startNode);
        p.getAirNetwork().getNodeList().add(endNode);
        p.getAirNetwork().getNodeList().add(intNode);
        
        startAirport=new Airport("test1", "","","", new Location(40, 40,10));
        endAirport=new Airport("test2", "","","", new Location(50,70,10));
        p.getAirportList().getAirportList().add(startAirport);
        p.getAirportList().getAirportList().add(endAirport);
        
    }

    /**
     * Test of createBestPathSimulation method, of class FlightPlanAnalysisController.
     */
    @Test
    public void testCreateBestPathSimulation() {
        System.out.println("createBestPathSimulation");
        TypePath type = TypePath.ECOLOGIC_PATH;
        Project p=new Project();
        FlightPlanAnalysisController instance = new FlightPlanAnalysisController(p);
        instance.newSImulation();
        instance.createBestPathSimulation(type);

    }
    
     private void createFlightPlan(){
        fPlan=new FlightPlan();
        
        createAirNet();
        fPlan.setOrigin(startAirport);
        fPlan.setDestination(endAirport);
        fPlan.setAircraft(new Aircraft());
    }
    
    
}
