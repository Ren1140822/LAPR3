/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import lapr.project.model.Aircraft;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.physics.PhysicsAlgorithms;

/**
 *
 * @author DianaSilva
 */
public class FastestPathResult extends BestPathResult{
    
    public FastestPathResult(Node startNode, Aircraft aircraft) {
        super(startNode, aircraft);
    }
 
    /**
     * Calculates the time flight
     * @return time flight
     */
    private double timeFlight(){
        return 0;
    }
    
    @Override
     public double calculateBestPath(){
       //falta fazer
       timeFlight();
       PhysicsAlgorithms.calculateVelocityAircraft(0, 0);
       return 0;
    } 

    @Override
    public boolean saveBestResult(){      
        return Project.getFastestPathResults().add(this);
    }
}