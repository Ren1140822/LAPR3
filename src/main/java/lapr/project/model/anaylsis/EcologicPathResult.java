/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import lapr.project.model.Aircraft;
import lapr.project.model.Node;
import lapr.project.model.Project;

import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 *
 * @author DianaSilva
 */
public class EcologicPathResult extends ResultPath{
    /**
     * Total weight of aircraft+passengers+crew
     */
    private double total_weight;
    
    /**
     * Default weight of aircraft+passengers+crew
     */
    private static final double DEFAULT_WEIGHT=0;
    
    /**
     * Aircraft of result path
     */
    private Aircraft aircraft;
    
    public EcologicPathResult(){
        super();
    }
    
    public EcologicPathResult(Node startNode, Node endNode, double totalWeight, Aircraft aircraft){
        super(startNode, endNode);
        this.total_weight=totalWeight;
        this.aircraft=aircraft;
    }
    
    public double energyConsum(){
        return 0;
    }
    
     @Override
    public void calculateBestPath(){
        LinkedList<Node> ecologicPath=super.getResultPath();
        /**corrigir**/
        double res=GraphAlgorithms.shortestPath(Project.getAirNetwork().getAirNetwork(), super.getStartNode(), super.getEndNode(), ecologicPath);
        super.setResult(res);
    }    
}
