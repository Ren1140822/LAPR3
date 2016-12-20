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
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class Aircraft implements Serializable {

    /**
     * Class attributes.
     */
    private String registration;
    private String company;
    private CabinConfiguration cabinConfig;
    private int nrOfCrewElements;
    private AircraftModel aircraftModel;

    /**
     * Default attributes.
     */
    private static final String DEFAULT_REGISTRATION = "No Registration ID.";
    private static final String DEFAULT_COMPANY = "No Company.";
    private static final CabinConfiguration DEFAULT_CABIN_CONFIG = new CabinConfiguration(0, 0);
    private static final int DEFAULT_NR_OF_CREW_ELEMENTS = 0;
    private static final AircraftModel DEFAULT_MODEL = new AircraftModel();

    /**
     * Default constructor.
     */
    public Aircraft() {
        this.registration = DEFAULT_REGISTRATION;
        this.company = DEFAULT_COMPANY;
        this.cabinConfig = DEFAULT_CABIN_CONFIG;
        this.nrOfCrewElements = DEFAULT_NR_OF_CREW_ELEMENTS;
        this.aircraftModel = DEFAULT_MODEL;
    }

    /**
     * Parameter constructor.
     *
     * @param registration the registration id
     * @param company the company
     * @param cabinConfig the cabin configuration
     * @param nrOfCrewElements the nr of crew elements
     */
    public Aircraft(String registration, String company, CabinConfiguration cabinConfig, int nrOfCrewElements, AircraftModel aircraftModel) {
        this.registration = registration;
        this.company = company;
        this.cabinConfig = cabinConfig;
        this.nrOfCrewElements = nrOfCrewElements;
        this.aircraftModel = aircraftModel;
    }

    /**
     * Copy constructor.
     *
     * @param aircraft the aicraft to copy
     */
    public Aircraft(Aircraft aircraft) {
        this.registration = aircraft.registration;
        this.company = aircraft.company;
        this.cabinConfig = aircraft.cabinConfig;
        this.nrOfCrewElements = aircraft.nrOfCrewElements;
        this.aircraftModel = aircraft.aircraftModel;
    }

    /**
     * Returns a string description of this object.
     *
     * @return the description of this object
     */
    @Override
    public String toString() {
        return registration;
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
        Aircraft otherAircraft = (Aircraft) otherObject;
        return this.cabinConfig.equals(otherAircraft.cabinConfig) && this.company.equals(otherAircraft.company) && this.nrOfCrewElements == otherAircraft.nrOfCrewElements && this.registration.equals(otherAircraft.registration) && this.equals(otherAircraft.aircraftModel);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.registration);
        hash = 79 * hash + Objects.hashCode(this.company);
        hash = 79 * hash + Objects.hashCode(this.cabinConfig);
        hash = 79 * hash + this.nrOfCrewElements;
        hash = 79 * hash + Objects.hashCode(this.aircraftModel);
        return hash;
    }

    /**
     * Gets the aircraft registration id.
     *
     * @return the string
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * Sets the aircraft registration.
     *
     * @param registration the string to set
     */
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    /**
     * Gets the aircraft company.
     *
     * @return the string
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the aircraft company.
     *
     * @param company the string to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the cabin configuration.
     *
     * @return the cabin configuration
     */
    public CabinConfiguration getCabinConfig() {
        return cabinConfig;
    }

    /**
     * Sets the cabin configuration.
     *
     * @param cabinConfig the cabin config to set
     */
    public void setCabinConfig(CabinConfiguration cabinConfig) {
        this.cabinConfig = cabinConfig;
    }

    /**
     * Gets nr of elements of the crew.
     *
     * @return the nr of elements
     */
    public int getNrOfCrewElements() {
        return nrOfCrewElements;
    }

    /**
     * Sets the nr of elements of the crew.
     *
     * @param nrOfCrewElements the nr of elements.
     */
    public void setNrOfCrewElements(int nrOfCrewElements) {
        this.nrOfCrewElements = nrOfCrewElements;
    }

    public AircraftModel getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(AircraftModel aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public boolean validate() {
        return this.nrOfCrewElements > 0 && this.company != null && this.registration != null && this.cabinConfig != null;
    }

}
