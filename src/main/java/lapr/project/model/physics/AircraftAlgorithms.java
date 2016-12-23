/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.physics;

import lapr.project.model.AircraftModel;
import lapr.project.model.Wind;

/**
 *
 * @author DianaSilva
 */
public class AircraftAlgorithms {    
    
      /**
     * Calculates the velocity of aircraft based on aircraft mass
     * @param velocityRef reference velocity
     * @param mass real mass
     * @param massRef reference mass
     * @return the velocity of aircraft (m/s)
     */
    public static double calculateVelocityAircraftMass(double velocityRef, double mass, double massRef){
        return velocityRef * Math.pow(mass/massRef, 0.5);
    }
    
    /**
     * Calculate the lift force acting on the aircraft (N)
     * @param coefLift lift coefficient
     * @param airDensity air density (kg/m3)
     * @param velocity velocity of aircraft (m/s)
     * @param area area of the wings (m2)
     * @return lift force
     */
    public double calculateLiftForce(double coefLift, double airDensity, double velocity, double area){
           return coefLift * ((airDensity * Math.pow(velocity, 2)) / 2) * area;
        }
    
    /**
     * Calculate the drag force acting on the aircraft (N)
     * @param coefDrag drag coefficient
     * @param airDensity air density (kg/m3)
     * @param velocity velocity of aircraft (m/s)
     * @param area reference area of the aircraft (m2)
     * @return drag force
     */
    public double calculateDragForce(double coefDrag, double airDensity, double velocity, double area){
           return coefDrag * ((airDensity * Math.pow(velocity, 2)) / 2) * area;    
    }
     
    /**
     * Calculates de lift coefficient of airplane
     * @param mass total mass of aircraft
     * @param airDensity density of air (kg/m3)
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
     * Calculate the maximum climb and take-off thrust at standart conditions (N)
     * @param coef1
     * @param altitude
     * @param coef2
     * @param coef3
     * @return maximum climb thrust (N)
     */
    public static double calculateClimbThrustJet(double altitude, double coef1, double coef2, double coef3){
        double altitudeFeets=ConversionAlgorithms.convertMetersFeet(altitude);
        return coef1* ( 1- (altitudeFeets/coef2) + coef3*Math.pow(altitude,2));
    }

    
    /**
     * Calculate the maximum climb and take-off thrust at standart conditions (N)
     * @param coef1
     * @param tas true air speed (kt)
     * @param altitude altitutde (ft)
     * @param coef2
     * @param coef3
     * @return maximum climb thrust (N)
     */
    public static double calculateClimbThrustTurboProp(double altitude, double tas, double coef1,  double coef2, double coef3){
        double altitudeFeets=ConversionAlgorithms.convertMetersFeet(altitude);
        return coef1/tas * (1- (altitudeFeets/coef2)) + coef3 ;
    }
    
       /**
     * Calculate the maximum climb and take-off thrust at standart conditions (N)
     * @param coef1
     * @param tas true air speed (kt)
     * @param altitude altitutde (ft)
     * @param coef2
     * @param coef3
     * @return maximum climb thrust (N)
     */
    public static double calculateClimbThrustPiston(double altitude, double tas, double coef1,  double coef2, double coef3){
        double altitudeFeets=ConversionAlgorithms.convertMetersFeet(altitude);
        return coef1 * (1- (altitudeFeets/coef2)) + coef3/tas ;
    }
    
    /**
     * Calculates thrust (kN)
     * @param dragCoef coefficient of draf
     * @param airDensity air density (kg/m3)
     * @param groundSpeed aircraft speed relative to ground
     * @param wind wind 
     * @return thrust (knots)
     */
    public static double calculateThrust(double dragCoef, double airDensity, double groundSpeed, Wind wind){
        double trueSpeed=calculateTrueForceSpeed(wind, groundSpeed);
        return  dragCoef*airDensity*Math.pow(trueSpeed, 2);
    }
    
    /**
     * Calculate true air speed based on cruise velocity and altitude (knot)
     * @param velocity velocity (m/s)
     * @param altitude altitude (kg/m3)
     * @return true air speed
     */
    public static double calculateTrueAirSpeed(double velocity, double altitude){
       
        /**
         * cruiseSpeed + 2% per 2000feets altitude
         *     2000 feets  ----- 2%
                  1 feet   ------ x= 2000/2= 1000%=0.1
         */
        
        double altitudeFeets=ConversionAlgorithms.convertMetersFeet(altitude);
        return ConversionAlgorithms.convertKnotMS(velocity+ 0.1*altitudeFeets);      
    }
    
    /**
     * Claculates the true force speed of aircraft
     * @param wind wind 
     * @param groundSpeed aircraft speed relative to ground
     * @return true speed
     */
    public static double calculateTrueForceSpeed(Wind wind, double groundSpeed){
        return wind.getWindIntensity()*Math.cos(wind.getWindDirection()) + groundSpeed;
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
