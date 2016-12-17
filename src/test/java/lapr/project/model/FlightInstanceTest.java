/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Flavio Relvas
 */
public class FlightInstanceTest {
    
    public FlightInstanceTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of toString method, of class FlightInstance.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FlightInstance instance = new FlightInstance();
        instance.flightDesignator = "F001";
        String expResult = "F001";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class FlightInstance.
     */
    @Test
    public void testEquals() {
        System.out.println("equalsNull");
        FlightInstance otherObject = null;
        FlightInstance instance = new FlightInstance();
        instance.flightDesignator = "F001";
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("equalsDifferent");
        otherObject = new FlightInstance();
        result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("equalsEqual");
        otherObject.flightDesignator = "F001";
        expResult = true;
        result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("equalsSame");
        otherObject = new FlightInstance(instance);
        result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class FlightInstance.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        FlightInstance instance = new FlightInstance();
        int expResult = Objects.hashCode(instance);
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}
