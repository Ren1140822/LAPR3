/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Pedro Fernandes
 */
public class Location implements Serializable{
    
    /**
     * Class atributes.
     */
    private double latitude;
    private double longitude;
    private int altitude;
    
    /**
     * Default values.
     */
    private final double DEFAULT_LAT = 0.0;
    private final double DEFAULT_LONG = 0.0;
    private final int DEFAULT_ALTITUDE = 0;
    
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
     * @param altitude the altitude of the airport
     */
    public Location(double latitude, double longitude, int altitude) {
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
     * Gets the altitude.
     *
     * @return the altitude
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     * Sets the altitude.
     *
     * @param altitude the altitude to set
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
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
        hash = 29 * hash + this.altitude;
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
        //altitude >= 0
        boolean alt = altitude >= 0;
        return lat && lon && alt;
    }
}
