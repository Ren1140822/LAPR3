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
public class FastestPathResult extends Path implements BestPathInterface{
    private FlightPlan flightPlan;
    /**
     * Constructor
     * @param flightPlan
     */
    public FastestPathResult(FlightPlan flightPlan) {
        super();
        this.flightPlan=flightPlan;
    }
    
    /**
     * Calculates the fastest path
     * @param airNetwork airnetwork of active project
     */
    @Override
    public void calculateBestPath(AirNetwork airNetwork){
        LinkedList<Node> fastestPath=(LinkedList<Node>)super.getResultPath();
        AirNetwork clone=airNetwork;
                
       
        //vento+cruiseSpeed
        super.setResult(0);
        super.setResultPath(fastestPath);
    }
}
