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

public class GraphSearch {
    
    public static Set<Vertex> depthFirstSearch( Graph g, Vertex s ) {
        Set<Vertex> foundHandled = new LinkedHashSet<>();
        Stack<Vertex> foundNotHandled = new Stack<>(); // using stack allows depth first search
        foundNotHandled.add(s);

        // exit when foundNotHandled is empty
        while (!foundNotHandled.empty()) {
            
            // let u be some node from foundNotHandled
            Vertex u = foundNotHandled.pop();

            if (!foundHandled.contains(u)) {
                // for each v connected to u
                List<Vertex> vlist = g.getAdjVertices(u.toString());
                for (Vertex v : vlist) {
                    foundNotHandled.push(v);
                }
                // move u from foundNotHandled to foundHandled
                foundHandled.add(u);
            }
        }
        return foundHandled;
    }
    
}


