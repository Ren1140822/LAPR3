/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Project;
import lapr.project.model.analysis.Path;
import lapr.project.model.analysis.SegmentResult;
import lapr.project.model.analysis.ShortestPathResult;
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
public class ExportCSVControllerTest {
    
    ExportCSVController instance;
    Project p;
    public ExportCSVControllerTest() {
           p = new Project();
        this.instance = new ExportCSVController(p);
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
     * Test of getAvailableResults method, of class ExportCSVController.
     */
    @Test
    public void testGetAvailableResults() {
        System.out.println("getAvailableResults");
        String sim = "Simulation";
       
        ShortestPathResult sp = new ShortestPathResult(new FlightPlan());
        sp.calculateBestPath(new AirNetwork());
        Simulation simu = new Simulation();
        simu.setShortestResultPath(sp);
        p.getSimulationsList().getSimulationsList().add(simu);
           ExportCSVController instance = new ExportCSVController(p);
        Map<String, Path> expResult = new HashMap<>();
        expResult.put("Best Consumption", p.getSimulationsList().getSimulationsList().getFirst().getEcologicResultPath());
        expResult.put("Fastest Path", p.getSimulationsList().getSimulationsList().getFirst().getFastestResultPath());
        expResult.put("Shortest Path", p.getSimulationsList().getSimulationsList().getFirst().getShortestResultPath());
        Map<String, Path> result = instance.getAvailableResults(sim);
        assertEquals(expResult, result);

    }

    /**
     * Test of getSimulationsList method, of class ExportCSVController.
     */
    @Test
    public void testGetSimulationsList() {
        System.out.println("getSimulationsList");
    
        List<String> simString = new LinkedList<>();
        List<Simulation> simlist = new LinkedList();
        Simulation sim = new Simulation();
        sim.createPathSimulation(TypePath.ALL);
        simlist.add(sim);
     
            p.getSimulationsList().getSimulationsList().add(sim);
         this.instance = new ExportCSVController(p);
        simString.add(sim.toString());
        List<String> result = instance.getSimulationsList();
        assertEquals(simString, result);

    }

    /**
     * Test of getFlightPathAnalisysResultsGroupedByOriginDestination method, of
     * class ExportCSVController.
     */
    @Test
    public void testGetFlightPathAnalisysResultsGroupedByOriginDestination() {
        System.out.println("getFlightPathAnalisysResultsGroupedByOriginDestination");
        String startNode = "node1";
        String endNode = "node2";
        ExportCSVController instance = this.instance;
        List<String> expResult = new LinkedList<>();
        List<String> result = instance.getFlightPathAnalisysResultsGroupedByOriginDestination(startNode, endNode);
        assertEquals(expResult, result);
      
    }
//
    /**
     * Test of getFlightPathAnalisysResultsGroupedByAircraftType method, of
     * class ExportCSVController.
     */
    @Test
    public void testGetFlightPathAnalisysResultsGroupedByAircraftType() {
        System.out.println("getFlightPathAnalisysResultsGroupedByAircraftType");
        String aircrafType = "A380";
          ExportCSVController instance = this.instance;
        List<String> expResult = new LinkedList<>();
        List<String> result = instance.getFlightPathAnalisysResultsGroupedByAircraftType(aircrafType);
        assertEquals(expResult, result);
      
    }
//
    /**
     * Test of getListOfAircraftTypes method, of class ExportCSVController.
     */
    @Test
    public void testGetListOfAircraftTypes() {
        System.out.println("getListOfAircraftTypes");
        AircraftModel acModel = new AircraftModel();
        acModel.setId("PASSENGER");
        Simulation sim = new Simulation();
         sim.getFlightPlan().getAircraft().setAircraftModel(acModel);
         p.getSimulationsList().getSimulationsList().add(sim);
        this.instance = new ExportCSVController(p);
        ExportCSVController instance = this.instance;
        
        List<String> expResult =  new LinkedList<>();
        expResult.add(acModel.getId());
        List<String> result = instance.getListOfAircraftTypes();
        assertEquals(expResult, result);
      
    }
//
    /**
     * Test of getListOfNodes method, of class ExportCSVController.
     */
    @Test
    public void testGetListOfNodes() {
        System.out.println("getListOfNodes");
         Simulation sim = new Simulation();
         sim.setData(0, 0, 0, 0, new Airport(), new Airport(),new Aircraft());
         p.getSimulationsList().getSimulationsList().add(sim);
        ExportCSVController instance = new ExportCSVController(p);
        
        List<String> expResult = new LinkedList<>();
        expResult.add("No IATA code.");
        List<String> result = instance.getListOfNodes();
        assertEquals(expResult, result);
      
    }
    
     @Test
    public void testExportResults() throws FileNotFoundException {
         System.out.println("exportResults");
          Simulation sm = new Simulation();
        sm.createPathSimulation(TypePath.ALL);
        SegmentResult r  = new SegmentResult();
        LinkedList<SegmentResult> segs = new LinkedList<>();
        segs.add(r);
        sm.getEcologicResultPath().setSegments(segs);
           p.getSimulationsList().getSimulationsList().add(sm);
        this.instance = new ExportCSVController(p);
        String[] s = new String[1];
        s[0] = "Simulation";
         String filePath = "src/main/resources/testhtml3.html";
           File file = new File(filePath);
        String whatToExport = "eco";
        ExportCSVController instance =  this.instance;
      
        boolean expResult =  true;
        boolean result = instance.exportResults(s, filePath, whatToExport);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testExportResults_2() throws FileNotFoundException {
         System.out.println("exportResults");
          Simulation sm = new Simulation();
        sm.createPathSimulation(TypePath.ALL);
        SegmentResult r  = new SegmentResult();
        LinkedList<SegmentResult> segs = new LinkedList<>();
        segs.add(r);
        sm.getShortestResultPath().setSegments(segs);
           p.getSimulationsList().getSimulationsList().add(sm);
        this.instance = new ExportCSVController(p);
        String[] s = new String[1];
        s[0] = "Simulation";
         String filePath = "src/main/resources/testhtml3.html";
           File file = new File(filePath);
        String whatToExport = "short";
        ExportCSVController instance =  this.instance;
      
        boolean expResult =  true;
        boolean result = instance.exportResults(s, filePath, whatToExport);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testExportResults_3() throws FileNotFoundException {
         System.out.println("exportResults");
          Simulation sm = new Simulation();
        sm.createPathSimulation(TypePath.ALL);
        SegmentResult r  = new SegmentResult();
        LinkedList<SegmentResult> segs = new LinkedList<>();
        segs.add(r);
        sm.getFastestResultPath().setSegments(segs);
           p.getSimulationsList().getSimulationsList().add(sm);
        this.instance = new ExportCSVController(p);
        String[] s = new String[1];
        s[0] = "Simulation";
         String filePath = "src/main/resources/testhtml3.html";
           File file = new File(filePath);
        String whatToExport = "fast";
        ExportCSVController instance =  this.instance;
      
        boolean expResult =  true;
        boolean result = instance.exportResults(s, filePath, whatToExport);
        assertEquals(expResult, result);
    }
}
