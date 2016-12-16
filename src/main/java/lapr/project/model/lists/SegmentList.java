/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import lapr.project.model.Node;
import lapr.project.model.Segment;

/**
 * Classe that represents a list of Segments
 * @author Pedro Fernandes
 */
public class SegmentList implements Serializable{
    
    /**
     * the list of segments
     */
    private LinkedList<Segment> segmentList;
    
    /**
     * Segment to be added into list
     */
    Segment segment;
    
    /**
     * Constructor
     */
    public SegmentList(){
        this.segmentList = new LinkedList<>();
    }
    
    /**
     * Copy constructor.
     * @param list the instance of this class
     */
    public SegmentList(SegmentList list){
        this.segmentList = list.segmentList;
    }
    
    /**
     * Parameter constructor.
     * @param segmentList the lis of segments
     */
    public SegmentList(LinkedList<Segment> segmentList)
    {
        this.segmentList = segmentList;
    }

    /**
     * gets the segment list
     * @return the segment List
     */
    public LinkedList<Segment> getSegmentList() {
        return segmentList;
    }

    /**
     * sets the segment list
     * @param segmentList the segment List
     */
    public void setSegmentList(LinkedList<Segment> segmentList) {
        this.segmentList = segmentList;
    }
    
    /**
     * create Segment
     */
    public void newSegment(){
        segment = new Segment();
    }
    
    /**
     * sets the segment
     * @param id the id of the segment
     * @param startNode the startNode of the segment
     * @param endNode the endNode of the segment
     * @param direction the direction of the segment
     * @param windIntensity the wind Intensity of the segment
     * @param windDirection the wind Direction of the segment
     */
    public void setSegment(String id, Node startNode, Node endNode, 
            String direction, int windIntensity, int windDirection){
        segment.setId(id);
        segment.setStartNode(startNode);
        segment.setEndNode(endNode);
        segment.setDirection(direction);
        segment.setWind(windIntensity, windDirection);
    }
    
    /**
     * validate and saves the segment into segmentList
     * @return true if segment is valid and is added, false if not
     */
    public boolean saveSegment(){
        return validate() && addSegment();       
    }
    
    /**
     * validate if segment is valid and do not exist in the list
     * @return true if segment is valid and do not exist in the list, false if not
     */
    private boolean validate(){
        return segment.validate() && !segmentList.contains(segment);
    }
    
    /**
     * add the segment into the list
     * @return true if segment is added, false if not
     */
    private boolean addSegment(){
        return segmentList.add(segment);
    }
}
