/*
 * CSD436-ALGORITHM PROBLEM SOLVING
 * ASSIGNMENT 5
 * XIN DONG on Feb. 26, 2021.
 */

package graphs;

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
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;

public class Graph {

    private Map<Vertex, ArrayList<Vertex>> adjVertices = new HashMap<>();

    // add an element to the vertices set
    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    // add an edge to the graph
    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }
    
    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    Set<Vertex> genericSearch(Graph g, Vertex s) {
        
        Set<Vertex> foundHandled = new HashSet<>();
        Set<Vertex> foundNotHandled = new HashSet<>();
        foundNotHandled.add(s);

        // exit when foundNotHandled is empty
        Iterator<Vertex> it = foundNotHandled.iterator();
        while (it.hasNext()) {
            // LI1: foreach found node v, we know that v is 
            //     reachable from s, because we have traced out 
            //     a path s-> v from s to it
            // LI2: If a node has beren handled, then all of 
            //     its neighbors have been found
            
            // let u be some node from foundNotHandled
            Vertex u = it.next();

            if (!foundHandled.contains(u)) {
                // for each v connected to u
                List<Vertex> vlist = adjVertices.get(u);
                for (Vertex v : vlist) {
                    foundNotHandled.add(v);
                }

                // move u from foundNotHandled to foundHandled
                foundHandled.add(u);
            }
            foundNotHandled.remove(u);
            it = foundNotHandled.iterator();
        }
        return foundHandled;
    }
    
    HashMap<Vertex, Pair<List<Vertex>, Integer>> ShortestPathBreadthFirst(Graph g, Vertex s) {
        HashMap<Vertex, Pair<List<Vertex>, Integer>> foundHandled = new HashMap<>();
        LinkedHashMap<Vertex, Pair<List<Vertex>, Integer>> foundNotHandled = new LinkedHashMap<>();
        
        List<Vertex> l = new LinkedList<>();
        l.add(s);
        foundNotHandled.put(s, new Pair(l, 0));

        // exit when foundNotHandled is empty
        Iterator<Entry<Vertex, Pair<List<Vertex>, Integer>>> it = foundNotHandled.entrySet().iterator();
        
        while (it.hasNext()) {
            // LI1: foreach found node v, we know that v is 
            //     reachable from s, because we have traced out 
            //     a path s-> v from s to it
            // LI2: If a node has beren handled, then all of 
            //     its neighbors have been found
            
            // let u be next node from foundNotHandled
            Entry<Vertex, Pair<List<Vertex>, Integer>> en = it.next();
            Vertex u = en.getKey();
            Pair<List<Vertex>, Integer> p = en.getValue();
            if (!foundHandled.keySet().contains(u)) {
                Integer distance = p.getS();
                // for each v connected to u
                List<Vertex> vlist = adjVertices.get(u);
                for (Vertex v : vlist) {
                    List<Vertex> path = new LinkedList<>(p.getF());
                    path.add(v);
                    foundNotHandled.put(v, new Pair(path, distance+1));
                }

                // move u from foundNotHandled to foundHandled
                foundHandled.put(u, foundNotHandled.remove(u));
                
            } else {
                foundNotHandled.remove(u);
            }
            it = foundNotHandled.entrySet().iterator();
            
        }
        
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
}
