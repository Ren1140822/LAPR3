/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import lapr.project.model.Node;

/**
 * The class to stores and manage analysis results of simulation
 * @author Diana Silva
 */
public class ResultPath {
    Node startNode;
    Node endNode;
    double resultPath;
    
    
    public ResultPath(Node startNode){
        this.startNode=startNode;
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
     * Sets the analysis final result
     * @param result analysis result  
     */
    public void setResult(double result){
        resultPath=result;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public double getResultPath() {
        return resultPath;
    }
    
       public double calculateBestPath(){
        return 0;
    } 
 
    public boolean saveBestResult(){      
        return true;
    }
    
    
}
