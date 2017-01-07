package lapr.project.controller;

import java.util.Arrays;
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
    private FlightPlan flight;
    Project project;
    
    public AddFlightPlanController(Project project){
        this.project = project;     
        fl = project.getFlightList();
        flight = fl.newFlight();
    }

    public void setData(String name, int minStopTime, String aircraft, String origin, 
            String destination, Object[] technicalStops, Object[] mandatoryWaypoints) {
        List<Object> stops = Arrays.asList(technicalStops);
        List<Object> mand = Arrays.asList(mandatoryWaypoints);
        List<String> stopfinal = new LinkedList<>();
        List<String> mandinal = new LinkedList<>();
        for (Object o : stops){
            Airport a = (Airport) o;
            stopfinal.add(a.getName());
        }
        for (Object o : mand){
            Node n = (Node) o;
            mandinal.add(n.getId());
        }
        flight.setFlightDesignator(name);
        flight.setMinStopTime(minStopTime);
        flight.setAircraft(aircraft);
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setTechnicalStops(stopfinal);
        flight.setMandatoryWaypoints(mandinal);
    }

    public boolean saveFlightPlan() {
        return flight.validate() && fl.saveFlight(flight);
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
