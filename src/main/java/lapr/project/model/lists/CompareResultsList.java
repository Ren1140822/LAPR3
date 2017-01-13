/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.analysis.ComparisonResult;

/**
 *
 * @author Diana Silva
 */
public class CompareResultsList implements Serializable {

     /**
     * Compare conditions
     */
    @XmlTransient
    private enum Criteria{
        AIRCRAFT, ENGINES
    }
   
    /**
     * The list of comparison results
     */
    private transient LinkedList<ComparisonResult> compareResults;
    
    /**
     * The comparison result 
     */
    private transient ComparisonResult compare;
    
    /**
     * Constructor
     */
    public CompareResultsList(){
         this.compareResults = new LinkedList<>();
    }
    
    /**
     * Gets the compare results list
     * @return the compare results list
     */
    public LinkedList<ComparisonResult> getCompareResults(){
        return  compareResults;
    }
    
    /**
     * Sets the compare results list
     * @param list the compare results list to set
     */
    public void setCompareList(LinkedList<ComparisonResult> list){
        this.compareResults=list;
    }
    
    public String[] getOptions(){
        String[] options ={Criteria.AIRCRAFT.name(),Criteria.ENGINES.name()} ;
        return options;
    }
    
    /**
     * Creates new comparison
     */
    public void createComparison() {
        compare=new ComparisonResult();
    }
    
    /**
     * Geths the comparison result created
     * @return comparison result
     */
    public ComparisonResult getCompareResult(){
        return compare;
    }
    
    /**
     * Validate and saves the comparison result into list
     * @return true if valid, false if not
     */
    public boolean saveCompareResult(){
        return validate() && addResult();
    }
    
    /**
     * Validate if comparison result is valid and do not exists in the list
     * @return true if comparison result is valid and do not exists in the list,
     * false if not
     */
    private boolean validate(){
        return compare.validate() && !compareResults.contains(compare);
    }
    
    /**
     * Add the simulation into the list
     * @return true if simulation is addef, false if not
     */
    private boolean addResult(){
        return compareResults.add(compare);
    }
    
}
