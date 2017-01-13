/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import lapr.project.model.analysis.ComparisonResult;
import lapr.project.model.analysis.Simulation;
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
public class CompareResultsListTest {
    
    public CompareResultsListTest() {
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
     * Test of getCompareResults method, of class CompareResultsList.
     */
    @Test
    public void testGetCompareResults() {
        System.out.println("getCompareResults");
        CompareResultsList instance = new CompareResultsList();
        LinkedList<ComparisonResult> expResult = new LinkedList<>();
        instance.setCompareList(expResult);
        LinkedList<ComparisonResult> result = instance.getCompareResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompareList method, of class CompareResultsList.
     */
    @Test
    public void testSetCompareList() {
        System.out.println("setCompareList");
        LinkedList<ComparisonResult> list = new LinkedList<>();
        CompareResultsList instance = new CompareResultsList();
        instance.setCompareList(list);
    }

    /**
     * Test of getOptions method, of class CompareResultsList.
     */
    @Test
    public void testGetOptions() {
        System.out.println("getOptions");
        CompareResultsList instance = new CompareResultsList();
        String[] expResult = {"AIRCRAFT", "ENGINES"};
        String[] result = instance.getOptions();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of createComparison method, of class CompareResultsList.
     */
    @Test
    public void testCreateComparison() {
        System.out.println("createComparison");
        CompareResultsList instance = new CompareResultsList();
        instance.createComparison();
    }

    /**
     * Test of getCompareResult method, of class CompareResultsList.
     */
    @Test
    public void testGetCompareResult() {
        System.out.println("getCompareResult");
        CompareResultsList instance = new CompareResultsList();
        instance.createComparison();
        ComparisonResult expResult = instance.getCompareResult();        
        ComparisonResult result = instance.getCompareResult();
        assertEquals(expResult, result);
    }

    /**
     * Test of saveCompareResult method, of class CompareResultsList.
     */
    @Test
    public void testSaveCompareResult() {
        System.out.println("saveCompareResult1");
        CompareResultsList instance = new CompareResultsList();
        instance.createComparison();
        boolean expResult = false;
        boolean result = instance.saveCompareResult();
        assertEquals(expResult, result);
        
        System.out.println("saveCompareResult2");
        CompareResultsList instance2 = new CompareResultsList();
        instance2.createComparison();
        instance2.getCompareResult().setAircraftModel("aircraft");
        instance2.getCompareResult().setAvgDistance(20);
        instance2.getCompareResult().setAvgFuel(245671);
        instance2.getCompareResult().setAvgTimeFlight(34567);
        instance2.getCompareResult().setMotorization("motoriz");
        
        LinkedList<Simulation> simulList = new LinkedList<>();
        Simulation s=new Simulation();
        simulList.add(s);      
        
        instance2.getCompareResult().setSimulationsCompared(simulList);
        
        boolean expResult2 = true;
        boolean result2 = instance2.saveCompareResult();
        assertEquals(expResult2, result2);
    }
    
}
