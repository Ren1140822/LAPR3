/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

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
        Segment instance = new Segment();
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
     * Test of getStartNode method, of class Segment.
     */
    @Test
    public void testGetStartNode() {
        System.out.println("getStartNode");
        Segment instance = new Segment();        
        Node expResult = new Node("id1", 2, 48.5);
        instance.setStartNode(expResult);
        Node result = instance.getStartNode();
        assertEquals(expResult, result);
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
     * Test of getEndNode method, of class Segment.
     */
    @Test
    public void testGetEndNode() {
        System.out.println("getEndNode");
        Segment instance = new Segment();
        Node expResult = new Node("id1", 2, 48.5);
        instance.setEndNode(expResult);
        Node result = instance.getEndNode();
        assertEquals(expResult, result);
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
        System.out.println("equals");
        Object otherObject = new Segment();
        Segment instance = new Segment();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Segment.
     */
    @Test
    public void testValidate() {
        System.out.println("validate1");
        Segment instance = new Segment("", new Node("id1",-91,90), new Node("id2", -9, 90), "direct", new Wind(15, 40));
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Segment instance2 = new Segment("seg01", new Node("id1",90,90), new Node("id2", -91, 90), "direct", new Wind(15, 40));
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        Segment instance3 = new Segment("s1", new Node("id1",-90,90), new Node("id2", -89, 90), "blbla", new Wind(15, 40));
        boolean expResult3 = false;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
        
        System.out.println("validate4");
        Segment instance4 = new Segment("s1", new Node("id1",-90,90), new Node("id2", -89, 90), "direct", new Wind(-15, 40));
        boolean expResult4 = false;
        boolean result4 = instance4.validate();
        assertEquals(expResult4, result4);
        
        System.out.println("validate5");
        Segment instance5 = new Segment("seg01", new Node("id1",-90,90), new Node("id2", 89, 90), "bidirectional", new Wind(15, 40));
        boolean expResult5 = true;
        boolean result5 = instance5.validate();
        assertEquals(expResult5, result5);
        
        System.out.println("validate6");
        Segment instance6 = new Segment("seg01", new Node("id1",-90,90), new Node("id1", -90, 90), "bidirectional", new Wind(15, 40));
        boolean expResult6 = false;
        boolean result6 = instance6.validate();
        assertEquals(expResult6, result6);
    }

    /**
     * Test of hashCode method, of class Segment.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Segment instance = new Segment();
        int expResult = 1060616918;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}
