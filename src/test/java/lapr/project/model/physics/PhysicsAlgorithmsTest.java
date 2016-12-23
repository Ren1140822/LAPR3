/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.physics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NANA
 */
public class PhysicsAlgorithmsTest {
    
    public PhysicsAlgorithmsTest() {
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
     * Test of calculateAbsoluteTemperature method, of class PhysicsAlgorithms.
     * https://www.digitaldutch.com/atmoscalc/
     */
    @Test
    public void testCalculateAbsoluteTemperature() {
        System.out.println("calculateAbsoluteTemperature");
        double altitude = 5000.0;
        double expResult = 255.150;
        double result = PhysicsAlgorithms.calculateAbsoluteTemperature(altitude);
        assertEquals(expResult, result, 0.5);
    }

    /**
     * Test of calculateAbsolutePressure method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateAbsolutePressure() {
        System.out.println("calculateAbsolutePressure");
        double altitude = 5000;
        double expResult = 54019.9;
        
        double result = PhysicsAlgorithms.calculateAbsolutePressure(altitude);
        assertEquals(expResult, result, 0.5);
    }

    /**
     * Test of calculateAirDensity method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateAirDensity() {
        System.out.println("calculateAirDensity");
        double pressure = 89874.6;
        double temperature = 281.650;
        double expResult = 1.11164;
        double result = PhysicsAlgorithms.calculateAirDensity(pressure, temperature);
        assertEquals(expResult, result, 0.5);
    }

    /**
     * Test of calculateVelocity method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateVelocity() {
        System.out.println("calculateVelocity");
        double distance = 100.0;
        double time = 200.0;
        double expResult = 0.5;
        double result = PhysicsAlgorithms.calculateVelocity(distance, time);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateTime method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateTime() {
        System.out.println("calculateTime");
        double distance = 1000.0;
        double velocity = 500.0;
        double expResult = 2.0;
        double result = PhysicsAlgorithms.calculateTime(distance, velocity);
        assertEquals(expResult, result, 0.0);
    }
}