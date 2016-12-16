/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.MapGraph.Graph;
import lapr.project.model.lists.NodeList;
import lapr.project.model.lists.SegmentList;
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
public class AirNetworkTest {
    
    public AirNetworkTest() {
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
     * Test of getNodeList method, of class AirNetwork.
     */
    @Test
    public void testGetNodeList() {
        System.out.println("getNodeList");
        AirNetwork instance = new AirNetwork();
        NodeList expResult = null; //Project.airNetwork;
        expResult.newNode();
        expResult.setNode("testenode", 50, 40);
        expResult.saveNode();
        NodeList result = instance.getNodeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSegmentList method, of class AirNetwork.
     */
    @Test
    public void testGetSegmentList() {
        System.out.println("getSegmentList");
        AirNetwork instance = new AirNetwork();
        SegmentList expResult = new SegmentList();
        SegmentList result = instance.getSegmentList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAirNetwork method, of class AirNetwork.
     */
    @Test
    public void testGetAirNetwork() {
        System.out.println("getAirNetwork");
        AirNetwork instance = new AirNetwork();
        Graph<Node, Segment> expResult = new Graph<>(true);
        Graph<Node, Segment> result = instance.getAirNetwork();
        assertEquals(expResult, result);
    }

    /**
     * Test of generateGraph method, of class AirNetwork.
     */
    @Test
    public void testGenerateGraph() {
        System.out.println("generateGraph");
        AirNetwork instance = new AirNetwork();
        boolean expResult = false;
        boolean result = instance.generateGraph();
        assertEquals(expResult, result);
        
        
        System.out.println("generateGraph2");
        AirNetwork instance2 = new AirNetwork();
        
        instance2.nodeList.newNode();
        instance2.nodeList.setNode("id1",-90,90);
        instance2.nodeList.saveNode();        
        instance2.nodeList.newNode();
        instance2.nodeList.setNode("id2", -90, 90);
        instance2.nodeList.saveNode();
        

        instance2.segmentList.newSegment();
        instance2.segmentList.setSegment("seg01", new Node("id1",-90,90), 
                new Node("id1", -90, 90), "bidirectional", 15, 40);
        instance2.segmentList.saveSegment();
        instance2.segmentList.newSegment();
        instance2.segmentList.setSegment("seg01", new Node("id1",-90,90), 
                new Node("id2", -90, 90), "bidirectional", 15, 40);
        instance2.segmentList.saveSegment();


        
        boolean expResult2 = true;
        boolean result2 = instance2.generateGraph();
        assertEquals(expResult2, result2);
        System.out.println(instance2.toString());
    }

    /**
     * Test of toString method, of class AirNetwork.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AirNetwork instance = new AirNetwork();
        Graph<Node, Segment> airNetwork = new Graph<>(true);
        String expResult = airNetwork.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
