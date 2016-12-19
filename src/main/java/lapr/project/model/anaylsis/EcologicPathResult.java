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
import lapr.project.model.physics.PhysicsAlgorithms;

/**
 *
 * @author DianaSilva
 */
public class EcologicPathResult extends BestPathResult{
    
    private double ecologicPath;
    //repensar
    private PhysicsAnalysis physicsAnalysis;
    
    public EcologicPathResult(Node startNode, Aircraft aircraft) {
        super(startNode, aircraft);
        physicsAnalysis=new PhysicsAnalysis();
        ecologicPath=0;
    }
    
    public double getEcologicPath(){
        return ecologicPath;
    }
     
    @Override
    public double calculateBestPath(){
        energyConsum(); //verifica o consumo de todos os caminhos 
        LinkedList<Node> shortPath=new LinkedList<>();
        GraphAlgorithms.shortestPath(Project.getAirNetwork().getAirNetwork(),super.getStartNode(), super.getEndNode(), shortPath);
        //corrigir
        ecologicPath=0;
        return 0;
    }
    
    private double energyConsum(){
        return PhysicsAlgorithms.calculateRangeAircraft();
    }
    
    @Override
    public boolean saveBestResult(){            
        return Project.getEcologicPathResults().add(this);
    }

    
}
