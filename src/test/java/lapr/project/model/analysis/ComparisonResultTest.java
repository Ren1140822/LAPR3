/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
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
public class ComparisonResultTest {
    
    public ComparisonResultTest() {
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
     * Test of getAvgDistance method, of class ComparisonResult.
     */
    @Test
    public void testGetAvgDistance() {
        System.out.println("getAvgDistance");
        ComparisonResult instance = new ComparisonResult();
         double expResult = 2.0;
         instance.setAvgDistance(expResult);
       
        double result = instance.getAvgDistance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAvgDistance method, of class ComparisonResult.
     */
    @Test
    public void testSetAvgDistance() {
        System.out.println("setAvgDistance");
        double avgDistance = 2.0;
        ComparisonResult instance = new ComparisonResult();
        instance.setAvgDistance(avgDistance);
        assertEquals(avgDistance, instance.getAvgDistance(), 0.0);
    }

    /**
     * Test of getAvgTimeFlight method, of class ComparisonResult.
     */
    @Test
    public void testGetAvgTimeFlight() {
        System.out.println("getAvgTimeFlight");
        ComparisonResult instance = new ComparisonResult();
        double expResult = 2.0;
        instance.setAvgTimeFlight(expResult);
       
        double result = instance.getAvgTimeFlight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAvgTimeFlight method, of class ComparisonResult.
     */
    @Test
    public void testSetAvgTimeFlight() {
        System.out.println("setAvgTimeFlight");
        double expResult = 2.0;
        ComparisonResult instance = new ComparisonResult();
        instance.setAvgTimeFlight(expResult);
        assertEquals(expResult, instance.getAvgTimeFlight(), 0.0);
    }

    /**
     * Test of getAvgFuel method, of class ComparisonResult.
     */
    @Test
    public void testGetAvgFuel() {
        System.out.println("getAvgFuel");
        ComparisonResult instance = new ComparisonResult();
        double expResult = 2.0;
        instance.setAvgFuel(expResult);
       
        double result = instance.getAvgFuel();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAvgFuel method, of class ComparisonResult.
     */
    @Test
    public void testSetAvgFuel() {
        System.out.println("setAvgFuel");
        double expResult = 2.0;
        ComparisonResult instance = new ComparisonResult();
        instance.setAvgFuel(expResult);
        assertEquals(expResult, instance.getAvgFuel(), 0.0);
    }

    /**
     * Test of getAircraftModel method, of class ComparisonResult.
     */
    @Test
    public void testGetAircraftModel() {
        System.out.println("getAircraftModel");
        ComparisonResult instance = new ComparisonResult();
        String expResult = "model1";
        instance.setAircraftModel(expResult);
        String result = instance.getAircraftModel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAircraftModel method, of class ComparisonResult.
     */
    @Test
    public void testSetAircraftModel() {
        System.out.println("setAircraftModel");
        String expResult = "model";
        ComparisonResult instance = new ComparisonResult();
        instance.setAircraftModel(expResult);
        String result=instance.getAircraftModel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMotorization method, of class ComparisonResult.
     */
    @Test
    public void testGetMotorization() {
        System.out.println("getMotorization");
        ComparisonResult instance = new ComparisonResult();
        String expResult = "motor1";
        instance.setMotorization(expResult);
        String result = instance.getMotorization();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSimulationsCompared method, of class ComparisonResult.
     */
    @Test
    public void testGetSimulationsCompared() {
        System.out.println("getSimulationsCompared");
        ComparisonResult instance = new ComparisonResult();
        LinkedList<Simulation> expResult = new LinkedList<>();
        Simulation s=new Simulation();
        expResult.add(s);      
        instance.getSimulationsCompared().add(s);
        LinkedList<Simulation> result = (LinkedList<Simulation>) instance.getSimulationsCompared();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setSimulationsCompared method, of class ComparisonResult.
     */
    @Test
    public void testSetSimulationsCompared() {
        System.out.println("setSimulationsCompared");
        ComparisonResult instance = new ComparisonResult();
        LinkedList<Simulation> expResult = new LinkedList<>();
        Simulation s=new Simulation();
        expResult.add(s);      
        instance.setSimulationsCompared(expResult);
        LinkedList<Simulation> result = (LinkedList<Simulation>) instance.getSimulationsCompared();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setMotorization method, of class ComparisonResult.
     */
    @Test
    public void testSetMotorization() {
        System.out.println("setMotorization");
       
        String expResult = "motorization";
        ComparisonResult instance = new ComparisonResult();
        instance.setMotorization(expResult);
        assertEquals(expResult, instance.getMotorization());
    }

    /**
     * Test of calculateTotalAverage method, of class ComparisonResult.
     */
    @Test
    public void testCalculateTotalAverage() {
        System.out.println("calculateTotalAverage");
        ComparisonResult instance = new ComparisonResult();
        LinkedList<Simulation> list=(LinkedList<Simulation>) instance.getSimulationsCompared();
        Simulation s=new Simulation();
        s.createPathSimulation(TypePath.ALL);
        double dist1=200;
        double dist2=300;
       
        SegmentResult seg=new SegmentResult();
        seg.setDistance(dist1);
        
        SegmentResult seg2=new SegmentResult();
        seg2.setDistance(dist2);
        s.getEcologicResultPath().getSegments().add(0, seg);
        s.getFastestResultPath().getSegments().add(0, seg2);
        
        list.add(s);
 
        double expResult=250;
        
        instance.calculateTotalAverage();
        double result=instance.getAvgDistance();
        
        assertEquals(expResult,result, 0.0);
    }

    /**
     * Test of validate method, of class ComparisonResult.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        ComparisonResult instance = new ComparisonResult();
        boolean expResult = true;
        instance.setAvgDistance(200);
        instance.setAvgTimeFlight(20);
        instance.setAvgFuel(4000);
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }

    /**
     * Test of toStringCompare method, of class ComparisonResult.
     */
    @Test
    public void testToStringCompare() {
        System.out.println("toStringCompare");
        Simulation sim= new Simulation();
        sim.createPathSimulation(TypePath.ALL);
        ComparisonResult instance = new ComparisonResult();
        double dist1=100;
        double dist2=200;
        double dist3=300;
        
        
        SegmentResult seg=new SegmentResult();
        seg.setDistance(dist1);
        
        SegmentResult seg2=new SegmentResult();
        seg2.setDistance(dist2);
        
        SegmentResult seg3=new SegmentResult();
        seg3.setDistance(dist3);
        
        sim.getEcologicResultPath().getSegments().add(0, seg);
        sim.getFastestResultPath().getSegments().add(0, seg2);
        sim.getFastestResultPath().getSegments().add(0,seg3);
        
        instance.getSimulationsCompared().add(sim);
        
        String[] result = instance.toStringCompare(sim);
        
        ShortestPathResult s= sim.getShortestResultPath();
        FastestPathResult f= sim.getFastestResultPath();
        EcologicPathResult e= sim.getEcologicResultPath();
         
        String[] data={String.format("%.2f", s.getDistance()),
            String.format("%.2f", f.getDistance()),
              String.format("%.2f",  e.getDistance()),
        
        String.format("%.2f", s.getTravellingTime()),
            String.format("%.2f", f.getTravellingTime()),
              String.format("%.2f", e.getTravellingTime()),
        
        String.format("%.2f", s.getEnergyConsum()),
            String.format("%.2f", f.getEnergyConsum()),
              String.format("%.2f", e.getEnergyConsum()),
        
        };
        String[]expResult = data;
        
        assertArrayEquals(expResult, result);
    }
}
