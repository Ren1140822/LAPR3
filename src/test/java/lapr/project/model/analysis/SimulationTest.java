/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.CabinConfiguration;
import lapr.project.model.FlightPlan;
import lapr.project.model.Location;
import lapr.project.model.Motorization;
import lapr.project.model.Node;
import lapr.project.model.Segment;
import lapr.project.model.Thrust_Function;
import lapr.project.model.Wind;
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
public class SimulationTest {
    AirNetwork network = new AirNetwork();
    
    public SimulationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Node n1 = new Node("id1", 0, 0);
        Node n2 = new Node("id2", 10, 10);
        Node n3 = new Node("id3", 20, 20);
        Node n4 = new Node("id4", 30, 30);
        Segment s1 = new Segment("seg1", n1, n2, "bidirectional", new Wind(), 0, 0);
        Segment s2 = new Segment("seg2", n2, n3, "bidirectional", new Wind(), 0, 0);
        Segment s3 = new Segment("seg3", n3, n4, "bidirectional", new Wind(), 0, 0);
        Segment s4 = new Segment("seg4", n1, n3, "bidirectional", new Wind(), 0, 0);
        Segment s5 = new Segment("seg5", n2, n4, "bidirectional", new Wind(), 0, 0);
        
        network.getNodeList().add(n1);
        network.getNodeList().add(n2);
        network.getNodeList().add(n3);
        network.getNodeList().add(n4);   
        
        network.getSegmentList().add(s1);
        network.getSegmentList().add(s2);
        network.getSegmentList().add(s3);
        network.getSegmentList().add(s4);
        network.getSegmentList().add(s5);
        
        network.generateGraph();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPassengers method, of class Simulation.
     */
    @Test
    public void testGetPassengers() {
        System.out.println("getPassengers");
        Simulation instance = new Simulation( 10,100, 100, 100);
        int expResult = 10;
        int result = instance.getPassengers();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassengers method, of class Simulation.
     */
    @Test
    public void testSetPassengers() {
        System.out.println("setPassengers");
        int passengers = 20;
        Simulation instance = new Simulation();
        instance.setPassengers(passengers);
    }

    /**
     * Test of getCrew method, of class Simulation.
     */
    @Test
    public void testGetCrew() {
        System.out.println("getCrew");
        Simulation instance = new Simulation();
        instance.setCrew(20);
        int expResult = 20;
        int result = instance.getCrew();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCrew method, of class Simulation.
     */
    @Test
    public void testSetCrew() {
        System.out.println("setCrew");
        int crew = 10;
        Simulation instance = new Simulation();
        instance.setCrew(crew);
    }

    /**
     * Test of getCargoLoad method, of class Simulation.
     */
    @Test
    public void testGetCargoLoad() {
        System.out.println("getCargoLoad");
        Simulation instance = new Simulation();
        instance.setCargoLoad(20.4);
        double expResult = 20.40;
        double result = instance.getCargoLoad();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCargoLoad method, of class Simulation.
     */
    @Test
    public void testSetCargoLoad() {
        System.out.println("setCargoLoad");
        double cargoLoad = 10.0;
        Simulation instance = new Simulation();
        instance.setCargoLoad(cargoLoad);
    }

    /**
     * Test of getTotalWeight method, of class Simulation.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalWeight");
        Simulation instance = new Simulation();
        instance.setTotalWeight(230.56);
        double expResult = 230.56;
        double result = instance.getTotalWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setTotalWeight method, of class Simulation.
     */
    @Test
    public void testSetTotalWeight() {
        System.out.println("setTotalWeight");
        double totalWeight = 340.0;
        Simulation instance = new Simulation();
        instance.setTotalWeight(totalWeight);
    }

    /**
     * Test of getFlightPlan method, of class Simulation.
     */
    @Test
    public void testGetFlightPlan() {
        System.out.println("getFlightPlan");
        Simulation instance = new Simulation();
        FlightPlan expResult = new FlightPlan();
        instance.setFlightPlan(expResult);
        FlightPlan result = instance.getFlightPlan();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFlightPlan method, of class Simulation.
     */
    @Test
    public void testSetFlightPlan() {
        System.out.println("setFlightPlan");
        FlightPlan flightPlan = new FlightPlan();
        Simulation instance = new Simulation();
        instance.setFlightPlan(flightPlan);
    }

    /**
     * Test of setData method, of class Simulation.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        int passengers = 10;
        int crew = 10;
        double cargoLoad = 10.0;
        double fuelLoad = 10.0;
        Airport startAirport = new Airport("TESTE1", "name", "town", "country", 
                new Location(10, 10, 10));
        Airport endAirport = new Airport("TESTE2", "name", "town", "country", 
                new Location(20, 10, 10));;
        Aircraft aircraft = new Aircraft();
        Simulation instance = new Simulation();
        instance.setData(passengers, crew, cargoLoad, fuelLoad, startAirport, endAirport, aircraft);
    }

    /**
     * Test of getFuelWeight method, of class Simulation.
     */
    @Test
    public void testGetFuelWeight() {
        System.out.println("getFuelWeight");
        Simulation instance = new Simulation();
        instance.setFuelWeight(23);
        double expResult = 23.0;
        double result = instance.getFuelWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFuelWeight method, of class Simulation.
     */
    @Test
    public void testSetFuelWeight() {
        System.out.println("setFuelWeight");
        double fuelWeight = 120.0;
        Simulation instance = new Simulation();
        instance.setFuelWeight(fuelWeight);
    }

    /**
     * Test of getStartNode method, of class Simulation.
     */
    @Test
    public void testGetStartNode() {
        System.out.println("getStartNode");
        AirNetwork net = network;
        int passengers = 10;
        int crew = 10;
        double cargoLoad = 10.0;
        double fuelLoad = 10.0;
        Airport startAirport = new Airport("TESTE1", "name", "town", "country", 
                new Location(10, 10, 10));
        Airport endAirport = new Airport("TESTE2", "name", "town", "country", 
                new Location(20, 10, 10));;
        Aircraft aircraft = new Aircraft();
        Simulation instance = new Simulation();
        instance.setData(passengers, crew, cargoLoad, fuelLoad, startAirport, 
                endAirport, aircraft);
        FlightPlan f = new FlightPlan();
        instance.setFlightPlan(f);
        Node expResult = network.getAirportNode(f.getOrigin());        
        Node result = instance.getStartNode(net);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndNode method, of class Simulation.
     */
    @Test
    public void testGetEndNode() {
        System.out.println("getEndNode");
        AirNetwork net = network;
        int passengers = 10;
        int crew = 10;
        double cargoLoad = 10.0;
        double fuelLoad = 10.0;
        Airport startAirport = new Airport("TESTE1", "name", "town", "country", 
                new Location(10, 10, 10));
        Airport endAirport = new Airport("TESTE2", "name", "town", "country", 
                new Location(20, 10, 10));;
        Aircraft aircraft = new Aircraft();
        Simulation instance = new Simulation();
        instance.setData(passengers, crew, cargoLoad, fuelLoad, startAirport, 
                endAirport, aircraft);
        FlightPlan f = new FlightPlan();
        instance.setFlightPlan(f);
        Node expResult = network.getAirportNode(f.getDestination());    
        Node result = instance.getEndNode(net);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartAirport method, of class Simulation.
     */
    @Test
    public void testGetStartAirport() {
        System.out.println("getStartAirport");
        Simulation instance = new Simulation();
        FlightPlan f = new FlightPlan();
        instance.setFlightPlan(f);
        Airport expResult = f.getOrigin();
        Airport result = instance.getStartAirport();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndAirport method, of class Simulation.
     */
    @Test
    public void testGetEndAirport() {
        System.out.println("getEndAirport");
        Simulation instance = new Simulation();
        FlightPlan f = new FlightPlan();
        instance.setFlightPlan(f);
        Airport expResult = f.getDestination();
        Airport result = instance.getEndAirport();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Simulation.
     */
    @Test
    public void testValidate() {
        CabinConfiguration c =new CabinConfiguration();
        Map<String,Integer> mapOfClasses = new HashMap<>();
        mapOfClasses.put("test", 15);
        c.setMapOfClasses(mapOfClasses);
        Aircraft a1 = new Aircraft("dsfsdg", "fdh", c, 8, new AircraftModel(
                "id", "description", "maker", "passenger", new Motorization(
                4, "motor", "motorType", 1000, 10000, 10000, 1000, 
                new Thrust_Function(100, 100, 100)), 10, 
                10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
                new LinkedList<>()));
        
        Airport airp1 = new Airport("opo", "porto", "porto", "portugal", new Location(10, 10, 10));
        Airport airp2 = new Airport("lis", "lisboa", "lisboa", "portugal", new Location(20, 20, 20));
        FlightPlan f = new FlightPlan("FF0001A", 10, a1, airp1, airp2,
                new LinkedList<>(), new LinkedList<>(),new LinkedList<>());
        
        System.out.println("validate1");
        Simulation instance = new Simulation();
        instance.setFlightPlan(f);
        instance.createPathSimulation(TypePath.ALL);
        instance.setData(10, 10, 10, 10, airp1, airp2, a1);
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        Simulation instance2 = new Simulation();
        instance2.setFlightPlan(f);
        instance2.createPathSimulation(TypePath.ALL);
        instance2.setData(10, 7, 10, 10, airp1, airp2, a1);
        boolean expResult2 = true;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getCounterCode method, of class Simulation.
     */
    @Test
    public void testGetCounterCode() {
        System.out.println("getCounterCode");
        Simulation instance = new Simulation();
        int expResult = instance.getCounterCode();
        int result = instance.getCounterCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEcologicResultPath method, of class Simulation.
     */
    @Test
    public void testGetEcologicResultPath() {
        System.out.println("getEcologicResultPath");
        Simulation instance = new Simulation();
        FlightPlan f = new FlightPlan();
        instance.setFlightPlan(f);        
        EcologicPathResult expResult = new EcologicPathResult(f);
        instance.setEcologicResultPath(expResult);
        EcologicPathResult result = instance.getEcologicResultPath();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEcologicResultPath method, of class Simulation.
     */
    @Test
    public void testSetEcologicResultPath() {
        System.out.println("setEcologicResultPath");
        FlightPlan f = new FlightPlan();        
        EcologicPathResult ecologicResultPath = new EcologicPathResult(f);
        Simulation instance = new Simulation();
        instance.setFlightPlan(f);
        instance.setEcologicResultPath(ecologicResultPath);
    }

    /**
     * Test of getFastestResultPath method, of class Simulation.
     */
    @Test
    public void testGetFastestResultPath() {
        System.out.println("getFastestResultPath");
        Simulation instance = new Simulation();
        FlightPlan f = new FlightPlan();
        instance.setFlightPlan(f);        
        FastestPathResult expResult = new FastestPathResult(f);
        instance.setFastestResultPath(expResult);
        FastestPathResult result = instance.getFastestResultPath();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFastestResultPath method, of class Simulation.
     */
    @Test
    public void testSetFastestResultPath() {
        System.out.println("setFastestResultPath");
        FastestPathResult fastestResultPath = null;
        Simulation instance = new Simulation();
        instance.setFastestResultPath(fastestResultPath);
    }

    /**
     * Test of getShortestResultPath method, of class Simulation.
     */
    @Test
    public void testGetShortestResultPath() {
        System.out.println("getShortestResultPath");
        Simulation instance = new Simulation();
        FlightPlan f = new FlightPlan();
        instance.setFlightPlan(f);        
        ShortestPathResult expResult = new ShortestPathResult(f);
        instance.setShortestResultPath(expResult);
        ShortestPathResult result = instance.getShortestResultPath();
        assertEquals(expResult, result);
    }

    /**
     * Test of setShortestResultPath method, of class Simulation.
     */
    @Test
    public void testSetShortestResultPath() {
        System.out.println("setShortestResultPath");        
        Simulation instance = new Simulation();
        FlightPlan f = new FlightPlan();
        instance.setFlightPlan(f);      
        ShortestPathResult shortestResultPath = new ShortestPathResult(f);
        instance.setShortestResultPath(shortestResultPath);
    }

    /**
     * Test of createPathSimulation method, of class Simulation.
     */
    @Test
    public void testCreatePathSimulation() {
        System.out.println("createPathSimulation1");
        TypePath type = TypePath.ALL;
        Simulation instance = new Simulation();
        instance.createPathSimulation(type);
        
        System.out.println("createPathSimulation2");        
        TypePath type2 = TypePath.ECOLOGIC_PATH;
        Simulation instance2 = new Simulation();
        instance2.createPathSimulation(type2);
        
        System.out.println("createPathSimulation3");        
        TypePath type3 = TypePath.FASTEST_PATH;
        Simulation instance3 = new Simulation();
        instance3.createPathSimulation(type3);
        
        System.out.println("createPathSimulation4");        
        TypePath type4 = TypePath.SHORTEST_PATH;
        Simulation instance4 = new Simulation();
        instance4.createPathSimulation(type4);
    }

    /**
     * Test of getResult method, of class Simulation.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        TypePath type = TypePath.ALL;
        Simulation instance = new Simulation();
        Path expResult = instance.getShortestResultPath();
        Path result = instance.getResult(type);
        assertEquals(expResult, result);
        
        System.out.println("getResult2");
        TypePath type2 = TypePath.SHORTEST_PATH;
        Simulation instance2 = new Simulation();
        Path expResult2 = instance2.getShortestResultPath();
        Path result2 = instance2.getResult(type2);
        assertEquals(expResult2, result2);
        
        System.out.println("getResult3");
        TypePath type3 = TypePath.FASTEST_PATH;
        Simulation instance3 = new Simulation();
        Path expResult3 = instance.getFastestResultPath();
        Path result3 = instance3.getResult(type3);
        assertEquals(expResult3, result3);
        
        System.out.println("getResult4");
        TypePath type4 = TypePath.ECOLOGIC_PATH;
        Simulation instance4 = new Simulation();
        Path expResult4 = instance4.getEcologicResultPath();
        Path result4 = instance.getResult(type4);
        assertEquals(expResult4, result4);
    }

//    /**
//     * Test of calculateBestPath method, of class Simulation.
//     */
//    @Test
//    public void testCalculateBestPath() {    
//        Aircraft a1 = new Aircraft("dsfsdg", "fdh", new CabinConfiguration(), 2, new AircraftModel(
//                "id", "description", "maker", "passenger", new Motorization(), 10, 
//                10, 10, 10, 10, 10, 10, 10, 10, 10, new LinkedList<>()));
//        
//        Airport airp1 = new Airport("opo", "porto", "porto", "portugal", new Location(10, 10, 10));
//        Airport airp2 = new Airport("lis", "lisboa", "lisboa", "portugal", new Location(20, 20, 20));
//        FlightPlan f = new FlightPlan("FF0001A", 10, a1, airp1, airp2,
//                new LinkedList<>(), new LinkedList<>(),new LinkedList<>());
//        
//        System.out.println("calculateBestPath1");
//        TypePath type = TypePath.SHORTEST_PATH;
//        AirNetwork air = network;
//        int timeStep = 10;
//        Simulation instance = new Simulation(); 
//        instance.createPathSimulation(type);
//        instance.setData(10, 10, 10, 10, airp1, airp2, a1);
//        instance.setFlightPlan(f);
//        boolean expResult = true;
//        boolean result = instance.calculateBestPath(type, air, timeStep);
//        assertEquals(expResult, result);
//        
//        System.out.println("calculateBestPath2");
//        TypePath type2 = TypePath.ALL;
//        AirNetwork air2 = network;
//        int timeStep2 = 0;
//        Simulation instance2 = new Simulation();
//        instance2.createPathSimulation(type);
//        instance2.setFlightPlan(f);
//        boolean expResult2 = true;
//        boolean result2 = instance2.calculateBestPath(type2, air2, timeStep2);
//        assertEquals(expResult2, result2);
//        
//        System.out.println("calculateBestPath3");
//        TypePath type3 = TypePath.ECOLOGIC_PATH;
//        AirNetwork air3 = network;
//        int timeStep3 = 0;
//        Simulation instance3 = new Simulation();
//        instance3.createPathSimulation(type);
//        instance3.setFlightPlan(f);
//        boolean expResult3 = true;
//        boolean result3 = instance3.calculateBestPath(type3, air3, timeStep3);
//        assertEquals(expResult3, result3);
//        
//        System.out.println("calculateBestPath4");
//        TypePath type4 = TypePath.FASTEST_PATH;
//        AirNetwork air4 = network;
//        int timeStep4 = 0;
//        Simulation instance4 = new Simulation();
//        instance4.createPathSimulation(type);
//        instance4.setFlightPlan(f);
//        boolean expResult4 = true;
//        boolean result4 = instance4.calculateBestPath(type4, air4, timeStep4);
//        assertEquals(expResult4, result4);
//    }

    /**
     * Test of toString method, of class Simulation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Simulation instance = new Simulation();
        String expResult = String.valueOf(instance.getCounterCode());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Simulation.
     */
    @Test
    public void testEquals() {
        System.out.println("equals1");
        Object otherObject = new Simulation();
        Simulation instance = new Simulation();
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("equals2");
        Object otherObject2 = new Airport();
        Simulation instance2 = new Simulation();
        boolean expResult2 = false;
        boolean result2 = instance2.equals(otherObject2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of hashCode method, of class Simulation.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Simulation instance = new Simulation();
        int expResult = 5;
        expResult = expResult*67 + instance.getPassengers();
        expResult = expResult*67 + instance.getCrew();
        expResult = expResult*67 + (int) (Double.doubleToLongBits(instance.getCargoLoad()) ^ 
                (Double.doubleToLongBits(instance.getCargoLoad()) >>> 32));
        expResult = expResult*67 + (int) (Double.doubleToLongBits(instance.getFuelWeight()) ^ 
                (Double.doubleToLongBits(instance.getFuelWeight()) >>> 32));
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}
