/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import lapr.project.model.Node;
import lapr.project.model.Segment;
import lapr.project.model.Wind;

/**
 *
 * @author NANA
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
        Segment segment1=new Segment("segmentTest1","test1", "test3", "BIDIRECTIONAL",windTest);       
        Segment segment2=new Segment("segmentTest2", "test1", "test2", "BIDIRECTIONAL",windTest);
        Segment segment3=new Segment("segmentTest3", "test2", "test3", "BIDIRECTIONAL", windTest);
        
        AirNetwork airnetwork=new AirNetwork();
        airnetwork.getAirNetwork().insertVertex(startNode);
        airnetwork.getAirNetwork().insertVertex(intNode);
        airnetwork.getAirNetwork().insertVertex(endNode);

        airnetwork.getAirNetwork().insertEdge(startNode, intNode, segment2, 10);
        airnetwork.getAirNetwork().insertEdge(intNode, endNode, segment3, 30);
        airnetwork.getAirNetwork().insertEdge(startNode, endNode, segment1, 20);  
        
        ShortestPathResult instance = new ShortestPathResult(startNode, endNode);
        instance.calculateBestPath(airnetwork);
        LinkedList<Node> result=new LinkedList<>();
        result.add(startNode);
        result.add(endNode);
        assertEquals(instance.resultPath, result);
    }
    
}
