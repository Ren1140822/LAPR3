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
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.anaylsis.ResultPath;
import lapr.project.model.anaylsis.Simulation;

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
    end airport doesn´t exists
    */
    public boolean createBestPathSimulation(Airport startAirport, Airport endAirport){
        Node startNode=convertAirportToNode(startAirport);
        Node endNode=convertAirportToNode(endAirport);
        if(startNode!=null && endNode!=null){
            project.getSimulationsList().getSimulation().createBestPathSimulation(project.getAirportList(), startNode, endNode);
            return true;
        }
        return false;
    }   
    
    /**
     * Set the data introduced by the user 
     * @param aircraft
     * @param passengers
     * @param crew
     * @param cargoLoad 
     */
    public void setData(Aircraft aircraft, int passengers, int crew, double cargoLoad){
        project.getSimulationsList().getSimulation().setData(aircraft, passengers, crew, cargoLoad);
    }
    
    /**
     * Calculates the ecologic best path
     */
    public void calculateEcologicPath(){
        project.getSimulationsList().getSimulation().getEcologicResultPath().calculateBestPath(project.getAirNetwork());
    }
    
     /**
     * Calculates the fastest best path
     */
     public void calculateFastestPath(){
        project.getSimulationsList().getSimulation().getFastestResultPath().calculateBestPath(project.getAirNetwork());
    }
     
    /**
     * Calculates the shortest best path
     */
      public void calculateShortesPath(){
        project.getSimulationsList().getSimulation().getShortestResultPath().calculateBestPath(project.getAirNetwork());
    }
      
      /**
       * Get the simulation resulte receiving the type of simulation by parameter
       * @param type type of simulation (shortest, fastest, ecologic
       * @return the result of simulation´s type
       */
      public ResultPath getResult(String type){
          switch (type){
              case "SHORTEST_PATH":
                  return project.getSimulationsList().getSimulation().getShortestResultPath();
              case "FASTEST_PATH":
                  return project.getSimulationsList().getSimulation().getFastestResultPath();
              case "ECOLOGIC_PATH":
                  return project.getSimulationsList().getSimulation().getEcologicResultPath();
              default:
                  return null;
          }
      }
      
      /**
       * Gets the travelling time resulted by the simulation
       * @param type type of simulation 
       * @return the travelling time result (min)
       */
      public double getTravellingTime(String type) {
        return getResult(type).getTravellingTime()/60;
      }
      
       /**
       * Gets the distance resulted by the simulation
       * @param type type of simulation
       * @return the distance (km)
       */
      public double getDistance(String type) {
        return getResult(type).getDistance()/1000;
      }
      
      /**
       * Gets the energy consume resulted by the simulation
       * @param type type of simulation
       * @return the energy consume
       */
      public double getEnergyConsume(String type){
          return getResult(type).getTravellingTime();
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