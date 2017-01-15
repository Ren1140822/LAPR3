
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AirNetwork;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.Segment;
import lapr.project.utils.DistanceCalculator;

/**
 * The class to stores and manage analysis results of simulation
 *
 * @author Diana Silva
 */
public abstract class Path {

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
     * Results of segmentsResultTime path calculated (climb, cruise, desc) by time step
     */
    private LinkedList<SegmentResult> segmentsResultTime;

    /**
     * Default value for the variables
     */
    private static final double DEFAULT_VALUE = 0.0;

    private AirNetwork air;
    
    /**
     * Results of segment results by segment of airnetwork
     */
    private LinkedList<SegmentResult> listSegResults;

    /**
     * Constructor
     */
    public Path() {
        super();
        this.path = new LinkedList<>();
        this.result = DEFAULT_VALUE;
        this.segmentsResultTime = new LinkedList<>();
        this.air = new AirNetwork();
        this.listSegResults=new LinkedList<>();
    }

    /**
     * Constructor
     *
     * @param resultPath result path of best path calculated
     * @param result result of best path
     * @param air airnetwork
     */
    public Path(List resultPath, double result, AirNetwork air) {
        this.path = (LinkedList<Node>) resultPath;
        this.result = result;
        segmentsResultTime = new LinkedList<>();
        this.air = air;
        this.listSegResults=new LinkedList<>();
    }

    /**
     * Sets the analysis final result
     *
     * @param result analysis result
     */
    public void setResult(double result) {
        this.result = result;
    }

    /**
     * Sets the analysis final result
     *
     * @param resultPath result path
     */
    public void setResultPath(List<Node> resultPath) {
        this.path = (LinkedList<Node>) resultPath;
    }

    /**
     * Gets the result of result path
     *
     * @return result
     */
    public double getResult() {
        return result;
    }

    /**
     * Gets the result path
     *
     * @return result path
     */
    public List<Node> getResultPath() {
        return path;
    }

    /**
     * @return the segmentsResultTime
     */
    public LinkedList<SegmentResult> getSegments() {
        return segmentsResultTime;
    }

    /**
     * @param segments the segmentsResultTime to set
     */
    public void setSegmentsResultTime(LinkedList<SegmentResult> segments) {
        this.segmentsResultTime = segments;
    }

    /**
     * @return the air
     */
    public AirNetwork getAir() {
        return air;
    }

    /**
     * @param air the air to set
     */
    public void setAir(AirNetwork air) {
        this.air = air;
    }

    /**
     * Validates the result path
     *
     * @return true if valid, false if not
     */
    public boolean validate() {
        return Double.doubleToLongBits(result) != 0 && path.isEmpty();
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
        return this.path.equals(otherResultPath.getResultPath())
                && Double.doubleToLongBits(this.result) == Double.doubleToLongBits(otherResultPath.getResult());
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
        double distanceTotal = 0;
        for (SegmentResult sr : segmentsResultTime) {
            distanceTotal += sr.getDistance();
        }
        return distanceTotal;
    }

    /**
     * @return the energyTotal
     */
    public double getEnergyConsum() {
        double res = 0;
        for (SegmentResult sr : segmentsResultTime) {
            res += sr.getEnergyConsume();
        }
        return res;
    }

    /**
     * @return the timeFlightTotal
     */
    public double getTravellingTime() {
        double res = 0;
        for (SegmentResult sr : segmentsResultTime) {
            res += sr.getFlightTime();
        }
        return res;
    }

    public LinkedList<Segment> getSegmentsPath(AirNetwork air) {
        LinkedList<Segment> list = new LinkedList<>();
        for (int i = 0; i < path.size() - 1; i++) {
            list.add(air.getAirNetwork().getEdge(path.get(i), path.get(i + 1)).getElement());
        }
        return list;
    }

    public boolean simulateInitialNode(FlightPlan flightPlan, int timeStep, double totalWeight, Segment segment) {
        SegmentResult srClimb = new SegmentResult(SegmentType.CLIMBING, flightPlan.getOrigin().getLocation().getAltitude(),
                totalWeight, timeStep, flightPlan.getAircraft().getAircraftModel(), flightPlan.getListPattern(), segment, totalWeight);
        if(!srClimb.validateCalculation())
            return false;
        do {
            srClimb.calculate();
            segmentsResultTime.add(srClimb);
        } while (!srClimb.stopClimb());

        SegmentResult seg = new SegmentResult(SegmentType.CRUISE, segmentsResultTime.getLast().getAltitudeFinal(), totalWeight, timeStep,
                flightPlan.getAircraft().getAircraftModel(), flightPlan.getListPattern(), segment, segmentsResultTime.getLast().getMass());
        seg.calculate();
        segmentsResultTime.add(seg);
        return true;
    }

    public boolean simulateEndNode(Airport startAirport, Airport endAirport, FlightPlan flightPlan, int timeStep, double totalWeight, Segment segment) {
        double remainingDistance = DistanceCalculator.calculateDistance(startAirport.getLocation().getLatitude(), startAirport.getLocation().getLongitude(), endAirport.getLocation().getLatitude(), endAirport.getLocation().getLongitude());
        double cumulativeDist =0;
        for(SegmentResult seg: segmentsResultTime)
        {
            cumulativeDist += seg.getDistance();
        }
        SegmentResult seg = new SegmentResult(SegmentType.CRUISE, getSegments().getLast().getAltitudeFinal(), totalWeight, timeStep,
                flightPlan.getAircraft().getAircraftModel(), flightPlan.getListPattern(), segment, getSegments().getLast().getMass());

        
        do {
            seg.calculate();
            segmentsResultTime.add(seg);
           
            cumulativeDist +=segmentsResultTime.getLast().getDistance();
        } while (cumulativeDist<(remainingDistance-222000));

        seg = new SegmentResult(SegmentType.DESC, segmentsResultTime.getLast().getAltitudeFinal(), totalWeight, timeStep,
                flightPlan.getAircraft().getAircraftModel(), flightPlan.getListPattern(), segment, segmentsResultTime.getLast().getMass());
           do {
            seg.calculate();
            segmentsResultTime.add(seg);
            cumulativeDist +=segmentsResultTime.getLast().getDistance();
        } while (cumulativeDist<(remainingDistance));
     
        return true;
    }

    public boolean simulateIntermNodes(FlightPlan flightPlan, int timeStep, double totalWeight, Segment segment) {
        SegmentResult seg = new SegmentResult(SegmentType.CRUISE, flightPlan.getOrigin().getLocation().getAltitude(), totalWeight, timeStep,
                flightPlan.getAircraft().getAircraftModel(), flightPlan.getListPattern(), segment, totalWeight);
        if(!seg.validateCalculation())
            return false;
        seg.calculate();
        segmentsResultTime.add(seg);
        return true;
    }
    
    public void createResultsList(){
        for(SegmentResult seg:segmentsResultTime){
            if(!listSegResults.contains(seg))
                listSegResults.add(seg);
        }
    }

    /**
     * @return the listSegResults
     */
    public LinkedList<SegmentResult> getListSegResults() {
        return listSegResults;
    }

    /**
     * @param listSegResults the listSegResults to set
     */
    public void setListSegResults(LinkedList<SegmentResult> listSegResults) {
        this.listSegResults = listSegResults;
    }
}
