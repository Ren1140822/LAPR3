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
import java.util.Map;
import lapr.project.controller.AddFlightPlanController;
import lapr.project.controller.ImportAircraftModelListController;
import lapr.project.controller.ImportAirportController;
import lapr.project.controller.ImportNetworkController;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.FlightPlan;
import lapr.project.model.Iten;
import lapr.project.model.Motorization;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.Thrust_Function;

/**
 *
 * @author DianaSilva
 */
public class ShortestPathResultTest {
    
    private Airport airportTest, airportTest2;
    private Aircraft aircraft;
    private int timeStep;
    
    public ShortestPathResultTest() {
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
     * Test of calculateBestPath method, of class ShortestPathResult.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testCalculateBestPath() throws FileNotFoundException {
        System.out.println("calculateBestPath");
        
         System.out.println("simulateInitialNode");
        Project project=new Project();
        
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
        
        createFlightPlan(project);
       
        Simulation s = new Simulation();
         s.setFlightPlan(project.getFlightList().getFlightList().get(0));
         s.setCargoLoad(70000);
         s.setFuelWeight(144720);
         
        double totalWeight= ((FlightPlan)project.getFlightList().getFlightList().get(0)).getAircraft().getAircraftModel().geteWeight()+70000+144720;
        
        Path instance = new EcologicPathResult(project.getFlightList().getFlightList().get(0));
        boolean expResult = true;
        
        Node startNode=project.getAirNetwork().getAirportNode(airportTest);
        Node endNode=project.getAirNetwork().getAirportNode(airportTest2);

        boolean result = instance.simulateInitialNode(s.getFlightPlan(), timeStep, totalWeight, project.getAirNetwork().getSegmentFromNodes(startNode, endNode));
        boolean result2 = instance.simulateEndNode(airportTest,airportTest2,s.getFlightPlan(), timeStep, totalWeight,project.getAirNetwork().getSegmentFromNodes(startNode, endNode));
        assertEquals(expResult, result);
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
        
       AircraftModel aircraftModel=new AircraftModel("gtrtgr", "jhygfjh", "kjgf", "passenger", 
                        motorization, eWeight, 0, 0, 0, 0,0, wingArea, 0, ar, e, listIten);
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

       File filePatterns = new File("src/main/resources/Flight_pattern_A380_v1a.csv");
       AddFlightPlanController controller = new AddFlightPlanController(project);
       controller.pattern(filePatterns);
       
       
       Object[] technicalStops = new Object[0];
        Object[] mandatoryWaypoints = new Object[0];
        
       controller.setData("te6454", timeStep, aircraft.getRegistration(), airportTest.getIATA(), airportTest2.getIATA(),technicalStops,mandatoryWaypoints);
       controller.saveFlightPlan();  
    }
    
}
