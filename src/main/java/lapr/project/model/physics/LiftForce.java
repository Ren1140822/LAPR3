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
    
    /**
     * @return the liftForce
     */
    public double getLiftForce() {
        return liftForce;
    }

    /**
     * @param liftForce the liftForce to set
     */
    public void setLiftForce(double liftForce) {
        this.liftForce = liftForce;
    }

    /**
     * @return the liftCoef
     */
    public double getLiftCoef() {
        return liftCoef;
    }

    /**
     * @param liftCoef the liftCoef to set
     */
    public void setLiftCoef(double liftCoef) {
        this.liftCoef = liftCoef;
    }

    /**
     * @return the areaWings
     */
    public double getAreaWings() {
        return areaWings;
    }

    /**
     * @param areaWings the areaWings to set
     */
    public void setAreaWings(double areaWings) {
        this.areaWings = areaWings;
    }

    /**
     * @return the airDensity
     */
    public double getAirDensity() {
        return airDensity;
    }

    /**
     * @param airDensity the airDensity to set
     */
    public void setAirDensity(double airDensity) {
        this.airDensity = airDensity;
    }

    /**
     * @return the aircraftVelocity
     */
    public double getAircraftVelocity() {
        return aircraftVelocity;
    }

    /**
     * @param aircraftVelocity the aircraftVelocity to set
     */
    public void setAircraftVelocity(double aircraftVelocity) {
        this.aircraftVelocity = aircraftVelocity;
    }
        
    public double getResult(){
        return getLiftForce();
    }
    
    public boolean calculateLiftForce(){
        if(validateOperation()){
            setLiftForce(getLiftCoef() * (getAirDensity() * Math.pow(getAircraftVelocity(), 2) / 2) * getAreaWings());
            return true;
        }
        return false;
    }
    
    private boolean validateOperation(){
        return getAirDensity()!=-1 && getLiftCoef()!=-1000 && getAircraftVelocity()!=-1 && getAreaWings()!=-1;
    }
}
