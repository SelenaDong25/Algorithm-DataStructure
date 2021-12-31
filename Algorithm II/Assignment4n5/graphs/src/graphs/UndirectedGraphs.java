/*
 * CSD436-ALGORITHM PROBLEM SOLVING
 * ASSIGNMENT 5
 * XIN DONG on Feb. 26, 2021.
 */
package graphs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class UndirectedGraphs {
    public static void main(String[] args) {
        Graph g = createGraph1();
        System.out.println(g);
        
        System.out.println("the found and handled vertices:");
        HashMap<Vertex, Pair<List<Vertex>, Integer>> h = g.ShortestPathBreadthFirst(g, new Vertex("B"));
        Iterator<Entry<Vertex, Pair<List<Vertex>, Integer>>> it = h.entrySet().iterator();
        
        while (it.hasNext()) {
            Entry<Vertex, Pair<List<Vertex>, Integer>> en = it.next();
            System.out.println("Vertex label: " + en.getKey());
            List<Vertex> path = en.getValue().getF();
            Integer distance = en.getValue().getS();
            System.out.println("Shortest path to vertex: " + path);
            System.out.println("distance to source vertex: " + distance);
            System.out.println();
        }
        
        System.out.println("Depth First Search");
        Set<Vertex> s = GraphSearch.depthFirstSearch(g, new Vertex("B"));
        Iterator<Vertex> it2 = s.iterator();
        
        while (it2.hasNext()) {
            Vertex v = it2.next();
            System.out.println(v);
        }
        
    }

    private static Graph createGraph1() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        graph.addEdge("E", "F");
        graph.addEdge("F", "G");
        graph.addEdge("G", "H");
        graph.addEdge("H", "A");
        
        graph.addEdge("A", "C");
        graph.addEdge("C", "G");
        
        return graph;
    }
    
    private static Graph createGraph2() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("E", "A");
        return graph;
    }
}
