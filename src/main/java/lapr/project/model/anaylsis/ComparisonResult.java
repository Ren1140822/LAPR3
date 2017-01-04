/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;

/**
 *
 * @author Diana Silva
 */
public class ComparisonResult {
    private double avgDistance;
    private double avgTimeFlight;
    private double avgFuel;
    private static final double DEFAULT_VALUE=0;
    private static final String DEFAULT_DESCRIPTION="Not selected";
    private String aircraftModel;
    private String motorization;
    private LinkedList<Simulation> list;
    
    public ComparisonResult() {
        this.avgDistance=DEFAULT_VALUE;
        this.avgTimeFlight=DEFAULT_VALUE;
        this.avgFuel=DEFAULT_VALUE; 
        this.aircraftModel=DEFAULT_DESCRIPTION;
        this.motorization=DEFAULT_DESCRIPTION;
        this.list=new LinkedList<>();
    }
    
    /**
     * @return the avgDistance
     */
    public double getAvgDistance() {
        return avgDistance;
    }

    /**
     * @param avgDistance the avgDistance to set
     */
    public void setAvgDistance(double avgDistance) {
        this.avgDistance = avgDistance;
    }

    /**
     * @return the avgTimeFlight
     */
    public double getAvgTimeFlight() {
        return avgTimeFlight;
    }

    /**
     * @param avgTimeFlight the avgTimeFlight to set
     */
    public void setAvgTimeFlight(double avgTimeFlight) {
        this.avgTimeFlight = avgTimeFlight;
    }

    /**
     * @return the avgFuel
     */
    public double getAvgFuel() {
        return avgFuel;
    }

    /**
     * @param avgFuel the avgFuel to set
     */
    public void setAvgFuel(double avgFuel) {
        this.avgFuel = avgFuel;
    }
    
    /**
     * @return the aircraft
     */
    public String getAircraftModel() {
        return aircraftModel;
    }

    /**
     * @param aircraftModel the aircraft model to set
     */
    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    /**
     * @return the motorization
     */
    public String getMotorization() {
        return motorization;
    }
    
    /**
     * Gets the simulations compared
     * @return simulations list compared
     */
    public LinkedList<Simulation> getSimulationsCompared(){
        return list;
    }
    
    /**
     * Sets the simulations list 
     * @param list simulations list to set
     */
    public void setSimulationsCompared(LinkedList<Simulation> list){
        this.list=list;
    }

    /**
     * @param motorization the motorization to set
     */
    public void setMotorization(String motorization) {
        this.motorization = motorization;
    }
    
    /**
     * Calculates and sets average distance, time flight and fuel of all
     * simulations
     */
    public void calculateTotalAverage(){ 
        double dist=calculateAverageDistance();
        
        if(Double.doubleToLongBits(dist)!=0)
            avgDistance=dist;
    
        double time=calculateAverageTime();
        if(Double.doubleToLongBits(time)!=0)
            avgTimeFlight=calculateAverageTime();
        
        double fuel=calculateAverageFuel();
        if(Double.doubleToLongBits(fuel)!=0)
            avgFuel=fuel;
    }
    
    /**
     * Calculates and sets average distance, time flight and fuel of all
     * simulations
     * @return 
     */
    private double calculateAverageDistance(){ 
        double sum=0;
        double count=0;
        for(Simulation sim: list){
            double v1=sim.getShortestResultPath().getDistance();
            double v2=sim.getFastestResultPath().getDistance();
            double v3=sim.getEcologicResultPath().getDistance();
            
            double res[]=sumCount(v1, v2, v3);
            sum+=res[0];
            count+=res[1];
        }
        return sum/count;
    }
    
    /**
     * Calculates and sets average distance, time flight and fuel of all
     * simulations
     * @return 
     */
    private double calculateAverageTime(){ 
        double sum=0;
        double count=0;
        for(Simulation sim: list){
            double v1=sim.getShortestResultPath().getTravellingTime();
            double v2=sim.getFastestResultPath().getTravellingTime();
            double v3=sim.getEcologicResultPath().getTravellingTime();
            
            double res[]=sumCount(v1, v2, v3);
            sum+=res[0];
            count+=res[1];
        }
        return sum/count;
    }
    
     /**
     * Calculates and sets average distance, time flight and fuel of all
     * simulations
     * @return 
     */
    private double calculateAverageFuel(){ 
        double sum=0;
        double count=0;
        for(Simulation sim: list){
            double v1=sim.getShortestResultPath().getEnergyConsum();
            double v2=sim.getFastestResultPath().getEnergyConsum();
            double v3=sim.getEcologicResultPath().getEnergyConsum();
            
            double res[]=sumCount(v1, v2, v3);
            sum+=res[0];
            count+=res[1];
        }
        return sum/count;
    }
    
    private double[] sumCount(double v1, double v2, double v3){
        int countTemp=0;
        double sum=0;
        
        if(Double.doubleToLongBits(v1)!=Double.doubleToLongBits(DEFAULT_VALUE)){
                sum+=v1;
                countTemp++;              
        }
        if(Double.doubleToLongBits(v2)!=Double.doubleToLongBits(DEFAULT_VALUE)){
            sum+=v2;
            countTemp++;            
        }
        if(Double.doubleToLongBits(v3)!=Double.doubleToLongBits(DEFAULT_VALUE)){
            sum+=v3;
            countTemp++;                
        }
        double[] res={sum,countTemp};
        return res;            
    }
   
      /**
     * Validates comparison result
     * @return true if all data is valid, false if not
     */
     public boolean validate() {
        return Double.doubleToLongBits(getAvgDistance())!=Double.doubleToLongBits(DEFAULT_VALUE) &&
               Double.doubleToLongBits(getAvgTimeFlight())!=Double.doubleToLongBits(DEFAULT_VALUE) &&
                Double.doubleToLongBits(getAvgFuel())!=Double.doubleToLongBits(DEFAULT_VALUE);
    }
     
    public String[] toStringCompare(Simulation sim){
        ShortestPathResult s= sim.getShortestResultPath();
        FastestPathResult f= sim.getFastestResultPath();
        EcologicPathResult e= sim.getEcologicResultPath();
         
        String[] data={String.format("%.2f", s.getDistance()),
            String.format("%.2f", f.getDistance()),
              String.format("%.2f",  e.getDistance()),
        
        String.format("%.2f", s.getTravellingTime()),
            String.format("%.2f", f.getTravellingTime()),
              String.format("%.2f", e.getTravellingTime()),
        
        String.format("%.2f", s.getEnergyConsum()),
            String.format("%.2f", f.getEnergyConsum()),
              String.format("%.2f", e.getEnergyConsum()),
        
        };
        return data;
    }
    
     public String[] toStringDif(){
        
        String[] data={String.format("%.2f", avgDistance),
            String.format("%.2f", avgDistance),
            String.format("%.2f",avgDistance),
            
            String.format("%.2f", avgTimeFlight),
            String.format("%.2f", avgTimeFlight),
            String.format("%.2f", avgTimeFlight),
            
            String.format("%.2f", avgFuel),
            String.format("%.2f", avgFuel),
            String.format("%.2f", avgFuel),
        };

        return data;
    }
     
    public String[] toStringCompareAvg(){
        String[] data={"Average:", String.format("%.2f", avgDistance)," ",
            "Average:",String.format("%.2f", avgTimeFlight), " ",
                    "Average:", String.format("%.2f", avgFuel)," "
        };
        return data;
    }
}
