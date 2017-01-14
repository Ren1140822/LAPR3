/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Iten;
import lapr.project.model.Motorization;
import lapr.project.model.Node;
import lapr.project.model.Pattern;
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
 * @author Diana Silva
 */
public class SegmentResultTest {
    LinkedList<Iten> listIten;
    LinkedList<Pattern> listPattern;    
            
    public SegmentResultTest() {
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
     * Test of getType method, of class SegmentResult.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        SegmentType expResult = SegmentType.CLIMBING;
      
        SegmentResult instance = new SegmentResult(expResult, 0, 0, 0,
                new AircraftModel(), listPattern, new Segment(),0);
       
         SegmentType result = instance.getType();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getInitialAltitude method, of class SegmentResult.
     */
    @Test
    public void testGetInitialAltitude() {
        System.out.println("getInitialAltitude");
        double expResult = 100;
        SegmentType type =  SegmentType.CLIMBING;
        SegmentResult instance = new SegmentResult(type,
                 expResult, 0,0, new AircraftModel(),listPattern, new Segment(),0);
       
       double result = instance.getInitialAltitude();
        assertEquals(expResult, result,0.0);
    }

    /**
     * Test of getMass method, of class SegmentResult.
     */
    @Test
    public void testGetMass() {
        System.out.println("getMass");
        double expResult = 100;
        SegmentType type =  SegmentType.CLIMBING;
        SegmentResult instance = new SegmentResult(type,
                0,  expResult, 0, new AircraftModel(), listPattern,new Segment(),0);
       instance.setMass(expResult);
       double result = instance.getMass();
        assertEquals(expResult, result,0.0);
    }

    /**
     * Test of getDistance method, of class SegmentResult.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        SegmentResult instance = new SegmentResult();
        double expResult = 10.0;
        instance.setDistance(expResult);
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFlightTime method, of class SegmentResult.
     */
    @Test
    public void testGetFlightTime() {
        System.out.println("getFlightTime");
        SegmentResult instance = new SegmentResult();
        int expResult = 670;
        instance.setFlightTime(expResult);
        int result = instance.getFlightTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEnergyConsume method, of class SegmentResult.
     */
    @Test
    public void testGetEnergyConsume() {
        System.out.println("getEnergyConsume");
        SegmentResult instance = new SegmentResult();
        double expResult = 78.0;
        instance.setEnergyConsume(expResult);
        double result = instance.getEnergyConsume();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getTimeStep method, of class SegmentResult.
     */
    @Test
    public void testGetTimeStep() {
        System.out.println("getTimeStep");
        SegmentType type = SegmentType.CLIMBING;
        int expResult = 120;
        SegmentResult instance = new SegmentResult(type,
                0,  0, expResult, new AircraftModel(), listPattern, new Segment(),0);
        
        int result = instance.getTimeStep();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setTimeStep method, of class SegmentResult.
     */
    @Test
    public void testSetTimeStep() {
        System.out.println("setTimeStep");
        int timeStep = 60;
        SegmentResult instance = new SegmentResult();
        instance.setTimeStep(timeStep);
    }

    /**
     * Test of setAltitudeFinal method, of class SegmentResult.
     */
    @Test
    public void testSetAltitudeFinal() {
        System.out.println("setAltitudeFinal");
        double altitudeFinal = 60.0;
        SegmentResult instance = new SegmentResult();
        instance.setAltitudeFinal(altitudeFinal);
    }

    /**
     * Test of setEnergyConsume method, of class SegmentResult.
     */
    @Test
    public void testSetEnergyConsume() {
        System.out.println("setEnergyConsume");
        double energyConsume = 687.0;
        SegmentResult instance = new SegmentResult();
        instance.setEnergyConsume(energyConsume);
    }

    /**
     * Test of setInitialAltitude method, of class SegmentResult.
     */
    @Test
    public void testSetInitialAltitude() {
        System.out.println("setInitialAltitude");
        double altitude = 67.0;
        SegmentResult instance = new SegmentResult();
        instance.setInitialAltitude(altitude);
    }

    /**
     * Test of setMass method, of class SegmentResult.
     */
    @Test
    public void testSetMass() {
        System.out.println("setMass");
        double mass = 798.0;
        SegmentResult instance = new SegmentResult();
        instance.setMass(mass);
    }

    /**
     * Test of setDistance method, of class SegmentResult.
     */
    @Test
    public void testSetDistance() {
        System.out.println("setDistance");
        double distance = 4766;
        SegmentResult instance = new SegmentResult();
        instance.setDistance(distance);
    }

    /**
     * Test of setFlightTime method, of class SegmentResult.
     */
    @Test
    public void testSetFlightTime() {
        System.out.println("setFlightTime");
        int flightTime = 809;
        SegmentResult instance = new SegmentResult();
        instance.setFlightTime(flightTime);
    }

    /**
     * Test of getVIas method, of class SegmentResult.
     */
    @Test
    public void testGetVIas() {
        System.out.println("getVIas");
        double altitude = 1993.83;
        SegmentType type = SegmentType.CLIMBING;
        double thrust0=3.38*Math.pow(10,5);
        double thrustMax=1.80*Math.pow(10,5);
        double maxThrustSpeed=0.9;
        
        Thrust_Function thrustFunction=new Thrust_Function(thrust0, thrustMax, maxThrustSpeed);
        
        int nrEngines=4;
        double cruiseAltitude=0;
        double cruiseSpeed=0;
        double tsfc=1.60*Math.pow(10,-4);
        double lapse=0.960;
        
        Motorization motorization=new Motorization(nrEngines, "", "", cruiseAltitude, cruiseSpeed, tsfc, lapse, thrustFunction);
        
        double wingArea=858;
        double ar=9;
        double e=0.84;
        
        createPatterns();
        
        AircraftModel aircraftModel=new AircraftModel("", "", "", "PASSENGER", motorization, 0,0, 0, 0, 0, 0, wingArea, 0, ar, e, listIten);
        SegmentResult instance = new SegmentResult(type, 0, 10000, 0, aircraftModel, listPattern,new Segment(),0);
        
        double result = instance.getVIas(altitude, type);
        assertEquals(210, result, 0.0);
    }

    /**
     * Test of getIndex method, of class SegmentResult.
     */
    @Test
    public void testGetIndex() {
        System.out.println("getIndex");
        double altitude = 1900.0;
        int expResult = 1;
        SegmentType type = SegmentType.CLIMBING;
        createPatterns();
        AircraftModel aircraftModel=new AircraftModel("", "", "", "PASSENGER", 
                new Motorization(), 0,0, 0, 0, 0, 0, 0, 0, 0,0, listIten);
        FlightPlan flightPlan=new FlightPlan("aa00", 0, new Aircraft(),
                new Airport(), new Airport(), new LinkedList<>(), 
                new LinkedList<>(), listPattern);
        SegmentResult instance = new SegmentResult(type, 0, 10000, 0, 
                aircraftModel, listPattern, new Segment(),0);

        int result = instance.getIndex(altitude);
        assertEquals(expResult, result);
        
    }
    
    private void createItens(){
        listIten=new LinkedList<>();
        Iten i0=new Iten(0.5,0.02);
        Iten i1=new Iten(0.8,0.03);
        Iten i2=new Iten(0.9,0.04);
        
        listIten.add(i0);
        listIten.add(i1);
        listIten.add(i2);
    }
    
    private void createPatterns(){
        listPattern=new LinkedList<>();
        
        Pattern pattern0=new Pattern(0, 210, 180);
        Pattern pattern1=new Pattern(1000, 210, 200);
        Pattern pattern2=new Pattern(2000, 220, 250);
        Pattern pattern3=new Pattern(3000, 230, 250);
        Pattern pattern4=new Pattern(4000, 250, 270);
        Pattern pattern5=new Pattern(5000, 260, 300);
        Pattern pattern6=new Pattern(6000, 290, 300);
        Pattern pattern7=new Pattern(7000, 290, 300);
        Pattern pattern8=new Pattern(8000, 290, 300);
        Pattern pattern9=new Pattern(9000, 290, 300);
        Pattern pattern10=new Pattern(10000, 290, 300);
        Pattern pattern11=new Pattern(11000, 300, 300);
        Pattern pattern12=new Pattern(12000, 300, 300);
        Pattern pattern13=new Pattern(130000, 300, 300);
        Pattern pattern14=new Pattern(140000, 300, 300);
        
        listPattern.add(pattern0);
        listPattern.add(pattern1);
        listPattern.add(pattern2);
        listPattern.add(pattern3);
        listPattern.add(pattern4);
        listPattern.add(pattern5);
        listPattern.add(pattern6);
        listPattern.add(pattern7);
        listPattern.add(pattern8);
        listPattern.add(pattern9);
        listPattern.add(pattern10);
        listPattern.add(pattern11);
        listPattern.add(pattern12);
        listPattern.add(pattern13);
        listPattern.add(pattern14);
    }

    /**
     * Test of getModel method, of class SegmentResult.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        AircraftModel expResult=new AircraftModel();
        SegmentResult instance = new SegmentResult(SegmentType.DESC, 0, 0, 0, 
                expResult, listPattern,new Segment(),0);
        AircraftModel result = instance.getModel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModel method, of class SegmentResult.
     */
    @Test
    public void testSetModel() {
        System.out.println("setModel");
        AircraftModel model = new AircraftModel();
        SegmentResult instance = new SegmentResult(SegmentType.DESC, 0, 0, 0, 
                model, listPattern,new Segment(),0);
        instance.setModel(model);
    }

    /**
     * Test of getCDrag0 method, of class SegmentResult.
     */
    @Test
    public void testGetCDrag0() {
        System.out.println("getCDrag0");
        double speed = 0.85;
       
        createItens();
        
        AircraftModel model = new AircraftModel("Dummy01", "", "", "Dummy01", 
                new Motorization(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, listIten);
        
        SegmentResult instance = new SegmentResult(SegmentType.DESC, 0, 0, 0,
                model, listPattern,new Segment(),0);
        
        double expResult = 0.03;
        double result = instance.getCDrag0(speed);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSegment method, of class SegmentResult.
     */
    @Test
    public void testGetSegment() {
        System.out.println("getSegment");
        
        Node nodeTest=new Node("test1", 100, 200);
        Node nodeTest2=new Node("test2", 100,300);
        
        Segment expResult=new Segment("test", nodeTest, nodeTest2, "", new Wind(), 0, 1000);
        
        SegmentResult instance = new SegmentResult(SegmentType.DESC, 0, 0, 0, 
                new AircraftModel(), listPattern, expResult,0);
        Segment result = instance.getSegment();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegment method, of class SegmentResult.
     */
    @Test
    public void testSetSegment() {
        System.out.println("setSegment");
        Segment segment = new Segment();
        SegmentResult instance = new SegmentResult();
        instance.setSegment(segment);
    }

    /**
     * Test of getListPatterns method, of class SegmentResult.
     */
    @Test
    public void testGetListPatterns() {
        System.out.println("getListPatterns");
        
        createPatterns();
        SegmentResult instance = new SegmentResult(SegmentType.CLIMBING,0,0,0,
                new AircraftModel(), listPattern, new Segment(),0);
        List<Pattern> result = instance.getListPatterns();
        assertEquals(listPattern, result);
    }

    /**
     * Test of setListPatterns method, of class SegmentResult.
     */
    @Test
    public void testSetListPatterns() {
        System.out.println("setListPatterns");
        List<Pattern> listPatterns = null;
        SegmentResult instance = new SegmentResult();
        createPatterns();
        instance.setListPatterns(listPatterns);
    }

    /**
     * Test of getTas method, of class SegmentResult.
     */
    @Test
    public void testGetTas() {
        System.out.println("getTas");
        SegmentResult instance = new SegmentResult();
        double expResult = -1.0;
        double result = instance.getTas();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculate method, of class SegmentResult.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        SegmentResult instance = new SegmentResult();
        boolean expResult = true;
        boolean result = instance.calculate();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class SegmentResult.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        SegmentResult instance = new SegmentResult();
        boolean expResult = true;
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateCalculation method, of class SegmentResult.
     */
    @Test
    public void testValidateCalculation() {
        System.out.println("validateCalculation");
        SegmentResult instance = new SegmentResult();
        boolean expResult = false;
        boolean result = instance.validateCalculation();
        assertEquals(expResult, result);
    }
   
    /**
     * Test of setTas method, of class SegmentResult.
     */
    @Test
    public void testSetTas() {
        System.out.println("setTas");
        double tas = 0.0;
        SegmentResult instance = new SegmentResult();
        instance.setTas(tas);
    }

    /**
     * Test of getInitMass method, of class SegmentResult.
     */
    @Test
    public void testGetInitMass() {
        System.out.println("getInitMass");
        SegmentResult instance = new SegmentResult();
        double expResult = 1000;
        instance.setInitMass(expResult);
        double result = instance.getInitMass();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setInitMass method, of class SegmentResult.
     */
    @Test
    public void testSetInitMass() {
        System.out.println("setInitMass");
        double initMass = 0.0;
        SegmentResult instance = new SegmentResult();
        instance.setInitMass(initMass);
    }
    
    
    /**
     * Test of getAltitudeFinal method, of class SegmentResult.
     */
    @Test
    public void testGetAltitudeFinal() {
        System.out.println("getAltitudeFinal");
        SegmentResult instance = new SegmentResult();
        double expResult = 1000.0;
        instance.setAltitudeFinal(expResult);
        double result = instance.getAltitudeFinal();
        assertEquals(expResult, result, 0.0);  
    }
}
