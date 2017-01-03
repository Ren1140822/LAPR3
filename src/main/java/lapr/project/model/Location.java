/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.utils.StringToSIUnitConverter;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement(name="location")
@XmlAccessorType(XmlAccessType.FIELD)
public class Location implements Serializable{
    
    /**
     * Class atributes.
     */
    @XmlElement(name="latitude")
    private double latitude;
    @XmlElement(name="longitude")
    private double longitude;
    @XmlTransient
    private double altitude;
    
    /**
     * Default values.
     */
    @XmlTransient
    private final double DEFAULT_LAT = 0.0;
    @XmlTransient
    private final double DEFAULT_LONG = 0.0;
    @XmlTransient
    private final double DEFAULT_ALTITUDE = 0;
    
    /**
     * Default constructor.
     */
    public Location() {
        this.latitude = DEFAULT_LAT;
        this.longitude = DEFAULT_LONG;
        this.altitude = DEFAULT_ALTITUDE;
    }
    
    /**
     * Parameter constructor.
     * 
     * @param latitude the latitude of the airport
     * @param longitude the longitude of the airport
     * @param altitude the alt of the airport
     */
    public Location(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }
    
    /**
     * Copy constructor.
     *
     * @param location the location
     */
    public Location(Location location) {
        this.latitude = location.latitude;
        this.longitude = location.longitude;
        this.altitude = location.altitude;
    }
    
    /**
     * Gets the latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude.
     *
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    

    /**
     * Gets the longitude.
     *
     * @return
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude.
     *
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets the alt.
     *
     * @return the alt
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * Sets the alt.
     *
     * @param altitude the alt to set
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
    
    /**
     * altitude for JAXB
     * @return altitude for JAXB
     */
    @XmlElement(name="altitude")
    private String getAltitude_(){
        return String.valueOf(altitude);
    }
    
    /**
     * Sets the intensity for JAXB
     *
     * @param altitude the alt to set
     */
    private void setAltitude_(String alt) {
        this.altitude = (double) StringToSIUnitConverter.length(alt);
    }
    
    /**
     * Returns a string description of this object.
     *
     * @return the description of this object
     */
    @Override
    public String toString() {
        return latitude + " <-> " + longitude + " <-> " + altitude;
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
        Location otherLocation = (Location) otherObject;
        boolean lat = !(this.latitude < otherLocation.latitude) && !(this.latitude > otherLocation.latitude);
        boolean lon = !(this.longitude < otherLocation.longitude) && !(this.longitude > otherLocation.longitude);
        return  this.altitude == otherLocation.altitude && lat && lon;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.latitude);
        hash = 29 * hash + Objects.hashCode(this.longitude);
        hash = 29 * hash + Objects.hashCode(this.altitude);
        return hash;
    }
    
    /**
     * validate airport
     * @return true if validate airport, false if not 
     */
    public boolean validate(){
        //latitude  => min: -90 max: 90
        boolean lat = !(latitude < -90 || latitude > 90);
        //longitude => min:-180 max:180
        boolean lon = !(longitude < -180 || longitude > 180);
        return lat && lon;
    }
}
