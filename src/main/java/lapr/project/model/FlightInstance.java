package lapr.project.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Flavio Relvas
 */
public class FlightInstance extends Flight implements Serializable {

    /**
     * Class attributes
     */
    private Date departureDay;

    /**
     * Default attributes
     */
    private final Date DEFAULT_DEPARTURE_DAY = new Date(System.currentTimeMillis());

    /**
     * Default constructor
     */
    public FlightInstance() {
        super();
        departureDay = DEFAULT_DEPARTURE_DAY;
    }

    /**
     * Parameter constructor
     *
     * @param flightDesignator the flight designator
     * @param minStopTime the minimun stop time for the flight
     * @param scheduledArrival the scheduled date of arrival for the flight
     * @param departureDay the day the flight actually occurs
     */
    public FlightInstance(String flightDesignator, int minStopTime, Date scheduledArrival, Date departureDay) {
        super(flightDesignator, minStopTime, scheduledArrival);
        this.departureDay = departureDay;
    }

    /**
     * Copy constructor
     * @param flight the flight to copy
     */
    public FlightInstance(FlightInstance flight) {
        super(flight);
        this.departureDay = flight.departureDay;
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
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.departureDay);
        return hash;
    }
    
    
    
}
