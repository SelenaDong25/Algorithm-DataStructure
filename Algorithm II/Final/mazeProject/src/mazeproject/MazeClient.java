/*
 * CSD436-Algorithm
 * ASSIGNMENT Final
 * XIN DONG on March. 20th, 2021.
 */
package mazeproject;

import Maze.Maze;
import disjointset.DisjointSet;


public class MazeClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int width = 100;
        int height = 100;
        Maze m = new Maze(width, height);
        m.decimateWalls(0);
        m.drawWalls();
        DisjointSet cells = m.getMaze();
        
        
    }
    
}
