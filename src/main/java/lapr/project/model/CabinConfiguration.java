/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class CabinConfiguration {

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

    public boolean equals(Object otherObject) {
        if (this == null) {
            return false;
        }
        if (this == otherObject) {
            return true;
        }
        CabinConfiguration otherCabin = (CabinConfiguration) otherObject;
        return this.numberOfSeatsComercial == otherCabin.numberOfSeatsComercial && this.numberOfSeatsEconomic == otherCabin.numberOfSeatsEconomic;
    }

}
