/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import lapr.project.model.Node;

/**
 * Classe that represents a list of Nodes
 * @author Pedro Fernandes
 */
public class NodeList implements Serializable{
    
    /**
     * the list of nodes
     */
    LinkedList<Node> nodeList;
    
    /**
     * Node to be added into list
     */
    Node node;
    
    /**
     * Constructor.
     */
    public NodeList(){
        this.nodeList = new LinkedList<>();
    }
    
    /**
     * Copy constructor.
     * @param list the instance of this class
     */
    public NodeList(NodeList list){
        this.nodeList = list.nodeList;
    }
    
    /**
     * Parameter constructor.
     * @param nodeList the list of airports
     */
    public NodeList(LinkedList<Node> nodeList)
    {
        this.nodeList = nodeList;
    }
    
    /**
     * gets the node list
     * @return the node list
     */
    public LinkedList<Node> getNodeList(){
        return nodeList;
    }
    
    /**
     * sets the node list
     * @param nodeList the node list
     */
    public void setNodeList(LinkedList<Node> nodeList){
        this.nodeList = nodeList;
    }
    
    /**
     * create Node
     */
    public void newNode(){
        node = new Node();
    }
    
    /**
     * sets the node
     * @param id the id of the node
     * @param latitude the latitude of the node
     * @param longitude the longitude of the node
     */
    public void setNode(String id, double latitude, double longitude){
        node.setId(id);
        node.setLatitude(latitude);
        node.setLongitude(longitude);
    }
    
    /**
     * validate and saves the node into nodeList
     * @return true if node is valid and is added, false if not
     */
    public boolean saveNode(){
        return validate() && addNode();
    }
    
    /**
     * validate if node is valid and do not exist in the list
     * @return true if node is valid and do not exist in the list, false if not
     */
    private boolean validate(){
        return node.validate() && !nodeList.contains(node);
    }
    
    /**
     * add the node into the list
     * @return true if node is added, false if not
     */
    private boolean addNode(){
        return nodeList.add(node);
    }
}
