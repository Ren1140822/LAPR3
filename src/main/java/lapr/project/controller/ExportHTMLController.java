/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import lapr.project.model.Project;
import lapr.project.utils.HTMLExporter;
import lapr.project.model.anaylsis.Result;
import lapr.project.model.lists.ResultsList;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportHTMLController {

    LinkedList<ResultsList> results;

    public ExportHTMLController() {

    }

    /**
     * Gets all available results.
     *
     * @return the list of results
     */
    public Map<String, LinkedList<Result>> getAvailableResults() {
        Map<String, LinkedList<Result>> results = new HashMap<>();
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
    public Map<String, LinkedList<Result>> getFlightPathAnalisysResultsGroupedByOriginDestination(String startNode, String endNode) {
        Map<String, LinkedList<Result>> results = new HashMap<>();
        if(startNode!=null)
        {
        LinkedList<Result> filteredResults = filterResults(Project.getEcologicPathResults(), startNode, endNode);
        results.put("Best consumption", filteredResults);
        filteredResults = filterResults(Project.getComparisonResults(), startNode, endNode);
        results.put("Comparison", filteredResults);
        filteredResults = filterResults(Project.getShortestPathResults(), startNode, endNode);
        results.put("Shortest Path", filteredResults);
        return results;
        }
        return getAvailableResults();
    }

    private LinkedList<Result> filterResults(LinkedList<Result> list, String startNode, String endNode) {
        LinkedList<Result> filteredResults = new LinkedList<>();
        for (Result r : list) {
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

    
      public Map<String, LinkedList<Result>> getFlightPathAnalisysResultsGroupedByAircraftType(String aircrafType) {
           Map<String, LinkedList<Result>> results = new HashMap<>();
            LinkedList<Result> filteredResults =filterResultsAircaft(Project.getEcologicPathResults(), aircrafType);
            results.put("Best consumption", filteredResults);
            filteredResults = filterResultsAircaft(Project.getComparisonResults(),  aircrafType);
            results.put("Comparison", filteredResults);
            filteredResults =filterResultsAircaft(Project.getShortestPathResults(), aircrafType);
            results.put("Shortest Path", filteredResults);
            return results;
    }
    
     private LinkedList<Result> filterResultsAircaft(LinkedList<Result> list,String aircraftType) {
       LinkedList<Result> filteredResults = new LinkedList<>();
        for (Result r : list) {
           // if (r.getAircraft().getAircraftModel().getType().equals(aircraftType)) {

                    filteredResults.add(r);
           // }
        }
        return filteredResults;
     }
    
    
    /**
     * Gets list of all start nodes.
     * @return  the list of start nodes.
     */
    public LinkedList<String> getListOfOrigins() {
        LinkedList<String> nodes = new LinkedList<>();
        LinkedList<Result> results = Project.getEcologicPathResults();
        for (Result r : results) {
            if (!nodes.contains(r.getStartNode().getId())) {
                nodes.add(r.getStartNode().getId());
            }
        }
        results = Project.getFastestPathResults();
        for (Result r : results) {
            if (!nodes.contains(r.getStartNode().getId())) {
                nodes.add(r.getStartNode().getId());
            }
        }
        results = Project.getComparisonResults();
        for (Result r : results) {
            if (!nodes.contains(r.getStartNode().getId())) {
                nodes.add(r.getStartNode().getId());
            }
        }
        return nodes;

    }

    /**
     * Exports a result to html.
     *
     * @param r the result
     * @param filePath the file path
     * @return true if exported
     */
    public boolean exportResult(Result r, String filePath) {
        String results[] = new String[10];
        return HTMLExporter.exportStringsToHTML("Results", "", "", results, filePath);
    }
}
