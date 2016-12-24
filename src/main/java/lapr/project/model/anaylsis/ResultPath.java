/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.Airport;
import lapr.project.model.Node;
import lapr.project.model.lists.AirportList;

/**
 * The class to stores and manage analysis results of simulation
 * @author Diana Silva
 */
public class ResultPath extends Simulation{
    /**
     * Value of result path
     */
    private double result; 
    
    /**
     * Path result
     */
    LinkedList<Node> resultPath=new LinkedList<>();
    
    /**
     * Energy consum of result path
     */
    private double energyConsum;
    
    /**
     * Travelling time of result path (s)
     */
    private double travellingTime;
    
    /**
     * Distance of result path (m)
     */
    private double distance;
    
    /**
     * Origin and Destination of result path
     */
    private Node startNode,  endNode;
   
    /**
     * Constructor
     */
    public ResultPath(){
        this.startNode=new Node();
        this.endNode=new Node();
    }  
    
    /**
     * Constructor
     * @param startNode
     * @param endNode
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
    
    public void calculateBestPath(AirNetwork airNetwork){
    } 
   
    @Override
    public boolean validate() {
        return Double.doubleToLongBits(result)!=0 && resultPath.isEmpty();
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
    
    /**
     * @return the energyConsum
     */
    public double getEnergyConsum() {
        return energyConsum;
    }

    /**
     * @param energyConsum the energyConsum to set
     */
    public void setEnergyConsum(double energyConsum) {
        this.energyConsum = energyConsum;
    }

    /**
     * @return the travellingTime
     */
    public double getTravellingTime() {
        return travellingTime;
    }
    
      /**
     * Sets distance of result path (m)
     * @param travellingTime
     */
    public void setTravellingTime(double travellingTime){
        this.travellingTime=travellingTime;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
    
    /**
     * Gets the start airport equivalent to the start node
     * @param list list of airports in the project
     * @return airport equivalent
     */
    public Airport getStartAirport(AirportList list){
        return list.getAirportNode(startNode);
    }
    
    /**
     * Gets the end airport equivalent to the end node
     * @param list list of airports in the project
     * @return airport equivalent
     */
    public Airport getEndAirport(AirportList list){
        return list.getAirportNode(endNode);
    }
}
