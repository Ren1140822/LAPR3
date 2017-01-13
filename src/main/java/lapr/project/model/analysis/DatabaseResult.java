/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class DatabaseResult {
    
    private String segID;
    private double TAS;
    private double altitude_ini;
    private double altitude_end;
    private double consumedFuel;

    /**
     * Parameter constructor for results that are loaded from database.
     * @param segID
     * @param TAS
     * @param altitude_ini
     * @param altitude_end
     * @param consumedFuel 
     */
    public DatabaseResult(String segID, double TAS, double altitude_ini, double altitude_end, double consumedFuel) {
        this.segID = segID;
        this.TAS = TAS;
        this.altitude_ini = altitude_ini;
        this.altitude_end = altitude_end;
        this.consumedFuel = consumedFuel;
    }
    
    
}
