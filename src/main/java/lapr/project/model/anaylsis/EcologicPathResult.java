/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.Node;

import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 *
 * @author DianaSilva
 */
public class EcologicPathResult extends ResultPath{
    
    public EcologicPathResult(Node startNode, Node endNode){
        super(startNode, endNode);
    }
 
    @Override
    public void calculateBestPath(AirNetwork airNetwork){
        LinkedList<Node> ecologicPath=super.getResultPath();
        /**corrigir**/
        double res=GraphAlgorithms.shortestPath(airNetwork.getAirNetwork(), 
                super.getStartNode(), super.getEndNode(), ecologicPath);
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
}
