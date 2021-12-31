/*
 * CSD436-Algorithm
 * ASSIGNMENT Final
 * XIN DONG on March. 20th, 2021.
 */
package Maze;

import disjointset.DisjointSet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author tom
 */
public class Maze {

    Wall w = new Wall();
    DisjointSet cells;
    int entrance;
    int exit;
    int height;
    int width;

    HashMap<Integer, Integer> boundaries = new HashMap<>();
    HashMap<Integer, Integer> whichBound = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    private int min(int x, int y) {
        return (x + y - abs(x - y)) / 2;
    }

    public Maze(int width, int height) {
        for (int j = 0; j < width; ++j) {
            boundaries.put(j, j);
            whichBound.put(j, 0);
            boundaries.put(j + width, width * (height - 1) + j);
            whichBound.put(j + width, 1);
        }

        for (int i = 1; i < height - 1; ++i) {
            boundaries.put(i - 1 + 2 * width, i * width);
            whichBound.put(i - 1 + 2 * width, 2);
            boundaries.put(i - 1 + 2 * width + height - 2, width * (i + 1) - 1);
            whichBound.put(i - 1 + 2 * width + height - 2, 3);
        }

        int entranceKey = (int) (Math.random() * 2 * width + 2 * (height - 2));
        int exitKey;
        entrance = boundaries.get(entranceKey);
        do {
            exitKey = (int) (Math.random() * 2 * width + 2 * (height - 2));
            exit = boundaries.get(exitKey);
        } while (Objects.equals(whichBound.get(entranceKey), whichBound.get(exitKey)));

        System.out.println(entranceKey);
        System.out.println(entrance);
        System.out.println(exitKey);
        System.out.println(exit);

        cells = new DisjointSet(width * height);
        this.height = height;
        this.width = width;
    }

    public DisjointSet getMaze() {
        return cells;
    }

    private int removeWall(int pos1, int pos2) {
        int s1 = cells.find(pos1);
        int s2 = cells.find(pos2);
        if (s1 != s2) {
            cells.union(s1, s2);
            return pos2;
        }
        return -1;
    }

    private int removeRandomWall(int pos1) {
        int rand;
        if (pos1 == 0) {
            if ((int) (Math.random() * 2) == 0) {
                return removeWall(pos1, pos1 + 1);
            } else {
                return removeWall(pos1, pos1 + width);
            }
        } else if (pos1 == width - 1) {
            if ((int) (Math.random() * 2) == 0) {
                return removeWall(pos1, pos1 - 1);
            } else {
                return removeWall(pos1, pos1 + width);
            }
        } else if (pos1 == width * (height - 1)) {
            if ((int) (Math.random() * 2) == 0) {
                return removeWall(pos1, pos1 + 1);
            } else {
                return removeWall(pos1, pos1 - width);
            }
        } else if (pos1 == width * height - 1) {
            if ((int) (Math.random() * 2) == 0) {
                return removeWall(pos1, pos1 - 1);
            } else {
                return removeWall(pos1, pos1 - width);
            }
        } else if (pos1 < width) {
            rand = (int) (Math.random() * 3);
            if (rand == 0) {
                return removeWall(pos1, pos1 + 1);
            } else if (rand == 1) {
                return removeWall(pos1, pos1 - 1);
            } else {
                return removeWall(pos1, pos1 + width);
            }
        } else if (pos1 >= width * (height - 1)) {
            rand = (int) (Math.random() * 3);
            if (rand == 0) {
                return removeWall(pos1, pos1 + 1);
            } else if (rand == 1) {
                return removeWall(pos1, pos1 - 1);
            } else {
                return removeWall(pos1, pos1 - width);
            }
        } else if (pos1 % width == 0) {
            rand = (int) (Math.random() * 3);
            if (rand == 0) {
                return removeWall(pos1, pos1 + 1);
            } else if (rand == 1) {
                return removeWall(pos1, pos1 + width);
            } else {
                return removeWall(pos1, pos1 - width);
            }
        } else if (pos1 % width == width - 1) {
            rand = (int) (Math.random() * 3);
            if (rand == 0) {
                return removeWall(pos1, pos1 - 1);
            } else if (rand == 1) {
                return removeWall(pos1, pos1 + width);
            } else {
                return removeWall(pos1, pos1 - width);
            }
        } else {
            rand = (int) (Math.random() * 4);
            if (rand == 0) {
                return removeWall(pos1, pos1 - 1);
            } else if (rand == 1) {
                return removeWall(pos1, pos1 + 1);
            } else if (rand == 2) {
                return removeWall(pos1, pos1 + width);
            } else {
                return removeWall(pos1, pos1 - width);
            }
        }
    }

    public void decimateWalls(int beyond) {
        int pos = entrance;
        while (cells.find(entrance) != cells.find(exit)) {
            pos = removeRandomWall(pos);
            if (pos == -1) {
                pos = (int) (Math.random() * width * height);
            }
        }

        for (int i = 0; i < beyond; ++i) {
            if (removeRandomWall((int) (Math.random() * width * height)) == -1) {
                i -= 1;
            }
        }
    }

    private class Wall {

        public void draw(Graphics g) {
            int left = 100;
            int right = 700;
            int up = 100;
            int down = 700;

            int horiz_inc = (right - left) / width;
            int ver_inc = (down - up) / height;

            int entranceX = entrance % width;
            int entranceY = entrance / width;
            int exitX = exit % width;
            int exitY = exit / width;

            int entranceXCoord = entranceX * horiz_inc;
            int entranceYCoord = entranceY * ver_inc;
            int exitXCoord = exitX * horiz_inc;
            int exitYCoord = exitY * ver_inc;

            right = horiz_inc * width + left;
            down = ver_inc * height + up;

            for (int j = 0, x = left; j < width; ++j, x += horiz_inc) {
                if (!((entranceY == 0 && j == entranceX) || (exitY == 0 && j == exitX))) {
                    g.drawLine(x, up, x + horiz_inc, up);
                }
                if (!((entranceY == height - 1 && j == entranceX) || (exitY == height - 1 && j == exitX))) {
                    g.drawLine(x, down, x + horiz_inc, down);
                }
            }

            for (int i = 0, y = up; i < height; ++i, y += ver_inc) {
                if (!((entranceX == 0 && i == entranceY) || (exitX == 0 && i == exitY))) {
                    g.drawLine(left, y, left, y + ver_inc);
                }
                if (!((entranceX == width - 1 && i == entranceY) || (exitX == width - 1 && i == exitY))) {
                    g.drawLine(right, y, right, y + ver_inc);
                }
            }

            for (int i = 0, y = up; i < height; ++i, y += ver_inc) {
                for (int j = 0, x = left; j < width; ++j, x += horiz_inc) {
                    if (j < width - 1 && cells.find(i * width + j) != cells.find(i * width + (j + 1))) {
                        // draw wall between cells i*width + j and i*width + (j+1)
                        g.drawLine(x + horiz_inc, y, x + horiz_inc, y + ver_inc);
                    }
                    if (i < height - 1 && cells.find(i * width + j) != cells.find((i + 1) * width + j)) {
                        // draw wall between cells i*width+j and (i+1)*width + j
                        g.drawLine(x, y + ver_inc, x + horiz_inc, y + ver_inc);
                    }
                }
            }
        }
    }

    private class MazeCanvas extends JComponent {

        @Override
        public void paint(Graphics g) {
            w.draw(g);
        }
    }

    public void drawWalls() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(100, 100, 800, 800);
        window.getContentPane().add(new MazeCanvas());
        window.setVisible(true);

        // set a width x height board on canvas with <height> rows and <width> columns
        // set positions on canva for each cell
    }
}
