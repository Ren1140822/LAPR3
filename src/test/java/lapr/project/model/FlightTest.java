/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.sql.Date;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Flavio Relvas
 */
public class FlightTest {
    Flight instance = new FlightInstance();
    
    public FlightTest() {
    }
    
    @Before
    public void setUp() {
        instance.flightDesignator = "F001";
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "F001";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Flight.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Flight otherObject = null;
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        otherObject = new FlightInstance();
        otherObject.flightDesignator = "F002";
        result = instance.equals(otherObject);
        assertEquals(expResult, result);
        otherObject.flightDesignator = "F001";
        expResult = true;
        result = instance.equals(otherObject);
        assertEquals("Should return true for flights with the same designator",expResult, result);
    }

    /**
     * Test of hashCode method, of class Flight.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = Objects.hashCode(instance);
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlightDesignator method, of class Flight.
     */
    @Test
    public void testGetFlightDesignator() {
        System.out.println("getFlightDesignator");
        String expResult = "F001";
        String result = instance.getFlightDesignator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFlightDesignator method, of class Flight.
     */
    @Test
    public void testSetFlightDesignator() {
        System.out.println("setFlightDesignator");
        String expResult = "F002";
        instance.setFlightDesignator(expResult);
        String result = instance.getFlightDesignator();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinStopTime method, of class Flight.
     */
    @Test
    public void testGetMinStopTime() {
        System.out.println("getMinStopTime");
        int expResult = 0;
        int result = instance.getMinStopTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMinStopTime method, of class Flight.
     */
    @Test
    public void testSetMinStopTime() {
        System.out.println("setMinStopTime");
        int minStopTime = 10;
        instance.setMinStopTime(minStopTime);
        int result = instance.getMinStopTime();
        assertEquals(minStopTime, result);
    }

    /**
     * Test of getScheduledArrival method, of class Flight.
     */
    @Test
    public void testGetScheduledArrival() {
        System.out.println("getScheduledArrival");
        Date expResult = new Date(System.currentTimeMillis());
        instance.setScheduledArrival(expResult);
        Date result = instance.getScheduledArrival();
        assertEquals(expResult, result);
    }
}
