/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.DAL.AirNetworkDAO;
import lapr.project.DAL.AircraftDAO;
import lapr.project.DAL.AircraftModelDAO;
import lapr.project.DAL.AirportDAO;
import lapr.project.DAL.FlightDAO;
import lapr.project.DAL.ProjectDAO;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Project;
import lapr.project.model.lists.AircraftList;
import lapr.project.model.lists.AircraftModelList;
import lapr.project.model.lists.AirportList;
import lapr.project.model.lists.CompareResultsList;
import lapr.project.model.lists.FlightList;
import lapr.project.model.lists.SimulationsList;

/**
 *
 * @author Pedro Fernandes
 */
public class OpenProjectController {

    private Project project;
    private List<Project> listProjects;

    public OpenProjectController() {
        ProjectDAO projectDAO = new ProjectDAO();
        listProjects = projectDAO.getAllProjects();

    }

    public List<Project> getProjectsListByName() {
        return this.listProjects;
    }

    public void setProjectByName(String name) {
        // ????
    }

    public Project getProjectSelected() {
        return this.project;
    }

    public Project getProjectFromDB(int projectID) {
        ProjectDAO projectDAO = new ProjectDAO();
        AirportDAO airportDAO = new AirportDAO();
        AircraftDAO aircraftDAO = new AircraftDAO();
        AirNetworkDAO airnetworkDAO = new AirNetworkDAO();
        AircraftModelDAO modelDAO = new AircraftModelDAO();
        FlightDAO flightDAO = new FlightDAO();
        List<String> projAttributes = projectDAO.getProject(projectID);
        List<Aircraft> aircraftList = aircraftDAO.getListOfAircrafts(String.valueOf(projectID));
        List<Airport> airportList = airportDAO.getListOfAirports(String.valueOf(projectID));
        AirNetwork realAN = airnetworkDAO.getAirNetwork(projectID);
        List<FlightPlan> planList = flightDAO.getFlightPlanList(projectID);
        List<AircraftModel> modelList = modelDAO.getAircraftModelList(projectID);
        Project newProject = new Project(projectID, projAttributes.get(1), projAttributes.get(2), new AircraftList(aircraftList), realAN, new AirportList(airportList), new CompareResultsList(), new FlightList(planList), new AircraftModelList(modelList), new SimulationsList());
        return newProject;
    }

}
