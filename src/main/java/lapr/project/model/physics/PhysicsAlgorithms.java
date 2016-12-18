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
    
    /**
     * Calculates the density of air
     * @param absolutePressure absolute pressure (Pa)
     * @return density of air (kg/m3)
     */
    public static double calculateAirDensity(double absolutePressure){
        //287.058= specific gas constant for dry air J/(kg.K) 
        double absoluteTemperature=216.65;
        return absolutePressure/(287.058*absoluteTemperature);
    }
    
    /**
     * Calculates the velocity of aircraft
     * @param distance distance (km)
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
     * @return lift coefficient
     */
    public static double calculateDragCoefficient(double liftCoef, double areaAircraft,double naoSei){
       //falta fazer
       //R=287.06J/KgK
        return 0;
    }
    
    /**
     * Calculates the estimative thrust specific fuel consumption (TSFC) - fuel 
     * efficienty of an engine design, i.e. fuel consumption (g/s) per unit of
     * thrust (kN)
     * @return fuel consumption per unit of thrust ((g/s)/kN)
     */
    public static double calculateTSFC(){
        //T^3= P2/ 4p (densidade)*A (volumeAr)
        return 0;
    }
    
    /**
     * Calculates the range of an aircraft in cruise flight
     * @return estimative fuelConsumption range of aircraft in cruise flight
     */
    public static double calculateRangeAircraft(){
        //TrueAirSpeed (TAS), TSFC, Wi=initial weight, Wf=final weight
        //R= (TAS/TSFC)*(L/D)*ln(Wi/Wf)
        return 0;
    }
}
