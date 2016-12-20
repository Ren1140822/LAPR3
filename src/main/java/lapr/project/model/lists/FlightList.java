package lapr.project.model.lists;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Flight;
import lapr.project.model.FlightInstance;
import lapr.project.model.RegularFlight;

/**
 *
 * @author Flavio Relvas
 */
public class FlightList implements Serializable{

    /** 
     * List of existing Flights
     */
    private List<Flight> flightList;

    public FlightList() {
        flightList = new LinkedList<>();
    }

    public FlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public FlightList(FlightList flightList) {
        this.flightList = flightList.flightList;
    }

    public Flight newFlight(String type) {
        if (type.equals("regular")) {
            return new RegularFlight();
        }
        if (type.equals("instance")) {
            return new FlightInstance();
        }
        return null;
    }

    private boolean validate(Flight flight) {
        if (flight == null) {
            return false;
        }

        for (Flight f : flightList) {
            if (flight.equals(f)) {
                return false;
            }
        }
        return true;
    }

    private void add(Flight flight) {
        flightList.add(flight);
    }

    public boolean saveFlight(Flight flight) {
        if (validate(flight)) {
            add(flight);
            return true;
        }
        return false;
    }
}
