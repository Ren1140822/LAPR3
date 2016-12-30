package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.Airport;
import lapr.project.model.Node;

/**
 * class that represents a list of airports
 * @author Renato Oliveira and Pedro Fernandes
 */
@XmlRootElement(name="Network")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirportList implements Serializable{
 
    /**
     * The list of airports.
     */
    @XmlElementWrapper(name="airport_list")
    @XmlElement(name="airport")
    private List<Airport> airportsList;
    
    /**
     * node to be added into list
     */
    @XmlTransient
    private Airport node;
    
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
        this.airportsList = list.getAirportList();
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
     * Gets the node list.
     * @return the node list
     */
    public List<Airport> getAirportList() {
        return airportsList;
    }
    
      /**
     * Return the list of airports (string)
     * @return list of airports (strings)
     */
    public List<String> getAirportListString() {
        List<String> listString = new LinkedList<>();
        List<Airport> list = airportsList;

        for(Airport air : list){
            listString.add(air.toString());
        }
        return listString;
    }
    

    /**
     * Sets the node list.
     * @param airportList the node list to set
     */
    public void setAirportList(List<Airport> airportList) {
        this.airportsList = airportList;
    }
    
    /**
     * create Airport
     */
    public void newAirport(){
        node = new Airport();
    }
    
    /**
     * sets data of the node
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
        node.setIATA(IATA);
        node.setName(name);
        node.setTown(town);
        node.setCountry(country);
        node.setLocation(latitude, longitude, altitude);
    }
    
    /**
     * validate and saves the node into airportsList
     * @return true if node is valid and is added, false if not
     */
    public boolean saveAirport(){
        return validate() && addAirport();       
    }
    
    /**
     * validate if node is valid and do not exist in the list
     * @return true if node is valid and do not exist in the list, false if not
     */
    private boolean validate(){
        return node.validate() && !airportsList.contains(node);
    }
    
    /**
     * add the node into the list
     * @return true if node is added, false if not
     */
    private boolean addAirport(){
        return airportsList.add(node);
    }
    
     /**
     * Gets airport correspondent to the node if exists
     * @param node node with latitude and longitude
     * @return airport with same latitude and longitude
     */
    public Airport getAirportNode(Node node){
        for(Airport airportFind: airportsList){
            if (Double.doubleToLongBits(node.getLatitude())==
                    Double.doubleToLongBits(airportFind.getLocation().getLatitude()) &&
                Double.doubleToLongBits(node.getLongitude())==
                    Double.doubleToLongBits(airportFind.getLocation().getLongitude()))
                return airportFind;
        }
        return null;
    }
    
}
