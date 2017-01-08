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
     * Pounds-force to newton constant (1 lbf= 44.4822 n)
     */
    private static final double LBF_NEWTON_CONSTANT=44.4822;
    
    /**
     * Knots to meters/second constant (1kn= 0.514444m/s)
     */
    private static final double KNOT_MS=0.514444;
    
    /**
     * Pounds to grams constant (1lb=453.592) 
     */
    private static final double LBF_G_CONSTANT=453.592;
    
    /**
     * Gallons to liters (1galon=3.785411784
     */
    private static final double GAL_L=3.785411784;
    
    /**
     * Liters to Kg (1L=0.804kg)
     */
    private static final double L_KG=0.804;
    
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
        return lbf*LBF_NEWTON_CONSTANT;
    }
    
    /**
     * Converts pounds to gram (lbf to g)
     * @param lbf value in lbf
     * @return converted value (N)
     */
    public static double convertLbfGram(double lbf){
        return lbf*LBF_G_CONSTANT;
    }
    
    /**
     * Converts gallons to liters
     * @param gal galon
     * @return converted value (L)
     */
    public static double convertGallonsLit(double gal){
        return gal*GAL_L;
    }
    
    public static double convertLtoKg(double l){
        return l*L_KG;
    }
}
