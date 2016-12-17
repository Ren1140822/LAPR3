/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Project;
import lapr.project.model.lists.AirportList;

/**
 * Controller to import airports
 * @author Pedro Fernandes
 */
public class ImportAirportController {
    
    AirportList airportsList;
    
    public ImportAirportController(){
        airportsList = Project.airportList;
    }
    
    public void ImportAirportList(String file){
        
        //implementar
        
    }
    
}
