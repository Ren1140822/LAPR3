/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class Airport implements Serializable{

    /**
     * Class atributes.
     */
    private String name;
    private String town;
    private String country;
    private String IATA;
    private Double latitude;
    private Double longitude;
    private int altitude;

    /**
     * Default values.
     */
    private final String DEFAULT_NAME = "No name.";
    private final String DEFAULT_TOWN = "No town.";
    private final String DEFAULT_COUNTRY = "No country.";
    private final String DEFAULT_IATA = "No IATA code.";
    private final Double DEFAULT_LAT = 0.0;
    private final Double DEFAULT_LONG = 0.0;
    private final int DEFAULT_ALTITUDE = 0;

    /**
     * Default constructor.
     */
    public Airport() {
        this.name = DEFAULT_NAME;
        this.town = DEFAULT_TOWN;
        this.IATA = DEFAULT_IATA;
        this.latitude = DEFAULT_LAT;
        this.longitude = DEFAULT_LONG;
        this.altitude = DEFAULT_ALTITUDE;
    }

    /**
     * Parameter constructor.
     * @param name the name of the airport
     * @param town the town of the airport
     * @param IATA the iata code of the airport
     * @param latitude the latitude of the airport
     * @param longitude the longitude of the airport
     * @param altitude the altitude of the airport
     */
    public Airport(String name, String town, String IATA, Double latitude, Double longitude, int altitude) {
        this.name = name;
        this.town = town;
        this.IATA = IATA;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    /**
     * Copy constructor.
     * @param airport the airport
     */
    public Airport(Airport airport) {
        this.name = airport.name;
        this.town = airport.town;
        this.IATA = airport.IATA;
        this.latitude = airport.latitude;
        this.longitude = airport.longitude;
        this.altitude = airport.altitude;
    }

 /**
  * Gets the name.
  * @return  the name
  */
    public String getName() {
        return name;
    }

    /**
     *Sets the name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Gets the town.
     * @return the town
     */
    public String getTown() {
        return town;
    }

    /**
     *Sets the town.
     * @param town the town to set
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     *Gets the country.
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     *Sets the country
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *Gets the iata code.
     * @return the iata code
     */
    public String getIATA() {
        return IATA;
    }

    /**
     *Sets the iata code.
     * @param IATA the iata code to set
     */
    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    /**
     *Gets the latitude.
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     *Sets the latitude.
     * @param latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     *Gets the longitude.
     * @return
     */
    public  Double getLongitude() {
        return longitude;
    }

    /**
     *Sets the longitude.
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     *Gets the altitude.
     * @return the altitude
     */
    public int getAltitude() {
        return altitude;
    }

    /**
     *Sets the altitude.
     * @param altitude the altitude to set 
     */
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

     /**
     * Returns a string description of this object.
     * @return the description of this object
     */
    public String toString()
    {
        return name;
    }
    
    /**
     * Checks if two object are equal.
     * @param otherObject the other object
     * @return true if equal
     */
    public boolean equals(Object otherObject)
    {
        if (this == otherObject)
        {
            return true;
        }
        Airport otherAirport = (Airport)otherObject;
       return this.name.equals(otherAirport.name)&&this.IATA .equals(otherAirport.IATA) &&
                this.altitude == otherAirport.altitude && this.country.equals(otherAirport.country)&&
                this.town.equals(otherAirport.town)&&this.latitude == otherAirport.latitude &&
                this.longitude == otherAirport.longitude;
    }
}
