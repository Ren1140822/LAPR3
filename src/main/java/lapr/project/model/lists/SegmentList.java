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
import lapr.project.model.Segment;

/**
 * Classe that represents a list of Segments
 * @author Pedro Fernandes
 */
public class SegmentList implements Serializable{
    
    /**
     * the list of segments
     */
    private List<Segment> segmentsList;
    
    /**
     * Segment to be added into list
     */
    private Segment segment;
    
    /**
     * Constructor
     */
    public SegmentList(){
        this.segmentsList = new LinkedList<>();
    }
    
    /**
     * Copy constructor.
     * @param list the instance of this class
     */
    public SegmentList(SegmentList list){
        this.segmentsList = list.segmentsList;
    }
    
    /**
     * Parameter constructor.
     * @param segmentList the lis of segments
     */
    public SegmentList(List<Segment> segmentList)
    {
        this.segmentsList = segmentList;
    }

    /**
     * gets the segment list
     * @return the segment List
     */
    public List<Segment> getSegmentList() {
        return segmentsList;
    }

    /**
     * sets the segment list
     * @param segmentList the segment List
     */
    public void setSegmentList(List<Segment> segmentList) {
        this.segmentsList = segmentList;
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
     * validate and saves the segment into segmentsList
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
        return segment.validate() && !segmentsList.contains(segment);
    }
    
    /**
     * add the segment into the list
     * @return true if segment is added, false if not
     */
    private boolean addSegment(){
        return segmentsList.add(segment);
    }
}
