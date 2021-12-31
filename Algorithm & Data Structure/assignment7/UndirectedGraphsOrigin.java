package undirectedgraphs;

public class UndirectedGraphs {
    public static void main(String[] args) {
        Graph g = createGraph();
        System.out.println(g);
        
        System.out.println("the found and handled vertices:");
        //System.out.println(g.genericSearch(g, new Vertex("G")));
        System.out.println(g.depthFirstSearch(g, new Vertex("A")));
    }

    private static Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        
        graph.addEdge("F", "G");
        graph.addEdge("F", "H");
        
        graph.addEdge("B", "A");
        graph.addEdge("C", "A");
        graph.addEdge("D", "A");
        graph.addEdge("E", "A");

        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        
        graph.addEdge("D", "E");

        return graph;
    }
}
