/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.Airport;
import lapr.project.model.Location;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.Segment;
import lapr.project.model.Wind;

/**
 *
 * @author DianaSilva
 */
public class ShortestPathResultTest {
    
    public ShortestPathResultTest() {
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
     * Test of calculateBestPath method, of class ShortestPathResult.
     */
    @Test
    public void testCalculateBestPath() {
        System.out.println("calculateBestPath");
         Node startNode=new Node("test1", 40, 40);
        Node intNode=new Node("test2", 50, 70);
        Node endNode=new Node("test3", 40, 80);
        
        Wind windTest=new Wind(10,10);
        String direction="BIDIRECTIONAL";
        Segment segment1=new Segment("segmentTest1","test1", "test3", direction,windTest,0,0);       
        Segment segment2=new Segment("segmentTest2", "test1", "test2", direction,windTest,0,0);
        Segment segment3=new Segment("segmentTest3", "test2", "test3", direction, windTest,0,0);
        
        Project p=new Project();
        AirNetwork airnetwork=p.getAirNetwork();
        airnetwork.getAirNetwork().insertVertex(startNode);
        airnetwork.getAirNetwork().insertVertex(intNode);
        airnetwork.getAirNetwork().insertVertex(endNode);
        
        airnetwork.getAirNetwork().insertEdge(startNode, endNode, segment1, 20);
        airnetwork.getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        airnetwork.getAirNetwork().insertEdge(intNode, endNode, segment3, 30);

        p.getAirNetwork().getNodeList().add(startNode);
        p.getAirNetwork().getNodeList().add(endNode);
        p.getAirNetwork().getNodeList().add(intNode);
        
        Airport startAirport=new Airport("test1", "","","", new Location(40, 40,10));
        Airport endAirport=new Airport("test2", "","","", new Location(50,70,10));
        p.getAirportList().getAirportList().add(startAirport);
        p.getAirportList().getAirportList().add(endAirport);
        
        Simulation instance=new Simulation();
        instance.createAllPathSimulation(startAirport, endAirport);
        instance.getShortestResultPath().calculateBestPath(airnetwork);

        LinkedList<Node> result=new LinkedList<>();
        result.add(startNode);
        result.add(intNode);
        assertEquals(instance.getShortestResultPath().getResultPath(), result);
    }
    
}
