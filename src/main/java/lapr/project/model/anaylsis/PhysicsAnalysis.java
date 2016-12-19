/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import lapr.project.model.physics.DragForce;
import lapr.project.model.physics.LiftForce;
import lapr.project.model.physics.PhysicsAlgorithms;

/**
 *
 * @author DianaSilva
 */
public class PhysicsAnalysis{
        
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
    
    public PhysicsAnalysis(){
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
        this.tsfc=PhysicsAlgorithms.calculateTSFC();
    }
    
    public void setRange(){
        rangeFlight=PhysicsAlgorithms.calculateRangeAircraft();
    }
    
}

