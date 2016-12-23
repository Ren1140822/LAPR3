/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.physics;

/**
 *
 * @author DianaSilva
 */
public class ConversionAlgorithms {
    /**
     * Meter to feet constant (1 unit meter= 3.280840 feets)
     */
    private static final double METER_FEET_CONSTANT= 3.280840; 
    
    /**
     * Pounds-force to gram constant (1 lbf= 44.4822 g)
     */
    private static final double LBF_GRAM_CONSTANT=44.4822;
    
    /**
     * Knots to meters/second constant (1kn= 0.514444m/s)
     */
    private static final double KNOT_MS=0.514444;
    
    /**
     * Converts meters to feets
     * @param meters value in meters
     * @return converted value (feets)
     */
    public static double convertMetersFeet(double meters){
        return meters*METER_FEET_CONSTANT;
    }
    
    public static double convertFeetM(double feet){
        return feet/METER_FEET_CONSTANT;
    }
    
    /**
     * Converts knots to meters/second
     * @param knot value in knots
     * @return converted value (m/s)
     */
    public static double convertKnotMS(double knot){
        return knot*KNOT_MS;
    }
    
    /**
     * Converts pounds-force into newtons (lbf to N)
     * @param lbf value in lbf
     * @return converted value (N)
     */
    public static double convertLbfN(double lbf){
        return lbf*LBF_GRAM_CONSTANT;
    }
}
