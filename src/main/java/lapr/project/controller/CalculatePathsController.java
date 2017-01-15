/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.Pattern;
import lapr.project.model.Project;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;

/**
 *
 * @author Pedro Fernandes and Diana Silva
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
    
      /**
     * Creates a new simulation
     */
    public void newSImulation(){
       project.getSimulationsList().newSimulation();
    }
    
    /* Creates a best path simullation receiving the selected airports
     * @param startNode origin of flight simulation
     * @param endNode destination of flight simulation
     * @return true if creates new simulation, false if start airport or
    end airport doesnÃ‚Â´t exists
    */
    public void createBestPathSimulation(TypePath type){   
        project.getSimulationsList().getSimulation().createPathSimulation(type);      
        
    }  
    
    /**
     * Set the data introduced by the user 
     * @param timeStep 
     * @param aircraftModel 
     * @param startAirport 
     * @param endAirport 
     */
    public void setData(int timeStep, AircraftModel aircraftModel, Airport startAirport, Airport endAirport)
    {
        
        Aircraft aircraft=new Aircraft();
        aircraft.setAircraftModel(aircraftModel);
        
        
        FlightPlan flightPlan=new FlightPlan("sm"+project.getSimulationsList().getSimulation().getCounterCode(), 0, aircraft, startAirport, endAirport, new LinkedList<>(), new LinkedList<>(),new LinkedList<>());
        project.getSimulationsList().getSimulation().setFlightPlan(flightPlan);
        project.getSimulationsList().getSimulation().setData(startAirport, endAirport, timeStep);
        project.getSimulationsList().getSimulation().setTotalWeight(4*Math.pow(10, 5));
    }
    
    /**
     * Calculates the ecologic best path
     * @param type
     * @return true if valid, false if not
     */
    public boolean calculatePath(TypePath type){
        return project.getSimulationsList().getSimulation().calculateBestPathCruise(type, project.getAirNetwork());
    }
    
    public boolean validateData(){
        return  project.getSimulationsList().getSimulation().validate();
    }
    
     /**
     * Saves the simulation for export results purposes
     * @return true if saves the simulation, false if not
     */
    public boolean saveSimulation(){
        return project.getSimulationsList().saveSimulation();
    }
    
    public Simulation getSimulation(){
        return project.getSimulationsList().getSimulation();
    }
}
