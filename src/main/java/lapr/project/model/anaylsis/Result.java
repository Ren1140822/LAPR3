/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import lapr.project.model.Aircraft;
import lapr.project.model.Node;

/**
 * The class to stores and manage analysis results
 * @author Diana Silva
 */
public class Result {
    private Node startNode;
    private Node endNode;
    Aircraft aircraft;
    
    public Result(){      
    }
    
    public Result(Aircraft aircraft){
        this.aircraft=aircraft;
    }
    
    public Result(Node startNode, Aircraft aircraft){
        this.startNode=startNode;
        this.aircraft=aircraft;
    }
    
    
    public Result(Node startNode){
        this.startNode=startNode;
    }
    
     /**
     * Gets the aircraft of flight
     * @return the aircraft
     */
    public Aircraft getAircraft() {
        return aircraft;
    }
    
     /**
     * Gets the origin of flight
     * @return the startNode
     */
    public Node getStartNode() {
        return startNode;
    }

    /**
     * Gests the destination of flight
     * @return the endNode
     */
    public Node getEndNode() {
        return endNode;
    }
    
    /**
     * Set the start airport
     * @param startNode origin of flight
     */
    public void setStartNode(Node startNode){
        this.startNode=startNode;
    }
    
    /**
     * Set the destination of flight
     * @param endNode destination of flight
     */
    public void setEndNode(Node endNode){
        this.endNode=endNode;
    }
    
    /**
     * Sets the aircraft of flight
     * @param aircraft 
     */
    public void setAircraft(Aircraft aircraft){
        this.aircraft=aircraft;
    }  
    
     
    public double calculateBestPath(){
        return 0;
    } 
 
    public boolean saveBestResult(){      
        return true;
    }
}
