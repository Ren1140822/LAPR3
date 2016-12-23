/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.AircraftModel;
import lapr.project.model.Regime;

/**
 * class that represents a list of aircraft model
 * @author Renato Oliveira and Pedro Fernandes
 */
@XmlRootElement(name="aircraft_list")
@XmlAccessorType(XmlAccessType.FIELD)
public class AircraftModelList implements Serializable{
    
    /**
     * Instance variables.
     */
    @XmlElement(name="aircraft")
    private List<AircraftModel> aircraftsModelList;
    
    /**
     * aircraft model to be added into list
     */
    @XmlTransient
    private AircraftModel aircraftModel;

    /**
     * Parameter constructor.
     * @param modelList  the list of aircraft models
     */
    public AircraftModelList(List<AircraftModel> modelList) {
        this.aircraftsModelList = modelList;
    }
    
    /**
     * Default constructor.
     */
     public AircraftModelList() {
        this.aircraftsModelList = new LinkedList<>();
    }

     /**
      * Linked list containing the aircraft.
      * @return the model list
      */
    public List<AircraftModel> getModelList() {
        return aircraftsModelList;
    }

    /**
     * Sets the model list.
     * @param modelList the model list
     */
    public void setModelList(List<AircraftModel> modelList) {
        this.aircraftsModelList = modelList;
    }
    
    /**
     * 
     * @param id
     * @param description
     * @param maker
     * @param type
     * @param eWeight
     * @param MTOW
     * @param MZFW
     * @param maxPayload
     * @param fuelCapacity
     * @param VMO
     * @param MMO
     * @param wingArea
     * @param wingSpan
     * @param wingCl
     * @param bodyCl
     * @param cDrag
     * @param e
     */
    public void setAircraftModelData(String id, String description, String maker,
            String type,double eWeight, double MTOW, double MZFW, double maxPayload, 
            double fuelCapacity, double VMO, double MMO, double wingArea, 
            double wingSpan, double wingCl, double bodyCl, double cDrag, double e){
        aircraftModel = new AircraftModel();
        aircraftModel.setDescription(description);
        aircraftModel.setE(e);
        aircraftModel.setFuelCapacity(fuelCapacity);
        aircraftModel.setId(id);
        aircraftModel.setMMO(MMO);
        aircraftModel.setMTOW(MTOW);
        aircraftModel.setMZFW(MZFW);
        aircraftModel.setMaker(maker);
        aircraftModel.setMaxPayload(maxPayload);
        aircraftModel.setType(type);
        aircraftModel.setVMO(VMO);
        aircraftModel.setWingArea(wingArea);
        aircraftModel.setWingSpan(wingSpan);
        aircraftModel.setcDrag(cDrag);
        aircraftModel.seteWeight(eWeight);
    }
    
    /**
     * 
     * @param number_motors
     * @param motor
     * @param motor_type
     * @param regimeList 
     */
    public void setAircraftModelMotorization(int number_motors, String motor, String motor_type, 
            List<Regime> regimeList){
        aircraftModel.setMotorization(number_motors, motor, motor_type, regimeList);
    }
     
    /**
     * validate and saves the airport into airportsList
     * @return true if airport is valid and is added, false if not
     */
    public boolean saveAircrcaftModel(){
        return validate() && addAircraftModel();       
    }

    private boolean validate()
    {
        return aircraftModel.validate() && !aircraftsModelList.contains(aircraftModel);
    }
    
    private boolean addAircraftModel(){
        return aircraftsModelList.add(aircraftModel);
    }
}
