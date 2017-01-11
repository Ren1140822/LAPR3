/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.Node;
import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 * The class to store and manage result data of shortest path analysis
 * @author DianaSilva
 */
public class ShortestPathResult extends ResultPath implements BestPathInterface {
    /**
     * Constructor
     */
    public ShortestPathResult(){
        super();
    }
  
     /**
     * Calculates the shortest path
     * @param airNetwork airnetwork of active project
     * @param start
     * @param end
     */
    @Override
    public void calculateBestPath(AirNetwork airNetwork, Node start, Node end){
        LinkedList<Node> shortPath=new LinkedList<>();
        double res=GraphAlgorithms.shortestPath(airNetwork.getAirNetwork(), 
                start, end, shortPath);
     
        super.setResult(res);
        super.setResultPath(shortPath);
    }
}
