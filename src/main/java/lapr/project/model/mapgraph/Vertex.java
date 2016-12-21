package lapr.project.model.mapgraph;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author DEI-ESINF
 * @param <V>
 * @param <E>
 */
public class Vertex<V, E> {

    private int key;                     //Vertex key number
    private V element;                 //Vertex information
    private Map<V, Edge<V, E>> outVerts; //adjacent vertices

    public Vertex() {
        key = -1;
        element = null;
        outVerts = new LinkedHashMap<>();
    }

    public Vertex(int k, V vInf) {
        key = k;
        element = vInf;
        outVerts = new LinkedHashMap<>();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int k) {
        key = k;
    }

    public V getElement() {
        return element;
    }

    public void setElement(V vInf) {
        element = vInf;
    }

    public void addAdjVert(V vAdj, Edge<V, E> edge) {
        outVerts.put(vAdj, edge);
    }

    public V getAdjVert(Edge<V, E> edge) {

        for (V vert : outVerts.keySet()) {
            if (edge.equals(outVerts.get(vert))) {
                return vert;
            }
        }

        return null;
    }

    public void remAdjVert(V vAdj) {
        outVerts.remove(vAdj);
    }

    public Edge<V, E> getEdge(V vAdj) {
        return outVerts.get(vAdj);
    }

    public int numAdjVerts() {
        return outVerts.size();
    }

    public Iterable<V> getAllAdjVerts() {
        return outVerts.keySet();
    }

    public Iterable<Edge<V, E>> getAllOutEdges() {
        return outVerts.values();
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) {
            return true;
        }
        if (otherObj == null || this.getClass() != otherObj.getClass()) {
            return false;
        }
        Vertex<V, E> otherVertex = (Vertex<V, E>) otherObj;

        return (this.key == otherVertex.key
                && this.element != null && otherVertex.element != null
                && this.element.equals(otherVertex.element));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.key;
        hash = 97 * hash + this.element.hashCode();
        hash = 97 * hash + this.outVerts.hashCode();
        return hash;
    }

    @Override
    public Vertex<V, E> clone() throws CloneNotSupportedException {

        Vertex<V, E> newVertex = new Vertex<>();

        newVertex.key = key;
        newVertex.element = element;

        for (V vert : outVerts.keySet()) {
            newVertex.outVerts.put(vert, outVerts.get(vert));
        }

        return newVertex;
    }

    @Override
    public String toString() {
        String st = "";
        if (element != null) {
            st = element + " (" + key + "): \n";
        }
        if (!outVerts.isEmpty()) {
            for (V vert : outVerts.keySet()) {
                st += outVerts.get(vert);
            }
        }
        return st;
    }

}
