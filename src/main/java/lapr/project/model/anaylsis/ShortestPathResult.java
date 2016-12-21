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
 * The class to store and manage result data of shortest path analysis
 * @author DianaSilva
 */
public class ShortestPathResult extends ResultPath {
    
    public ShortestPathResult(Node startNode){
        super(startNode);
    }
    
     @Override
    public void calculateBestPath(){
        LinkedList<Node> shortPath=super.getResultPath();
        double res=GraphAlgorithms.shortestPath(Project.getAirNetwork().getAirNetwork(), super.getStartNode(), super.getEndNode(), shortPath);
        super.setResult(res);
    }
    
    @Override
    public boolean saveBestResult(){            
        return Project.getShortestPathResults().add(this);
    }
}
