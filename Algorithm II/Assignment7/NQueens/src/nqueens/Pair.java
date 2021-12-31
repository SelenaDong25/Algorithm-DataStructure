/*
 * CSD415-OPERATING SYSTEM
 * ASSIGNMENT 7
 * XIN DONG on March. 12th, 2021.
 */
package nqueens;

public class Pair {
    String file;
    String rank;
    
    public Pair(int file, int rank) {
        this.file = String.valueOf((char) (file + 'A'));
        this.rank = String.valueOf(rank + 1);
    }
    
    public String getFile() {
        return file;
    }
    
    public String getRank() {
        return rank;
    }
    
    public int fileToInt() {
        
        return file.charAt(0) - 'A';
    }
    
    public int rankToInt() {
        return Integer.parseInt(rank) - 1;
    }
}
