/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AircraftModel;
import lapr.project.model.Project;
import lapr.project.model.lists.AircraftList;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddAircraftController {

    AircraftList aircraftList;
    AircraftModel model;

    public AddAircraftController() {
        aircraftList = Project.aircraftList;
    }

    public boolean createAircraft() {
        return aircraftList.createAircraft();
    }

    public boolean setAircraftData(String registration, String company, int nrOfSeatsEcon, int nrOfSeatsCommercial, int NrOfElements) {
        return aircraftList.setAircraftData(registration, company, nrOfSeatsEcon, nrOfSeatsCommercial, NrOfElements);
    }

    public boolean setAircraftModel(String aircraftModelID)
    {
        return true;
    }
    public List<String> getListOfAircraftModels()
    {
           List<AircraftModel> list =  Project.getModelList().getModelList();
           LinkedList<String> modelListInString = new LinkedList<>();
           for(AircraftModel model:list)
           {
               modelListInString.add("");
           }
           return modelListInString;
    }
    
    private void getModelByID(String id)
    {
        List<AircraftModel> list =  Project.getModelList().getModelList();
        for(AircraftModel model : list)
        {
            
        }
    }
}
