/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Node;
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
public class NodeListTest {
    
    public NodeListTest() {
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
     * Test of getNodeList method, of class NodeList.
     */
    @Test
    public void testGetNodeList() {
        System.out.println("getNodeList");
        NodeList instance = new NodeList();
        List<Node> expResult = new LinkedList<>();
        instance.setNodeList(expResult);
        List<Node> result = instance.getNodeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNodeList method, of class NodeList.
     */
    @Test
    public void testSetNodeList() {
        System.out.println("setNodeList");
        List<Node> nodeList = new LinkedList<>();
        NodeList instance = new NodeList();
        instance.setNodeList(nodeList);
    }

    /**
     * Test of newNode method, of class NodeList.
     */
    @Test
    public void testNewNode() {
        System.out.println("newNode");
        NodeList instance = new NodeList();
        instance.newNode();
    }

    /**
     * Test of setNode method, of class NodeList.
     */
    @Test
    public void testSetNode() {
        System.out.println("setNode");
        String id = "nodeteste";
        double latitude = 40.0;
        double longitude = 70.0;
        NodeList instance = new NodeList();
        instance.newNode();
        instance.setNode(id, latitude, longitude);
    }

    /**
     * Test of saveNode method, of class NodeList.
     */
    @Test
    public void testSaveNode() {
        System.out.println("saveNode1");
        NodeList instance = new NodeList();
        instance.newNode();
        instance.setNode("testenode1", 50, 40);
        boolean expResult = true;
        boolean result = instance.saveNode();
        assertEquals(expResult, result);
        
        System.out.println("saveNode2");
        NodeList instance2 = new NodeList();
        instance2.newNode();
        instance2.setNode("testenode2", 500, 40);
        boolean expResult2 = false;
        boolean result2 = instance2.saveNode();
        assertEquals(expResult2, result2);
        
        System.out.println("saveNode3");
        NodeList instance3 = new NodeList();
        instance3.newNode();
        instance3.setNode("testenode2", 50, 40);
        instance3.saveNode();
        
        instance3.newNode();
        instance3.setNode("testenode2", 50, 40);
        boolean expResult3 = false;
        boolean result3 = instance3.saveNode();
        assertEquals(expResult3, result3);
        
        System.out.println("saveNode4");
        NodeList instance4 = new NodeList();
        instance4.newNode();
        instance4.setNode("testenode2", 50, 40);
        instance4.saveNode();
        
        instance4.newNode();
        instance4.setNode("testenode3", 51, 40);
        boolean expResult4 = true;
        boolean result4 = instance4.saveNode();
        assertEquals(expResult4, result4);
    }
    
}
