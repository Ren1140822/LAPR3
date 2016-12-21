/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Flavio Relvas
 */
public class DistanceCalculatorTest {

    public DistanceCalculatorTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of calculateDistance method, of class DistanceCalculator.
     */
    @Test
    public void testCalculateDistance() {
        System.out.println("calculateDistance");
        double lat1 = 41.2481003;
        double lon1 = -8.6813898;
        double lat2 = 40.7812996;
        double lon2 = -8.6813898;
        double expResult = 51.91e3;
        double result = DistanceCalculator.calculateDistance(lat1, lon1, lat2, lon2);
        assertEquals(expResult, result, 1.0);
        
    }

}
