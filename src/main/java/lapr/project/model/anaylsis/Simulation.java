/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.Objects;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.Node;
import lapr.project.model.lists.AirportList;
import lapr.project.model.physics.AircraftAlgorithms;
import lapr.project.model.physics.PhysicsAlgorithms;

/**
 *
 * @author Diana Silva
 */
public class Simulation{
    /**
     * number of passengers and members crew of simulation flight
     */
    private int passengers, crew;
    /**
     * cargoLoad of simulation flight
     */
    private double cargoLoad;
    
    /**
     * Fuel loaded in aircraft (g)
     */
    private double fuelWeight;
    
    /**
     * total weight (g)
     */
    private double totalWeight;
    
    /**
     * aircraft of simulation flight
     */
    private Aircraft aircraft;
    /**
     * result of the most ecological path
     */
    private EcologicPathResult ecologicResultPath;
    /**
     * result of the fastest path
     */
    private FastestPathResult fastestResultPath;
    /**
     * result of the shortest path
     */
    private ShortestPathResult shortestResultPath;
    /**
     * default value
     */
    private static final double DEFAULT_VALUE=0;  
    
    /**
     * Start airport of simulation flight
     */
    private Airport startAirport;
    
    /**
     * End airport of simulation flight
     */
    private Airport endAirport;
    
    /**
     * Id of simulation
     */
    private int counterCode=0;
    
    /**
     * Constructor
     */
    public Simulation(){
        this.startAirport=new Airport();
        this.endAirport=new Airport();
        this.passengers=(int) DEFAULT_VALUE;
        this.crew=(int) DEFAULT_VALUE;
        this.cargoLoad=DEFAULT_VALUE;
        this.totalWeight=DEFAULT_VALUE;
        this.fuelWeight=DEFAULT_VALUE;
        this.aircraft=new Aircraft();  
        counterCode++;
    }
    
    /**
     * Constructor
     * @param startAirport the origin of flight simulated
     * @param endAirport the destination of flight simulated
     */
    public Simulation(Airport startAirport, Airport endAirport){
        this.startAirport=startAirport;
        this.endAirport=endAirport;
        this.passengers=(int) DEFAULT_VALUE;
        this.crew=(int) DEFAULT_VALUE;
        this.cargoLoad=DEFAULT_VALUE;
        this.totalWeight=DEFAULT_VALUE;
        this.fuelWeight=DEFAULT_VALUE;
        this.aircraft=new Aircraft();  
        counterCode++;
    }  
    
     /**
     * constructor
     * @param passengers number of passengers
     * @param crew number of crew members
     * @param cargoLoad cargo load (kg)
     * @param totalWeight total weight (kg)
     * @param fuelWeight fuel weight (kg)
     * @param aircraft aircraft 
     */
    public Simulation(int passengers, int crew, double cargoLoad, double totalWeight, double fuelWeight, Aircraft aircraft){
        this.startAirport=new Airport();
        this.endAirport=new Airport();
        this.passengers=passengers;
        this.crew=crew;
        this.cargoLoad=cargoLoad*1000;
        this.totalWeight=totalWeight*1000;
        this.fuelWeight=fuelWeight*1000;
        this.aircraft=aircraft; 
        counterCode++;
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

    /**
     * @return the ecologicResultPath
     */
    public EcologicPathResult getEcologicResultPath() {
        return ecologicResultPath;
    }

    /**
     * @param ecologicResultPath the ecologicResultPath to set
     */
    public void setEcologicResultPath(EcologicPathResult ecologicResultPath) {
        this.ecologicResultPath = ecologicResultPath;
    }

    /**
     * @return the fastestResultPath
     */
    public FastestPathResult getFastestResultPath() {
        return fastestResultPath;
    }

    /**
     * @param fastestResultPath the fastestResultPath to set
     */
    public void setFastestResultPath(FastestPathResult fastestResultPath) {
        this.fastestResultPath = fastestResultPath;
    }

    /**
     * @return the shortestResultPath
     */
    public ShortestPathResult getShortestResultPath() {
        return shortestResultPath;
    }

    /**
     * @param shortestResultPath the shortestResultPath to set
     */
    public void setShortestResultPath(ShortestPathResult shortestResultPath) {
        this.shortestResultPath = shortestResultPath;
    }
    
      /**
     * @return the startAirport
     */
    public Airport getStartAirport() {
        return startAirport;
    }

    /**
     * @param startAirport the startAirport to set
     */
    public void setStartAirport(Airport startAirport) {
        this.startAirport = startAirport;
    }

    /**
     * @return the endAirport
     */
    public Airport getEndAirport() {
        return endAirport;
    }

    /**
     * @param endAirport the endAirport to set
     */
    public void setEndAirport(Airport endAirport) {
        this.endAirport = endAirport;
    }

    /**
     * @return the counterCode
     */
    public int getCounterCode() {
        return counterCode;
    }
    
    /**
     * Sets data needed to the simulation 
     * @param aircraft aircraft of flight
     * @param passengers number of passengers
     * @param crew number of crew members
     * @param cargoLoad cargo load (kg)
     * @param fuelLoad weight of fuel (kg)
     */
    public void setData(Aircraft aircraft, int passengers, int crew, double cargoLoad, double fuelLoad){
        this.aircraft=aircraft;
        this.passengers=passengers;
        this.crew=crew;
        this.cargoLoad=cargoLoad*1000;
        this.fuelWeight=fuelWeight*1000;
        this.totalWeight=calculateInitialWeight();
    }

    /**
     * Calculates the initial weight of aircraft
     * @return the initial weight of aircraft (kg)
     */
    private double calculateInitialWeight(){
       return AircraftAlgorithms.calculateInitialWeight(passengers, crew,
               cargoLoad, fuelWeight, aircraft.getAircraftModel().geteWeight())
               /1000;
    }
    
    /**
     * @return the fuelWeight
     */
    public double getFuelWeight() {
        return fuelWeight;
    }

    /**
     * @param fuelWeight the fuelWeight to set
     */
    public void setFuelWeight(double fuelWeight) {
        this.fuelWeight = fuelWeight;
    }
  
    /**
     * Get air density node
     * @param airport
     * @return 
     */
    public double getAirdensityNode(Airport airport){
        return PhysicsAlgorithms.calculateAirDensity(1, 1);
    }
    
    /**
     * Gets the start node of simulated flight
     * @param net airnetwork of active project
     * @return start node
     */
    public Node getStartNode(AirNetwork net){
        return net.getAirportNode(startAirport);
    }

      /**
     * Gets the end node of simulated flight
     * @param net airnetwork of active project
     * @return end node
     */
    public Node getEndNode(AirNetwork net){
        return net.getAirportNode(endAirport);
    }
    
    /**
     * Sets the start node of flight
     * @param startNode origin of flight
     * @param list airport list of active project
     */
    public void setStartNode(Node startNode, AirportList list){
        this.startAirport=list.getAirportNode(startNode);
    }
    
        /**
     * Sets the start node of flight
     * @param endNode destination of flight
     * @param list airport list of active project
     */
    public void setEndNode(Node endNode, AirportList list){
        this.endAirport=list.getAirportNode(endNode);
    }
    
     /**
     * Creates all best path simulation
     * @param startAirport start airport of simulation
     * @param endAirport end airport of simulation
     */
    public void createAllPathSimulation(Airport startAirport, Airport endAirport){
        this.shortestResultPath=new ShortestPathResult(startAirport,endAirport);
        this.fastestResultPath=new FastestPathResult(startAirport, endAirport);
        this.ecologicResultPath=new EcologicPathResult(startAirport,endAirport);
    }
    
    /**
     * Creates a best path simulation
     * @param startAirport start airport of simulation
     * @param endAirport end airport of simulation
     * @param type type of path to be simulated
     */
    public void createPathSimulation(Airport startAirport, Airport endAirport, TypePath type){
    
        TypePath p=type;
        switch(p){
            case ALL:
                this.shortestResultPath=new ShortestPathResult(startAirport,endAirport);
                this.fastestResultPath=new FastestPathResult(startAirport, endAirport);
                this.ecologicResultPath=new EcologicPathResult(startAirport,endAirport);
            case SHORTEST_PATH:
                this.shortestResultPath=new ShortestPathResult(startAirport,endAirport);
            case FASTEST_PATH:
                this.fastestResultPath=new FastestPathResult(startAirport, endAirport);
            case ECOLOGIC_PATH:
            this.ecologicResultPath=new EcologicPathResult(startAirport, endAirport);
            default:
                this.shortestResultPath=new ShortestPathResult(startAirport,endAirport);
        }
    }
    
    /**
     * Validates simulation 
     * @return true if all data is valid, false if not
     */
     public boolean validate() {
        boolean v1= validateAircraftRelatedData();
        boolean v2= ecologicResultPath.validate() || fastestResultPath.validate() 
                || shortestResultPath.validate();
        
        return v1 && v2;
    }
     
     /**
      * Validates aircraft related data (nr passengers/crew, weight, fuel capacity)
      * @return true if data related to the aircraft is valid, false if not
      */
     public boolean validateAircraftRelatedData(){
         return this.passengers<=aircraft.getCabinConfig().getTotalSeats() &&
                this.crew<=aircraft.getNrOfCrewElements() && 
                this.fuelWeight<=aircraft.getAircraftModel().getFuelCapacity()
                && Double.doubleToLongBits(totalWeight)<=aircraft.getAircraftModel().getMTOW() &&
                aircraft.validate();
     }

    /**
     * @return the number of simulations created
     */
    public int getNumberSimulationsCreated() {
        return getCounterCode();
    }
    
     /**
     * Checks if two object are equal.
     *
     * @param otherObject the other object
     * @return true if equal
     */
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        if (this == otherObject) {
            return true;
        }
        Simulation otherSimulation = (Simulation) otherObject;
        boolean v1=this.aircraft.equals(otherSimulation.getAircraft()) &&
                this.getStartAirport().equals(otherSimulation.getStartAirport()) &&
                this.getEndAirport().equals(otherSimulation.getEndAirport()) &&
                this.passengers==otherSimulation.getPassengers() &&
                this.crew==otherSimulation.getCrew() &&
                Double.doubleToLongBits(this.cargoLoad)==
                Double.doubleToLongBits(otherSimulation.getCargoLoad()) &&
                Double.doubleToLongBits(this.fuelWeight)==
                Double.doubleToLongBits(otherSimulation.getFuelWeight());
       boolean v2=this.getEcologicResultPath().equals(otherSimulation.getEcologicResultPath()) &&
               this.getShortestResultPath().equals(otherSimulation.getShortestResultPath()) 
               && this.getFastestResultPath().equals(otherSimulation.getFastestResultPath());
       return v1 && v2;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.passengers;
        hash = 67 * hash + this.crew;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.cargoLoad) ^ (Double.doubleToLongBits(this.cargoLoad) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.fuelWeight) ^ (Double.doubleToLongBits(this.fuelWeight) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.aircraft);
        hash = 67 * hash + Objects.hashCode(this.getStartAirport());
        hash = 67 * hash + Objects.hashCode(this.getEndAirport());
        return hash;
    }
}
