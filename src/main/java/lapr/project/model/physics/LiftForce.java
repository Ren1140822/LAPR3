/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.physics;

/**
 * Class to calculate and manage parameters related to the lift force applied to the aircraft
 * @author Diana Silva
 */
public class LiftForce {
    /**
     * lift force acting on the aircraft (N)
     */
    private double liftForce;
    
    /**
     * lift coefficient
     */
    private double liftCoef;
    
    /**
     * area of the wings (m2)
     */
    private double areaWings;
    
    /**
     * density of air (kg/m3)
     */
    private double airDensity;

    /**
     * velocity of aircraft relative to air (m/s)
     */
    private double aircraftVelocity;
    
    public LiftForce(){
        this.liftCoef=-1000;
        this.areaWings=-1;
        this.airDensity=2263206;
        this.aircraftVelocity=-1;
    }
    
    public LiftForce(double liftCoef, double aircraftVelocity){
        this.liftCoef=liftCoef;     
        this.aircraftVelocity=aircraftVelocity; 
        this.areaWings=-1;
        this.airDensity=-1;
    }
    
    public LiftForce(double liftCoef, double areaWings, double airDensity, double aircraftVelocity){
        this.liftCoef=liftCoef;
        this.areaWings=areaWings;
        this.airDensity=airDensity;
        this.aircraftVelocity=aircraftVelocity;
    }
    
    public double getResult(){
        return liftForce;
    }
    
    public boolean calculateLiftForce(){
        if(validateOperation()){
            liftForce= liftCoef* (airDensity*Math.pow(aircraftVelocity, 2)/2) * areaWings;
            return true;
        }
        return false;
    }
    
    private boolean validateOperation(){
        return airDensity!=-1 && liftCoef!=-1000 && aircraftVelocity!=-1 && areaWings!=-1;
    }
}
