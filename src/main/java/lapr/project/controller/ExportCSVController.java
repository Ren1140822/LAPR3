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

import lapr.project.model.analysis.ResultPath;
import lapr.project.model.analysis.Simulation;
import lapr.project.utils.CSVExporter;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportCSVController {

    Project project;

    public ExportCSVController(Project project) {
        this.project = project;
    }

    String currentSim;

    /**
     * Gets all available results.
     *
     * @return the list of results
     */
    public Map<String, ResultPath> getAvailableResults(String sim) {
        currentSim = sim;
        Map<String, ResultPath> results = new HashMap<>();
        List<Simulation> list = project.getSimulationsList().getSimulationsList();
        Simulation aux = getSimulationByString(sim);
        for (Simulation simulation : list) {
            if (aux.equals(simulation)) {
                results.put("Best consumption", simulation.getEcologicResultPath());
                results.put("Fastest path", simulation.getFastestResultPath());
                results.put("Shortest pth", simulation.getShortestResultPath());
            }
        }

        return results;

    }

    public List<String> getSimulationsList() {
        List<String> simString = new LinkedList<>();
        List<Simulation> list = project.getSimulationsList().getSimulationsList();
        Simulation sim = new Simulation();
        list.add(sim);
        sim = new Simulation();
        list.add(sim);
        sim = new Simulation();
        list.add(sim);
        sim = new Simulation();
        list.add(sim);

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
                if (simulation.getStartAirport().getIATA().equals(startNode) && simulation.getEndAirport().getIATA().equals(endNode)) {
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

            if (s.getAircraft().getAircraftModel().getType().equals(aircrafType)) {
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

            results.add(s.getAircraft().getAircraftModel().getType());

        }
        return results;
    }

    /**
     * Gets list of all start nodes.
     *
     * @return the list of start nodes.
     */
    public List<String> getListOfAirports() {
        List<String> results = new LinkedList<>();
        List<Simulation> sims = project.getSimulationsList().getSimulationsList();
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
     * Exports results to csv.
     *
     * @param s
     * @param r the result
     * @param whatToExport
     * @param filePath the file path
     * @return true if exported
     */
    public boolean exportResults(String[] s, String filePath, String whatToExport) {
        String results[][] = new String[s.length][6];
        if (whatToExport.equals("short")) {

            int i = 0;
            for (int j = 0; j < results.length; j++) {
                Simulation sim = getSimulationByString(s[i]);

                results[j][0] = "Shortest path result: " + String.valueOf(sim.getShortestResultPath());
                results[j][1] = "Origin node latitude: " + sim.getStartAirport().getLocation().getLatitude();
                results[j][2] = "Origin node longitude: " + sim.getStartAirport().getLocation().getLongitude();
                results[j][3] = "Destination node latitude: " + sim.getEndAirport().getLocation().getLatitude();
                results[j][4] = "Destination node longitude: " + sim.getEndAirport().getLocation().getLongitude();
                results[j][5] = "Total distance calculated: " + sim.getShortestResultPath().getDistance();
                i++;
            }
        }
        if (whatToExport.equals("eco")) {
            int i = 0;
            for (int j = 0; j < results.length; j++) {
                Simulation sim = getSimulationByString(s[i]);

                results[j][0] = "Shortest path result: " + String.valueOf(sim.getEcologicResultPath());
                results[j][1] = "Origin airport latitude: " + sim.getEcologicResultPath().getStartAirport().getLocation().getLatitude();
                results[j][2] = "Origin airport longitude: " + sim.getEcologicResultPath().getStartAirport().getLocation().getLongitude();
                results[j][3] = "Destination airport latitude: " + sim.getEcologicResultPath().getEndAirport().getLocation().getLatitude();
                results[j][4] = "Destination airport longitude: " + sim.getEcologicResultPath().getEndAirport().getLocation().getLongitude();
                results[j][5] = "Total distance calculated: " + sim.getEcologicResultPath().getResult();
                i++;
            }
        }
        if (whatToExport.equals("fastest")) {
            int i = 0;
            for (int j = 0; j < results.length; j++) {
                Simulation sim = getSimulationByString(s[i]);

                results[j][0] = "Shortest path result: " + String.valueOf(sim.getFastestResultPath());
                results[j][1] = "Origin airport latitude: " + sim.getFastestResultPath().getStartAirport().getLocation().getLatitude();
                results[j][2] = "Origin airport longitude: " + sim.getFastestResultPath().getStartAirport().getLocation().getLongitude();
                results[j][3] = "Destination airport latitude: " + sim.getFastestResultPath().getEndAirport().getLocation().getLatitude();
                results[j][4] = "Destination airport longitude: " + sim.getFastestResultPath().getEndAirport().getLocation().getLongitude();
                results[j][5] = "Total distance calculated: " + sim.getFastestResultPath().getResult();
                i++;
            }
        }
        return CSVExporter.exportMultipleStringsToCSV(filePath, "Results", "Title", results, filePath);
    }

    public boolean exportResult(ResultPath r, String filePath) {
        String results[] = new String[10];
        return CSVExporter.exportStringsToCSV("Results", "", "", results, filePath);
    }

}
