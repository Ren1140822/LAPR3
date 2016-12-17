/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import lapr.project.model.mapgraph.Graph;
import lapr.project.model.lists.NodeList;
import lapr.project.model.lists.SegmentList;

/**
 * Class that represents a air network of Segments and Nodes
 * @author Pedro Fernandes
 */
public class AirNetwork implements Serializable{
    
    /**
     * the list of nodes
     */
    private NodeList nodeList;
    /**
     * the list of segments
     */
    private SegmentList segmentList;
    /**
     * graph
     */
    private transient Graph<Node, Segment> airNetworkGraph;
    
    /**
     * constructor
     */
    public AirNetwork(){
        nodeList = new NodeList();
        segmentList = new SegmentList();
        airNetworkGraph = new Graph<>(true);
    }
    
    /**
     * gets the node list
     * @return the node list
     */
    public NodeList getNodeList(){
        return nodeList;
    }
    
    /**
     * gets the segment list
     * @return the segment list
     */
    public SegmentList getSegmentList(){
        return segmentList;
    }
    
    /**
     * gets the airnetwork graph
     * @return the airnetwork graph
     */
    public Graph<Node, Segment> getAirNetwork(){
        return airNetworkGraph;
    }
    
    /**
     * Sets the nodes list class reference.
     *
     * @param list the list
     */
    public void setNodeList(NodeList list) {
        nodeList = list;
    }
    
    /**
     * Sets the segments list class reference.
     *
     * @param list the list
     */
    public void setSegmentList(SegmentList list) {
        segmentList = list;
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
        for(Node node : nodeList.getNodeList()){
            airNetworkGraph.insertVertex(node);
        }
        return airNetworkGraph.numVertices() == nodeList.getNodeList().size();
    }
    
    /**
     * insert segments into graph
     * @return true if num edges >= size of segmentlist
     * (because bidirectional segments add two edges), 
     * false if not
     */
    private boolean insertSegments(){
        for(Segment segment : segmentList.getSegmentList()){
            if(segment.getDirection() == Segment.Direction.BIDIRECTIONAL){
                airNetworkGraph.insertEdge(segment.getStartNode(), segment.getEndNode(), segment, 1);
                airNetworkGraph.insertEdge(segment.getEndNode(),segment.getStartNode(), segment, 1);
            }else{
                if(segment.getDirection() == Segment.Direction.DIRECT){
                    airNetworkGraph.insertEdge(segment.getStartNode(), segment.getEndNode(), segment, 1);
                }
            }      
        }
        return airNetworkGraph.numEdges() >= segmentList.getSegmentList().size();
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
    public NodeList getPossibleEndNodes(Node startNode) {
        NodeList list = new NodeList();
        /**implement methods to find possible end airports by the segments in project**/
        return list;
    }
}
