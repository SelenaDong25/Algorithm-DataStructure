/*
 * CSD335-ALGORITHM & DATA STRUCTURE
 * ASSIGNMENT 5
 * XIN DONG ON MAY 20, 2020.
 */
package hashbinarytreeass;


import java.util.Queue;
import java.util.LinkedList;
public class Tree {

    Node root;

    // Constructors 
    public Tree(int key) {
        root = new Node(key);
    }

    public Tree() {
        root = null;

    }
    /**
     * The method to calculate total nodes within a tree
     * @return total counts
    */
    public int size() {
        // If tree is empty 
        if (root == null) {
            return 0;
        }

        // Initialize empty queue. 
        Queue<Node> queue = new LinkedList<>();

        // Do level order traversal starting from root 
        queue.add(root);

        int count = 0; // Initialize count of full nodes 
        while (!queue.isEmpty()) {

            Node temp = queue.poll();
            if (temp.left != null && temp.right != null) {
                count++;
            }

            // Enqueue left child  
            if (temp.left != null) {
                queue.add(temp.left);
            }

            // Enqueue right child  
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return count;
    }
}
