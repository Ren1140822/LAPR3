/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Aircraft;
import lapr.project.model.Node;

/**
 *
 * @author Diana Silva
 */
public class Simulation{
    private int passengers, crew;
    private double cargoLoad;
    private double totalWeight;
    private Aircraft aircraft;
    private List<SegmentResult> segmentsList;
    private ResultPath bestResultPath;
    
    private static final double DEFAULT_VALUE=0;
    
    /**
     * constructor
     */
    public Simulation(){
        this.passengers=(int) DEFAULT_VALUE;
        this.crew=(int) DEFAULT_VALUE;
        this.cargoLoad=DEFAULT_VALUE;
        this.totalWeight=DEFAULT_VALUE;
        this.aircraft=new Aircraft();
        this.segmentsList=new ArrayList<>();
        this.bestResultPath=new ResultPath();
    }
    
    public Simulation(Node startNode, Node endNode, Aircraft aircraft, int passengers, int crew, double cargoLoad){
        this.passengers=passengers;
        this.crew=crew;
        this.cargoLoad=cargoLoad;
        this.aircraft=aircraft;
        this.totalWeight=calculateTotalWeight();
        this.segmentsList=new ArrayList<>();
        this.bestResultPath=new ResultPath(startNode, endNode);
    } 
    
    public Simulation(Node startNode, Node endNode, Aircraft aircraft){
        this.passengers=(int) DEFAULT_VALUE;
        this.crew=(int) DEFAULT_VALUE;
        this.cargoLoad=DEFAULT_VALUE;
        this.totalWeight=DEFAULT_VALUE;
        this.aircraft=aircraft;
        this.segmentsList=new ArrayList<>();
        this.bestResultPath=new ResultPath(startNode,endNode);
    }
    
    /**
     * Return the segments of simulation
     * @return segments of result
     */
    public List<SegmentResult> getSegmentsList(){
        return segmentsList;
    }
    
     /**
     * @param list the segmentsList to set
     */
    public void setSegmentsList(List<SegmentResult> list) {
        this.segmentsList = list;
    }

    /** Gets the number of passengers
     * @return the passengers
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Sets the number of passengers
     * @param passengers the passengers to set
     */
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    /**
     * Get the number of cabine crew members
     * @return the crew
     */
    public int getCrew() {
        return crew;
    }

    /**
     * Sets the number of cabine crew members
     * @param crew the crew to set
     */
    public void setCrew(int crew) {
        this.crew = crew;
    }

    /**
     * Gets the cargo load
     * @return the cargoLoad
     */
    public double getCargoLoad() {
        return cargoLoad;
    }

    /**
     * Sets the cargo load
     * @param cargoLoad the cargoLoad to set
     */
    public void setCargoLoad(double cargoLoad) {
        this.cargoLoad = cargoLoad;
    }

    /**
     * Gets the aircraft of flight
     * @return the aircraft
     */
    public Aircraft getAircraft() {
        return aircraft;
    }

    /**
     * Sets the aircraft of flight
     * @param aircraft the aircraft to set
     */
    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    /**
     * @return the totalWeight
     */
    public double getTotalWeight() {
        return totalWeight;
    }

    /**
     * @param totalWeight the totalWeight to set
     */
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
    
    
    public boolean addSegmentResult(){
        return getSegmentsList().add(new SegmentResult());
    }

    public boolean validate() {
        boolean v1=this.passengers!=0 && this.crew!=0 &&
                this.cargoLoad!=0 && this.totalWeight!=0 &&
                this.aircraft!=null && this.getSegmentsList().isEmpty() && getBestResultPath()!=null;
        boolean v2= aircraft.validate() && getBestResultPath().validate();
        
        return v1 && v2;
    }

    private double calculateTotalWeight(){
        //195 libras per person
        return passengers*195+crew*195+cargoLoad; /**(falta combustivel)**/
    }

    /**
     * @return the bestResultPath
     */
    public ResultPath getBestResultPath() {
        return bestResultPath;
    }

    /**
     * @param bestResultPath the bestResultPath to set
     */
    public void setBestResultPath(ResultPath bestResultPath) {
        this.bestResultPath = bestResultPath;
    }
}
