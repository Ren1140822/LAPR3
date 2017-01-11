/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Project;
import lapr.project.utils.DAL;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class DALController {

    Project p;
    ImportAirportController cont;
    ImportAircraftModelListController contAir;
    ImportNetworkController ncont;

    public DALController() {
        p = new Project();
        cont = new ImportAirportController(p);
        ncont = new ImportNetworkController(p);
        contAir = new ImportAircraftModelListController(p);
    }

    public void test() throws FileNotFoundException, SQLException {
        cont.importXMLAirportList(new File("src/main/resources/TestSet02_Airports.xml"));
        DAL dal = new DAL();
         //dal.WriteAirportsToDatabase(p.getAirportList().getAirportList(), 1);
       List<Airport> aptest = dal.getListOfAirports("1");
        ncont.importXMLNetwork(new File("src/main/resources/TestSet02_Network.xml"));
      // dal.WriteAirNetworkToDatabase("1", ncont.network.getDescription());
        AirNetwork tmp = dal.getAirNetwork("1");
//         dal.WriteNodesToDatabase(ncont.network.getNodeList(),   Integer.parseInt(tmp.getId()));
//          dal.WriteSegmentsToDatabase(ncont.network.getSegmentList(),  Integer.parseInt(tmp.getId()));
          //AirNetwork tmp2 = dal.getAirNetwork("1");

          contAir.importXMLAircraftModelList(new File("src/main/resources/TestSet02_Aircraft.xml"));
        dal.WriteAircraftModelsToDatabase(contAir.aircraftsModelList.getModelList(), 1);
         List<AircraftModel> listModel = dal.getAircraftModelList(1);
//        
        FlightPlan plan = new FlightPlan();
        plan.setOrigin(aptest.get(2));
        plan.setDestination(aptest.get(5));
        List<FlightPlan> plans = new LinkedList<>();
        plan.getTechnicalStops().add(aptest.get(10));
        plan.getTechnicalStops().add(aptest.get(13));
        plan.setAircraft(new Aircraft());
        Aircraft ac = new Aircraft();
        ac.setAircraftModel(listModel.get(1));
        List<Aircraft> listACr = new LinkedList<>();
        listACr.add(ac);
        dal.WriteAircraftsToDatabase(listACr, 1);
        plan.getMandatoryWaypoints().add(tmp.getNodeList().get(2));
           plan.getMandatoryWaypoints().add(tmp.getNodeList().get(7));
        plans.add(plan);
       
        dal.WriteFlightPlansToDatabase(plans, 1);
    }
}
