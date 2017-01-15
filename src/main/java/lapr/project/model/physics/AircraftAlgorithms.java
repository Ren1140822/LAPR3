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
     * Fuel density (kg/L)
     */
    private static final double FUEL_DENSITY=8.040;
    /**
     * Default weight per person (kg)
     */
    private static final double WEIGHT_PER_PERSON=88.4505;
    
    /**
     * Sea level static thrust at takeoff (kg)
     */
    private static final double THRUST_SEA_LEVEL=7.71107029;
    /**
     * Density at sea level standart - kg/m3
     */
    private static final double AIR_DENSITY_SEA=1.225;
        
    /**
     * Speed of sound at sea level (m/s)
     */
    private static final double SPEED_SOUND_SEA=340.3;
    
    /**
     * Ratio of specific heat at constant volume
     */
    private static final double GAMMA_RATIO=1.4;

    /**
     * Calculate the lift force acting on the aircraft (N)
     * @param coefLift lift coefficient
     * @param airDensity air density (kg/m3)
     * @param velocity velocity of aircraft (m/s)
     * @param area area of the wings (m2)
     * @return lift force
     */
    public double calculateLiftForce(double coefLift, double airDensity, 
            double velocity, double area){
           return coefLift * ((airDensity * velocity*velocity) / 2) * area;
        }
    
    /**
     * Calculate the drag force acting on the aircraft (N)
     * @param coefDrag drag coefficient
     * @param airDensity air density (kg/m3)
     * @param velocity velocity at indicated air speed (m/s)
     * @param wingArea wingArea of the wings
     * @return drag force
     */
    public static double calculateDragForce(double coefDrag, double airDensity, 
            double velocity, double wingArea){
         //  return coefDrag * ((airDensity * Math.pow(velocity, 2)) / 2) * wingArea;             
         return  0.5*airDensity* Math.pow(velocity,2)*wingArea*coefDrag;
    }
     
    /**
     * Calculates de lift coefficient of airplane
     * @param mass total mass of aircraft
     * @param airDensity density of air (kg/m3)
     * @param areaWings area of wings (m2)
     * @param velocity true air speed (m/s)
     * @return lift coefficient
     */
    public static double calculateLiftCoefficient(double mass, double airDensity, 
            double areaWings,double velocity){
        double gravity=PhysicsAlgorithms.getGRAVITY_CONSTANT_SEA();
        return (2*mass*gravity)/(airDensity*areaWings*Math.pow(velocity,2));
    }
   
     /**
     * Calculates the drag coefficient of aircraft
     * @param cDrag0 drag coefficient
     * @param liftCoef lift coefficient
     * @param aRatio wing span (m)
     * @param e
     * @return lift coefficient
     */
    public static double calculateDragCoefficient(double cDrag0, double liftCoef, 
    double aRatio, double e){
    //R=287.06J/KgK  
    //return cDrag0 + (Math.pow(liftCoef,2)/ Math.PI*(Math.pow(wingSpan, 2)/wingArea)*e);
       
      return Math.pow(liftCoef,2)/(Math.PI*aRatio*e )+cDrag0;
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
     * @param cargoLoad cargo load (kg)
     * @param emptyWeight
     * @param fuel
     * @return initial weight
     */
    public static double calculateInitialWeight(int passengers, int crew, 
            double cargoLoad, double emptyWeight, double fuel){
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
    public static double calculateFinalWeight(double initialWeight, double timeFlight,
            double tsfc){
        return initialWeight -(timeFlight*tsfc);
    }
    
    /**
     * Calculate fuel used
     * @param initialWeight initial weight of aircraft (g)
     * @param finalWeight final weight of aircraft (g)
     * @param weightZeroFuel zero fuel weight (total - weight of the usable fuel on board)
     * @return  fuel used (g)
     */
    public static double calculateFuelUsed(double initialWeight, double finalWeight,
            double weightZeroFuel){
        return finalWeight-initialWeight-weightZeroFuel;
    }
     
    /**
     * Calculates thrust to the climb phase (kN)
     * @param thrustMa thrust (N)
     * @param lambda lambda (thrust)
     * @param mTrue true mass (kg)
     * @param airDensity air density (kg/m3)
     * @param thrustLapseRate thrust lapse rate
     * @return thrust (kN)
     */
    public static double calculateThrustClimb(double thrustMa, double lambda,
            double mTrue, double airDensity, double thrustLapseRate){
        //return  dragCoef*airDensity*Math.pow(tas, 2);
        return (thrustMa-lambda*mTrue)*Math.pow((airDensity/AIR_DENSITY_SEA),
                thrustLapseRate);
    } 
    
     /**
     * Calculates thrust to the cruise phase (kN)
     * @param drag drag force (N)
     * @param nrEngines number of engines in the aircraft
     * @return thrust (kN)
     */
    public static double calculateThrustCruise(double drag, int nrEngines){
        return drag/nrEngines;
    } 
    
     /**
     * Calculates thrust to the descend phase (kN)
     * @param thrustMa thrust (N)
     * @param lambda lambda (thrust)
     * @param mTrue true mass (kg)
     * @param airDensity air density (kg/m3)
     * @param thrustLapseRate thrust lapse rate
     * @return thrust (kN)
     */
    public static double calculateThrustDescend(double thrustMa, double lambda,
            double mTrue, double airDensity, double thrustLapseRate){
        //return  dragCoef*airDensity*Math.pow(tas, 2);
        return 0.1*(thrustMa-lambda*mTrue)*Math.pow(airDensity/AIR_DENSITY_SEA,
                thrustLapseRate);
 
    } 
  
    /**
     * Calculate the climb ratio (m/s)
     * @param totalThrust 
     * @param drag drag force (N)
     * @param tas true air speed (m/s)
     * @param mass initial mass (kg)
     * @return 
     */
    public static double calculateDhDt(double totalThrust, double
            drag, double tas, double mass){
        double gravity=PhysicsAlgorithms.getGRAVITY_CONSTANT_SEA();
        return (totalThrust-drag)*tas/mass/gravity;
    }
    
    /**
     * Calculates lambda (thrust)
     * @param velThrustMa velocity thrust (M)
     * @param thrustMa thrust (N)
     * @param thrustMi thrust (N)
     * @return lambda
     */
    public static double calculateLambda(double velThrustMa, double thrustMa, 
            double thrustMi){
        return (thrustMa-thrustMi)/(velThrustMa/SPEED_SOUND_SEA);
    }
    
    /**
     * Calculates the mass true of aircraft based on airdensity and indicated
     * air speed
     * @param airDensity air desnisty (kg/m3)
     * @param vIas velocity at indicated air speed (m/s)
     * @return true mass (kg)
     */
    public static double calculateMTrue(double airDensity, double vIas){
        double c1=AIR_DENSITY_SEA/airDensity;
        double c2=vIas/661.5;
        double exp1= 3.5;
        double exp2= 0.286;
        
        return Math.sqrt(5*(Math.pow(c1*(Math.pow(1+0.2*(c2*c2),exp1)-1)+1,exp2)-1));
    }
    
    /**
     * Calculates the true air speed based on altitude and indicated air speed 
     * @param airDensity air density (kg/m3)
     * @param temperature absolute temperatue (K)
     * @param vIas indicated air speed (m/s)
     * @return true air speed (m/s)
     */
    public static double calculateTAS(double airDensity, double temperature,
            double vIas){
        double mTrue=calculateMTrue(airDensity, vIas);
        double spSound=PhysicsAlgorithms.calculateSoundSpeed(temperature);

        return (mTrue*spSound);    
    }
    
        /**
     * Calculates the true wind applied (E6B- delta A)
     * @param course desired course relative to aircraft
     * @param wind wind applied
     * @param tas true airspeed (m/s)
       * @return true speed
     */
    public static double calculateTrueWindApplied(double course, Wind wind,
            double tas){
        return (int)(180/Math.PI * Math.asin(wind.getWindIntensity()/tas)*
                Math.sin((Math.PI*(wind.getWindDirection()-course))/180));
    }
    
    /**
     * Calculates the ground speed
     * @param tas true air speed of aircraft (m/s)
     * @param wind wind
     * @param course desired course
     * @return ground speed (m/s)
     */
    public static double calculateGroundSpeed(double tas,Wind wind, double course){
        double deltaA=calculateWindCorrectionAngle(course, tas, wind);
        return Math.sqrt(Math.pow(tas, 2)+Math.pow(wind.getWindIntensity(), 2)-
                2*tas*wind.getWindIntensity()*Math.cos((Math.PI*(course-wind.getWindDirection())+ deltaA)/180));
    }
        
    /**
     * Calculates the wind correction angle
     * @param angAircCourse angle of aircraft relative to the course
     * @param tas true airspeed of aircraft
     * @param wind wind applied
     * @return wind correction (%)
     */
    public static double calculateWindCorrectionAngle(double angAircCourse,
            double tas, Wind wind){
        return Math.asin(Math.toRadians(wind.getWindIntensity()/tas));
    }
    

    /**
     * Calculates the angle of aircraft related to the ground in climbing
     * @param tas true air speed (m/s)
     * @param dhDT acc
     * @return angle (radians)
     */
    public static double calculateClimbingAng(double tas, double dhDT){
        return Math.asin(dhDT/tas);
    }
   
    /**
     * Calculates the weight ratio (kg/s)
     * @param totalThrust
     * @param timeStep time step to consider
     * @param tsfc estimative thrust specific fuel consumption (TSFC) (g/s) per
     * unit of thrust (kN)
     * @return 
     */
    public static double calculateDwDt(double totalThrust, double
            timeStep, double tsfc){
        double gravity=PhysicsAlgorithms.getGRAVITY_CONSTANT_SEA();
        return totalThrust*timeStep*tsfc/gravity;
    }
    
    /**
     * Calculates the distance gained based on true air speed, climbing angle of
     * aircraft and time step 
     * @param tas true air speed (m/s)
     * @param angle angle (radians)
     * @param timeStep time step (s)
     * @return distance (m)
     */
    public static double calculateDistanceGained(double tas, double angle, double 
            timeStep){
        return tas*Math.cos(angle)*timeStep;
    }
    
    /**
     * Calculates the altitude gained based on timeStep, previous altitude and dhDT
     * @param prevAlt previous altitude
     * @param dhDT 
     * @param timeStep time step (s)
     * @return altitude (m)
     */
    public static double calculateAltitudeGained(double prevAlt,double dhDT, double timeStep){
        return prevAlt+(dhDT*timeStep);
    }
  
    /**
     * Calculates the new mass based on previous mass and dwDt
     * @param prevMass
     * @param dwDt
     * @return mass (kg)
     */
    public static double calculateNewMass(double prevMass, double dwDt){
        return prevMass-dwDt;
    }
    
    /**
     * Calculates the total thrust (climb phase) - N
     * @param thrust (kN)
     * @param nrEngines number of motors in the aircraft
     * @return total thrust
     */
    public static double calculateTotalThrustClimb(double thrust, int nrEngines){
        return thrust*nrEngines;
    }
    
    /**
     * Calculates the total thrust (descend phase) - N
     * @param thrust (kN)
     * @param nrEngines number of motors in the aircraft
     * @return 
     */
    public static double calculateTotalThrustDescend(double thrust, int nrEngines){
        if(thrust>0)
            return thrust*nrEngines;
        return 0;
    }
    
    /**
     * Calculates the total thrust (cruise phase) - N
     * @param draft draft force applied
     * @return total thrust
     */
    public static double calculateTotalThrustCruise(double draft){
        return draft;
    }
    
        /**
     * Calculates the altitude descended by aircraft (m)
     * @param dhDt ratio altitude per second (m/s)
     * @param timeStep time step considered
     * @return 
     */
    public static double calculateAltitudeDesc(double dhDt, int timeStep){
        return dhDt*timeStep;
    }

}
