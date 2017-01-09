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
public class EditDataProjectController {
    
    private Project project;    
    
    public EditDataProjectController(Project project){
        this.project=project;
    }
    
    public boolean setDataProject(String name, String desc){
        project.setName(name);
        project.setDescription(desc);
        
        return project.validate() && editProjectDataBase();        
    }
    
    public int getIdProject(){
        return project.getIdProject();
    }
    
    public String getNameProject(){
        return project.getName();
    }
    
    public String getDescriptionProject(){
        return project.getDescription();
    }
    
    private boolean editProjectDataBase(){
        // implement connect db
        return true;
    }
    
}
