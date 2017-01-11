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
public class AircraftAlgorithmsTest {
    
    public AircraftAlgorithmsTest() {
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
     * Test of calculateVelocityAircraftMass method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateMTrue() {
        System.out.println("calculateMTrue");
        double airDens=1.22501312;
        double vIas=210;
        double expResult = 0.317618939;
        double result = AircraftAlgorithms.calculateMTrue(airDens,vIas);
        assertEquals(expResult, result, 0.1);
        double test = (result/expResult);
        System.out.println("Result: "+ result);   
        System.out.println(String.format("Error: %.2f %%", test));
    }    

    /**
     * Test of calculateTAS method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateTAS() {
        System.out.println("calculateTAS");
        double airDensity=1.22501312;
        double temperature = 288.2;
        double vIas = 210.0;
        double expResult = 108.0832375;
        double result = AircraftAlgorithms.calculateTAS(airDensity, temperature, vIas);
        assertEquals(expResult, result, 0.1);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateLiftCoefficient method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateLiftCoefficient() {
        System.out.println("calculateLiftCoefficient");
        double mass = 5.4*Math.pow(10, 5);
        double airDensity = 1.22501312;
        double areaWings = 858;
        double velocity = 108.0832375;
        double expResult = 0.8624279;
        double result = AircraftAlgorithms.calculateLiftCoefficient(mass, airDensity, areaWings, velocity);
        assertEquals(expResult, result, 0.1);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateDragCoefficient method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateDragCoefficient() {
        System.out.println("calculateDragCoefficient");
        double cDrag0 = 0.02;
        double liftCoef = 0.8624279;
        double aRatio = 9;
        double e = 0.84;
        double expResult = 0.051316551;
        double result = AircraftAlgorithms.calculateDragCoefficient(cDrag0, liftCoef, aRatio, e);
        assertEquals(expResult, result, 0.1);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateDragForce method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateDragForce() {
        System.out.println("calculateDragForce");
        double coefDrag = 0.051316551;
        double airDensity = 1.22501312;
        double velocity = 108.0832375;
        double wingArea = 858;
        double expResult = 315044.7;
        double result = AircraftAlgorithms.calculateDragForce(coefDrag, airDensity, velocity, wingArea);
        assertEquals(expResult, result, 0.1);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateThrust method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateThrust() {
        System.out.println("calculateThrust");
        double thrustMa = 3.38*Math.pow(10,5);
        double lambda = 1.76*Math.pow(10,5);
        double mTrue = 0.317618939;
        double airDensity = 1.22501312;
        double thrustLapseRate = 0.96;
        double expResult = 2.82* Math.pow(10,5);
        double result = AircraftAlgorithms.calculateThrust(thrustMa, lambda, mTrue, airDensity, thrustLapseRate);
        assertEquals(expResult, result, 200);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateLambda method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateLambda() {
        System.out.println("calculateLambda");
        double velThrustMa = 0.9;
        double thrustMa = 3.38*Math.pow(10,5);
        double thrustMi = 1.80*Math.pow(10,5);
        double expResult = 1.76* Math.pow(10,5);
        double result = AircraftAlgorithms.calculateLambda(velThrustMa, thrustMa, thrustMi);
        assertEquals(expResult, result, 500);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateDhDt method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateDhDt() {
        System.out.println("calculateDhDt");
        double thrust = 2.82*Math.pow(10, 5)*4;
        double drag = 315044.7;
        double tas = 108.0832375;
        double mass = 5.40*Math.pow(10, 5);
        double expResult = 16.6;
        double result = AircraftAlgorithms.calculateDhDt(thrust, drag, tas, mass);
        assertEquals(expResult, result, 0.01);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateClimbingAng method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateClimbingAng() {
        System.out.println("calculateClimbingAng");
        double tas = 108.0832375;
        double dhDT = 16.6;
        double expResult = 0.154;
        double result = AircraftAlgorithms.calculateClimbingAng(tas, dhDT);
        assertEquals(expResult, result, 0.01);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateDwDt method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateDwDt() {
        System.out.println("calculateDwDt");
        double thrust = 1.13*Math.pow(10, 6);
        double timeStep = 120;
        double tsfc = 1.6*Math.pow(10,-4);
        double expResult = 2.21*Math.pow(10, 3);
        double result = AircraftAlgorithms.calculateDwDt(thrust, timeStep, tsfc);
        assertEquals(expResult, result, 2.5);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateInitialWeight method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateInitialWeight() {
        System.out.println("calculateInitialWeight");
        int passengers = 10;
        int crew = 10;
        double cargoLoad = 10.0;
        double emptyWeight = 10.0;
        double fuel = 10.0;
        double expResult = 1869.4;
        double result = AircraftAlgorithms.calculateInitialWeight(passengers, crew, cargoLoad, emptyWeight, fuel);
        assertEquals(expResult, result, 0.1);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateDistance method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateDistanceGained() {
        System.out.println("calculateDistanceGained");
        double tas = 108.0832375;
        double angle = 0.154;
        double timeStep = 120.0;
        double expResult = 1.28*Math.pow(10, 4);
        double result = AircraftAlgorithms.calculateDistanceGained(tas, angle, timeStep);
        assertEquals(expResult, result,20.0);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateAltitudeGained method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateAltitudeGained() {
        System.out.println("calculateAltitudeGained");
        double prevAlt=0;
        double dhDT = 16.6;
        double timeStep = 120;
        double expResult = 1993.83;
        double result = AircraftAlgorithms.calculateAltitudeGained(prevAlt,dhDT, timeStep);
        assertEquals(expResult, result, 2.0);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }

    /**
     * Test of calculateNewMass method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateNewMass() {
        System.out.println("calculateNewMass");
        double prevMass = 5.4*Math.pow(10,5);
        double dwDt = 2.21*Math.pow(10,3);
        double expResult = 5.38*Math.pow(10,5);
        double result = AircraftAlgorithms.calculateNewMass(prevMass, dwDt);
        assertEquals(expResult, result,500.0);
        double test = (result/expResult);
        System.out.println("Result: "+ result);
        System.out.println(String.format("Error: %.2f %%", test));
    }
}