/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AircraftModel;
import lapr.project.model.Projects.Project;
import lapr.project.model.lists.AircraftList;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddAircraftController {

    /**
     * Instance variables.
     */
    AircraftList aircraftList;
    AircraftModel model;

    /**
     * Default constructor.
     */
    public AddAircraftController() {
        aircraftList = Project.getAircraftListReference();
    }

    /**
     * Creates a new aircraft.
     * @return true if created.
     */
    public boolean createAircraft() {
        return aircraftList.createAircraft();
    }

    /**
     * Sets aircraft data.
     * @param registration the registration id
     * @param company the company
     * @param nrOfSeatsEcon nr of seats economic
     * @param nrOfSeatsCommercial nr of seats commercial
     * @param NrOfElements nr of crew elements
     * @return  true if data is set, false otherwise
     */
    public boolean setAircraftData(String registration, String company, int nrOfSeatsEcon, int nrOfSeatsCommercial, int NrOfElements) {
        return aircraftList.setAircraftData(registration, company, nrOfSeatsEcon, nrOfSeatsCommercial, NrOfElements);
    }

    /**
     * Checks if model is set.
     * @return true if set, null pointer exception otherwise.
     */
    public boolean hasModel() {
        if (this.model == null) {
            throw new NullPointerException("Model not set.");
        }
        return true;
    }

    /**
     * Sets the aircrfat model.
     * @param aircraftModelID the id of the aircraft model
     * @return true if all OK
     */
    public boolean setAircraftModel(String aircraftModelID) {
        getModelByID(aircraftModelID);
        if (model != null) {
            return aircraftList.setAircraftModel(this.model);
        }
        return false;
    }

    /**
     * Gets the list of aircraft models in string form.
     * @return the list of strings
     */
    public List<String> getListOfAircraftModels() {
       
        List<AircraftModel> list = Project.getModelList().getModelList();
        LinkedList<String> modelListInString = new LinkedList<>();
        for (AircraftModel model : list) {
            modelListInString.add(model.getId());
        }

        return modelListInString;
    }

    /**
     * Gets a model by his ID
     * @param id  the string ID
     */
    private void getModelByID(String id) {
        List<AircraftModel> list = Project.getModelList().getModelList();
        for (AircraftModel model : list) {
            if (model.getId().equals(id)) {
                this.model = model;
            }
        }
    }
}
