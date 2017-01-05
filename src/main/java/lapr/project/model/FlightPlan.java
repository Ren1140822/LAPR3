package lapr.project.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Flavio Relvas
 */
public class FlightPlan implements Serializable {

    /**
     * Class attributes
     */
    private String flightDesignator;
    private int minStopTime; // time in minutes
    private String aircraft;
    private String origin;
    private String destination;
    private LinkedList<String> technicalStops;
    private LinkedList<String> mandatoryWaypoints;

    /**
     * Default attributes
     */
    private final String DEFAULT_FLIGHT_DESIGNATOR = "FF0001A";
    private final int DEFAULT_MIN_STOP_TIME = 0;
    private final String DEFAULT_AIRCRAFT = "No Aircraft";
    private final String DEFAULT_ORIGIN = "No Origin";
    private final String DEFAULT_DESTINATION = "No Destination";
    private final LinkedList<String> DEFAULT_TECHNICAL_STOPS = new LinkedList<>();
    private final LinkedList<String> DEFAULT_MANDATORY_WAYPOINTS = new LinkedList<>();

    /**
     * Default constructor
     */
    public FlightPlan() {
        flightDesignator = DEFAULT_FLIGHT_DESIGNATOR;
        minStopTime = DEFAULT_MIN_STOP_TIME;
        aircraft = DEFAULT_AIRCRAFT;
        origin = DEFAULT_ORIGIN;
        destination = DEFAULT_DESTINATION;
        technicalStops = DEFAULT_TECHNICAL_STOPS;
        mandatoryWaypoints = DEFAULT_MANDATORY_WAYPOINTS;
    }

    /**
     * Parameter constructor
     *
     * @param flightDesignator the flight designator
     * @param minStopTime the minimun stop time for the flight
     */
    public FlightPlan(String flightDesignator, int minStopTime, String aircraft, String origin, String destination, LinkedList<String> technicalStops, LinkedList<String> mandatoryWaypoints) {
        this.flightDesignator = flightDesignator;
        this.minStopTime = minStopTime;
        this.aircraft = aircraft;
        this.origin = origin;
        this.destination = destination;
        this.technicalStops = technicalStops;
        this.mandatoryWaypoints = mandatoryWaypoints;
    }

    /**
     * Copy constructor
     *
     * @param flight the flight to copy
     */
    public FlightPlan(FlightPlan flight) {
        this.flightDesignator = flight.flightDesignator;
        this.minStopTime = flight.minStopTime;
        this.aircraft = flight.aircraft;
        this.origin = flight.origin;
        this.destination = flight.destination;
        this.technicalStops = flight.technicalStops;
        this.mandatoryWaypoints = flight.mandatoryWaypoints;
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
        FlightPlan other = (FlightPlan) otherObject;
        return this.flightDesignator.equals(other.flightDesignator);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.flightDesignator);
        hash = 53 * hash + this.minStopTime;
        return hash;
    }

    public boolean validate() {
        if (!flightDesignator.matches("([a-zA-Z0-9]{2})([0-9]{1,4})([a-zA-Z]?)")) {
            return false;
        }
        if (minStopTime < 0) {
            return false;
        }

        return !aircraft.isEmpty();
    }

    /**
     * Gets the flight designator
     *
     * @return the flight's designator
     */
    public String getFlightDesignator() {
        return flightDesignator;
    }

    /**
     * Sets the flight designator
     *
     * @param flightDesignator the new flight designator
     */
    public void setFlightDesignator(String flightDesignator) {
        this.flightDesignator = flightDesignator;
    }

    /**
     * Gets the minimum stop time of the flight
     *
     * @return the minimum stop time of the flight
     */
    public int getMinStopTime() {
        return minStopTime;
    }

    /**
     * Sets the minimum stop time of the flight
     *
     * @param minStopTime the new minimun stop time for the flight
     */
    public void setMinStopTime(int minStopTime) {
        this.minStopTime = minStopTime;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTechnicalStops(LinkedList<String> technicalStops) {
        this.technicalStops = technicalStops;
    }

    public void setMandatoryWaypoints(LinkedList<String> mandatoryWaypoints) {
        this.mandatoryWaypoints = mandatoryWaypoints;
    }

}
