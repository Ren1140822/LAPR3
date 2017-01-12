/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Flavio Relvas
 */
public class DistanceCalculatorTest {

    public DistanceCalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of calculateDistance method, of class DistanceCalculator.
     */
    @Test
    public void testCalculateDistance() {
        System.out.println("calculateDistance1");
        double lat1 = 41.2481003;
        double lon1 = -8.6813898;
        double lat2 = 40.7812996;
        double lon2 = -8.6813898;
        double expResult = 51.91e3;
        double result = DistanceCalculator.calculateDistance(lat1, lon1, lat2, lon2);
        assertEquals(expResult, result, 10.0);
        System.out.println("Expected: " + expResult);
        System.out.println("Distance: " + result);
        
        System.out.println("calculateDistance2 - Lisboa -> Miami");
        double lat3 = 25.7931995;
        double lon3 = -80.2906036;
        double lat4 = 38.7812996;
        double lon4 = -9.1359196;
        double expResult2 = 6677000;
        double result2 = DistanceCalculator.calculateDistance(lat3, lon3, lat4, lon4);
        assertEquals(expResult2, result2, 1000.0);
        System.out.println("Expected: " + expResult2);
        System.out.println("Distance: " + result2);
    }

}
