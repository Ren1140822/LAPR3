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
public class NodeTest {
    
    public NodeTest() {
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
     * Test of getId method, of class Node.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Node instance = new Node();
        instance.setId("idteste");
        String expResult = "idteste";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Node.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "teste";
        Node instance = new Node();
        instance.setId(id);
    }

    /**
     * Test of getLatitude method, of class Node.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        Node instance = new Node();
        instance.setLatitude(-49.80);
        double expResult = -49.80;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLatitude method, of class Node.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        double latitude = -49.80;
        Node instance = new Node();
        instance.setLatitude(latitude);
    }

    /**
     * Test of getLongitude method, of class Node.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        Node instance = new Node();
        instance.setLongitude(-85.051);
        double expResult = -85.051;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLongitude method, of class Node.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        double longitude = -32.098;
        Node instance = new Node();
        instance.setLongitude(longitude);
    }

    /**
     * Test of toString method, of class Node.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Node instance = new Node();
        String expResult = instance.getId();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Node.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new Node();
        Node instance = new Node();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Node.
     */
    @Test
    public void testValidate() {
        System.out.println("validate1");
        Node instance = new Node();
        instance.setId("");
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Node instance2 = new Node();
        instance2.setLatitude(-91);
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        Node instance3 = new Node();
        instance3.setLatitude(91);
        boolean expResult3 = false;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
        
        System.out.println("validate4");
        Node instance4 = new Node();
        instance4.setLongitude(-181);
        boolean expResult4 = false;
        boolean result4 = instance4.validate();
        assertEquals(expResult4, result4);
        
        System.out.println("validate5");
        Node instance5 = new Node();
        instance5.setLongitude(181);
        boolean expResult5 = false;
        boolean result5 = instance5.validate();
        assertEquals(expResult5, result5);
        
        System.out.println("validate6");
        Node instance6 = new Node();
        instance6.setId("idteste");
        instance6.setLatitude(45.054);
        instance6.setLongitude(175.6981);
        boolean expResult6 = true;
        boolean result6 = instance6.validate();
        assertEquals(expResult6, result6);
    }

    /**
     * Test of hashCode method, of class Node.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Node instance = new Node();
        int expResult = 1802867498;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}
