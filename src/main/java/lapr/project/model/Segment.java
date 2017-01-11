/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Class that represents a Segment
 *
 * @author Pedro Fernandes
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Segment implements Serializable {

    /**
     * Class atributes.
     */
    @XmlTransient
    private String id;
    @XmlTransient
    private Node startNode;
    @XmlTransient
    private Node endNode;

    @XmlTransient
    public enum Direction {
        BIDIRECTIONAL, DIRECT
    };
    @XmlTransient
    private Direction direction;
    @XmlTransient
    private Wind wind;
    @XmlTransient
    private int minAltSlot;
    @XmlTransient
    private int maxAltSlot;

    /**
     * Default values.
     */
    @XmlTransient
    private static final String DEFAULT_ID = "NOID";
    @XmlTransient
    private static final Direction DEFAULT_DIRECTION = Direction.BIDIRECTIONAL;
    @XmlTransient
    private static final int DEFAULT_MIN_ALT_SLOT = 0;
    @XmlTransient
    private static final int DEFAULT_MAX_ALT_SLOT = 0;

    /**
     * Default constructor.
     */
    public Segment() {
        this.id = DEFAULT_ID;
        this.startNode = new Node();
        this.endNode = new Node();
        this.direction = DEFAULT_DIRECTION;
        this.wind = new Wind();
        this.minAltSlot = DEFAULT_MIN_ALT_SLOT;
        this.maxAltSlot = DEFAULT_MAX_ALT_SLOT;
    }

    /**
     * Parameter constructor
     *
     * @param id the id of the segment
     * @param startNode the start node of the segment
     * @param endNode the end node of the segment
     * @param direction the Direction of the segment
     * @param wind the wind of the segment
     * @param minAltSlot
     * @param maxAltSlot
     */
    public Segment(String id, Node startNode, Node endNode, String direction,
            Wind wind, int minAltSlot, int maxAltSlot) {
        this.id = id;
        this.startNode = startNode;
        this.endNode = endNode;
        setDirection(direction);
        this.wind = wind;
        this.minAltSlot = minAltSlot;
        this.maxAltSlot = minAltSlot;
    }

    /**
     * Copy constructor.
     *
     * @param segment the segment
     */
    public Segment(Segment segment) {
        this.id = segment.id;
        this.startNode = segment.startNode;
        this.endNode = segment.endNode;
        this.direction = segment.direction;
        this.wind = segment.wind;
        this.minAltSlot = segment.minAltSlot;
        this.maxAltSlot = segment.maxAltSlot;
    }

    /**
     * gets the id of the segment
     *
     * @return the id
     */
    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    /**
     * sets the id of the segment
     *
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * gets the start node of the segment
     *
     * @return the startNode
     */
    @XmlElement(name = "start_node")
    public String getStartNode_() {
        return String.valueOf(startNode);
    }

    /**
     * sets the start node of the segment
     *
     * @param startNodeid the startNode to set
     */
    public void setStartNode_(String startNodeid) {
        this.startNode.setId(startNodeid);
    }

    /**
     * gets the start node of the segment
     *
     * @return the startNode
     */
    public Node getStartNode() {
        return startNode;
    }

    /**
     * sets the start node of the segment
     *
     * @param startNode the startNode to set
     */
    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    /**
     * gets the end node of the segment
     *
     * @return the endNode
     */
    public Node getEndNode() {
        return endNode;
    }

    /**
     * sets the end node of the segment
     *
     * @param endNode the endNode to set
     */
    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    /**
     * gets the end node of the segment
     *
     * @return the endNode
     */
    @XmlElement(name = "end_node")
    public String getEndNode_() {
        return String.valueOf(endNode);
    }

    /**
     * sets the end node of the segment
     *
     * @param endNodeid the endNode to set
     */
    public void setEndNode_(String endNodeid) {
        this.endNode.setId(endNodeid);
    }

    /**
     * gets the Direction of the segment
     *
     * @return the Direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * sets the Direction of the segment
     *
     * @param direction the Direction to set
     */
    public void setDirection(String direction) {
        try {
            this.direction = Direction.valueOf(direction.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }

    /**
     * altitude for JAXB
     *
     * @return altitude for JAXB
     */
    @XmlElement(name = "direction")
    private String getDirection_() {
        return String.valueOf(direction);
    }

    /**
     * Sets the intensity for JAXB
     *
     * @param altitude the alt to set
     */
    private void setDirection_(String dir) {
        setDirection(dir);
    }

    /**
     * gets the wind of the segment
     *
     * @return the wind
     */
    @XmlElement
    public Wind getWind() {
        return wind;
    }

    /**
     * sets the wind of the segment
     *
     * @param windIntensity the wind Intensity
     * @param windDirection the wind Direction
     */
    public void setWind(int windIntensity, int windDirection) {
        wind.setWindIntensity(windIntensity);
        wind.setWindDirection(windDirection);
    }

    /**
     * @return the minAltSlot
     */
    public int getMinAltSlot() {
        return minAltSlot;
    }

    /**
     * @param minAltSlot the minAltSlot to set
     */
    public void setMinAltSlot(int minAltSlot) {
        this.minAltSlot = minAltSlot;
    }

    /**
     * @return the maxAltSlot
     */
    public int getMaxAltSlot() {
        return maxAltSlot;
    }

    /**
     * @param maxAltSlot the maxAltSlot to set
     */
    public void setMaxAltSlot(int maxAltSlot) {
        this.maxAltSlot = maxAltSlot;
    }

    /**
     * Returns a string description of this object.
     *
     * @return the description of this object
     */
    @Override
    public String toString() {
        return id;
    }

    /**
     * Checks if two object are equal.
     *
     * @param otherObject the other object
     * @return true if equal
     */
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        if (this == otherObject) {
            return true;
        }
        Segment otherSegment = (Segment) otherObject;

        //to remove major error from sonarqube
        boolean v1 = this.startNode.getId().equals(otherSegment.startNode.getId())
                && this.endNode.getId().equals(otherSegment.endNode.getId());
        if (v1) {
            return this.id.equalsIgnoreCase(otherSegment.id);
        } else {
            return false;
        }
    }

    /**
     * hascode segment
     *
     * @return hascode segment
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id.hashCode();
        hash = 47 * hash + this.startNode.hashCode();
        hash = 47 * hash + this.endNode.hashCode();
        hash = 47 * hash + this.direction.hashCode();
        hash = 47 * hash + this.wind.hashCode();
        return hash;
    }

    /**
     * validate latitude and longitude
     *
     * @return true if validate latitude and longitude, false if not
     */
    public boolean validate() {
        //to remove major error from sonarqube
        boolean v1 = !this.id.isEmpty()
                && this.direction != null;
        boolean v2 = !this.startNode.equals(this.endNode)
                && this.wind.validate();
        return v1 && v2;
    }

}
