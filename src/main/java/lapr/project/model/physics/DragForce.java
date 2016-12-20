/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.physics;

/**
 * Class to calculate and manage parameters related to the drage force applied to the aircraft
 * @author Diana Silva
 */
public class DragForce {
    /**
     * drag force acting on the aircraft (N)
     */
    private double dragForce;
    
    /**
     * drag coefficient
     */
    private double dragCoef;
    
    /**
     * area of the aircraft (m2)
     */
    private double areaAircraft;
    
    /**
     * density of air (kg/m3)
     */
    private double airDensity;

    /**
     * velocity of aircraft relative to air (m/s)
     */
    private double velocityAircraft;
    
    public DragForce(){
        this.dragCoef=-1000;
        this.areaAircraft=-1;
        this.dragForce=-1;
        this.airDensity=2263206;
        this.velocityAircraft=-1;
    }
    
    public DragForce(double airDensity, double velocityAircraft){
        
        this.velocityAircraft=velocityAircraft;
        this.airDensity=airDensity;
        this.areaAircraft=-1;
        this.dragCoef=-1000;
       
    }
    
    public DragForce(double dragCoef, double areaAircraft, double airDensity, double velocityAircraft){
        this.dragCoef=dragCoef;
        this.areaAircraft=areaAircraft;
        this.airDensity=airDensity;
        this.velocityAircraft=velocityAircraft;
    }
     
    private boolean validateOperation(){
        return getAirDensity()!=-1 && getDragCoef()!=-1000 && getVelocityAircraft()!=-1 && getAreaAircraft()!=-1;
    }

    /**
     * @return the dragForce
     */
    public double getDragForce() {
        return dragForce;
    }

    /**
     * @param dragForce the dragForce to set
     */
    public void setDragForce(double dragForce) {
        this.dragForce = dragForce;
    }

    /**
     * @return the dragCoef
     */
    public double getDragCoef() {
        return dragCoef;
    }

    /**
     * @param dragCoef the dragCoef to set
     */
    public void setDragCoef(double dragCoef) {
        this.dragCoef = dragCoef;
    }

    /**
     * @return the areaAircraft
     */
    public double getAreaAircraft() {
        return areaAircraft;
    }

    /**
     * @param areaAircraft the areaAircraft to set
     */
    public void setAreaAircraft(double areaAircraft) {
        this.areaAircraft = areaAircraft;
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
     * @return the velocityAircraft
     */
    public double getVelocityAircraft() {
        return velocityAircraft;
    }

    /**
     * @param velocityAircraft the velocityAircraft to set
     */
    public void setVelocityAircraft(double velocityAircraft) {
        this.velocityAircraft = velocityAircraft;
    }
    
       
    public double getResult(){
        return getDragForce();
    }
    
    public boolean calculateDragForce(){
        if(validateOperation()){
            setDragForce(getDragCoef() * (getAirDensity() * Math.pow(getVelocityAircraft(), 2) / 2) * getAreaAircraft());
            return true;
        }
        return false;
    }
}
