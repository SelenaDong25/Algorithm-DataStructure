/*
 * CSD415-OPERATING SYSTEM
 * ASSIGNMENT 6
 * XIN DONG on March. 7th, 2021.
 * Based on instructor provided code, added some methods and helpers.
 */
package lwtgraphs;

public class Edge {
    private Vertex u;   // vertex u
    private Vertex v;   // vertex v
    private int w;      // weight w

    public Edge(Vertex u, Vertex v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public Vertex getU() { return u; }
    public Vertex getV() { return v; }
    public int getWeight() { return w; }
    
    @Override
    public boolean equals(Object o) {
        Edge e = (Edge) o;
        if (this.u.equals(e.v) && this.v.equals(e.u) && this.w == e.w) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.u.hashCode() + this.v.hashCode() + this.w;
    }

    @Override
    public String toString() {
        return 
                "(" + this.u.toString() + 
                "," + this.v.toString() + 
                "):" + w;
    }
}

