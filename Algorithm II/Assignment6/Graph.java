package lwtgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Vertex, ArrayList<Edge>> adjVertices = new HashMap<>();

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
