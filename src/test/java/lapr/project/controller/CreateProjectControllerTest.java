/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Project;
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
public class CreateProjectControllerTest {
    
    Project project = new Project();
    
    public CreateProjectControllerTest() {
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
     * Test of setProject method, of class CreateProjectController.
     */
    @Test
    public void testSetProject() {        
        System.out.println("setProject1");
        String name = "";
        String desc = "";
        CreateProjectController instance = new CreateProjectController();
        boolean expResult = false;
        boolean result = instance.setProject(name, desc);
        assertEquals(expResult, result);
        
        System.out.println("setProject2");
        String name2 = "test";
        String desc2 = "";
        CreateProjectController instance2 = new CreateProjectController();
        boolean expResult2 = false;
        boolean result2 = instance2.setProject(name2, desc2);
        assertEquals(expResult2, result2);
        
        System.out.println("setProject3");
        String name3 = "";
        String desc3 = "test";
        CreateProjectController instance3 = new CreateProjectController();
        boolean expResult3 = false;
        boolean result3 = instance3.setProject(name3, desc3);
        assertEquals(expResult3, result3);
        
        System.out.println("setProject4");
        String name4 = "test";
        String desc4 = "test";
        CreateProjectController instance4 = new CreateProjectController();
        boolean expResult4 = true;
        boolean result4 = instance4.setProject(name4, desc4);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of getProject method, of class CreateProjectController.
     */
    @Test
    public void testGetProject() {
        System.out.println("getProject");
        CreateProjectController instance = new CreateProjectController();
        Project expResult = null;
        Project result = instance.getProject();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hasProjectCreated method, of class CreateProjectController.
     */
    @Test
    public void testHasProjectCreated() {
        System.out.println("hasProjectCreated1");
        CreateProjectController instance = new CreateProjectController();
        boolean expResult = false;
        boolean result = instance.hasProjectCreated();
        assertEquals(expResult, result);
        
        System.out.println("hasProjectCreated2");
        CreateProjectController instance2 = new CreateProjectController();
        instance2.setProject("testname", "testdescription");
        boolean expResult2 = true;
        boolean result2 = instance2.hasProjectCreated();
        assertEquals(expResult2, result2);
    }
    
}
