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
public class LocationTest {
    
    public LocationTest() {
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
     * Test of getLatitude method, of class Location.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        Location instance = new Location(new Location());
        double expResult = 0.0;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLatitude method, of class Location.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        double latitude = 10.0;
        Location instance = new Location();
        instance.setLatitude(latitude);
    }

    /**
     * Test of getLongitude method, of class Location.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        Location instance = new Location();
        double expResult = 0.0;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLongitude method, of class Location.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        double longitude = 20.0;
        Location instance = new Location();
        instance.setLongitude(longitude);
    }

    /**
     * Test of getAltitude method, of class Location.
     */
    @Test
    public void testGetAltitude() {
        System.out.println("getAltitude");
        Location instance = new Location();
        int expResult = 0;
        int result = instance.getAltitude();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAltitude method, of class Location.
     */
    @Test
    public void testSetAltitude() {
        System.out.println("setAltitude");
        int altitude = 10;
        Location instance = new Location();
        instance.setAltitude(altitude);
    }

    /**
     * Test of toString method, of class Location.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Location instance = new Location();
        String expResult = instance.getLatitude() + " <-> " + 
                instance.getLongitude() + " <-> " + instance.getAltitude();;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Location.
     */
    @Test
    public void testEquals() {
        System.out.println("equals1");
        Object otherObject =  new Location();
        Location instance = new Location();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("equals2");
        Object otherObject2 =  new Location(89, 0, 0);
        Location instance2 = new Location();
        boolean expResult2 = false;
        boolean result2 = instance2.equals(otherObject2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of hashCode method, of class Location.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Location instance = new Location();
        int expResult = 0;
        int result = instance.hashCode();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Location.
     */
    @Test
    public void testValidate() {
        System.out.println("validate1");
        Location instance = new Location(91, 0, 0);
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Location instance2 = new Location();
        boolean expResult2 = true;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
    }
    
}
