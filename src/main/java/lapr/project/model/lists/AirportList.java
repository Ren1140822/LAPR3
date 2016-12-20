package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Airport;

/**
 * class that represents a list of airports
 * @author Renato Oliveira and Pedro Fernandes
 */
@XmlRootElement(name="Network")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirportList {
 
    /**
     * The list of airports.
     */
    @XmlElementWrapper(name="airport_list")
    @XmlElement(name="airport")
    private List<Airport> airportsList;
    
    /**
     * airport to be added into list
     */
    @XmlTransient
    private Airport airport;
    
    /**
     * Constructor.
     */
    public AirportList() {
        this.airportsList = new LinkedList<>();
    }
    
    /**
     * Copy constructor.
     * @param list the instance of this class
     */
    public AirportList(AirportList list)
    {
        this.airportsList = list.airportsList;
    }
    
    /**
     * Parameter constructor.
     * @param airportList the list of airports
     */
    public AirportList(List<Airport> airportList)
    {
        this.airportsList = airportList;
    }

    /**
     * Gets the airport list.
     * @return the airport list
     */
    public List<Airport> getAirportList() {
        return airportsList;
    }

    /**
     * Sets the airport list.
     * @param airportList the airport list to set
     */
    public void setAirportList(List<Airport> airportList) {
        this.airportsList = airportList;
    }
    
    /**
     * create Airport
     */
    public void newAirport(){
        airport = new Airport();
    }
    
    /**
     * sets data of the airport
     * @param IATA
     * @param name
     * @param town
     * @param country
     * @param latitude
     * @param longitude
     * @param altitude 
     */
    public void setAirportData(String IATA, String name, String town, String country,
            double latitude, double longitude, int altitude){
        airport.setIATA(IATA);
        airport.setName(name);
        airport.setTown(town);
        airport.setCountry(country);
        airport.setLocation(latitude, longitude, altitude);
    }
    
    /**
     * validate and saves the airport into airportsList
     * @return true if airport is valid and is added, false if not
     */
    public boolean saveAirport(){
        return validate() && addAirport();       
    }
    
    /**
     * validate if airport is valid and do not exist in the list
     * @return true if airport is valid and do not exist in the list, false if not
     */
    private boolean validate(){
        return airport.validate() && !airportsList.contains(airport);
    }
    
    /**
     * add the airport into the list
     * @return true if airport is added, false if not
     */
    private boolean addAirport(){
        return airportsList.add(airport);
    }
    
}
