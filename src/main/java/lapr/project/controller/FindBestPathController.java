/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.anaylsis.FastestPathResult;
import lapr.project.model.anaylsis.EcologicPathResult;
import lapr.project.model.lists.NodeList;
import lapr.project.utils.PhysicsAlgorithms;

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
    
    public NodeList getPossibleEndNodes(Node startNode){
        return Project.getAirNetwork().getPossibleEndNodes(startNode);
    }
    
    public void setEndNode(Node endNode){
        //corrigir
        ecologicResult.setEndNode(endNode);
        fastestResult.setEndNode(endNode);
    }
  
    private boolean saveResult(Node startNode, Node endNode, LinkedList<Node> shortPath){
        //corrigir
        double bestPath = PhysicsAlgorithms.calculateBestPathResult(fastestResult);
//        result.setResult(shortestPath);
//        return Project.getListResults().getShortesPathResultsList().add(result);
        return true;
    }
}
