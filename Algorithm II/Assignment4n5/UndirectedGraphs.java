package graphs;

public class UndirectedGraphs {
    public static void main(String[] args) {
        Graph g = createGraph1();
        System.out.println(g);
        
        System.out.println("the found and handled vertices:");
        System.out.println(g.genericSearch(g, new Vertex("B")));
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
