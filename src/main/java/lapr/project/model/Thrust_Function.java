package lapr.project.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.utils.StringToSIUnitConverter;

/**
 * Represents the regime of motorization
 *
 * @author Diana Silva
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Thrust_Function implements Serializable {

    /**
     * thrust_0 (SI)
     */    
    @XmlTransient
    private double thrust_0;

    /**
     * thrust_max_speed (SI)
     */    
    @XmlTransient
    private double thrust_max_speed;

    /**
     * max_speed (kN)
     */    
    @XmlTransient
    private double max_speed;
    
    @XmlTransient
    private static final double DEFAULT_THRUST_0 = 1;
    @XmlTransient
    private static final double DEFAULT_THRUST_MAX_SPEED = 1;
    @XmlTransient
    private static final double DEFAULT_MAX_SPEED = 1;
    
    public Thrust_Function() {
        this.thrust_0 = DEFAULT_THRUST_0;
        this.thrust_max_speed = DEFAULT_THRUST_MAX_SPEED;
        this.max_speed = DEFAULT_MAX_SPEED;
    }
    
    public Thrust_Function(double thrust_0, double thrust_max_speed, double max_speed) {
        this.thrust_0 = thrust_0;
        this.thrust_max_speed = thrust_max_speed;
        this.max_speed = max_speed;
    }

    /**
     * @return the thrustSFC
     */
    public double getThrust_0() {
        return thrust_0;
    }

    /**
     * @param thrust_0
     */
    public void setThrust_0(double thrust_0) {
        this.thrust_0 = thrust_0;
    }

    /**
     * @return the thrustSFC for JAXB
     */
    @XmlElement(name = "thrust_0")
    public String getThrust_0_() {
        return String.valueOf(thrust_0);
    }

    /**
     * @param thrust_0
     */
    public void setThrust_0_(String thrust_0) {
        this.thrust_0 = StringToSIUnitConverter.TSFC(thrust_0);
    }

    /**
     * @return the thrust_max_speed
     */
    public double getMaxSpeed() {
        return max_speed;
    }

    /**
     * @param max_speed the thrust_max_speed to set
     */
    public void setMaxSpeed(double max_speed) {
        this.max_speed = max_speed;
    }

    /**
     * @return the thrust_max_speed for JAXB
     */
    @XmlElement(name = "max_speed")
    public String getMaxSpeed_() {
        return String.valueOf(max_speed);
    }

    /**
     * @param sp the thrust_max_speed to set for JAXB
     */
    public void setMaxSpeed_(String sp) {
        this.max_speed = StringToSIUnitConverter.speed(sp);
    }

    /**
     * @return the max_speed
     */
    public double getThrustMaxSpeed() {
        return thrust_max_speed;
    }

    /**
     * @param thrust_max_speed the max_speed to set
     */
    public void setThrustMaxSpeed(double thrust_max_speed) {
        this.thrust_max_speed = thrust_max_speed;
    }

    /**
     * @return the max_speed for JAXB
     */
    @XmlElement(name = "thrust_max_speed")
    public String getThrustMaxSpeed_() {
        return String.valueOf(thrust_max_speed);
    }

    /**
     * @param th the max_speed to set for JAXB
     */
    public void setThrustMaxSpeed_(String th) {
        this.thrust_max_speed = StringToSIUnitConverter.TSFC(th);
    }
    
    public boolean validate() {
        boolean v1 = thrust_0 > 0 && thrust_max_speed > 0;
        return v1 && max_speed > 0;
    }
}
