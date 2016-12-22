/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.anaylsis.ResultPath;
import lapr.project.model.lists.AircraftList;
import lapr.project.model.lists.AircraftModelList;
import lapr.project.model.lists.AirportList;
import lapr.project.model.lists.CompareResultsList;
import lapr.project.model.lists.SimulationsList;
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
public class ProjectTest {
    
    public ProjectTest() {
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
     * Test of getAircraftList method, of class Project.
     */
    @Test
    public void testGetAircraftList() {
        System.out.println("getAircraftList");
        Project instance = new Project();
        AircraftList expResult = new AircraftList();
        instance.setAircraftList(expResult);
        AircraftList result = instance.getAircraftList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAircraftList method, of class Project.
     */
    @Test
    public void testSetAircraftList() {
        System.out.println("setAircraftList");
        AircraftList aircraftList = new AircraftList();
        Project instance = new Project();
        instance.setAircraftList(aircraftList);
    }

    /**
     * Test of getAirNetwork method, of class Project.
     */
    @Test
    public void testGetAirNetwork() {
        System.out.println("getAirNetwork");
        Project instance = new Project();
        AirNetwork expResult = new AirNetwork();
        instance.setAirNetwork(expResult);
        AirNetwork result = instance.getAirNetwork();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAirNetwork method, of class Project.
     */
    @Test
    public void testSetNetwork() {
        System.out.println("setNetwork");
        AirNetwork network = new AirNetwork();
        Project instance = new Project();
        instance.setAirNetwork(network);
    }

    /**
     * Test of getAirportList method, of class Project.
     */
    @Test
    public void testGetAirportList() {
        System.out.println("getAirportList");
        Project instance = new Project();
        AirportList expResult = new AirportList();
        instance.setAirportList(expResult);
        AirportList result = instance.getAirportList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAirportList method, of class Project.
     */
    @Test
    public void testSetAirportList() {
        System.out.println("setAirportList");
        AirportList airportList = new AirportList();
        Project instance = new Project();
        instance.setAirportList(airportList);
    }

    /**
     * Test of getCompareList method, of class Project.
     */
    @Test
    public void testGetCompareList() {
        System.out.println("getCompareList");
        Project instance = new Project();
        CompareResultsList expResult = new CompareResultsList();
        instance.setCompareList(expResult);
        CompareResultsList result = instance.getCompareList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompareList method, of class Project.
     */
    @Test
    public void testSetCompareList() {
        System.out.println("setCompareList");
        CompareResultsList compareList = new CompareResultsList();
        Project instance = new Project();
        instance.setCompareList(compareList);
    }

    /**
     * Test of getAircraftModelList method, of class Project.
     */
    @Test
    public void testGetAircraftModelList() {
        System.out.println("getAircraftModelList");
        Project instance = new Project();
        AircraftModelList expResult = new AircraftModelList();
        instance.setAircraftModelList(expResult);
        AircraftModelList result = instance.getAircraftModelList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAircraftModelList method, of class Project.
     */
    @Test
    public void testSetModelList() {
        System.out.println("setModelList");
        AircraftModelList modelList = new AircraftModelList();
        Project instance = new Project();
        instance.setAircraftModelList(modelList);
    }

    /**
     * Test of getSimulationsList method, of class Project.
     */
    @Test
    public void testGetSimulationsList() {
        System.out.println("getSimulationsList");
        Project instance = new Project();
        SimulationsList expResult = new SimulationsList();
        instance.setSimulationsList(expResult);
        SimulationsList result = instance.getSimulationsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSimulationsList method, of class Project.
     */
    @Test
    public void testSetSimulationsList() {
        System.out.println("setSimulationsList");
        SimulationsList simulationsList = new SimulationsList();
        Project instance = new Project();
        instance.setSimulationsList(simulationsList);
    }

    /**
     * Test of getIdProject method, of class Project.
     */
    @Test
    public void testGetIdProject() {
        System.out.println("getIdProject");
        Project instance = new Project();
        int expResult = 0;
        int result = instance.getIdProject();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdProject method, of class Project.
     */
    @Test
    public void testSetIdProject() {
        System.out.println("setIdProject");
        int idProject = 1;
        Project instance = new Project();
        instance.setIdProject(idProject);
    }

    /**
     * Test of getName method, of class Project.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Project instance = new Project();
        String expResult = "NO_NAME_PROJECT";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Project.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "abc";
        Project instance = new Project();
        instance.setName(name);
    }

    /**
     * Test of getDescription method, of class Project.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Project instance = new Project();
        String expResult = "NO_DESCRIPTION";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Project.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "abc";
        Project instance = new Project();
        instance.setDescription(description);

    }

    /**
     * Test of getEcologicPathResults method, of class Project.
     */
    @Test
    public void testGetEcologicPathResults() {
        System.out.println("getEcologicPathResults");
        Project instance = new Project();
        List<ResultPath> expResult = new LinkedList<>();
        instance.getSimulationsList().getSimulationsList().stream().forEach((s) -> {
            expResult.add(s.getEcologicResultPath());
        });
        List<ResultPath> result = instance.getEcologicPathResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShortestPathResults method, of class Project.
     */
    @Test
    public void testGetShortestPathResults() {
        System.out.println("getShortestPathResults");
        Project instance = new Project();
        List<ResultPath> expResult = new LinkedList<>();
        instance.getSimulationsList().getSimulationsList().stream().forEach((s) -> {
            expResult.add(s.getEcologicResultPath());
        });
        List<ResultPath> result = instance.getShortestPathResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFastestPathResults method, of class Project.
     */
    @Test
    public void testGetFastestPathResults() {
        System.out.println("getFastestPathResults");
        Project instance = new Project();
        List<ResultPath> expResult = new LinkedList<>();
        instance.getSimulationsList().getSimulationsList().stream().forEach((s) -> {
            expResult.add(s.getEcologicResultPath());
        });
        List<ResultPath> result = instance.getFastestPathResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Project.
     */
    @Test
    public void testValidate() {
        System.out.println("validate1");
        String name = "";
        String desc = "descr";
        Project instance = new Project();
        instance.setName(name);
        instance.setDescription(desc);
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        String name2 = "abc";
        String desc2 = "";
        Project instance2 = new Project();
        instance2.setName(name2);
        instance2.setDescription(desc2);
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        String name3 = "abc";
        String desc3 = "descr";
        Project instance3 = new Project();
        instance3.setName(name3);
        instance3.setDescription(desc3);
        boolean expResult3 = true;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
    }

    /**
     * Test of toString method, of class Project.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Project instance = new Project();
        String expResult = instance.getName();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
