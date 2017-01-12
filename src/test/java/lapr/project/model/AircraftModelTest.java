/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pedro Fernandes
 */
public class AircraftModelTest {
    
    public AircraftModelTest() {
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
     * Test of toString method, of class AircraftModel.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AircraftModel instance = new AircraftModel();
        String expResult = instance.getId();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class AircraftModel.
     */
    @Test
    public void testEquals() {
        System.out.println("equals1");
        Object otherObject = null;
        AircraftModel instance = new AircraftModel();
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
        System.out.println("equals2");
        Object otherObject2 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(), 
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, new LinkedList<>());
        AircraftModel instance2 = new AircraftModel();
        boolean expResult2 = true;
        boolean result2 = instance2.equals(otherObject2);
        assertEquals(expResult2, result2);
        
        System.out.println("equals3");
        Object otherObject3 = new Motorization();
        AircraftModel instance3 = new AircraftModel();
        boolean expResult3 = false;
        boolean result3 = instance3.equals(otherObject3);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of validate method, of class AircraftModel.
     */
    @Test
    public void testValidate() {
        
        List<Thrust_Function> regimeList = new LinkedList<>();
        Thrust_Function r = new Thrust_Function();
        regimeList.add(r);
        
        
        System.out.println("validate1");
        AircraftModel instance = new AircraftModel("", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(), 
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, new  LinkedList<>());
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        
        System.out.println("validate2");
        AircraftModel instance2 = new AircraftModel("Dummy 01", "", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, new  LinkedList<>());
        boolean expResult2 = false;
        boolean result2 = instance2.validate();
        assertEquals(expResult2, result2);
        
        System.out.println("validate3");
        AircraftModel instance3 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, new  LinkedList<>());
        boolean expResult3 = false;
        boolean result3 = instance3.validate();
        assertEquals(expResult3, result3);
        
        System.out.println("validate4");
        AircraftModel instance4 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, new  LinkedList<>());
        boolean expResult4 = false;
        boolean result4 = instance4.validate();
        assertEquals(expResult4, result4);
        
        System.out.println("validate5");
        AircraftModel instance5 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", null, 
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, new LinkedList<>());
        boolean expResult5 = false;
        boolean result5 = instance5.validate();
        assertEquals(expResult5, result5);
        
        System.out.println("validate6");
        AircraftModel instance6 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                0, 1, 1, 1, 1, 1, 1, 1, 1, 1, new  LinkedList<>());
        boolean expResult6 = false;
        boolean result6 = instance6.validate();
        assertEquals(expResult6, result6);
        
        System.out.println("validate7");
        AircraftModel instance7 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 0, 1, 1, 1, 1, 1, 1, 1, 1, new  LinkedList<>());
        boolean expResult7 = false;
        boolean result7 = instance7.validate();
        assertEquals(expResult7, result7);
        
        System.out.println("validate8");
        AircraftModel instance8 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 0, 1, 1, 1, 1, 1, 1, 1, new  LinkedList<>());
        boolean expResult8 = false;
        boolean result8 = instance8.validate();
        assertEquals(expResult8, result8);
        
        System.out.println("validate9");
        AircraftModel instance9 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 0, 1, 1, 1, 1, 1, 1, new  LinkedList<>());
        boolean expResult9 = false;
        boolean result9 = instance9.validate();
        assertEquals(expResult9, result9);
        
        System.out.println("validate10");
        AircraftModel instance10 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 1, 0, 1, 1, 1, 1, 1, new  LinkedList<>());
        boolean expResult10 = false;
        boolean result10 = instance10.validate();
        assertEquals(expResult10, result10);
        
        System.out.println("validate11");
        AircraftModel instance11 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 1, 1, 0, 1, 1, 1, 1, new  LinkedList<>());
        boolean expResult11 = false;
        boolean result11 = instance11.validate();
        assertEquals(expResult11, result11);
        
        System.out.println("validate12");
        AircraftModel instance12 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 1, 1, 1, 0, 1, 1, 1, new  LinkedList<>());
        boolean expResult12 = false;
        boolean result12 = instance12.validate();
        assertEquals(expResult12, result12);
        
        System.out.println("validate13");
        AircraftModel instance13 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 1, 1, 1, 1, 0, 1, 1, new  LinkedList<>());
        boolean expResult13 = false;
        boolean result13 = instance13.validate();
        assertEquals(expResult13, result13);
        
        System.out.println("validate14");
        AircraftModel instance14 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 1, 1, 1, 1, 1, 0, 1, new  LinkedList<>());
        boolean expResult14 = false;
        boolean result14 = instance14.validate();
        assertEquals(expResult14, result14);
        
        System.out.println("validate15");
        AircraftModel instance15 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 1, 1, 1, 1, 1, 1, 0, new  LinkedList<>());
        boolean expResult15 = false;
        boolean result15 = instance15.validate();
        assertEquals(expResult15, result15);
        
        System.out.println("validate16");
        Iten i = new Iten(10, 10);
        List list = new LinkedList<>();
        list.add(i);
        AircraftModel instance16 = new AircraftModel("Dummy 01", "Dummy aircraft 01", 
                "Boeing", "passenger", new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function()), 
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, list);
        boolean expResult16 = false;
        boolean result16 = instance16.validate();
        assertEquals(expResult16, result16);
    }

    /**
     * Test of getId method, of class AircraftModel.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        AircraftModel instance = new AircraftModel();
        String expResult = "Dummy 01";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class AircraftModel.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "Dummy 01";
        AircraftModel instance = new AircraftModel();
        instance.setId(id);
    }

    /**
     * Test of getDescription method, of class AircraftModel.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        AircraftModel instance = new AircraftModel();
        String expResult = "Dummy aircraft 01";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class AircraftModel.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Dummy aircraft 01";
        AircraftModel instance = new AircraftModel();
        instance.setDescription(description);
    }

    /**
     * Test of getMaker method, of class AircraftModel.
     */
    @Test
    public void testGetMaker() {
        System.out.println("getMaker");
        AircraftModel instance = new AircraftModel();
        String expResult = "Boeing";
        String result = instance.getMaker();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaker method, of class AircraftModel.
     */
    @Test
    public void testSetMaker() {
        System.out.println("setMaker");
        String maker = "Boeing";
        AircraftModel instance = new AircraftModel();
        instance.setMaker(maker);
    }

    /**
     * Test of getType method, of class AircraftModel.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        AircraftModel instance = new AircraftModel();
        String expResult = "PASSENGER";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class AircraftModel.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "passenger";
        AircraftModel instance = new AircraftModel();
        instance.setType(type);
    }

    /**
     * Test of getType_ method, of class AircraftModel.
     */
    @Test
    public void testGetType_() {
        System.out.println("getType_");
        AircraftModel instance = new AircraftModel();
        String expResult = "PASSENGER";
        String result = instance.getType_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType_ method, of class AircraftModel.
     */
    @Test
    public void testSetType_() {
        System.out.println("setType_");
        String type = "passenger";
        AircraftModel instance = new AircraftModel();
        instance.setType_(type);
    }

    /**
     * Test of getMotorization method, of class AircraftModel.
     */
    @Test
    public void testGetMotorization() {
        System.out.println("getMotorization");
        List<Thrust_Function> regimeList = new LinkedList<>();
        Thrust_Function r = new Thrust_Function();
        regimeList.add(r);
        AircraftModel instance = new AircraftModel();
        Motorization expResult = new Motorization(10, "motor", "motor_type", 1,1,1,1, new Thrust_Function());
        instance.setMotorization(expResult);
        Motorization result = instance.getMotorization();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMotorization method, of class AircraftModel.
     */
    @Test
    public void testSetMotorization_4args() {
        System.out.println("setMotorization");
        int number_motors =4;
        String motor = "dsf";
        String motor_type = "gdf";
        List<Thrust_Function> regimeList = new LinkedList<>();
        Thrust_Function r = new Thrust_Function();
        regimeList.add(r);
        AircraftModel instance = new AircraftModel();
        instance.setMotorization(number_motors, motor, motor_type, 1,1,1,1, new Thrust_Function());
    }

    /**
     * Test of geteWeight method, of class AircraftModel.
     */
    @Test
    public void testGeteWeight() {
        System.out.println("geteWeight");
        AircraftModel instance = new AircraftModel();
        double expResult = 1.0;
        double result = instance.geteWeight();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of seteWeight method, of class AircraftModel.
     */
    @Test
    public void testSeteWeight() {
        System.out.println("seteWeight");
        double eWeight = 2.0;
        AircraftModel instance = new AircraftModel();
        instance.seteWeight(eWeight);
    }

    /**
     * Test of geteWeight_ method, of class AircraftModel.
     */
    @Test
    public void testGeteWeight_() {
        System.out.println("geteWeight_");
        AircraftModel instance = new AircraftModel();
        String expResult = "1.0";
        String result = instance.geteWeight_();
        assertEquals(expResult, result);
    }

    /**
     * Test of seteWeight_ method, of class AircraftModel.
     */
    @Test
    public void testSeteWeight_() {
        System.out.println("seteWeight_");
        String eWeight = "394.09E+03 US";
        AircraftModel instance = new AircraftModel();
        instance.seteWeight_(eWeight);
    }

    /**
     * Test of getMTOW method, of class AircraftModel.
     */
    @Test
    public void testGetMTOW() {
        System.out.println("getMTOW");
        AircraftModel instance = new AircraftModel();
        double expResult = 1.0;
        double result = instance.getMTOW();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setMTOW method, of class AircraftModel.
     */
    @Test
    public void testSetMTOW() {
        System.out.println("setMTOW");
        double MTOW = 202.0;
        AircraftModel instance = new AircraftModel();
        instance.setMTOW(MTOW);
    }

    /**
     * Test of getMTOW_ method, of class AircraftModel.
     */
    @Test
    public void testGetMTOW_() {
        System.out.println("getMTOW_");
        AircraftModel instance = new AircraftModel();
        String expResult = "1.0";
        String result = instance.getMTOW_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMTOW_ method, of class AircraftModel.
     */
    @Test
    public void testSetMTOW_() {
        System.out.println("setMTOW_");
        String MTOW = "875E+03 US";
        AircraftModel instance = new AircraftModel();
        instance.setMTOW_(MTOW);
    }

    /**
     * Test of getMaxPayload method, of class AircraftModel.
     */
    @Test
    public void testGetMaxPayload() {
        System.out.println("getMaxPayload");
        AircraftModel instance = new AircraftModel();
        double expResult = 1.0;
        double result = instance.getMaxPayload();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setMaxPayload method, of class AircraftModel.
     */
    @Test
    public void testSetMaxPayload() {
        System.out.println("setMaxPayload");
        double maxPayload = 0.0;
        AircraftModel instance = new AircraftModel();
        instance.setMaxPayload(maxPayload);
    }

    /**
     * Test of getMaxPayload_ method, of class AircraftModel.
     */
    @Test
    public void testGetMaxPayload_() {
        System.out.println("getMaxPayload_");
        AircraftModel instance = new AircraftModel();
        String expResult = "1.0";
        String result = instance.getMaxPayload_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxPayload_ method, of class AircraftModel.
     */
    @Test
    public void testSetMaxPayload_() {
        System.out.println("setMaxPayload_");
        String maxPayload = "71395 US";
        AircraftModel instance = new AircraftModel();
        instance.setMaxPayload_(maxPayload);
    }

    /**
     * Test of getFuelCapacity method, of class AircraftModel.
     */
    @Test
    public void testGetFuelCapacity() {
        System.out.println("getFuelCapacity");
        AircraftModel instance = new AircraftModel();
        double expResult = 1.0;
        double result = instance.getFuelCapacity();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFuelCapacity method, of class AircraftModel.
     */
    @Test
    public void testSetFuelCapacity() {
        System.out.println("setFuelCapacity");
        double fuelCapacity = 10.0;
        AircraftModel instance = new AircraftModel();
        instance.setFuelCapacity(fuelCapacity);
    }

    /**
     * Test of getFuelCapacity_ method, of class AircraftModel.
     */
    @Test
    public void testGetFuelCapacity_() {
        System.out.println("getFuelCapacity_");
        AircraftModel instance = new AircraftModel();
        String expResult = "1.0";
        String result = instance.getFuelCapacity_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFuelCapacity_ method, of class AircraftModel.
     */
    @Test
    public void testSetFuelCapacity_() {
        System.out.println("setFuelCapacity_");
        String fuelCapacity = "57285 US";
        AircraftModel instance = new AircraftModel();
        instance.setFuelCapacity_(fuelCapacity);
    }

    /**
     * Test of getVMO method, of class AircraftModel.
     */
    @Test
    public void testGetVMO() {
        System.out.println("getVMO");
        AircraftModel instance = new AircraftModel();
        double expResult = 1.0;
        double result = instance.getVMO();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setVMO method, of class AircraftModel.
     */
    @Test
    public void testSetVMO() {
        System.out.println("setVMO");
        double VMO = 120.0;
        AircraftModel instance = new AircraftModel();
        instance.setVMO(VMO);
    }

    /**
     * Test of getVMO_ method, of class AircraftModel.
     */
    @Test
    public void testGetVMO_() {
        System.out.println("getVMO_");
        AircraftModel instance = new AircraftModel();
        String expResult = "1.0";
        String result = instance.getVMO_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVMO_ method, of class AircraftModel.
     */
    @Test
    public void testSetVMO_() {
        System.out.println("setVMO_");
        String VMO = "365 Knot";
        AircraftModel instance = new AircraftModel();
        instance.setVMO_(VMO);
    }

    /**
     * Test of getMMO method, of class AircraftModel.
     */
    @Test
    public void testGetMMO() {
        System.out.println("getMMO");
        AircraftModel instance = new AircraftModel();
        double expResult = 1.0;
        double result = instance.getMMO();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setMMO method, of class AircraftModel.
     */
    @Test
    public void testSetMMO() {
        System.out.println("setMMO");
        double MMO = 0.01;
        AircraftModel instance = new AircraftModel();
        instance.setMMO(MMO);
    }

    /**
     * Test of getMMO_ method, of class AircraftModel.
     */
    @Test
    public void testGetMMO_() {
        System.out.println("getMMO_");
        AircraftModel instance = new AircraftModel();
        String expResult = "1.0";
        String result = instance.getMMO_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMMO_ method, of class AircraftModel.
     */
    @Test
    public void testSetMMO_() {
        System.out.println("setMMO_");
        String MMO = "0.9 M";
        AircraftModel instance = new AircraftModel();
        instance.setMMO_(MMO);
    }

    /**
     * Test of getWingArea method, of class AircraftModel.
     */
    @Test
    public void testGetWingArea() {
        System.out.println("getWingArea");
        AircraftModel instance = new AircraftModel();
        double expResult = 1.0;
        double result = instance.getWingArea();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setWingArea method, of class AircraftModel.
     */
    @Test
    public void testSetWingArea() {
        System.out.println("setWingArea");
        double wingArea = 120.0;
        AircraftModel instance = new AircraftModel();
        instance.setWingArea(wingArea);
    }

    /**
     * Test of getWingArea_ method, of class AircraftModel.
     */
    @Test
    public void testGetWingArea_() {
        System.out.println("getWingArea_");
        AircraftModel instance = new AircraftModel();
        String expResult = "1.0";
        String result = instance.getWingArea_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWingArea_ method, of class AircraftModel.
     */
    @Test
    public void testSetWingArea_() {
        System.out.println("setWingArea_");
        String wingArea = "512 SI";
        AircraftModel instance = new AircraftModel();
        instance.setWingArea_(wingArea);
    }

    /**
     * Test of getWingSpan method, of class AircraftModel.
     */
    @Test
    public void testGetWingSpan() {
        System.out.println("getWingSpan");
        AircraftModel instance = new AircraftModel();
        double expResult = 1.0;
        double result = instance.getWingSpan();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setWingSpan method, of class AircraftModel.
     */
    @Test
    public void testSetWingSpan() {
        System.out.println("setWingSpan");
        double wingSpan = 10.0;
        AircraftModel instance = new AircraftModel();
        instance.setWingSpan(wingSpan);
    }

    /**
     * Test of getWingSpan_ method, of class AircraftModel.
     */
    @Test
    public void testGetWingSpan_() {
        System.out.println("getWingSpan_");
        AircraftModel instance = new AircraftModel();
        String expResult = "1.0";
        String result = instance.getWingSpan_();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWingSpan_ method, of class AircraftModel.
     */
    @Test
    public void testSetWingSpan_() {
        System.out.println("setWingSpan_");
        String wingSpan = "512 SI";
        AircraftModel instance = new AircraftModel();
        instance.setWingSpan_(wingSpan);
    }

    /**
     * Test of getE method, of class AircraftModel.
     */
    @Test
    public void testGetE() {
        System.out.println("getE");
        AircraftModel instance = new AircraftModel();
        double expResult = 1.0;
        double result = instance.getE();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setE method, of class AircraftModel.
     */
    @Test
    public void testSetE() {
        System.out.println("setE");
        double e = 0.078;
        AircraftModel instance = new AircraftModel();
        instance.setE(e);
    }

    /**
     * Test of setMotorization method, of class AircraftModel.
     */
    @Test
    public void testSetMotorization_Motorization() {
        System.out.println("setMotorization");
        Motorization motorization = new Motorization();
        AircraftModel instance = new AircraftModel();
        instance.setMotorization(motorization);
    }

    /**
     * Test of hashCode method, of class AircraftModel.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        AircraftModel instance = new AircraftModel();
        int expResult = instance.getId().hashCode() + 7 * 79;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMotorization method, of class AircraftModel.
     */
    @Test
    public void testSetMotorization_8args() {
        System.out.println("setMotorization");
        int number_motors = 4;
        String motor = "df";
        String motor_type = "fgd";
        double cruise_altitude = 1.0;
        double cruise_speed = 1.0;
        double TSFC = 1.0;
        double lapse_rate_factor = 1.0;
        Thrust_Function thrust_function = new Thrust_Function(12, 12, 12);
        AircraftModel instance = new AircraftModel();
        instance.setMotorization(number_motors, motor, motor_type, cruise_altitude, cruise_speed, TSFC, lapse_rate_factor, thrust_function);
    }

    /**
     * Test of getAspect_ratio method, of class AircraftModel.
     */
    @Test
    public void testGetAspect_ratio() {
        System.out.println("getAspect_ratio");
        AircraftModel instance = new AircraftModel();
        double expResult = 1.0;
        double result = instance.getAspectRatio();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAspect_ratio method, of class AircraftModel.
     */
    @Test
    public void testSetAspect_ratio() {
        System.out.println("setAspect_ratio");
        double aspect_ratio = 1.0;
        AircraftModel instance = new AircraftModel();
        instance.setAspectRatio(aspect_ratio);
    }

    /**
     * Test of addIten method, of class AircraftModel.
     */
    @Test
    public void testAddIten() {
        System.out.println("addIten");
        double speed = 10.0;
        double Cdrag_0 = 10.0;
        AircraftModel instance = new AircraftModel();
        boolean expResult = true;
        boolean result = instance.addIten(speed, Cdrag_0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListIten method, of class AircraftModel.
     */
    @Test
    public void testGetListIten() {
        System.out.println("getListIten");
        AircraftModel instance = new AircraftModel();
        List<Iten> expResult = new LinkedList<>();
        instance.setListIten(expResult);
        List<Iten> result = instance.getListIten();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListIten method, of class AircraftModel.
     */
    @Test
    public void testSetListIten() {
        System.out.println("setListIten");
        List<Iten> listIten = new LinkedList<>();
        AircraftModel instance = new AircraftModel();
        instance.setListIten(listIten);
    }
}
