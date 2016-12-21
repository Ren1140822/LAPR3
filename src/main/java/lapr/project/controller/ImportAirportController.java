/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lapr.project.model.Projects.Project;
import lapr.project.model.lists.AirportList;

/**
 * Controller to import airports
 * @author Pedro Fernandes
 */
public class ImportAirportController {
    
    AirportList airportsList;
    
    JAXBContext jaxbContext;
    
    public ImportAirportController(){
        airportsList = Project.getAirportListReference();
    }
    
    /**
     * airport list imported
     * @param file
     * @return airport list imported
     * @throws FileNotFoundException 
     */
    public boolean importXMLAirportList(File file) throws FileNotFoundException {
        try {
            jaxbContext = JAXBContext.newInstance(AirportList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            airportsList = (AirportList) jaxbUnmarshaller.unmarshal(file);
            return !airportsList.getAirportList().isEmpty();
        } catch (JAXBException ex) { 
            System.err.println(ex);
            return false;
        }
    }
    
}
