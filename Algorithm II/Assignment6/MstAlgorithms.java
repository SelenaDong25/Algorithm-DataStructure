
package lwtgraphs;

import java.util.LinkedHashSet;
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
        Set<Edge> mst = new LinkedHashSet<>();
        mstCost = 0;
        
        return mst;
    }
}
