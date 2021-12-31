/*
 * CSD415-OPERATING SYSTEM
 * ASSIGNMENT 6
 * XIN DONG on March. 7th, 2021.
 * Based on instructor provided code, added some methods and helpers.
 */
package lwtgraphs;

import disjointset.DisjointSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Graph {

    private Map<Vertex, ArrayList<Edge>> adjVertices = new HashMap<>();
    
    private Map<String, Integer> vmap= new LinkedHashMap<>();
    // newly added, setter, set vetex to number --XinDong
    public void setVertexMap() {
        Iterator <Vertex> it = adjVertices.keySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            vmap.put(it.next().toString(), count);
            count += 1;
        }
    }
    // newly added, getter, get the vertex and corresponding numbers --XinDong
    public Map<String,Integer> getVertexMap() {
        return vmap;
    }

    // add a vertex to the graph, with an empty edge list
    public void addVertex(Integer label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    // add an edge to the node u
    public void addEdge(Integer uInt, Integer vInt, int w) {
        Vertex u = new Vertex(uInt);
        Vertex v = new Vertex(vInt);

        addEdge(u, v, w);
        addEdge(v, u, w);
    }

    // for use within the class only...
    private void addEdge(Vertex u, Vertex v, int w) {
        List<Edge> uvwList = adjVertices.get(u);
        Edge uEdge = new Edge(u, v, w);
        if (!uvwList.contains(uEdge)) {
            uvwList.add(new Edge(u, v, w));
        }
    }
    // newly added, to sort edge by weight --XinDong
    public List<Edge> getSortedEdges() {
        List<Edge> edgeset = new ArrayList<>();
        var it = adjVertices.values().iterator();
        while(it.hasNext()) {
            edgeset.addAll(it.next());
        }
        List<Edge> edgesetNoDup = new ArrayList<>(new HashSet<>(edgeset));
        edgesetNoDup.sort((Edge e1, Edge e2) -> e1.getWeight() - e2.getWeight());
        
        return edgesetNoDup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Vertex, ArrayList<Edge>> entry : adjVertices.entrySet()) {
            sb.append(entry.getKey()).append("->")
                    .append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}