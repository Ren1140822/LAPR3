/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import lapr.project.model.AircraftModel;
import lapr.project.model.FlightPlan;
import lapr.project.model.Pattern;
import lapr.project.model.Thrust_Function;
import lapr.project.model.physics.AircraftAlgorithms;
import lapr.project.model.physics.PhysicsAlgorithms;

/**
 * Class to store the results of simulation segments (climbing+cruise+desc)
 * @author DianaSilva
 */
public class SegmentResult {

    private double altitude;
    private double altitudeFinal;
    private double mass;
    private double distance;
    private int flightTime;
    private AircraftModel model;
    private FlightPlan flightPlan;
    private static final double DEFAULT_VALUE=0;
    private double energyConsume;
    private int timeStep;
   
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
        this.altitudeFinal=DEFAULT_VALUE;
        this.mass=DEFAULT_VALUE;
        this.flightTime=(int) DEFAULT_VALUE;
        this.distance=DEFAULT_VALUE;
        this.energyConsume=DEFAULT_VALUE;
        this.timeStep=(int) DEFAULT_VALUE;
        this.model=new AircraftModel();
        this.flightPlan=new FlightPlan();
    }
   
  
    /**
     * Constructor
     * @param type type of segment result
     * @param altitudeInitial altitude on the start node of segment (m)
     * @param altitudeFinal altitude on the end node of segment (m)
     * @param mass mass (kg)
     * @param timeStep time step to consider in segments (s)
     */
    public SegmentResult(Type type, double altitudeInitial, double altitudeFinal,
            double mass, int timeStep, AircraftModel model, FlightPlan flightPlan){
        this.type=type;
        this.altitude=altitudeInitial;
        this.altitudeFinal=altitudeFinal;
        this.mass=mass;
        this.timeStep=timeStep;
        this.flightTime=(int) DEFAULT_VALUE;
        this.distance=DEFAULT_VALUE;
        this.energyConsume=DEFAULT_VALUE;
        this.model=model;
        this.flightPlan=flightPlan;
        
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
    public double getInitialAltitude() {
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
     * @return the energyConsume
     */
    public double getEnergyConsume() {
        return energyConsume;
    }
    
     /**
     * @return the altitudeFinal
     */
    public double getAltitudeFinal() {
        return altitudeFinal;
    }
    
     /**
     * @return the timeStep
     */
    public int getTimeStep() {
        return timeStep;
    }

    /**
     * @param timeStep the timeStep to set
     */
    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    /**
     * @param altitudeFinal the altitudeFinal to set
     */
    public void setAltitudeFinal(double altitudeFinal) {
        this.altitudeFinal = altitudeFinal;
    }
    

    /**
     * @param energyConsume the energyConsume to set
     */
    public void setEnergyConsume(double energyConsume) {
        this.energyConsume = energyConsume;
    }
    
    /**
     * @param altitude the altitude to set
     */
    public void setInitialAltitude(double altitude) {
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
    
    /**
     * Calculates the distance, mass and flight time in the segment
     */
    public void calculate(){
        if(validate()){
            for(int i=0; i<model.getListIten().size(); i++){
                if(altitude<altitudeFinal){
                    double airDensity=PhysicsAlgorithms.calculateAirdensity(altitude);
                    double temperature=PhysicsAlgorithms.calculateAbsoluteTemperature(altitude);
                    double vIas=getVIas(altitude, type);
                    double cDrag=model.getListIten().get(i).getCdrag_0();

                    double tas=AircraftAlgorithms.calculateTAS(airDensity, temperature, vIas);

                    Thrust_Function t=model.getMotorization().getThrust_function();
                    double thrustMa=t.getThrustMaxSpeed();       
                    double velThrustMa=t.getMaxSpeed();
                    double thrustMi=t.getThrust_0();
                    double lambda=AircraftAlgorithms.calculateLambda(velThrustMa, thrustMa, thrustMi);

                    double mTrue=AircraftAlgorithms.calculateMTrue(airDensity, vIas);

                    double thrustLapseRate=model.getMotorization().getLapse_rate_factor();

                    double thrust=AircraftAlgorithms.calculateThrust(thrustMa, lambda, mTrue, airDensity, thrustLapseRate);
                    double totalThrust=thrust*model.getMotorization().getNumberMotors();
                    double wingArea=model.getWingArea();

                    double liftCoef=AircraftAlgorithms.calculateLiftCoefficient(mass, airDensity, wingArea, vIas);

                    double coefDrag=AircraftAlgorithms.calculateDragCoefficient(cDrag, liftCoef, model.getAspectRatio(), model.getE());

                    double drag=AircraftAlgorithms.calculateDragForce(coefDrag, airDensity, vIas, wingArea);

                    double dhDT=AircraftAlgorithms.calculateDhDt(totalThrust, drag, tas, mass);

                    double angle=AircraftAlgorithms.calculateClimbingAng(tas, dhDT);

                    double dwDT=AircraftAlgorithms.calculateDwDt(totalThrust, thrust, tas);

                    double newMass=AircraftAlgorithms.calculateNewMass(mass, dwDT);

                    distance+=AircraftAlgorithms.calculateDistanceGained(tas, angle, timeStep);
                    altitude+=AircraftAlgorithms.calculateAltitudeGained(drag, dhDT, thrust);
                    mass+=newMass;
                    flightTime+=timeStep;
                }
            }
        } 
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
        AircraftAlgorithms.calculateFuelUsed(initialWeight, finalWeight, weightZeroFuel);      
    }
    
    public double getVIas(double altitude, Type type) {
        Type p=type;
        LinkedList<Pattern> list=(LinkedList<Pattern>) flightPlan.getListPattern();
        int altIndex=0;
 
        switch(p){
            case CRUISE:
               return model.getMotorization().getCruise_speed();
            case CLIMBING:
               altIndex=getIndex(altitude);
               if(altIndex!=-1)
                    return list.get(altIndex).getvClimb();
               return -1;
            case DESC:
               altIndex=getIndex(altitude);
               if(altIndex!=-1)
                    return list.get(altIndex).getvDesc(); 
               return -1;
            default:
                return -1;         
         } 
    }
    
    public int getIndex(double altitude){
        LinkedList<Pattern> list=(LinkedList<Pattern>) flightPlan.getListPattern();
        int size=list.size();
        if(size!=0){
            boolean b=list.get(0).getAltitude()<=altitude &&
                    altitude<list.get(size-1).getAltitude();
            
            if(b ){
                for(int i=0; i<size-1;i++){
                    double min=list.get(i).getAltitude();
                    double max=list.get(i+1).getAltitude();
                    if(min>=altitude && altitude<max){
                        return i;
                    }   
                }
            }
        }
        return -1;
    }
    
    public boolean validate(){
        boolean b=false;
        if(Type.CLIMBING==type) b= altitude<altitudeFinal;
        if(Type.DESC==type) b=altitude>altitudeFinal;
        if(Type.CRUISE==type) b=altitude==altitudeFinal;
        return b;
    }
}