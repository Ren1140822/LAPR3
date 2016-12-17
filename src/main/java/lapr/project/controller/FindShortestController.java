/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.anaylsis.ShortestPathResult;
import lapr.project.model.lists.NodeList;
import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 * Controller to find shortest path between two airports
 * @author Diana Silva
 */
public class FindShortestController {
    
    ShortestPathResult result;
    
    public void newResult(Node startNode){
       result=Project.getListResults().newShortestResult(startNode);
    }
    
    public Node[] getVertices(){
        return Project.getAirNetwork().getAirNetwork().allkeyVerts();
    }
    
    public NodeList getPossibleEndNodes(Node startNode){
        return result.getPossibleEndNodes(startNode);
    }
    
    public void setEndNode(Node endNode){
        result.setEndNode(endNode);
    }
  
    private boolean saveResult(Node startNode, Node endNode, LinkedList<Node> shortPath){
       // result.setResult(GraphAlgorithms.shortestPath(AirNetwork.getAirNetwork(), startNode, endNode, shortPath));
        return Project.getListResults().getShortesPathResultsList().add(result);
    }
    
}
