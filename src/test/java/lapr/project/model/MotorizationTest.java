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
public class MotorizationTest {
    
    public MotorizationTest() {
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
     * Test of getNumberMotors method, of class Motorization.
     */
    @Test
    public void testGetNumber_motors() {
        System.out.println("getNumber_motors");
        Motorization instance = new Motorization();
        int expResult = 0;
        int result = instance.getNumberMotors();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumberMotors method, of class Motorization.
     */
    @Test
    public void testSetNumber_motors() {
        System.out.println("setNumber_motors");
        int number_motors = 10;
        Motorization instance = new Motorization();
        instance.setNumberMotors(number_motors);
    }

    /**
     * Test of getMotor method, of class Motorization.
     */
    @Test
    public void testGetMotor() {
        System.out.println("getMotor");
        Motorization instance = new Motorization();
        String expResult = "NOMOTOR";
        String result = instance.getMotor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMotor method, of class Motorization.
     */
    @Test
    public void testSetMotor() {
        System.out.println("setMotor");
        String motor = "GE CF6-80C2B1F";
        Motorization instance = new Motorization();
        instance.setMotor(motor);
    }

    /**
     * Test of getMotorType method, of class Motorization.
     */
    @Test
    public void testGetMotor_type() {
        System.out.println("getMotor_type");
        Motorization instance = new Motorization();
        String expResult = "NOMOTORTYPE";
        String result = instance.getMotorType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMotorType method, of class Motorization.
     */
    @Test
    public void testSetMotor_type() {
        System.out.println("setMotor_type");
        String motor_type = "turbofan";
        Motorization instance = new Motorization();
        instance.setMotorType(motor_type);
    }

    /**
     * Test of validate method, of class Motorization.
     */
    @Test
    public void testValidate() {        
        System.out.println("validate1");
        Motorization instance = new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function());
        boolean expResult = true;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Motorization instance2 = new Motorization(10, "motor", "", 1,1,1,1, new Thrust_Function());
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        Motorization instance3 = new Motorization(10, "", "motor_type", 1,1,1,1, new Thrust_Function());
        boolean expResult3 = false;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
        
        System.out.println("validate4");
        Motorization instance4 = new Motorization(0, "motor", "motor_type", 1,1,1,1, new Thrust_Function());
        boolean expResult4 = false;
        boolean result4 = instance4.validate();
        assertEquals(expResult4, result4);
    }

    /**
     * Test of getNumberMotors method, of class Motorization.
     */
    @Test
    public void testGetNumberMotors() {
        System.out.println("getNumberMotors");
        Motorization instance = new Motorization();
        int expResult = 10;
        instance.setNumberMotors(expResult);
        int result = instance.getNumberMotors();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumberMotors method, of class Motorization.
     */
    @Test
    public void testSetNumberMotors() {
        System.out.println("setNumberMotors");
        int numberMotors = 10;
        Motorization instance = new Motorization();
        instance.setNumberMotors(numberMotors);
    }

    /**
     * Test of getMotorType method, of class Motorization.
     */
    @Test
    public void testGetMotorType() {
        System.out.println("getMotorType");
        Motorization instance = new Motorization();
        String expResult = "stdhf";
        instance.setMotorType(expResult);
        String result = instance.getMotorType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMotorType method, of class Motorization.
     */
    @Test
    public void testSetMotorType() {
        System.out.println("setMotorType");
        String motorType = "swzrsdfxhb";
        Motorization instance = new Motorization();
        instance.setMotorType(motorType);

    }

    /**
     * Test of getCruise_altitude method, of class Motorization.
     */
    @Test
    public void testGetCruise_altitude() {
        System.out.println("getCruise_altitude");
        Motorization instance = new Motorization();
        double expResult = 10.0;
        instance.setCruise_altitude(expResult);
        double result = instance.getCruise_altitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCruise_altitude method, of class Motorization.
     */
    @Test
    public void testSetCruise_altitude() {
        System.out.println("setCruise_altitude");
        double cruise_altitude = 10.0;
        Motorization instance = new Motorization();
        instance.setCruise_altitude(cruise_altitude);
    }

    /**
     * Test of getCruise_altitude_ method, of class Motorization.
     */
    @Test
    public void testGetCruise_altitude_() {
        System.out.println("getCruise_altitude_");
        Motorization instance = new Motorization();
        String expResult = "0.0";
        instance.setCruise_altitude_(expResult);
        String result = instance.getCruise_altitude_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCruise_altitude_ method, of class Motorization.
     */
    @Test
    public void testSetCruise_altitude_() {
        System.out.println("setCruise_altitude_");
        String cruise_altitude = "43.1E+03 US";
        Motorization instance = new Motorization();
        instance.setCruise_altitude_(cruise_altitude);
    }

    /**
     * Test of getCruise_speed method, of class Motorization.
     */
    @Test
    public void testGetCruise_speed() {
        System.out.println("getCruise_speed");
        Motorization instance = new Motorization();
        double expResult = 0.84;
        instance.setCruise_speed(expResult);
        double result = instance.getCruise_speed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCruise_speed method, of class Motorization.
     */
    @Test
    public void testSetCruise_speed() {
        System.out.println("setCruise_speed");
        double cruise_speed =80.0;
        Motorization instance = new Motorization();
        instance.setCruise_speed(cruise_speed);
    }

    /**
     * Test of getCruise_speed_ method, of class Motorization.
     */
    @Test
    public void testGetCruise_speed_() {
        System.out.println("getCruise_speed_");
        Motorization instance = new Motorization();
        String expResult = "0.0";
        instance.setCruise_altitude_(expResult);
        String result = instance.getCruise_speed_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCruise_speed_ method, of class Motorization.
     */
    @Test
    public void testSetCruise_speed_() {
        System.out.println("setCruise_speed_");
        String cruise_speed = "0.84 M";
        Motorization instance = new Motorization();
        instance.setCruise_speed_(cruise_speed);
    }

    /**
     * Test of getTSFC method, of class Motorization.
     */
    @Test
    public void testGetTSFC() {
        System.out.println("getTSFC");
        Motorization instance = new Motorization();
        double expResult = 10.0;
        instance.setTSFC(expResult);
        double result = instance.getTSFC();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setTSFC method, of class Motorization.
     */
    @Test
    public void testSetTSFC() {
        System.out.println("setTSFC");
        double TSFC = 20.0;
        Motorization instance = new Motorization();
        instance.setTSFC(TSFC);
    }

    /**
     * Test of getTSFC_ method, of class Motorization.
     */
    @Test
    public void testGetTSFC_() {
        System.out.println("getTSFC_");
        Motorization instance = new Motorization();
        String expResult = "0.0";
        instance.setTSFC_(expResult);
        String result = instance.getTSFC_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTSFC_ method, of class Motorization.
     */
    @Test
    public void testSetTSFC_() {
        System.out.println("setTSFC_");
        String TSFC = "1.6e-4 SI";
        Motorization instance = new Motorization();
        instance.setTSFC_(TSFC);
    }

    /**
     * Test of getLapse_rate_factor method, of class Motorization.
     */
    @Test
    public void testGetLapse_rate_factor() {
        System.out.println("getLapse_rate_factor");
        Motorization instance = new Motorization();
        double expResult = 10.0;
        instance.setLapse_rate_factor(expResult);
        double result = instance.getLapse_rate_factor();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLapse_rate_factor method, of class Motorization.
     */
    @Test
    public void testSetLapse_rate_factor() {
        System.out.println("setLapse_rate_factor");
        double lapse_rate_factor = 10.0;
        Motorization instance = new Motorization();
        instance.setLapse_rate_factor(lapse_rate_factor);
    }

    /**
     * Test of getThrust_function method, of class Motorization.
     */
    @Test
    public void testGetThrust_function() {
        System.out.println("getThrust_function");
        Motorization instance = new Motorization();
        Thrust_Function expResult = new Thrust_Function(10, 29, 10);
        instance.setThrust_function(expResult);
        Thrust_Function result = instance.getThrust_function();
        assertEquals(expResult, result);
    }

    /**
     * Test of setThrust_function method, of class Motorization.
     */
    @Test
    public void testSetThrust_function() {
        System.out.println("setThrust_function");
        Thrust_Function thrust_function = new Thrust_Function();
        Motorization instance = new Motorization();
        instance.setThrust_function(thrust_function);
    }
    
}
