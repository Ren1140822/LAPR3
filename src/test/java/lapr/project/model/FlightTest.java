/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.sql.Date;
import java.util.Objects;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Flavio Relvas
 */
public class FlightTest {

    Flight instance;

    public FlightTest() {
    }

    @Before
    public void setUp() {
        instance = new FlightInstance();
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "FF0001A";
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
        otherObject.flightDesignator = "FF0001B";
        result = instance.equals(otherObject);
        assertEquals(expResult, result);
        otherObject.flightDesignator = "FF0001A";
        expResult = true;
        result = instance.equals(otherObject);
        assertEquals("Should return true for flights with the same designator", expResult, result);
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
        String expResult = "FF0001A";
        String result = instance.getFlightDesignator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFlightDesignator method, of class Flight.
     */
    @Test
    public void testSetFlightDesignator() {
        System.out.println("setFlightDesignator");
        String expResult = "FF0001B";
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

    /**
     * Test of validate method, of class Flight
     */
    @Test
    public void testValidate() {
        System.out.println("validate default");
        boolean expResult = true;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate flightDesignator pass");
        instance.flightDesignator = "FF01A";
        result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate flightDesignator fail");
        instance.flightDesignator = "00AAb2";
        expResult = false;
        result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate minStopTime fail");
        expResult = false;
        instance.flightDesignator = "FF0001A";
        instance.minStopTime = -100;
        result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate shceduledArrival fail");
        expResult = false;
        instance.scheduledArrival = new Date(System.currentTimeMillis());
        result = instance.validate();
        assertEquals(expResult, result);
    }
}
