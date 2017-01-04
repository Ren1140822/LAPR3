package lapr.project.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.utils.StringToSIUnitConverter;

/**
 * Class that represents the motorization of aircraft
 *
 * @author Diana Silva
 */
@XmlRootElement(name = "motorization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Motorization implements Serializable {

    /**
     * Class attributes
     */
    @XmlElement(name = "number_motors")
    private int numberMotors;
    @XmlElement(name = "motor")
    private String motor;
    @XmlElement(name = "motor_type")
    private String motorType;
    @XmlTransient
    private double cruise_altitude;
    @XmlTransient
    private double cruise_speed;
    /**
     * thrust specific fuel consumption (fuel efficienty) - fuel consumption
     * (grams/second) per unit of thrust (kN) (SI units).
     */
    @XmlTransient
    private double TSFC;
    @XmlElement(name = "lapse_rate_factor")
    private double lapse_rate_factor;
    @XmlElement(name = "thrust_function")
    private Thrust_Function thrust_function;

    /**
     * Default attributes
     */
    @XmlTransient
    private static final int DEFAULT_NUMBER_MOTORS = 0;
    @XmlTransient
    private static final String DEFAULT_MOTOR = "NOMOTOR";
    @XmlTransient
    private static final String DEFAULT_MOTOR_TYPE = "NOMOTORTYPE";
    @XmlTransient
    private static final double DEFAULT_CRUISE_ALTITUDE = 0;
    @XmlTransient
    private static final double DEFAULT_CRUISE_SPEED = 0;
    @XmlTransient
    private static final double DEFAULT_TSFC = 0;
    @XmlTransient
    private static final double DEFAULT_LAPSE_RATE = 0;

    /**
     * Default constructor
     */
    public Motorization() {
        this.numberMotors = DEFAULT_NUMBER_MOTORS;
        this.motor = DEFAULT_MOTOR;
        this.motorType = DEFAULT_MOTOR_TYPE;
        this.cruise_altitude = DEFAULT_CRUISE_ALTITUDE;
        this.cruise_speed = DEFAULT_CRUISE_SPEED;
        this.TSFC = DEFAULT_TSFC;
        this.lapse_rate_factor = DEFAULT_LAPSE_RATE;
        this.thrust_function = new Thrust_Function();
    }

    /**
     * Parameter constructor
     *
     * @param numberMotors
     * @param motor
     * @param motorType
     * @param cruise_altitude
     * @param cruise_speed
     * @param TSFC
     * @param lapse_rate_factor
     * @param thrust_function
     */
    public Motorization(int numberMotors, String motor, String motorType,
            double cruise_altitude, double cruise_speed, double TSFC,
            double lapse_rate_factor, Thrust_Function thrust_function) {
        this.numberMotors = numberMotors;
        this.motor = motor;
        this.motorType = motorType;
        this.cruise_altitude = cruise_altitude;
        this.cruise_speed = cruise_speed;
        this.TSFC = TSFC;
        this.lapse_rate_factor = lapse_rate_factor;
        this.thrust_function = thrust_function;
    }

    /**
     * @return the numberMotors
     */
    public int getNumberMotors() {
        return numberMotors;
    }

    /**
     * @param numberMotors the numberMotors to set
     */
    public void setNumberMotors(int numberMotors) {
        this.numberMotors = numberMotors;
    }

    /**
     * @return the motor
     */
    public String getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

    /**
     * @return the motorType
     */
    public String getMotorType() {
        return motorType;
    }

    /**
     * @param motorType the motorType to set
     */
    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    /**
     * @return the cruise_altitude
     */
    public double getCruise_altitude() {
        return cruise_altitude;
    }

    /**
     * @param cruise_altitude the cruise_altitude to set
     */
    public void setCruise_altitude(double cruise_altitude) {
        this.cruise_altitude = cruise_altitude;
    }

    /**
     * @return the cruise_altitude for JAXB
     */
    @XmlElement(name = "cruise_altitude")
    public String getCruise_altitude_() {
        return String.valueOf(cruise_altitude);
    }

    /**
     * @param cruise_altitude the cruise_altitude to set for JAXB
     */
    public void setCruise_altitude_(String cruise_altitude) {
        this.cruise_altitude = StringToSIUnitConverter.length(cruise_altitude);
    }

    /**
     * @return the cruise_speed
     */
    public double getCruise_speed() {
        return cruise_speed;
    }

    /**
     * @param cruise_speed the cruise_speed to set
     */
    public void setCruise_speed(double cruise_speed) {
        this.cruise_speed = cruise_speed;
    }

    /**
     * @return the cruise_speed for JAXB
     */
    @XmlElement(name = "cruise_speed")
    public String getCruise_speed_() {
        return String.valueOf(cruise_speed);
    }

    /**
     * @param cruise_speed the cruise_speed to set for JAXB
     */
    public void setCruise_speed_(String cruise_speed) {
        this.cruise_speed = StringToSIUnitConverter.speed(cruise_speed);
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
    @XmlElement(name = "TSFC")
    public String getTSFC_() {
        return String.valueOf(TSFC);
    }

    /**
     * @param TSFC the TSFC to set for JAXB
     */
    public void setTSFC_(String TSFC) {
        this.TSFC = StringToSIUnitConverter.TSFC(TSFC);
    }

    /**
     * @return the lapse_rate_factor
     */
    public double getLapse_rate_factor() {
        return lapse_rate_factor;
    }

    /**
     * @param lapse_rate_factor the lapse_rate_factor to set
     */
    public void setLapse_rate_factor(double lapse_rate_factor) {
        this.lapse_rate_factor = lapse_rate_factor;
    }

    /**
     * @return the thrust_function
     */
    public Thrust_Function getThrust_function() {
        return thrust_function;
    }

    /**
     * @param thrust_function the thrust_function to set
     */
    public void setThrust_function(Thrust_Function thrust_function) {
        this.thrust_function = thrust_function;
    }

    /**
     *
     * @return
     */
    public boolean validate() {
        boolean v1 = this.numberMotors > 0
                && !this.motorType.isEmpty()
                && !this.motor.isEmpty()
                && this.getThrust_function().validate();
        return v1;
    }

}
