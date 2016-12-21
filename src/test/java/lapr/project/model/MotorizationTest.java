/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.List;
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
     * Test of getNumber_motors method, of class Motorization.
     */
    @Test
    public void testGetNumber_motors() {
        System.out.println("getNumber_motors");
        Motorization instance = new Motorization();
        int expResult = 0;
        int result = instance.getNumber_motors();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber_motors method, of class Motorization.
     */
    @Test
    public void testSetNumber_motors() {
        System.out.println("setNumber_motors");
        int number_motors = 10;
        Motorization instance = new Motorization();
        instance.setNumber_motors(number_motors);
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
     * Test of getMotor_type method, of class Motorization.
     */
    @Test
    public void testGetMotor_type() {
        System.out.println("getMotor_type");
        Motorization instance = new Motorization();
        String expResult = "NOMOTORTYPE";
        String result = instance.getMotor_type();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMotor_type method, of class Motorization.
     */
    @Test
    public void testSetMotor_type() {
        System.out.println("setMotor_type");
        String motor_type = "turbofan";
        Motorization instance = new Motorization();
        instance.setMotor_type(motor_type);
    }

    /**
     * Test of getRegimeList method, of class Motorization.
     */
    @Test
    public void testGetRegimeList() {
        System.out.println("getRegimeList");
        Motorization instance = new Motorization();
        List<Regime> expResult = new LinkedList<>();
        instance.setRegimeList(expResult);
        List<Regime> result = instance.getRegimeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRegimeList method, of class Motorization.
     */
    @Test
    public void testSetRegimeList() {
        System.out.println("setRegimeList");
        List<Regime> regimeList = new LinkedList<>();
        Motorization instance = new Motorization();
        instance.setRegimeList(regimeList);
    }

    /**
     * Test of newRegime method, of class Motorization.
     */
    @Test
    public void testNewRegime() {
        System.out.println("newRegime");
        Motorization instance = new Motorization();
        Regime expResult = new Regime();        
        Regime result = instance.newRegime();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of saveRegime method, of class Motorization.
     */
    @Test
    public void testSaveRegime() {
        System.out.println("saveRegime");
        Regime regime = new Regime();
        Motorization instance = new Motorization();
        boolean expResult = true;
        boolean result = instance.saveRegime(regime);
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Motorization.
     */
    @Test
    public void testValidate() {
        List<Regime> regimeList1 =  new LinkedList<>();
                
        List<Regime> regimeList2 = new LinkedList<>();
        Regime r2 = new Regime();
        regimeList2.add(r2);
        
        System.out.println("validate1");
        Motorization instance = new Motorization(10, "motor", "motor_type", regimeList1);
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Motorization instance2 = new Motorization(10, "motor", "", regimeList2);
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        Motorization instance3 = new Motorization(10, "", "motor_type", regimeList2);
        boolean expResult3 = false;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
        
        System.out.println("validate4");
        Motorization instance4 = new Motorization(0, "motor", "motor_type", regimeList2);
        boolean expResult4 = false;
        boolean result4 = instance4.validate();
        assertEquals(expResult4, result4);
        
        System.out.println("validate5");
        Motorization instance5 = new Motorization(10, "motor", "motor_type", regimeList2);
        boolean expResult5 = true;
        boolean result5 = instance5.validate();
        assertEquals(expResult5, result5);
    }
    
}
