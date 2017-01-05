package lapr.project.controller;

import java.util.LinkedList;
import lapr.project.model.FlightPlan;
import lapr.project.model.Project;
import lapr.project.model.lists.FlightList;

/**
 *
 * @author Flavio Relvas
 */
public class AddFlightPlanController {

    private FlightList fl;

    public FlightPlan NewFlightPlan(Project project) {
        fl = project.getFlightList();
        return fl.newFlight();
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
}
