/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import lapr.project.model.Node;
import lapr.project.model.anaylsis.ComparisonResult;
import lapr.project.model.anaylsis.EcologicPathResult;
import lapr.project.model.anaylsis.FastestPathResult;
import lapr.project.model.anaylsis.Result;
import lapr.project.model.anaylsis.ShortestPathResult;

/**
 *
 * @author Renato Oliveira, Diana Silva
 */
public class ResultsList {

    private LinkedList<Result> shortesPathResultsList;
    private LinkedList<Result> ecologicResultsList;
    private LinkedList<Result> fastestResultsList;
    private LinkedList<ComparisonResult> comparisonResultsList;

    public ResultsList() {
        shortesPathResultsList= new LinkedList();
        ecologicResultsList= new LinkedList();
        fastestResultsList= new LinkedList<>();
        comparisonResultsList= new LinkedList();
    }
    
    public enum Option{
        SHORTEST_PATH, ECOLOGIC_PATH, FASTEST_PATH;
    }
    
    public enum OptionCompare{
        VELOCITY, ENERGY_CONSUMPTION,FLIGHT_TIME; 
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
    public LinkedList<Result> getEcologicResultsList() {
        return ecologicResultsList;
    }

    /**
     * Sets the list of best results
     * @param ecologicResultsList the list to set
     */
    public void setEcologicResultsList(LinkedList<Result> ecologicResultsList) {
        this.ecologicResultsList = ecologicResultsList;
    }
    
    /**
     * Gets the fastest results list.
     * @return the list
     */
    public LinkedList<Result> getFastestResultsList() {
        return fastestResultsList;
    }

    /**
     * Sets the list of best results
     * @param fastestResultsList the list to set
     */
    public void setFastestResultsList(LinkedList<Result> fastestResultsList) {
        this.fastestResultsList = fastestResultsList;
    }
    

    /**
     * Gets the results of comparison.
     * @return the list
     */
    public LinkedList<ComparisonResult> getComparisonResultsList() {
        return comparisonResultsList;
    }

    /**
     * Sets the comparison results list.
     * @param comparisonResultsList  the list to set
     */
    public void setComparisonResultsList(LinkedList<ComparisonResult> comparisonResultsList) {
        this.comparisonResultsList = comparisonResultsList;
    }
    
    /**
     * Gests the List of analysis options 
     * @return analysis options
     */
    public HashSet<Option> getResultOptions(){
        HashSet<Option> optionsList=null;
        optionsList.addAll(Arrays.asList(Option.values()));
        return optionsList;
    }
    
   /**
     * Gests the List of comparison options 
     * @return analysis options
     */
    public HashSet<OptionCompare> getComparisonOptions(){
        HashSet<OptionCompare> optionsList=null;
        optionsList.addAll(Arrays.asList(OptionCompare.values()));
        return optionsList;
    }
    
    /**
     * Creates the result of shortest path analysis
     * @param startNode initial airport
     * @param endNode final airport
     * @return result created
     */
    public ShortestPathResult newShortestResult(Node startNode){
        ShortestPathResult result=new ShortestPathResult(startNode);
        return result;
    }
    
    /**
     * Creates the result of fastest path analysis
     * @param startNode initial airport
     * @param endNode final airport
     * @return result created
     */
    public FastestPathResult newFastestResult(Node startNode){
        FastestPathResult result=new FastestPathResult(startNode);
        return result;
    }
    
     
    /**
     * Creates the result of ecologic path analysis
     * @param startNode initial airport
     * @param endNode final airport
     * @return result created
     */
    public EcologicPathResult newEcologicResult(Node startNode){
        EcologicPathResult result=new EcologicPathResult(startNode);
        return result;
    }   
}