/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import lapr.project.model.Node;
import lapr.project.model.Project;

/**
 *
 * @author DianaSilva
 */
public class FastestPathResult extends BestPathResult{
    
    public FastestPathResult(Node startNode) {
        super(startNode);
    }
    
    @Override
    public double calculateBestPath(){
        return 0;
    }
    
    @Override
    public boolean saveBestResult(){      
        super.setResult(calculateBestPath());
        return Project.getFastestPathResults().add(this);
    }

}
