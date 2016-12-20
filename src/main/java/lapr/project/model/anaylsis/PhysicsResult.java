/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import lapr.project.model.AircraftModel;
import lapr.project.model.physics.DragForce;
import lapr.project.model.physics.LiftForce;
import lapr.project.model.physics.PhysicsAlgorithms;

/**
 *
 * @author DianaSilva
 */
public class PhysicsResult {
        
    /**
     *  lift force acting on the aircraft (N)
     */
    private LiftForce liftForce;
    
    /**
     * drag force acting on the aircraft (N)
     */
    private DragForce dragForce;
    
    /**
     * thrust specific fuel consumption (fuel efficienty)
     */
    private double tsfc;
    
    /**
     * the range of an aircraft in cruise flight
     */
    private double rangeFlight;
    
    public PhysicsResult(){
        liftForce=new LiftForce();
        dragForce=new DragForce();
        tsfc=0;
        rangeFlight=0;
    }
     
    /**
     * Gets the lift force
     * @return lift force
     */
    public LiftForce getLiftForce(){
        return liftForce;
    }
    
    /**
     * Gets the drag force
     * @return drag force
     */
    public DragForce getDragForce(){
        return dragForce;
    }
    
    public void setTSFC(double tsfc){
        this.setTsfc(tsfc);
    }
    
    public void setRange(AircraftModel aircraftModel){
        setRangeFlight(PhysicsAlgorithms.calculateRangeAircraft(aircraftModel));
    }

    /**
     * @param liftForce the liftForce to set
     */
    public void setLiftForce(LiftForce liftForce) {
        this.liftForce = liftForce;
    }

    /**
     * @param dragForce the dragForce to set
     */
    public void setDragForce(DragForce dragForce) {
        this.dragForce = dragForce;
    }

    /**
     * @return the tsfc
     */
    public double getTsfc() {
        return tsfc;
    }

    /**
     * @param tsfc the tsfc to set
     */
    public void setTsfc(double tsfc) {
        this.tsfc = tsfc;
    }

    /**
     * @return the rangeFlight
     */
    public double getRangeFlight() {
        return rangeFlight;
    }

    /**
     * @param rangeFlight the rangeFlight to set
     */
    public void setRangeFlight(double rangeFlight) {
        this.rangeFlight = rangeFlight;
    }
    
}

