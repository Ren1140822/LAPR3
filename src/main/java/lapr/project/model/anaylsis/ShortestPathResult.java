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
import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 * The class to store and manage result data of shortest path analysis
 * @author DianaSilva
 */
public class ShortestPathResult extends ResultPath {
    /**
     * Constructor
     */
    public ShortestPathResult(){
        super();
    }
    
    /**
     * Constructor
     * @param startAirport
     * @param endAirport 
     */
    public ShortestPathResult(Airport startAirport, Airport endAirport){
        super(startAirport, endAirport);
    }
    
     /**
     * Calculates the shortest path
     * @param airNetwork airnetwork of active project
     */
    @Override
    public void calculateBestPath(AirNetwork airNetwork){
        LinkedList<Node> shortPath=(LinkedList<Node>)super.getResultPath();
        double res=GraphAlgorithms.shortestPath(airNetwork.getAirNetwork(), 
                super.getStartNode(airNetwork), super.getEndNode(airNetwork), shortPath);
        super.setResult(res);
        super.setResultPath(shortPath);
    }
    
    /**
     * Get distance of result path (m)
     * @return distance (m)
     */
    @Override
    public double getDistance(){
        return super.getResult();
    }
}
