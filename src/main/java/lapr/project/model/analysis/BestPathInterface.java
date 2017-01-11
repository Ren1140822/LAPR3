/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import lapr.project.model.AirNetwork;
import lapr.project.model.Node;

/**
 *
 * @author Diana Silva
 */
public interface BestPathInterface {
    public void calculateBestPath(AirNetwork airNetwork, Node start, Node end);
}
