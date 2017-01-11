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
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;

import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 *
 * @author DianaSilva
 */
public class EcologicPathResult extends ResultPath implements BestPathInterface{
    /**
     * Constructor
     */
    public EcologicPathResult(){
        super();
    }
    
    @Override
    public void calculateBestPath(AirNetwork airNetwork, Node start, Node end) {
        LinkedList<Node> ecologicPath=(LinkedList<Node>)super.getResultPath();
        /**corrigir**/
        double res=GraphAlgorithms.shortestPath(airNetwork.getAirNetwork(), 
                start, end, ecologicPath);
        super.setResult(res);
        super.setResultPath(ecologicPath);
    }
}
