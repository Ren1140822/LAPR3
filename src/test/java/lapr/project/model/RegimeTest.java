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
public class RegimeTest {
    
    public RegimeTest() {
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
     * Test of getId method, of class Regime.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Regime instance = new Regime();
        String expResult = "NOID";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Regime.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "abc";
        Regime instance = new Regime();
        instance.setId(id);
    }

    /**
     * Test of getTSFC method, of class Regime.
     */
    @Test
    public void testGetTSFC() {
        System.out.println("getTSFC");
        Regime instance = new Regime();
        double expResult = 1;
        double result = instance.getTSFC();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setTSFC method, of class Regime.
     */
    @Test
    public void testSetTSFC() {
        System.out.println("setTSFC");
        double TSFC = 10.0;
        Regime instance = new Regime();
        instance.setTSFC(TSFC);
    }

    /**
     * Test of getTSFC_ method, of class Regime.
     */
    @Test
    public void testGetTSFC_() {
        System.out.println("getTSFC_");
        Regime instance = new Regime();
        String expResult = "1.0";
        String result = instance.getTSFC_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTSFC_ method, of class Regime.
     */
    @Test
    public void testSetTSFC_() {
        System.out.println("setTSFC_");
        String tsfc = "0.5";
        Regime instance = new Regime();
        instance.setTSFC_(tsfc);
    }

    /**
     * Test of getSpeed method, of class Regime.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        Regime instance = new Regime();
        double expResult = 1;
        double result = instance.getSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setSpeed method, of class Regime.
     */
    @Test
    public void testSetSpeed() {
        System.out.println("setSpeed");
        double speed = 10.0;
        Regime instance = new Regime();
        instance.setSpeed(speed);
    }

    /**
     * Test of getSpeed_ method, of class Regime.
     */
    @Test
    public void testGetSpeed_() {
        System.out.println("getSpeed_");
        Regime instance = new Regime();
        String expResult = "1.0";
        String result = instance.getSpeed_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpeed_ method, of class Regime.
     */
    @Test
    public void testSetSpeed_() {
        System.out.println("setSpeed_");
        String sp = "1.5";
        Regime instance = new Regime();
        instance.setSpeed_(sp);
    }

    /**
     * Test of getThrust method, of class Regime.
     */
    @Test
    public void testGetThrust() {
        System.out.println("getThrust");
        Regime instance = new Regime();
        double expResult = 1;
        double result = instance.getThrust();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setThrust method, of class Regime.
     */
    @Test
    public void testSetThrust() {
        System.out.println("setThrust");
        double thrust = 0.40;
        Regime instance = new Regime();
        instance.setThrust(thrust);
    }

    /**
     * Test of getThrust_ method, of class Regime.
     */
    @Test
    public void testGetThrust_() {
        System.out.println("getThrust_");
        Regime instance = new Regime();
        String expResult = "1.0";
        String result = instance.getThrust_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setThrust_ method, of class Regime.
     */
    @Test
    public void testSetThrust_() {
        System.out.println("setThrust_");
        String th = "1.247";
        Regime instance = new Regime();
        instance.setThrust_(th);
    }

    /**
     * Test of getAltitude method, of class Regime.
     */
    @Test
    public void testGetAltitude() {
        System.out.println("getAltitude");
        Regime instance = new Regime();
        double expResult = 1;
        double result = instance.getAltitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAltitude method, of class Regime.
     */
    @Test
    public void testSetAltitude() {
        System.out.println("setAltitude");
        double altitude = 1;
        Regime instance = new Regime();
        instance.setAltitude(altitude);
    }

    /**
     * Test of getAltitude_ method, of class Regime.
     */
    @Test
    public void testGetAltitude_() {
        System.out.println("getAltitude_");
        Regime instance = new Regime();
        String expResult = "1.0";
        String result = instance.getAltitude_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAltitude_ method, of class Regime.
     */
    @Test
    public void testSetAltitude_() {
        System.out.println("setAltitude_");
        String alt = "1.5";
        Regime instance = new Regime();
        instance.setAltitude_(alt);
    }

    /**
     * Test of validate method, of class Regime.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Regime instance = new Regime("id", 1, 12, 12, 12);
        boolean expResult = true;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Regime instance2 = new Regime("id", -1, 12, 12, 12);
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        Regime instance3 = new Regime("id", 1, -12, 12, 12);
        boolean expResult3 = false;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
        
        System.out.println("validate4");
        Regime instance4 = new Regime("id", 1, 12, -12, 12);
        boolean expResult4 = false;
        boolean result4 = instance4.validate();
        assertEquals(expResult4, result4);
        
        System.out.println("validate5");
        Regime instance5 = new Regime("id", 1, 12, 12, -12);
        boolean expResult5 = false;
        boolean result5 = instance5.validate();
        assertEquals(expResult5, result5);
        
        System.out.println("validate6");
        Regime instance6 = new Regime("", 1, 12, 12, 12);
        boolean expResult6 = false;
        boolean result6 = instance6.validate();
        assertEquals(expResult6, result6);
    }
    
}
