/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Node;

import lapr.project.model.Projects.Project;
import lapr.project.model.anaylsis.EcologicPathResult;
import lapr.project.model.anaylsis.FastestPathResult;
/**
 *
 * @author Diana Silva
 */
public class FindBestPathController {
    EcologicPathResult ecologicResult;
    FastestPathResult fastestResult;
    
    public void newEcologicResult(Node startNode){
       ecologicResult=Project.getListResults().newEcologicResult(startNode);
    }
    
    public void newFastestResult(Node startNode){
       fastestResult=Project.getListResults().newFastestResult(startNode);
    }
    
    public Node[] getVertices(){
        return Project.getAirNetwork().getAirNetwork().allkeyVerts();
    }
    
    public List<Node> getPossibleEndNodes(Node startNode){
        return Project.getAirNetwork().getPossibleEndNodes(startNode);
    }
    
    public void setEndNodeEcologic(Node endNode){
        ecologicResult.setEndNode(endNode);
    }
    
    
    public void setEndNodeFastest(Node endNode){
        fastestResult.setEndNode(endNode);
    }
  
    private boolean saveEcologicResult(Node startNode, Node endNode, LinkedList<Node> shortPath){

        return Project.getListResults().getShortesPathResultsList().add(ecologicResult);
    }
    
     private boolean saveFastestResult(Node startNode, Node endNode, LinkedList<Node> shortPath){
        return Project.getListResults().getShortesPathResultsList().add(fastestResult);
    }
}
