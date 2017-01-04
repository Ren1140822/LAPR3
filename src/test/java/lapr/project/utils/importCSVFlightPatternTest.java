/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Pattern;
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
public class importCSVFlightPatternTest {
    private final String caminhoA380 = "src/main/resources/Flight_pattern_A380_v0.csv";
    private final String caminhoB777 = "src/main/resources/Flight_pattern_B777-200_v0.csv";
    
    public importCSVFlightPatternTest() {
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
     * Test of pattern method, of class importCSVFlightPattern.
     */
    @Test
    public void testPattern() {    
        System.out.println("A380");
        String ficheiro = caminhoA380;
        List<Pattern> list = new LinkedList<>();
        importCSVFlightPattern instance = new importCSVFlightPattern();
        boolean expResult = true;
        boolean result = instance.pattern(ficheiro, list);
        assertEquals(expResult, result);
        for(Pattern p : list){
            System.out.println(p.toString());
        }
        
        System.out.println("B777");
        String ficheiro2 = caminhoB777;
        List<Pattern> list2 = new LinkedList<>();
        importCSVFlightPattern instance2 = new importCSVFlightPattern();
        boolean expResult2 = true;
        boolean result2 = instance2.pattern(ficheiro2, list2);
        assertEquals(expResult2, result2);
        for(Pattern p2 : list2){
            System.out.println(p2.toString());
        }
    }
    
}
