/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Project;
import lapr.project.model.analysis.Simulation;

/**
 *
 * @author DianaSilva
 */
public class ComparisonController {
    Project project;
    String criteria;
    
    public ComparisonController(Project project){
        this.project=project;
    }
    
    public String[] getComparisonOptions(){
        return project.getCompareList().getOptions();
    }
    
    public void createComparison(){
        project.getCompareList().createComparison();
    }
    
    public List<String> getAircraftsSimulated(){
        return project.getTypesAircraftSimulated();
    }
    
    public void setAircraft(String criteria){
        project.getCompareList().getCompareResult().setAircraftModel(criteria);
        project.getCompareList().getCompareResult().setSimulationsCompared((LinkedList<Simulation>) project.getSimulationsAircraft(criteria));
   }
    
     public void setEngine(String criteria){
        project.getCompareList().getCompareResult().setMotorization(criteria);
        project.getCompareList().getCompareResult().setSimulationsCompared((LinkedList<Simulation>) project.getSimulationsAircraft(criteria));
    }
    
    public List<Simulation> getListSimulations(){
        return project.getCompareList().getCompareResult().getSimulationsCompared();
    }
    
     public String[] getResults(Simulation s){
        return project.getCompareList().getCompareResult().toStringCompare(s);
    }
    
    public void calculateAverage(){
         project.getCompareList().getCompareResult().calculateTotalAverage();
    }
    
    public String[] getAverages(){
        return project.getCompareList().getCompareResult().toStringCompareAvg();
    }
    
    public String[] getDifAvg(){
        return project.getCompareList().getCompareResult().toStringDif();
    }
    
    public boolean saveComparison(){
        return true;
    }

}
