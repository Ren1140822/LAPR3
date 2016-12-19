/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Aircraft;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.anaylsis.Result;

/**
 *
 * @author Diana Silva
 */
public class FindBestPathController {
    Result result;
    
    public void newEcologicResult(Node startNode, Aircraft aircraft){
       result=Project.getListResults().newEcologicResult(startNode, aircraft);
    }
    
    public void newFastestResult(Node startNode, Aircraft aircraft){
      result=Project.getListResults().newFastestResult(startNode, aircraft);
    }
    
    public void newShortestResult(Node startNode){
        result=Project.getListResults().newShortestResult(startNode);
    }
    
    public Node[] getVertices(){
        return Project.getAirNetwork().getAirNetwork().allkeyVerts();
    }
    
//    public List<Node> getPossibleEndNodes(Node startNode){
//        return Project.getAirNetwork().getPossibleEndNodes(startNode);
//    }
    
    public void setEndNode(Node endNode){
        result.setEndNode(endNode);
    }
 
    public double calculateResult(){
        return result.calculateBestPath();
    }
    
    public boolean saveResult(){
        return result.saveBestResult();
    }
}
