/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.DAL.ProjectDAO;
import lapr.project.model.Project;

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
