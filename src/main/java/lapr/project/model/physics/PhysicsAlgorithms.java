/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.physics;

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
     * Molecular weight of dry air (g/mol)
     */
    private static final double WEIGHT_DRY_AIR=28.9644;
    
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
       double base=1- ((TEMPERATURE_LAPSE_RATE*(altitude/1000))/TEMPERATURE_SEA);
       double exp=(GRAVITY_CONSTANT_SEA*WEIGHT_DRY_AIR)/(GAS_CONSTANT_AIR*TEMPERATURE_LAPSE_RATE); 
       return PRESSURE_SEA*Math.pow(base, exp);
    }
    
    /**
     * Calculates the density of air (kg/m3)
     * @param pressure pressure (Pa)
     * @param temperature temperature (K)
     * @return density of air (kg/m3)
     */
    public static double calculateAirDensity(double pressure, double temperature){

        return (pressure*WEIGHT_DRY_AIR/(GAS_CONSTANT_AIR*temperature*1000));
    }
    
         
    /**
     * Calculates the velocity of aircraft
     * @param distance distance (m)
     * @param time time (s)
     * @return the velocity of aircraft (m/s)
     */
    public static double calculateVelocity(double distance, double time){
        return distance/time;
    }
    
     /**
     * Calculates the time based on distance and velocity
     * @param distance distance (m)
     * @param velocity velocity of aircraft (m/s)
     * @return the time dispended (s)
     */
    public static double calculateTime(double distance, double velocity){
        return distance/velocity;
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