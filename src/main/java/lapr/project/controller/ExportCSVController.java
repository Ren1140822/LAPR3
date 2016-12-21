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
import lapr.project.utils.CSVExporter;
import lapr.project.model.anaylsis.ResultPath;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportCSVController {

    /**
     * Gets all available results.
     *
     * @return the list of results
     */
    public Map<String, List<ResultPath>> getAvailableResults() {
        Map<String, List<ResultPath>> results = new HashMap<>();
        results.put("Best consumption", Project.getEcologicPathResults());
         results.put("Comparison", Project.getComparisonResults());
        results.put("Shortest Path", Project.getShortestPathResults());
        return results;

    }

    /**
     * Gets results that fit the criteria.
     *
     * @param startNode the origin
     * @param endNode the destination
     * @return the map containing the results
     */
    public Map<String, List<ResultPath>> getFlightPathAnalisysResultsGroupedByOriginDestination(String startNode, String endNode) {
        Map<String, List<ResultPath>> results = new HashMap<>();
        if (startNode != null) {
            List<ResultPath> filteredResults = filterResultsNodes(Project.getEcologicPathResults(), startNode, endNode);
            results.put("Best consumption", filteredResults);
            filteredResults = filterResultsNodes(Project.getComparisonResults(), startNode, endNode);
            results.put("Comparison", filteredResults);
            filteredResults = filterResultsNodes(Project.getShortestPathResults(), startNode, endNode);
            results.put("Shortest Path", filteredResults);
            return results;
        }
        return getAvailableResults();
    }

    /**
     * Filters results by node.
     * @param list the list of results
     * @param startNode start node
     * @param endNode end node
     * @return  the list of results
     */
    private List<ResultPath> filterResultsNodes(List<ResultPath> list, String startNode, String endNode) {
        List<ResultPath> filteredResults = new LinkedList<>();
        for (ResultPath r : list) {
            if (r.getStartNode().getId().equals(startNode)) {
                if (r.getEndNode().equals("any")) {
                    filteredResults.add(r);
                }
                if (r.getEndNode().equals(endNode)) {
                    filteredResults.add(r);
                }
            }
        }
        return filteredResults;
    }

    public Map<String, List<ResultPath>> getFlightPathAnalisysResultsGroupedByAircraftType(String aircrafType) {
           Map<String, List<ResultPath>> results = new HashMap<>();
            List<ResultPath> filteredResults =filterResultsAircaft(Project.getEcologicPathResults(), aircrafType);
            results.put("Best consumption", filteredResults);
            filteredResults = filterResultsAircaft(Project.getComparisonResults(),  aircrafType);
            results.put("Comparison", filteredResults);
            filteredResults =filterResultsAircaft(Project.getShortestPathResults(), aircrafType);
            results.put("Shortest Path", filteredResults);
            return results;
    }
    
     private List<ResultPath> filterResultsAircaft(List<ResultPath> list,String aircraftType) {
       List<ResultPath> filteredResults = new LinkedList<>();
        for (ResultPath r : list) {
           // if (r.getAircraft().getAircraftModel().getType().equals(aircraftType)) {

                    filteredResults.add(r);
           // }
        }
        return filteredResults;
     }

    /**
     * Gets list of all start nodes.
     *
     * @return the list of start nodes.
     */
    public List<String> getListOfOrigins() {
        List<String> nodes = new LinkedList<>();
        List<ResultPath> results = Project.getEcologicPathResults();
        for (ResultPath r : results) {
            
            if (!nodes.contains(r.getStartNode().getId())) {
                nodes.add(r.getStartNode().getId());
            }
        }
        results = Project.getFastestPathResults();
        for (ResultPath r : results) {
            if (!nodes.contains(r.getStartNode().getId())) {
                nodes.add(r.getStartNode().getId());
            }
        }
        results = Project.getComparisonResults();
        for (ResultPath r : results) {
            if (!nodes.contains(r.getStartNode().getId())) {
                nodes.add(r.getStartNode().getId());
            }
        }
        return nodes;
    }

    /**
     * Gets list of all aircraftType.
     *
     * @return the list of all aircraft types
     */
    public List<String> getListOfAircraftTypes() {
        List<String> aircraftTypes = new LinkedList<>();
        List<ResultPath> results = Project.getEcologicPathResults();
        for (ResultPath r : results) {
            if (!aircraftTypes.contains(r.getStartNode().getId())) {
                aircraftTypes.add(r.getStartNode().getId());
            }
        }
        results = Project.getFastestPathResults();
        for (ResultPath r : results) {
            if (!aircraftTypes.contains(r.getStartNode().getId())) {
                aircraftTypes.add(r.getStartNode().getId());
            }
        }
        results = Project.getComparisonResults();
        for (ResultPath r : results) {
            if (!aircraftTypes.contains(r.getStartNode().getId())) {
                aircraftTypes.add(r.getStartNode().getId());
            }
        }
        return aircraftTypes;
    }

    /**
     * Exports a result to html.
     *
     * @param r the result
     * @param filePath the file path
     * @return true if exported
     */
    public boolean exportResult(ResultPath r, String filePath) {
        String results[] = new String[10];
        return CSVExporter.exportStringsToCSV("Results", "", "", results, filePath);
    }
    
    /**
     * Exports  results  to csv.
     *
     * @param r the result
     * @param filePath the file path
     * @return true if exported
     */
    public boolean exportResults(ResultPath r[], String filePath) {
        String results[][] = new String[10][10];
        return CSVExporter.exportMultipleStringsToCSV(filePath, filePath, filePath, results, filePath);
    }
}
