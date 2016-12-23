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
public class ConversionAlgorithmsTest {
    
    public ConversionAlgorithmsTest() {
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
     * Test of convertMetersFeet method, of class ConversionAlgorithms.
     */
    @Test
    public void testConvertMetersFeet() {
        System.out.println("convertMetersFeet");
        double meters = 5.5;
        double expResult = 18.0446;
        double result = ConversionAlgorithms.convertMetersFeet(meters);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of convertFeetM method, of class ConversionAlgorithms.
     */
    @Test
    public void testConvertFeetM() {
        System.out.println("convertFeetM");
        double feet = 5.5;
        double expResult = 1.6764;
        double result = ConversionAlgorithms.convertFeetM(feet);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of convertKnotMS method, of class ConversionAlgorithms.
     */
    @Test
    public void testConvertKnotMS() {
        System.out.println("convertKnotMS");
        double knot = 5.5;
        double expResult = 2.82944;
        double result = ConversionAlgorithms.convertKnotMS(knot);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of convertLbfN method, of class ConversionAlgorithms.
     */
    @Test
    public void testConvertLbfN() {
        System.out.println("convertLbfN");
        double lbf = 5.5;
        double expResult = 244.652;
        double result = ConversionAlgorithms.convertLbfN(lbf);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of convertLbfGram method, of class ConversionAlgorithms.
     */
    @Test
    public void testConvertLbfGram() {
        System.out.println("convertLbfGram");
        double lbf = 5.5;
        double expResult = 2494.76;
        double result = ConversionAlgorithms.convertLbfGram(lbf);
        assertEquals(expResult, result, 0.01);
    }
    
}
