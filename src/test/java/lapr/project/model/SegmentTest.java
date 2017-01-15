/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pedro Fernandes
 */
public class SegmentTest {
    
    public SegmentTest() {
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
     * Test of getId method, of class Segment.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Segment instance = new Segment(new Segment());
        instance.setId("teste");
        String expResult = "teste";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Segment.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "teste";
        Segment instance = new Segment();
        instance.setId(id);
    }

    /**
     * Test of setStartNode method, of class Segment.
     */
    @Test
    public void testSetStartNode() {
        System.out.println("setStartNode");
        Node startNode = new Node("id1", 2, 48.5);
        Segment instance = new Segment();
        instance.setStartNode(startNode);
    }

    /**
     * Test of setEndNode method, of class Segment.
     */
    @Test
    public void testSetEndNode() {
        System.out.println("setEndNode");
        Node endNode = new Node("id1", 2, 48.5);
        Segment instance = new Segment();
        instance.setEndNode(endNode);
    }

    /**
     * Test of getDirection method, of class Segment.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        Segment instance = new Segment();
        instance.setDirection("bidirectional");
        Segment.Direction expResult = Segment.Direction.BIDIRECTIONAL;
        Segment.Direction result = instance.getDirection();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDirection method, of class Segment.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");
        String direction = "bidirectional";
        Segment instance = new Segment();
        instance.setDirection(direction);
    }

    /**
     * Test of getWind method, of class Segment.
     */
    @Test
    public void testGetWind() {
        System.out.println("getWind");
        Segment instance = new Segment();
        int windIntensity = 45;
        int windDirection = 16;
        Wind expResult = new Wind(windIntensity, windDirection);
        instance.setWind(windIntensity, windDirection);
        Wind result = instance.getWind();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWind method, of class Segment.
     */
    @Test
    public void testSetWind() {
        System.out.println("setWind");
        int windIntensity = 45;
        int windDirection = 16;
        Segment instance = new Segment();
        instance.setWind(windIntensity, windDirection);
    }

    /**
     * Test of toString method, of class Segment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Segment instance = new Segment();
        String expResult = instance.getId();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Segment.
     */
    @Test
    public void testEquals() {
        System.out.println("equals1");
        Object otherObject = new Segment();
        Segment instance = new Segment();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("equals2");
        Object otherObject2 = new Segment();
        Segment instance2 =new Segment("", new Node("a", 10, 0), new Node(), "direct", 
                new Wind(15, 40),10,0);
        boolean expResult2 = false;
        boolean result2 = instance2.equals(otherObject2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of hashCode method, of class Segment.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Segment instance = new Segment();
        int expResult = 0;
        int result = instance.hashCode();
        assertNotEquals(expResult, result);
    }
    
    /**
     * Test of validate method, of class Segment.
     */
    @Test
    public void testValidate() {
        Node n1 = new Node("id1",-91,90);
        Node n2 = new Node("id2", -9, 90);
        Node n3 = new Node("id3",-91,90);
        Node n4 = new Node("id4",-89,90);
        Node n5 = new Node("id5",-11,90);
        Node n6 = new Node("id6",-91,90);
        Node n7 = new Node("id7",-91,90);
        
        System.out.println("validate1");
        Segment instance = new Segment("", n1, n2, "direct", new Wind(15, 40),0,0);
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Segment instance2 = new Segment("seg01", n5, n5, "bidirectional", new Wind(15, 40),0,0);
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        Segment instance3 = new Segment("s1",n1, n4, "blbla", new Wind(15, 40),0,0);
        boolean expResult3 = false;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
        
        System.out.println("validate4");
        Segment instance4 = new Segment("s1", n5, n3, "direct", new Wind(-15, 40),0,0);
        boolean expResult4 = false;
        boolean result4 = instance4.validate();
        assertEquals(expResult4, result4);
        
        System.out.println("validate5");
        Segment instance5 = new Segment("seg01", n5, n3, "bidirectional", new Wind(15, 40),0,0);
        boolean expResult5 = true;
        boolean result5 = instance5.validate();
        assertEquals(expResult5, result5);
        
       
    }

    /**
     * Test of getStartNode method, of class Segment.
     */
    @Test
    public void testGetStartNode() {
        System.out.println("getStartNode");
        Segment instance = new Segment();
        Node expResult = new Node();
        instance.setStartNode(expResult);
        Node result = instance.getStartNode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndNode method, of class Segment.
     */
    @Test
    public void testGetEndNode() {
        System.out.println("getEndNode");
        Segment instance = new Segment();
        Node expResult = new Node();
        instance.setEndNode(expResult);
        Node result = instance.getEndNode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinAltSlot method, of class Segment.
     */
    @Test
    public void testGetMinAltSlot() {
        System.out.println("getMinAltSlot");
        Segment instance = new Segment();
        int expResult = 0;
        int result = instance.getMinAltSlot();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMinAltSlot method, of class Segment.
     */
    @Test
    public void testSetMinAltSlot() {
        System.out.println("setMinAltSlot");
        int minAltSlot = 1000;
        Segment instance = new Segment();
        instance.setMinAltSlot(minAltSlot);
    }

    /**
     * Test of getMaxAltSlot method, of class Segment.
     */
    @Test
    public void testGetMaxAltSlot() {
        System.out.println("getMaxAltSlot");
        Segment instance = new Segment();
        int expResult = 0;
        int result = instance.getMaxAltSlot();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxAltSlot method, of class Segment.
     */
    @Test
    public void testSetMaxAltSlot() {
        System.out.println("setMaxAltSlot");
        int maxAltSlot = 12000;
        Segment instance = new Segment();
        instance.setMaxAltSlot(maxAltSlot);
    }

    /**
     * Test of getStartNode_ method, of class Segment.
     */
    @Test
    public void testGetStartNode_() {
        System.out.println("getStartNode_");
        Segment instance = new Segment();
        Node startNode=new Node();
        instance.setStartNode(startNode);

        String expResult = startNode.getId();
        String result = instance.getStartNode_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStartNode_ method, of class Segment.
     */
    @Test
    public void testSetStartNode_() {
        System.out.println("setStartNode_");
        String startNodeid = "iji";
        Segment instance = new Segment();
        instance.setStartNode_(startNodeid);
    }

    /**
     * Test of getEndNode_ method, of class Segment.
     */
    @Test
    public void testGetEndNode_() {
        System.out.println("getEndNode_");
        Segment instance = new Segment();
        Node endNode=new Node();
        instance.setEndNode(endNode);
        String expResult = endNode.getId();
        String result = instance.getEndNode_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEndNode_ method, of class Segment.
     */
    @Test
    public void testSetEndNode_() {
        System.out.println("setEndNode_");
        String endNodeid = "";
        Segment instance = new Segment();
        instance.setEndNode_(endNodeid);
    }
    
}
