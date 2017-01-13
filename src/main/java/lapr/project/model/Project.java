/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.analysis.Path;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.lists.AircraftList;
import lapr.project.model.lists.AircraftModelList;
import lapr.project.model.lists.AirportList;
import lapr.project.model.lists.CompareResultsList;
import lapr.project.model.lists.FlightList;
import lapr.project.model.lists.SimulationsList;

/**
 * Class that represents a simulation of air network fights
 *
 * @author Renato Oliveira, Pedro Fernandes, Diana Silva
 */
public class Project implements Serializable, Comparable {

    /**
     * Variables to read from DAL or file.
     */
    private AircraftList aircraftList;
    private AirNetwork network;
    private AirportList airportList;
    private transient CompareResultsList compareList;
    private transient FlightList flightList;
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
        this.flightList = new FlightList();
        this.modelList = new AircraftModelList();
        this.simulationsList = new SimulationsList();
    }

    /**
     * Constructor copy
     *
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
        this.flightList = proj.flightList;
        this.modelList = proj.modelList;
        this.simulationsList = proj.simulationsList;
    }

    /**
     * Constructor copy
     *
     * @param idProject idProject
     * @param name name
     * @param description description
     * @param aircraftList aircraftList
     * @param network network
     * @param airportList airportList
     * @param compareList compareList
     * @param flightList flightList
     * @param modelList modelList
     * @param simulationsList simulationsList
     */
    public Project(int idProject, String name, String description, AircraftList aircraftList,
            AirNetwork network, AirportList airportList, CompareResultsList compareList, FlightList flightList,
            AircraftModelList modelList, SimulationsList simulationsList) {
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.aircraftList = aircraftList;
        this.network = network;
        this.airportList = airportList;
        this.compareList = compareList;
        this.flightList = flightList;
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
    public void setAirNetwork(AirNetwork network) {
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
        return getModelList();
    }

    /**
     * @param modelList the modelList to set
     */
    public void setAircraftModelList(AircraftModelList modelList) {
        this.setModelList(modelList);
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
    public List<Path> getEcologicPathResults() {
        LinkedList<Path> list = new LinkedList<>();
        for (Simulation s : getSimulationsList().getSimulationsList()) {
            if (Double.doubleToLongBits(s.getEcologicResultPath().getResult()) != 0) {
                list.add(s.getEcologicResultPath());
            }
        }
        return list;
    }

    /**
     * Gets the shortest path results.
     *
     * @return the shortest path results
     */
    public List<Path> getShortestPathResults() {
        LinkedList<Path> list = new LinkedList<>();
        for (Simulation s : getSimulationsList().getSimulationsList()) {
            if (Double.doubleToLongBits(s.getShortestResultPath().getResult()) != 0) {
                list.add(s.getShortestResultPath());
            }
        }
        return list;
    }

    /**
     * Gets the fastest path results.
     *
     * @return the fastestest path results
     */
    public List<Path> getFastestPathResults() {
        LinkedList<Path> list = new LinkedList<>();
        for (Simulation s : getSimulationsList().getSimulationsList()) {
            if (Double.doubleToLongBits(s.getFastestResultPath().getResult()) != 0) {
                list.add(s.getFastestResultPath());
            }
        }
        return list;
    }

    /**
     * Validates the name and description
     *
     * @return true if validates, false if not
     */
    public boolean validate() {
        return !this.name.isEmpty() && !this.description.isEmpty();
    }

    /**
     * Gets the possible end airports linked to the origin node
     *
     * @param startNode origin node of airnetwork
     * @return list airports linked to the start node
     */
    public List<Airport> getPossibleEndAirports(Node startNode) {
        LinkedList<Airport> listAirports = new LinkedList<>();
        List<Node> endNodes = getAirNetwork().getPossibleEndNodes(startNode);
        for (Node nodeEnd : endNodes) {
            Airport a = getAirportList().getAirportNode(nodeEnd);
            if (a != null) {
                listAirports.add(getAirportList().getAirportNode(nodeEnd));
            }
        }
        Airport airport = getAirportList().getAirportNode(startNode);
        if (listAirports.contains(airport)) {
            listAirports.remove(airport);
        }
        return listAirports;
    }

    /**
     * Gets the possible end airports linked to the origin node
     *
     * @param startNode origin node of airnetwork
     * @return list airports linked to the start node
     */
    public List<Node> getPossibleEndNodes(Node startNode) {
        List<Node> listNodes = getAirNetwork().getPossibleEndNodes(startNode);
        if (listNodes.contains(startNode)) {
            listNodes.remove(startNode);
        }
        return listNodes;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Simulation> getSimulationsAircraft(String type) {
        LinkedList<Simulation> results = new LinkedList<>();
        List<Simulation> sims = getSimulationsList().getSimulationsList();
        for (Simulation s : sims) {
            if (s.getFlightPlan().getAircraft().getAircraftModel().getType().equals(type)) {
                results.add(s);
            }
        }
        return results;
    }

    public List<String> getTypesAircraftSimulated() {
        LinkedList<String> listSimulated = new LinkedList<>();
        LinkedList<Simulation> sims = getSimulationsList().getSimulationsList();
        for (Simulation s : sims) {
            String a = s.getFlightPlan().getAircraft().getAircraftModel().getType();
            if (!listSimulated.contains(a)) {
                listSimulated.add(a);
            }
        }
        return listSimulated;
    }

    /**
     *
     * @return
     */
    public FlightList getFlightList() {
        return flightList;
    }

    /**
     * @param flightList the flightList to set
     */
    public void setFlightList(FlightList flightList) {
        this.flightList = flightList;
    }

    /**
     * @return the modelList
     */
    public AircraftModelList getModelList() {
        return modelList;
    }

    /**
     * @param modelList the modelList to set
     */
    public void setModelList(AircraftModelList modelList) {
        this.modelList = modelList;
    }

    @Override
    public int compareTo(Object t) {
        Project otherProject = (Project) t;
        return this.idProject > otherProject.idProject ? 1 : this.idProject < otherProject.idProject ? -1 : 0;
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        if (this == otherObject) {
            return true;
        }
        Project otherProject = (Project) otherObject;
       
        return  this.name.equalsIgnoreCase(otherProject.getName());
    } 

}
