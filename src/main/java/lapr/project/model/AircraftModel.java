/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 * Class that represents motorized commercial aircraft
 * @author Diana Silva
 */
public class AircraftModel {
    /**
     * identification
     */
    private double id;
    
    private String maker;
    
    private enum type{
        PASSENGER, CARGO, MIXED
    };
    
    private Motorization motorization;
    
    private double EWeight;
    
    private double MTOW;
    
    private double MZFW;
    
    private double max_payload;
    
    private double fuel_capacity;
    
    private double VMO;
    
    private double MMO;
    
    private double wingArea;
    
    private double bodyArea;
    
    private double wingCl;
    
    private double bodyCl;
    
    private double Cdrag_0;
    
    private double e;
    
    public AircraftModel(double id, String maker, enum type, Motorization motorization,
            double eWeight, double MTOW, double MZFW, double max_payload, double 
                    fuel_capacity, double VMO, double MMO, double wingArea, double
                            bodyArea, double wingCl, double bodyCl, double Cdrag_0, double e){
        this.id=id;
        this.maker=maker;
        this.type=type;
        this.motorization=motorization;
        this.EWeight=eWeight;
        this.MTOW=MTOW;
        this.MZFW=MZFW;
        this.max_payload=max_payload;
        this.fuel_capacity=fuel_capacity;
        this.VMO=VMO;
        this.MMO=MMO;
        this.wingArea=wingArea;
        this.bodyArea=bodyArea;
        this.wingCl=wingCl;
        this.bodyCl=bodyCl;
        this.Cdrag_0=CDrag_0;
        this.e=e;
    }
    
}
