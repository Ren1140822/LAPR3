/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import lapr.project.model.Node;
import lapr.project.model.anaylsis.EcologicPathResult;
import lapr.project.model.anaylsis.FastestPathResult;
import lapr.project.model.anaylsis.Result;
import lapr.project.model.anaylsis.ShortestPathResult;

/**
 *
 * @author Renato Oliveira, Diana Silva
 */
public class ResultsList {

    private List<Result> shortesPathResultsList;
    private List<Result> ecologicResultsList;
    private List<Result> fastestResultsList;
    private List<Result> comparisonResultsList;

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
    public List<Result> getShortesPathResultsList() {
        return shortesPathResultsList;
    }

    /**
     * Sets the shortest path results list.
     * @param shortesPathResultsList the list to set
     */
    public void setShortesPathResultsList(List<Result> shortesPathResultsList) {
        this.shortesPathResultsList = shortesPathResultsList;
    }

    /**
     * Gets the best results list.
     * @return the list
     */
    public List<Result> getEcologicResultsList() {
        return ecologicResultsList;
    }

    /**
     * Sets the list of best results
     * @param ecologicResultsList the list to set
     */
    public void setEcologicResultsList(List<Result> ecologicResultsList) {
        this.ecologicResultsList = ecologicResultsList;
    }
    
    /**
     * Gets the fastest results list.
     * @return the list
     */
    public List<Result> getFastestResultsList() {
        return fastestResultsList;
    }

    /**
     * Sets the list of best results
     * @param fastestResultsList the list to set
     */
    public void setFastestResultsList(List<Result> fastestResultsList) {
        this.fastestResultsList = fastestResultsList;
    }
    

    /**
     * Gets the results of comparison.
     * @return the list
     */
    public List<Result> getComparisonResultsList() {
        return comparisonResultsList;
    }

    /**
     * Sets the comparison results list.
     * @param comparisonResultsList  the list to set
     */
    public void setComparisonResultsList(List<Result> comparisonResultsList) {
        this.comparisonResultsList = comparisonResultsList;
    }
    
    /**
     * Gests the List of analysis options 
     * @return analysis options
     */
    public Set<Option> getResultOptions(){
        Set<Option> optionsList=null;
        optionsList.addAll(Arrays.asList(Option.values()));
        return optionsList;
    }
    
   /**
     * Gests the List of comparison options 
     * @return analysis options
     */
    public Set<OptionCompare> getComparisonOptions(){
        Set<OptionCompare> optionsList=null;
        optionsList.addAll(Arrays.asList(OptionCompare.values()));
        return optionsList;
    }
    
    /**
     * Creates the result of shortest path analysis
     * @param startNode initial airport
     * @return result created
     */
    public ShortestPathResult newShortestResult(Node startNode){
        ShortestPathResult result=new ShortestPathResult(startNode);
        return result;
    }
    
    /**
     * Creates the result of fastest path analysis
     * @param startNode initial airport
     * @return result created
     */
    public FastestPathResult newFastestResult(Node startNode){
        FastestPathResult result=new FastestPathResult(startNode);
        return result;
    }
    
     
    /**
     * Creates the result of ecologic path analysis
     * @param startNode initial airport
     * @return result created
     */
    public EcologicPathResult newEcologicResult(Node startNode){
        EcologicPathResult result=new EcologicPathResult(startNode);
        return result;
    }   
}