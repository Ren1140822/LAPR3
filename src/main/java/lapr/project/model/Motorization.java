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
    
    public Motorization(int number_motors, String motor, String motor_type, RegimeList regimeList){
        this.number_motors=number_motors;
        this.motor=motor;
        this.motor_type=motor_type;
        this.regimeList=new RegimeList();
    }

    /**
     * @return the number_motors
     */
    public int getNumber_motors() {
        return number_motors;
    }

    /**
     * @param number_motors the number_motors to set
     */
    public void setNumber_motors(int number_motors) {
        this.number_motors = number_motors;
    }

    /**
     * @return the motor
     */
    public String getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }

    /**
     * @return the motor_type
     */
    public String getMotor_type() {
        return motor_type;
    }

    /**
     * @param motor_type the motor_type to set
     */
    public void setMotor_type(String motor_type) {
        this.motor_type = motor_type;
    }

    /**
     * @return the regimeList
     */
    public RegimeList getRegimeList() {
        return regimeList;
    }

    /**
     * @param regimeList the regimeList to set
     */
    public void setRegimeList(RegimeList regimeList) {
        this.regimeList = regimeList;
    }

    /**
     * 
     * @return 
     */
    public boolean validate(){ 
        boolean v1 = !this.motor.isEmpty()
                && !this.motor_type.isEmpty()
                && this.number_motors!=0
                && !this.regimeList.getRegimeList().isEmpty(); 
        return v1;
    }
}
