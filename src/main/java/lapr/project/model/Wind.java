/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;

/**
 * Class that represents Wind of a Segment
 * @author Pedro Fernandes
 */
public class Wind implements Serializable{
    
    /**
     * Class atributes.
     */
    private int windIntensity;
    private int windDirection;
    
    /**
     * Default values.
     */
    private final int DEFAULT_WIND_INTENSITY = 0;
    private final int DEFAULT_WIND_DIRECTION = 0;
    
    /**
     * Default constructor.
     */
    public Wind(){
        this.windDirection = DEFAULT_WIND_DIRECTION;
        this.windIntensity = DEFAULT_WIND_INTENSITY;
    }
    
    /**
     * Parameter constructor
     * @param windIntensity the intensity of the wind
     * @param windDirection the direction of the wind
     */
    public Wind(int windIntensity, int windDirection){
        this.windDirection = windDirection;
        this.windIntensity = windIntensity;
    }
    
    /**
     * Copy constructor.
     * @param wind the node
     */  
    public Wind(Wind wind){
        this.windDirection = wind.windDirection;
        this.windIntensity = wind.windIntensity;
    }

    /**
     * gets the intensity of the wind
     * @return the windIntensity
     */
    public int getWindIntensity() {
        return windIntensity;
    }

    /**
     * sets the intensity of the wind
     * @param windIntensity the windIntensity to set
     */
    public void setWindIntensity(int windIntensity) {
        this.windIntensity = windIntensity;
    }

    /**
     * gets the direction of the wind
     * @return the windDirection
     */
    public int getWindDirection() {
        return windDirection;
    }

    /**
     * sets the direction of the wind
     * @param windDirection the windDirection to set
     */
    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }
    
    /**
     * Returns a string description of this object.
     * @return the description of this object
     */
    @Override
    public String toString()
    {
        return windDirection + " <-> " + windIntensity;
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
        Wind otherWind = (Wind) otherObject;
        return this.windDirection == otherWind.windDirection &&
                this.windIntensity == otherWind.windIntensity;
    }
    
    /**
     * validate wind intensity and direction
     * @return true if validate wind intensity and direction, false if not 
     */
    public boolean validate(){
        //direction relative to the North (-180º <-> 180º)
        //intensity > 0
        return (!((windDirection < -180 || windDirection > 180))
                && (windIntensity >= 0));
    }
}
