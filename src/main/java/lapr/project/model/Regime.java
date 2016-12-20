package lapr.project.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents the regime of motorization
 *
 * @author Diana Silva
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Regime implements Serializable{

    /**
     * id of regime motorization
     */
    @XmlAttribute(name = "ID")
    private String id;

    /**
     * thrust specific fuel consumption (fuel efficienty) - fuel consumption
     * (grams/second) per unit of thrust (kN) (SI units).
     */    
    @XmlTransient
    private double TSFC;

    /**
     * speed of aircraft (m/s)
     */    
    @XmlTransient
    private double speed;

    /**
     * thrust (kN)
     */    
    @XmlTransient
    private double thrust;

    /**
     * altitude
     */
    @XmlTransient
    private double altitude;
    
    @XmlTransient
    private static final String DEFAULT_ID = "NOID";
    @XmlTransient
    private static final double DEFAULT_TSFC = 1;
    @XmlTransient
    private static final double DEFAULT_SPEED = 1;
    @XmlTransient
    private static final double DEFAULT_THRUST = 1;
    @XmlTransient
    private static final double DEFAULT_ALTITUDE = 1;

    public Regime() {
        this.id = DEFAULT_ID;
        this.TSFC = DEFAULT_TSFC;
        this.speed = DEFAULT_SPEED;
        this.thrust = DEFAULT_THRUST;
        this.altitude = DEFAULT_ALTITUDE;
    }

    public Regime(String id, double TSFC, double speed, double thrust, double altitude) {
        this.id = id;
        this.TSFC = TSFC;
        this.speed = speed;
        this.thrust = thrust;
        this.altitude = altitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
     * @return the TSFC for JAXB
     */
    @XmlElement(name="TSFC")
    public String getTSFC_() {
        return String.valueOf(TSFC);
    }

    /**
     * @param tsfc the TSFC to set for JAXB
     */
    public void setTSFC_(String tsfc) {
        String a = tsfc.replaceAll(" US", "");
        this.TSFC = Double.parseDouble(a);
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
     * @return the speed for JAXB
     */
    @XmlElement(name = "speed")
    public String getSpeed_() {
        return String.valueOf(speed);
    }

    /**
     * @param sp the speed to set for JAXB
     */
    public void setSpeed_(String sp) {
        String a = sp.replaceAll(" M", "");
        this.speed = Double.parseDouble(a);
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
     * @return the thrust for JAXB
     */
    @XmlElement(name = "thrust")
    public String getThrust_() {
        return String.valueOf(thrust);
    }

    /**
     * @param th the thrust to set for JAXB
     */
    public void setThrust_(String th) {
        String a = th.replaceAll(" US", "");
        this.thrust = Double.parseDouble(a);
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
     * @return the altitude for JAXB
     */
    @XmlElement(name = "altitude")
    public String getAltitude_() {
        return String.valueOf(altitude);
    }

    /**
     * @param alt the alt to set for JAXB
     */
    public void setAltitude_(String alt) {
        String a = alt.replaceAll(" US", "");
        this.altitude = Double.parseDouble(a);
    }

    public boolean validate() {
        boolean v1 = !id.isEmpty() && TSFC > 0 && speed > 0;
        return v1 && thrust > 0 && altitude > 0;
    }
}
