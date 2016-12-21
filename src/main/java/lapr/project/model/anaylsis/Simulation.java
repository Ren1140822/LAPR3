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
    //195 libras per person
    private double cargoLoad;
    private double totalWeight;
    private Aircraft aircraft;
    private List<SegmentResult> list;
    private ResultPath bestResultPath;
    
    private static final double TOTAL_WEIGHT=0;
    Node startAirport, endAirport;
    
    public Simulation(Node startNode, Node endNode, int passengers, int crew, double cargoLoad){
        this.passengers=passengers;
        this.crew=crew;
        this.cargoLoad=cargoLoad;
        this.startAirport=startNode;
        this.endAirport=endNode;
        this.totalWeight=TOTAL_WEIGHT;
        this.list=new ArrayList<>();
    } 
    
    public List<SegmentResult> getList(){
        return list;
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
        return list.add(new SegmentResult());
    }
   
}
