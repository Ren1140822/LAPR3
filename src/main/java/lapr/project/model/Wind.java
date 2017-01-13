/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.utils.StringToSIUnitConverter;

/**
 * Class that represents Wind of a Segment
 * @author Pedro Fernandes
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Wind implements Serializable{
    
    /**
     * Class atributes.
     */
    @XmlTransient
    private double windIntensity;
    @XmlElement(name="wind_direction")
    private double windDirection;
    
    /**
     * Default values.
     */
    @XmlTransient
    private final double DEFAULT_WIND_INTENSITY = 0;
    @XmlTransient
    private final double DEFAULT_WIND_DIRECTION = 0;
    
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
    public Wind(double windIntensity, double windDirection){
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
     * gets the wind intensity of the wind
     * @return the wind Intensity
     */
    @XmlTransient
    public double getWindIntensity() {
        return windIntensity;
    }

    /**
     * sets the intensity of the wind
     * @param windIntensity the windIntensity to set
     */
    public void setWindIntensity(double windIntensity) {
        this.windIntensity = windIntensity;
    }
    
    /**
     * gets the wind intensity for JAXB
     * @return the wind intensity for JAXB
     */
    @XmlElement(name="wind_intensity")
    public String getWindIntensity_() {
        return String.valueOf(windIntensity);
    }

    /**
     * sets the wind intensity for JAXB
     * @param windInt the wind intensity for JAXB
     */
    public void setWindIntensity_(String windInt) {
        this.windIntensity = StringToSIUnitConverter.speed(windInt);
    }

    /**
     * gets the direction of the wind
     * @return the windDirection
     */
    public double getWindDirection() {
        return windDirection;
    }

    /**
     * sets the direction of the wind
     * @param windDirection the windDirection to set
     */
    public void setWindDirection(double windDirection) {
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
        boolean windd = !(this.windDirection < otherWind.windDirection) && !(this.windDirection > otherWind.windDirection);
        boolean windi = !(this.windIntensity < otherWind.windIntensity) && !(this.windIntensity > otherWind.windIntensity);
        return windd && windi;
    }

    /**
     * hascode wind
     * @return hascode wind
     */
    @Override
    public int hashCode() {
        int hash = 3;
        Double i1 = this.windIntensity;
        Double i2 = this.windDirection;
        hash = 47 * hash + i1.hashCode();
        hash = 47 * hash + i2.hashCode();
        return hash;
    }
    
    /**
     * validate wind intensity and direction
     * @return true if validate wind intensity and direction, false if not 
     */
    public boolean validate(){
        //direction relative to the North (-180º <-> 180º)
        //intensity > 0
        return !(windDirection < -180 || windDirection > 180)
                && (windIntensity >= 0);
    }
}
