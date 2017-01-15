/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.FlightPlan;
import lapr.project.model.Iten;
import lapr.project.model.Location;
import lapr.project.model.Motorization;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.Segment;
import lapr.project.model.Thrust_Function;
import lapr.project.model.Wind;
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
 * @author Diana Silva
 */
public class FindBestPathControllerTest {
    
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
        p=new Project();
        FindBestPathController instance = new FindBestPathController(p);
        instance.newSImulation();
        Simulation result=p.getSimulationsList().getSimulation();
        Simulation expResult=instance.getSimulation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPossibleEndAirports method, of class FindBestPathController.
     */
    @Test
    public void testGetPossibleEndAirports() {
        System.out.println("getPossibleEndAirports");
   
        createAirNet();
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
       
        p=new Project();
        p.getAirportList().getAirportList().add(startAirport);
        p.getAirportList().getAirportList().add(endAirport);  
        
        startNode=new Node("test",10,10);
        endNode=new Node("test1", 20,20);
        
        p.getAirNetwork().getNodeList().add(startNode);
        p.getAirNetwork().getNodeList().add(endNode);
        
        FindBestPathController instance = new FindBestPathController(p);
        instance.newSImulation();
        instance.createBestPathSimulation(TypePath.ALL);
       
        Simulation result =instance.getSimulation();
  
        Simulation expResult= new Simulation();
        expResult.createPathSimulation(TypePath.ALL);
        assertEquals(expResult, result);
    }

    /**
     * Test of setData method, of class FindBestPathController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Simulation s=new Simulation();
        createFlightPlan();
        s.setFlightPlan(fPlan);
        
        Airport startAirport=new Airport();
        Airport endAirport=new Airport();
        
        Node start=new Node();
        Node end=new Node();
        
        p=new Project();
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
        instance.getFlightPlanSelected(fPlan);
        instance.setData(passengers, crew, cargoLoad, fuelWeight,120);
        
        s.createPathSimulation(TypePath.ALL);
        assertEquals(instance.getSimulation(), instance.getSimulation());
    }

    /**
     * Test of getResult method, of class FindBestPathController.
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
        p=new Project();
        createFlightPlan();
        
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
        instance.getFlightPlanSelected(fPlan);
        instance.setData(50, 10, 100,1,120);
        
        instance.getSimulation().getEcologicResultPath().setResult(10);
        instance.getSimulation().getEcologicResultPath().setResultPath(new LinkedList<>());
        boolean expResult = true;
        boolean result = instance.saveSimulation();
        assertEquals(expResult, result);
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
    
    private void createFlightPlan(){
        fPlan=new FlightPlan();
        
        createAirNet();
        fPlan.setOrigin(startAirport);
        fPlan.setDestination(endAirport);
        fPlan.setAircraft(new Aircraft());
    }
    
    private void createAircraft(){
        
        int numberMotor=4;
        double tsfc=1.60*Math.pow(10, -4);
        double lapseRate=0.96;
        double t0=3.38*Math.pow(10, 5);
        double tMax=1.80*Math.pow(10, 5);
        double tMaxSp=0.9;
        Thrust_Function thrustFunction=new Thrust_Function(t0, tMax, tMaxSp);
        
        double eWeight=3*Math.pow(10, 5);
        double wingArea=858;
        double ar=9;
        double e=0.84;

        Iten it1=new Iten(210, 0.02);
        Iten it2=new Iten(210, 0.02);
        Iten it3=new Iten(230, 0.02);
        
        LinkedList<Iten> listIten=new LinkedList<>();
        listIten.add(it1);
        listIten.add(it2);
        listIten.add(it3);
        
        Motorization motorization=new Motorization(numberMotor, "","", 0, 0, 
                tsfc, lapseRate, thrustFunction);
        
       aircraftModel=new AircraftModel("", "", "", "Dummy 01", 
                        motorization, eWeight, 0, 0, 0, 0,0, wingArea, 0, ar, e, listIten);

    }

    /**
     * Test of getFlightPlanStringInfo method, of class FindBestPathController.
     */
    @Test
    public void testGetFlightPlanStringInfo() {
        System.out.println("getFlightPlanStringInfo");
        FindBestPathController instance = new FindBestPathController(p);
        FlightPlan flightPlan = new FlightPlan();
        instance.getFlightPlanSelected(flightPlan);
        String expResult = instance.getFlightPlanStringInfo();
        String result = instance.getFlightPlanStringInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTechnicalStops method, of class FindBestPathController.
     */
    @Test
    public void testGetTechnicalStops() {
        System.out.println("getTechnicalStops");
        FindBestPathController instance = new FindBestPathController(p);
        FlightPlan flightPlan = new FlightPlan();
        instance.getFlightPlanSelected(flightPlan);
        List<Airport> expResult = instance.getFlightPlan().getTechnicalStops();
        List<Airport> result = instance.getTechnicalStops();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMandatoryWaypoints method, of class FindBestPathController.
     */
    @Test
    public void testGetMandatoryWaypoints() {
        System.out.println("getMandatoryWaypoints");
        FindBestPathController instance = new FindBestPathController(p);
        FlightPlan flightPlan = new FlightPlan();
        instance.getFlightPlanSelected(flightPlan);
        List<Node> expResult = instance.getFlightPlan().getMandatoryWaypoints();
        List<Node> result = instance.getMandatoryWaypoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCabinConfig method, of class FindBestPathController.
     */
    @Test
    public void testGetCabinConfig() {
        System.out.println("getCabinConfig");
        FindBestPathController instance = new FindBestPathController(p);
        FlightPlan flightPlan = new FlightPlan();
        instance.getFlightPlanSelected(flightPlan);
        Map<String, Integer> expResult = instance.getFlightPlan().getAircraft().getCabinConfig().getMapOfClasses();
        Map<String, Integer> result = instance.getCabinConfig();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlightPlan method, of class FindBestPathController.
     */
    @Test
    public void testGetFlightPlan() {
        System.out.println("getFlightPlan");
        FindBestPathController instance = new FindBestPathController(p);
        FlightPlan flightPlan = new FlightPlan();
        instance.getFlightPlanSelected(flightPlan);
        FlightPlan expResult = flightPlan;
        FlightPlan result = instance.getFlightPlan();
        assertEquals(expResult, result);
    }
}