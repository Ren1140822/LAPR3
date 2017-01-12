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
 * @author Diana Silva
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
        double expResult = 255.650;
        double result = PhysicsAlgorithms.calculateAbsoluteTemperature(altitude);
        assertEquals(expResult, result, 0.01);
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
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
        assertEquals(expResult, result, 0.05);
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
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
        assertEquals(expResult, result, 0.01);
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
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
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
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
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateAirdensity method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateAirdensity() {
        System.out.println("calculateAirdensity");
        double altitude = 1000.0;
        double expResult = 1.11164;
        double result = PhysicsAlgorithms.calculateAirdensity(altitude);
        assertEquals(expResult, result, 0.01);
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
    }
    
    /**
     * Test of calculateSoundSpeed method, of class PhysicsAlgorithms.
      http://www.sengpielaudio.com/calculator-speedsound.htm
     */
    @Test
    public void testCalculateSoundSpeed() {
        System.out.println("calculateSoundSpeed");
        double temperature = 288.2;
        double expResult = 340.3;
        double result = PhysicsAlgorithms.calculateSoundSpeed(temperature);
        assertEquals(expResult, result, 0.5);
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
    }
    
    /**
     * Test of getPRESSURE_SEA method, of class PhysicsAlgorithms.
     */
    @Test
    public void testGetPRESSURE_SEA() {
        System.out.println("getPRESSURE_SEA");
        double expResult = 101325.0;
        double result = PhysicsAlgorithms.getPRESSURE_SEA();
        assertEquals(expResult, result, 0.0);
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of getTEMPERATURE_SEA method, of class PhysicsAlgorithms.
     */
    @Test
    public void testGetTEMPERATURE_SEA() {
        System.out.println("getTEMPERATURE_SEA");
        double expResult = 288.15;
        double result = PhysicsAlgorithms.getTEMPERATURE_SEA();
        assertEquals(expResult, result, 0.0);
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of getGAS_CONSTANT_AIR method, of class PhysicsAlgorithms.
     */
    @Test
    public void testGetGAS_CONSTANT_AIR() {
        System.out.println("getGAS_CONSTANT_AIR");
        double expResult = 8.31432;
        double result = PhysicsAlgorithms.getGAS_CONSTANT_AIR();
        assertEquals(expResult, result, 0.0);
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of getGRAVITY_CONSTANT_SEA method, of class PhysicsAlgorithms.
     */
    @Test
    public void testGetGRAVITY_CONSTANT_SEA() {
        System.out.println("getGRAVITY_CONSTANT_SEA");
        double expResult = 9.80665;
        double result = PhysicsAlgorithms.getGRAVITY_CONSTANT_SEA();
        assertEquals(expResult, result, 0.0);
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
    }

  
}