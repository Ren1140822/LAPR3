/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.anaylsis.ResultPath;
import lapr.project.model.lists.AircraftList;
import lapr.project.model.lists.AircraftModelList;
import lapr.project.model.lists.AirportList;
import lapr.project.model.lists.CompareResultsList;
import lapr.project.model.lists.SimulationsList;

/**
 * Class that represents a simulation of air network fights
 *
 * @author Renato Oliveira, Pedro Fernandes, Diana Silva
 */
public class Project implements Serializable {

    /**
     * Variables to read from DAL or file.
     */
    private AircraftList aircraftList;
    private AirNetwork network;
    private AirportList airportList;
    private CompareResultsList compareList;
//         public static FlightList flightList;
    private AircraftModelList modelList;
    private SimulationsList simulationsList;

    private int idProject;
    private String name;
    private String description;

    private final int DEFAULT_ID_PROJECT = 0;
    private final String DEFAULT_NAME = "NO_NAME_PROJECT";
    private final String DEFAULT_DESCRIPTION = "NO_DESCRIPTION";

    /**
     * constructor by default
     */
    public Project() {
        this.idProject = DEFAULT_ID_PROJECT;
        this.name = DEFAULT_NAME;
        this.description = DEFAULT_DESCRIPTION;
        this.aircraftList = new AircraftList();
        this.network = new AirNetwork();
        this.airportList = new AirportList();
        this.compareList = new CompareResultsList();
//         this.flightList=new FlightList();
        this.modelList = new AircraftModelList();
        this.simulationsList = new SimulationsList();
    }
    
    /**
     * Constructor copy
     * @param proj project
     */
    public Project(Project proj) {
        this.idProject = proj.idProject;
        this.name = proj.name;
        this.description = proj.description;
        this.aircraftList = proj.aircraftList;
        this.network = proj.network;
        this.airportList = proj.airportList;
        this.compareList = proj.compareList;
//         this.flightList=proj.flightList;
        this.modelList = proj.modelList;
        this.simulationsList = proj.simulationsList;
    }
    
    /**
     * Constructor copy
     * @param idProject idProject
     * @param name name
     * @param description description
     * @param aircraftList aircraftList
     * @param network network
     * @param airportList airportList
     * @param compareList compareList
     * @param modelList modelList
     * @param simulationsList simulationsList
     */
    public Project(int idProject, String name, String description, AircraftList aircraftList,
        AirNetwork network, AirportList airportList, CompareResultsList compareList,
        AircraftModelList modelList, SimulationsList simulationsList) {
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.aircraftList = aircraftList;
        this.network = network;
        this.airportList = airportList;
        this.compareList = compareList;
//         this.flightList = flightList;
        this.modelList = modelList;
        this.simulationsList = simulationsList;
    }

    /**
     * @return the aircraftList
     */
    public AircraftList getAircraftList() {
        return aircraftList;
    }

    /**
     * @param aircraftList the aircraftList to set
     */
    public void setAircraftList(AircraftList aircraftList) {
        this.aircraftList = aircraftList;
    }

    /**
     * @return the network
     */
    public AirNetwork getAirNetwork() {
        return network;
    }

    /**
     * @param network the network to set
     */
    public void setNetwork(AirNetwork network) {
        this.network = network;
    }

    /**
     * @return the airportList
     */
    public AirportList getAirportList() {
        return airportList;
    }

    /**
     * @param airportList the airportList to set
     */
    public void setAirportList(AirportList airportList) {
        this.airportList = airportList;
    }

    /**
     * @return the compareList
     */
    public CompareResultsList getCompareList() {
        return compareList;
    }

    /**
     * @param compareList the compareList to set
     */
    public void setCompareList(CompareResultsList compareList) {
        this.compareList = compareList;
    }

    /**
     * @return the modelList
     */
    public AircraftModelList getAircraftModelList() {
        return modelList;
    }

    /**
     * @param modelList the modelList to set
     */
    public void setModelList(AircraftModelList modelList) {
        this.modelList = modelList;
    }

    /**
     * @return the simulationsList
     */
    public SimulationsList getSimulationsList() {
        return simulationsList;
    }

    /**
     * @param simulationsList the simulationsList to set
     */
    public void setSimulationsList(SimulationsList simulationsList) {
        this.simulationsList = simulationsList;
    }

    /**
     * @return the idProject
     */
    public int getIdProject() {
        return idProject;
    }

    /**
     * @param idProject the idProject to set
     */
    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
        /**
     * Gets the ecologic results.
     *
     * @return the ecologic results
     */
    public List<ResultPath> getEcologicPathResults() {
        LinkedList<ResultPath> list = new LinkedList<>();
        getSimulationsList().getSimulationsList().stream().forEach((s) -> {
            list.add(s.getEcologicResultPath());
        });
        return list;
    }

    /**
     * Gets the shortest path results.
     *
     * @return the shortest path results
     */
    public List<ResultPath> getShortestPathResults() {
        LinkedList<ResultPath> list = new LinkedList<>();
        getSimulationsList().getSimulationsList().stream().forEach((s) -> {
            list.add(s.getShortestResultPath());
        });
        return list;
    }

    /**
     * Gets the fastest path results.
     *
     * @return the fastestest path results
     */
    public List<ResultPath> getFastestPathResults() {
        LinkedList<ResultPath> list = new LinkedList<>();
        getSimulationsList().getSimulationsList().stream().forEach((s) -> {
            list.add(s.getFastestResultPath());
        });
        return list;
    }
    
    /**
     * Validates the name and description
     *
     * @param name name of project
     * @param desc description of project
     * @return true if validates, false if not
     */
    public boolean validate(String name, String desc) {
        return name != null && desc != null;
    }
    
    @Override
    public String toString(){
        return name;
    }

}
