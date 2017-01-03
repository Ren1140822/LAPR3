/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.utils.StringToSIUnitConverter;

/**
 * Class that represents motorized commercial aircraft
 *
 * @author Diana Silva, Flavio Relvas, Pedro Fernandes
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AircraftModel implements Serializable {

    /**
     * Class attributes
     */
    @XmlAttribute(name = "model_ID")
    private String id;

    /**
     * Type (passenger, cargo, mixed)
     */
    @XmlTransient
    private enum Type {

        PASSENGER, CARGO, MIXED
    };
    
    /**
     * Variable who stores the type
     */
    @XmlTransient
    private Type type;
    
    /**
     * Description of aircraft model
     */
    @XmlAttribute(name = "description")
    private String description;
    
    /**
     * Maker of aircraft model
     */
    @XmlElement(name = "maker")
    private String maker;
    
    /**
     * Motorization of aircraft model
     */
    @XmlElement(name = "motorization")
    private Motorization motorization;
    
    /**
     * Empty weight
     */
    @XmlTransient
    private double eWeight;
    
    /**
     * Maximum take-off weight (MTOW) - kg
     */
    @XmlTransient
    private double MTOW;
    
    /**
     * Maximum payload (kg)
     */
    @XmlTransient
    private double maxPayload;
    
    /**
     * Maximum fuel capacity (L)
     */
    @XmlTransient
    private double fuelCapacity;
    
    /**
     * VMO (knot)
     */
    @XmlTransient
    private double VMO;
    
    /**
     * Maximum operating Match number - MMO - (relative to the speed of sound)
     */
    @XmlTransient
    private double MMO;
    
    /**
     * Wing area (m2)
     */
    @XmlTransient
    private double wingArea;
    
    /**
     * Wing span - distance from one wingtip to the other (m)
     */
    @XmlTransient
    private double wingSpan;
    
    @XmlElement(name = "aspect_ratio")
    private double aspect_ratio;
    
    /**
     * Constant e
     */
    @XmlElement(name = "e")
    private double e;
    
    /**
     * Coefficient of drag
     */
    @XmlElementWrapper(name = "Cdrag_function")
    @XmlElement(name = "iten")
    private List<Iten> listIten;

    /**
     * Default attributes
     */
    @XmlTransient
    private final String DEFAULT_ID = "Dummy 01";
    @XmlTransient
    private final String DEFAULT_DESCRIPTION = "Dummy aircraft 01";
    @XmlTransient
    private final String DEFAULT_MAKER = "Boeing";
    @XmlTransient
    private final Type DEFAULT_TYPE = Type.PASSENGER;
    @XmlTransient
    private final double DEFAULT_EWEIGHT = 1;
    @XmlTransient
    private final double DEFAULT_MTOW = 1;
    @XmlTransient
    private final double DEFAULT_ASPECT_RATIO = 1;
    @XmlTransient
    private final double DEFAULT_MAXPAYLOAD = 1;
    @XmlTransient
    private final double DEFAULT_FUELCAPACITY = 1;
    @XmlTransient
    private final double DEFAULT_VMO = 1;
    @XmlTransient
    private final double DEFAULT_MMO = 1;
    @XmlTransient
    private final double DEFAULT_WINGAREA = 1;
    @XmlTransient
    private final double DEFAULT_WINGSPAN = 1;    
    @XmlTransient
    private final double DEFAULT_E = 1;

    /**
     * Default constructor
     */
    public AircraftModel() {
        id = DEFAULT_ID;
        description = DEFAULT_DESCRIPTION;
        maker = DEFAULT_MAKER;
        type = DEFAULT_TYPE;
        motorization = new Motorization();
        eWeight = DEFAULT_EWEIGHT;
        MTOW = DEFAULT_MTOW;
        maxPayload = DEFAULT_MAXPAYLOAD;
        fuelCapacity = DEFAULT_FUELCAPACITY;
        VMO = DEFAULT_VMO;
        MMO = DEFAULT_MMO;
        wingArea = DEFAULT_WINGAREA;
        wingSpan = DEFAULT_WINGSPAN;
        aspect_ratio = DEFAULT_ASPECT_RATIO;
        e = DEFAULT_E;
        listIten = new LinkedList<>();        
    }

    /**
     * Parameter constructor
     */
    /**
     *
     * @param id
     * @param description
     * @param maker
     * @param type
     * @param motorization
     * @param eWeight
     * @param MTOW
     * @param maxPayload
     * @param fuelCapacity
     * @param VMO
     * @param MMO
     * @param wingArea
     * @param aspect_ratio
     * @param wingSpan
     * @param listIten
     * @param e
     */
    public AircraftModel(String id, String description, String maker, String type,
            Motorization motorization, double eWeight, double MTOW,
            double maxPayload, double fuelCapacity, double VMO, double MMO,
            double wingArea, double wingSpan, double aspect_ratio,
            double e, List<Iten> listIten) {
        this.id = id;
        this.description = description;
        this.maker = maker;
        setType(type);
        this.motorization = motorization;
        this.eWeight = eWeight;
        this.MTOW = MTOW;
        this.maxPayload = maxPayload;
        this.fuelCapacity = fuelCapacity;
        this.VMO = VMO;
        this.MMO = MMO;
        this.wingArea = wingArea;
        this.wingSpan = wingSpan;
        this.aspect_ratio = aspect_ratio;
        this.e = e;
        this.listIten = listIten;
    }

    /**
     * Copy constructor
     *
     * @param model
     */
    public AircraftModel(AircraftModel model) {
        this.id = model.id;
        this.description = model.description;
        this.maker = model.maker;
        setType(model.getType());
        this.motorization = model.motorization;
        this.eWeight = model.eWeight;
        this.MTOW = model.MTOW;
        this.maxPayload = model.maxPayload;
        this.fuelCapacity = model.fuelCapacity;
        this.VMO = model.VMO;
        this.MMO = model.MMO;
        this.wingArea = model.wingArea;
        this.wingSpan = model.wingSpan;
        this.aspect_ratio = model.aspect_ratio;
        this.e = model.e;
        this.listIten = model.listIten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getType() {
        return type.toString();
    }

    public void setType(String type) {
        try {
            this.type = Type.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }

    @XmlElement(name = "type")
    public String getType_() {
        return String.valueOf(type);
    }

    public void setType_(String type) {
        setType(type);
    }

    public Motorization getMotorization() {
        return motorization;
    }

    public void setMotorization(Motorization motorization) {
        this.motorization = motorization;
    }

    public void setMotorization(int number_motors, String motor, String motor_type,
            double cruise_altitude, double cruise_speed, double TSFC,
            double lapse_rate_factor, Thrust_Function thrust_function) {
        motorization.setNumberMotors(number_motors);
        motorization.setMotor(motor);
        motorization.setMotorType(motor_type);
        motorization.setCruise_altitude(cruise_altitude);
        motorization.setCruise_speed(cruise_speed);
        motorization.setTSFC(TSFC);
        motorization.setLapse_rate_factor(lapse_rate_factor);
        motorization.setThrust_function(thrust_function);

    }

    public double geteWeight() {
        return eWeight;
    }

    public void seteWeight(double eWeight) {
        this.eWeight = eWeight;
    }

    @XmlElement(name = "EWeight")
    public String geteWeight_() {
        return String.valueOf(eWeight);
    }

    public void seteWeight_(String eWeight) {
        this.eWeight = StringToSIUnitConverter.weight(eWeight);
    }

    public double getMTOW() {
        return MTOW;
    }

    public void setMTOW(double MTOW) {
        this.MTOW = MTOW;
    }

    @XmlElement(name = "MTOW")
    public String getMTOW_() {
        return String.valueOf(MTOW);
    }

    public void setMTOW_(String MTOW) {
        this.MTOW = StringToSIUnitConverter.weight(MTOW);
    }

    public double getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(double maxPayload) {
        this.maxPayload = maxPayload;
    }

    @XmlElement(name = "max_payload")
    public String getMaxPayload_() {
        return String.valueOf(maxPayload);
    }

    public void setMaxPayload_(String maxPayload) {
        this.maxPayload = StringToSIUnitConverter.weight(maxPayload);;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @XmlElement(name = "fuel_capacity")
    public String getFuelCapacity_() {
        return String.valueOf(fuelCapacity);
    }

    public void setFuelCapacity_(String fuelCapacity) {
        this.fuelCapacity = StringToSIUnitConverter.volume(fuelCapacity);
    }

    public double getVMO() {
        return VMO;
    }

    public void setVMO(double VMO) {
        this.VMO = VMO;
    }

    @XmlElement(name = "VMO")
    public String getVMO_() {
        return String.valueOf(VMO);
    }

    public void setVMO_(String VMO) {
        String a = VMO.replaceAll(" Knot", "");
        this.VMO = Double.parseDouble(a);
    }

    public double getMMO() {
        return MMO;
    }

    public void setMMO(double MMO) {
        this.MMO = MMO;
    }

    @XmlElement(name = "MMO")
    public String getMMO_() {
        return String.valueOf(MMO);
    }

    public void setMMO_(String MMO) {
        String a = MMO.replaceAll(" M", "");
        this.MMO = Double.parseDouble(a);
    }

    public double getWingArea() {
        return wingArea;
    }

    public void setWingArea(double wingArea) {
        this.wingArea = wingArea;
    }

    @XmlElement(name = "wing_area")
    public String getWingArea_() {
        return String.valueOf(wingArea);
    }

    public void setWingArea_(String wingArea) {
        this.wingArea = StringToSIUnitConverter.area(wingArea);
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    @XmlElement(name = "wing_span")
    public String getWingSpan_() {
        return String.valueOf(wingSpan);
    }

    public void setWingSpan_(String wingSpan) {
        this.wingSpan = StringToSIUnitConverter.length(wingSpan);
    }

    /**
     * @return the aspect_ratio
     */
    public double getAspect_ratio() {
        return aspect_ratio;
    }

    /**
     * @param aspect_ratio the aspect_ratio to set
     */
    public void setAspect_ratio(double aspect_ratio) {
        this.aspect_ratio = aspect_ratio;
    }
    
    public boolean addIten(double speed, double Cdrag_0){
        Iten i = new Iten(speed, Cdrag_0);
        return listIten.add(i);
    }

    /**
     * @return the listIten
     */
    public List<Iten> getListIten() {
        return listIten;
    }

    /**
     * @param listIten the listIten to set
     */
    public void setListIten(List<Iten> listIten) {
        this.listIten = listIten;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        if (this == otherObject) {
            return true;
        }

        AircraftModel other = (AircraftModel) otherObject;
        return this.id.equalsIgnoreCase(other.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id.hashCode();
        return hash;
    }

    public boolean validate() {
        boolean v1 = !id.isEmpty() && !description.isEmpty() && !maker.isEmpty();
        v1 = v1 && motorization != null && eWeight > 0 && MTOW > 0;
        v1 = v1 && maxPayload > 0 && fuelCapacity > 0 && aspect_ratio > 0;
        v1 = v1 && VMO > 0 && MMO > 0 && wingArea > 0;
        v1 = v1 && wingSpan > 0  && e > 0;
        v1 = v1 && type != null && motorization.validate();

        return v1;
    }
}
