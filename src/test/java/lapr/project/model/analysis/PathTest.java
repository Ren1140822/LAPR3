/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AirNetwork;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.Segment;
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
        double result_2 = 0.0;
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
        FlightPlan flightPlan=new FlightPlan();
        EcologicPathResult instance = new EcologicPathResult(flightPlan);
        instance.setResultPath(resultPath);
    }

    /**
     * Test of getResult method, of class Path.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        FlightPlan flightPlan=new FlightPlan();
        EcologicPathResult instance = new EcologicPathResult(flightPlan);
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
        FlightPlan flightPlan=new FlightPlan();
        LinkedList<Node> expResult=new LinkedList<>();
        EcologicPathResult instance = new EcologicPathResult(flightPlan);
        instance.setResultPath(expResult);
        List<Node> result = instance.getResultPath();
        assertEquals(expResult, result);
    }

}
