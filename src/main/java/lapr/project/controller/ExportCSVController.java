/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.LinkedList;
import lapr.project.model.Result;
import lapr.project.utils.CSVExporter;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ExportCSVController {
    
    
       /**
     * Gets all available results.
     * @return  the list of results
     */
    public LinkedList<Result> getAvailableResults()
    {
        //Project.getAvailableResults();
        return new LinkedList<Result>();
    }
    
    /**
     * Exports a result to html.
     * @param r the result
     * @param filePath the file path
     * @return true if exported
     */
    public boolean exportResult(Result r,String filePath)
    {
        String results[] = new String[10];
        return CSVExporter.exportStringsToCSV("Results", "", "", results, filePath);
    }
}
