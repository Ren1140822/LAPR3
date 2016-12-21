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
import lapr.project.model.AirNetwork;

import lapr.project.model.Projects.Project;

/**
 * Controller to import network from file
 * @author Pedro Fernandes
 */
public class ImportNetworkController {
    
    AirNetwork network;
    
    JAXBContext jaxbContext;
    
    public ImportNetworkController(){
        network = Project.getAirNetwork();
    }
    
    /**
     * network imported
     * @param file
     * @return network imported
     * @throws FileNotFoundException 
     */
    public boolean importXMLNetwork(File file) throws FileNotFoundException {
        try {
            jaxbContext = JAXBContext.newInstance(AirNetwork.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            network = (AirNetwork) jaxbUnmarshaller.unmarshal(file);
            return !network.getNodeList().isEmpty() && !network.getSegmentList().isEmpty();
        } catch (JAXBException ex) { 
            System.err.println(ex);
            return false;
        }
    }
    
}
