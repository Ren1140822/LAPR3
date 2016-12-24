/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.CabinConfiguration;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AircraftList implements Serializable{

    /**
     * The list of aircrafts.
     */
    private List<Aircraft> aircraftList;

    Aircraft aircraft;

    /**
     * Constructor.
     */
    public AircraftList() {
        this.aircraftList = new LinkedList<>();
    }

    /**
     * Copy constructor.
     *
     * @param list the instance of this class
     */
    public AircraftList(AircraftList list) {
        this.aircraftList = list.aircraftList;
    }

    /**
     * Parameter constructor.
     *
     * @param aircraftList the list of aircrafts
     */
    public AircraftList(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }

    /**
     * Gets the aircraft list.
     *
     * @return the aircraft list
     */
    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    /**
     * Sets the aircraft list.
     *
     * @param aircraftList the aircraft list to set
     */
    public void setAircrafttList(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }

    /**
     * Creates a new instance of aircraft.
     *
     * @return
     */
    public boolean createAircraft() {
        aircraft = new Aircraft();
        return true;
    }

    public boolean setAircraftData(String registration, String company, int nrOfSeatsEcon, int nrOfSeatsCommercial, int NrOfElements) {

        aircraft.setRegistration(registration);
        aircraft.setCabinConfig(new CabinConfiguration(nrOfSeatsEcon, nrOfSeatsCommercial));
        aircraft.setCompany(company);
        aircraft.setNrOfCrewElements(NrOfElements);
        if (aircraft.validate() && validate()) {
            this.aircraftList.add(aircraft);
            return true;
        }
        return false;
    }

    public boolean setAircraftModel(AircraftModel model) {
        aircraft.setAircraftModel(model);
        return true;
    }
    
        
    /**
     * Return the list of aircrafts (string)
     * @return list of aircrafts (strings)
     */
    public List<String> getAircraftsListString() {
        List<String> listString = new LinkedList<>();
        List<Aircraft> list = aircraftList;

        list.stream().forEach((air) -> {
            listString.add(air.toString());
        });
        return listString;
    }

    private boolean validate() {
        return !this.aircraftList.contains(aircraft);
    }
}
