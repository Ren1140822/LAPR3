/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.List;

import lapr.project.model.mapgraph.Graph;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pedro Fernandes, Diana Silva
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
     * Test of getAirNetwork method, of class AirNetwork.
     */
    @Test
    public void testGetAirNetwork() {
        System.out.println("getAirNetwork");
        Project p = new Project();
        AirNetwork instance = p.getAirNetwork();
        Graph<Node, Segment> expResult = instance.getAirNetwork();        
        Graph<Node, Segment> result = instance.getAirNetwork();
        assertEquals(expResult, result);
    }

    /**
     * Test of generateGraph method, of class AirNetwork.
     */
    @Test
    public void testGenerateGraph() {
        Project p = new Project();
        System.out.println("generateGraph");
        AirNetwork instance = p.getAirNetwork();
        boolean expResult = false;
        boolean result = instance.generateGraph();
        assertEquals(expResult, result);
        
        
        System.out.println("generateGraph2");
        AirNetwork instance2 = new AirNetwork();
        
        instance2.setNode("id1",-40,90);
        instance2.saveNode();        
        instance2.setNode("id2", -50, 90);
        instance2.saveNode();
        instance2.setNode("id3", -90, 40);
        instance2.saveNode();
        instance2.setNode("id4", -90, 50);
        instance2.saveNode();
        
        instance2.setSegment("seg01", "id1", 
                "id2", "bidirectional", 15, 40);
        instance2.saveSegment();
        instance2.setSegment("seg02", "id1", 
                "id3", "bidirectional", 15, 40);
        instance2.saveSegment();

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
        Project p = new Project();
        AirNetwork instance = p.getAirNetwork();
        Graph<Node, Segment> airNetwork = new Graph<>(true);
        String expResult = airNetwork.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class AirNetwork.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        AirNetwork instance = new AirNetwork();
        String expResult = "NoID";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class AirNetwork.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "ID";
        AirNetwork instance = new AirNetwork();
        instance.setId(id);
    }

    /**
     * Test of getDescription method, of class AirNetwork.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        AirNetwork instance = new AirNetwork();
        String expResult = "NoDescription";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class AirNetwork.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "sfd";
        AirNetwork instance = new AirNetwork();
        instance.setDescription(description);
    }

    /**
     * Test of setNode method, of class AirNetwork.
     */
    @Test
    public void testSetNode() {
        System.out.println("setNode");
        String id = "a";
        double latitude = 0.0;
        double longitude = 0.0;
        AirNetwork instance = new AirNetwork();
        instance.setNode(id, latitude, longitude);
    }

    /**
     * Test of saveNode method, of class AirNetwork.
     */
    @Test
    public void testSaveNode() {
        System.out.println("saveNode");
        AirNetwork instance = new AirNetwork();
        instance.setNode("a", 0, 0);
        boolean expResult = true;
        boolean result = instance.saveNode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegment method, of class AirNetwork.
     */
    @Test
    public void testSetSegment() {
        System.out.println("setSegment");
        String id = "a";
        Node startNode = new Node("a", 0, 0);
        Node endNode = new Node("b",1,1);
        String direction = "bidirectional";
        int windIntensity = 0;
        int windDirection = 0;
        AirNetwork instance = new AirNetwork();
        instance.setSegment(id, startNode.getId(), endNode.getId(), direction, windIntensity, windDirection);
    }

    /**
     * Test of saveSegment method, of class AirNetwork.
     */
    @Test
    public void testSaveSegment() {
        System.out.println("saveSegment");
        AirNetwork instance = new AirNetwork();
        String id = "a";
        Node startNode = new Node("a", 0, 0);
        Node endNode = new Node("b",1,1);
        String direction = "bidirectional";
        int windIntensity = 10;
        int windDirection = 10;
        instance.setSegment(id, startNode.getId(), endNode.getId(), direction, windIntensity, windDirection);
        boolean expResult = true;
        boolean result = instance.saveSegment();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSegmentList method, of class AirNetwork.
     */
    @Test
    public void testGetSegmentList() {
        System.out.println("getSegmentList");
        AirNetwork instance = new AirNetwork();
        List<Segment> expResult = new LinkedList<>();
        instance.setSegmentList(expResult);
        List<Segment> result = instance.getSegmentList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegmentList method, of class AirNetwork.
     */
    @Test
    public void testSetSegmentList() {
        System.out.println("setSegmentList");
        List<Segment> list = new LinkedList<>();
        AirNetwork instance = new AirNetwork();
        instance.setSegmentList(list);
    }

    /**
     * Test of getNodeList method, of class AirNetwork.
     */
    @Test
    public void testGetNodeList() {
        System.out.println("getNodeList");
        AirNetwork instance = new AirNetwork();
        List<Node> expResult = new LinkedList<>();
        instance.setNodeList(expResult);
        List<Node> result = instance.getNodeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNodeList method, of class AirNetwork.
     */
    @Test
    public void testSetNodeList() {
        System.out.println("setNodeList");
        List<Node> list = new LinkedList<>();
        AirNetwork instance = new AirNetwork();
        instance.setNodeList(list);
    }

    /**
     * Test of getNodeByString method, of class AirNetwork.
     */
    @Test
    public void testGetNodeByString() {
        System.out.println("getNodeByString1");
        String id = "";
        AirNetwork instance = new AirNetwork();
        Node expResult = new Node("id1",45,12);
        instance.getNodeList().add(expResult);
        Node result = instance.getNodeByString(id);
        assertNotEquals(expResult, result);
        
        System.out.println("getNodeByString2");
        String id2 = "id1";
        AirNetwork instance2 = new AirNetwork();
        Node expResult2 = new Node("id1",45,12);
        instance2.getNodeList().add(expResult);
        Node result2 = instance2.getNodeByString(id2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getPossibleEndNodes method, of class AirNetwork.
     */
    @Test
    public void testGetPossibleEndNodes() {
        System.out.println("getPossibleEndNodes");
        Node startNode=new Node("test1", 40, 40);
        Node intNode=new Node("test2", 50, 70);
        Node endNode=new Node("test3", 40, 80);
        Node testNode1=new Node("test4", 40,30);
        Node testNode=new Node("test5", 40, 90);
        
        Wind windTest=new Wind(10,10);
        String direction="BIDIRECTIONAL";
        Segment segment1=new Segment("segmentTest1","test1", "test3", direction,windTest,0,0);       
        Segment segment2=new Segment("segmentTest2", "test1", "test2", direction,windTest,0,0);
        Segment segment3=new Segment("segmentTest3", "test2", "test3", direction, windTest,0,0);
        Segment segment4=new Segment("segmentTest4", "test4", "test5", direction, windTest,0,0);
        
        AirNetwork instance=new AirNetwork();
        instance.getAirNetwork().insertVertex(startNode);
        instance.getAirNetwork().insertVertex(intNode);
        instance.getAirNetwork().insertVertex(endNode);
        instance.getAirNetwork().insertVertex(testNode);
        instance.getAirNetwork().insertVertex(testNode1);

        instance.getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        instance.getAirNetwork().insertEdge(intNode, endNode, segment3, 30);
        instance.getAirNetwork().insertEdge(startNode, endNode, segment1, 20); 
        instance.getAirNetwork().insertEdge(testNode1, testNode, segment4, 5);
        //falta verificar range
        
        LinkedList<Node> result=new LinkedList<>();
        result.add(startNode);
        result.add(intNode);
        result.add(endNode);
       
        assertEquals(instance.getPossibleEndNodes(startNode), result);
    }

    /**
     * Test of getAirportNode method, of class AirNetwork.
     */
    @Test
    public void testGetAirportNode() {
        System.out.println("getAirportNode");
        AirNetwork instance = new AirNetwork();
        
        Node nodeTest1=new Node("test1", 10, 30);
        Node nodeTest2=new Node("test2", 10, 20);
        Node nodeTest3=new Node("test3", 40, 20);
       
        instance.getNodeList().add(nodeTest1);
        instance.getNodeList().add(nodeTest2);
        instance.getNodeList().add(nodeTest3);
        
        Airport airportTest=new Airport("", "", "", "", new Location(10,20,10));
        
        Node expResult = nodeTest2;
        Node result = instance.getAirportNode(airportTest);
        assertEquals(expResult, result);
    }


}
