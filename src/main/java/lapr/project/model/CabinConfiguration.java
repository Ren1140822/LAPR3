/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class CabinConfiguration implements Serializable {

    /**
     * Instance variables.
     */
    Map<String, Integer> mapOfClasses;

    /**
     * Parameter constructor.
     */
    public CabinConfiguration(Map<String, Integer> map) {
        this.mapOfClasses = map;
    }

    /**
     * Default constructor.
     */
    public CabinConfiguration() {
        this.mapOfClasses = new HashMap<>();
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
        return this.mapOfClasses.equals(otherCabin.mapOfClasses);
    }

    public int getTotalSeats() {
        int result = 0;
        for (Integer i : mapOfClasses.values()) {
            result += i;
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.mapOfClasses);
        return hash;
    }

}
