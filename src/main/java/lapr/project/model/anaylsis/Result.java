/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import lapr.project.model.Node;
import lapr.project.model.lists.NodeList;

/**
 * The class to stores and manage analysis results
 * @author Diana Silva
 */
public class Result {
    Node startNode;
    Node endNode;
    double resultPath;
    
    
    public Result(Node startNode){
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
}
