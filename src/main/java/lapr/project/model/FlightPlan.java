package lapr.project.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlTransient;

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
    private Aircraft aircraft;
    private Airport origin;
    private Airport destination;
    private List<Airport> technicalStops;
    private List<Node> mandatoryWaypoints;
    /**
     * List of Pattern
     */
    @XmlTransient
    private List<Pattern> listPattern;

    /**
     * Default attributes
     */
    private final String DEFAULT_FLIGHT_DESIGNATOR = "FF0001A";
    private final int DEFAULT_MIN_STOP_TIME = 0;

    /**
     * Default constructor
     */
    public FlightPlan() {
        flightDesignator = DEFAULT_FLIGHT_DESIGNATOR;
        minStopTime = DEFAULT_MIN_STOP_TIME;
        aircraft = new Aircraft();
        origin = new Airport();
        destination = new Airport();
        technicalStops = new LinkedList<>();
        mandatoryWaypoints = new LinkedList<>();
        listPattern = new LinkedList<>();
    }

    /**
     * Parameter constructor
     *
     * @param flightDesignator the flight designator
     * @param minStopTime the minimun stop time for the flight
     * @param aircraft
     * @param origin
     * @param destination
     * @param technicalStops
     * @param mandatoryWaypoints
     */
    public FlightPlan(String flightDesignator, int minStopTime, Aircraft aircraft,
            Airport origin, Airport destination, LinkedList<Airport> technicalStops,
            LinkedList<Node> mandatoryWaypoints, List<Pattern> listPattern) {
        this.flightDesignator = flightDesignator;
        this.minStopTime = minStopTime;
        this.aircraft = aircraft;
        this.origin = origin;
        this.destination = destination;
        this.technicalStops = technicalStops;
        this.mandatoryWaypoints = mandatoryWaypoints;
        this.listPattern = listPattern;
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
        this.listPattern = flight.listPattern;
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
        if (getOrigin().equals(getDestination())) {
            return false;
        }
        if (getTechnicalStops().contains(getOrigin()) || getTechnicalStops().contains(getDestination())) {
            return false;
        }
        for(Node n: getMandatoryWaypoints()){
            if (Double.doubleToLongBits(n.getLatitude())==
                    Double.doubleToLongBits(getOrigin().getLocation().getLatitude()) &&
                Double.doubleToLongBits(n.getLongitude())==
                    Double.doubleToLongBits(getOrigin().getLocation().getLongitude()))
                return false;
            if (Double.doubleToLongBits(n.getLatitude())==
                    Double.doubleToLongBits(getDestination().getLocation().getLatitude()) &&
                Double.doubleToLongBits(n.getLongitude())==
                    Double.doubleToLongBits(getDestination().getLocation().getLongitude()))
                return false;
            for (Airport a : getTechnicalStops()){
                if (Double.doubleToLongBits(n.getLatitude())==
                        Double.doubleToLongBits(a.getLocation().getLatitude()) &&
                    Double.doubleToLongBits(n.getLongitude())==
                        Double.doubleToLongBits(a.getLocation().getLongitude()))
                    return false;
            }
        }

        return getAircraft().validate();
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

    /**
     * @return the aircraft
     */
    public Aircraft getAircraft() {
        return aircraft;
    }

    /**
     * @param aircraft the aircraft to set
     */
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    /**
     * @return the origin
     */
    public Airport getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public Airport getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    /**
     * @return the technicalStops
     */
    public List<Airport> getTechnicalStops() {
        return this.technicalStops;
    }

    /**
     * @param technicalStops the technicalStops to set
     */
    public void setTechnicalStops(List<Airport> technicalStops) {
        this.technicalStops = technicalStops;
    }

    /**
     * @return the mandatoryWaypoints
     */
    public List<Node> getMandatoryWaypoints() {
        return mandatoryWaypoints;
    }

    /**
     * @param mandatoryWaypoints the mandatoryWaypoints to set
     */
    public void setMandatoryWaypoints(List<Node> mandatoryWaypoints) {
        this.mandatoryWaypoints = mandatoryWaypoints;
    }

    /**
     * @return the listPattern
     */
    public List<Pattern> getListPattern() {
        return listPattern;
    }

    /**
     * @param listPattern the listPattern to set
     */
    public void setListPattern(List<Pattern> listPattern) {
        this.listPattern = listPattern;
    }
    
    public String getFlightPlanStringInfo(){
        return "Designator: " + flightDesignator + "\nAirport Origin: " + 
                getOrigin().getIATA() + "\nAirport Destiantion: " +                 
                getDestination().getIATA() + "\nAircraft -> " + 
                this.getAircraft().toStringInfo() + "\n";
    }
   
}
