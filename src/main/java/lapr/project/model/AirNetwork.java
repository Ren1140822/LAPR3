/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.mapgraph.Graph;
import lapr.project.model.lists.NodeList;
import lapr.project.model.lists.SegmentList;

/**
 * Class that represents a air network of Segments and Nodes
 * @author Pedro Fernandes
 */
public class AirNetwork {
    
    /**
     * the list of nodes
     */
    NodeList nodeList;
    /**
     * the list of segments
     */
    SegmentList segmentList;
    /**
     * graph
     */
    private Graph<Node, Segment> airNetwork;
    
    /**
     * constructor
     */
    public AirNetwork(){
//        nodeList = Project.nodeList;
//        segmentList = Project.segmentList;
        airNetwork = new Graph<>(true);
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
        return airNetwork;
    }
    
    /**
     * generate the graph with nodes -> vertex and segments -> edges
     * @return true if airnetwork is generated, false if not
     */
    public boolean generateGraph(){
        return (insertNodes() &&  insertSegments()); 
    }
    
    /**
     * insert nodes into graph
     * @return true if num vertices == size of nodelist, false if not
     */
    private boolean insertNodes(){
        for(Node node : nodeList.getNodeList()){
            airNetwork.insertVertex(node);
        }
        return airNetwork.numVertices() == nodeList.getNodeList().size();
    }
    
    /**
     * insert segments into graph
     * @return true if num edges == size of segmentlist, false if not
     */
    private boolean insertSegments(){
        for(Segment segment : segmentList.getSegmentList()){
            airNetwork.insertEdge(segment.getStartNode(), segment.getEndNode(), segment, 1);
        }
        return airNetwork.numEdges() == segmentList.getSegmentList().size();
    }
    
    /**
     * description of airnetwork graph
     * @return description of airnetwork graph
     */
    @Override
    public String toString() {
        return airNetwork.toString();
    } 
}
