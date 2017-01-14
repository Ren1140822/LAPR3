 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AircraftModel;
import lapr.project.model.Iten;
import lapr.project.model.Pattern;
import lapr.project.model.Segment;
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
    private Segment segment;

    private static final double DEFAULT_VALUE=-1;
    private double energyConsume;
    private int timeStep;
    private SegmentType type;
    private double angle;
    private double dhDT;
    private List<Pattern> listPatterns;
    
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
    private double groundSpeed;
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
        this.segment=new Segment();
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
        this.segment=new Segment();
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
     * @param segment
     */
    public SegmentResult(SegmentType type, double altitudeInitial,double mass, 
            int timeStep, AircraftModel model, List<Pattern> listPattern, 
            Segment segment){
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
        this.segment=segment;
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
     * @return the segment
     */
    public Segment getSegment() {
        return segment;
    }

    /**
     * @param segment the segment to set
     */
    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    /**
     * @return the listPatterns
     */
    public List<Pattern> getListPatterns() {
        return listPatterns;
    }

    /**
     * @param listPatterns the listPatterns to set
     */
    public void setListPatterns(List<Pattern> listPatterns) {
        this.listPatterns = listPatterns;
    }
    
    
    /**
     * Get true airspeed
     * @return the tas true air speed (m/s)
     */
    public double getTas() {
        return tas;
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
                    return getListPatterns().get(altIndex).getvClimb();
               return altIndex;
            case DESC:
               altIndex=getIndex(altitude);
               if(altIndex!=-1)
                    return getListPatterns().get(altIndex).getvDesc(); 
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
        int size=getListPatterns().size();
        if(size>0){
            boolean b=getListPatterns().get(0).getAltitude()<=altitude &&
                    altitude<getListPatterns().get(size-1).getAltitude();
            
            if(b ){
                for(int i=0; i<size-1;i++){
                    double min=getListPatterns().get(i).getAltitude();
                    double max=getListPatterns().get(i+1).getAltitude();
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
    public boolean stopClimb(){
        boolean pass=false;
        
        do{
            pass=calculate();
            
        }while(angle>0.2 || altitude>=getModel().getMotorization().getCruise_altitude()
                && pass);
        if(!pass) return false;
        altitudeFinal=altitude;
        return true;
    }

    private boolean calculateBasic(){        
        airDensity=PhysicsAlgorithms.calculateAirdensity(altitude);
        double temperature=PhysicsAlgorithms.calculateAbsoluteTemperature(altitude);
        vIas=getVIas(altitude, type);
        
        if(Double.doubleToLongBits(vIas)==-1){
            return false;
        }
        
        cDrag=0;
        
        if(Double.doubleToLongBits(dhDT)==-1)
             cDrag=getModel().getListIten().get(0).getCdrag_0();
        else
            cDrag=getCDrag0(dhDT);

        if(Double.doubleToLongBits(cDrag)==-1)
            return false;
        
        double tas=AircraftAlgorithms.calculateTAS(airDensity, temperature, vIas);
        
        groundSpeed=AircraftAlgorithms.calculateGroundSpeed(tas, segment.getWind(), angle);

        lambda=AircraftAlgorithms.calculateLambda(velThrustMa, thrustMa, thrustMi);

        mTrue=AircraftAlgorithms.calculateMTrue(airDensity, vIas);
        
        return true;
    }
    
    /**
     * Calculates the segment according to type (Descente,Cruise,Climb) 
     * @param type 
     * @return boolean if operation is valid, false if not
     */
    public boolean calculateByType(SegmentType type){
        this.type=type;
        return calculate();
    }
    
     /**
     * Calculates the distance, mass and flight time in the segment
     */
    public boolean calculate(){
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

        dhDT=AircraftAlgorithms.calculateDhDt(totalThrust, drag, groundSpeed, mass);

        angle=AircraftAlgorithms.calculateClimbingAng(groundSpeed, dhDT);

        double dwDT=AircraftAlgorithms.calculateDwDt(totalThrust, thrust, groundSpeed);

        double newMass=AircraftAlgorithms.calculateNewMass(mass, dwDT);
        
        distance+=AircraftAlgorithms.calculateDistanceGained(groundSpeed, angle, timeStep);
        
        if(type!=SegmentType.CLIMBING)
            altitude+=AircraftAlgorithms.calculateAltitudeGained(drag, dhDT, thrust);
        if(type!=SegmentType.DESC)
            altitude+=AircraftAlgorithms.calculateAltitudeDesc(dhDT, timeStep);
        
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
         boolean v1 = Double.doubleToLongBits(this.altitude)!=-1;
         
        boolean v2 = this.type!=null;
        return v1 && v2;
    }
    
    
    public boolean validateCalculation(){
         double defaultValue=Thrust_Function.getDefaultValue();
         double defaultWing=AircraftModel.getDefaultWingArea();
         
         boolean v1=Double.doubleToLongBits(thrustMa)!=Double.doubleToLongBits(defaultValue) &&
                 Double.doubleToLongBits(velThrustMa)!=Double.doubleToLongBits(defaultValue)&&
                 Double.doubleToLongBits(thrustMi)!=Double.doubleToLongBits(defaultValue) &&
                 Double.doubleToLongBits(thrustLapseRate)!=Double.doubleToLongBits(defaultValue);     
           
         return v1 && t==null && Double.doubleToLongBits(wingArea)!=Double.doubleToLongBits(defaultWing);
    }
}
