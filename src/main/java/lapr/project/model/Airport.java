/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class that represents airport
 * @author Renato Oliveira and Pedro Fernandes
 */
public class Airport implements Serializable {

    /**
     * Class atributes.
     */
    private String name;
    private String town;
    private String country;
    private String IATA;
    private Location location;

    /**
     * Default values.
     */
    private final String DEFAULT_NAME = "No name.";
    private final String DEFAULT_TOWN = "No town.";
    private final String DEFAULT_COUNTRY = "No country.";
    private final String DEFAULT_IATA = "No IATA code.";

    /**
     * Default constructor.
     */
    public Airport() {
        this.name = DEFAULT_NAME;
        this.town = DEFAULT_TOWN;
        this.IATA = DEFAULT_IATA;
        this.country = DEFAULT_COUNTRY;
        location = new Location();
    }

    /**
     * Parameter constructor.
     * 
     * @param IATA the iata code of the airport
     * @param name the name of the airport
     * @param town the town of the airport
     * @param country the country of the airport
     * @param localizacao the localizacao of the airport
     */
    public Airport(String IATA, String name, String town, String country, Location localizacao) {
        this.name = name;
        this.town = town;
        this.IATA = IATA;
        this.country = country;
        this.location = localizacao;
    }

    /**
     * Copy constructor.
     *
     * @param airport the airport
     */
    public Airport(Airport airport) {
        this.name = airport.name;
        this.town = airport.town;
        this.IATA = airport.IATA;
        this.country = airport.country;
        this.location = airport.location;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the town.
     *
     * @return the town
     */
    public String getTown() {
        return town;
    }

    /**
     * Sets the town.
     *
     * @param town the town to set
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country
     *
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the iata code.
     *
     * @return the iata code
     */
    public String getIATA() {
        return IATA;
    }

    /**
     * Sets the iata code.
     *
     * @param IATA the iata code to set
     */
    public void setIATA(String IATA) {
        this.IATA = IATA;
    }
    
    
    /**
     * gets the location of a aiport
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * sets the location of a aiport
     * @param latitude latitude
     * @param longitude longitude
     * @param altitude altitude
     */
    public void setLocation(double latitude, double longitude, int altitude) {
        location.setAltitude(altitude);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
    }
    
    /**
     * Returns a string description of this object.
     *
     * @return the description of this object
     */
    @Override
    public String toString() {
        return name;
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
        Airport otherAirport = (Airport) otherObject;
        return this.IATA.equals(otherAirport.IATA) || this.getLocation().equals(otherAirport.getLocation());              
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.name.hashCode();
        hash = 29 * hash + this.town.hashCode();
        hash = 29 * hash + this.country.hashCode();
        hash = 29 * hash + this.IATA.hashCode();
        return hash;
    }

    /**
     * validate airport
     * @return true if validate airport, false if not 
     */
    public boolean validate(){
        //to remove major error from sonarqube
        boolean v1 = !this.IATA.isEmpty()
                && !this.country.isEmpty()
                && !this.name.isEmpty();
        boolean v2 = !this.town.isEmpty()
                && location.validate();
        return v1 && v2;                
    }
    
    
}
