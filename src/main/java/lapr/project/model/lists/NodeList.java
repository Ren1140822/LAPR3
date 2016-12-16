/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Node;

/**
 * Classe that represents a list of Nodes
 * @author Pedro Fernandes
 */
public class NodeList implements Serializable{
    
    /**
     * the list of nodes
     */
    private List<Node> nodesList;
    
    /**
     * Node to be added into list
     */
    private Node node;
    
    /**
     * Constructor.
     */
    public NodeList(){
        this.nodesList = new LinkedList<>();
    }
    
    /**
     * Copy constructor.
     * @param list the instance of this class
     */
    public NodeList(NodeList list){
        this.nodesList = list.nodesList;
    }
    
    /**
     * Parameter constructor.
     * @param nodeList the list of airports
     */
    public NodeList(List<Node> nodeList)
    {
        this.nodesList = nodeList;
    }
    
    /**
     * gets the node list
     * @return the node list
     */
    public List<Node> getNodeList(){
        return nodesList;
    }
    
    /**
     * sets the node list
     * @param nodeList the node list
     */
    public void setNodeList(List<Node> nodeList){
        this.nodesList = nodeList;
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
     * validate and saves the node into nodesList
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
        return node.validate() && !nodesList.contains(node);
    }
    
    /**
     * add the node into the list
     * @return true if node is added, false if not
     */
    private boolean addNode(){
        return nodesList.add(node);
    }
}
