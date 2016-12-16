/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class that represents a Segment
 * @author Pedro Fernandes
 */
public class Segment implements Serializable{
    
    /**
     * Class atributes.
     */
    private String id;
    private Node startNode;
    private Node endNode;
    public enum Direction {bidirectional, direct, reverse};
    private Direction direction;
    private Wind wind;
    
    /**
     * Default values.
     */
    private final String DEFAULT_ID = "NOID";
    private final Direction DEFAULT_DIRECTION = Direction.bidirectional;
    
    /**
     * Default constructor.
     */
    public Segment(){
        this.id = DEFAULT_ID;
        this.startNode = new Node();
        this.endNode = new Node();
        this.direction = DEFAULT_DIRECTION;
        this.wind = new Wind();
    }
    /**
     * Parameter constructor
     * @param id the id of the segment
     * @param startNode the start node of the segment
     * @param endNode the end node of the segment
     * @param direction the Direction of the segment
     * @param wind the wind of the segment
     */
    public Segment(String id, Node startNode, Node endNode, String direction, Wind wind){
        this.id = id;
        this.startNode = startNode;
        this.endNode = endNode;
        setDirection(direction);
        this.wind = wind;
    }
    
    /**
     * Copy constructor.
     * @param segment the segment
     */
    public Segment(Segment segment){
        this.id = segment.id;
        this.startNode = segment.startNode;
        this.endNode = segment.endNode;
        this.direction = segment.direction;
        this.wind = segment.wind;
    }

    /**
     * gets the id of the segment
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * sets the id of the segment
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * gets the start node of the segment
     * @return the startNode
     */
    public Node getStartNode() {
        return startNode;
    }

    /**
     * sets the start node of the segment
     * @param startNode the startNode to set
     */
    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    /**
     * gets the end node of the segment
     * @return the endNode
     */
    public Node getEndNode() {
        return endNode;
    }

    /**
     * sets the end node of the segment
     * @param endNode the endNode to set
     */
    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    /**
     * gets the Direction of the segment
     * @return the Direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * sets the Direction of the segment
     * @param direction the Direction to set
     */
    public void setDirection(String direction) {
        try{
            this.direction = Direction.valueOf(direction);
        }catch (IllegalArgumentException e){
        }
    }

    /**
     * gets the wind of the segment
     * @return the wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * sets the wind of the segment
     * @param windIntensity the wind Intensity
     * @param windDirection the wind Direction
     */
    public void setWind(int windIntensity, int windDirection) {
        wind.setWindIntensity(windIntensity);
        wind.setWindDirection(windDirection);
    }
    
    /**
     * Returns a string description of this object.
     * @return the description of this object
     */
    @Override
    public String toString()
    {
        return id;
    }
    
    /**
     * Checks if two object are equal.
     * @param otherObject the other object
     * @return true if equal
     */
    @Override
    public boolean equals(Object otherObject){
        if(otherObject == null || this.getClass() != otherObject.getClass()){
            return false;
        }
        if (this == otherObject)
        {
            return true;
        }
        Segment otherSegment = (Segment) otherObject;
        return this.id.equals(otherSegment.id) &&
                this.startNode.equals(otherSegment.startNode) &&
                this.endNode.equals(otherSegment.endNode) &&
                this.direction.equals(otherSegment.direction) &&
                this.wind.equals(otherSegment.wind);
    }
    
    /**
     * hascode segment
     * @return hascode segment
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.startNode);
        hash = 47 * hash + Objects.hashCode(this.endNode);
        hash = 47 * hash + Objects.hashCode(this.direction);
        hash = 47 * hash + Objects.hashCode(this.wind);
        return hash;
    }
    
    /**
     * validate latitude and longitude
     * @return true if validate latitude and longitude, false if not 
     */
    public boolean validate(){
        //latitude  => min: -90 max: 90
        //longitude => min:-180 max:180
        return !this.id.isEmpty()
                && this.direction != null
                && this.startNode.validate()
                && this.endNode.validate()
                && !this.startNode.equals(this.endNode)
                && this.wind.validate();
    }
    
}
