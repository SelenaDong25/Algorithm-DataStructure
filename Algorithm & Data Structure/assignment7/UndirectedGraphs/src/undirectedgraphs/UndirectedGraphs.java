/*
 * CSD335-ALGORITHM & DATA STRUCTURE
 * ASSIGNMENT 7
 * XIN DONG ON June 7, 2020.
 */
package undirectedgraphs;


public class UndirectedGraphs {


    public static void main(String[] args) {
        // TODO code application logic here
        Graph g = createGraph();
        System.out.println(g);
        
        System.out.println("the found and handled vertices:");
        //System.out.println(g.genericSearch(g, new Vertex("G")));
        System.out.println("Depth Search:\n" + g.depthFirstSearch(g, new Vertex("A")));
        System.out.println("Breadth First search:\n" + g.genericSearch(g, new Vertex("K")));
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
        graph.addVertex("I");
        graph.addVertex("J");
        graph.addVertex("K");
        graph.addVertex("L");
        
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
        
        graph.addEdge("I", "J");
        graph.addEdge("I", "K");
        graph.addEdge("F", "I");
        graph.addEdge("H", "L");
        

        return graph;
    }
}
