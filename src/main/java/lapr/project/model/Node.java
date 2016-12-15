/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;

/**
 * Classe that represents a Node of the AirNetwork
 * @author Pedro Fernandes
 */
public class Node implements Serializable{
    
    /**
     * Class atributes.
     */
    private String id;
    private double latitude;
    private double longitude;
    
    /**
     * Default values.
     */
    private final String DEFAULT_ID = "NO_ID";
    private final double DEFAULT_LATITUDE = 0;
    private final double DEFAULT_LONGITUDE = 0;
            
    /**
     * Default constructor.
     */
    public Node() {
        this.id = DEFAULT_ID;
        this.latitude = DEFAULT_LATITUDE;
        this.longitude = DEFAULT_LONGITUDE;
    }
    /**
     * Parameter constructor
     * @param id the id of the node
     * @param latitude the latitude of the node
     * @param longitude the longitude of the node
     */
    public Node(String id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }    
            
    /**
     * Copy constructor.
     * @param node the node
     */
    public Node(Node node){
        this.id = node.id;
        this.latitude = node.latitude;
        this.longitude = node.longitude;        
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
     * gets the latitude
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * sets the latitude
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * gets the longitude
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * sets the longitude
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
        Node otherNode = (Node) otherObject;
        return this.id.equals(otherNode.id) &&
                this.latitude == otherNode.latitude &&
                this.longitude == otherNode.longitude;
    }
    /**
     * validate latitude and longitude
     * @return true if validate latitude and longitude, false if not 
     */
    public boolean validate(){
        //latitude  => min: -90 max: 90
        //longitude => min:-180 max:180
        return !(latitude < -90 && latitude > 90)
                && !(longitude < -180 && longitude > 180);
    }
}
