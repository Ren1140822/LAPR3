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
