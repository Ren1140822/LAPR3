/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import lapr.project.model.AirNetwork;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.Segment;


/**
 * Controller to import network from file
 * @author Pedro Fernandes
 */
public class ImportNetworkController {
    
    Project project;
    AirNetwork network;
    
    JAXBContext jaxbContext;
    
    public ImportNetworkController(Project project){
        this.project = project;
        network = project.getAirNetwork();
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
            network.setSegmentsForJAXB();
            boolean a = !network.getNodeList().isEmpty() 
                    && !network.getSegmentList().isEmpty()
                    && network.generateGraph();
            if(a){ 
                network.setNodeList(removeDuplicatesNodes(network.getNodeList()));
                network.setSegmentList(removeDuplicatesSegments(network.getSegmentList()));
                project.setAirNetwork(network); 
            }            
            return a;
        } catch (JAXBException ex) { 
            System.err.println(ex);
            return false;
        }
    }
    
    
    private List<Node> removeDuplicatesNodes(List<Node> list){
        List<Node> listAux = new LinkedList<>();
        for (Node n : list){
            if(!listAux.contains(n)){
                listAux.add(n);
            }            
        }
        return listAux;
    }
    
    private List<Segment> removeDuplicatesSegments(List<Segment> list){
        List<Segment> listAux = new LinkedList<>();
        for (Segment s : list){
            if(!listAux.contains(s)){
                listAux.add(s);
            }            
        }
        return listAux;
    }
}
