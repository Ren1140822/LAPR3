/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.physics;

import lapr.project.model.AircraftModel;

/**
 * 
 * @author Diana Silva
 */
public class PhysicsAlgorithms {  
    //source: https://wahiduddin.net/calc/density_altitude.htm
    
    /**
     * static pressure (pressure at sea level (Pa)
     */
    private static final double PRESSURE_SEA=101325;
    
    /**
     * static temperature (temperature at sea level (K)
     */
    private static final double TEMPERATURE_SEA=288.15;
    
    /**
     * Specific gas constant for dry air (N.m/mol.K)
     */
    private static final double GAS_CONSTANT_AIR= 8.31432;
    
    /**
     * Acceleration of gravity at sea level (m/s2)
     */
    private static final double GRAVITY_CONSTANT_SEA=9.80665;
    
    /**
     * Temperature lapse rate (deg K/m)
     */
    private static final double TEMPERATURE_LAPSE_RATE=6.5;
    
    /**
     * Molecular weight of dry air (kg/mol)
     */
    private static final double WEIGHT_DRY_AIR=28.9644/1000;
    
    /**
     * Return the absolute temperature based on altitude (K)
     * @param altitude altitude (m)
     * @return temperature (kelvin)
     */
    public static double calculateAbsoluteTemperature(double altitude){
        //T= To - 6.5 * h(m)/1000
        return TEMPERATURE_SEA-(TEMPERATURE_LAPSE_RATE*(altitude/1000));
    }
    
    /**
     * Return the absolute pressure based on altitude (Pa)
     * @param altitude altitude (m)
     * @return absolute pressure (pa)
     */
    public static double calculateAbsolutePressure(double altitude){
       //P=P0. (1- (L.h/to))^ ((g*m)/(R*L)
       double base=1- ((TEMPERATURE_LAPSE_RATE*(altitude/1000)/TEMPERATURE_SEA));
       double exp=(GRAVITY_CONSTANT_SEA*WEIGHT_DRY_AIR)/(GAS_CONSTANT_AIR*TEMPERATURE_LAPSE_RATE); 
       return Double.doubleToLongBits(PRESSURE_SEA*Math.pow(base, exp));
    }
    
    /**
     * Calculates the density of air
     * @param pressure pressure (Pa)
     * @param temperature temperature (K)
     * @return density of air (kg/m3)
     */
    public static double calculateAirDensity(double pressure, double temperature){

        return (pressure*WEIGHT_DRY_AIR/(GAS_CONSTANT_AIR*temperature*1000))*1000;
    }
    
    /**
     * Calculates the velocity of aircraft
     * @param distance distance (m)
     * @param time time (hour)
     * @return the velocity of aircraft (m/s)
     */
    public static double calculateVelocityAircraft(double distance, double time){
        return distance/time;
    }
      
    /**
     * Calculates de lift coefficient of airplane
     * @param mass total mass of aircraft
     * @param airDensity density of air (km/m3)
     * @param areaWings area of wings (m2)
     * @param velocity velocity of aircraft (m2)
     * @return lift coefficient
     */
    public static double calculateLiftCoefficient(double mass, double airDensity, double areaWings,double velocity){
       //9.8= gravitational constant 
        return (2*mass*9.8)/(airDensity*areaWings*velocity);
    }
   
     /**
     * Calculates the drag coefficient of aircraft
     * @param cDrag0 drag coefficient
     * @param liftCoef lift coefficient
     * @param area area
     * @param e
     * @return lift coefficient
     */
    public static double calculateDragCoefficient(double cDrag0, double liftCoef, double area, double e){
       //R=287.06J/KgK  
        return cDrag0 + (Math.pow(liftCoef,2)/ Math.PI*area*e);
    }
    
    /**
     * Calculates the estimative thrust specific fuel consumption (TSFC) - fuel 
     * efficienty of an engine design, i.e. fuel consumption (g/s) per unit of
     * thrust (kN)
     * @param p
     * @param density density
     * @param airVolume air volume
     * @return fuel consumption per unit of thrust ((g/s)/kN)
     */
    public static double calculateTSFC(double p, double density, double airVolume){
        //T^3= P2/ 4p (densidade)*A (volumeAr)
        return Math.pow(p, 2)/ (4*p*density*airVolume);
    }
    
    /**
     * Calculates the range of an aircraft in cruise flight
     * @param tas true air speed
     * @param tsfc thrust specific fuel consumption
     * @param wi initial weight
     * @param wf final weight
     * @param liftForce ligt 
     * @param dragForce drag
     * @return estimative fuelConsumption range of aircraft in cruise flight
     */
    public static double calculateRangeAircraft(double tas, double tsfc, double wi, double wf, double liftForce, double dragForce){
        //TrueAirSpeed (TAS), TSFC, Wi=initial weight, Wf=final weight
        //R= (TAS/TSFC)*(L/D)*ln(Wi/Wf)
        return (tas/tsfc)*(liftForce/dragForce)*-Math.log(wi/wf);
    }
    
     /**
     * Calculates the range of an aircraftModel in cruise flight
     * @param aircraftModel aircraft model
     * @return estimative fuelConsumption range of aircraftModel in cruise flight
     */
    public static double calculateRangeAircraft(AircraftModel aircraftModel){
        //TrueAirSpeed (TAS), TSFC, Wi=initial weight, Wf=final weight
        //R= (TAS/TSFC)*(L/D)*ln(Wi/Wf)
        return 0;
                //(aircraftModel/tsfc)*(liftForce/dragForce)*-Math.log(wi/wf);
    }

    /**
     * @return the PRESSURE_SEA
     */
    public static double getPRESSURE_SEA() {
        return PRESSURE_SEA;
    }

    /**
     * @return the TEMPERATURE_SEA
     */
    public static double getTEMPERATURE_SEA() {
        return TEMPERATURE_SEA;
    }

    /**
     * @return the GAS_CONSTANT_AIR
     */
    public static double getGAS_CONSTANT_AIR() {
        return GAS_CONSTANT_AIR;
    }

    /**
     * @return the GRAVITY_CONSTANT_SEA
     */
    public static double getGRAVITY_CONSTANT_SEA() {
        return GRAVITY_CONSTANT_SEA;
    }   
}