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
public class RegularFlightTest {

    public RegularFlightTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of toString method, of class RegularFlight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RegularFlight instance = new RegularFlight();
        instance.flightDesignator = "F001";
        String expResult = "F001";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class RegularFlight.
     */
    @Test
    public void testEquals() {
        System.out.println("equalsNull");
        RegularFlight otherObject = null;
        RegularFlight instance = new RegularFlight();
        instance.flightDesignator = "F001";
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);

        System.out.println("equalsDifferent");
        otherObject = new RegularFlight();
        result = instance.equals(otherObject);
        assertEquals(expResult, result);

        System.out.println("equalsEqual");
        otherObject.flightDesignator = "F001";
        expResult = true;
        result = instance.equals(otherObject);
        assertEquals(expResult, result);

        System.out.println("equalsSame");
        otherObject = new RegularFlight(instance);
        result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class RegularFlight.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        RegularFlight instance = new RegularFlight();
        int expResult = Objects.hashCode(instance);
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

}
