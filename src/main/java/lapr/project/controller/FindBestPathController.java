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

/**
 *
 * @author Diana Silva
 */
public class FindBestPathController {
    
    Project project;
    
    public FindBestPathController(Project project){
        this.project = project;
    }
    
    public void newSImulation(Node startNode){
       project.getSimulationsList().newSimulation();
    }
    
    public List<Aircraft> getAircraftsList(){
        return project.getAircraftList().getAircraftList();
    }
    
    public List<Airport> getAirportsList(){
        return project.getAirportList().getAirportList();
    }
      
    public void setStartNode(Node startNode){
       project.getSimulationsList().getSimulation().setStartNode(startNode);
    }
    
    public LinkedList<Node> getPossibleEndNodes(Node startNode){
        return project.getAirNetwork().getPossibleEndNodes(startNode);
    }
    
    public void setEndNode(Node endNode){
        project.getSimulationsList().getSimulation().setEndNode(endNode);
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
  
    public boolean saveSimulation(){
        return project.getSimulationsList().saveSimulation();
    }
}