
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AirNetwork;
import lapr.project.model.AircraftModel;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.Pattern;
import lapr.project.model.Segment;
import lapr.project.model.physics.AircraftAlgorithms;

/**
 * The class to stores and manage analysis results of simulation
 * @author Diana Silva
 */
public class Path {
    /**
     * Value of result path calculated
     */
    private double result; 
    
    /**
     * Path result of best path calculated
     */
    LinkedList<Node> path;
    
    /**
     * Path result of best path calculated
     */
    LinkedList<Segment> segmentsPath;
    
    /**
     * Results of segmentsResult path calculated (climb, cruise, desc)
     */
    private LinkedList<SegmentResult> segmentsResult;
    
    /**
     * Default value for the variables
     */
    private static final double DEFAULT_VALUE=0.0;
    
    private AirNetwork air;
    
    /**
     * distnace to land aircraft desired
     */
    private static final double LAND_DIST_REF=193.121*1000;

   
    /**
     * Constructor
     */
    public Path(){
        super();
        this.path=new LinkedList<>();
        this.result=DEFAULT_VALUE;
        this.segmentsResult=new LinkedList<>();
        this.air=new AirNetwork();
    }  
      
 /**
     * Constructor
     * @param resultPath result path of best path calculated
     * @param result result of best path
     * @param air airnetwork
     */
    public Path(List resultPath,double result, AirNetwork air){
        this.path=(LinkedList<Node>) resultPath;
        this.result=result;
        segmentsResult=new LinkedList<>();
        this.air=air;
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
        this.path=(LinkedList<Node>) resultPath;
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
        return path;
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
     * @return the segmentsResult
     */
    public LinkedList<SegmentResult> getSegments() {
        return segmentsResult;
    }

    /**
     * @param segments the segmentsResult to set
     */
    public void setSegments(LinkedList<SegmentResult> segments) {
        this.segmentsResult = segments;
    }  
    
    private boolean newSegment(SegmentResult sr){
        if(sr.validate()){
           this.segmentsResult.add(sr);
           return true;
        }
        return false;
    }
    
     /**
     * Validates the result path
     * @return true if valid, false if not
     */
    public boolean validate() {
        return Double.doubleToLongBits(result)!=0 && path.isEmpty();
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
        Path otherResultPath = (Path) otherObject;
        return this.path.equals(otherResultPath.getResultPath()) &&
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
        for(SegmentResult sr: segmentsResult){
            distanceTotal+=sr.getDistance();
        }
        return distanceTotal;
    }

    /**
     * @return the energyTotal
     */
    public double getEnergyConsum() {
        double res=0;
        for(SegmentResult sr: segmentsResult){
            res+=sr.getEnergyConsume();
        }
        return res;
    }

    /**
     * @return the timeFlightTotal
     */
    public double getTravellingTime() {
        double res=0;
        for(SegmentResult sr: segmentsResult){
            res+=sr.getFlightTime();
        }
        return res;
    }
    
    /**
     * Simulates initial node
     * @param start start airport
     * @param initialMass initial weight of aircraft (kg)
     * @param timeStep time step to consider (s)
     * @param aircraftModel aircraftModel
     * @param list list of patterns to consider
     * @param segment segment to simulate
     * @return true if segment result was created, false if not
     */
    public boolean simulateInitialNode(Airport start, double initialMass,
            int timeStep,  AircraftModel aircraftModel, List<Pattern> list, Segment segment)
    {
        double altitude=start.getLocation().getAltitude();
                    
        SegmentResult srClimb=new SegmentResult(SegmentType.CLIMBING,
                altitude,initialMass, timeStep, aircraftModel, 
                list,segment);
        boolean stopClimb=srClimb.stopClimb();
        do{
            boolean testClimb= srClimb.calculate();
     
           if(testClimb)
           
            segmentsResult.add(srClimb);
        }while(!stopClimb);
        
        return simulateIntermNodes(segmentsResult.getLast().getMass(),
                timeStep, aircraftModel, list,segment, segmentsResult.getLast().getAltitudeFinal());
       
    }
    
    /**
     * Simulate the intermediate nodes
     * @param initialMass initial mass (kg)
     * @param timeStep time step to consider (s)
     * @param aircraftModel aircraft model
     * @param list list of patterns to consider
     * @param segment segment to simulate
     * @param initialAltitude initial altitude (m)
     * @return true if segment result was created, false if not
     */
    public boolean simulateIntermNodes(double initialMass, int timeStep, 
            AircraftModel aircraftModel, List<Pattern> list, Segment segment, 
            double initialAltitude)
    {
       
        SegmentResult srCruise=new SegmentResult(SegmentType.CRUISE,
                            initialAltitude, initialMass, timeStep,aircraftModel, list, segment);
       
        boolean testCruise=srCruise.calculate();
        if(testCruise)
            segmentsResult.add(srCruise);
        
        return testCruise;
    }
    
    public boolean simulateEndNode(int timeStep, 
            AircraftModel aircraftModel, List<Pattern> list, Segment segment, 
            double initialAltitude)
    {
            SegmentResult srDescend=new SegmentResult(SegmentType.DESC,
                                segmentsResult.getLast().getAltitudeFinal(),
                    segmentsResult.getLast().getMass(), timeStep, aircraftModel, list, segment);
            boolean testEnd=srDescend.calculate();
            
             if(testEnd)
                 segmentsResult.add(srDescend);
             return testEnd;
    }
    
    private double estimateDistanceToDescend(Airport end,
            int timeStep,  AircraftModel aircraftModel, List<Pattern> list,
            Segment segment){
         
            SegmentResult srAuxDesc=new SegmentResult(SegmentType.DESC,
                        segmentsResult.getLast().getAltitudeFinal(),segmentsResult.getLast().getMass(), 
            timeStep, aircraftModel, list, segment);
            double altFinalAirport=end.getLocation().getAltitude();
            double altFinalSimulation=srAuxDesc.getAltitudeFinal();
            double distanceDesc=0;
            if(altFinalSimulation<=altFinalAirport){
                double margin=altFinalAirport-altFinalSimulation;
                double perc=(srAuxDesc.getDistance()-LAND_DIST_REF)/srAuxDesc.getDistance();
                return srAuxDesc.getDistance()*(srAuxDesc.getDistance()*perc);
              
            }else
                return -1;
    }
    
    /**
     * Create results of path (climb-cruise-descend)
     * @param flightPlan flight plan to calculate
     * @param initialMass initial weigt
     * @param timeStep time step do consider
     * @return true if valid, false if not
     */
    public boolean createPartialResults(FlightPlan flightPlan,
        double initialMass, int timeStep){
        AircraftModel aircraftModel=flightPlan.getAircraft().getAircraftModel();
        double altitude=-1;
        if(!path.isEmpty()){
            List<Pattern> list=flightPlan.getListPattern();
            int nrScale=flightPlan.getMandatoryWaypoints().size();
            double size=path.size();
            LinkedList<Segment> listSegments=getSegmentsPath(air);
            Airport startAirport=flightPlan.getOrigin();
                      
            //for(int j=0; j<nrScale;j++)
 
            //ONLY ONE AIRPORT-SKY-DESCEND (nrScale=0)
            for(int i=0; i<size;i++){
                //NODE2-NODE3-...-LASTNODE
                if(i!=0 && i!=size-1)
                    simulateIntermNodes(segmentsResult.getLast().getMass(), timeStep, aircraftModel, list,
                            listSegments.get(i), segmentsResult.getLast().getAltitudeFinal());
                
                //CLIMBING PHASE - AIRPORT/FIRSTNODE - SKY 
                if(i==0){
                    simulateInitialNode(startAirport, initialMass, timeStep,
                            aircraftModel, list, listSegments.get(i));
                    
                }
                //DESCEND PHASE
                if(i==path.size()-1){
                    //SIMULATE DESCENT
                    double distance=estimateDistanceToDescend(flightPlan.getDestination(),
                            timeStep, aircraftModel, list, listSegments.get(i));                 
                    do{
                        simulateIntermNodes(segmentsResult.getLast().getMass(), timeStep, aircraftModel, list,
                            listSegments.get(i), segmentsResult.getLast().getAltitudeFinal());

                    }while(segmentsResult.getLast().getDistance()<distance);           
                }
            }
        }
        
        return !path.isEmpty() || segmentsResult.isEmpty();
    }
    
    public LinkedList<Segment> getSegmentsPath(AirNetwork air){
        LinkedList<Segment> list=new LinkedList<>();
        for(int i=0; i<path.size()-1;i++){
            list.add(air.getAirNetwork().getEdge(path.get(i),path.get(i+1)).getElement());
        }
        return list;
    }
        
    /**
     * Calculate distance needed do descend phase
     * @return distance (m)
     */
    private double calculateDistanceToDescend(double altitude, Airport finalAirport){
     //  double timeToDescend=altitude-finalAirport.getLocation().getAltitude()/dhDT;
        
       //return timeToDescend*groundSpeed;
       return 0;
    }
}
