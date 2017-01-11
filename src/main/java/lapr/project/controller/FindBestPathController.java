/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.analysis.ResultPath;
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
    Project project;
    
    /**
     * The possible endNodes for the start airport choosed
     */
    LinkedList<Node> endNodes;
    
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
     * Gets the aircraft list of active project
     * @return list of available aircrafts
     */
    public List<Aircraft> getAircraftsList(){
        return project.getAircraftList().getAircraftList();
    }
    
    /**
     * Gets the airport list of active project
     * @return list of available airports
     */
    public List<Airport> getAirportList(){
        return project.getAirportList().getAirportList();
    }
    
    /**
     * Gets airport correspondent to the selected node if exists
     * @param node selected node
     * @return airport with same latitude and longitude of selected node
     */
    public Airport convertNodeToAirport(Node node){
       return project.getAirportList().getAirportNode(node);
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
    
    /* Creates a best path simullation receiving the selected airports
     * @param startNode origin of flight simulation
     * @param endNode destination of flight simulation
     * @return true if creates new simulation, false if start airport or
    end airport doesnÂ´t exists
    */
    public void createBestPathSimulation(TypePath type){   
       project.getSimulationsList().getSimulation().createPathSimulation(type);
    }   
    
    /**
     * Set the data introduced by the user 
     * @param startAirport
     * @param endAirport
     * @param aircraft
     * @param passengers
     * @param crew
     * @param cargoLoad 
     * @param fuelLoad 
     */
    public void setData(Airport startAirport, Airport endAirport,
            Aircraft aircraft, int passengers, int crew, 
            double cargoLoad, double fuelLoad){
        project.getSimulationsList().getSimulation().setData(passengers, 
                crew, cargoLoad, fuelLoad, startAirport, endAirport, aircraft);
    }
    
    /**
     * Calculates the ecologic best path
     * @param type
     * @return 
     */
    public boolean calculatePath(TypePath type){
        return project.getSimulationsList().getSimulation().calculateBestPath( type, project.getAirNetwork());
    }
      /**
       * Get the simulation resulte receiving the type of simulation by parameter
       * @param type type of simulation (shortest, fastest, ecologic
       * @return the result of simulationÂ´s type
       */
      public ResultPath getResult(TypePath type){
          return project.getSimulationsList().getSimulation().getResult(type);
      }
      
      /**
       * Gets the travelling time resulted by the simulation
       * @param type type of simulation 
       * @return the travelling time result (min)
       */
      public double getTravellingTime(TypePath type) {
        return getResult(type).getTravellingTime();
      }
      
       /**
       * Gets the distance resulted by the simulation
       * @param type type of simulation
       * @return the distance (km)
       */
      public double getDistance(TypePath type) {
        return getResult(type).getDistance();
      }
      
      /**
       * Gets the energy consume resulted by the simulation
       * @param type type of simulation
       * @return the energy consume
       */
      public double getEnergyConsume(TypePath type){
          return getResult(type).getEnergyConsum();
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