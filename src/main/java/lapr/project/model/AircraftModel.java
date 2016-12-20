/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 * Class that represents motorized commercial aircraft
 *
 * @author Diana Silva
 */
public class AircraftModel {

    private enum Type {

        PASSENGER, CARGO, MIXED
    };

    /**
     * Class attributes
     */
    private String id;
    private String description;
    private String maker;
    private Type type;
    private Motorization motorization;
    private double eWeight;
    private double MTOW;
    private double MZFW;
    private double maxPayload;
    private double fuelCapacity;
    private double VMO;
    private double MMO;
    private double wingArea;
    private double wingSpan;
    private double cDrag;
    private double e;

    /**
     * Default attributes
     */
    private final String DEFAULT_ID = "Dummy 01";
    private final String DEFAULT_DESCRIPTION = "Dummy aircraft 01";
    private final String DEFAULT_MAKER = "Boeing";
    private final Type DEFAULT_TYPE = Type.PASSENGER;
    private final Motorization DEFAULT_MOTORIZATION = new Motorization();
    private final double DEFAULT_EWEIGHT = 1;
    private final double DEFAULT_MTOW = 1;
    private final double DEFAULT_MZFW = 1;
    private final double DEFAULT_MAXPAYLOAD = 1;
    private final double DEFAULT_FUELCAPACITY = 1;
    private final double DEFAULT_VMO = 1;
    private final double DEFAULT_MMO = 1;
    private final double DEFAULT_WINGAREA = 1;
    private final double DEFAULT_WINGSPAN = 1;
    private final double DEFAULT_CDRAG = 1;
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
    public AircraftModel(String id, String description, String maker, Motorization motorization,
            double eWeight, double MTOW, double MZFW, double maxPayload, double fuelCapacity, double VMO, double MMO, double wingArea, double wingSpan, double wingCl, double bodyCl, double cDrag, double e) {
        this.id = id;
        this.description = description;
        this.maker = maker;
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

    public void setType(Type type) {
        this.type = type;
    }

    public Motorization getMotorization() {
        return motorization;
    }

    public void setMotorization(Motorization motorization) {
        this.motorization = motorization;
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
