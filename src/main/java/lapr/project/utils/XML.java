/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import lapr.project.model.lists.AirportList;

/**
 *
 * 
 */
public class XML {

    /**
     * Constructor
     */
    public XML() {
    }

    /**
     * export xml airportList
     *
     * @param file
     * @param airportsList
     * @return 
     * @throws java.io.FileNotFoundException 
     */
    public boolean exportXMLAirportList(File file, AirportList airportsList) throws FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(AirportList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(airportsList, new FileWriter(file));
            return true;
        } catch (JAXBException | IOException e) {
                System.err.println(e.getMessage());
            return false;
        }
    }
    
    /**
     * 
     * @param file
     * @return
     * @throws FileNotFoundException 
     */
    public AirportList importXMLAirportList(File file) throws FileNotFoundException {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(AirportList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            AirportList airportsList = (AirportList) jaxbUnmarshaller.unmarshal(file);
            return airportsList;
        } catch (JAXBException ex) { 
            System.err.println(ex);
            return null;
        }
    }

}
