/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.AirNetwork;
import lapr.project.model.Project;
import lapr.project.model.lists.NodeList;
import lapr.project.model.lists.SegmentList;

/**
 * Controller to import network from file
 * @author Pedro Fernandes
 */
public class ImportNetworkController {
    
    SegmentList segmentsList;
    NodeList nodesList;
    AirNetwork network;
    
    public ImportNetworkController(){
        network = Project.getAirNetwork();
        segmentsList = network.getSegmentList();
        nodesList = network.getNodeList();
    }
    
    public AirNetwork getAirNetwork(){
        return network;
    }
    
    public SegmentList getSegmentList(){
        return segmentsList;
    }
    
    public NodeList getNodeList(){
        return nodesList;
    }
    
    public void importNetwork(String file){
        
        //implementar
        
    }
    
}
