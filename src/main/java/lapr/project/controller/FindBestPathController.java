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
    
    public void newSImulation(Node startNode){
       Project.getSimulationsListReference().newSimulation();
    }
    
    public Node[] getVertices(){
        return Project.getAirNetwork().getAirNetwork().allkeyVerts();
    }
      
    public void setStartNode(Node startNode){
       Project.getSimulationsListReference().getSimulation().setStartNode(startNode);
    }
    
    public LinkedList<Node> getPossibleEndNodes(Node startNode){
        return Project.getAirNetwork().getPossibleEndNodes(startNode);
    }
    
    public void setEndNode(Node endNode){
        Project.getSimulationsListReference().getSimulation().setEndNode(endNode);
    }
    
    public void setData(Aircraft aircraft, int passengers, int crew, double cargoLoad){
        Project.getSimulationsListReference().getSimulation().setData(aircraft, passengers, crew, cargoLoad);
    }
  
    private boolean saveSimulation(){
        return Project.getSimulationsListReference().saveSimulation();
    }
}