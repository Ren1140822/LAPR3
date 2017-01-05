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
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AirportTest {

    Airport instance2 = new Airport();

    public AirportTest() {
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
     * Test of getName method, of class Airport.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Airport instance = this.instance2;
        String expResult = "No name.";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setName method, of class Airport.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "newname";
        Airport instance = new Airport(new Airport());
        instance.setName(name);
        assertEquals(instance.getName(), "newname");
    }

    /**
     * Test of getTown method, of class Airport.
     */
    @Test
    public void testGetTown() {
        System.out.println("getTown");
        Airport instance = new Airport();
        String expResult = "No town.";
        String result = instance.getTown();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTown method, of class Airport.
     */
    @Test
    public void testSetTown() {
        System.out.println("setTown");
        String town = "newtown";
        Airport instance = new Airport();
        instance.setTown(town);
        assertEquals(instance.getTown(), "newtown");
    }

    /**
     * Test of getCountry method, of class Airport.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        Airport instance = new Airport();
        String expResult = "No country.";
        String result = instance.getCountry();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCountry method, of class Airport.
     */
    @Test
    public void testSetCountry() {
        System.out.println("setCountry");
        String country = "newcountry";
        Airport instance = new Airport();
        instance.setCountry(country);
        assertEquals(instance.getCountry(), "newcountry");
    }

    /**
     * Test of getIATA method, of class Airport.
     */
    @Test
    public void testGetIATA() {
        System.out.println("getIATA");
        Airport instance = new Airport();
        String expResult = "No IATA code.";
        String result = instance.getIATA();
        assertEquals(expResult, result);

    }

    /**
     * Test of setIATA method, of class Airport.
     */
    @Test
    public void testSetIATA() {
        System.out.println("setIATA");
        String IATA = "new IATA";
        Airport instance = new Airport();
        instance.setIATA(IATA);
        assertEquals(instance.getIATA(), "new IATA");
    }

    /**
     * Test of getLocation method, of class Airport.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Airport instance = new Airport();
        Location expResult = new Location(0.0, 0.0, 0);
        Location result = instance.getLocation();
        assertEquals(expResult, result);

    }

    /**
     * Test of setLocation method, of class Airport.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        double latitude = 0.1;
        double longitude = 0.1;
        int altitude = 0;
        Airport instance = new Airport();
        instance.setLocation(latitude, longitude, altitude);
        assertEquals(instance.getLocation(), new Location(latitude, longitude, altitude));
    }

    /**
     * Test of toString method, of class Airport.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Airport instance = new Airport();
        String expResult = "No IATA code.";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Airport.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new Airport();
        Airport instance = new Airport();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class Airport.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Airport instance = new Airport();
        int hash = 3;
        hash = 29 * hash + instance.getName().hashCode();
        hash = 29 * hash + instance.getTown().hashCode();
        hash = 29 * hash + instance.getCountry().hashCode();
        hash = 29 * hash + instance.getIATA().hashCode();
        int result = instance.hashCode();
        assertEquals(hash, result);

    }

    /**
     * Test of validate method, of class Airport.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Airport instance = new Airport();
        boolean expResult = true;
        boolean result = instance.validate();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAirdensityAirport method, of class Airport.
     */
    @Test
    public void testGetAirdensityAirport() {
        System.out.println("getAirdensityAirport");
        double altitude=1000;
        Airport instance = new Airport("", "", "", "", new Location(1,1, altitude));
        double expResult = 1.11164;
        double result = instance.getAirdensityAirport();
        assertEquals(expResult, result, 0.5);
    }
}
