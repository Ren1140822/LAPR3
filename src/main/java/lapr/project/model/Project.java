/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.List;
import lapr.project.model.anaylsis.ResultPath;
import lapr.project.model.lists.AircraftList;
import lapr.project.model.lists.AircraftModelList;
import lapr.project.model.lists.AirportList;
import lapr.project.model.lists.CompareResultsList;
import lapr.project.model.lists.ResultsList;
import lapr.project.model.lists.SimulationsList;

/**
 * Class that represents a simulation of air network fights
 *
 * @author Renato Oliveira, Pedro Fernandes, Diana Silva
 */
public class Project implements Serializable {

   

        /**
         * Variables to read from DAL or file.
         */
        private static AircraftList aircraftList = new AircraftList();
        private static AirNetwork network = new AirNetwork();
        private static AirportList airportList = new AirportList();
        private static ResultsList resultsList = new ResultsList();
        private static CompareResultsList compareList = new CompareResultsList();
//         public static FlightList flightList=new FlightList();
        private static AircraftModelList modelList = new AircraftModelList();
        private static SimulationsList simulationsList = new SimulationsList();

        private static int idProject;
        private static String name;
        private static String description;

        /**
         * private constructor to hide the implicit public one
         */
        private Project() {
        }

        /**
         * Gets the list of aircrafts.
         *
         * @return a linked list with aircrafts
         */
        public static List<Aircraft> getAircraftList() {
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
        public static List<Airport> getAirportList() {
            return airportList.getAirportList();
        }

        /**
         * Gets the analysis results.
         *
         * @return the list of analysis results
         */
        public static ResultsList getListResults() {
            return resultsList;
        }

        /**
         * Gets the comparison results.
         *
         * @return the comparison results
         */
        public static List<ResultPath> getComparisonResults() {
            return resultsList.getComparisonResultsList();
        }

        /**
         * Gets the ecologic results.
         *
         * @return the ecologic results
         */
        public static List<ResultPath> getEcologicPathResults() {
            return resultsList.getEcologicResultsList();
        }

        /**
         * Gets the shortest path results.
         *
         * @return the shortest path results
         */
        public static List<ResultPath> getShortestPathResults() {
            return resultsList.getShortesPathResultsList();
        }

        /**
         * Gets the fastest path results.
         *
         * @return the fastestest path results
         */
        public static List<ResultPath> getFastestPathResults() {
            return resultsList.getFastestResultsList();
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
         * @param list the list of analysis results
         */
        public static void setResultsList(ResultsList list) {
            resultsList = list;
        }

        /**
         * Gets the aircraft model list.
         *
         * @return the list
         */
        public static AircraftModelList getModelList() {
            return modelList;
        }

        /**
         * Sets the aircraft model list.
         *
         * @param modelList the model list to set
         */
        public static void setModelList(AircraftModelList modelList) {
            Project.modelList = modelList;
        }
        
        /**
         * gets tha name of project
         * @return 
         */
        public static String getName(){
            return Project.name;
        }

        /**
         * Sets the name of project
         *
         * @param name name of project
         */
        public static void setName(String name) {
            Project.name = name;
        }

        /**
         * Sets the description text about project
         *
         * @param desc description of project
         */
        public static void setDescription(String desc) {
            description = desc;
        }

        public static void newProject(String name, String desc) {

            if (validate(name, desc)) {
                setDescription(desc);
                setName(name);
                create();
                idProject = 1;
                /**
                 * Corrigir para ID novo na base de dados *
                 */
            }
        }

        /**
         * Validates the name and description
         *
         * @param name name of project
         * @param desc description of project
         * @return true if validates, false if not
         */
        private static boolean validate(String name, String desc) {
            return name != null && desc != null;
        }

        /**
         * Creates main classes of projects
         */
        private static void create() {
            aircraftList = new AircraftList();
            //flightList=new FlightList();
            network = new AirNetwork();
            airportList = new AirportList();
            resultsList = new ResultsList();
            compareList = new CompareResultsList();
            modelList = new AircraftModelList();
        }

        public static AircraftList getAircraftListReference() {
            return aircraftList;
        }

        public static AirportList getAirportListReference() {
            return airportList;
        }

        public static AircraftModelList getAircraftModelListReference() {
            return modelList;
        }

        public static SimulationsList getSimulationsListReference() {
            return simulationsList;
        }
    }


