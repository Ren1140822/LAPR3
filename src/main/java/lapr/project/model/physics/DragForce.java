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
    double velocityAircraft;
    
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
    
    public double getResult(){
        return dragForce;
    }
    
    public boolean calculateDragForce(){
        if(validateOperation()){
            dragForce= dragCoef* (airDensity*Math.pow(velocityAircraft, 2)/2) * areaAircraft;
            return true;
        }
        return false;
    }
    
    private boolean validateOperation(){
        return airDensity!=-1 && dragCoef!=-1000 && velocityAircraft!=-1 && areaAircraft!=-1;
    }
}
