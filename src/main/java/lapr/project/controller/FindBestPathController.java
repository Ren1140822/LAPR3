/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import lapr.project.model.Aircraft;
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
    
    public Node[] getVertices(){
        return project.getAirNetwork().getAirNetwork().allkeyVerts();
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
  
    public boolean saveSimulation(){
        return project.getSimulationsList().saveSimulation();
    }
}