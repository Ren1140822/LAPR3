/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import lapr.project.model.Node;
import lapr.project.model.lists.NodeList;

/**
 *
 * @author Diana Silva
 */
public class Result {
    Node startNode;
    Node endNode;
    LinkedList<Node> resultPath = new LinkedList<>();
    
    
    public Result(Node startNode){
        this.startNode=startNode;
    }
    
    public void setStartNode(Node startNode){
        this.startNode=startNode;
    }
    
    public void setEndNode(Node endNode){
        this.endNode=endNode;
    }
    
    public NodeList getPossibleEndNodes(Node startNode){
        NodeList list=new NodeList();
        /**implement methods to find possible end airports by the segments in project**/
        
        return list; 
    }
    
    public void setResult(LinkedList<Node> result){
        resultPath=result;
    }
    
    private void setTipo(){
        
    }
}
