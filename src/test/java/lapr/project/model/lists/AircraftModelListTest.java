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

    
}
