/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import lapr.project.model.anaylsis.BestPathResult;
import lapr.project.model.anaylsis.EcologicPathResult;
import lapr.project.model.anaylsis.FastestPathResult;

/**
 * 
 * @author Diana Silva
 */
public class PhysicsAlgorithms {
    public static double calculateBestPathResult(BestPathResult result){
        if(result instanceof EcologicPathResult){
            calculateEcologicResult(result);
        }
        if(result instanceof FastestPathResult){
            calculateFastestResult(result);
        }
        return 0;
    }
    
    private static double calculateEcologicResult(BestPathResult result){
        return 0;
    }
    
    private static double calculateFastestResult(BestPathResult result){
        return 0;
    }
}
