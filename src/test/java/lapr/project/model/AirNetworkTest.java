/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.mapgraph.Graph;
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
        AirNetwork instance = Project.network;
        NodeList expResult = Project.network.getNodeList();
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
        AirNetwork instance = Project.network;
        SegmentList expResult = Project.network.getSegmentList();
        expResult.newSegment();
        expResult.setSegment("seg01", new Node("id1",-90,90), new Node("id2", 89, 90), "bidirectional", 15, 40);
        expResult.saveSegment();
        SegmentList result = instance.getSegmentList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAirNetwork method, of class AirNetwork.
     */
    @Test
    public void testGetAirNetwork() {
        System.out.println("getAirNetwork");
        AirNetwork instance = Project.network;
        Graph<Node, Segment> expResult = instance.getAirNetwork();        
        Graph<Node, Segment> result = instance.getAirNetwork();
        assertEquals(expResult, result);
    }

    /**
     * Test of generateGraph method, of class AirNetwork.
     */
    @Test
    public void testGenerateGraph() {
        System.out.println("generateGraph");
        AirNetwork instance = Project.network;
        boolean expResult = true;
        boolean result = instance.generateGraph();
        assertEquals(expResult, result);
        
        
        System.out.println("generateGraph2");
        AirNetwork instance2 = new AirNetwork();
        
        instance2.getNodeList().newNode();
        instance2.getNodeList().setNode("id1",-90,90);
        instance2.getNodeList().saveNode();        
        instance2.getNodeList().newNode();
        instance2.getNodeList().setNode("id2", -90, 90);
        instance2.getNodeList().saveNode();
        

        instance2.getSegmentList().newSegment();
        instance2.getSegmentList().setSegment("seg01", new Node("id1",-90,90), 
                new Node("id1", -90, 90), "bidirectional", 15, 40);
        instance2.getSegmentList().saveSegment();
        instance2.getSegmentList().newSegment();
        instance2.getSegmentList().setSegment("seg01", new Node("id1",-90,90), 
                new Node("id2", -90, 90), "bidirectional", 15, 40);
        instance2.getSegmentList().saveSegment();


        
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
        AirNetwork instance = Project.network;
        Graph<Node, Segment> airNetwork = new Graph<>(true);
        String expResult = airNetwork.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNodeList method, of class AirNetwork.
     */
    @Test
    public void testSetNodeList() {
        System.out.println("setNodeList");
        NodeList list = new NodeList();
        list.newNode();
        list.setNode("a", 0, 0);
        list.saveNode();
        AirNetwork instance = new AirNetwork();
        instance.setNodeList(list);
    }

    /**
     * Test of setSegmentList method, of class AirNetwork.
     */
    @Test
    public void testSetSegmentList() {
        System.out.println("setSegmentList");
        SegmentList list = new SegmentList();
        list.newSegment();
        list.setSegment("seg01", new Node("id1",-90,90), 
                new Node("id1", -90, 90), "bidirectional", 15, 40);
        list.saveSegment();
        AirNetwork instance = new AirNetwork();
        instance.setSegmentList(list);
    }
    
}
