/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.Airport;
import lapr.project.model.Node;

import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 *
 * @author DianaSilva
 */
public class EcologicPathResult extends ResultPath{
    /**
     * Constructor
     */
    public EcologicPathResult(){
        super();
    }
    
    public EcologicPathResult(Airport startAirport, Airport endAirport){
        super(startAirport,endAirport);
    }
    
    /**
     * Calculates the ecologic best path
     * @param airNetwork airnetwork of active project
     */
    @Override
    public void calculateBestPath(AirNetwork airNetwork){
        LinkedList<Node> ecologicPath=(LinkedList<Node>)super.getResultPath();
        /**corrigir**/
        double res=GraphAlgorithms.shortestPath(airNetwork.getAirNetwork(), 
                super.getStartNode(airNetwork), super.getEndNode(airNetwork), ecologicPath);
        super.setResult(res);
        super.setResultPath(ecologicPath);
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
