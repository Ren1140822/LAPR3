/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Aircraft;
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
public class AircraftListTest {
       AircraftList instance2 = new AircraftList();
    public AircraftListTest() {
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
     * Test of getAircraftList method, of class AircraftList.
     */
    @Test
    public void testGetAircraftList() {
        System.out.println("getAircraftList");
     
        List<Aircraft> expResult = new LinkedList<>();
        instance2.setAircrafttList(expResult);
        List<Aircraft> result = instance2.getAircraftList();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of setAircrafttList method, of class AircraftList.
     */
    @Test
    public void testSetAircrafttList() {
        System.out.println("setAircrafttList");
        LinkedList<Aircraft> aircraftList =  new LinkedList<Aircraft>();
        aircraftList.add(new Aircraft());
        AircraftList instance =this.instance2;
        instance.setAircrafttList(aircraftList);
        assertEquals(instance.getAircraftList(), aircraftList);
    }

    /**
     * Test of createAircraft method, of class AircraftList.
     */
    @Test
    public void testCreateAircraft() {
        System.out.println("createAircraft");
        AircraftList instance = new AircraftList();
        instance.createAircraft();
        assertEquals(instance.aircraft,new Aircraft());
    }

    /**
     * Test of setAircraftData method, of class AircraftList.
     */
    @Test
    public void testSetAircraftData() {
        System.out.println("setAircraftData");
        String registration = "reg1";
        String company = "cmp1";
        int nrOfSeatsEcon = 10;
        int nrOfSeatsCommercial = 10;
        int NrOfElements = 10;
        AircraftList instance = this.instance2;
        instance.createAircraft();
        boolean expResult = true;
        boolean result = instance.setAircraftData(registration, company, nrOfSeatsEcon, nrOfSeatsCommercial, NrOfElements);
        assertEquals(expResult, result);
        
    }
    
}
