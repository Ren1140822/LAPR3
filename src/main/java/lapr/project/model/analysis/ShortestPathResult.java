/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.AirNetwork;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.Segment;
import lapr.project.model.mapgraph.Edge;
import lapr.project.model.mapgraph.Graph;
import lapr.project.model.mapgraph.GraphAlgorithms;

/**
 * The class to store and manage result data of shortest path analysis
 * @author DianaSilva
 */
public class ShortestPathResult extends Path implements BestPathInterface  {
    private FlightPlan flightPlan;
    
    /**
     * Constructor
     * @param flightPlan
     */
    public ShortestPathResult(FlightPlan flightPlan){
        super();
        this.flightPlan=flightPlan;
    }
  
     /**
     * Calculates the shortest path
     * @param air airnetwork
     * @param totalWeight total weight of aircraft (kg)
     * @param timeStep time step (s)
     * @param flightPlan flight plan
     */
    @Override
    public void calculateBestPath(AirNetwork air, FlightPlan flightPlan, double totalWeight, int timeStep){
        LinkedList<Edge<Node, Segment>> lS = new LinkedList<>();
        Graph<Node, Segment> distanceGraph = air.getAirNetwork().clone();
        SegmentResult seg = null;
        air.getAirNetwork().edges().forEach(lS::add);

        for (Edge<Node, Segment> e : lS) {
            if (e.getVOrig().equals(air.getAirportNode(flightPlan.getOrigin()))) {
                if (simulateInitialNode(flightPlan, timeStep, totalWeight, e.getElement())) {
                    seg=getSegments().getLast();
                    if (seg.stopClimb()) {
                        seg = getSegments().getFirst();
                    } else {
                        seg = getSegments().getLast();
                    }
                }
            } else if (e.getVDest().equals(air.getAirportNode(flightPlan.getDestination()))) {
                if (simulateEndNode(flightPlan.getOrigin(),flightPlan.getDestination(),flightPlan, timeStep, totalWeight, e.getElement())) {
                    seg = getSegments().getLast();
                }
//            } else if (simulateIntermNodes(flightPlan, timeStep, totalWeight, e.getElement())) {
//                seg = getSegments().getLast();
            }
            if(seg!=null)
            {
                distanceGraph.removeEdge(e.getVOrig(), e.getVDest());
                distanceGraph.insertEdge(e.getVOrig(), e.getVDest(), e.getElement(), seg.getDistance());
            }
        }

        Node origin = air.getAirportNode(flightPlan.getOrigin());
        Node dest = air.getAirportNode(flightPlan.getDestination());
        
        List<Node> waypoints = flightPlan.getMandatoryWaypoints();

        LinkedList<Node> fullPaths = new LinkedList<>();
        LinkedList<Node> shortPath = new LinkedList<>();
        double res = 0.0;
        if (waypoints.size() > 0) {

            res += GraphAlgorithms.shortestPath(distanceGraph, origin, waypoints.get(0), fullPaths);
            shortPath.addAll(fullPaths);
            for (int i = 0; i < waypoints.size() - 1; i++) {
                res += GraphAlgorithms.shortestPath(distanceGraph, waypoints.get(i), waypoints.get(i + 1), fullPaths);
            }
            shortPath.addAll(fullPaths);
            res += GraphAlgorithms.shortestPath(distanceGraph, waypoints.get(waypoints.size()-1), dest, fullPaths);
            shortPath.addAll(fullPaths);
        } else {
            res += GraphAlgorithms.shortestPath(distanceGraph, origin, dest, fullPaths);
            shortPath.addAll(fullPaths);
        }

        setResult(res);
        setResultPath(shortPath);
        createResultsList();
    }

    @Override
    public void calculateBestPathCruise(AirNetwork air, FlightPlan flightPlan, double totalWeight, int timeStep) {
        LinkedList<Edge<Node, Segment>> lS = new LinkedList<>();
        Graph<Node, Segment> distanceGraph = air.getAirNetwork().clone();
        SegmentResult seg = null;
        air.getAirNetwork().edges().forEach(lS::add);

        for (Edge<Node, Segment> e : lS) {
           if(simulateIntermNodes(flightPlan, timeStep, totalWeight, e.getElement())) {
                 seg=getSegments().getLast();
            }
            if(seg!=null)
            {
                distanceGraph.removeEdge(e.getVOrig(), e.getVDest());
                distanceGraph.insertEdge(e.getVOrig(), e.getVDest(), e.getElement(), seg.getDistance());
            }
        }

        Node origin = air.getAirportNode(flightPlan.getOrigin());
        Node dest = air.getAirportNode(flightPlan.getDestination());
  
        LinkedList<Node> fullPaths = new LinkedList<>();
        LinkedList<Node> shortPath = new LinkedList<>();
        double res = 0.0;
        res += GraphAlgorithms.shortestPath(distanceGraph, origin, dest, fullPaths);
        shortPath.addAll(fullPaths);

        setResult(res);
        setResultPath(shortPath);
    }
}
