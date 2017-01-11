/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;

/**
 *
 * @author DianaSilva
 */
public class EcologicPathResult extends ResultPath implements BestPathInterface{
    private FlightPlan flightPlan;
    
    /**
     * Constructor
     * @param flightPlan
     */
    public EcologicPathResult(FlightPlan flightPlan){
        super();
        this.flightPlan=flightPlan;
    }
    
    @Override
    public void calculateBestPath(AirNetwork airNetwork) {
        LinkedList<Node> ecologicPath=(LinkedList<Node>)super.getResultPath();
        /**corrigir**/
        
        super.setResult(0);
        super.setResultPath(ecologicPath);
    }
}
