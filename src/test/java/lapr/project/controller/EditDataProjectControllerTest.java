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
public class EditDataProjectControllerTest {
    
    Project project = new Project();
    
    public EditDataProjectControllerTest() {
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
     * Test of setDataProject method, of class EditDataProjectController.
     */
    @Test
    public void testSetDataProject() {
        System.out.println("setDataProject1");
        String name = "";
        String desc = "";
        EditDataProjectController instance = new EditDataProjectController(project);
        boolean expResult = false;
        boolean result = instance.setDataProject(name, desc);
        assertEquals(expResult, result);
        
        System.out.println("setDataProject2");
        String name2 = "test";
        String desc2 = "";
        EditDataProjectController instance2 = new EditDataProjectController(project);
        boolean expResult2 = false;
        boolean result2 = instance2.setDataProject(name2, desc2);
        assertEquals(expResult2, result2);
        
        System.out.println("setDataProject3");
        String name3 = "";
        String desc3 = "test";
        EditDataProjectController instance3 = new EditDataProjectController(project);
        boolean expResult3 = false;
        boolean result3 = instance3.setDataProject(name3, desc3);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of getIdProject method, of class EditDataProjectController.
     */
    @Test
    public void testGetIdProject() {
        System.out.println("getIdProject");
        EditDataProjectController instance = new EditDataProjectController(project);
        int expResult = 0;
        int result = instance.getIdProject();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNameProject method, of class EditDataProjectController.
     */
    @Test
    public void testGetNameProject() {
        System.out.println("getNameProject");
        EditDataProjectController instance = new EditDataProjectController(project);
        String expResult = "NO_NAME_PROJECT";
        String result = instance.getNameProject();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescriptionProject method, of class EditDataProjectController.
     */
    @Test
    public void testGetDescriptionProject() {
        System.out.println("getDescriptionProject");
        EditDataProjectController instance = new EditDataProjectController(project);
        String expResult = "NO_DESCRIPTION";
        String result = instance.getDescriptionProject();
        assertEquals(expResult, result);
    }
    
}
