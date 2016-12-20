/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class CabinConfiguration implements Serializable{

    /**
     * Instance variables.
     */
    int numberOfSeatsEconomic;
    int numberOfSeatsComercial;

    /**
     * Parameter constructor.
     *
     * @param numberOfSeatsEconomic number of seats in economic class
     * @param numberOfSeatsComercial number of seats in commercial class
     */
    public CabinConfiguration(int numberOfSeatsEconomic, int numberOfSeatsComercial) {
        this.numberOfSeatsEconomic = numberOfSeatsEconomic;
        this.numberOfSeatsComercial = numberOfSeatsComercial;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        if (this == otherObject) {
            return true;
        }

        CabinConfiguration otherCabin = (CabinConfiguration) otherObject;
        return this.numberOfSeatsComercial == otherCabin.numberOfSeatsComercial && this.numberOfSeatsEconomic == otherCabin.numberOfSeatsEconomic;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.numberOfSeatsEconomic;
        hash = 97 * hash + this.numberOfSeatsComercial;
        return hash;
    }

}
