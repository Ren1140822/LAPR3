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
public class ItenTest {
    
    public ItenTest() {
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
     * Test of getSpeed method, of class Iten.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        Iten instance = new Iten();
        double expResult = 1.0;
        double result = instance.getSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setSpeed method, of class Iten.
     */
    @Test
    public void testSetSpeed() {
        System.out.println("setSpeed");
        double speed = 10.0;
        Iten instance = new Iten();
        instance.setSpeed(speed);
    }

    /**
     * Test of getSpeed_ method, of class Iten.
     */
    @Test
    public void testGetSpeed_() {
        System.out.println("getSpeed_");
        Iten instance = new Iten();
        String expResult = "1.0";
        String result = instance.getSpeed_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpeed_ method, of class Iten.
     */
    @Test
    public void testSetSpeed_() {
        System.out.println("setSpeed_");
        String speed = "0.75 M";
        Iten instance = new Iten();
        instance.setSpeed_(speed);
    }

    /**
     * Test of getCdrag_0 method, of class Iten.
     */
    @Test
    public void testGetCdrag_0() {
        System.out.println("getCdrag_0");
        Iten instance = new Iten();
        double expResult = 1.0;
        double result = instance.getCdrag_0();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCdrag_0 method, of class Iten.
     */
    @Test
    public void testSetCdrag_0() {
        System.out.println("setCdrag_0");
        double Cdrag_0 = 0.017;
        Iten instance = new Iten();
        instance.setCdrag_0(Cdrag_0);
    }

    /**
     * Test of validate method, of class Iten.
     */
    @Test
    public void testValidate() {
        System.out.println("validate1");
        Iten instance = new Iten(-1, 0);
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Iten instance2 = new Iten(1, 0);
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        Iten instance3 = new Iten(1, 10);
        boolean expResult3 = true;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
    }
    
}
