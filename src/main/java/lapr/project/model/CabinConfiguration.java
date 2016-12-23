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
    private int numberOfSeatsEconomic;
    private int numberOfSeatsComercial;

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

    /**
     * Gets the number of seats in comercial class
     * @return the numberOfSeatsComercial
     */
    public int getNumberOfSeatsComercial() {
        return numberOfSeatsComercial;
    }
    
    /**
     * Gets the number of seats in economic class
     * @return the numberOfSeatsEconomic
     */
    public int getNumberOfSeatsEconomic() {
        return numberOfSeatsEconomic;
    }
    
     /**
     * Gets the number of seats 
     * @return the number of seats
     */
    public int getTotalSeats() {
        return numberOfSeatsEconomic + numberOfSeatsComercial;
    }
    
    /**
     * Sets the number of seats in economic class
     * @param numberOfSeatsEconomic the numberOfSeatsEconomic to set
     */
    public void setNumberOfSeatsEconomic(int numberOfSeatsEconomic) {
        this.numberOfSeatsEconomic = numberOfSeatsEconomic;
    }

    /**
     * Sets the number of seat in comercial class
     * @param numberOfSeatsComercial the numberOfSeatsComercial to set
     */
    public void setNumberOfSeatsComercial(int numberOfSeatsComercial) {
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
        return this.getNumberOfSeatsComercial() == otherCabin.getNumberOfSeatsComercial() && this.getNumberOfSeatsEconomic() == otherCabin.getNumberOfSeatsEconomic();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.getNumberOfSeatsEconomic();
        hash = 97 * hash + this.getNumberOfSeatsComercial();
        return hash;
    }

  


}
