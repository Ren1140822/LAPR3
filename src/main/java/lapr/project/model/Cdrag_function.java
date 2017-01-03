/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.utils.StringToSIUnitConverter;

/**
 *
 * @author Pedro Fernandes
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Cdrag_function {   
    
    @XmlElementWrapper(name = "Cdrag_function")
    @XmlElement(name = "iten")
    private List<iten> listIten;
    
    public Cdrag_function(){
        listIten = new LinkedList<>();
    }
    
    public boolean addIten(double speed, double Cdrag_0){
        return listIten.add(new iten(speed, Cdrag_0));
    }

    /**
     * @return the listIten
     */
    public List<iten> getListIten() {
        return listIten;
    }

    /**
     * @param listIten the listIten to set
     */
    public void setListIten(List<iten> listIten) {
        this.listIten = listIten;
    }
    
    public boolean validate(){
        return !listIten.isEmpty();
    }
    
    
    private class iten{
        @XmlTransient
        private double speed;
        @XmlElement(name = "Cdrag_0")
        private double Cdrag_0;
        @XmlTransient
        private final double DEFAULT_SPEED = 1;
        @XmlTransient
        private final double DEFAULT_CDRAG_0 = 1;
        
        private iten(){
            this.speed = DEFAULT_SPEED;
            this.Cdrag_0 = DEFAULT_CDRAG_0;        
        }
        private iten(double speed, double Cdrag_0){
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
        
        public boolean validate(){
            return speed > 0 && Cdrag_0 >0;
        }
    
    }
}
