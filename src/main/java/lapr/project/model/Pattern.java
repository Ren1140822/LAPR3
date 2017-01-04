/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;

/**
 *
 * @author Pedro Fernandes
 */
public class Pattern implements Serializable{
    
    /**
     * (US)
     */
    private double altitude;
    /**
     * (knot)
     */
    private double vClimb;
    /**
     * (knot)
     */
    private double vDesc;
    
    private final double DEFAULT_ALTITUDE=0;
    private final double DEFAULT_V_CLIMB=0;
    private final double DEFAULT_V_DESC=0;
    
    public Pattern(){
        this.altitude = DEFAULT_ALTITUDE;
        this.vClimb = DEFAULT_V_CLIMB;
        this.vDesc = DEFAULT_V_DESC;
    }
    
    public Pattern(Pattern p){
        this.altitude = p.altitude;
        this.vClimb = p.vClimb;
        this.vDesc = p.vDesc;
    }
    
    public Pattern(double altitude, double vClimb, double vDesc){
        this.altitude = DEFAULT_ALTITUDE;
        this.vClimb = DEFAULT_V_CLIMB;
        this.vDesc = DEFAULT_V_DESC;
    }

    /**
     * @return the altitude
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * @param altitude the altitude to set
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    /**
     * @return the vClimb
     */
    public double getvClimb() {
        return vClimb;
    }

    /**
     * @param vClimb the vClimb to set
     */
    public void setvClimb(double vClimb) {
        this.vClimb = vClimb;
    }

    /**
     * @return the vDesc
     */
    public double getvDesc() {
        return vDesc;
    }

    /**
     * @param vDesc the vDesc to set
     */
    public void setvDesc(double vDesc) {
        this.vDesc = vDesc;
    }
    
    @Override
    public String toString(){
        return "Altitude: " + altitude + " VClimb: " + vClimb + 
                " VDesc: " + vDesc;
    }
    
}
