/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Airport;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.analysis.Path;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.analysis.TypePath;

/**
 *
 * @author Diana Silva
 */
public class FlightPlanAnalysisController {
    /**
     * The project active
     */
    Project project;
    
    /**
     * Constructor
     * @param project active project 
     */    
    public FlightPlanAnalysisController(Project project){
        this.project = project;
    }
    
    /**
     * Creates a new simulation
     */
    public void newSImulation(){
       project.getSimulationsList().newSimulation();
    }
    
    /**
     * Gets airport correspondent to the selected node if exists
     * @param node selected node
     * @return airport with same latitude and longitude of selected node
     */
    public Airport convertNodeToAirport(Node node){
       return project.getAirportList().getAirportNode(node);
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
     * Gets node correspondent to the selected airport if exists
     * @param airport selected airport
     * @return node with same latitude and longitude of selected airport
     */
    public Node convertAirportToNode(Airport airport){
         return project.getAirNetwork().getAirportNode(airport);
    }
          
    /**
     * Gets the possible end airports linked to the origin node
     * @param startNode origin node of airnetwork
     * @return list airports linked to the start node
     */
    public List<Airport> getPossibleEndAirports(Node startNode){
        return project.getPossibleEndAirports(startNode);
    }
    
      /**
     * Set the data introduced by the user 
     * @param start
     * @param end 
     * @param timeStep 
     */
    public void setData(Airport start, Airport end,int timeStep){
        project.getSimulationsList().getSimulation().setData(start, end, timeStep);
    }
    
      /**
       * Get the simulation resulte receiving the type of simulation by parameter
       * @param type type of simulation (shortest, fastest, ecologic
       * @return the result of simulationÂ´s type
       */
      public Path getResult(TypePath type){
          return project.getSimulationsList().getSimulation().getResult(type);
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