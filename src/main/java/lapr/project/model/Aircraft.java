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
public class Aircraft implements Serializable {
    
    /**
     * Class attributes.
     */
    private int registration;
    private String company;
    private int cabinConfig;
    private int nrOfCrewElements;
    
    /**
     * Default attributes.
     */
    private final int DEFAULT_REGISTRATION=0;
    private final String DEFAULT_COMPANY="No Company.";
    private final int DEFAULT_CABIN_CONFIG=0;
    private final int DEFAULT_NR_OF_CREW_ELEMENTS=0;

    /**
     * Default constructor.
     */
    public Aircraft() {
        this.registration = DEFAULT_REGISTRATION;
        this.company = DEFAULT_COMPANY;
        this.cabinConfig =DEFAULT_CABIN_CONFIG;
        this.nrOfCrewElements = DEFAULT_NR_OF_CREW_ELEMENTS;
    }
    
    /**
     * Parameter constructor.
     * @param registration the registration id
     * @param company the company
     * @param cabinConfig the cabin configuration
     * @param nrOfCrewElements the nr of crew elements
     */
    public Aircraft(int registration, String company, int cabinConfig, int nrOfCrewElements) {
        this.registration = registration;
        this.company = company;
        this.cabinConfig = cabinConfig;
        this.nrOfCrewElements = nrOfCrewElements;
    }
    
    /**
     * Copy constructor.
     * @param aircraft the aicraft to copy
     */
    public Aircraft (Aircraft aircraft)
    {
         this.registration = aircraft.registration;
        this.company = aircraft.company;
        this.cabinConfig = aircraft.cabinConfig;
        this.nrOfCrewElements = aircraft.nrOfCrewElements;
    }
    
    /**
     * Returns a string description of this object.
     * @return the description of this object
     */
    public String toString()
    {
        return String.valueOf(registration);
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
        Aircraft otherAircraft = (Aircraft)otherObject;
       return this.cabinConfig == otherAircraft.cabinConfig && this.company.equals(otherAircraft.company)&& this.nrOfCrewElements==otherAircraft.nrOfCrewElements && this.registration==otherAircraft.registration;
    }
    
}
