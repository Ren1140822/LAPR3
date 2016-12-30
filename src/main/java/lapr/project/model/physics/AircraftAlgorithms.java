/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.physics;

import lapr.project.model.Wind;

/**
 *
 * @author DianaSilva
 */
public class AircraftAlgorithms {    
    /**
     * Fuel density (g/L)
     */
    private static final double FUEL_DENSITY=8040;
    /**
     * Default weight per person (g)
     */
    private static final double WEIGHT_PER_PERSON=88450.5;
    
    /**
     * Sea level static thrust at takeoff (g)
     */
    private static final double THRUST_SEA_LEVEL=7711.07029*1000;
    /**
     * Density at sea level standart - g/m3
     */
    private static final double AIR_DENSITY_SEA=1.225*1000;
    
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
     * @param area area of the wings
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
     * @param wingArea wing area (m2)
     * @param wingSpan wing span (m)
     * @param e
     * @return lift coefficient
     */
    public static double calculateDragCoefficient(double cDrag0, double liftCoef, double wingArea, double wingSpan, double e){
       //R=287.06J/KgK  
        return cDrag0 + (Math.pow(liftCoef,2)/ Math.PI*(Math.pow(wingSpan, 2)/wingArea)*e);
    }
    
    /**
     * Calculate the maximum climb and take-off thrust at standart conditions (N)
     * @param coef1 (N)
     * @param altitude altitude (m)
     * @param coef2 feet
     * @param coef3 1/(feet^2)
     * @return maximum climb thrust (N)
     */
    public static double calculateClimbThrustJet(double altitude, double coef1, double coef2, double coef3){
        double altitudeFeets=ConversionAlgorithms.convertMetersFeet(altitude);
        return coef1* ( 1- (altitudeFeets/coef2) + coef3*Math.pow(altitude,2));
    }

    
    /**
     * Calculate the maximum climb and take-off thrust at standart conditions (N)
     * @param coef1 (knot-N)
     * @param tas true air speed (kt)
     * @param altitude altitutde (m)
     * @param coef2 feet
     * @param coef3 N
     * @return maximum climb thrust (N)
     */
    public static double calculateClimbThrustTurboProp(double altitude, double tas, double coef1,  double coef2, double coef3){
        double altitudeFeets=ConversionAlgorithms.convertMetersFeet(altitude);
        return coef1/tas * (1- (altitudeFeets/coef2)) + coef3 ;
    }
    
       /**
     * Calculate the maximum climb and take-off thrust at standart conditions (N)
     * @param coef1 (N)
     * @param tas true air speed (kt)
     * @param altitude altitutde (ft)
     * @param coef2 feet
     * @param coef3 knot-N
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
     * @param altitude altitude (m)
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
        return wind.getWindIntensity()*Math.cos(wind.getWindDirection()) + 
                groundSpeed;
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
    public static double calculateRangeAircraft(double tas, double tsfc, 
            double wi, double wf, double liftForce, double dragForce){
        //R= (TAS/TSFC)*(L/D)*ln(Wi/Wf)
        return (tas/tsfc)*(liftForce/dragForce)*-Math.log(wi/wf);
    }
    
    /**
     * Calculates the initial weight of aircraft
     * @param passengers number of passengers
     * @param crew number of crew members
     * @param cargoLoad cargo load (g)
     * @param emptyWeight
     * @param fuel
     * @return initial weight
     */
    public static double calculateInitialWeight(int passengers, int crew, double cargoLoad, double emptyWeight, double fuel){
        return (passengers*WEIGHT_PER_PERSON)+(crew*WEIGHT_PER_PERSON) +
                cargoLoad+emptyWeight+(fuel*FUEL_DENSITY);
    }
    
    
    /**
     * Calculates the weight of aircraft in the end of a flight
     * @param initialWeight total initial weight of aircraft
     * @param timeFlight time flight (s)
     * @param tsfc thrust specific fuel consumption
     * @return final weight
     */
    public static double calculateFinalWeight(double initialWeight, double timeFlight, double tsfc){
        return initialWeight -(timeFlight*tsfc);
    }
    
    /**
     * Calculate fuel used
     * @param initialWeight initial weight of aircraft (g)
     * @param finalWeight final weight of aircraft (g)
     * @param weightZeroFuel zero fuel weight (total - weight of the usable fuel on board)
     * @return  fuel used (g)
     */
    public static double calculateFuelUsed(double initialWeight, double finalWeight,double weightZeroFuel){
        return finalWeight-initialWeight-weightZeroFuel;
    }
    
    public static double calculateThrust(double airDensity){
        return THRUST_SEA_LEVEL*Math.pow((airDensity/AIR_DENSITY_SEA),0.90);   
    }
}
