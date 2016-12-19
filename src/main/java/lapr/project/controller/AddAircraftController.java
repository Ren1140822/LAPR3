/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Project;
import lapr.project.model.lists.AircraftList;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddAircraftController {

    AircraftList aircraftList;

    public AddAircraftController() {
        aircraftList = Project.aircraftList;
    }

    public boolean createAircraft() {
        return aircraftList.createAircraft();
    }

    public boolean setAircraftData(String registration, String company, int nrOfSeatsEcon, int nrOfSeatsCommercial, int NrOfElements) {
        return aircraftList.setAircraftData(registration, company, nrOfSeatsEcon, nrOfSeatsCommercial, NrOfElements);
    }

}
