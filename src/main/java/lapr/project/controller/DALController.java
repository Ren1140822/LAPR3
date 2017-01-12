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
import lapr.project.DAL.ProjectDAO;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Pattern;
import lapr.project.model.Project;
import lapr.project.utils.DAL;

/**
 *
 * @author Renato Oliveira 11pid0822@isep.ipp.pt
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

    public void test(int pid) throws FileNotFoundException, SQLException {
        ProjectDAO dao = new ProjectDAO();
       
       
        dao.createProject(p);
        pid = dao.getProjectID();
        cont.importXMLAirportList(new File("src/main/resources/TestSet02_Airports.xml"));
        DAL dal = new DAL();
         dal.WriteAirportsToDatabase(p.getAirportList().getAirportList(), pid);
       List<Airport> aptest = dal.getListOfAirports(String.valueOf(pid));
        ncont.importXMLNetwork(new File("src/main/resources/TestSet02_Network.xml"));
       dal.WriteAirNetworkToDatabase(pid, ncont.network.getDescription());
        AirNetwork tmp = dal.getAirNetwork(pid);
         dal.WriteNodesToDatabase(ncont.network.getNodeList(),   Integer.parseInt(tmp.getId()));
          dal.WriteSegmentsToDatabase(ncont.network.getSegmentList(),  Integer.parseInt(tmp.getId()));
          AirNetwork tmp2 = dal.getAirNetwork(pid);

          contAir.importXMLAircraftModelList(new File("src/main/resources/TestSet02_Aircraft.xml"));
        dal.WriteAircraftModelsToDatabase(contAir.aircraftsModelList.getModelList(), pid);
         List<AircraftModel> listModel = dal.getAircraftModelList(pid);
    
        FlightPlan plan = new FlightPlan();
        plan.setOrigin(aptest.get(pid));
        plan.setDestination(aptest.get(5));
        List<FlightPlan> plans = new LinkedList<>();
        plan.getTechnicalStops().add(aptest.get(10));
        plan.getTechnicalStops().add(aptest.get(13));
        plan.setAircraft(new Aircraft());
        Aircraft ac = new Aircraft();
        ac.setAircraftModel(listModel.get(1));
        List<Aircraft> listACr = new LinkedList<>();
        listACr.add(ac);
        dal.WriteAircraftsToDatabase(listACr,pid);
        plan.getMandatoryWaypoints().add(tmp2.getNodeList().get(2));
           plan.getMandatoryWaypoints().add(tmp2.getNodeList().get(7));
           Pattern pt = new Pattern();
           plan.getListPattern().add(pt);
        plans.add(plan);
       
        dal.WriteFlightPlansToDatabase(plans, pid);
    }
}
