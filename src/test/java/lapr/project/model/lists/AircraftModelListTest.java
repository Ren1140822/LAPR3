/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AircraftModel;
import lapr.project.model.Thrust_Function;
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
        AircraftModelList instance = new AircraftModelList(new LinkedList<>());
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
        String id = "eawt";
        String description = "et";
        String maker = "et";
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
        double aspect_ratio = 10.0;
        double e = 10.0;
        AircraftModelList instance = new AircraftModelList();
        instance.setAircraftModelData(id, description, maker, type, eWeight, MTOW, MZFW, maxPayload, fuelCapacity, VMO, MMO, wingArea, wingSpan, wingCl, bodyCl, cDrag, aspect_ratio, e);
    }

    /**
     * Test of setCdrag_function method, of class AircraftModelList.
     */
    @Test
    public void testSetCdrag_function() {
        System.out.println("setCdrag_function");
        double speed = 10.0;
        double cdrag_0 = 10.0;
        AircraftModelList instance = new AircraftModelList();
        instance.setAircraftModelData("id", "description", "maker", "passenger", 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        instance.setCdrag_function(speed, cdrag_0);
    }

    /**
     * Test of setMotorization method, of class AircraftModelList.
     */
    @Test
    public void testSetMotorization() {
        System.out.println("setMotorization");
        
        int number_motors = 10;
        String motor = "fd";
        String motor_type = "aerg";
        double cruise_altitude = 10.0;
        double cruise_speed = 10.0;
        double TSFC = 10.0;
        double lapse_rate_factor = 10.0;
        Thrust_Function thrust_function = new Thrust_Function(10, 3, 3);
        AircraftModelList instance = new AircraftModelList();
        instance.setAircraftModelData("id", "description", "maker", "passenger", 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        instance.setMotorization(number_motors, motor, motor_type, cruise_altitude, cruise_speed, TSFC, lapse_rate_factor, thrust_function);
    }

    /**
     * Test of saveAircrcaftModel method, of class AircraftModelList.
     */
    @Test
    public void testSaveAircrcaftModel() {
        System.out.println("saveAircrcaftModel");
        AircraftModelList instance = new AircraftModelList();
        instance.setAircraftModelData("id", "description", "maker", "passenger", 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        instance.setMotorization(4, "fd", "dsffv", 4, 4, 4, 4, new Thrust_Function());
        boolean expResult = true;
        boolean result = instance.saveAircrcaftModel();
        assertEquals(expResult, result);
    }

    
}
