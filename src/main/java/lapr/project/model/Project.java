/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.List;
import lapr.project.model.lists.AircraftList;
import lapr.project.model.lists.AirportList;
import lapr.project.model.lists.NodeList;
import lapr.project.model.lists.ResultsList;
import lapr.project.model.lists.SegmentList;

/**
 * Class that represents a simulation of air network fights
 * @author Renato Oliveira 1140822@isep.ipp.pt and Pedro Fernandes
 */
public class Project {

    /**
     * Variables to read from DAL or file.
     */
    public static AircraftList aircraftList = new AircraftList();
    public static AirNetwork network = new AirNetwork();    
    public static AirportList airportList;
    public static ResultsList resultsList = new ResultsList();

    /**
     * Gets the list of aircrafts.
     *
     * @return a linked list with aircrafts
     */
    public static LinkedList<Aircraft> getAircraftList() {
        return aircraftList.getAircraftList();
    }
    
    /**
     * Gets the network.
     *
     * @return the network.
     */
    public static AirNetwork getAirNetwork() {
        return network;
    }

    /**
     * Gets the list of airports.
     *
     * @return the list of airports
     */
    public static LinkedList<Airport> getAirportList() {
        return airportList.getAirportList();
    }

    /**
     * Gets the comparison results.
     *
     * @return the comparison results
     */
    public static LinkedList<Result> getComparisonResults() {
        return resultsList.getComparisonResultsList();
    }

    /**
     * Gets the best results.
     *
     * @return the best results
     */
    public static LinkedList<Result> getBestResults() {
        return resultsList.getBestResultsList();
    }

    /**
     * Gets the shortest path results.
     *
     * @return the shortest path results
     */
    public static LinkedList<Result> getShortestPathResults() {
        return resultsList.getShortesPathResultsList();
    }

    /**
     * Sets the aircrafts list class reference.
     *
     * @param list the list
     */
    public static void setAirNetwork(AircraftList list) {
        aircraftList = list;
    }

    /**
     * Sets the results list class reference.
     *
     * @param list the list
     */
    public static void setResultsList(ResultsList list) {
        resultsList = list;
    }

}
