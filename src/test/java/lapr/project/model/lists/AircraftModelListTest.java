/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AircraftModel;
import lapr.project.model.Regime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AircraftModelListTest {
    
    public AircraftModelListTest() {
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
     * Test of getModelList method, of class AircraftModelList.
     */
    @Test
    public void testGetModelList() {
        System.out.println("getModelList");
        AircraftModelList instance = new AircraftModelList();
        List<AircraftModel> expResult = new LinkedList<>();
        instance.setModelList(expResult);
        List<AircraftModel> result = instance.getModelList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModelList method, of class AircraftModelList.
     */
    @Test
    public void testSetModelList() {
        System.out.println("setModelList");
        List<AircraftModel> modelList = new LinkedList<>();
        AircraftModelList instance = new AircraftModelList();
        instance.setModelList(modelList);
    }

    /**
     * Test of setAircraftModelData method, of class AircraftModelList.
     */
    @Test
    public void testSetAircraftModelData() {
        System.out.println("setAircraftModelData");
        String id = "abc";
        String description = "sdf";
        String maker = "df";
        String type = "passenger";
        double eWeight = 10.0;
        double MTOW = 10.0;
        double MZFW = 10.0;
        double maxPayload = 10.0;
        double fuelCapacity = 10.0;
        double VMO = 10.0;
        double MMO = 10.0;
        double wingArea = 10.0;
        double wingSpan = 10.0;
        double wingCl = 10.0;
        double bodyCl = 10.0;
        double cDrag = 10.0;
        double e = 10.0;
        AircraftModelList instance = new AircraftModelList();
        instance.setAircraftModelData(id, description, maker, type, eWeight, 
                MTOW, MZFW, maxPayload, fuelCapacity, VMO, MMO, wingArea, 
                wingSpan, wingCl, bodyCl, cDrag, e);
    }

    /**
     * Test of setAircraftModelMotorization method, of class AircraftModelList.
     */
    @Test
    public void testSetAircraftModelMotorization() {
        System.out.println("setAircraftModelMotorization");
        int number_motors = 40;
        String motor = "erdfhc";
        String motor_type = "gfjf";
        List<Regime> regimeList = new LinkedList<>();
        Regime r = new Regime("id", 23, 23, 34, 34);
        regimeList.add(r);
        AircraftModelList instance = new AircraftModelList();
        String id = "abc";
        String description = "sdf";
        String maker = "df";
        String type = "passenger";
        double eWeight = 10.0;
        double MTOW = 10.0;
        double MZFW = 10.0;
        double maxPayload = 10.0;
        double fuelCapacity = 10.0;
        double VMO = 10.0;
        double MMO = 10.0;
        double wingArea = 10.0;
        double wingSpan = 10.0;
        double wingCl = 10.0;
        double bodyCl = 10.0;
        double cDrag = 10.0;
        double e = 10.0;
        instance.setAircraftModelData(id, description, maker, type, eWeight,
                MTOW, MZFW, maxPayload, fuelCapacity, VMO, MMO, wingArea, 
                wingSpan, wingCl, bodyCl, cDrag, e);
        instance.setAircraftModelMotorization(number_motors, motor, motor_type, regimeList);
    }

    /**
     * Test of saveAircrcaftModel method, of class AircraftModelList.
     */
    @Test
    public void testSaveAircrcaftModel() {
        System.out.println("saveAircrcaftModel");
        AircraftModelList instance = new AircraftModelList();
        String id = "abc";
        String description = "sdf";
        String maker = "df";
        String type = "passenger";
        double eWeight = 10.0;
        double MTOW = 10.0;
        double MZFW = 10.0;
        double maxPayload = 10.0;
        double fuelCapacity = 10.0;
        double VMO = 10.0;
        double MMO = 10.0;
        double wingArea = 10.0;
        double wingSpan = 10.0;
        double wingCl = 10.0;
        double bodyCl = 10.0;
        double cDrag = 10.0;
        double e = 10.0;
        instance.setAircraftModelData(id, description, maker, type, eWeight,
                MTOW, MZFW, maxPayload, fuelCapacity, VMO, MMO, wingArea, 
                wingSpan, wingCl, bodyCl, cDrag, e);
        List<Regime> regimeList = new LinkedList<>();
        Regime r = new Regime("id", 23, 23, 34, 34);
        regimeList.add(r);
        instance.setAircraftModelMotorization(23, "asf", "passenger", regimeList);
        boolean expResult = true;
        boolean result = instance.saveAircrcaftModel();
        assertEquals(expResult, result);
    }
    
}
