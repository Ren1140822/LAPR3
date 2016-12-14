package lapr.project.model.lists;

import java.util.LinkedList;
import lapr.project.model.Airport;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AirportList {
 
    /**
     * The list of airports.
     */
    LinkedList<Airport> airportList;

    /**
     * Constructor.
     */
    public AirportList() {
        this.airportList = new LinkedList<>();
    }
    
    /**
     * Copy constructor.
     * @param list the instance of this class
     */
    public AirportList(AirportList list)
    {
        this.airportList = list.airportList;
    }
    
    /**
     * Parameter constructor.
     * @param airportList the list of airports
     */
    public AirportList(LinkedList<Airport> airportList)
    {
        this.airportList = airportList;
    }

    /**
     * Gets the airport list.
     * @return the airport list
     */
    public LinkedList<Airport> getAirportList() {
        return airportList;
    }

    /**
     * Sets the airport list.
     * @param airportList the airport list to set
     */
    public void setAirportList(LinkedList<Airport> airportList) {
        this.airportList = airportList;
    }
    
    
}
