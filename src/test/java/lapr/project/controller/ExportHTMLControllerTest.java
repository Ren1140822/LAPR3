/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

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
import lapr.project.model.analysis.ShortestPathResult;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;
import lapr.project.utils.HTMLExporterTest;

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
public class ExportHTMLControllerTest {

    ExportHTMLController instance;
    Project p;

    public ExportHTMLControllerTest() {
        p = new Project();
        this.instance = new ExportHTMLController(p);

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
     * Test of getAvailableResults method, of class ExportHTMLController.
     */
    @Test
    public void testGetAvailableResults() {
        System.out.println("getAvailableResults");
        String sim = "Simulation";
        ExportHTMLController instance = this.instance;
        ShortestPathResult sp = new ShortestPathResult(new FlightPlan());
        sp.calculateBestPath(new AirNetwork());
        Simulation simu = new Simulation();
        simu.setShortestResultPath(sp);
        p.getSimulationsList().getSimulationsList().add(simu);
        Map<String, Path> expResult = new HashMap<>();
        expResult.put("Best consumption", p.getSimulationsList().getSimulationsList().getFirst().getEcologicResultPath());
        expResult.put("Fastest path", p.getSimulationsList().getSimulationsList().getFirst().getFastestResultPath());
        expResult.put("ShortestPath", p.getSimulationsList().getSimulationsList().getFirst().getShortestResultPath());
        Map<String, Path> result = instance.getAvailableResults(sim);
        assertEquals(expResult, result);

    }

    /**
     * Test of getSimulationsList method, of class ExportHTMLController.
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
        this.instance = new ExportHTMLController(p);
        simString.add(sim.toString());
        List<String> result = instance.getSimulationsList();
        assertEquals(simString, result);

    }

    /**
     * Test of getFlightPathAnalisysResultsGroupedByOriginDestination method, of
     * class ExportHTMLController.
     */
    @Test
    public void testGetFlightPathAnalisysResultsGroupedByOriginDestination() {
        System.out.println("getFlightPathAnalisysResultsGroupedByOriginDestination");
        String startNode = "node1";
        String endNode = "node2";
        ExportHTMLController instance = this.instance;
        List<String> expResult = new LinkedList<>();
        List<String> result = instance.getFlightPathAnalisysResultsGroupedByOriginDestination(startNode, endNode);
        assertEquals(expResult, result);

    }
//

    /**
     * Test of getFlightPathAnalisysResultsGroupedByAircraftType method, of
     * class ExportHTMLController.
     */
    @Test
    public void testGetFlightPathAnalisysResultsGroupedByAircraftType() {
        System.out.println("getFlightPathAnalisysResultsGroupedByAircraftType");
        String aircrafType = "A380";
        ExportHTMLController instance = this.instance;
        List<String> expResult = new LinkedList<>();
        List<String> result = instance.getFlightPathAnalisysResultsGroupedByAircraftType(aircrafType);
        assertEquals(expResult, result);

    }
//

    /**
     * Test of getListOfAircraftTypes method, of class ExportHTMLController.
     */
    @Test
    public void testGetListOfAircraftTypes() {
        System.out.println("getListOfAircraftTypes");
        AircraftModel acModel = new AircraftModel();
        acModel.setId("PASSENGER");
        Simulation sim = new Simulation();
        sim.getFlightPlan().getAircraft().setAircraftModel(acModel);
        p.getSimulationsList().getSimulationsList().add(sim);
        this.instance = new ExportHTMLController(p);
        ExportHTMLController instance = this.instance;

        List<String> expResult = new LinkedList<>();
        expResult.add(acModel.getId());
        List<String> result = instance.getListOfAircraftTypes();
        assertEquals(expResult, result);

    }
//

    /**
     * Test of getListOfNodes method, of class ExportHTMLController.
     */
    @Test
    public void testGetListOfNodes() {
        System.out.println("getListOfNodes");
        Simulation sim = new Simulation();
        sim.setData(0, 0, 0, 0, new Airport(), new Airport(), new Aircraft());
        p.getSimulationsList().getSimulationsList().add(sim);
        ExportHTMLController instance = new ExportHTMLController(p);

        List<String> expResult = new LinkedList<>();
        expResult.add("No IATA code.");
        List<String> result = instance.getListOfNodes();
        assertEquals(expResult, result);

    }

    @Test
    public void testExportResults() throws FileNotFoundException {
            HTMLExporterTest test = new HTMLExporterTest();
            test.testExportStringsToHTML_5args_1();
            assertTrue(test.isResult());
    }

}
