package undirectedgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import javafx.util.Pair;

public class Graph {

    private Map<Vertex, ArrayList<Vertex>> adjVertices = new HashMap<>();

    // add an element to the vertices set
    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    // remove an element from the vertices set
    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    // add an edge to the graph
    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    // remove an edge from the graph
    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null) {
            eV1.remove(v2);
        }
        if (eV2 != null) {
            eV2.remove(v1);
        }
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    List<Vertex> getAdjVertices(Vertex vlabel) {
        return adjVertices.get(vlabel);
    }

	// returns a set of vertices reachable by s using 
	// the generic search method presented in section 
	// 20.1 of the text titled, "How to Think About 
	// Algorithms", page 199. Pseudo code for the 
	// can be found on page 201.
    Set<Vertex> genericSearch(Graph g, Vertex s) {
        Set<Vertex> foundHandled = new HashSet<>();

		// TODO: your implementation for genericSearch
		// goes here.

        return foundHandled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Vertex, ArrayList<Vertex>> entry : adjVertices.entrySet()) {
            sb.append(entry.getKey()).append("->")
                    .append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    Set<Vertex> depthFirstSearch(Graph g, Vertex s) {
        Set<Vertex> foundHandled = new HashSet<>();
        Stack<Pair<Vertex, Integer>> foundNotHandled = new Stack<>();
        foundNotHandled.push(new Pair<Vertex, Integer>(s, 0));

        while (foundNotHandled.empty() == false) {
            Pair ui = foundNotHandled.pop();
            Vertex u = (Vertex) ui.getKey();
            Integer i = (Integer) ui.getValue();

            List<Vertex> adjVertices = g.getAdjVertices(u);
            // are there more edges to be processed?
            if (adjVertices != null && i < adjVertices.size()) {
                Vertex v = adjVertices.get(i);
                // there are more edges to process, so push the another
                // tuple for the next edge onto the stack
                i++;
                foundNotHandled.push(new Pair<Vertex, Integer>(u, i));

                // see if u has previously been found
                boolean _foundButNotCompletelyHandled
                        = foundButNotCompletelyHandled(v, foundNotHandled);

                if (!foundHandled.contains(v) && !_foundButNotCompletelyHandled) {
                    // v has not previously been found
                    foundNotHandled.push(new Pair<Vertex, Integer>(v, 0));
                } else if (_foundButNotCompletelyHandled) {
                    ;
                } else if (foundHandled.contains(v)) {
                    ;
                }
            } else {
                foundHandled.add(u);
            }
        }

    return foundHandled ;
}

// see if the node v is in the stack
private boolean foundButNotCompletelyHandled(Vertex v, Stack<Pair<Vertex, Integer>> stack) {
        for (Pair<Vertex, Integer> pair : stack) {
            if (pair.getKey().equals(v)) {
                return true;
            }
        }
        return false;
    }
}
