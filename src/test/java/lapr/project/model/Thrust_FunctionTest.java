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
public class Thrust_FunctionTest {
    
    public Thrust_FunctionTest() {
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
     * Test of getThrust_0 method, of class Thrust_Function.
     */
    @Test
    public void testGetThrust_0() {
        System.out.println("getThrust_0");
        Thrust_Function instance = new Thrust_Function();
        instance.setThrust_0(12);
        double expResult = 12.0;
        double result = instance.getThrust_0();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setThrust_0 method, of class Thrust_Function.
     */
    @Test
    public void testSetThrust_0() {
        System.out.println("setThrust_0");
        double thrust_0 = 10.0;
        Thrust_Function instance = new Thrust_Function();
        instance.setThrust_0(thrust_0);
    }

    /**
     * Test of getThrust_0_ method, of class Thrust_Function.
     */
    @Test
    public void testGetThrust_0_() {
        System.out.println("getThrust_0_");
        Thrust_Function instance = new Thrust_Function();
        instance.setThrust_0_("12 SI");
        String expResult = "12.0";
        String result = instance.getThrust_0_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setThrust_0_ method, of class Thrust_Function.
     */
    @Test
    public void testSetThrust_0_() {
        System.out.println("setThrust_0_");
        String thrust_0 = "4.89E+05 SI";
        Thrust_Function instance = new Thrust_Function();
        instance.setThrust_0_(thrust_0);
    }

    /**
     * Test of getMaxSpeed method, of class Thrust_Function.
     */
    @Test
    public void testGetMaxSpeed() {
        System.out.println("getMaxSpeed");
        Thrust_Function instance = new Thrust_Function();
        instance.setMaxSpeed(13);
        double expResult = 13.0;
        double result = instance.getMaxSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setMaxSpeed method, of class Thrust_Function.
     */
    @Test
    public void testSetMaxSpeed() {
        System.out.println("setMaxSpeed");
        double max_speed = 10.0;
        Thrust_Function instance = new Thrust_Function();
        instance.setMaxSpeed(max_speed);
    }

    /**
     * Test of getMaxSpeed_ method, of class Thrust_Function.
     */
    @Test
    public void testGetMaxSpeed_() {
        System.out.println("getMaxSpeed_");
        Thrust_Function instance = new Thrust_Function();
        instance.setMaxSpeed_("1 M");
        String expResult = "343.2";
        String result = instance.getMaxSpeed_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxSpeed_ method, of class Thrust_Function.
     */
    @Test
    public void testSetMaxSpeed_() {
        System.out.println("setMaxSpeed_");
        String sp = "1.0 M";
        Thrust_Function instance = new Thrust_Function();
        instance.setMaxSpeed_(sp);
    }

    /**
     * Test of getThrustMaxSpeed method, of class Thrust_Function.
     */
    @Test
    public void testGetThrustMaxSpeed() {
        System.out.println("getThrustMaxSpeed");
        Thrust_Function instance = new Thrust_Function();
        instance.setThrustMaxSpeed(13);
        double expResult = 13.0;
        double result = instance.getThrustMaxSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setThrustMaxSpeed method, of class Thrust_Function.
     */
    @Test
    public void testSetThrustMaxSpeed() {
        System.out.println("setThrustMaxSpeed");
        double thrust_max_speed = 120.0;
        Thrust_Function instance = new Thrust_Function();
        instance.setThrustMaxSpeed(thrust_max_speed);
    }

    /**
     * Test of getThrustMaxSpeed_ method, of class Thrust_Function.
     */
    @Test
    public void testGetThrustMaxSpeed_() {
        System.out.println("getThrustMaxSpeed_");
        Thrust_Function instance = new Thrust_Function();
        instance.setThrustMaxSpeed_("120 SI");
        String expResult = "120.0";
        String result = instance.getThrustMaxSpeed_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setThrustMaxSpeed_ method, of class Thrust_Function.
     */
    @Test
    public void testSetThrustMaxSpeed_() {
        System.out.println("setThrustMaxSpeed_");
        String th = "3.0E+05 SI";
        Thrust_Function instance = new Thrust_Function();
        instance.setThrustMaxSpeed_(th);
    }

    /**
     * Test of validate method, of class Thrust_Function.
     */
    @Test
    public void testValidate() {
        System.out.println("validate1");
        Thrust_Function instance = new Thrust_Function(0, 10, 10);
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Thrust_Function instance2 = new Thrust_Function(12, 0, 10);
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        Thrust_Function instance3 = new Thrust_Function(12, 10, 0);
        boolean expResult3 = false;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
        
        System.out.println("validate4");
        Thrust_Function instance4 = new Thrust_Function(12, 10, 10);
        boolean expResult4 = true;
        boolean result4 = instance4.validate();
        assertEquals(expResult4, result4);

    }
    
}
