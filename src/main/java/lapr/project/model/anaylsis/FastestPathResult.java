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
import lapr.project.model.physics.PhysicsAlgorithms;


/**
 *
 * @author DianaSilva
 */
public class FastestPathResult extends ResultPath{
    
    public FastestPathResult(Node startNode) {
        super(startNode);
    }
    
    @Override
    public void calculateBestPath(){
        LinkedList<Node> fastestPath=super.getResultPath();
        /**corrigir**/
        double res=GraphAlgorithms.shortestPath(Project.getAirNetwork().getAirNetwork(), super.getStartNode(), super.getEndNode(), fastestPath);
        super.setResult(res);
    }
     
     
     
    @Override
    public boolean saveBestResult(){      
        return Project.getFastestPathResults().add(this);
    }

}
