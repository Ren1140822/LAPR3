package lapr.project.model;

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
public class Regime {

    /**
     * id of regime motorization
     */
    @XmlAttribute(name = "id")
    private String id;

    /**
     * thrust specific fuel consumption (fuel efficienty) - fuel consumption
     * (grams/second) per unit of thrust (kN) (SI units).
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
    private static final double DEFAULT_TSFC = 1;
    @XmlTransient
    private static final double DEFAULT_SPEED = 1;
    @XmlTransient
    private static final double DEFAULT_THRUST = 1;
    @XmlTransient
    private static final long DEFAULT_ALTITUDE = 1;

    public Regime() {
        id = DEFAULT_ID;
        TSFC = DEFAULT_TSFC;
        speed = DEFAULT_SPEED;
        thrust = DEFAULT_THRUST;
        altitude = DEFAULT_ALTITUDE;
    }

    public Regime(String id, double TSFC, double speed, double thrust, long altitude) {
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
        boolean v1 = !id.isEmpty() && !(TSFC > 0) && !(speed > 0);
        return v1 && !(thrust > 0) && !(altitude > 0);
    }
}
