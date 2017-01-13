/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.Node;
import lapr.project.model.Project;

/**
 *
 * @author Pedro Fernandes
 */
public class CalculatePathsController {
    
    private Project project;
    
    public CalculatePathsController(Project project){
        this.project = project; 
    }
    
    public List<AircraftModel> getAircraftsModelList(){
        return project.getAircraftModelList().getModelList();
    }
    
    /**
     * Gets the airport list of active project
     * @return list of available airports
     */
    public List<Airport> getAirportList(){
        return project.getAirportList().getAirportList();
    }
    
    public List<Airport> getPossibleEndAirportsByAirportID(String startAir){
        Airport a = project.getAirportList().getAirportByString(startAir); 
        Node n = project.getAirNetwork().getAirportNode(a);
        if(a!=null && n!=null){
            return project.getPossibleEndAirports(n);
        }
        return new LinkedList<>();
    }
    
}
