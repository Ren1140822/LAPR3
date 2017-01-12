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
import lapr.project.model.Iten;
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

    private static final double DEFAULT_VALUE=-1;
    private double energyConsume;
    private int timeStep;
    private SegmentType type;
    private double angle;
    private double dhDT;
    private static List<Pattern> listPatterns;
    
    //DISTANCE TO THE AIRPORT WHEN AIRCRAFT START THE DESCEND PHASE 
    private static final double DIST_DESC=4.82803*1000;
    
    //CONSTANT VALUES RELATED DO THE AIRCRAFT MODEL
    private static Thrust_Function t;
    private static double thrustMa;       
    private static double velThrustMa;
    private static double thrustMi;
    private static double thrustLapseRate;
    private static double wingArea;
    
    //VALUES RELATED TO CALCULATION OPERATIONS 
    private double airDensity;
    private double vIas; 
    private double cDrag; 
    private double lambda;
    private double mTrue;
    private double tas;
    
    /**
     * Constructor
     */
    public SegmentResult(){
        this.type=SegmentType.CLIMBING;
        this.altitude=DEFAULT_VALUE;
        this.altitudeFinal=DEFAULT_VALUE;
        this.mass=DEFAULT_VALUE;
        this.flightTime=(int) DEFAULT_VALUE;
        this.distance=DEFAULT_VALUE;
        this.energyConsume=DEFAULT_VALUE;
        this.timeStep=(int) DEFAULT_VALUE;
        this.angle=DEFAULT_VALUE;
        this.dhDT=DEFAULT_VALUE;
        this.model=new AircraftModel();
        listPatterns=new LinkedList<>();
        constantValues(model);
    }
    
    /**
     * Constructor
     * @param type 
     */
    public SegmentResult(SegmentType type){
       this.type=type;
       this.altitude=DEFAULT_VALUE;
        this.altitudeFinal=DEFAULT_VALUE;
        this.mass=DEFAULT_VALUE;
        this.flightTime=(int) DEFAULT_VALUE;
        this.distance=DEFAULT_VALUE;
        this.energyConsume=DEFAULT_VALUE;
        this.timeStep=(int) DEFAULT_VALUE;
        this.angle=DEFAULT_VALUE;
        this.dhDT=DEFAULT_VALUE;
        this.model=new AircraftModel();
        listPatterns=new LinkedList<>();
        constantValues(model);
   }
  
    /**
     * Constructor
     * @param type type of segment result
     * @param altitudeInitial altitude on the start node of segment (m)
     * @param mass mass (kg)
     * @param timeStep time step to consider in segments (s)
     * @param model aircraft model
     * @param listPattern   list pattern
     */
    public SegmentResult(SegmentType type, double altitudeInitial,double mass, 
            int timeStep, AircraftModel model, List<Pattern> listPattern){
        this.type=type;
        this.altitude=altitudeInitial;
        this.mass=mass;
        this.timeStep=timeStep;
        this.flightTime=(int) DEFAULT_VALUE;
        this.distance=DEFAULT_VALUE;
        this.energyConsume=DEFAULT_VALUE;
        this.angle=DEFAULT_VALUE;
        this.dhDT=DEFAULT_VALUE;
        this.altitudeFinal=DEFAULT_VALUE;
        this.model=model;
        listPatterns=listPattern;
        constantValues(model);
    }
      
    /**
     * @return the type
     */
    public SegmentType getType() {
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
     * @return the model
     */
    public AircraftModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(AircraftModel model) {
        this.model = model;
        constantValues(model);
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
        
    public double getVIas(double altitude, SegmentType type) {
        SegmentType p=type;

        int altIndex=-1;
 
        switch(p){
            case CRUISE:
               return getModel().getMotorization().getCruise_speed();
            case CLIMBING:
               altIndex=getIndex(altitude);
               if(altIndex!=-1)
                    return listPatterns.get(altIndex).getvClimb();
               return altIndex;
            case DESC:
               altIndex=getIndex(altitude);
               if(altIndex!=-1)
                    return listPatterns.get(altIndex).getvDesc(); 
               return -altIndex;
            default:
                return altIndex;         
         } 
    }
    
    public double getCDrag0(double speed){
        LinkedList<Iten> list=(LinkedList<Iten>) getModel().getListIten();
        int size=list.size();
        if(size>0){
            boolean b=list.get(0).getSpeed()<=speed &&
                    speed<list.get(size-1).getSpeed();
            for (int i=0; i<list.size()-1;i++){
                double min=list.get(i).getSpeed();
                double max=list.get(i+1).getSpeed();
                if(min<=speed && speed<max){
                    return list.get(i).getCdrag_0();
                } 
            }
        }
        return -1;
    }
    
    public int getIndex(double altitude){
        int size=listPatterns.size();
        if(size>0){
            boolean b=listPatterns.get(0).getAltitude()<=altitude &&
                    altitude<listPatterns.get(size-1).getAltitude();
            
            if(b ){
                for(int i=0; i<size-1;i++){
                    double min=listPatterns.get(i).getAltitude();
                    double max=listPatterns.get(i+1).getAltitude();
                    if(min<=altitude && altitude<max){
                        return i;
                    }   
                }
            }
        }
        return -1;
    }
    
    /**
     * Calculates the values of climb phase 
     * @return true if valid, false if not
     */
    public boolean calculateClimb(){
        boolean pass=false;
        
        do{
            pass=calculate();
            
        }while(angle>0.2 || altitude>=getModel().getMotorization().getCruise_altitude()
                && pass);
        if(!pass) return false;
        altitudeFinal=altitude;
        return true;
    }
    
    /**
     * Calculates the values of descend phase 
     * @param finalAirport
     * @return true if valid, false if not
     */
    public boolean calculateDescend(Airport finalAirport){
        boolean pass=false;
        
        do{
            pass=calculate();
        }while(altitude<finalAirport.getLocation().getAltitude() && pass);
        
        if(!pass) return false;
        
        altitudeFinal=altitude;
        return true;
    }
    
    public boolean calculateCruise(Airport finalAirport){
        boolean pass=false;
        double distAirport=0;
        do{
            pass=calculate(); 
            distAirport=distanceToGo(finalAirport);
        }while(pass && distAirport<=DIST_DESC);
        return distAirport!=0;
    }
    
    private double distanceToGo(Airport finAirport){
        return 3-finAirport.getLocation().getLongitude();
    }
    
    private boolean calculateBasic(){        
        airDensity=PhysicsAlgorithms.calculateAirdensity(altitude);
        double temperature=PhysicsAlgorithms.calculateAbsoluteTemperature(altitude);
        vIas=getVIas(altitude, type);
        
        if(vIas==-1){
            return false;
        }
        
        cDrag=0;
        
        if(dhDT==-1)
             cDrag=getModel().getListIten().get(0).getCdrag_0();
        else
            cDrag=getCDrag0(dhDT);

        if(cDrag==-1)
            return false;
        tas=AircraftAlgorithms.calculateTAS(airDensity, temperature, vIas);

        lambda=AircraftAlgorithms.calculateLambda(velThrustMa, thrustMa, thrustMi);

        mTrue=AircraftAlgorithms.calculateMTrue(airDensity, vIas);
        
        return true;
    }
    
    
     /**
     * Calculates the distance, mass and flight time in the segment
     */
    private boolean calculate(){
        if(type!=SegmentType.CRUISE)
            calculateBasic();
        double liftCoef=AircraftAlgorithms.calculateLiftCoefficient(mass, airDensity, wingArea, vIas);

        double coefDrag=AircraftAlgorithms.calculateDragCoefficient(cDrag, liftCoef, getModel().getAspectRatio(), getModel().getE());

        double drag=AircraftAlgorithms.calculateDragForce(coefDrag, airDensity, vIas, wingArea);

        double thrust=-1;
        if(type!=SegmentType.CRUISE){
              thrust=calculateThrust(thrustMa, lambda, mTrue, airDensity, thrustLapseRate);
        }else
            thrust=AircraftAlgorithms.calculateThrustCruise(drag, getModel().getMotorization().getNumberMotors());

        double totalThrust=calculateTotalThrust(thrust, drag);

        dhDT=AircraftAlgorithms.calculateDhDt(totalThrust, drag, tas, mass);

        angle=AircraftAlgorithms.calculateClimbingAng(tas, dhDT);

        double dwDT=AircraftAlgorithms.calculateDwDt(totalThrust, thrust, tas);

        double newMass=AircraftAlgorithms.calculateNewMass(mass, dwDT);

        distance+=AircraftAlgorithms.calculateDistanceGained(tas, angle, timeStep);
        altitude+=AircraftAlgorithms.calculateAltitudeGained(drag, dhDT, thrust);
        mass+=newMass;
        flightTime+=timeStep;
        return true;
    }
    
    
    private double calculateThrust(double thrustMa, double lambda, double mTrue,
            double airDensity, double thrustLapseRate){
        double totalThrust=-1;

        if(SegmentType.CLIMBING==type)
             totalThrust=AircraftAlgorithms.
                     calculateThrustClimb(thrustMa, lambda, mTrue, airDensity, thrustLapseRate);
        if(SegmentType.DESC==type) 
            totalThrust= AircraftAlgorithms.
                    calculateThrustDescend(thrustMa, lambda, mTrue, airDensity, thrustLapseRate);
        
        return totalThrust;
    }  
    
    private double calculateTotalThrust(double thrust, double drag){
        double totalThrust=-1;

        if(SegmentType.CLIMBING==type)
             totalThrust=AircraftAlgorithms.
                     calculateTotalThrustClimb(thrust,getModel().getMotorization().getNumberMotors());
        if(SegmentType.DESC==type) 
            totalThrust= AircraftAlgorithms.
                    calculateTotalThrustDescend(thrust,getModel().getMotorization().getNumberMotors());
        if(SegmentType.CRUISE==type) 
            totalThrust= AircraftAlgorithms.calculateTotalThrustCruise(drag);
        
        return totalThrust;
    } 

    private static void constantValues(AircraftModel model){
        t=model.getMotorization().getThrust_function();
        thrustMa=t.getThrustMaxSpeed();       
        velThrustMa=t.getMaxSpeed();
        thrustMi=t.getThrust_0();
        thrustLapseRate=model.getMotorization().getLapse_rate_factor();
        wingArea=model.getWingArea();
    }
    
    public boolean validate(){
         boolean v1 = this.altitude!=-1;
         
        boolean v2 = this.type!=null;
        return v1 && v2;
    }
}