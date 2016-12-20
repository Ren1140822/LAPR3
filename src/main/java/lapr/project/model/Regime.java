/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents the regime of motorization
 * @author Diana Silva
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Regime {

    /**
     * id of regime motorization
     */
    @XmlAttribute(name="id")
    private String id;
    
    /**
     * thrust specific fuel consumption (fuel efficienty) - 
     * fuel consumption (grams/second) per unit of thrust (kN) (SI units).
     */
    @XmlElement
    private double TSFC;
    
   
    /**
     * speed of aircraft (m/s)
     */
    @XmlElement
    private double speed;
    
    /**
     * thrust (kN)
     */
    @XmlElement
    private double thrust;
    
    /**
     * altitude
     */
    @XmlElement
    private long altitude;
    @XmlTransient
    private static final String DEFAULT_ID = "NOID";
    @XmlTransient
    private static final double DEFAULT_TSFC = 0;
    @XmlTransient
    private static final double DEFAULT_SPEED = 0;
    @XmlTransient
    private static final double DEFAULT_THRUST = 0;
    @XmlTransient
    private static final long DEFAULT_ALTITUDE = 0;
    
    public Regime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
    
     public boolean validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
