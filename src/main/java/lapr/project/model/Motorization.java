package lapr.project.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Class that represents the motorization of aircraft
 *
 * @author Diana Silva
 */
@XmlRootElement(name = "motorization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Motorization implements Serializable{

    /**
     * Class attributes
     */
    @XmlElement(name = "number_motors")
    private int numberMotors;
    @XmlElement(name = "motor")
    private String motor;
    @XmlElement(name = "motor_type")
    private String motorType;
    @XmlElementWrapper(name = "regime_list")
    @XmlElement(name = "regime")
    private List<Regime> regimeList;

    /**
     * Default attributes
     */
    @XmlTransient
    private static final int DEFAULT_NUMBER_MOTORS = 0;
    @XmlTransient
    private static final String DEFAULT_MOTOR = "NOMOTOR";
    @XmlTransient
    private static final String DEFAULT_MOTOR_TYPE = "NOMOTORTYPE";

    /**
     * Default constructor
     */
    public Motorization() {
        this.numberMotors = DEFAULT_NUMBER_MOTORS;
        this.motor = DEFAULT_MOTOR;
        this.motorType = DEFAULT_MOTOR_TYPE;
        this.regimeList = new LinkedList<>();
    }

    /**
     * Parameter constructor
     *
     * @param numberMotors
     * @param motor
     * @param motorType
     * @param regimeList
     */
    public Motorization(int numberMotors, String motor, String motorType,
            List<Regime> regimeList) {
        this.numberMotors = numberMotors;
        this.motor = motor;
        this.motorType = motorType;
        this.regimeList = regimeList;
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

//********************** regime list ***************************************
    /**
     * @return the regimeList
     */
    public List<Regime> getRegimeList() {
        return regimeList;
    }

    /**
     * @param regimeList the regimeList to set
     */
    public void setRegimeList(List<Regime> regimeList) {
        this.regimeList = regimeList;
    }

    public Regime newRegime() {
        return new Regime();
    }

    /**
     * validate and saves the regime into regimeList
     *
     * @param regime
     * @return true if regiem is valid and it´s added, false if not
     */
    public boolean saveRegime(Regime regime) {
        if (validate(regime)) {
            addRegime(regime);
            return true;
        }
        return false;
    }

    /**
     * validate if regime is valid and do not exist in the list
     *
     * @param regime regime
     * @return true if regime is valid and do not exist in the list, false if
     * not
     */
    private boolean validate(Regime regime) {
        return regime.validate() && !regimeList.contains(regime);
    }

    /**
     * add the regime into the list
     *
     * @return true if regime is added, false if not
     */
    private boolean addRegime(Regime regime) {
        return regimeList.add(regime);
    }
// ************************* end regime list ***********************************

    /**
     * 
     * @return
     */
    public boolean validate() {
        boolean v1 = this.numberMotors > 0
                && !this.motorType.isEmpty()
                && !this.motor.isEmpty()
                && this.regimeList.size() > 0;
        return v1;
    }
}
