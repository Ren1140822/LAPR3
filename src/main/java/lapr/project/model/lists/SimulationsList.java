/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Aircraft;
import lapr.project.model.Node;
import lapr.project.model.anaylsis.Simulation;

/**
 *
 * @author DianaSilva
 */
public class SimulationsList implements Serializable {
    
    
    /**
     * The list simulations
     */
    private List<Simulation> simulationsList;
  
       
    private Simulation simulation;
    
    
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
    
    public SimulationsList(List<Simulation> list){
        this.simulationsList=list;
    }
    
    /**
     * Gets the simulations list
     * @return the simulations list
     */
    public List<Simulation> getSimulationsList(){
        return simulationsList;
    }
    
    /**
     * Sets the simulations list
     * @param list the simulations list to set
     */
    public void setSimulationsList(List<Simulation> list){
        this.simulationsList=list;
    }
    
    /**
     * Creates new simulation
     */
    public void newSimulation(){
        simulation= new Simulation();
    }
    
    /**
     * Creates new simulation with data
     * @param startNode start airport
     * @param endNode end airport
     * @param aircraft aircraft
     * @param passengers total passengers
     * @param crew total persons of crew
     * @param cargoLoad cargo weight
     */
    public void newSimulation(Node startNode, Node endNode, Aircraft aircraft, int passengers, int crew, double cargoLoad){
        simulation= new Simulation(startNode, endNode, aircraft, passengers, crew, cargoLoad);
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
