/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Node;
import lapr.project.model.Segment;
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
public class SegmentListTest {
    
    public SegmentListTest() {
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
     * Test of getSegmentList method, of class SegmentList.
     */
    @Test
    public void testGetSegmentList() {
        System.out.println("getSegmentList");
        SegmentList instance = new SegmentList();
        List<Segment> expResult = new LinkedList<>();
        instance.setSegmentList(expResult);
        List<Segment> result = instance.getSegmentList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegmentList method, of class SegmentList.
     */
    @Test
    public void testSetSegmentList() {
        System.out.println("setSegmentList");
        List<Segment> segmentList = new LinkedList<>();
        SegmentList instance = new SegmentList();
        instance.setSegmentList(segmentList);
    }

    /**
     * Test of newSegment method, of class SegmentList.
     */
    @Test
    public void testNewSegment() {
        System.out.println("newSegment");
        SegmentList instance = new SegmentList();
        instance.newSegment();
    }

    /**
     * Test of setSegment method, of class SegmentList.
     */
    @Test
    public void testSetSegment() {
        System.out.println("setSegment");
        String id = "";
        Node startNode = new Node("testenode1", 50, 40);
        Node endNode = new Node("testenode2", 50, 40);
        String direction = "bidirectional";
        int windIntensity = 0;
        int windDirection = 0;
        SegmentList instance = new SegmentList();
        instance.newSegment();
        instance.setSegment(id, startNode, endNode, direction, 
                windIntensity, windDirection);
    }

    /**
     * Test of saveSegment method, of class SegmentList.
     */
    @Test
    public void testSaveSegment() {
        System.out.println("saveSegment1");
        SegmentList instance = new SegmentList();
        instance.newSegment();
        instance.setSegment("seg01", new Node("id1",-90,90), new Node("id2", 89, 90), "bidirectional", 15, 40);
        boolean expResult = true;
        boolean result = instance.saveSegment();
        assertEquals(expResult, result);
        
        System.out.println("saveSegment2");
        SegmentList instance2 = new SegmentList();
        instance2.newSegment();
        instance2.setSegment("seg01", new Node("id1",-90,90), new Node("id1", -90, 90), "bidirectional", 15, 40);
        boolean expResult2 = false;
        boolean result2 = instance2.saveSegment();
        assertEquals(expResult2, result2);
        
        System.out.println("saveSegment3");
        SegmentList instance3 = new SegmentList();
        instance3.newSegment();
        instance3.setSegment("seg01", new Node("id1",-90,90), new Node("id1", -90, 90), "bidirectional", 15, 40);
        instance3.saveSegment();
        instance3.newSegment();
        instance3.setSegment("seg01", new Node("id1",-90,90), new Node("id1", -90, 90), "bidirectional", 15, 40);
        boolean expResult3 = false;
        boolean result3 = instance3.saveSegment();
        assertEquals(expResult3, result3);
        
        System.out.println("saveSegment3");
        SegmentList instance4 = new SegmentList();
        instance4.newSegment();
        instance4.setSegment("seg01", new Node("id1",-90,90), new Node("id1", -90, 90), "bidirectional", 15, 40);
        instance4.saveSegment();
        instance4.newSegment();
        instance4.setSegment("seg01", new Node("id1",-90,90), new Node("id2", -90, 90), "bidirectional", 15, 40);
        boolean expResult4 = true;
        boolean result4 = instance4.saveSegment();
        assertEquals(expResult4, result4);
    }
    
}
