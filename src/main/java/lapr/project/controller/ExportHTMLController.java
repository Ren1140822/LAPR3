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
        String results[][] = new String[s.length][1000];
        if (whatToExport.equals("short")) {

            int i = 0;
            for (int j = 0; j < results.length; j++) {

                Simulation sim = getSimulationByString(s[i]);
                if (sim.getShortestResultPath() != null) {
                    int oldZ =0;
                    for (int z = 0; z < sim.getShortestResultPath().getSegments().size(); z++) {
                        SegmentResult seg = sim.getShortestResultPath().getSegments().get(z);
                        results[j][z+oldZ] = "Shortest path result: " + String.valueOf(seg.getSegment().getId());
                        results[j][z + 1+oldZ] = "Origin airport latitude: " + seg.getSegment().getStartNode().getId();
                        results[j][z + 2+oldZ] = "Destination airport longitude: " + seg.getSegment().getEndNode().getId();
                        results[j][z + 3+oldZ] = "TAS: " + seg.getDistance();
                        results[j][z + 4+oldZ] = "Initial Altitude: " + seg.getInitialAltitude();
                        results[j][z + 5+oldZ] = "TASFinal: " + seg.getDistance();
                        results[j][z + 6+oldZ] = "Final altitude: " + seg.getAltitudeFinal();
                        results[j][z + 7+oldZ] = "Fuel consumption: " + seg.getEnergyConsume();
                        results[j][z + 8+oldZ] = "Remaining fuel: " + seg.getDistance();
                        results[j][z + 9+oldZ] = "Distance: " + seg.getDistance();
                        results[j][z + 10+oldZ] = "Flight Time: " + seg.getDistance();
                        oldZ +=10;
                    }

                }
                i++;
            }
        }
        if (whatToExport.equals("eco")) {
            int i = 0;
            for (int j = 0; j < results.length; j++) {
                Simulation sim = getSimulationByString(s[i]);
                if (sim.getEcologicResultPath() != null) {
                  int oldZ =0;
                    for (int z = 0; z < sim.getEcologicResultPath().getSegments().size(); z++) {
                        SegmentResult seg = sim.getEcologicResultPath().getSegments().get(z);
                        results[j][z+oldZ] = "Shortest path result: " + String.valueOf(seg.getSegment().getId());
                        results[j][z + 1+oldZ] = "Origin airport latitude: " + seg.getSegment().getStartNode().getId();
                        results[j][z + 2+oldZ] = "Destination airport longitude: " + seg.getSegment().getEndNode().getId();
                        results[j][z + 3+oldZ] = "TAS: " + seg.getDistance();
                        results[j][z + 4+oldZ] = "Initial Altitude: " + seg.getInitialAltitude();
                        results[j][z + 5+oldZ] = "TASFinal: " + seg.getDistance();
                        results[j][z + 6+oldZ] = "Final altitude: " + seg.getAltitudeFinal();
                        results[j][z + 7+oldZ] = "Fuel consumption: " + seg.getEnergyConsume();
                        results[j][z + 8+oldZ] = "Remaining fuel: " + seg.getDistance();
                        results[j][z + 9+oldZ] = "Distance: " + seg.getDistance();
                        results[j][z + 10+oldZ] = "Flight Time: " + seg.getDistance();
                        oldZ +=11;
                    }
                }
                i++;
            }
        }
        if (whatToExport.equals("fastest")) {
            int i = 0;
            for (int j = 0; j < results.length; j++) {
                Simulation sim = getSimulationByString(s[i]);
                if (sim.getFastestResultPath() != null) {
                  int oldZ =0;
                    for (int z = 0; z < sim.getFastestResultPath().getSegments().size(); z++) {
                        SegmentResult seg = sim.getFastestResultPath().getSegments().get(z);
                        results[j][z+oldZ] = "Shortest path result: " + String.valueOf(seg.getSegment().getId());
                        results[j][z + 1+oldZ] = "Origin airport latitude: " + seg.getSegment().getStartNode().getId();
                        results[j][z + 2+oldZ] = "Destination airport longitude: " + seg.getSegment().getEndNode().getId();
                        results[j][z + 3+oldZ] = "TAS: " + seg.getDistance();
                        results[j][z + 4+oldZ] = "Initial Altitude: " + seg.getInitialAltitude();
                        results[j][z + 5+oldZ] = "TASFinal: " + seg.getDistance();
                        results[j][z + 6+oldZ] = "Final altitude: " + seg.getAltitudeFinal();
                        results[j][z + 7+oldZ] = "Fuel consumption: " + seg.getEnergyConsume();
                        results[j][z + 8+oldZ] = "Remaining fuel: " + seg.getDistance();
                        results[j][z + 9+oldZ] = "Distance: " + seg.getDistance();
                        results[j][z + 10+oldZ] = "Flight Time: " + seg.getDistance();
                        oldZ +=11;
                    }
                }
                i++;
            }
        }

        return HTMLExporter.exportMultipleStringsToHTML("Results", "", "", results, filePath);
    }
}
