/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.Airport;
import lapr.project.model.Location;
import lapr.project.model.Node;
import lapr.project.model.Project;
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
public class ResultPathTest {
    
    public ResultPathTest() {
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
     * Test of setResult method, of class ResultPath.
     */
    @Test
    public void testSetResult() {
        System.out.println("setResult");
        double result_2 = 0.0;
        ResultPath instance = new ResultPath();
        instance.setResult(result_2);
        assertEquals(instance.getResult(), result_2, 0.0);
    }

    /**
     * Test of setResultPath method, of class ResultPath.
     */
    @Test
    public void testSetResultPath() {
        System.out.println("setResultPath");
        LinkedList<Node> resultPath = new LinkedList<>();
        Node test=new Node("test",0,0);
        resultPath.add(test);
        ResultPath instance = new ResultPath();
        instance.setResultPath(resultPath);
        assertEquals(instance.getResultPath(), resultPath);
    }

    /**
     * Test of getResult method, of class ResultPath.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        ResultPath instance = new ResultPath();
        double expResult = 2.0;
        instance.setResult(expResult);  
        double result = instance.getResult();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getResultPath method, of class ResultPath.
     */
    @Test
    public void testGetResultPath() {
        System.out.println("getResultPath");
        LinkedList<Node> expResult = new LinkedList<>();
        Node test=new Node("test",0,0);
        expResult.add(test);
        
        ResultPath instance = new ResultPath(null, null, expResult, 0, 0, 0, 0);
   
        LinkedList<Node> result = (LinkedList<Node>) instance.getResultPath();
        assertEquals(expResult, result);
    }


    /**
     * Test of getStartNode method, of class ResultPath.
     */
    @Test
    public void testGetStartNode() {
        System.out.println("getStartNode");
        Node expResult=new Node("test1",20,0);
        Node node2=new Node("test2", 0,0);
        
        Project p=new Project();
        p.getAirNetwork().getNodeList().add(node2);
        p.getAirNetwork().getNodeList().add(expResult);
        
        Airport startAirport=new Airport("test","","","", new Location(20,0,0));
        Airport endAirport=new Airport("test2","","","", new Location(0,0,0));
        
        ResultPath instance = new ResultPath(startAirport, endAirport);
        Node result = instance.getStartNode(p.getAirNetwork());
        assertEquals(expResult, result);
    }

    /**
     * Test of setStartNode method, of class ResultPath.
     */
    @Test
    public void testSetStartNode() {
        System.out.println("setStartNode");
        Node expResult=new Node("test1",0,0);
        Airport airportResult=new Airport("","","","",new Location(0,0,0));
        Project p=new Project();
        p.getAirportList().getAirportList().add(airportResult);
        p.getAirNetwork().getNodeList().add(expResult);
        
        ResultPath instance = new ResultPath();
        instance.setStartNode(expResult, p.getAirportList());
        Node result = instance.getStartNode(p.getAirNetwork());
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndNode method, of class ResultPath.
     */
    @Test
    public void testGetEndNode() {
        System.out.println("getEndNode");
        Node expResult=new Node("test1",20,0);
        Node node2=new Node("test2", 10,0);
        
        Project p=new Project();
        p.getAirNetwork().getNodeList().add(node2);
        p.getAirNetwork().getNodeList().add(expResult);
        
        Airport startAirport=new Airport("test","","","", new Location(10,0,0));
        Airport endAirport=new Airport("test2","","","", new Location(20,0,0));
        
        ResultPath instance = new ResultPath(startAirport, endAirport);
        Node result = instance.getEndNode(p.getAirNetwork());
        assertEquals(expResult, result);
        assertEquals(expResult, result);
    }

    /**
     * Test of setEndNode method, of class ResultPath.
     */
    @Test
    public void testSetEndNode() {
        System.out.println("setEndNode");
        Node expResult=new Node("test1",10,0);
        Airport airportResult=new Airport("","","","",new Location(10,0,0));
        Project p=new Project();
        p.getAirportList().getAirportList().add(airportResult);
        p.getAirNetwork().getNodeList().add(expResult);
        
        ResultPath instance = new ResultPath();
        instance.setEndNode(expResult, p.getAirportList());
        Node result = instance.getEndNode(p.getAirNetwork());
        assertEquals(expResult, result);
    }

    /**
     * Test of getEnergyConsum method, of class ResultPath.
     */
    @Test
    public void testGetEnergyConsum() {
        System.out.println("getEnergyConsum");
        double expResult = 2.0;
        ResultPath instance = new ResultPath(null, null, null, 0, expResult, 0, 0);
        double result = instance.getEnergyConsum();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setEnergyConsum method, of class ResultPath.
     */
    @Test
    public void testSetEnergyConsum() {
        System.out.println("setEnergyConsum");
        double energyConsum = 2.0;
        ResultPath instance = new ResultPath();
        instance.setEnergyConsum(energyConsum);
        
        assertEquals(energyConsum, instance.getEnergyConsum(), 0.0);
    }

    /**
     * Test of getTravellingTime method, of class ResultPath.
     */
    @Test
    public void testGetTravellingTime() {
        System.out.println("getTravellingTime");
         double expResult = 2.0;
        ResultPath instance = new ResultPath(null, null, null, 0, 0, expResult, 0);
        double result = instance.getTravellingTime();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setTravellingTime method, of class ResultPath.
     */
    @Test
    public void testSetTravellingTime() {
        System.out.println("setTravellingTime");
         double travelling = 2.0;
        ResultPath instance = new ResultPath();
        instance.setTravellingTime(travelling);
        
        assertEquals(travelling, instance.getTravellingTime(), 0.0);
    }

    /**
     * Test of getDistance method, of class ResultPath.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        double expResult = 2.0;
        ResultPath instance = new ResultPath(null, null, null, expResult, 0, 0, 0);
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setDistance method, of class ResultPath.
     */
    @Test
    public void testSetDistance() {
        System.out.println("setDistance");
         double expResult = 2.0;
        ResultPath instance = new ResultPath();
        instance.setDistance(expResult);
        
        assertEquals(expResult, instance.getDistance(), 0.0);
    }

    /**
     * Test of getStartAirport method, of class ResultPath.
     */
    @Test
    public void testGetStartAirport() {
        System.out.println("getStartAirport");
      
        Location locationTest=new Location(1,1,1);
        Airport test1=new Airport("airportTest", "", "", "", locationTest);

        ResultPath instance=new ResultPath(test1, new Airport());
        Airport expResult = test1;
        Airport result = instance.getStartAirport();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndAirport method, of class ResultPath.
     */
    @Test
    public void testGetEndAirport() {
        System.out.println("getEndAirport");
         Location locationTest=new Location(1,1,1);
        Airport test1=new Airport("airportTest", "", "", "", locationTest);

        ResultPath instance=new ResultPath(new Airport(),test1);
        Airport expResult = test1;
        Airport result = instance.getEndAirport();
        assertEquals(expResult, result);
    }
      
    /**
     * Test of validate method, of class ResultPath.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        ResultPath instance = new ResultPath();
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateBestPath method, of class ResultPath.
     */
    @Test
    public void testCalculateBestPath() {
        System.out.println("calculateBestPath");
        AirNetwork airNetwork = null;
        ResultPath instance = new ResultPath();
        instance.calculateBestPath(airNetwork);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTravellingTime method, of class ResultPath.
     */
    @Test
    public void testCalculateTravellingTime() {
        System.out.println("calculateTravellingTime");
        ResultPath instance = new ResultPath();
        instance.calculateTravellingTime();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateEnergyConsumption method, of class ResultPath.
     */
    @Test
    public void testCalculateEnergyConsumption() {
        System.out.println("calculateEnergyConsumption");
        double initialWeight = 0.0;
        double timeFlight = 0.0;
        double tsfc = 0.0;
        double weightZeroFuel = 0.0;
        ResultPath instance = new ResultPath();
        instance.calculateEnergyConsumption(initialWeight, timeFlight, tsfc, weightZeroFuel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ResultPath.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = null;
        ResultPath instance = new ResultPath();
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ResultPath.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ResultPath instance = new ResultPath();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
