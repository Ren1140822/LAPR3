/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.analysis;

import java.util.Iterator;
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
 *
 * @author DianaSilva
 */
public class EcologicPathResult extends Path implements BestPathInterface {

    private FlightPlan flightPlan;

    /**
     * Constructor
     *
     * @param flightPlan
     */
    public EcologicPathResult(FlightPlan flightPlan) {
        super();
        this.flightPlan = flightPlan;
    }

    @Override
    public void calculateBestPath(AirNetwork airNetwork) {
        LinkedList<Node> ecologicPath = airNetwork.getAllPathsFromFlightPlanPassingThroughWaypoints(flightPlan);
        /**
         * corrigir*
         */

        super.setResult(0);
        super.setResultPath(ecologicPath);
    }

    /**
     *
     * @param air
     * @param flightPlan
     * @param totalWeight
     * @param timeStep
     */
    void calculateEcoPath(AirNetwork air, FlightPlan flightPlan, double totalWeight, int timeStep) {
        LinkedList<Edge<Node, Segment>> lS = new LinkedList<>();
        Graph<Node, Segment> consumeGraph = air.getAirNetwork().clone();
        SegmentResult seg = null;
        air.getAirNetwork().edges().forEach(lS::add);
        for (Edge<Node, Segment> e : lS) {
            if (e.getVOrig().equals(air.getAirportNode(flightPlan.getOrigin()))) {
                seg = new SegmentResult(SegmentType.CLIMBING, flightPlan.getOrigin().getLocation().getAltitude(), totalWeight, timeStep, flightPlan.getAircraft().getAircraftModel(), flightPlan.getListPattern(), e.getElement());
                seg.calculateByType(SegmentType.CLIMBING);
            } else {
                if (e.getVDest().equals(air.getAirportNode(flightPlan.getDestination()))) {
                    seg = new SegmentResult(SegmentType.DESC, flightPlan.getOrigin().getLocation().getAltitude(), totalWeight, timeStep, flightPlan.getAircraft().getAircraftModel(), flightPlan.getListPattern(), e.getElement());
                    seg.calculateByType(SegmentType.DESC);
                } else {
                    seg = new SegmentResult(SegmentType.CRUISE, flightPlan.getOrigin().getLocation().getAltitude(), totalWeight, timeStep, flightPlan.getAircraft().getAircraftModel(), flightPlan.getListPattern(), e.getElement());
                    seg.calculateByType(SegmentType.CRUISE);
                }
            }
            consumeGraph.removeEdge(e.getVOrig(), e.getVDest());
            consumeGraph.insertEdge(e.getVOrig(), e.getVDest(), e.getElement(), seg.getEnergyConsume());
        }

        Node origin = air.getAirportNode(flightPlan.getOrigin());
        Node dest = air.getAirportNode(flightPlan.getDestination());
        List<Node> waypoints = flightPlan.getMandatoryWaypoints();

        LinkedList<Node> fullPaths = new LinkedList<>();
        LinkedList<Node> ecoPath = new LinkedList<>();
        double res = 0.0;
        if (waypoints.size() > 0) {

            res += GraphAlgorithms.shortestPath(consumeGraph, origin, waypoints.get(0), fullPaths);
            ecoPath.addAll(fullPaths);
            for (int i = 0; i < waypoints.size() - 1; i++) {
                res += GraphAlgorithms.shortestPath(consumeGraph, waypoints.get(i), waypoints.get(i + 1), fullPaths);
            }
            ecoPath.addAll(fullPaths);
            res += GraphAlgorithms.shortestPath(consumeGraph, waypoints.get(waypoints.size()), dest, fullPaths);
            ecoPath.addAll(fullPaths);
        } else {
            res += GraphAlgorithms.shortestPath(consumeGraph, origin, dest, fullPaths);
            ecoPath.addAll(fullPaths);
        }

        super.setResult(res);
        super.setResultPath(ecoPath);
    }
}
