/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.physics;

import lapr.project.model.Wind;
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
     * Test of calculateVelocityAircraftMass method, of class
     * AircraftAlgorithms.
     */
    @Test
    public void testCalculateMTrue() {
        System.out.println("calculateMTrue");
        double airDens = 1.22501312;
        double vIas = 210;
        double expResult = 0.317618939;
        double result = AircraftAlgorithms.calculateMTrue(airDens, vIas);
        assertEquals(expResult, result, 0.1);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateTAS method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateTAS() {
        System.out.println("calculateTAS");
        double airDensity = 1.22501312;
        double temperature = 288.2;
        double vIas = 210.0;
        double expResult = 108.0832375;
        double result = AircraftAlgorithms.calculateTAS(airDensity, temperature, vIas);
        assertEquals(expResult, result, 0.1);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateLiftCoefficient method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateLiftCoefficient() {
        System.out.println("calculateLiftCoefficient");
        double mass = 5.4 * Math.pow(10, 5);
        double airDensity = 1.22501312;
        double areaWings = 858;
        double velocity = 108.0832375;
        double expResult = 0.8624279;
        double result = AircraftAlgorithms.calculateLiftCoefficient(mass, airDensity, areaWings, velocity);
        assertEquals(expResult, result, 0.1);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
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
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
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
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

//    /**
//     * Test of calculateLambda method, of class AircraftAlgorithms.
//     */
//    @Test
//    public void testCalculateLambda() {
//        System.out.println("calculateLambda");
//        double velThrustMa = 0.9;
//        double thrustMa = 3.38 * Math.pow(10, 5);
//        double thrustMi = 1.80 * Math.pow(10, 5);
//        double expResult = 1.76 * Math.pow(10, 5);
//        double result = AircraftAlgorithms.calculateLambda(velThrustMa, thrustMa, thrustMi);
//        assertEquals(expResult, result, 500);
//        double test = 1 - result / expResult;
//        System.out.println("ExpResult: " + expResult);
//        System.out.println("Result: " + result);
//        System.out.println(String.format("Error: %.5f %%", test));
//    }

    /**
     * Test of calculateDhDt method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateDhDt() {
        System.out.println("calculateDhDt");
        double thrust = 2.82 * Math.pow(10, 5) * 4;
        double drag = 315044.7;
        double tas = 108.0832375;
        double mass = 5.40 * Math.pow(10, 5);
        double expResult = 16.6;
        double result = AircraftAlgorithms.calculateDhDt(thrust, drag, tas, mass);
        assertEquals(expResult, result, 0.01);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
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
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateDwDt method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateDwDt() {
        System.out.println("calculateDwDt");
        double thrust = 1.13 * Math.pow(10, 6);
        double timeStep = 120;
        double tsfc = 1.6 * Math.pow(10, -4);
        double expResult = 2.21 * Math.pow(10, 3);
        double result = AircraftAlgorithms.calculateDwDt(thrust, timeStep, tsfc);
        assertEquals(expResult, result, 2.5);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
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
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
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
        double expResult = 1.28 * Math.pow(10, 4);
        double result = AircraftAlgorithms.calculateDistanceGained(tas, angle, timeStep);
        assertEquals(expResult, result, 20.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateAltitudeGained method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateAltitudeGained() {
        System.out.println("calculateAltitudeGained");
        double prevAlt = 0;
        double dhDT = 16.6;
        double timeStep = 120;
        double expResult = 1993.83;
        double result = AircraftAlgorithms.calculateAltitudeGained(prevAlt, dhDT, timeStep);
        assertEquals(expResult, result, 2.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateNewMass method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateNewMass() {
        System.out.println("calculateNewMass");
        double prevMass = 5.4 * Math.pow(10, 5);
        double dwDt = 2.21 * Math.pow(10, 3);
        double expResult = 5.38 * Math.pow(10, 5);
        double result = AircraftAlgorithms.calculateNewMass(prevMass, dwDt);
        assertEquals(expResult, result, 500.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

//    /**
//     * Test of calculateTrueWindApplied method, of class AircraftAlgorithms.
//     http://hyperphysics.phy-astr.gsu.edu/hbase/airpw.html#c2
//     * FALTA
//     */
//    @Test
//    public void testCalculateTrueWindApplied() {
//        System.out.println("calculateTrueWindApplied");
//        Wind wind = new Wind(10,10);
//        double course=1.65E-01;
//        double tas=108.08;
//        double expResult=0;
//        double result = AircraftAlgorithms.calculateTrueWindApplied(course,wind,tas);
//        assertEquals(expResult, result, 0.0);
//        double test = 1 - result/expResult;
//        System.out.println("ExpResult: "+ expResult);
//        System.out.println("Result: "+ result);
//        System.out.println(String.format("Error: %.5f %%", test));
//    }
//    /**
//     * Test of calculateTSFC method, of class AircraftAlgorithms.
//     * FALTA
//     */
//    @Test
//    public void testCalculateTSFC() {
//        System.out.println("calculateTSFC");
//        double p = 0.0;
//        double density = 0.0;
//        double airVolume = 0.0;
//        double expResult = 0.0;
//        double result = AircraftAlgorithms.calculateTSFC(p, density, airVolume);
//        assertEquals(expResult, result, 0.0);
//    double test = 1 - result/expResult;
//        System.out.println("ExpResult: "+ expResult);
//        System.out.println("Result: "+ result);
//        System.out.println(String.format("Error: %.5f %%", test));
//    }
//    /**
//     * Test of calculateRangeAircraft method, of class AircraftAlgorithms.
//     * FALTA
//     */
//    @Test
//    public void testCalculateRangeAircraft() {
//        System.out.println("calculateRangeAircraft");
//        double tas = 228.69;
//        double tsfc = 1.6E-04;
//        double wi = 1.0;
//        double wf = 1.0;
//        double liftForce = 0.4262;
//        double dragForce = 2.14E+05;
//        double expResult = 10000.0;
//        double result = AircraftAlgorithms.calculateRangeAircraft(tas, tsfc, wi, wf, liftForce, dragForce);
//        assertEquals(expResult, result, 0.0);
//    double test = 1 - result/expResult;
//        System.out.println("ExpResult: "+ expResult);
//        System.out.println("Result: "+ result);
//        System.out.println(String.format("Error: %.5f %%", test));
//    }
    /**
     * Test of calculateFuelUsed method, of class AircraftAlgorithms. FALTA
     */
    @Test
    public void testCalculateFuelUsed() {
        System.out.println("calculateFuelUsed");
        double initialWeight = 10000.0;
        double finalWeight = 1000.0;
        double weightZeroFuel = 8000.0;
        double expResult = -17000.0;
        double result = AircraftAlgorithms.calculateFuelUsed(initialWeight, finalWeight, weightZeroFuel);
        assertEquals(expResult, result, 0.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateThrustClimb method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateThrustClimb() {
        System.out.println("calculateThrust");
        double thrustMa = 3.38 * Math.pow(10, 5);
        double lambda = 1.76 * Math.pow(10, 5);
        double mTrue = 0.317618939;
        double airDensity = 1.22501312;
        double thrustLapseRate = 0.96;
        double expResult = 2.82 * Math.pow(10, 5);
        double result = AircraftAlgorithms.calculateThrustClimb(thrustMa, lambda, mTrue, airDensity, thrustLapseRate);
        assertEquals(expResult, result, 200);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateThrustCruise method, of class AircraftAlgorithms. FALTA
     */
    @Test
    public void testCalculateThrustCruise() {
        System.out.println("calculateThrustCruise");
        double drag = 240575.7;
        int nrEngines = 1;
        double expResult = 240575.7;
        double result = AircraftAlgorithms.calculateThrustCruise(drag, nrEngines);
        assertEquals(expResult, result, 0.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateThrustDescend method, of class AircraftAlgorithms. FALTA
     */
    @Test
    public void testCalculateThrustDescend() {
        System.out.println("calculateThrustDescend");
        double thrustMa = 3.38E+05;
        double lambda = 1.76E+05;
        double mTrue = 0.751;
        double airDensity = 0.40966;
        double thrustLapseRate = 0.96;
        double expResult = 7.2E+03;
        double result = AircraftAlgorithms.calculateThrustDescend(thrustMa, lambda, mTrue, airDensity, thrustLapseRate);
        assertEquals(expResult, result, 10.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));

    }

    /**
     * Test of calculateTotalThrustClimb method, of class AircraftAlgorithms.
     * FALTA
     */
    @Test
    public void testCalculateTotalThrustClimb() {
        System.out.println("calculateTotalThrustClimb");
        double thrust = 2.23E+05;
        int nrEngines = 4;
        double expResult = 8.94E+05;
        double result = AircraftAlgorithms.calculateTotalThrustClimb(thrust, nrEngines);
        assertEquals(expResult, result, 2000.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateTotalThrustDescend method, of class AircraftAlgorithms.
     * FALTA
     */
    @Test
    public void testCalculateTotalThrustDescend() {
        System.out.println("calculateTotalThrustDescend");
        double thrust = 7.2E+03;
        int nrEngines = 4;
        double expResult = 2.88E+04;
        double result = AircraftAlgorithms.calculateTotalThrustDescend(thrust, nrEngines);
        assertEquals(expResult, result, 0.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateTotalThrustCruise method, of class AircraftAlgorithms.
     * FALTA
     */
    @Test
    public void testCalculateTotalThrustCruise() {
        System.out.println("calculateTotalThrustCruise");
        double draft = 7.20E+03;
        double expResult = 7.20E+03;
        double result = AircraftAlgorithms.calculateTotalThrustCruise(draft);
        assertEquals(expResult, result, 0.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    //falta groundSpeed http://www.csgnetwork.com/e6bcalc.html
    //falta windApplied http://hyperphysics.phy-astr.gsu.edu/hbase/airpw.html#c2

    /**
     * Test of calculateLiftForce method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateLiftForce() {
        System.out.println("calculateLiftForce");
        double coefLift = 0.44193312;
        double airDensity = 0.40966425;
        double velocity = 300;
        double area = 858;
        AircraftAlgorithms instance = new AircraftAlgorithms();
        double expResult = 6990116;
        double result = instance.calculateLiftForce(coefLift, airDensity, velocity, area);
        assertEquals(expResult, result, 1.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateGroundSpeed method, of class AircraftAlgorithms.
     */
    @Test
    public void testCalculateGroundSpeed() {
        System.out.println("calculateGroundSpeed");
        double tas = 228.6961;
        Wind wind = new Wind(50,0);
        double course = 15.0;
        double expResult = 180.0;
        double result = AircraftAlgorithms.calculateGroundSpeed(tas, wind, course);
        assertEquals(expResult, result, 1.0);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }

    /**
     * Test of calculateWindCorrectionAngle method, of class AircraftAlgorithms.
     * http://www.luizmonteiro.com/Article_Estimating_Wind_Correction_Angle_Printable.htm
     */
    @Test
    public void testCalculateWindCorrectionAngle() {
        System.out.println("calculateWindCorrectionAngle");
        double angAircCourse = 30.0;
        double tas = 228.6961;
        Wind wind = new Wind(50,0);
        double expResult = 0.0038;
        double result = AircraftAlgorithms.calculateWindCorrectionAngle(angAircCourse, tas, wind);
        assertEquals(expResult, result, 0.001);
        double test = 1 - result / expResult;
        System.out.println("ExpResult: " + expResult);
        System.out.println("Result: " + result);
        System.out.println(String.format("Error: %.5f %%", test));
    }
}
