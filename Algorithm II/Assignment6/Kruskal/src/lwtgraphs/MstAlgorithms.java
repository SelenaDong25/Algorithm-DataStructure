/*
 * CSD415-OPERATING SYSTEM
 * ASSIGNMENT 6
 * XIN DONG on March. 7th, 2021.
 * Based on instructor provided code, added some methods and helpers.
 */
package lwtgraphs;

import disjointset.DisjointSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author tom
 */
public class MstAlgorithms {
    // TODO - cost of minimum-spanning tree
    private static int mstCost = 0;
    
    // the minimum spanning tree
    private static Set<Edge> mst = null;

    // TODO - Calculate and return the cost 
    // of the minimum-spanning tree
    public static int getMstCost() {
        return mstCost;
    }

    public static Set<Edge> getMst() {
        return mst;
    }

    // TODO - Kruskal's algorithm
    public static Set<Edge> Kruskals(Graph g) {
        Set<Edge> MST = new LinkedHashSet<>();
        mstCost = 0;
        g.setVertexMap();
        Map<String, Integer> vmap = g.getVertexMap();
        var dset = new DisjointSet(vmap.size());
        
        List<Edge> edgeset = g.getSortedEdges();
        var edgeIt = edgeset.iterator();
        while(edgeIt.hasNext()) {
            Edge e = edgeIt.next();
            int findU = dset.find(vmap.get(e.getU().toString()));
            int findV = dset.find(vmap.get(e.getV().toString()));
            if (findU != findV) {
                MST.add(e);
                dset.union(findU, findV);
            }
        }
        mst = MST;
        
        Iterator<Edge> mstEdge = MST.iterator();
        while(mstEdge.hasNext()) {
            mstCost += mstEdge.next().getWeight();
        }
        
        return MST;
    }
}
