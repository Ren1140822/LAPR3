package lapr.project.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Flavio Relvas
 */
public abstract class Flight implements Serializable {

    /**
     * Class attributes
     */
    String flightDesignator;
    //private enum type{Regular, Charter}; //@TODO - create ENUM for this attribute
    //private String departureData; //@TODO - ask what datatype this should be
    int minStopTime; // time in minutes
    Date scheduledArrival; //@TODO - should this be so sort of date

    /**
     * Default attributes
     */
    private final String DEFAULT_FLIGHT_DESIGNATOR = "No Designator";
    private final int DEFAULT_MIN_STOP_TIME = 0;
    private final Date DEFAULT_SCHEDULED_ARRIVAL = null;

    /**
     * Default constructor
     */
    public Flight() {
        flightDesignator = DEFAULT_FLIGHT_DESIGNATOR;
        minStopTime = DEFAULT_MIN_STOP_TIME;
        scheduledArrival = DEFAULT_SCHEDULED_ARRIVAL;
    }

    /**
     * Parameter constructor
     *
     * @param flightDesignator the flight designator
     * @param minStopTime the minimun stop time for the flight
     * @param scheduledArrival the scheduled date of arrival for the flight
     */
    public Flight(String flightDesignator, int minStopTime, Date scheduledArrival) {
        this.flightDesignator = flightDesignator;
        this.minStopTime = minStopTime;
        this.scheduledArrival = scheduledArrival;
    }

    /**
     * Copy constructor
     *
     * @param flight the flight to copy
     */
    public Flight(Flight flight) {
        this.flightDesignator = flight.flightDesignator;
        this.minStopTime = flight.minStopTime;
        this.scheduledArrival = flight.scheduledArrival;
    }

    @Override
    public String toString() {
        return this.flightDesignator;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        if (this == otherObject) {
            return true;
        }
        Flight other = (Flight) otherObject;
        return this.flightDesignator.equals(other.flightDesignator);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.flightDesignator);
        hash = 53 * hash + this.minStopTime;
        hash = 53 * hash + Objects.hashCode(this.scheduledArrival);
        return hash;
    }

    
    
    /**
     * Gets the flight designator
     * @return the flight's designator
     */
    public String getFlightDesignator() {
        return flightDesignator;
    }

    /**
     * Sets the flight designator
     * @param flightDesignator the new flight designator
     */
    public void setFlightDesignator(String flightDesignator) {
        this.flightDesignator = flightDesignator;
    }

    /**
     * Gets the minimum stop time of the flight
     * @return the minimum stop time of the flight
     */
    public int getMinStopTime() {
        return minStopTime;
    }

    /**
     * Sets the minimum stop time of the flight
     * @param minStopTime the new minimun stop time for the flight
     */
    public void setMinStopTime(int minStopTime) {
        this.minStopTime = minStopTime;
    }

    /**
     * Gets the date of the scheduled arrival for the flight
     * @return the date of the scheduled arrival of the flight
     */
    public Date getScheduledArrival() {
        return scheduledArrival;
    }

    /**
     * Sets the date of the scheduled arrival of the flight
     * @param scheduledArrival the new date of the flight's arrival
     */
    public void setScheduledArrival(Date scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }
    
    
}
