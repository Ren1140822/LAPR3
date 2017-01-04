/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.AirNetwork;
import lapr.project.model.Airport;
import lapr.project.model.Node;
import lapr.project.model.physics.AircraftAlgorithms;

/**
 * The class to stores and manage analysis results of simulation
 * @author Diana Silva
 */
public class ResultPath extends Simulation {
    /**
     * Value of result path calculated
     */
    private double result; 
    
    /**
     * Path result of best path calculated
     */
    LinkedList<Node> resultPath=new LinkedList<>();
    
    /**
     * Energy consum of result path
     */
    private double energyConsum;
    
    /**
     * Travelling time of result path (s)
     */
    private double travellingTime;
    
    /**
     * Distance of result path (m)
     */
    private double distance;
    
    /**
     * Default value for the variables
     */
    private static final double DEFAULT_VALUE=0.0;
   
    /**
     * Constructor
     */
    public ResultPath(){
        super();
        this.resultPath=new LinkedList<>();
        this.distance=DEFAULT_VALUE;
        this.energyConsum=DEFAULT_VALUE;
        this.travellingTime=DEFAULT_VALUE;
        this.result=DEFAULT_VALUE;
    }  
    
    /**
     * Constructor
     * @param startAirport startAirport of path
     * @param endAirport endAirport of path
     */
    public ResultPath(Airport startAirport, Airport endAirport){
        super(startAirport, endAirport);
        this.resultPath=new LinkedList<>();
        this.distance=DEFAULT_VALUE;
        this.energyConsum=DEFAULT_VALUE;
        this.travellingTime=DEFAULT_VALUE;
        this.result=DEFAULT_VALUE;
       
    }  
    
 /**
     * Constructor
     * @param startAirport startAirport of path
     * @param endAirport endAirport of path
     * @param resultPath result path of best path calculated
     * @param distance distance of best path calculated
     * @param energyConsum energy consume of best path calculated
     * @param travellingTime travelling time of best path calculated
     * @param result result of best path
     */
    public ResultPath(Airport startAirport, Airport endAirport, List resultPath, 
            double distance, double energyConsum, double travellingTime,
            double result){
        super(startAirport, endAirport);
        this.resultPath=(LinkedList<Node>) resultPath;
        this.distance=distance;
        this.energyConsum=energyConsum;
        this.travellingTime=travellingTime;
        this.result=result;
       
    }  
      
    /**
     * Sets the analysis final result
     * @param result analysis result  
     */
    public void setResult(double result){
        this.result=result;
    }
    
    /**
     * Sets the analysis final result
     * @param resultPath result path  
     */
    public void setResultPath(List<Node> resultPath){
        this.resultPath=(LinkedList<Node>) resultPath;
    }

    /**
     * Gets the result of result path
     * @return result
     */
    public double getResult() {
        return result;
    }
    
    /**
     * Gets the result path 
     * @return result path 
     */
    public List<Node> getResultPath(){
        return resultPath;
    }
    
    /**
     * @return the energyConsum
     */
    public double getEnergyConsum() {
        return energyConsum;
    }

    /**
     * @param energyConsum the energyConsum to set
     */
    public void setEnergyConsum(double energyConsum) {
        this.energyConsum = energyConsum;
    }

    /**
     * @return the travellingTime (s)
     */
    public double getTravellingTime() {
        return travellingTime;
    }
    
      /**
     * Sets distance of result path (s)
     * @param travellingTime
     */
    public void setTravellingTime(double travellingTime){
        this.travellingTime=travellingTime;
    }

    /**
     * @return the distance (m)
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
    
     /**
     * Calculate best path
     * @param airNetwork airnetwork of active project
     */
    public void calculateBestPath(AirNetwork airNetwork){
        result=0;
    } 

     /**
     * Calculates the travelling time simulation result
     */
     public void calculateTravellingTime(){
         /**
          *   double altitude=PhysicsAlgorithms.calculateAirDensity(cargoLoad, fuelWeight)
         double velocity=AircraftAlgorithms.calculateTrueAirSpeed(fuelWeight, )
        return PhysicsAlgorithms.calculateTime(resultPath.getDistance(), aircraft.get)
          */
         travellingTime=0;
    }
    
    /**
     * Calculates the energy consum of simulation result
     * @param initialWeight
     * @param timeFlight
     * @param tsfc
     * @param weightZeroFuel
     */
    public void calculateEnergyConsumption(double initialWeight, double timeFlight, double tsfc, double weightZeroFuel){
        double finalWeight=AircraftAlgorithms.calculateFinalWeight(initialWeight, timeFlight, tsfc);
        //falta converter fuel para energia
        energyConsum= AircraftAlgorithms.calculateFuelUsed(initialWeight, finalWeight, weightZeroFuel);      
    }
     
    /**
     * Validates the result path
     * @return true if valid, false if not
     */
    @Override
    public boolean validate() {
        boolean v1=Double.doubleToLongBits(result)!=0 && resultPath.isEmpty();
        boolean v2=Double.doubleToLongBits(travellingTime)!=0 && 
                Double.doubleToLongBits(energyConsum)!=0 && 
                Double.doubleToLongBits(distance)!=0;
        return v1 && v2;
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
        ResultPath otherResultPath = (ResultPath) otherObject;
        return super.getStartAirport().equals(otherResultPath.getStartAirport()) &&
                super.getEndAirport().equals(otherResultPath.getEndAirport()) &&
                this.resultPath.equals(otherResultPath.getResultPath()) &&
                Double.doubleToLongBits(this.result)==Double.doubleToLongBits(otherResultPath.getResult());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.result) ^ (Double.doubleToLongBits(this.result) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.resultPath);
        hash = 79 * hash + Objects.hashCode(super.getStartAirport());
        hash = 79 * hash + Objects.hashCode(super.getEndAirport());
        return hash;
    }   
}