/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

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
public class StringToSIUnitConverterTest {
    
    public StringToSIUnitConverterTest() {
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
     * Test of weight method, of class StringToSIUnitConverter.
     */
    @Test
    public void testWeight() {
        System.out.println("weight1");
        String s = "1.0 SI";
        double expResult = 1;
        double result = StringToSIUnitConverter.weight(s);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("weight2");
        String s2 = "1.0 US";
        double expResult2 = 0.453;
        double result2 = StringToSIUnitConverter.weight(s2);
        assertEquals(expResult2, result2, 0.001);
    }

    /**
     * Test of volume method, of class StringToSIUnitConverter.
     */
    @Test
    public void testVolume() {
        System.out.println("volume1");
        String s = "1.0 SI";
        double expResult = 1;
        double result = StringToSIUnitConverter.volume(s);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("volume2");
        String s2 = "1.0 US";
        double expResult2 = 0.0037;
        double result2 = StringToSIUnitConverter.volume(s2);
        assertEquals(expResult2, result2, 0.0001);
    }

    /**
     * Test of area method, of class StringToSIUnitConverter.
     */
    @Test
    public void testArea() {
        System.out.println("area1");
        String s = "1.0 SI";
        double expResult = 1;
        double result = StringToSIUnitConverter.area(s);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("area2");
        String s2 = "1.0 US";
        double expResult2 = 0.0929;
        double result2 = StringToSIUnitConverter.area(s2);
        assertEquals(expResult2, result2, 0.0);
    }

    /**
     * Test of length method, of class StringToSIUnitConverter.
     */
    @Test
    public void testLength() {
        System.out.println("length1");
        String s = "1.0 SI";
        double expResult = 1;
        double result = StringToSIUnitConverter.length(s);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("length2");
        String s2 = "1.0 US";
        double expResult2 = 0.3048;
        double result2 = StringToSIUnitConverter.length(s2);
        assertEquals(expResult2, result2, 0.0);
        
        System.out.println("length3");
        String s3 = "1.0 m";
        double expResult3 = 1;
        double result3 = StringToSIUnitConverter.length(s3);
        assertEquals(expResult3, result3, 0.0);
    }

    /**
     * Test of TSFC method, of class StringToSIUnitConverter.
     */
    @Test
    public void testTSFC() {
        System.out.println("TSFC1");
        String s = "1.0 SI";
        double expResult = 1;
        double result = StringToSIUnitConverter.TSFC(s);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("TSFC2");
        String s2 = "1.0 US";
        double expResult2 = 28.32;
        double result2 = StringToSIUnitConverter.TSFC(s2);
        assertEquals(expResult2, result2, 0.01);
    }

    /**
     * Test of speed method, of class StringToSIUnitConverter.
     */
    @Test
    public void testSpeed() {
        System.out.println("speed1");
        String s = "1.0 SI";
        double expResult = 1;
        double result = StringToSIUnitConverter.speed(s);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("speed2");
        String s2 = "1.0 US";
        double expResult2 = 0.447;
        double result2 = StringToSIUnitConverter.speed(s2);
        assertEquals(expResult2, result2, 0.0);
        
        System.out.println("speed3");
        String s3 = "1.0 M";
        double expResult3 = 343.2;
        double result3 = StringToSIUnitConverter.speed(s3);
        assertEquals(expResult3, result3, 0.0);
        
        System.out.println("speed4");
        String s4 = "1.0 knot";
        double expResult4 = 1;
        double result4 = StringToSIUnitConverter.speed(s4);
        assertEquals(expResult4, result4, 0.0);
    }

    /**
     * Test of force method, of class StringToSIUnitConverter.
     */
    @Test
    public void testForce() {
        System.out.println("force1");
        String s = "1.0 SI";
        double expResult = 1;
        double result = StringToSIUnitConverter.force(s);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("force2");
        String s2 = "1.0 US";
        double expResult2 = 0.004448;
        double result2 = StringToSIUnitConverter.force(s2);
        assertEquals(expResult2, result2, 0.0);
    }
    
}
