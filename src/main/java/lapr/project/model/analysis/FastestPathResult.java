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
import lapr.project.model.Segment;
import lapr.project.model.mapgraph.GraphAlgorithms;


/**
 *
 * @author DianaSilva
 */
public class FastestPathResult extends ResultPath implements BestPathInterface{
    
    /**
     * Constructor
     */
    public FastestPathResult() {
        super();
    }
    
    /**
     * Calculates the fastest path
     * @param airNetwork airnetwork of active project
     * @param start
     * @param end
     */
    @Override
    public void calculateBestPath(AirNetwork airNetwork, Node start, Node end){
        LinkedList<Node> fastestPath=(LinkedList<Node>)super.getResultPath();
        AirNetwork clone=airNetwork;
                
        for(Segment seg:clone.getSegmentList()){
            start=clone.getNodeFromList(seg.getStartNode());
            end=clone.getNodeFromList(seg.getEndNode());
    
        }
         double res=GraphAlgorithms.shortestPath(clone.getAirNetwork(), 
                start,end, fastestPath);
        //vento+cruiseSpeed
        super.setResultPath(fastestPath);
        super.setResult(res);
    }
}
