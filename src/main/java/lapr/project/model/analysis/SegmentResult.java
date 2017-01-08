/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

/**
 * Class to store the results of simulation segments (climbing+cruise+desc)
 * @author DianaSilva
 */
public class SegmentResult {

    private double altitude;
    private double mass;
    private double distance;
    private int flightTime;
    private static final double DEFAULT_VALUE=0;
    
    public enum Type{
        CLIMBING, CRUISE, DESC
    }
    private final Type type;  
    /**
     * Constructor
     */
    public SegmentResult(){
        this.type=Type.CRUISE;
        this.altitude=DEFAULT_VALUE;
        this.mass=DEFAULT_VALUE;
        this.flightTime=(int) DEFAULT_VALUE;
        this.distance=DEFAULT_VALUE;
    }
   
  
    /**
     * Constructor
     * @param type type of segment result
     * @param altitude altitude (m)
     * @param mass mass (kg)
     * @param timeStep time step (s)
     */
    public SegmentResult(Type type, double altitude, double mass, int timeStep){
        this.type=type;
        this.altitude=altitude;
        this.mass=mass;
        this.flightTime=timeStep;
        this.distance=DEFAULT_VALUE;
    }
   
    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @return the altitude
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * @return the mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @return the flightTime
     */
    public int getFlightTime() {
        return flightTime;
    }
    
    /**
     * @param altitude the altitude to set
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @param flightTime the flightTime to set
     */
    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }
}