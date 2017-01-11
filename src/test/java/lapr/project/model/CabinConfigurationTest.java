/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
public class CabinConfigurationTest {
    
    public CabinConfigurationTest() {
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
     * Test of equals method, of class CabinConfiguration.
     */
    @Test
    public void testEquals() {
        System.out.println("equals1");
        Object otherObject = new CabinConfiguration();
        CabinConfiguration instance = new CabinConfiguration();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("equals2");
        Object otherObject2 = null;
        CabinConfiguration instance2 = new CabinConfiguration();
        boolean expResult2 = false;
        boolean result2 = instance2.equals(otherObject2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getTotalSeats method, of class CabinConfiguration.
     */
    @Test
    public void testGetTotalSeats() {
        System.out.println("getTotalSeats");
        CabinConfiguration instance = new CabinConfiguration();
        int expResult = 0;
        int result = instance.getTotalSeats();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class CabinConfiguration.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        CabinConfiguration instance = new CabinConfiguration();
        int expResult = 43 * 7 + Objects.hashCode(instance.getMapOfClasses());
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMapOfClasses method, of class CabinConfiguration.
     */
    @Test
    public void testGetMapOfClasses() {
        System.out.println("getMapOfClasses");
        CabinConfiguration instance = new CabinConfiguration();
        Map<String, Integer> expResult = new HashMap<>();
        instance.setMapOfClasses(expResult);
        Map<String, Integer> result = instance.getMapOfClasses();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class CabinConfiguration.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CabinConfiguration instance = new CabinConfiguration();
        String expResult = String.format("%s", instance.getMapOfClasses().keySet());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMapOfClasses method, of class CabinConfiguration.
     */
    @Test
    public void testSetMapOfClasses() {
        System.out.println("setMapOfClasses");
        Map<String, Integer> mapOfClasses = new HashMap<>();
        CabinConfiguration instance = new CabinConfiguration();
        instance.setMapOfClasses(mapOfClasses);
    }
    
}
