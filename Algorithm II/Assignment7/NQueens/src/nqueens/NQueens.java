/*
 * CSD415-OPERATING SYSTEM
 * ASSIGNMENT 7
 * XIN DONG on March. 12th, 2021.
 */
package nqueens;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author dx200
 */
public class NQueens {
    int n;
    List<List<Pair>> solution = new ArrayList<>();
    
    NQueens(int n) {
        this.n = n;
    }
    
    public List<List<Pair>> getSolution() {
        return solution;
    }
    
    public void findSolutionHelper(int file, int rank, int numQueensLeft, List<Pair> queenSoFar) {
        // base case
        if (rank == n && numQueensLeft > 0) {
            return;
        }
        if (numQueensLeft == 0) {
            solution.add(queenSoFar);
            return;
        }
        List<Pair> queenSoFarCopy = new ArrayList<>(queenSoFar);
        
        // option 1: do not place queen on current position
        if (file == n-1) {
            findSolutionHelper(0, rank+1, numQueensLeft, queenSoFarCopy);
        } else {
            findSolutionHelper(file+1, rank, numQueensLeft, queenSoFarCopy);
        }
        
        // option 2: place queen on current position if there are no conflicts
        Iterator<Pair> it = queenSoFar.iterator();
        Pair curPos = new Pair(file, rank);
        boolean conflict = false;
        while (it.hasNext()) {
            Pair position = it.next();
            int posFile = position.fileToInt();
            int posRank = position.rankToInt();
            if (posFile == file || posRank == rank || posFile + posRank == file + rank 
                    || posFile - posRank == file - rank) {
                conflict = true;
                break;
            }
        }
        if (conflict == false) {
            queenSoFar.add(curPos);
        
            if (file == n-1) {
                findSolutionHelper(0, rank+1, numQueensLeft-1, queenSoFar);
            } else {
                findSolutionHelper(file+1, rank, numQueensLeft-1, queenSoFar);
            }
        }
    }
    
    public void findSolution() {
        List<Pair> queenSoFar = new ArrayList<>();
        findSolutionHelper(0, 0, n, queenSoFar);
        //System.out.println(solution.size());
    }
}
