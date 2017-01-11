/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
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
public class AircraftTest {
    Aircraft instance2 = new Aircraft();
    public AircraftTest() {
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
     * Test of toString method, of class Aircraft.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "No Registration ID.";
        String result = instance2.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Aircraft.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = this.instance2;
        Aircraft instance = this.instance2;
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getRegistration method, of class Aircraft.
     */
    @Test
    public void testGetRegistration() {
        System.out.println("getRegistration");
        Aircraft instance = new Aircraft(instance2);
        String expResult = "No Registration ID.";
        String result = instance.getRegistration();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setRegistration method, of class Aircraft.
     */
    @Test
    public void testSetRegistration() {
        System.out.println("setRegistration");
        String registration = "new reg";
        Aircraft instance =this.instance2;
        instance.setRegistration(registration);
        String result = instance.getRegistration();
          assertEquals(result,"new reg");
    }

    /**
     * Test of getCompany method, of class Aircraft.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        Aircraft instance = this.instance2;
        String expResult = "No Company.";
        String result = instance.getCompany();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setCompany method, of class Aircraft.
     */
    @Test
    public void testSetCompany() {
        System.out.println("setCompany");
        String company = "new comp";
        Aircraft instance = this.instance2;
        instance.setCompany(company);
        assertEquals(instance.getCompany(), "new comp");
    }

    /**
     * Test of getCabinConfig method, of class Aircraft.
     */
    @Test
    public void testGetCabinConfig() {
        System.out.println("getCabinConfig");
        Aircraft instance =this.instance2;
        CabinConfiguration expResult = new CabinConfiguration();
        CabinConfiguration result = instance.getCabinConfig();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setCabinConfig method, of class Aircraft.
     */
    @Test
    public void testSetCabinConfig() {
        System.out.println("setCabinConfig");
        CabinConfiguration cabinConfig = new CabinConfiguration();
        Aircraft instance = this.instance2;
        instance.setCabinConfig(cabinConfig);
        assertEquals(instance.getCabinConfig(), cabinConfig);
    }

    /**
     * Test of getNrOfCrewElements method, of class Aircraft.
     */
    @Test
    public void testGetNrOfCrewElements() {
        System.out.println("getNrOfCrewElements");
        Aircraft instance = this.instance2;
        int expResult = 0;
        int result = instance.getNrOfCrewElements();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of setNrOfCrewElements method, of class Aircraft.
     */
    @Test
    public void testSetNrOfCrewElements() {
        System.out.println("setNrOfCrewElements");
        int nrOfCrewElements = 3;
        Aircraft instance = this.instance2;
        instance.setNrOfCrewElements(nrOfCrewElements);
           assertEquals(instance.getNrOfCrewElements(),nrOfCrewElements);
      
    }

    /**
     * Test of validate method, of class Aircraft.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Aircraft instance = this.instance2;
        boolean expResult = true;
        instance.setNrOfCrewElements(1);
      
        boolean result = instance.validate();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of hashCode method, of class Aircraft.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Aircraft instance = new Aircraft();
        int expResult = 7;
        expResult = expResult *79 + instance.getRegistration().hashCode();
        expResult = expResult *79 + instance.getCompany().hashCode();
        expResult = expResult *79 + instance.getCabinConfig().hashCode();
        expResult = expResult *79 + instance.getNrOfCrewElements();
        expResult = expResult *79 + instance.getAircraftModel().hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAircraftModel method, of class Aircraft.
     */
    @Test
    public void testGetAircraftModel() {
        System.out.println("getAircraftModel");
        Aircraft instance = new Aircraft();
        AircraftModel expResult = new AircraftModel(new AircraftModel());
        AircraftModel result = instance.getAircraftModel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAircraftModel method, of class Aircraft.
     */
    @Test
    public void testSetAircraftModel() {
        System.out.println("setAircraftModel");
        AircraftModel aircraftModel = new AircraftModel("id", "description", "maker", "passenger", 
                new Motorization(), 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, new LinkedList<>());
        Aircraft instance = new Aircraft();
        instance.setAircraftModel(aircraftModel);

    }

}
