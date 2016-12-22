/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.anaylsis.ResultPath;

/**
 *
 * @author Diana Silva
 */
public class CompareResultsList {
    
    private LinkedList<ResultPath> compareResults;
    
    public CompareResultsList(){
         this.compareResults = new LinkedList<>();
    }
    
    public List<ResultPath> getCompareResults(){
        return  this.compareResults;
    }
}
