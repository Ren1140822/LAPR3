/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.physics.AircraftAlgorithms;
import lapr.project.model.physics.ConversionAlgorithms;

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
     * path of simulation
     */
    private ResultPath resultPath;
    
    /**
     * default value
     */
    private static final double DEFAULT_VALUE=0;  
    
    /**
     * Id of simulation
     */
    private static int counterCode=0;
    
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
     * flight plan to be simulated
     */
    private FlightPlan flightPlan;
    
    /**
     * Constructor
     */
    public Simulation(){
        this.passengers=(int) DEFAULT_VALUE;
        this.crew=(int) DEFAULT_VALUE;
        this.cargoLoad=DEFAULT_VALUE;
        this.totalWeight=DEFAULT_VALUE;
        this.fuelWeight=DEFAULT_VALUE;  
        this.flightPlan=new FlightPlan();
        Simulation.counterCode++;
    }
    
     /**
     * constructor
     * @param passengers number of passengers
     * @param crew number of crew members
     * @param cargoLoad cargo load (kg)
     * @param fuelLoad fuel weight (kg)
     */
    public Simulation(int passengers, int crew, double cargoLoad, double fuelLoad){
        this.passengers=passengers;
        this.crew=crew;
        this.cargoLoad=cargoLoad;
        this.fuelWeight=ConversionAlgorithms.convertLtoKg(fuelLoad);
        this.totalWeight=this.passengers+this.crew+this.cargoLoad+this.fuelWeight;
        this.flightPlan=new FlightPlan();
        Simulation.counterCode++;
    }
    
    public Simulation(Airport startAirport, Airport endAirport,
            Aircraft aircraft){
        
        
         this.flightPlan=new FlightPlan("si"+counterCode, 0, aircraft,
                startAirport, endAirport, new LinkedList<>(), new LinkedList<>(),
                new LinkedList<>()); 
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
     * @return the flightPlan
     */
    public FlightPlan getFlightPlan() {
        return flightPlan;
    }
    
    /**
     * @param flightPlan the flightPlan to set
     */
    public void setFlightPlan(FlightPlan flightPlan) {
        this.flightPlan = flightPlan;
    }
    
    /**
     * Sets data needed to the simulation 
     * @param passengers number of passengers
     * @param crew number of crew members
     * @param cargoLoad cargo load (kg)
     * @param fuelLoad fuel weight (kg)
     * @param startAirport
     * @param endAirport
     * @param aircraft
     */
    public void setData(int passengers, int crew, double cargoLoad, double fuelLoad,
            Airport startAirport, Airport endAirport, Aircraft aircraft){
        this.passengers=passengers;
        this.crew=crew;
        this.cargoLoad=cargoLoad;
        this.fuelWeight=ConversionAlgorithms.convertLtoKg(fuelLoad);
        this.flightPlan=new FlightPlan("si"+counterCode, 0, aircraft,
                startAirport, endAirport, new LinkedList<>(), new LinkedList<>(),
                new LinkedList<>()); 
        this.totalWeight=AircraftAlgorithms.calculateInitialWeight(passengers,
                crew, cargoLoad, aircraft.getAircraftModel().geteWeight(),fuelLoad);
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
     * Gets the start node of simulated flight
     * @param net airnetwork of active project
     * @return start node
     */
    public Node getStartNode(AirNetwork net){
        return net.getAirportNode(flightPlan.getOrigin());
    }
      /**
     * Gets the end node of simulated flight
     * @param net airnetwork of active project
     * @return end node
     */
    public Node getEndNode(AirNetwork net){
        return net.getAirportNode(flightPlan.getDestination());
    }
    
    public Airport getStartAirport(){
        return flightPlan.getOrigin();
    }
    
    public Airport getEndAirport(){
        return flightPlan.getDestination();
    }
        
        /*
     * Validates simulation 
     * @return true if all data is valid, false if not
     */
     public boolean validate() {
        return validateAircraftRelatedData();
    }
     
     /**
      * Validates aircraft related data (nr passengers/crew, weight, fuel capacity)
      * @return true if data related to the aircraft is valid, false if not
      */
     private boolean validateAircraftRelatedData(){
         Aircraft aircraft=flightPlan.getAircraft();
         if(aircraft==null)
             return false;
         else{
            boolean v1 = this.passengers<=aircraft.getCabinConfig().getTotalSeats() &&
                this.crew<=aircraft.getNrOfCrewElements() && 
                this.fuelWeight<=ConversionAlgorithms.convertLtoKg(aircraft.getAircraftModel().getFuelCapacity());
            boolean v2 = v1 && Double.doubleToLongBits(totalWeight)<=Double.doubleToLongBits(aircraft.getAircraftModel().getMTOW());
            return v2 && aircraft.validate();
         }
     }
    
     /**
     * @return the counterCode
     */
    public int getCounterCode() {
        return counterCode;
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
     * Creates a best path simulation
     * @param type type of path to be simulated
     */
    public void createPathSimulation(TypePath type){  
        TypePath p=type;
        if(flightPlan!=null){
            switch(p){
                case ALL:
                    this.shortestResultPath=new ShortestPathResult(flightPlan);
                    this.fastestResultPath=new FastestPathResult(flightPlan);
                    this.ecologicResultPath=new EcologicPathResult(flightPlan);
                case SHORTEST_PATH:
                    this.shortestResultPath=new ShortestPathResult(flightPlan);
                case FASTEST_PATH:
                    this.fastestResultPath=new FastestPathResult(flightPlan);
                case ECOLOGIC_PATH:
                this.ecologicResultPath=new EcologicPathResult(flightPlan);
                default:
                    this.shortestResultPath=new ShortestPathResult(flightPlan);
            }
        }
    }
    
     public ResultPath getResult(TypePath type){
          TypePath p=type;
          switch (p){
              case SHORTEST_PATH:
                    return shortestResultPath;
              case FASTEST_PATH:
                  return fastestResultPath;
              case ECOLOGIC_PATH:
                  return ecologicResultPath;
              default:
                  return shortestResultPath;
          }
      }
     
     
     public boolean calculateBestPath(TypePath type, AirNetwork air, int timeStep){
         if(flightPlan!=null){
             TypePath p=type;
            switch (p){
                case SHORTEST_PATH:
                     shortestResultPath.calculateBestPath(air);
                     shortestResultPath.createSegments(flightPlan, totalWeight, timeStep);
                     return true;
                case FASTEST_PATH:
                    fastestResultPath.calculateBestPath(air);
                    fastestResultPath.createSegments(flightPlan, totalWeight, timeStep);
                    return true;
                case ECOLOGIC_PATH:
                    ecologicResultPath.calculateBestPath(air);
                    ecologicResultPath.createSegments(flightPlan, totalWeight, timeStep);
                    return true;

                case ALL:
                  shortestResultPath.calculateBestPath(air);
                  fastestResultPath.calculateBestPath(air);
                  ecologicResultPath.calculateBestPath(air);
                  
                  shortestResultPath.createSegments(flightPlan, totalWeight, timeStep);
                  fastestResultPath.createSegments(flightPlan, totalWeight, timeStep);
                  ecologicResultPath.createSegments(flightPlan, totalWeight, timeStep);
                  
                  
                  return true;
                default:
                    return false;
            }
         }
      return false;
     }
      
    @Override
    public String toString()
    {
        return String.valueOf(this.getCounterCode());
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
      
        return this.passengers==otherSimulation.getPassengers() &&
                this.crew==otherSimulation.getCrew() && Double.doubleToLongBits(this.cargoLoad)==
                Double.doubleToLongBits(otherSimulation.getCargoLoad()) &&
                Double.doubleToLongBits(this.fuelWeight)==
                Double.doubleToLongBits(otherSimulation.getFuelWeight());

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.passengers;
        hash = 67 * hash + this.crew;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.cargoLoad) ^ (Double.doubleToLongBits(this.cargoLoad) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.fuelWeight) ^ (Double.doubleToLongBits(this.fuelWeight) >>> 32));
        return hash;
    }
}
