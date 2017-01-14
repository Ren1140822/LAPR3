/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.FlightPlan;
import lapr.project.model.Project;
import lapr.project.model.analysis.SegmentResult;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;
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
public class FindBestPathResultControllerTest {
      FindBestPathController instance ;
      Project p;
    public FindBestPathResultControllerTest() {
        p = new Project();
        instance = new FindBestPathController(p);
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
     * Test of getSegmentInformation method, of class FindBestPathResultController.
     */
    @Test
    public void testGetSegmentInformation() {
        System.out.println("getSegmentInformation");
         FlightPlan plan = new FlightPlan();
           Simulation sm = new Simulation();
        sm.createPathSimulation(TypePath.ALL);
        
        SegmentResult r = new SegmentResult();
        r.getSegment().setId("seg1");
        LinkedList<SegmentResult> segs = new LinkedList<>();
        segs.add(r);
        sm.getFastestResultPath().setSegments(segs);
         sm.getShortestResultPath().setSegments(segs);
             sm.getEcologicResultPath().setSegments(segs);
        p.getSimulationsList().getSimulationsList().add(sm);
        String segID = "seg1";
        FindBestPathResultController instance = new FindBestPathResultController(sm);
        instance.getSegmentInformation(segID);
    
    }

//    /**
//     * Test of getSimulation method, of class FindBestPathResultController.
//     */
//    @Test
//    public void testGetSimulation() {
//        System.out.println("getSimulation");
//        FindBestPathResultController instance = null;
//        Simulation expResult = null;
//        Simulation result = instance.getSimulation();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNodeID method, of class FindBestPathResultController.
//     */
//    @Test
//    public void testGetNodeID() {
//        System.out.println("getNodeID");
//        FindBestPathResultController instance = null;
//        String expResult = "";
//        String result = instance.getNodeID();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEndNodeID method, of class FindBestPathResultController.
//     */
//    @Test
//    public void testGetEndNodeID() {
//        System.out.println("getEndNodeID");
//        FindBestPathResultController instance = null;
//        String expResult = "";
//        String result = instance.getEndNodeID();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTas method, of class FindBestPathResultController.
//     */
//    @Test
//    public void testGetTas() {
//        System.out.println("getTas");
//        FindBestPathResultController instance = null;
//        double expResult = 0.0;
//        double result = instance.getTas();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getInitAltitude method, of class FindBestPathResultController.
//     */
//    @Test
//    public void testGetInitAltitude() {
//        System.out.println("getInitAltitude");
//        FindBestPathResultController instance = null;
//        double expResult = 0.0;
//        double result = instance.getInitAltitude();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFinalAlt method, of class FindBestPathResultController.
//     */
//    @Test
//    public void testGetFinalAlt() {
//        System.out.println("getFinalAlt");
//        FindBestPathResultController instance = null;
//        double expResult = 0.0;
//        double result = instance.getFinalAlt();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFuelConsumption method, of class FindBestPathResultController.
//     */
//    @Test
//    public void testGetFuelConsumption() {
//        System.out.println("getFuelConsumption");
//        FindBestPathResultController instance = null;
//        double expResult = 0.0;
//        double result = instance.getFuelConsumption();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDistance method, of class FindBestPathResultController.
//     */
//    @Test
//    public void testGetDistance() {
//        System.out.println("getDistance");
//        FindBestPathResultController instance = null;
//        double expResult = 0.0;
//        double result = instance.getDistance();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFlightTime method, of class FindBestPathResultController.
//     */
//    @Test
//    public void testGetFlightTime() {
//        System.out.println("getFlightTime");
//        FindBestPathResultController instance = null;
//        double expResult = 0.0;
//        double result = instance.getFlightTime();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSegmentsList method, of class FindBestPathResultController.
//     */
//    @Test
//    public void testGetSegmentsList() {
//        System.out.println("getSegmentsList");
//        TypePath type = null;
//        FindBestPathResultController instance = null;
//        List<SegmentResult> expResult = null;
//        List<SegmentResult> result = instance.getSegmentsList(type);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
