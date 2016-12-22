/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;
import lapr.project.model.AirNetwork;
import lapr.project.model.Aircraft;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.mapgraph.GraphAlgorithms;


/**
 *
 * @author DianaSilva
 */
public class FastestPathResult extends ResultPath{
    /**
     * Aircraft of result path
     */
    private Aircraft aircraft;
    
    public FastestPathResult() {
        super();
    }
    public FastestPathResult(Node startNode, Node endNode, Aircraft aircraft){
        super(startNode, endNode);
        this.aircraft=aircraft;
    }
    
    @Override
    public void calculateBestPath(AirNetwork airNetwork){
        LinkedList<Node> fastestPath=super.getResultPath();
        /**corrigir**/
        double res=GraphAlgorithms.shortestPath(airNetwork.getAirNetwork(), super.getStartNode(), super.getEndNode(), fastestPath);
        super.setResult(res);
    }
}
