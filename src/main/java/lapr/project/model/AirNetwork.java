/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.mapgraph.Graph;

/**
 * Class that represents a air network of Segments and Nodes
 * @author Pedro Fernandes
 */
@XmlRootElement(name="Network")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirNetwork implements Serializable{    
    /**
     * the id of airnetwork
     */
    @XmlAttribute(name="id")
    private String id;
    /**
     * the id of description
     */
    @XmlAttribute(name="description")
    private String description;
    /**
     * the list of nodes
     */
    @XmlElementWrapper(name="node_list")
    @XmlElement(name="node")
    private Map<String,Node> nodeList;
    /**
     * Node to be added into list
     */
    @XmlTransient
    private Node node;
    /**
     * the list of segments
     */
    @XmlElementWrapper(name="segment_list")
    @XmlElement(name="segment")
    private List<Segment> segmentList;
    
    /**
     * Segment to be added into list
     */
    @XmlTransient
    private Segment segment;
    
    /**
     * graph
     */
    private transient Graph<Node, Segment> airNetworkGraph;
    /**
     * Default values
     */
    @XmlTransient
    private String DEFAULT_ID = "NoID";
    @XmlTransient
    private String DEFAULT_DESCRIPTION = "NoDescription";
    /**
     * constructor
     */
    public AirNetwork(){
        this.id = DEFAULT_ID;
        this.description=DEFAULT_DESCRIPTION;
        this.nodeList = new HashMap<>();
        this.segmentList = new LinkedList<>();
        this.airNetworkGraph = new Graph<>(true);
    }
    
    /**
     * gets the id
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * sets the id
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * gets the description
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the description
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
//****************************** Node List *********************************    
    /**
     * sets the node
     * @param id the id of the node
     * @param latitude the latitude of the node
     * @param longitude the longitude of the node
     */
    public void setNode(String id, double latitude, double longitude){
        node = new Node();
        node.setId(id);
        node.setLatitude(latitude);
        node.setLongitude(longitude);
    }
    
    /**
     * validate and saves the node into nodesList
     * @return true if node is valid and is added, false if not
     */
    public boolean saveNode(){
        if(validateNode()){
            addNode();
            return true;
        }
        return false;
    }
    
    /**
     * validate if node is valid and do not exist in the list
     * @return true if node is valid and do not exist in the list, false if not
     */
    private boolean validateNode(){
        return node.validate() && !nodeList.containsKey(node.getId());
    }
    
    /**
     * add the node into the list
     * @return true if node is added, false if not
     */
    private void addNode(){
        nodeList.put(node.getId(), node);
    }
    
    /**
     * gets the node list
     * @return the node list
     */
    public Map<String, Node> getNodeList(){
        return nodeList;
    }
    
    /**
     * Sets the nodes list class reference.
     *
     * @param list the list
     */
    public void setNodeList(Map<String, Node> list) {
        nodeList = list;
    }
//*************************** end Node List *******************************


//****************************** Segment List *********************************     

    /**
     * sets the segment
     * @param id the id of the segment
     * @param startNode the startNode of the segment
     * @param endNode the endNode of the segment
     * @param direction the direction of the segment
     * @param windIntensity the wind Intensity of the segment
     * @param windDirection the wind Direction of the segment
     */
    public void setSegment(String id, String startNode, String endNode, 
            String direction, int windIntensity, int windDirection){
        segment = new Segment();
        segment.setId(id);
        segment.setStartNode(startNode);
        segment.setEndNode(endNode);
        segment.setDirection(direction);
        segment.setWind(windIntensity, windDirection);
    }
    
    /**
     * validate and saves the segment into segmentsList
     * @return true if segment is valid and is added, false if not
     */
    public boolean saveSegment(){
        return validateSegment()&& addSegment();       
    }
    
    /**
     * validate if segment is valid and do not exist in the list
     * @return true if segment is valid and do not exist in the list, false if not
     */
    private boolean validateSegment(){
        return segment.validate() && !segmentList.contains(segment);
    }
    
    /**
     * add the segment into the list
     * @return true if segment is added, false if not
     */
    private boolean addSegment(){
        return segmentList.add(segment);
    }
    
    /**
     * gets the segment list
     * @return the segment list
     */
    public List<Segment> getSegmentList(){
        return segmentList;
    }

    /**
     * Sets the segments list class reference.
     *
     * @param list the list
     */
    public void setSegmentList(List<Segment> list) {
        segmentList = list;
    }
    
//*************************** end Segment List *******************************
    
    /**
     * gets the airnetwork graph
     * @return the airnetwork graph
     */
    public Graph<Node, Segment> getAirNetwork(){
        return airNetworkGraph;
    }   
    
    /**
     * generate the graph with nodes -> vertex and segments -> edges
     * @return true if airnetwork is generated, false if not
     */
    public boolean generateGraph(){
        return insertNodes() &&  insertSegments(); 
    }
    
    /**
     * insert nodes into graph
     * @return true if num vertices == size of nodelist, false if not
     */
    private boolean insertNodes(){
        Set<String> nodes = nodeList.keySet();
        if(nodes.isEmpty()) return false;
        for(String nod : nodes){
            airNetworkGraph.insertVertex(nodeList.get(nod));
        }
        return airNetworkGraph.numVertices() == nodeList.size();
    }
    
    /**
     * insert segments into graph
     * @return true if num edges >= size of segmentlist
     * (because bidirectional segments add two edges), 
     * false if not
     */
    private boolean insertSegments(){
        for(Segment s : segmentList){
            if(s.getDirection() == Segment.Direction.BIDIRECTIONAL){
                airNetworkGraph.insertEdge(nodeList.get(s.getStartNode()), 
                        nodeList.get(s.getEndNode()), s, 1);
                airNetworkGraph.insertEdge(nodeList.get(s.getEndNode()),
                        nodeList.get(s.getStartNode()), s, 1);
            }else{
                if(s.getDirection() == Segment.Direction.DIRECT){
                    airNetworkGraph.insertEdge(nodeList.get(s.getStartNode()), 
                            nodeList.get(s.getEndNode()), s, 1);
                }
            }      
        }
        return airNetworkGraph.numEdges() >= segmentList.size();
    }
    
    /**
     * description of airnetwork graph
     * @return description of airnetwork graph
     */
    @Override
    public String toString() {
        return airNetworkGraph.toString();
    } 

    /**
     * Gets the possible end destinations relatives to origin of flight
     * @param startNode origin of flight
     * @return list of possible destination airports
     */
    public List<Node> getPossibleEndNodes(Node startNode) {
        List<Node> list = new LinkedList<>();
        /**implement methods to find possible end airports by the segments in project**/
        return list;
    }
}
