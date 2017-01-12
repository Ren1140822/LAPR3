/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Project;

/**
 *
 * @author Pedro Fernandes
 */
public class CopyProjectController {
    
    private Project project;
    private List<String> listProjects;
    
    public CopyProjectController(){
        listProjects = new LinkedList<>();// implement from DAL
    }
    
    public List<String> getProjectsListByName(){
        return this.listProjects;
    }
    
    public Project getProjectSelected(){
        return this.project;
    }
    
}
