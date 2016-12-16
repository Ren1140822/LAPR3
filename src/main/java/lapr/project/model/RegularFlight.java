package lapr.project.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Flavio Relvas
 */
public class RegularFlight extends Flight implements Serializable {

    /**
     * Class attributes
     */
    private List<Date> departureDays;

    /**
     * Default attributes
     */
    private final List<Date> DEFAULT_DEPARTURE_DAYS = new LinkedList<>();

    /**
     * Default constructor
     */
    public RegularFlight() {
        super();
        departureDays = DEFAULT_DEPARTURE_DAYS;
    }

    /**
     * Parameter constructor
     *
     * @param flightDesignator the flight designator
     * @param minStopTime the minimun stop time for the flight
     * @param scheduledArrival the scheduled date of arrival for the flight
     * @param departureDays the list of the days the flight actually occurs
     */
    public RegularFlight(String flightDesignator, int minStopTime, Date scheduledArrival, List<Date> departureDays) {
        super(flightDesignator, minStopTime, scheduledArrival);
        this.departureDays = departureDays;
    }

    /**
     * Copy constructor
     * @param flight the flight to copy
     */
    public RegularFlight(RegularFlight flight) {
        super(flight);
        this.departureDays = flight.departureDays;
    }

    /**
     * Returns a string description of this object.
     * @return the description of this object
     */
    @Override
    public String toString() {
        return super.toString();
    }

     /**
     * Checks if two object are equal.
     * @param otherObject the other object
     * @return true if equal
     */
    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.departureDays);
        return hash;
    }
    
    
    
}
