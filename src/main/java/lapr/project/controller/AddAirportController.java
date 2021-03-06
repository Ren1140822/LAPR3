/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Project;
import lapr.project.model.lists.AirportList;

/**
 * Controller to add airports
 * @author Pedro Fernandes
 */
public class AddAirportController {
    
    private Project project;
    AirportList airportsList;
    
    public AddAirportController(Project project){
        this.project = project;
        airportsList = project.getAirportList();
    }
    
    public void setAirportData(String IATA, String name, String town, String country,
            double latitude, double longitude, int altitude){
        airportsList.newAirport();
        airportsList.setAirportData(IATA, name, town, country, latitude, longitude, altitude);
    }
    
    public boolean saveAirport(){
        return airportsList.saveAirport();
    }
    
}
