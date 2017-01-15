/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import java.util.Map;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.analysis.Path;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;

/**
 *
 * @author Diana Silva
 */
public class FindBestPathController {
    /**
     * The project active
     */
    private Project project;
    
    private FlightPlan flightPlan;
    
    /**
     * Constructor
     * @param project active project 
     */    
    public FindBestPathController(Project project){
        this.project = project;
    }
    
    /**
     * Creates a new simulation
     */
    public void newSImulation(){
       project.getSimulationsList().newSimulation();
    }
    
    /**
     * Gets the airport origin
     * @return airport origin
     */
    public String getFlightPlanStringInfo(){
        return flightPlan.getFlightPlanStringInfo();
    }
    
    public List<Airport> getTechnicalStops(){
        return flightPlan.getTechnicalStops();
    }
    
    public List<Node> getMandatoryWaypoints(){
        return flightPlan.getMandatoryWaypoints();
    }
          
    /**
     * Gets the possible end airports linked to the origin node
     * @param startNode origin node of airnetwork
     * @return list airports linked to the start node
     */
    public List<Airport> getPossibleEndAirports(Node startNode){
        return project.getPossibleEndAirports(startNode);
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
     * @param passengers
     * @param crew
     * @param cargoLoad 
     * @param fuelLoad 
     * @param timeStep 
     */
    public void setData(int passengers, int crew, double cargoLoad, double fuelLoad,int timeStep){
        project.getSimulationsList().getSimulation().setData(passengers, 
                crew, cargoLoad, fuelLoad, flightPlan, timeStep);
    }
    
    /**
     * Calculates the ecologic best path
     * @param type
     * @return true if valid, false if not
     */
    public boolean calculatePath(TypePath type){
        return project.getSimulationsList().getSimulation().calculateBestPath( type, project.getAirNetwork());
    }
    
      /**
       * Gets the simulation resulte receiving the type of simulation by parameter
       * @param type type of simulation (shortest, fastest, ecologic
       * @return the result of simulation type
       */
      public Path getResult(TypePath type){
          return project.getSimulationsList().getSimulation().getResult(type);
      }
    
    public Simulation getSimulation(){
        return project.getSimulationsList().getSimulation();
    }
    
    public List<FlightPlan> getFlightPlanList(){
        return project.getFlightList().getFlightList();
    }
    
    public void getFlightPlanSelected(FlightPlan flightPlan){
        this.flightPlan = flightPlan;
    }
    
    public Map<String,Integer> getCabinConfig(){
        return this.flightPlan.getAircraft().getCabinConfig().getMapOfClasses();
    }
    
    public FlightPlan getFlightPlan(){
        return flightPlan;
    }
    
    public boolean validateData(){
        return   project.getSimulationsList().getSimulation().validateAircraftRelatedData();
    }
    
     /**
     * Saves the simulation for export results purposes
     * @return true if saves the simulation, false if not
     */
    public boolean saveSimulation(){
        return project.getSimulationsList().saveSimulation();
    }
}