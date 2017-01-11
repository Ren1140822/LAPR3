/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.Node;
import lapr.project.model.Pattern;
import lapr.project.model.physics.AircraftAlgorithms;

/**
 * The class to stores and manage analysis results of simulation
 * @author Diana Silva
 */
public abstract class ResultPath {
    /**
     * Value of result path calculated
     */
    private double result; 
    
    /**
     * ResultPath result of best path calculated
     */
    LinkedList<Node> resultPath;
    
    /**
     * Results of segments path calculated (climb, cruise, desc)
     */
    private LinkedList<SegmentResult> segments;
    
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
        this.result=DEFAULT_VALUE;
        this.segments=new LinkedList<>();
    }  
      
 /**
     * Constructor
     * @param resultPath result path of best path calculated
     * @param distance distance of best path calculated
     * @param energyConsum energy consume of best path calculated
     * @param travellingTime travelling time of best path calculated
     * @param result result of best path
     */
    public ResultPath(List resultPath, 
            double distance, double energyConsum, double travellingTime,
            double result){
        this.resultPath=(LinkedList<Node>) resultPath;
        this.result=result;
        segments=new LinkedList<>();
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
     * Calculates the energy consum of simulation result
     * @param initialWeight
     * @param timeFlight
     * @param tsfc
     * @param weightZeroFuel
     */
    public void calculateEnergyConsumption(double initialWeight, double timeFlight, double tsfc, double weightZeroFuel){
        double finalWeight=AircraftAlgorithms.calculateFinalWeight(initialWeight, timeFlight, tsfc);
        //falta converter fuel para energia
//        energyConsum= AircraftAlgorithms.calculateFuelUsed(initialWeight, finalWeight, weightZeroFuel);      
    }
     
    /**
     * @return the segments
     */
    public LinkedList<SegmentResult> getSegments() {
        return segments;
    }

    /**
     * @param segments the segments to set
     */
    public void setSegments(LinkedList<SegmentResult> segments) {
        this.segments = segments;
    }  
    
    public boolean newSegment(SegmentResult sr){
        if(sr.validate()){
           this.segments.add(sr);
           return true;
        }
        return false;
    }
    
    /**
     * Gets the velocity desc indicated to the aircraft
     * @param altitude altitude (m)
     * @param list list of patterns of flight plan
     * @return velocity (m/s)
     */
    public double getVDesc(double altitude, LinkedList<Pattern> list){
        int size=list.size();
        double vDesc=0;
        for(int i=0; i<size; i++){
            boolean b=list.get(i).getAltitude()<altitude &&
                    altitude<list.get(i+1).getAltitude();
            
            if(b)
                vDesc=list.get(i).getvClimb();
        }
        return vDesc;       
    }
    
    
    public void calculateSimulation(){
        double altitude=0;
        double vIas=0;
        if(!resultPath.isEmpty()){
            for (Node resultPath1 : resultPath) {
                //Se node2 Ã© AEROPORTO ---> logo criar Subida-Cruise-Descida
                //Se node2 nÃ£o Ã© ""    ---> logo criar Subida-Cruise apenas
//                if(resultPath.get(i+1)  ){
//                    
//                }
            }
        }
    }
    
     /**
     * Validates the result path
     * @return true if valid, false if not
     */
    public boolean validate() {
        return Double.doubleToLongBits(result)!=0 && resultPath.isEmpty();
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
        return this.resultPath.equals(otherResultPath.getResultPath()) &&
                Double.doubleToLongBits(this.result)==Double.doubleToLongBits(otherResultPath.getResult());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.result) ^ (Double.doubleToLongBits(this.result) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.resultPath);
        return hash;
    }   

    /**
     * @return the distanceTotal
     */
    public double getDistance() {
        double distanceTotal=0;
        for(SegmentResult sr: segments){
            distanceTotal+=sr.getDistance();
        }
        return distanceTotal;
    }

    /**
     * @return the energyTotal
     */
    public double getEnergyConsum() {
        double res=0;
        for(SegmentResult sr: segments){
            res+=sr.getEnergyConsume();
        }
        return res;
    }

    /**
     * @return the timeFlightTotal
     */
    public double getTravellingTime() {
        double res=0;
        for(SegmentResult sr: segments){
            res+=sr.getFlightTime();
        }
        return res;
    }
}