/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.lists.RegimeList;



/**
 * Class that represents the motorization of aircraft
 * @author Diana Silva
 */
public class Motorization {
    /**
     * number of motors
     */
    private int number_motors;
    
    /**
     * motor code (ex: GE CF6-80C2B1F
     */
    private String motor;
    
    /**
     * motor type (Ex: turbofan)
     */
    private String motor_type;

    private RegimeList regimeList;
        
}
