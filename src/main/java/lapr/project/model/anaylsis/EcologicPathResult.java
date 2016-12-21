/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import lapr.project.model.Node;

import lapr.project.model.Projects.Project;
import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 *
 * @author DianaSilva
 */
public class EcologicPathResult extends ResultPath{
    /**
     * Total weight of aircraft
     */
    private double weight; 
    
    private static final double DEFAULT_WEIGHT=0;
    
    public EcologicPathResult(Node startNode) {
        super(startNode);
        this.weight=DEFAULT_WEIGHT;
    }
    
    public EcologicPathResult(Node startNode, Node endNode, double totalWeight){
        super(startNode, endNode);
        this.weight=totalWeight;       
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
    
    @Override
    public boolean saveBestResult(){      
        
        return Project.getEcologicPathResults().add(this);
    }

    
}
