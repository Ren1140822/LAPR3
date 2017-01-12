/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.Pattern;
import lapr.project.model.physics.AircraftAlgorithms;

/**
 * The class to stores and manage analysis results of simulation
 * @author Diana Silva
 */
public class ResultPath {
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
     * @param result result of best path
     */
    public ResultPath(List resultPath,double result){
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
    
    private boolean newSegment(SegmentResult sr){
        if(sr.validate()){
           this.segments.add(sr);
           return true;
        }
        return false;
    }

    public boolean createSegments(FlightPlan flightPlan,
        double initialMass, int timeStep){
        AircraftModel aircraftModel=flightPlan.getAircraft().getAircraftModel();
        double altitude=-1;
        if(!resultPath.isEmpty()){
            List<Pattern> list=flightPlan.getListPattern();
            Airport finalAirport=flightPlan.getDestination();
            int nrScale=flightPlan.getMandatoryWaypoints().size();
            for(int i=0; i<=nrScale;i++){
                for(int j=0;j<resultPath.size()-1;j++){
                    
                    //CLIMBING PHASE - AIRPORT/FIRSTNODE - SKY 
                    if(i==0){
                        altitude=flightPlan.getOrigin().getLocation().getAltitude();
                    
                        SegmentResult srClimb=new SegmentResult(SegmentType.CLIMBING,
                                altitude,initialMass, timeStep,aircraftModel, 
                                list);
                        segments.add(srClimb);
                        boolean testClimb=srClimb.calculateClimb();
                        if(testClimb){ 
                            altitude=srClimb.getAltitudeFinal();
                           
                            SegmentResult srCruise=new SegmentResult(SegmentType.CRUISE,
                                altitude, initialMass, timeStep,aircraftModel,
                                    list);
                            segments.add(srCruise);
                            boolean testCruise=srCruise.calculateCruise(finalAirport);
                           if(testCruise){
                               altitude=srCruise.getAltitudeFinal();
                           } 
                        }
                    }
                    //DESCEND PHASE - SKY-AIRPORT
                    if(i==resultPath.size()-1){
                         SegmentResult srCruise=new SegmentResult(SegmentType.CRUISE,
                                altitude,initialMass, timeStep,aircraftModel, list);
                         segments.add(srCruise);
                        if(srCruise.calculateCruise(finalAirport)){
                            altitude=srCruise.getAltitudeFinal();
                            SegmentResult srDescend=new SegmentResult(SegmentType.DESC,
                                altitude, initialMass, timeStep,aircraftModel, list);
                            segments.add(srDescend);
                           srDescend.calculateDescend(finalAirport);
                        }
                    
                    //NODE2-NODE3-...-LASTNODE
                    }else{
                        SegmentResult srCruise=new SegmentResult(SegmentType.CRUISE,
                                altitude, initialMass, timeStep,aircraftModel, list);
                        segments.add(srCruise);
                        boolean testCruise=srCruise.calculateCruise(finalAirport);
                        if(testCruise){
                            altitude=srCruise.getAltitudeFinal();
                        } 
                    }
                    
                }
            }
        }
        return !resultPath.isEmpty() || segments.isEmpty();
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