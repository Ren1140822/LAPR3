/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Node;
import lapr.project.model.anaylsis.EcologicPathResult;
import lapr.project.model.anaylsis.FastestPathResult;
import lapr.project.model.anaylsis.ShortestPathResult;
import lapr.project.model.anaylsis.ResultPath;

/**
 *
 * @author Renato Oliveira, Diana Silva
 */
public class ResultsList {

    private List<ResultPath> shortesPathResultsList;
    private List<ResultPath> ecologicResultsList;
    private List<ResultPath> fastestResultsList;
    private List<ResultPath> comparisonResultsList;

    public ResultsList() {
        shortesPathResultsList= new LinkedList<>();
        ecologicResultsList= new LinkedList<>();
        fastestResultsList= new LinkedList<>();
        comparisonResultsList= new LinkedList<>();
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
    public List<ResultPath> getShortesPathResultsList() {
        return shortesPathResultsList;
    }

    /**
     * Sets the shortest path results list.
     * @param shortesPathResultsList the list to set
     */
    public void setShortesPathResultsList(List<ResultPath> shortesPathResultsList) {
        this.shortesPathResultsList = shortesPathResultsList;
    }

    /**
     * Gets the best results list.
     * @return the list
     */
    public List<ResultPath> getEcologicResultsList() {
        return ecologicResultsList;
    }

    /**
     * Sets the list of best results
     * @param ecologicResultsList the list to set
     */
    public void setEcologicResultsList(List<ResultPath> ecologicResultsList) {
        this.ecologicResultsList = ecologicResultsList;
    }
    
    /**
     * Gets the fastest results list.
     * @return the list
     */
    public List<ResultPath> getFastestResultsList() {
        return fastestResultsList;
    }

    /**
     * Sets the list of best results
     * @param fastestResultsList the list to set
     */
    public void setFastestResultsList(List<ResultPath> fastestResultsList) {
        this.fastestResultsList = fastestResultsList;
    }
    

    /**
     * Gets the results of comparison.
     * @return the list
     */
    public List<ResultPath> getComparisonResultsList() {
        return comparisonResultsList;
    }

    /**
     * Sets the comparison results list.
     * @param comparisonResultsList  the list to set
     */
    public void setComparisonResultsList(List<ResultPath> comparisonResultsList) {
        this.comparisonResultsList = comparisonResultsList;
    }
    
    /**
     * Gests the List of analysis options 
     * @return analysis options
     */
    public Option[] getResultOptions(){
        return Option.values();
    }
    
   /**
     * Gests the List of comparison options 
     * @return analysis options
     */
    public OptionCompare[] getComparisonOptions(){
        return OptionCompare.values();
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