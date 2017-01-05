package lapr.project.controller;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.Project;
import lapr.project.model.lists.FlightList;

/**
 *
 * @author Flavio Relvas
 */
public class AddFlightPlanController {

    private FlightList fl;
    Project project;
    
    public AddFlightPlanController(Project project){
        this.project = project;     
        fl = project.getFlightList();
        fl.newFlight();
    }

    public void setData(FlightPlan flight, int minStopTime, String aircraft, String origin, String destination, LinkedList<String> technicalStops, LinkedList<String> mandatoryWaypoints) {
        flight.setMinStopTime(minStopTime);
        flight.setAircraft(aircraft);
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setTechnicalStops(technicalStops);
        flight.setMandatoryWaypoints(mandatoryWaypoints);
    }

    public boolean setFlightDesignator(FlightPlan flight, String name) {
        flight.setFlightDesignator(name);
        return flight.validate();
    }

    public boolean saveFlightPlan(FlightPlan flight) {
        return fl.saveFlight(flight);
    }
    
    /**
     * Gets the aircraft list of active project
     * @return list of available aircrafts
     */
    public List<Aircraft> getAircraftsList(){
        return project.getAircraftList().getAircraftList();
    }
    
    /**
     * Gets the airport list of active project
     * @return list of available airports
     */
    public List<Airport> getAirportList(){
        return project.getAirportList().getAirportList();
    }
    
    /**
     * Gets the node list of active project
     * @return list of nodes
     */
    public List<Node> getNodeList(){
        return project.getAirNetwork().getNodeList();
    }
}
