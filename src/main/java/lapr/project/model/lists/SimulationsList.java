/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import lapr.project.model.analysis.Simulation;

/**
 *
 * @author DianaSilva
 */
public class SimulationsList implements Serializable {
    
    
    /**
     * The list simulations
     */
    private transient LinkedList<Simulation> simulationsList;
  
    /**
     * The simulation created
     */   
    private transient Simulation simulation;
    
    /**
     * Constructor
     */
    public SimulationsList(){
        this.simulationsList=new LinkedList<>();
    }
    
    /**
     * Copy constructor.
     * @param list the instance of this class
     */
    public SimulationsList(SimulationsList list)
    {
        this.simulationsList = list.getSimulationsList();
    }
    
    public SimulationsList(LinkedList<Simulation> list){
        this.simulationsList=list;
    }
    
    /**
     * Gets the simulations list
     * @return the simulations list
     */
    public LinkedList<Simulation> getSimulationsList(){
        return simulationsList;
    }
    
    /**
     * Sets the simulations list
     * @param list the simulations list to set
     */
    public void setSimulationsList(LinkedList<Simulation> list){
        this.simulationsList=list;
    }
    
    /**
     * Creates new simulation
     */
    public void newSimulation(){
        simulation= new Simulation();
        
    }
    
    /**
     * Gets the simulation created
     * @return simulation
     */
    public Simulation getSimulation(){
        return simulation;
    }
    
    
    /**
     * Validate and saves the simulation into simulations list
     * @return true if valid, false if not
     */
    public boolean saveSimulation(){
        return validate() && addSimulation();
    }
    
    /**
     * Validate if simulation is valid and do not exists in the simulations list
     * @return true if simulation is valid and do not exists in the list, false if not
     */
    private boolean validate(){
        return simulation.validate() && !simulationsList.contains(simulation);
    }
    
    /**
     * Add the simulation into the list
     * @return true if simulation is addef, false if not
     */
    private boolean addSimulation(){
        return simulationsList.add(simulation);
    }
    
    
    
    
}
