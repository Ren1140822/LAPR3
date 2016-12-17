/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.anaylsis;

import java.util.LinkedList;

/**
 *
 * @author Diana Silva
 */
public  interface InterfaceResults {
    public LinkedList<Result> getListShortestResults();
    public LinkedList<Result> getListEcologicResults();
    public LinkedList<Result> getListFastestResults();
    public LinkedList<ComparisonResult> getComparisonResults();
    public String[] getAnalysisOptions();
   
}