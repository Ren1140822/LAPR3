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
public class EcologicPathResult extends BestPathResult{
    
    public EcologicPathResult(Node startNode) {
        super(startNode);
    }
    
    public double energyConsum(){
        return 0;
    }
    
    @Override
    public double calculateBestPath(){
        return 0;
    }
    
    @Override
    public boolean saveBestResult(){      
        super.setResult(calculateBestPath());
        return Project.getEcologicPathResults().add(this);
    }

    
}
