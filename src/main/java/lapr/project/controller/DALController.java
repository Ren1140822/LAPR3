/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import lapr.project.model.AirNetwork;
import lapr.project.model.Project;
import lapr.project.utils.DAL;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class DALController {
    Project p;
    ImportAirportController cont ;
    ImportNetworkController ncont;
    public DALController()
    {
         p= new Project();
       cont = new ImportAirportController(p);
       ncont = new ImportNetworkController(p);
    }
    
    public void test() throws FileNotFoundException
    {
        cont.importXMLAirportList(new File("src/main/resources/TestSet02_Airports.xml"));
        DAL dal = new DAL();
       // dal.WriteAirportsToDatabase(p.getAirportList().getAirportList(), 1);
       // List<Airport> aptest = dal.getListOfAirports("1");
       ncont.importXMLNetwork(new File("src/main/resources/TestSet02_Network.xml"));
       dal.WriteAirNetworkToDatabase("1", ncont.network.getDescription());
       AirNetwork tmp = dal.getAirNetwork("1");
         dal.WriteNodesToDatabase(ncont.network.getNodeList(),   Integer.parseInt(tmp.getId()));
       dal.WriteSegmentsToDatabase(ncont.network.getSegmentList(),  Integer.parseInt(tmp.getId()));
        AirNetwork tmp2 = dal.getAirNetwork("1");
    }
}
