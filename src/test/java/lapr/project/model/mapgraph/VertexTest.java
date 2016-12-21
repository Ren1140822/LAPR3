/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mapgraph;

import java.util.LinkedHashMap;
import lapr.project.model.Node;
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
public class VertexTest {
    
    public VertexTest() {
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
     * Test of getKey method, of class Vertex.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        Vertex instance = new Vertex();
        int expResult = -1;
        int result = instance.getKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKey method, of class Vertex.
     */
    @Test
    public void testSetKey() {
        System.out.println("setKey");
        int k = 12;
        Vertex instance = new Vertex();
        instance.setKey(k);
    }

    /**
     * Test of getElement method, of class Vertex.
     */
    @Test
    public void testGetElement() {
        System.out.println("getElement");
        Vertex instance = new Vertex();
        Object expResult = null;
        Object result = instance.getElement();
        assertEquals(expResult, result);
    }

    /**
     * Test of setElement method, of class Vertex.
     */
    @Test
    public void testSetElement() {
        System.out.println("setElement");
        Object vInf = new Node();
        Vertex instance = new Vertex();
        instance.setElement(vInf);
    }

    /**
     * Test of addAdjVert method, of class Vertex.
     */
    @Test
    public void testAddAdjVert() {
        System.out.println("addAdjVert");
        Vertex instance = new Vertex();
        instance.addAdjVert(this, new Edge());
    }

    /**
     * Test of remAdjVert method, of class Vertex.
     */
    @Test
    public void testRemAdjVert() {
        System.out.println("remAdjVert");
        Object vAdj = null;
        Vertex instance = new Vertex();
        instance.remAdjVert(vAdj);
    }

    /**
     * Test of numAdjVerts method, of class Vertex.
     */
    @Test
    public void testNumAdjVerts() {
        System.out.println("numAdjVerts");
        Vertex instance = new Vertex();
        int expResult = 0;
        int result = instance.numAdjVerts();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Vertex.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObj = null;
        Vertex instance = new Vertex();
        boolean expResult = false;
        boolean result = instance.equals(otherObj);
        assertEquals(expResult, result);
    }
}
