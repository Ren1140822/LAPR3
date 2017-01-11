/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 * The class to store and manage result data of shortest path analysis
 * @author DianaSilva
 */
public class ShortestPathResult extends ResultPath implements BestPathInterface {
    private FlightPlan flightPlan;
    
    /**
     * Constructor
     * @param flightPlan
     */
    public ShortestPathResult(FlightPlan flightPlan){
        super();
        this.flightPlan=flightPlan;
    }
  
     /**
     * Calculates the shortest path
     * @param airNetwork airnetwork of active project
     * @param flightPlan
     */
    @Override
    public void calculateBestPath(AirNetwork airNetwork){
        LinkedList<Node> shortPath=new LinkedList<>();
        Node start=airNetwork.getAirportNode(flightPlan.getOrigin());
        Node end=airNetwork.getAirportNode(flightPlan.getDestination());
        
        double res=GraphAlgorithms.shortestPath(airNetwork.getAirNetwork(), 
                start, end, shortPath);
     
        super.setResult(res);
        super.setResultPath(shortPath);
    }
}
