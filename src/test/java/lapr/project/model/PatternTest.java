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
public class PatternTest {
    
    public PatternTest() {
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
     * Test of getAltitude method, of class Pattern.
     */
    @Test
    public void testGetAltitude() {
        System.out.println("getAltitude");
        Pattern instance = new Pattern();
        double expResult = 0.0;
        double result = instance.getAltitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAltitude method, of class Pattern.
     */
    @Test
    public void testSetAltitude() {
        System.out.println("setAltitude");
        double altitude = 10.0;
        Pattern instance = new Pattern();
        instance.setAltitude(altitude);
    }

    /**
     * Test of getvClimb method, of class Pattern.
     */
    @Test
    public void testGetvClimb() {
        System.out.println("getvClimb");
        Pattern instance = new Pattern();
        double expResult = 0.0;
        double result = instance.getvClimb();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setvClimb method, of class Pattern.
     */
    @Test
    public void testSetvClimb() {
        System.out.println("setvClimb");
        double vClimb = 10.0;
        Pattern instance = new Pattern();
        instance.setvClimb(vClimb);
    }

    /**
     * Test of getvDesc method, of class Pattern.
     */
    @Test
    public void testGetvDesc() {
        System.out.println("getvDesc");
        Pattern instance = new Pattern();
        double expResult = 0.0;
        double result = instance.getvDesc();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setvDesc method, of class Pattern.
     */
    @Test
    public void testSetvDesc() {
        System.out.println("setvDesc");
        double vDesc = 10.0;
        Pattern instance = new Pattern();
        instance.setvDesc(vDesc);
    }

    /**
     * Test of toString method, of class Pattern.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Pattern instance = new Pattern();
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
