/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AircraftTest {
    Aircraft instance = new Aircraft();
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
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class Aircraft.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = new Aircraft();
        Aircraft instance = this.instance;
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
        Aircraft instance =this.instance;
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
        Aircraft instance =this.instance;
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
        Aircraft instance = this.instance;
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
        Aircraft instance = this.instance;
        instance.setCompany(company);
        assertEquals(instance.getCompany(), "new comp");
    }

    /**
     * Test of getCabinConfig method, of class Aircraft.
     */
    @Test
    public void testGetCabinConfig() {
        System.out.println("getCabinConfig");
        Aircraft instance =this.instance;
        CabinConfiguration expResult = new CabinConfiguration(0,0);
        CabinConfiguration result = instance.getCabinConfig();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setCabinConfig method, of class Aircraft.
     */
    @Test
    public void testSetCabinConfig() {
        System.out.println("setCabinConfig");
        CabinConfiguration cabinConfig = new CabinConfiguration(1,1);
        Aircraft instance = this.instance;
        instance.setCabinConfig(cabinConfig);
        assertEquals(instance.getCabinConfig(), cabinConfig);
    }

    /**
     * Test of getNrOfCrewElements method, of class Aircraft.
     */
    @Test
    public void testGetNrOfCrewElements() {
        System.out.println("getNrOfCrewElements");
        Aircraft instance = this.instance;
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
        Aircraft instance = this.instance;
        instance.setNrOfCrewElements(nrOfCrewElements);
           assertEquals(instance.getNrOfCrewElements(),nrOfCrewElements);
      
    }

    /**
     * Test of validate method, of class Aircraft.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Aircraft instance = this.instance;
        boolean expResult = true;
        instance.setNrOfCrewElements(1);
      
        boolean result = instance.validate();
        assertEquals(expResult, result);
  
    }
    
}
