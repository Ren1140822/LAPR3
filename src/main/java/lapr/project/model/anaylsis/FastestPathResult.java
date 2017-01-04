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
import lapr.project.model.Segment;
import lapr.project.model.mapgraph.GraphAlgorithms;
import lapr.project.model.physics.AircraftAlgorithms;


/**
 *
 * @author DianaSilva
 */
public class FastestPathResult extends ResultPath{
    
    /**
     * Constructor
     */
    public FastestPathResult() {
        super();
    }
    
    /**
     * Constructor
     * @param startAirport
     * @param endAirport
     */
    public FastestPathResult(Airport startAirport, Airport endAirport) {
        super(startAirport,endAirport);
    }
    
    /**
     * Calculates the fastest path
     * @param airNetwork airnetwork of active project
     */
    @Override
    public void calculateBestPath(AirNetwork airNetwork){
        LinkedList<Node> fastestPath=(LinkedList<Node>)super.getResultPath();
        AirNetwork clone=airNetwork;
                
        for(Segment seg:clone.getSegmentList()){
            Node start=clone.getNodeByString(seg.getStartNode());
            Node end=clone.getNodeByString(seg.getEndNode());
     
        }
         double res=GraphAlgorithms.shortestPath(clone.getAirNetwork(), 
                super.getStartNode(airNetwork), super.getEndNode(airNetwork), fastestPath);
        //vento+cruiseSpeed
        super.setResultPath(fastestPath);
        super.setResult(res);
    }
    
       /**
     * Get distance of result path (m)
     * @return distance (m)
     */
    @Override
    public double getDistance(){
        //alterar
        return super.getResult();
    }
    
      
    /**
     * Sets the distance result
     * @param res
     */
    @Override
    public  void setDistance(double res){
        super.setResult(res);
    }
}
