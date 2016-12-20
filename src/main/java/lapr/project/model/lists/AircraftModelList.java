/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AircraftModel;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AircraftModelList {
    
    /**
     * Instance variables.
     */
    private List<AircraftModel> modelList;

    /**
     * Parameter constructor.
     * @param modelList  the list of aircraft models
     */
    public AircraftModelList(List<AircraftModel> modelList) {
        this.modelList = modelList;
    }
    
    /**
     * Default constructor.
     */
     public AircraftModelList() {
        this.modelList = new LinkedList<>();
    }

     /**
      * Linked list containing the aircraft.
      * @return the model list
      */
    public List<AircraftModel> getModelList() {
        return modelList;
    }

    /**
     * Sets the model list.
     * @param modelList the model list
     */
    public void setModelList(List<AircraftModel> modelList) {
        this.modelList = modelList;
    }
     
     
    public boolean addAircraftModel(AircraftModel model)
    {
        if(validate(model))
        {
            this.modelList.add(model);
            return true;
        }
        return false;
    }
     
    private boolean validate(AircraftModel model)
    {
        return !this.modelList.contains(model);
    }
}
