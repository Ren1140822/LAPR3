/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import lapr.project.model.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diana Silva
 */
public class ResultPathTest {
    
    public ResultPathTest() {
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
     * Test of setResult method, of class ResultPath.
     */
    @Test
    public void testSetResult() {
        System.out.println("setResult");
        double result_2 = 0.0;
        ResultPath instance = new ResultPath();
        instance.setResult(result_2);
        assertEquals(instance.getResult(), result_2, 0.0);
    }

    /**
     * Test of setResultPath method, of class ResultPath.
     */
    @Test
    public void testSetResultPath() {
        System.out.println("setResultPath");
        LinkedList<Node> resultPath = new LinkedList<>();
        Node test=new Node("test",0,0);
        resultPath.add(test);
        ResultPath instance = new ResultPath();
        instance.setResultPath(resultPath);
        assertEquals(instance.getResultPath(), resultPath);
    }

    /**
     * Test of getResult method, of class ResultPath.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        ResultPath instance = new ResultPath();
        double expResult = 2.0;
        instance.setResult(expResult);  
        double result = instance.getResult();
        assertEquals(expResult, result, 0.0);
    }

}
