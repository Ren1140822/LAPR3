/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import lapr.project.model.Node;

/**
 * The class to stores and manage analysis results of simulation
 * @author Diana Silva
 */
public class ResultPath {
    /**
     * Start airport
     */
    private Node startNode;
    /**
     * End airport
     */
    private Node endNode;
    /**
     * Value of result path
     */
    double result;  
    
    /**
     * Path result
     */
    LinkedList<Node> resultPath=new LinkedList<>();
    
    /**
     * Constructor
     */
    public ResultPath(){
        this.startNode=new Node();
        this.endNode=new Node();
    }
    
    
    /**
     * Constructor
     * @param startNode start airport
     */
    public ResultPath(Node startNode){
        this.startNode=startNode;
    }
    
    /**
     * COnstructor
     * @param startNode start airport
     * @param endNode destination airport
     */
     public ResultPath(Node startNode, Node endNode){
        this.startNode=startNode;
        this.endNode=endNode;
    } 
     
     
     
      
    /**
     * Sets the analysis final result
     * @param result analysis result  
     */
    public void setResult(double result){
        this.result=result;
    }
    
    /**
     * Sets the analysis final result
     * @param resultPath result path  
     */
    public void setResultPath(LinkedList<Node> resultPath){
        this.resultPath=resultPath;
    }

    public double getResult() {
        return result;
    }
    
    public LinkedList<Node> getResultPath(){
        return resultPath;
    }
    
    public void calculateBestPath(){
    } 

    boolean validate() {
        return result!=0 && resultPath.isEmpty();
    }

    /**
     * Gets the origin of flight
     * @return the startNode
     */
    public Node getStartNode() {
        return startNode;
    }

    /**
     * Sets the origin of flight
     * @param startNode the startNode to set
     */
    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    /**
     * Gets the destination of flight
     * @return the endNode
     */
    public Node getEndNode() {
        return endNode;
    }

    /**
     * Sets the destination of flight
     * @param endNode the endNode to set
     */
    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }
    
    
}
