/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lapr.project.model.Project;

import lapr.project.model.analysis.Path;
import lapr.project.model.analysis.SegmentResult;
import lapr.project.model.analysis.Simulation;
import lapr.project.model.lists.AirportList;
import lapr.project.utils.HTMLExporter;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportHTMLController {

    private Project project;

    private String currentSim;

    public ExportHTMLController(Project project) {
        this.project = project;
    }

    /**
     * Gets all available results.
     *
     * @return the list of results
     */
    public Map<String, Path> getAvailableResults(String sim) {
        currentSim = sim;
        Map<String, Path> results = new HashMap<>();
        List<Simulation> list = project.getSimulationsList().getSimulationsList();
        Simulation aux = getSimulationByString(sim);
        for (Simulation simulation : list) {
            if (aux.equals(simulation)) {
                results.put("Best consumption", simulation.getEcologicResultPath());
                results.put("Fastest path", simulation.getFastestResultPath());
                results.put("ShortestPath", simulation.getShortestResultPath());
            }
        }

        return results;

    }

    public List<String> getSimulationsList() {
        List<String> simString = new LinkedList<>();
        List<Simulation> list = project.getSimulationsList().getSimulationsList();

        for (Simulation simulation : list) {
            simString.add(simulation.toString());
        }
        return simString;
    }

    private Simulation getSimulationByString(String id) {
        List<Simulation> list = project.getSimulationsList().getSimulationsList();
        for (Simulation simulation : list) {
            if (simulation.toString().equals(id)) {
                return simulation;
            }
        }
        return null;
    }

    /**
     * Gets results that fit the criteria.
     *
     * @param startNode the origin
     * @param endNode the destination
     * @return the map containing the results
     */
    public List<String> getFlightPathAnalisysResultsGroupedByOriginDestination(String startNode, String endNode) {
        List<String> results = new LinkedList<>();
        if (startNode != null) {
            List<Simulation> list = project.getSimulationsList().getSimulationsList();
            for (Simulation simulation : list) {
                String startIata = simulation.getStartAirport().getIATA();
                String endIata = simulation.getEndAirport().getIATA();
                if (endIata.equals(endNode) && startIata.equals(startNode)) {
                    results.add(simulation.toString());
                    //results.put("Comparison",sim.getComparison());
                    //  results.put("Shortest Path", Project.getShortestPathResults());
                }
            }
//        List<ResultPath> filteredResults = filterResults(Project.getEcologicPathResults(), startNode, endNode);
//        results.put("Best consumption", filteredResults);
//        filteredResults = filterResults(Project.getComparisonResults(), startNode, endNode);
//        results.put("Comparison", filteredResults);
//        filteredResults = filterResults(Project.getShortestPathResults(), startNode, endNode);
//        results.put("Shortest Path", filteredResults);
            return results;
        }
        return results;
    }

    public List<String> getFlightPathAnalisysResultsGroupedByAircraftType(String aircrafType) {
        List<String> results = new LinkedList<>();
        List<Simulation> sims = project.getSimulationsList().getSimulationsList();
        for (Simulation s : sims) {

            if (s.getFlightPlan().getAircraft().getAircraftModel().getType().equals(aircrafType)) {
                results.add(s.toString());
                //results.put("Comparison",sim.getComparison());
                //  results.put("Shortest Path", Project.getShortestPathResults());
            }

        }
        return results;

    }

    /**
     * Gets list of all aircraft types.
     *
     * @return the list of all aircraft types.
     */
    public List<String> getListOfAircraftTypes() {
        List<String> results = new LinkedList<>();
        List<Simulation> sims = project.getSimulationsList().getSimulationsList();
        for (Simulation s : sims) {

            results.add(s.getFlightPlan().getAircraft().getAircraftModel().getType());

        }
        return results;
    }

    /**
     * Gets list of all start nodes.
     *
     * @return the list of start nodes.
     */
    public List<String> getListOfNodes() {
        List<String> results = new LinkedList<>();
        List<Simulation> sims = project.getSimulationsList().getSimulationsList();
        AirportList list = project.getAirportList();
        for (Simulation s : sims) {
            if (!results.contains(s.getStartAirport().getIATA())) {
                results.add(s.getStartAirport().getIATA());
            }
            if (!results.contains(s.getEndAirport().getIATA())) {
                results.add(s.getEndAirport().getIATA());
            }

        }
        return results;
    }

    /**
     * Exports a result to html.
     *
     * @param r the result
     * @param filePath the file path
     * @return true if exported
     */
    public boolean exportResult(Simulation s, String filePath) {
        String results[] = new String[10];
        return HTMLExporter.exportStringsToHTML("Results", "", "", results, filePath);
    }

    /**
     * Exports a set of results to html.
     *
     * @param r the result
     * @param filePath the file path
     * @return true if exported
     */
    public boolean exportResults(String[] s, String filePath, String whatToExport) {
        String results[][] = new String[s.length][11];
        if (whatToExport.equals("short")) {

            int i = 0;
            for (int j = 0; j < results.length; j++) {

                Simulation sim = getSimulationByString(s[i]);
                for (SegmentResult seg : sim.getShortestResultPath().getSegments()) {
                    if (sim.getShortestResultPath() != null) {
                        results[j][0] = "Shortest path result: " + String.valueOf(seg.getSegment().getId());
                        results[j][1] = "Origin airport latitude: " + seg.getSegment().getStartNode().getId();
                        results[j][2] = "Destination airport longitude: " + seg.getSegment().getEndNode().getId();
                        results[j][3] = "TAS: " + seg.getDistance();
                        results[j][4] = "Initial Altitude: " + seg.getInitialAltitude();
                        results[j][5] = "TASFinal: " + seg.getDistance();
                        results[j][6] = "Final altitude: " + seg.getAltitudeFinal();
                        results[j][7] = "Fuel consumption: " + seg.getEnergyConsume();
                        results[j][8] = "Remaining fuel: " + seg.getDistance();
                        results[j][9] = "Distance: " + seg.getDistance();
                        results[j][10] = "Flight Time: " + seg.getDistance();

                    }
                }
                i++;
            }
        }
        if (whatToExport.equals("eco")) {
            int i = 0;
            for (int j = 0; j < results.length; j++) {
                Simulation sim = getSimulationByString(s[i]);
                for (SegmentResult seg : sim.getEcologicResultPath().getSegments()) {
                    if (sim.getEcologicResultPath() != null) {
                        results[j][0] = "Shortest path result: " + String.valueOf(seg.getSegment().getId());
                        results[j][1] = "Origin airport latitude: " + seg.getSegment().getStartNode().getId();
                        results[j][2] = "Destination airport longitude: " + seg.getSegment().getEndNode().getId();
                        results[j][3] = "TAS: " + seg.getDistance();
                        results[j][4] = "Initial Altitude: " + seg.getInitialAltitude();
                        results[j][5] = "TASFinal: " + seg.getDistance();
                        results[j][6] = "Final altitude: " + seg.getAltitudeFinal();
                        results[j][7] = "Fuel consumption: " + seg.getEnergyConsume();
                        results[j][8] = "Remaining fuel: " + seg.getDistance();
                        results[j][9] = "Distance: " + seg.getDistance();
                        results[j][10] = "Flight Time: " + seg.getDistance();

                    }
                }
                i++;
            }
        }
        if (whatToExport.equals("fastest")) {
            int i = 0;
           for (int j = 0; j < results.length; j++) {
                Simulation sim = getSimulationByString(s[i]);
                for (SegmentResult seg : sim.getFastestResultPath().getSegments()) {
                    if (sim.getFastestResultPath() != null) {
                        results[j][0] = "Shortest path result: " + String.valueOf(seg.getSegment().getId());
                        results[j][1] = "Origin airport latitude: " + seg.getSegment().getStartNode().getId();
                        results[j][2] = "Destination airport longitude: " + seg.getSegment().getEndNode().getId();
                        results[j][3] = "TAS: " + seg.getDistance();
                        results[j][4] = "Initial Altitude: " + seg.getInitialAltitude();
                        results[j][5] = "TASFinal: " + seg.getDistance();
                        results[j][6] = "Final altitude: " + seg.getAltitudeFinal();
                        results[j][7] = "Fuel consumption: " + seg.getEnergyConsume();
                        results[j][8] = "Remaining fuel: " + seg.getDistance();
                        results[j][9] = "Distance: " + seg.getDistance();
                        results[j][10] = "Flight Time: " + seg.getDistance();

                    }
                }
                i++;
            }
        }

        return HTMLExporter.exportMultipleStringsToHTML("Results", "", "", results, filePath);
    }
}
