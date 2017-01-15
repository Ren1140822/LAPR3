/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lapr.project.controller.AddFlightPlanController;
import lapr.project.controller.ImportAircraftModelListController;
import lapr.project.controller.ImportAirportController;
import lapr.project.controller.ImportNetworkController;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.FlightPlan;
import lapr.project.model.Iten;
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
 * @author NANA
 */
public class PathTest {
    private Airport airportTest, airportTest2;
    private Aircraft aircraft;
    private int timeStep;
    private Project project;
    
    public PathTest() {
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
     * Test of setResult method, of class Path.
     */
    @Test
    public void testSetResult() {
        System.out.println("setResult");
        double result_2 = 200.0;
        FlightPlan flightPlan=new FlightPlan();
        EcologicPathResult instance = new EcologicPathResult(flightPlan);
        instance.setResult(result_2);
    }

    /**
     * Test of setResultPath method, of class Path.
     */
    @Test
    public void testSetResultPath() {
        System.out.println("setResultPath");
        List<Node> resultPath = new LinkedList<>();
        Path instance=new PathImpl();
        instance.setResultPath(resultPath);
    }

    /**
     * Test of getResult method, of class Path.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Path instance=new PathImpl();
        double expResult = 2000.0;
        instance.setResult(expResult);
        double result = instance.getResult();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getResultPath method, of class Path.
     */
    @Test
    public void testGetResultPath() {
        System.out.println("getResultPath");
        
        LinkedList<Node> expResult=new LinkedList<>();
        
        Path instance=new PathImpl();
        instance.setResultPath(expResult);
        List<Node> result = instance.getResultPath();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSegments method, of class Path.
     */
    @Test
    public void testGetSegments() {
        System.out.println("getSegments");
        Path instance = new PathImpl();
        LinkedList<SegmentResult> expResult = new LinkedList<>();
        LinkedList<SegmentResult> result = instance.getSegments();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegmentsResultTime method, of class Path.
     */
    @Test
    public void testSetSegments() {
        System.out.println("setSegments");
        LinkedList<SegmentResult> segments = null;
        Path instance = new PathImpl();
        instance.setSegmentsResultTime(segments);
    }

    /**
     * Test of getAir method, of class Path.
     */
    @Test
    public void testGetAir() {
        System.out.println("getAir");
        Path instance = new PathImpl();
        AirNetwork expResult = new AirNetwork();
        instance.setAir(expResult);
        AirNetwork result = instance.getAir();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAir method, of class Path.
     */
    @Test
    public void testSetAir() {
        System.out.println("setAir");
        AirNetwork air = new AirNetwork();
        Path instance = new PathImpl();
        instance.setAir(air);
    }

    /**
     * Test of validate method, of class Path.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Path instance = new PathImpl();
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Path.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new PathImpl();
        Path instance = new PathImpl();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Path.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Path instance = new PathImpl();
       int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(instance.getResult()) ^
                (Double.doubleToLongBits(instance.getResult()) >>> 32));
        int result = instance.hashCode();
        assertEquals(hash, result); 
    }

    /**
     * Test of simulateInitialNode method, of class Path.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testSimulateInitialNode() throws FileNotFoundException {
       
        System.out.println("simulateInitialNode");
        createProject();  
        createFlightPlan(project);
       
        Simulation s = new Simulation();
         s.setFlightPlan(project.getFlightList().getFlightList().get(0));
         s.setCargoLoad(70000);
         s.setFuelWeight(144720);
         
        double totalWeight= ((FlightPlan)project.getFlightList().getFlightList().get(0)).getAircraft().getAircraftModel().geteWeight()+70000+144720;
        s.createPathSimulation(TypePath.ECOLOGIC_PATH);
        Path instance = s.getEcologicResultPath();
        boolean expResult = true;
        
        Node startNode=project.getAirNetwork().getAirportNode(airportTest);
        Node endNode=project.getAirNetwork().getAirportNode(airportTest2);

        boolean result = instance.simulateInitialNode(s.getFlightPlan(), timeStep, totalWeight, project.getAirNetwork().getSegmentFromNodes(startNode, endNode));
        
        assertEquals(expResult, result);

    }


    public class PathImpl extends Path {
        
    }

    /**
     * Test of setSegmentsResultTime method, of class Path.
     */
    @Test
    public void testSetSegmentsResultTime() {
        System.out.println("setSegmentsResultTime");
        LinkedList<SegmentResult> segments = new LinkedList<>();
        Path instance = new PathImpl();
        instance.setSegmentsResultTime(segments);
    }

    /**
     * Test of getDistance method, of class Path.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Path instance = new PathImpl();
        LinkedList<SegmentResult> list=new LinkedList<>();
        
        SegmentResult seg1=new SegmentResult();
        SegmentResult seg2=new SegmentResult();
        seg1.setDistance(100.8);
        seg2.setDistance(200);
        list.add(seg1);
        list.add(seg2);
         instance.setSegmentsResultTime(list);
        double expResult = 300.8;
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getEnergyConsum method, of class Path.
     */
    @Test
    public void testGetEnergyConsum() {
        System.out.println("getEnergyConsum");
        Path instance = new PathImpl();
        LinkedList<SegmentResult> list=new LinkedList<>();
        
        SegmentResult seg1=new SegmentResult();
        SegmentResult seg2=new SegmentResult();
        seg1.setEnergyConsume(100.8);
        seg2.setEnergyConsume(200);
        list.add(seg1);
        list.add(seg2);
         instance.setSegmentsResultTime(list);
        double expResult = 300.8;
        double result = instance.getEnergyConsum();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getTravellingTime method, of class Path.
     */
    @Test
    public void testGetTravellingTime() {
        System.out.println("getTravellingTime");
        Path instance = new PathImpl();
        LinkedList<SegmentResult> list=new LinkedList<>();
        
        SegmentResult seg1=new SegmentResult();
        SegmentResult seg2=new SegmentResult();
        seg1.setFlightTime(100);
        seg2.setFlightTime(200);
        list.add(seg1);
        list.add(seg2);
        instance.setSegmentsResultTime(list);
        double expResult = 300;
        double result = instance.getTravellingTime();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of simulateEndNode method, of class Path.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testSimulateEndNode() throws FileNotFoundException {
        System.out.println("simulateEndNode");
        createProject();  
        createFlightPlan(project);
       
        Simulation s = new Simulation();
         s.setFlightPlan(project.getFlightList().getFlightList().get(0));
         s.setCargoLoad(70000);
         s.setFuelWeight(144720);
         
        double totalWeight= ((FlightPlan)project.getFlightList().getFlightList().get(0)).getAircraft().getAircraftModel().geteWeight()+70000+144720;
        s.createPathSimulation(TypePath.ECOLOGIC_PATH);
        Path instance = s.getEcologicResultPath();
        boolean expResult = true;
        
          SegmentResult cruise=new SegmentResult(SegmentType.CRUISE);
        s.getEcologicResultPath().getSegments().add(cruise);
        
        Node startNode=project.getAirNetwork().getAirportNode(airportTest);
        Node endNode=project.getAirNetwork().getAirportNode(airportTest2);
        
        boolean result = instance.simulateEndNode(airportTest,airportTest2,s.getFlightPlan(), timeStep, totalWeight,project.getAirNetwork().getSegmentFromNodes(startNode, endNode));
    
        assertEquals(expResult, result);
    }
     
    
    
        
    /**
     * Test of simulateIntermNodes method, of class Path.
     */
    @Test
    public void testSimulateIntermNodes() throws FileNotFoundException {
        System.out.println("simulateIntermNodes");

        createProject();  
        createFlightPlan(project);
       
        Simulation s = new Simulation();
         s.setFlightPlan(project.getFlightList().getFlightList().get(0));
         s.setCargoLoad(70000);
         s.setFuelWeight(144720);
         
        double totalWeight= ((FlightPlan)project.getFlightList().getFlightList().get(0)).getAircraft().getAircraftModel().geteWeight()+70000+144720;
        s.createPathSimulation(TypePath.ECOLOGIC_PATH);
        Path instance = s.getEcologicResultPath();
        SegmentResult cruise=new SegmentResult(SegmentType.CRUISE);
        s.getEcologicResultPath().getSegments().add(cruise);
        boolean expResult = true;
        
        Node startNode=project.getAirNetwork().getAirportNode(airportTest);
        Node endNode=project.getAirNetwork().getAirportNode(airportTest2);

        boolean result = instance.simulateIntermNodes(s.getFlightPlan(), timeStep, totalWeight, project.getAirNetwork().getSegmentFromNodes(startNode, endNode));
        assertEquals(expResult, result);
    }

    /**
     * Test of createResultsList method, of class Path.
     */
    @Test
    public void testCreateResultsList() {
        System.out.println("createResultsList");
        Path instance = new PathImpl();
        instance.createResultsList();
    }

    /**
     * Test of getListSegResults method, of class Path.
     */
    @Test
    public void testGetListSegResults() {
        System.out.println("getListSegResults");
        Path instance = new PathImpl();
        LinkedList<SegmentResult> expResult =new LinkedList<>();
        LinkedList<SegmentResult> result = instance.getListSegResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListSegResults method, of class Path.
     */
    @Test
    public void testSetListSegResults() {
        System.out.println("setListSegResults");
        LinkedList<SegmentResult> listSegResults = null;
        Path instance = new PathImpl();
        instance.setListSegResults(listSegResults);
    }
    
       
    private void createFlightPlan(Project project) throws FileNotFoundException{
     
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
        
        Motorization motorization=new Motorization(numberMotor, "hjgf","hjutr", 0, 0, 
                tsfc, lapseRate, thrustFunction);
        
         ImportAircraftModelListController cntg = new ImportAircraftModelListController(project);
         File file = new File("src/main/resources/TestSet02_Aircraft.xml");
        cntg.importXMLAircraftModelList(file);
       
       timeStep=120;
       Map<String, Integer> map = new HashMap<>();
       map.put("afd", 123);
       CabinConfiguration c = new CabinConfiguration(map);
       aircraft=new Aircraft("lol", "lol", c, 10, project.getAircraftModelList().getModelList().get(0));
       
       project.getAircraftList().getAircraftList().add(aircraft);
       airportTest=project.getAirportList().getAirportByString("LIS");
       airportTest2=project.getAirportList().getAirportByString("PDL");
     

//       flightPlan=new FlightPlan("test", timeStep, aircraft, airportTest, airportTest2, new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
       
       File filePatterns = new File("src/main/resources/Flight_pattern_A380_v1a.csv");
       AddFlightPlanController controller = new AddFlightPlanController(project);
       controller.pattern(filePatterns);
       
       
       Object[] technicalStops = new Object[0];
        Object[] mandatoryWaypoints = new Object[0];
        
       controller.setData("te6454", timeStep, aircraft.getRegistration(), airportTest.getIATA(), airportTest2.getIATA(),technicalStops,mandatoryWaypoints);
       controller.saveFlightPlan();
    }
    
    private void createProject() throws FileNotFoundException{
        project=new Project();
        String fileAircraft = "src/main/resources/TestSet02_Aircraft.xml";
        File file = new File(fileAircraft);
        
        ImportAircraftModelListController impAircraftModel=new ImportAircraftModelListController(project);
        impAircraftModel.importXMLAircraftModelList(file);
       
        
        String fileAirport = "src/main/resources/TestSet02_Airports.xml";
        File file2 = new File(fileAirport);
        
        ImportAirportController impAirport=new ImportAirportController(project);
        impAirport.importXMLAirportList(file2);
        
        String fileNet = "src/main/resources/TestSet02_Network.xml";
        File file3 = new File(fileNet);
        
        ImportNetworkController impNet=new ImportNetworkController(project);
        impNet.importXMLNetwork(file3);
    }

}
