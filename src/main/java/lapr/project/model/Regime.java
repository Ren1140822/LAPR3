/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 * Represents the regime of motorization
 * @author Diana Silva
 */
public class Regime {

    public Regime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * id of regime motorization
     */
    private enum id{
        Cruise
    }
    
    /**
     * thrust specific fuel consumption (fuel efficienty) - 
     * fuel consumption (grams/second) per unit of thrust (kN) (SI units).
     */
    private double TSFC;
    
   
    /**
     * speed of aircraft (m/s)
     */
    private double speed;
    
    /**
     * thrust (kN)
     */
    private double thrust;
    
    /**
     * altitude
     */
    private long altitude;
    
    public Regime(double TSFC, double speed, double thrust, long altitude){
        this.TSFC=TSFC;
        this.speed=speed;
        this.thrust=thrust;
        this.altitude=altitude;
    }
    
    /**
     * @return the TSFC
     */
    public double getTSFC() {
        return TSFC;
    }

    /**
     * @param TSFC the TSFC to set
     */
    public void setTSFC(double TSFC) {
        this.TSFC = TSFC;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @return the thrust
     */
    public double getThrust() {
        return thrust;
    }

    /**
     * @param thrust the thrust to set
     */
    public void setThrust(double thrust) {
        this.thrust = thrust;
    }

    /**
     * @return the altitude
     */
    public long getAltitude() {
        return altitude;
    }

    /**
     * @param altitude the altitude to set
     */
    public void setAltitude(long altitude) {
        this.altitude = altitude;
    }
}
