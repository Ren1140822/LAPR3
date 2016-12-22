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
import lapr.project.model.Project;

import lapr.project.model.lists.AircraftModelList;

/**
 * Controller to import aircraft model list
 * @author Pedro Fernandes
 */
public class ImportAircraftModelListController {
    
    Project project;
    
    AircraftModelList aircraftsModelList;
    
    JAXBContext jaxbContext;
    
    public ImportAircraftModelListController(Project project){
        this.project = project;
        aircraftsModelList = project.getAircraftModelList();
    }
    
    /**
     * network imported
     * @param file
     * @return network imported
     * @throws FileNotFoundException 
     */
    public boolean importXMLAircraftModelList(File file) throws FileNotFoundException {
        try {
            jaxbContext = JAXBContext.newInstance(AircraftModelList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            aircraftsModelList = (AircraftModelList) jaxbUnmarshaller.unmarshal(file);
            return !aircraftsModelList.getModelList().isEmpty();
        } catch (JAXBException ex) { 
            System.err.println(ex);
            return false;
        }
    }
    
}
