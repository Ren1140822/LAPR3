/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import lapr.project.model.Result;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ResultsList {

    private LinkedList<Result> shortesPathResultsList;
    private LinkedList<Result> bestResultsList;
    private LinkedList<Result> comparisonResultsList;

    public ResultsList() {
        shortesPathResultsList= new LinkedList();
        bestResultsList= new LinkedList();
        comparisonResultsList= new LinkedList();
    }

    /**
     * Gets all the results of usage of shortest path algorithm.
     * @return the list
     */
    public LinkedList<Result> getShortesPathResultsList() {
        return shortesPathResultsList;
    }

    /**
     * Sets the shortest path results list.
     * @param shortesPathResultsList the list to set
     */
    public void setShortesPathResultsList(LinkedList<Result> shortesPathResultsList) {
        this.shortesPathResultsList = shortesPathResultsList;
    }

    /**
     * Gets the best results list.
     * @return the list
     */
    public LinkedList<Result> getBestResultsList() {
        return bestResultsList;
    }

    /**
     * Sets the list of best results
     * @param bestResultsList the list to set
     */
    public void setBestResultsList(LinkedList<Result> bestResultsList) {
        this.bestResultsList = bestResultsList;
    }

    /**
     * Gets the results of comparison.
     * @return the list
     */
    public LinkedList<Result> getComparisonResultsList() {
        return comparisonResultsList;
    }

    /**
     * Sets the comparison results list.
     * @param comparisonResultsList  the list to set
     */
    public void setComparisonResultsList(LinkedList<Result> comparisonResultsList) {
        this.comparisonResultsList = comparisonResultsList;
    }

    

}
