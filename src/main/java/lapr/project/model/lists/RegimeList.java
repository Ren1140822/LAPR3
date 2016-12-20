/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Regime;

/**
 *
 * @author Diana Silva
 */
public class RegimeList {
    private List<Regime> regimeList;

    public RegimeList(){
        regimeList=new LinkedList<>();
    }
        
        /**
     * Gets the regime list.
     * @return the regime list
     */
    public List<Regime> getRegimeList() {
        return regimeList;
    }

    /**
     * Sets the regime list.
     * @param regimeList the list to set
     */
    public void setRegimeist(List<Regime> regimeList) {
        this.regimeList= regimeList;
    }
    
    /**
     * create Regime
     * @return 
     */
    public Regime newRegime(){
        return new Regime();
    }
    
    /**
     * validate and saves the regime into regimeList
     * @param regime
     * @return true if regiem is valid and it´s added, false if not
     */
    public boolean saveRegime(Regime regime){
        return validate(regime) && addRegime(regime);       
    }
    
    /**
     * validate if regime is valid and do not exist in the list
     * @param regime regime
     * @return true if regime is valid and do not exist in the list, false if not
     */
    public boolean validate(Regime regime){
        return regime.validate() && !regimeList.contains(regime);
    }
    
    /**
     * add the regime into the list
     * @return true if regime is added, false if not
     */
    private boolean addRegime(Regime regime){
        return regimeList.add(regime);
    }

}
