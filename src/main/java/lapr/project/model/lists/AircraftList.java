/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import lapr.project.model.Aircraft;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AircraftList {
      /**
     * The list of aircrafts.
     */
    LinkedList<Aircraft>aircraftList;

    /**
     * Constructor.
     */
    public AircraftList() {
        this.aircraftList = new LinkedList<>();
    }
    
    /**
     * Copy constructor.
     * @param list the instance of this class
     */
    public AircraftList(AircraftList list)
    {
        this.aircraftList = list.aircraftList;
    }
    
    /**
     * Parameter constructor.
     * @param aircraftList the list of aircrafts
     */
    public AircraftList(LinkedList<Aircraft>aircraftList)
    {
        this.aircraftList = aircraftList;
    }

    /**
     * Gets the aircraft list.
     * @return the aircraft list
     */
    public LinkedList<Aircraft> getAirportList() {
        return aircraftList;
    }

    /**
     * Sets the aircraft list.
     * @param aircraftList the aircraft list to set
     */
    public void setAirportList(LinkedList<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }
    
    
}
