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

/**
 *
 * @author Diana Silva
 */
public class FindBestPathController {
    
    Project project;
    LinkedList<Node> endNodes;
    
    public FindBestPathController(Project project){
        this.project = project;
    }
    
    public void newSImulation(){
       project.getSimulationsList().newSimulation();
    }
    
    public List<Aircraft> getAircraftsList(){
        return project.getAircraftList().getAircraftList();
    }
    
    public List<Airport> getAirportList(){
        return project.getAirportList().getAirportList();
    }
    
    public Airport convertNodeToAirport(Node node){
       return project.getAirportList().getAirportNode(node);
    }
    
    public Node convertAirportToNode(Airport airport){
         return project.getAirNetwork().getAirportNode(airport);
    }
          
    public LinkedList<Airport> getPossibleEndAirports(Node startNode){
        return project.getPossibleEndAirports(startNode);
    }
    
    public void createBestPathSimulation(Airport startAirport, Airport endAirport){
        Node startNode=convertAirportToNode(startAirport);
        Node endNode=convertAirportToNode(endAirport);
            project.getSimulationsList().getSimulation().createBestPathSimulation(project.getAirportList(), startNode, endNode);
    }   
    
    public void setData(Aircraft aircraft, int passengers, int crew, double cargoLoad){
        project.getSimulationsList().getSimulation().setData(aircraft, passengers, crew, cargoLoad);
    }
    
    public void calculateEcologicPath(){
        project.getSimulationsList().getSimulation().getEcologicResultPath().calculateBestPath(project.getAirNetwork());
    }
    
     public void calculateFastestPath(){
        project.getSimulationsList().getSimulation().getFastestResultPath().calculateBestPath(project.getAirNetwork());
    }
      public void calculateShortesPath(){
        project.getSimulationsList().getSimulation().getShortestResultPath().calculateBestPath(project.getAirNetwork());
    }
      
      public ResultPath getResult(String type){
          switch (type){
              case "SHORTEST_PATH":
                  return project.getSimulationsList().getSimulation().getShortestResultPath();
              case "FASTEST_PATH":
                  return project.getSimulationsList().getSimulation().getFastestResultPath();
              case "ECOLOGIC_PATH":
                  return project.getSimulationsList().getSimulation().getEcologicResultPath();
          }
          return null;
      }
      
      public double getTravellingTime(String type) {
        //project.getSimulationsList().getSimulation().calculateTravellingTime(resultPath)
        return getResult(type).getTravellingTime();
      }
  
    public boolean saveSimulation(){
        return project.getSimulationsList().saveSimulation();
    }
}