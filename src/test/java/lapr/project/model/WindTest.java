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
public class WindTest {
    
    public WindTest() {
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
     * Test of getWindIntensity method, of class Wind.
     */
    @Test
    public void testGetWindIntensity() {
        System.out.println("getWindIntensity");
        Wind instance = new Wind(new Wind());
        instance.setWindIntensity(90);
        int expResult = 90;
        int result = instance.getWindIntensity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWindIntensity method, of class Wind.
     */
    @Test
    public void testSetWindIntensity() {
        System.out.println("setWindIntensity");
        int windIntensity = 90;
        Wind instance = new Wind();
        instance.setWindIntensity(windIntensity);
    }

    /**
     * Test of getWindDirection method, of class Wind.
     */
    @Test
    public void testGetWindDirection() {
        System.out.println("getWindDirection");
        Wind instance = new Wind();
        instance.setWindDirection(20);
        int expResult = 20;
        int result = instance.getWindDirection();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWindDirection method, of class Wind.
     */
    @Test
    public void testSetWindDirection() {
        System.out.println("setWindDirection");
        int windDirection = 20;
        Wind instance = new Wind();
        instance.setWindDirection(windDirection);
    }

    /**
     * Test of toString method, of class Wind.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Wind instance = new Wind();
        String expResult = instance.getWindDirection() + " <-> " + instance.getWindIntensity();;
        String result = instance.toString();
        assertEquals(expResult, result);   
    }

    /**
     * Test of equals method, of class Wind.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new Wind();
        Wind instance = new Wind();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Wind.
     */
    @Test
    public void testValidate() {
        System.out.println("validate1");
        Wind instance = new Wind();
        boolean expResult = true;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Wind instance2 = new Wind();
        instance2.setWindDirection(45);
        instance2.setWindIntensity(20);
        boolean expResult2 = true;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        Wind instance3 = new Wind();
        instance3.setWindDirection(-245);
        instance3.setWindIntensity(20);
        boolean expResult3 = false;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
        
        System.out.println("validate4");
        Wind instance4 = new Wind();
        instance4.setWindDirection(45);
        instance4.setWindIntensity(-1);
        boolean expResult4 = false;
        boolean result4 = instance4.validate();
        assertEquals(expResult4, result4);
        
        System.out.println("validate5");
        Wind instance5 = new Wind();
        instance5.setWindDirection(245);
        instance5.setWindIntensity(20);
        boolean expResult5 = false;
        boolean result5 = instance5.validate();
        assertEquals(expResult5, result5);
    }

    /**
     * Test of hashCode method, of class Wind.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Wind instance = new Wind();
        int expResult = 6627;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}
