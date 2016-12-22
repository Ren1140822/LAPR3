/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mapgraph;

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
 * @author Pedro Fernandes
 */
public class EdgeTest {
    
    public EdgeTest() {
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
     * Test of getElement method, of class Edge.
     */
    @Test
    public void testGetElement() {
        System.out.println("getElement");
        Edge instance = new Edge();
        Object expResult = new Segment();
        instance.setElement(expResult);
        Object result = instance.getElement();
        assertEquals(expResult, result);
    }

    /**
     * Test of setElement method, of class Edge.
     */
    @Test
    public void testSetElement() {
        System.out.println("setElement");
        Object eInf = new Segment();
        Edge instance = new Edge();
        instance.setElement(eInf);
    }

    /**
     * Test of getWeight method, of class Edge.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Edge instance = new Edge();
        double expResult = 0.0;
        double result = instance.getWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setWeight method, of class Edge.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        double ew = 0.0;
        Edge instance = new Edge();
        instance.setWeight(ew);
    }

    /**
     * Test of getVOrig method, of class Edge.
     */
    @Test
    public void testGetVOrig() {
        System.out.println("getVOrig");
        Edge instance = new Edge();
        Object expResult = new Node();
        Vertex vd = new Vertex(0, expResult);
        instance.setVOrig(vd);
        Object result = instance.getVOrig();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVOrig method, of class Edge.
     */
    @Test
    public void testSetVOrig() {
        System.out.println("setVOrig");
        Edge instance = new Edge();
        instance.setVOrig(new Vertex());
    }

    /**
     * Test of getVDest method, of class Edge.
     */
    @Test
    public void testGetVDest() {
        System.out.println("getVDest");
        Edge instance = new Edge();
        Object expResult = new Node();
        Vertex vd = new Vertex(0, expResult);
        instance.setVDest(vd);
        Object result = instance.getVDest();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVDest method, of class Edge.
     */
    @Test
    public void testSetVDest() {
        System.out.println("setVDest");
        Edge instance = new Edge();
        instance.setVDest(new Vertex());
    }

    /**
     * Test of compareTo method, of class Edge.
     */
    @Test
    public void testCompareTo() {
        
        Vertex vd1 = new Vertex(0, new Node("id1", 2, 0));
        Vertex vd2 = new Vertex(1, new Node("id2", 20, 0));
        
        System.out.println("compareTo1");
        Object otherObject = new Edge();
        Edge instance = new Edge();
        int expResult = 0;
        int result = instance.compareTo(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("compareTo2");
        Object otherObject2 = new Edge(new Node(), 20, vd1, vd2);
        Edge instance2 = new Edge();
        int expResult2 = -1;
        int result2 = instance2.compareTo(otherObject2);
        assertEquals(expResult2, result2);
        
        System.out.println("compareTo3");
        Object otherObject3 = new Edge();
        Edge instance3 = new Edge(new Node(), 20, vd1, vd2);
        int expResult3 = 1;
        int result3 = instance3.compareTo(otherObject3);
        assertEquals(expResult3, result3);
    }

    
}
