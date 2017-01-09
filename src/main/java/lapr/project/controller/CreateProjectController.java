/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Project;

/**
 *
 * @author Pedro Fernandes
 */
public class CreateProjectController {
    
    Project project;
    
    public CreateProjectController(){
        project = new Project();
    }
    
    public boolean setProject(String name, String description){
        //project.setIdProject(0); check in db and add 1 to count of projects
        project.setName(name);
        project.setDescription(description);
        
        return project.validate() && insertProjectDataBase(); 
    }
    
    private boolean insertProjectDataBase(){
        // implement connect db
        return true;
    }
    
    public Project getProject(){
        return this.project;
    }
    
    public boolean hasProjectCreated(){
        return this.project!=null;
    }
    
}
