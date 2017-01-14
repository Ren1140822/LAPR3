/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.mapgraph.Graph;
import lapr.project.model.mapgraph.GraphAlgorithms;
import lapr.project.utils.DistanceCalculator;

/**
 * Class that represents a air network of Segments and Nodes
 *
 * @author Pedro Fernandes
 */
@XmlRootElement(name = "Network")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirNetwork implements Serializable {

    /**
     * the id of airnetwork
     */
    @XmlAttribute(name = "id")
    private String id;
    /**
     * the id of description
     */
    @XmlAttribute(name = "description")
    private String description;
    /**
     * the list of nodes
     */
    @XmlElementWrapper(name = "node_list")
    @XmlElement(name = "node")
    private List<Node> nodeList;
    /**
     * Node to be added into list
     */
    @XmlTransient
    private Node node;
    /**
     * the list of segments
     */
    @XmlElementWrapper(name = "segment_list")
    @XmlElement(name = "segment")
    private List<Segment> segmentList;

    /**
     * Segment to be added into list
     */
    @XmlTransient
    private Segment segment;

    /**
     * graph
     */
    private transient Graph<Node, Segment> airNetworkGraph;
    /**
     * Default values
     */
    @XmlTransient
    private String DEFAULT_ID = "NoID";
    @XmlTransient
    private String DEFAULT_DESCRIPTION = "NoDescription";

    /**
     * constructor
     */
    public AirNetwork() {
        this.id = DEFAULT_ID;
        this.description = DEFAULT_DESCRIPTION;
        this.nodeList = new LinkedList<>();
        this.segmentList = new LinkedList<>();
        this.airNetworkGraph = new Graph<>(true);
    }

    /**
     * gets the id
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * sets the id
     *
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * gets the description
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the description
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
//****************************** Node List *********************************    

    /**
     * sets the node
     *
     * @param id the id of the node
     * @param latitude the latitude of the node
     * @param longitude the longitude of the node
     */
    public void setNode(String id, double latitude, double longitude) {
        node = new Node();
        node.setId(id);
        node.setLatitude(latitude);
        node.setLongitude(longitude);
    }

    /**
     * validate and saves the node into nodesList
     *
     * @return true if node is valid and is added, false if not
     */
    public boolean saveNode() {
        if (validateNode()) {
            addNode();
            return true;
        }
        return false;
    }

    /**
     * validate if node is valid and do not exist in the list
     *
     * @return true if node is valid and do not exist in the list, false if not
     */
    private boolean validateNode() {
        return node.validate() && !nodeList.contains(node);
    }

    /**
     * add the node into the list
     *
     * @return true if node is added, false if not
     */
    private void addNode() {
        nodeList.add(node);
    }

    /**
     * gets the node list
     *
     * @return the node list
     */
    public List<Node> getNodeList() {
        return nodeList;
    }

    /**
     * Sets the nodes list class reference.
     *
     * @param list the list
     */
    public void setNodeList(List<Node> list) {
        nodeList = list;
    }

    /**
     * get node by id
     *
     * @param id the id of the node
     * @return node by id
     */
    public Node getNodeByString(String id) {
        Node n = null;
        for (Node nod : nodeList) {
            if (nod.getId().equalsIgnoreCase(id)) {
                return nod;
            }
        }
        return n;
    }

    public Node getNodeFromList(Node n) {
        Node node = null;
        for (Node nod : nodeList) {
            if (nod.equals(n)) {
                return nod;
            }
        }
        return node;
    }

//*************************** end Node List *******************************
//****************************** Segment List *********************************     
    /**
     * sets the segment
     *
     * @param id the id of the segment
     * @param startNode the startNode of the segment
     * @param endNode the endNode of the segment
     * @param direction the direction of the segment
     * @param windIntensity the wind Intensity of the segment
     * @param windDirection the wind Direction of the segment
     */
    public void setSegment(String id, Node startNode, Node endNode,
            String direction, int windIntensity, int windDirection) {
        segment = new Segment();
        segment.setId(id);
        segment.setStartNode(startNode);
        segment.setEndNode(endNode);
        segment.setDirection(direction);
        segment.setWind(windIntensity, windDirection);
    }

    /**
     * method that subtitute corretely the StartNode and End Node of segment
     * because when import xml, start and end nodes are created only with Id
     */
    public void setSegmentsForJAXB() {
        for (Segment s : segmentList) {
            String s1 = s.getStartNode().getId();
            Node n1 = getNodeByString(s1);
            s.setStartNode(n1);

            String s2 = s.getEndNode().getId();
            Node n2 = getNodeByString(s2);
            s.setEndNode(n2);
        }
    }

    /**
     * validate and saves the segment into segmentsList
     *
     * @return true if segment is valid and is added, false if not
     */
    public boolean saveSegment() {
        return validateSegment() && addSegment();
    }

    /**
     * validate if segment is valid and do not exist in the list
     *
     * @return true if segment is valid and do not exist in the list, false if
     * not
     */
    private boolean validateSegment() {
        return segment.validate() && !segmentList.contains(segment);
    }

    /**
     * add the segment into the list
     *
     * @return true if segment is added, false if not
     */
    private boolean addSegment() {
        return segmentList.add(segment);
    }

    /**
     * gets the segment list
     *
     * @return the segment list
     */
    public List<Segment> getSegmentList() {
        return segmentList;
    }

    /**
     * Sets the segments list class reference.
     *
     * @param list the list
     */
    public void setSegmentList(List<Segment> list) {
        segmentList = list;
    }

//*************************** end Segment List *******************************
    /**
     * gets the airnetwork graph
     *
     * @return the airnetwork graph
     */
    public Graph<Node, Segment> getAirNetwork() {
        return airNetworkGraph;
    }

    /**
     * generate the graph with nodes -> vertex and segments -> edges
     *
     * @return true if airnetwork is generated, false if not
     */
    public boolean generateGraph() {
        return insertNodes() && insertSegments();
    }

    /**
     * insert nodes into graph
     *
     * @return true if num vertices == size of nodelist, false if not
     */
    private boolean insertNodes() {
        for (Node node : nodeList) {
            airNetworkGraph.insertVertex(node);
        }
        return airNetworkGraph.numVertices() > 0;
    }

    /**
     * insert segments into graph
     *
     * @return true if num edges >= size of segmentlist (because bidirectional
     * segments add two edges), false if not
     */
    private boolean insertSegments() {
        for (Segment seg : segmentList) {
            airNetworkGraph.insertEdge(getNodeFromList(seg.getStartNode()),
                    getNodeFromList(seg.getEndNode()), seg,
                    DistanceCalculator.calculateDistance(getNodeFromList(seg.getStartNode()).getLatitude(),
                            getNodeFromList(seg.getStartNode()).getLongitude(),
                            getNodeFromList(seg.getEndNode()).getLatitude(),
                            getNodeFromList(seg.getEndNode()).getLongitude()));

        }
        return airNetworkGraph.numEdges() > 0;
    }

    /**
     * description of airnetwork graph
     *
     * @return description of airnetwork graph
     */
    @Override
    public String toString() {
        return airNetworkGraph.toString();
    }

    /**
     * Gets the possible end destinations relatives to origin of flight
     *
     * @param startNode origin of flight
     * @return list of possible destination airports
     */
    public List<Node> getPossibleEndNodes(Node startNode) {
        /**
         * implement methods to find possible end airports by the segments in
         * project*
         */
        /**
         * falta verificar range*
         */
        return GraphAlgorithms.DepthFirstSearch(airNetworkGraph, startNode);
    }

    /**
     * Gets node correspondent to the airport if exists
     *
     * @param airport airport
     * @return node equivalent to the node
     */
    public Node getAirportNode(Airport airport) {
        for (Node nodeFind : nodeList) {
            if (Double.doubleToLongBits(nodeFind.getLatitude())
                    == Double.doubleToLongBits(airport.getLocation().getLatitude())
                    && Double.doubleToLongBits(nodeFind.getLongitude())
                    == Double.doubleToLongBits(airport.getLocation().getLongitude())) {
                return nodeFind;
            }
        }
        return null;
    }

    /**
     * Gets segment from origin and destination nodes
     *
     * @param startNode
     * @param endNode
     * @return segment
     */
    public Segment getSegmentFromNodes(Node startNode, Node endNode) {
        return getAirNetwork().getEdge(startNode, endNode).getElement();
    }

//    public LinkedList<Node> getAllPathsFromFlightPlanPassingThroughWaypoints(FlightPlan plan) {
//        LinkedList<Node> fullPaths = new LinkedList<>();
//        Node origin = getAirportNode(plan.getOrigin());
//        Node dest = getAirportNode(plan.getDestination());
//        List<Node> waypoints = plan.getMandatoryWaypoints();
//        if (waypoints.size() > 0) {
//
//            GraphAlgorithms.shortestPath(airNetworkGraph, origin, waypoints.get(0), fullPaths);
//            for (int i = 0; i < waypoints.size() - 1; i++) {
//                GraphAlgorithms.shortestPath(airNetworkGraph, waypoints.get(i), waypoints.get(i + 1), fullPaths);
//            }
//            GraphAlgorithms.shortestPath(airNetworkGraph, waypoints.get(waypoints.size()), dest, fullPaths);
//        } else {
//            GraphAlgorithms.shortestPath(airNetworkGraph, origin, dest, fullPaths);
//        }
//        return fullPaths;
//    }

//    public LinkedList<Node> getAllPathsFromFlightPlanPassingThroughWaypoints2(FlightPlan plan) {
//        LinkedList<Node> fullPaths = new LinkedList<>();
//        Node origin = getAirportNode(plan.getOrigin());
//        Node dest = getAirportNode(plan.getDestination());
//        List<Node> waypoints = plan.getMandatoryWaypoints();
//        double x = origin.getLatitude() - waypoints.get(0).getLatitude();
//        double y = origin.getLongitude() - waypoints.get(0).getLongitude();
//        double distance = Math.sqrt(x * x + y * y);
//        Graph<Node, Segment> graph = new Graph<>(true);
//        graph = airNetworkGraph.clone();
//        graph.getEdge(origin, waypoints.get(0)).setWeight(distance);
//        for (int i = 0; i < waypoints.size() - 1; i++) {
//            x = waypoints.get(i).getLatitude() - waypoints.get(i + 1).getLatitude();
//            y = waypoints.get(i).getLongitude() - waypoints.get(i + 1).getLongitude();
//            distance = Math.sqrt(x * x + y * y);
//
//            if (graph.getEdge(waypoints.get(i), waypoints.get(i + 1)) != null) {
//
//                graph.getEdge(waypoints.get(i), waypoints.get(i + 1)).setWeight(distance);
//            }
//        }
//        x = waypoints.get(waypoints.size() - 1).getLatitude() - dest.getLatitude();
//        y = waypoints.get(waypoints.size() - 1).getLongitude() - dest.getLongitude();
//        distance = Math.sqrt(x * x + y * y);
//        graph.getEdge(waypoints.get(waypoints.size() - 1), dest).setWeight(distance);
//        if (waypoints.size() > 0) {
//
//            GraphAlgorithms.shortestPath(graph, origin, waypoints.get(0), fullPaths);
//            for (int i = 0; i < waypoints.size() - 1; i++) {
//
//                GraphAlgorithms.shortestPath(graph, waypoints.get(i), waypoints.get(i + 1), fullPaths);
//            }
//            GraphAlgorithms.shortestPath(graph, waypoints.get(waypoints.size() - 1), dest, fullPaths);
//        } else {
//            GraphAlgorithms.shortestPath(airNetworkGraph, origin, dest, fullPaths);
//        }
//        return fullPaths;
//    }

}
