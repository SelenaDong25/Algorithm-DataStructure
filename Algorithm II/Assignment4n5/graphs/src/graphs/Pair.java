/*
 * CSD436-ALGORITHM PROBLEM SOLVING
 * ASSIGNMENT 5
 * XIN DONG on Feb. 26, 2021.
 */
package graphs;

public class Pair<F, S> {
    private F f;
    private S s;
    public Pair(F f, S s){
        this.f = f;
        this.s = s;
    }
    public F getF(){ return f; }
    public S getS(){ return s; }
    public void setL(F f){ this.f = f; }
    public void setR(S s){ this.s = s; }
}
