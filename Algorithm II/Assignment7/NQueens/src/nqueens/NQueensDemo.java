/*
 * CSD415-OPERATING SYSTEM
 * ASSIGNMENT 7
 * XIN DONG on March. 12th, 2021.
 */
package nqueens;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author dx200
 */
public class NQueensDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NQueens nq = new NQueens(4);
        nq.findSolution();
        List<List<Pair>> solution = nq.getSolution();
        Iterator<List<Pair>> it = solution.iterator();
        
        while (it.hasNext()) {
            System.out.println("Solution: ");
            Iterator<Pair> it1 = it.next().iterator();
            while (it1.hasNext()) {
                Pair pos = it1.next();
                System.out.println(pos.getFile() + " " + pos.getRank());
            }
            System.out.println();
        }
    }
    
}
