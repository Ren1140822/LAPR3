/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Class that represents motorized commercial aircraft
 *
 * @author Diana Silva
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AircraftModel {

    private enum Type {
        PASSENGER, CARGO, MIXED
    };

    /**
     * Class attributes
     */
    @XmlAttribute(name="model_ID")
    private String id;
    @XmlAttribute(name="description")
    private String description;
    @XmlElement(name="maker")
    private String maker;
    @XmlElement(name="type")
    private Type type;
    @XmlElement(name="motorization")
    private Motorization motorization;
    @XmlElement(name="EWeight")
    private double eWeight;
    @XmlElement(name="MTOW")
    private double MTOW;
    @XmlElement(name="MZFW")
    private double MZFW;
    @XmlElement(name="max_payload")
    private double maxPayload;
    @XmlElement(name="fuel_capacity")
    private double fuelCapacity;
    @XmlElement(name="VMO")
    private double VMO;
    @XmlElement(name="MMO")
    private double MMO;
    @XmlElement(name="wing_area")
    private double wingArea;
    @XmlElement(name="wing_span")
    private double wingSpan;
    @XmlElement(name="Cdrag_0")
    private double cDrag;
    @XmlElement(name="e")
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
    private final Motorization DEFAULT_MOTORIZATION = new Motorization();
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
        motorization = DEFAULT_MOTORIZATION;
        eWeight = DEFAULT_EWEIGHT;
        MTOW = DEFAULT_MTOW;
        MZFW = DEFAULT_MZFW;
        maxPayload = DEFAULT_MAXPAYLOAD;
        fuelCapacity = DEFAULT_FUELCAPACITY;
        VMO = DEFAULT_VMO;
        MMO = DEFAULT_MMO;
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
     * @param wingCl
     * @param bodyCl
     * @param cDrag
     * @param e
     */
    public AircraftModel(String id, String description, String maker, String type,
            Motorization motorization, double eWeight, double MTOW, double MZFW, 
            double maxPayload,double fuelCapacity, double VMO, double MMO, double wingArea, 
            double wingSpan, double wingCl, double bodyCl, double cDrag, double e) {
        this.id = id;
        this.description = description;
        this.maker = maker;
        setType(type);
        this.motorization = motorization;
        this.eWeight = eWeight;
        this.MTOW = MTOW;
        this.MZFW = MZFW;
        this.maxPayload = maxPayload;
        this.fuelCapacity = fuelCapacity;
        this.VMO = VMO;
        this.MMO = MMO;
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
        this.MTOW = model.MTOW;
        this.MZFW = model.MZFW;
        this.maxPayload = model.maxPayload;
        this.fuelCapacity = model.fuelCapacity;
        this.VMO = model.VMO;
        this.MMO = model.MMO;
        this.wingArea = model.wingArea;
        this.wingSpan = model.wingSpan;
        this.cDrag = model.cDrag;
        this.e = model.e;
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

    public boolean validate() {
        boolean v1 = !id.isEmpty() && !description.isEmpty() && !maker.isEmpty();
        //v1 = v1 && motorization.validate() && !(eWeight > 0) && !(MTOW > 0);
        v1 = v1 && !(MZFW > 0) && !(maxPayload > 0) && !(fuelCapacity > 0);
        v1 = v1 && !(VMO > 0) && !(MMO > 0) && !(wingArea > 0);
        v1 = v1 && !(wingSpan > 0) && !(cDrag > 0) && !(e > 0);

        return v1;

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

    public Type getType() {
        return type;
    }

    public void setType(String type) {
        try{
            this.type = Type.valueOf(type.toUpperCase());
        }catch (IllegalArgumentException e){
            System.err.println(e);
        }
    }

    public Motorization getMotorization() {
        return motorization;
    }

    public void setMotorization(int number_motors, String motor, String motor_type, 
            List<Regime> regimeList) {
        motorization.setNumber_motors(number_motors);
        motorization.setMotor(motor);
        motorization.setMotor_type(motor_type);
        motorization.setRegimeList(regimeList);
        
    }

    public double geteWeight() {
        return eWeight;
    }

    public void seteWeight(double eWeight) {
        this.eWeight = eWeight;
    }

    public double getMTOW() {
        return MTOW;
    }

    public void setMTOW(double MTOW) {
        this.MTOW = MTOW;
    }

    public double getMZFW() {
        return MZFW;
    }

    public void setMZFW(double MZFW) {
        this.MZFW = MZFW;
    }

    public double getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(double maxPayload) {
        this.maxPayload = maxPayload;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getVMO() {
        return VMO;
    }

    public void setVMO(double VMO) {
        this.VMO = VMO;
    }

    public double getMMO() {
        return MMO;
    }

    public void setMMO(double MMO) {
        this.MMO = MMO;
    }

    public double getWingArea() {
        return wingArea;
    }

    public void setWingArea(double wingArea) {
        this.wingArea = wingArea;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
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

}
