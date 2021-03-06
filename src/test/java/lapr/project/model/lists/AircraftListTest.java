/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Motorization;
import lapr.project.model.Thrust_Function;
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
        int NrOfElements = 10;
        AircraftList instance = new AircraftList(new LinkedList<>());
        instance.createAircraft();
        boolean expResult = true;
        boolean result = instance.setAircraftData(registration, company, new HashMap<String,Integer>(), NrOfElements);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setAircraftModel method, of class AircraftList.
     */
    @Test
    public void testSetAircraftModel() {
        System.out.println("setAircraftModel");
        AircraftModel model = new AircraftModel("id", "description", "maker", "passenger", 
                new Motorization(4, "fd", "dsffv", 4, 4, 4, 4, new Thrust_Function()),
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, new LinkedList<>());
        AircraftList instance = new AircraftList(new AircraftList());
        boolean expResult = true;
        instance.createAircraft();
        boolean result = instance.setAircraftModel(model);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAircraftsListString method, of class AircraftList.
     */
    @Test
    public void testGetAircraftsListString() {
        System.out.println("getAircraftsListString");
        AircraftList instance = new AircraftList();
        List<String> expResult = new LinkedList<>();
        List<String> result = instance.getAircraftsListString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAircraftByString method, of class AircraftList.
     */
    @Test
    public void testGetAircraftByString() {
        System.out.println("getAircraftByString");
        String id = "";
        AircraftList instance = new AircraftList();
        Aircraft expResult = null;
        Aircraft result = instance.getAircraftByString(id);
        assertEquals(expResult, result);
    }
    
}
