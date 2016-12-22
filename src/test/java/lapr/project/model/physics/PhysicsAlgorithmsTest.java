/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.physics;

import lapr.project.model.AircraftModel;
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
     */
    @Test
    public void testCalculateAbsoluteTemperature() {
        System.out.println("calculateAbsoluteTemperature");
        double altitude = 1000.0;
        double expResult = 0.0;
        double result = PhysicsAlgorithms.calculateAbsoluteTemperature(altitude);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateAbsolutePressure method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateAbsolutePressure() {
        System.out.println("calculateAbsolutePressure");
        double altitude = 1000;
        double expResult = 89874.57;
        double result = PhysicsAlgorithms.calculateAbsolutePressure(altitude);
        assertEquals(expResult, result, 10000.0);
    }

    /**
     * Test of calculateAirDensity method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateAirDensity() {
        System.out.println("calculateAirDensity");
        double pressure = 0.0;
        double temperature = 0.0;
        double expResult = 0.0;
        double result = PhysicsAlgorithms.calculateAirDensity(pressure, temperature);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateVelocityAircraft method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateVelocityAircraft() {
        System.out.println("calculateVelocityAircraft");
        double distance = 0.0;
        double time = 0.0;
        double expResult = 0.0;
        double result = PhysicsAlgorithms.calculateVelocityAircraft(distance, time);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateLiftCoefficient method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateLiftCoefficient() {
        System.out.println("calculateLiftCoefficient");
        double mass = 0.0;
        double airDensity = 0.0;
        double areaWings = 0.0;
        double velocity = 0.0;
        double expResult = 0.0;
        double result = PhysicsAlgorithms.calculateLiftCoefficient(mass, airDensity, areaWings, velocity);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateDragCoefficient method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateDragCoefficient() {
        System.out.println("calculateDragCoefficient");
        double cDrag0 = 0.0;
        double liftCoef = 0.0;
        double area = 0.0;
        double e = 0.0;
        double expResult = 0.0;
        double result = PhysicsAlgorithms.calculateDragCoefficient(cDrag0, liftCoef, area, e);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTSFC method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateTSFC() {
        System.out.println("calculateTSFC");
        double p = 0.0;
        double density = 0.0;
        double airVolume = 0.0;
        double expResult = 0.0;
        double result = PhysicsAlgorithms.calculateTSFC(p, density, airVolume);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateRangeAircraft method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateRangeAircraft_6args() {
        System.out.println("calculateRangeAircraft");
        double tas = 0.0;
        double tsfc = 0.0;
        double wi = 0.0;
        double wf = 0.0;
        double liftForce = 0.0;
        double dragForce = 0.0;
        double expResult = 0.0;
        double result = PhysicsAlgorithms.calculateRangeAircraft(tas, tsfc, wi, wf, liftForce, dragForce);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateRangeAircraft method, of class PhysicsAlgorithms.
     */
    @Test
    public void testCalculateRangeAircraft_AircraftModel() {
        System.out.println("calculateRangeAircraft");
        AircraftModel aircraftModel = null;
        double expResult = 0.0;
        double result = PhysicsAlgorithms.calculateRangeAircraft(aircraftModel);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }    
}
