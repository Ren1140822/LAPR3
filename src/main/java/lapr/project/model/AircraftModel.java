/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.utils.StringToSIUnitConverter;

/**
 * Class that represents motorized commercial aircraft
 *
 * @author Diana Silva, Flavio Relvas
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
    private double maxTakeOffWeight;
    
    /**
     * Maximum zero fuel weight (maxZeroFuelWeight) - kg
     */
    @XmlTransient
    private double maxZeroFuelWeight;
    
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
     * Maximum operating speed (maximum permitted speed for the aircraft)- m/s
     */
    @XmlTransient
    private double maxSpeed;
    @XmlTransient
    
    /**
     * Maximum operating Match number - MMO - (relative to the speed of sound)
     */
    private double matchOperating;
    
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
    
    /**
     * Coefficient of drag
     */
    @XmlElement(name = "Cdrag_0")
    private double cDrag;
    
    /**
     * Constant e
     */
    @XmlElement(name = "e")
    private double e;

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
    private final double DEFAULT_MZFW = 1;
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
    private final double DEFAULT_CDRAG = 1;
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
        maxTakeOffWeight = DEFAULT_MTOW;
        maxZeroFuelWeight = DEFAULT_MZFW;
        maxPayload = DEFAULT_MAXPAYLOAD;
        fuelCapacity = DEFAULT_FUELCAPACITY;
        maxSpeed = DEFAULT_VMO;
        matchOperating = DEFAULT_MMO;
        wingArea = DEFAULT_WINGAREA;
        wingSpan = DEFAULT_WINGSPAN;
        cDrag = DEFAULT_CDRAG;
        e = DEFAULT_E;
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
     * @param MZFW
     * @param maxPayload
     * @param fuelCapacity
     * @param VMO
     * @param MMO
     * @param wingArea
     * @param wingSpan
     * @param cDrag
     * @param e
     */
    public AircraftModel(String id, String description, String maker, String type,
            Motorization motorization, double eWeight, double MTOW, double MZFW,
            double maxPayload, double fuelCapacity, double VMO, double MMO, double wingArea,
            double wingSpan, double cDrag, double e) {
        this.id = id;
        this.description = description;
        this.maker = maker;
        setType(type);
        this.motorization = motorization;
        this.eWeight = eWeight;
        this.maxTakeOffWeight = MTOW;
        this.maxZeroFuelWeight = MZFW;
        this.maxPayload = maxPayload;
        this.fuelCapacity = fuelCapacity;
        this.maxSpeed = VMO;
        this.matchOperating = MMO;
        this.wingArea = wingArea;
        this.wingSpan = wingSpan;
        this.cDrag = cDrag;
        this.e = e;
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
        this.motorization = model.motorization;
        this.eWeight = model.eWeight;
        this.maxTakeOffWeight = model.maxTakeOffWeight;
        this.maxZeroFuelWeight = model.maxZeroFuelWeight;
        this.maxPayload = model.maxPayload;
        this.fuelCapacity = model.fuelCapacity;
        this.maxSpeed = model.maxSpeed;
        this.matchOperating = model.matchOperating;
        this.wingArea = model.wingArea;
        this.wingSpan = model.wingSpan;
        this.cDrag = model.cDrag;
        this.e = model.e;
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
            List<Regime> regimeList) {
        motorization.setNumberMotors(number_motors);
        motorization.setMotor(motor);
        motorization.setMotorType(motor_type);
        motorization.setRegimeList(regimeList);

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
        return maxTakeOffWeight;
    }

    public void setMTOW(double MTOW) {
        this.maxTakeOffWeight = MTOW;
    }

    @XmlElement(name = "MTOW")
    public String getMTOW_() {
        return String.valueOf(maxTakeOffWeight);
    }

    public void setMTOW_(String MTOW) {
        this.maxTakeOffWeight = StringToSIUnitConverter.weight(MTOW);
    }

    public double getMZFW() {
        return maxZeroFuelWeight;
    }

    public void setMZFW(double MZFW) {
        this.maxZeroFuelWeight = MZFW;
    }

    @XmlElement(name = "MZFW")
    public String getMZFW_() {
        return String.valueOf(maxZeroFuelWeight);
    }

    public void setMZFW_(String MZFW) {
        this.maxZeroFuelWeight = StringToSIUnitConverter.weight(MZFW);
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
        return maxSpeed;
    }

    public void setVMO(double VMO) {
        this.maxSpeed = VMO;
    }

    @XmlElement(name = "VMO")
    public String getVMO_() {
        return String.valueOf(maxSpeed);
    }

    public void setVMO_(String VMO) {
        String a = VMO.replaceAll(" Knot", "");
        this.maxSpeed = Double.parseDouble(a);
    }

    public double getMMO() {
        return matchOperating;
    }

    public void setMMO(double MMO) {
        this.matchOperating = MMO;
    }

    @XmlElement(name = "MMO")
    public String getMMO_() {
        return String.valueOf(matchOperating);
    }

    public void setMMO_(String MMO) {
        String a = MMO.replaceAll(" M", "");
        this.matchOperating = Double.parseDouble(a);
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

    public double getcDrag() {
        return cDrag;
    }

    public void setcDrag(double cDrag) {
        this.cDrag = cDrag;
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
        v1 = v1 && motorization != null && eWeight > 0 && maxTakeOffWeight > 0;
        v1 = v1 && maxZeroFuelWeight > 0 && maxPayload > 0 && fuelCapacity > 0;
        v1 = v1 && maxSpeed > 0 && matchOperating > 0 && wingArea > 0;
        v1 = v1 && wingSpan > 0 && cDrag > 0 && e > 0;
        v1 = v1 && type != null && motorization.validate();

        return v1;

    }
}
