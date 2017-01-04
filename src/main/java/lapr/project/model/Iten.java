/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.utils.StringToSIUnitConverter;

/**
 *
 * @author Pedro Fernandes
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Iten implements Serializable{

    @XmlTransient
    private double speed;
    @XmlElement(name = "Cdrag_0")
    private double Cdrag_0;
    @XmlTransient
    private final double DEFAULT_SPEED = 1;
    @XmlTransient
    private final double DEFAULT_CDRAG_0 = 1;

    public Iten() {
        this.speed = DEFAULT_SPEED;
        this.Cdrag_0 = DEFAULT_CDRAG_0;
    }

    public Iten(double speed, double Cdrag_0) {
        this.speed = speed;
        this.Cdrag_0 = Cdrag_0;
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
     * @param speed the speed to set for JAXB
     */
    public void setSpeed_(String speed) {
        this.speed = StringToSIUnitConverter.speed(speed);
    }

    /**
     * @return the Cdrag_0
     */
    public double getCdrag_0() {
        return Cdrag_0;
    }

    /**
     * @param Cdrag_0 the Cdrag_0 to set
     */
    public void setCdrag_0(double Cdrag_0) {
        this.Cdrag_0 = Cdrag_0;
    }

    public boolean validate() {
        return speed > 0 && Cdrag_0 > 0;
    }
    
    @Override
    public String toString(){
        return "Speed: " + speed + " Cdrag: " + Cdrag_0;
    }

}
