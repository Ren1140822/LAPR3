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
     * @param cDrag0 drag coefficient
     * @param liftCoef lift coefficient
     * @param area area
     * @return lift coefficient
     */
    public static double calculateDragCoefficient(double cDrag0, double liftCoef, double area){
       //R=287.06J/KgK  
        return cDrag0 + (Math.pow(liftCoef,2)/ Math.PI*area*Math.E);
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
    
}
