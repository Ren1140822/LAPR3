/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.DAL.AirNetworkDAO;
import lapr.project.DAL.AircraftDAO;
import lapr.project.DAL.AircraftModelDAO;
import lapr.project.DAL.AirportDAO;
import lapr.project.DAL.FlightDAO;
import lapr.project.DAL.ProjectDAO;
import lapr.project.model.AirNetwork;
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
public class CreateProjectController {

    private Project project;

    public CreateProjectController() {
    }

    public boolean setProject(String name, String description) {
        project = new Project();
        project.setName(name);
        project.setDescription(description);

        return project.validate();
    }

    public boolean insertProjectDataBase() {
        ProjectDAO projectDAO = new ProjectDAO();
        projectDAO.createProject(project);
        return projectDAO.saveFullProject(project);

    }

    public Project getProject() {
        return this.project;
    }

    public boolean hasProjectCreated() {
        return this.project != null;
    }

}
