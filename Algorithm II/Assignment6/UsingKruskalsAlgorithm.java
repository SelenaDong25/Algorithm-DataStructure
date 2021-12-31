package csd436;

import lwtgraphs.Graph;
import disjointset.DisjointSet;
import lwtgraphs.MstAlgorithms;

/**
 *
 * @author tomabot
 */
public class UsingKruskalsAlgorithm {

    public static void main(String[] args) {
        Graph g = new Graph();
        
        // add vertices and edges to the graph
        buildGraph(g);
        System.out.println(g);  // output the graph
        
        // calculate the minimum-spanning tree
        MstAlgorithms.Kruskals(g);

        // output the minimum-spanning tree and the cost
        System.out.println("minimum-spanning tree:");
        System.out.println(MstAlgorithms.getMst());
    }
    
    private static void buildGraph( Graph g ) {
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        
        g.addEdge(1,0,1);
        g.addEdge(0,7,1);
        g.addEdge(7,6,1);
        g.addEdge(2,7,1);
        g.addEdge(7,3,1);
        g.addEdge(4,2,1);
        g.addEdge(5,4,1);
    }
    
    private static void disjointSetTest() {
        DisjointSet dset8 = new DisjointSet(8);
        System.out.println("initial:" + dset8);

        dset8.union(4, 5);
        System.out.println("union(4,5):" + dset8);

        dset8.union(6, 7);
        System.out.println("union(6,7):" + dset8);

        dset8.union(4, 6);
        System.out.println("union(4,6):" + dset8);

        dset8.union(3, 4);
        System.out.println("union(3,4):" + dset8);
        
        int fnd = dset8.find(6);
        System.out.println("find(6):" + fnd);
        System.out.println("find(6):" + dset8);
    }
}
