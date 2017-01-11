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
import lapr.project.model.analysis.SegmentResult;
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
public class FindBestPathControllerTest {
    
    public FindBestPathControllerTest() {
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
     * Test of newSImulation method, of class FindBestPathController.
     */
    @Test
    public void testNewSImulation() {
        System.out.println("newSImulation");
        Project p=new Project();
        FindBestPathController instance = new FindBestPathController(p);
        instance.newSImulation();
        Simulation result=p.getSimulationsList().getSimulation();
        Simulation expResult=instance.getSimulation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAircraftsList method, of class FindBestPathController.
     */
    @Test
    public void testGetAircraftsList() {
        System.out.println("getAircraftsList");
        Project p=new Project();
        Aircraft test=new Aircraft();
        p.getAircraftList().getAircraftList().add(test);
        FindBestPathController instance = new FindBestPathController(p);
        List<Aircraft> expResult = new LinkedList<>();
        expResult.add(test);
        List<Aircraft> result = instance.getAircraftsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAirportList method, of class FindBestPathController.
     */
    @Test
    public void testGetAirportList() {
        System.out.println("getAirportList");
        Project p=new Project();
        Airport a=new Airport();
        p.getAirportList().getAirportList().add(a);
        FindBestPathController instance = new FindBestPathController(p);
        
        List<Airport> expResult = new LinkedList<>();
        expResult.add(a);
        List<Airport> result = instance.getAirportList();
        assertEquals(expResult, result);
    }

    /**
     * Test of convertNodeToAirport method, of class FindBestPathController.
     */
    @Test
    public void testConvertNodeToAirport() {
        System.out.println("convertNodeToAirport");
        Project p=new Project();
        
        AirportList listTest = new AirportList();
        
        Airport airportTest1=new Airport("1", "", "", "", new Location(20,30,10));
        Airport airportTest2=new Airport("2", "", "", "", new Location(40,50,10));
        Airport airportTest3=new Airport("3", "", "", "", new Location(10,20,10));
        
        listTest.getAirportList().add(airportTest1);
        listTest.getAirportList().add(airportTest2);
        listTest.getAirportList().add(airportTest3);
  
        Node nodeTest=new Node("test1", 40, 50);
        
        p.getAirportList().setAirportList(listTest.getAirportList());
        
        FindBestPathController instance=new FindBestPathController(p);
        Airport expResult = airportTest2;
        Airport result = instance.convertNodeToAirport(nodeTest);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertAirportToNode method, of class FindBestPathController.
     */
    @Test
    public void testConvertAirportToNode() {
        System.out.println("convertAirportToNode");
        Project p=new Project();
        
       AirNetwork airTest = new AirNetwork();
        
        Node nodeTest1=new Node("test1", 10, 30);
        Node nodeTest2=new Node("test2", 10, 20);
        Node nodeTest3=new Node("test3", 40, 20);
       
        airTest.getNodeList().add(nodeTest1);
        airTest.getNodeList().add(nodeTest2);
        airTest.getNodeList().add(nodeTest3);
        
        Airport airportTest=new Airport("", "", "", "", new Location(10,20,10));
        
        p.getAirNetwork().setNodeList(airTest.getNodeList());
        FindBestPathController instance= new FindBestPathController(p);
        
        Node expResult = nodeTest2;
        Node result = instance.convertAirportToNode(airportTest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPossibleEndAirports method, of class FindBestPathController.
     */
    @Test
    public void testGetPossibleEndAirports() {
        System.out.println("getPossibleEndAirports");
   
        Node startNode=new Node("test1", 40, 40);
        Node intNode=new Node("test2", 50, 70);
        Node endNode=new Node("test3", 40, 80);
        Node testNode1=new Node("test4", 40,30);
        Node testNode=new Node("test5", 40, 90);
        
        Wind windTest=new Wind(10,10);
        String direction="BIDIRECTIONAL";
        Segment segment1=new Segment("segmentTest1",startNode, endNode, direction,windTest,0,0);       
        Segment segment2=new Segment("segmentTest2", startNode, intNode, direction,windTest,0,0);
        Segment segment3=new Segment("segmentTest3", intNode, endNode, direction, windTest,0,0);
        Segment segment4=new Segment("segmentTest4", testNode1, testNode, direction, windTest,0,0);
        
        AirNetwork airTest=new AirNetwork();
        airTest.getAirNetwork().insertVertex(startNode);
        airTest.getAirNetwork().insertVertex(intNode);
        airTest.getAirNetwork().insertVertex(endNode);
        airTest.getAirNetwork().insertVertex(testNode);
        airTest.getAirNetwork().insertVertex(testNode1);

        airTest.getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        airTest.getAirNetwork().insertEdge(intNode, endNode, segment3, 30);
        airTest.getAirNetwork().insertEdge(startNode, endNode, segment1, 20); 
        airTest.getAirNetwork().insertEdge(testNode1, testNode, segment4, 5);
        
        Project p=new Project();
        p.setAirNetwork(airTest);
        
        p.getAirportList().getAirportList().add(new Airport("","","","",new Location(40,40,0)));
        p.getAirportList().getAirportList().add(new Airport("","","","",new Location(50,70,0)));
        p.getAirportList().getAirportList().add(new Airport("","","","",new Location(40,80,0)));
        
        FindBestPathController instance=new FindBestPathController(p);
        
        LinkedList<Airport> result=new LinkedList<>();

        result.add(p.getAirportList().getAirportNode(intNode));
        result.add(p.getAirportList().getAirportNode(endNode));
       
        assertEquals(instance.getPossibleEndAirports(startNode), result);
    }

    /**
     * Test of createBestPathSimulation method, of class FindBestPathController.
     */
    @Test
    public void testCreateBestPathSimulation() {
        System.out.println("createBestPathSimulation");
        Airport startAirport = new Airport("test1", "","","", new Location(10,10,10));
        Airport endAirport = new Airport("test2", "","","", new Location(20,20,20));
       
        Project p=new Project();
        p.getAirportList().getAirportList().add(startAirport);
        p.getAirportList().getAirportList().add(endAirport);  
        
        Node startNode=new Node("test",10,10);
        Node endNode=new Node("test1", 20,20);
        
        p.getAirNetwork().getNodeList().add(startNode);
        p.getAirNetwork().getNodeList().add(endNode);
        
        FindBestPathController instance = new FindBestPathController(p);
        instance.newSImulation();
        instance.createBestPathSimulation(TypePath.ALL);
       
        Simulation result =instance.getSimulation();
  
        Simulation expResult= new Simulation(startAirport, endAirport, new Aircraft());
        expResult.createPathSimulation(TypePath.ALL);
        assertEquals(expResult, result);
    }

    /**
     * Test of setData method, of class FindBestPathController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        
        
        Airport startAirport=new Airport();
        Airport endAirport=new Airport();
        
        Node start=new Node();
        Node end=new Node();
        
        Project p=new Project();
        FindBestPathController instance = new FindBestPathController(p);
        p.getAirportList().getAirportList().add(startAirport);
        p.getAirportList().getAirportList().add(endAirport);
         
        p.getAirNetwork().getNodeList().add(start);
        p.getAirNetwork().getNodeList().add(end);
        
        Aircraft a=new Aircraft();
        int passengers = 20;
        int crew = 100;
        double cargoLoad = 40.4;
        double fuelWeight=0;
        instance.newSImulation();
        instance.createBestPathSimulation(TypePath.ALL);
        instance.setData( startAirport, endAirport,a, passengers, crew, cargoLoad, fuelWeight);
        
        Simulation s=new Simulation(passengers, crew, cargoLoad, fuelWeight);
        
        FlightPlan fp=new FlightPlan();
        
        fp.setOrigin(startAirport);
        fp.setDestination(endAirport);
        fp.setAircraft(a);
        s.setFlightPlan(fp);
        
        s.createPathSimulation(TypePath.ALL);
        assertEquals(instance.getSimulation(), s);
    }

    /**
     * Test of calculateShortesPath method, of class FindBestPathController.
     */
    @Test
    public void testCalculateShortesPath() {
        System.out.println("calculateShortesPath");
        Node startNode=new Node("test1", 40, 40);
        Node intNode=new Node("test2", 50, 70);
        Node endNode=new Node("test3", 40, 80);
        
        Wind windTest=new Wind(10,10);
        String direction="BIDIRECTIONAL";
        Segment segment1=new Segment("segmentTest1",startNode, endNode, direction,windTest,0,0);       
        Segment segment2=new Segment("segmentTest2", startNode, intNode, direction,windTest,0,0);
        Segment segment3=new Segment("segmentTest3", intNode, endNode, direction, windTest,0,0);
        
        Project p=new Project();
        AirNetwork airnetwork=p.getAirNetwork();
        airnetwork.getAirNetwork().insertVertex(startNode);
        airnetwork.getAirNetwork().insertVertex(intNode);
        airnetwork.getAirNetwork().insertVertex(endNode);
        
        airnetwork.getAirNetwork().insertEdge(startNode, endNode, segment1, 20);
        airnetwork.getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        airnetwork.getAirNetwork().insertEdge(intNode, endNode, segment3, 30);
  
        
        FindBestPathController instance= new FindBestPathController(p);
        p.getAirNetwork().getNodeList().add(startNode);
        p.getAirNetwork().getNodeList().add(endNode);
        p.getAirNetwork().getNodeList().add(intNode);
        
        Airport startAirport=new Airport("test1", "","","", new Location(40, 40,10));
        Airport endAirport=new Airport("test2", "","","", new Location(50,70,10));
        p.getAirportList().getAirportList().add(startAirport);
        p.getAirportList().getAirportList().add(endAirport);
        
        instance.newSImulation();
        instance.setData(startAirport, endAirport, new Aircraft(), 0, 0, 0, 0);
        instance.createBestPathSimulation(TypePath.SHORTEST_PATH);
        
        instance.calculatePath(TypePath.SHORTEST_PATH);
        LinkedList<Node> result=new LinkedList<>();
//        result.add(startNode);
//        result.add(intNode);
        assertEquals(instance.getSimulation().getShortestResultPath().getResultPath(), result);
    }

    /**
     * Test of getResult method, of class FindBestPathController.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        TypePath type = TypePath.SHORTEST_PATH;
        Project p=new Project();
        
        Node startNode=new Node("", 10, 10);
        Node endNode=new Node("", 20, 20);
        double expResult = 20;
        
        Airport startAirport=new Airport("", "", "", "", new Location(10,10,10));
        Airport endAirport=new Airport("", "", "", "", new Location(20,20,20));
        
        p.getAirportList().getAirportList().add(startAirport);
        p.getAirportList().getAirportList().add(endAirport);
        
        p.getAirNetwork().getNodeList().add(startNode);
        p.getAirNetwork().getNodeList().add(endNode);
        FindBestPathController instance = new FindBestPathController(p);        
        
        instance.newSImulation();
        instance.createBestPathSimulation(TypePath.ALL);
        
        instance.getSimulation().getShortestResultPath().setResult(expResult);
        double result = instance.getResult(type).getResult();
        assertEquals(expResult, result,0.0);

    }

    /**
     * Test of saveSimulation method, of class FindBestPathController.
     */
    @Test
    public void testSaveSimulation() {
        System.out.println("saveSimulation");
        Project p=new Project();
        
        FindBestPathController instance = new FindBestPathController(p);
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
       
        instance.setData(startAirport, endAirport,new Aircraft("", "", cc,3, am), 50, 10, 100,1);
        
        instance.getSimulation().getEcologicResultPath().setResult(10);
        instance.getSimulation().getEcologicResultPath().setResultPath(new LinkedList<>());
        boolean expResult = false;
        boolean result = instance.saveSimulation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTravellingTime method, of class FindBestPathController.
     */
    @Test
    public void testGetTravellingTime() {
        System.out.println("getTravellingTime");
        TypePath type = TypePath.ECOLOGIC_PATH;
        int expResult = 60;
         
        FindBestPathController instance = new FindBestPathController(new Project());
        instance.newSImulation();
        instance.createBestPathSimulation(type);
        SegmentResult sr=new SegmentResult();
        sr.setFlightTime(expResult);
        instance.getSimulation().getEcologicResultPath().newSegment(sr);

        double result = instance.getTravellingTime(type);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getDistance method, of class FindBestPathController.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        TypePath type = TypePath.ECOLOGIC_PATH;
         double expResult = 0.02;
         
        FindBestPathController instance = new FindBestPathController(new Project());
        
        instance.newSImulation();
        instance.createBestPathSimulation(type);
        SegmentResult sr=new SegmentResult();
        
        sr.setDistance(expResult);
        instance.getSimulation().getEcologicResultPath().newSegment(sr);

        double result = instance.getDistance(type);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getEnergyConsume method, of class FindBestPathController.
     */
    @Test
    public void testGetEnergyConsume() {
        System.out.println("getEnergyConsume");
        TypePath type = TypePath.ECOLOGIC_PATH;
         double expResult = 200;
         
        FindBestPathController instance = new FindBestPathController(new Project());
        
        instance.newSImulation();
        instance.createBestPathSimulation(type);
        SegmentResult sr=new SegmentResult();
        sr.setEnergyConsume(expResult);
        instance.getSimulation().getEcologicResultPath().newSegment(sr);

        double result = instance.getEnergyConsume(type);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSimulation method, of class FindBestPathController.
     */
    @Test
    public void testGetSimulation() {
        System.out.println("getSimulation");
        FindBestPathController instance = new FindBestPathController(new Project());
        Airport startAirport=new Airport();
        Airport endAirport=new Airport();
        
        Simulation expResult = new Simulation(startAirport,endAirport, new Aircraft());
 
        expResult.createPathSimulation(TypePath.ALL);
        
        instance.newSImulation();
        instance.createBestPathSimulation(TypePath.ALL);
        
        Simulation result = instance.getSimulation();
        assertEquals(expResult, result);
    }
    
}