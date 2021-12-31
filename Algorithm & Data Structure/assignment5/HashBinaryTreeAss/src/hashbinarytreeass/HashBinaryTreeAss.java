/*
 * CSD335-ALGORITHM & DATA STRUCTURE
 * ASSIGNMENT 5
 * XIN DONG ON MAY 20, 2020.
 */
package hashbinarytreeass;

public class HashBinaryTreeAss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // initialize a hash table with 5 buckets
        HashBinaryTree demo = new HashBinaryTree(5);
        Integer[] array = {14,13,11,3,33,24,21,4};
        demo.insert(array);     
        demo.insert(56);
        demo.insert(15);


        System.out.println("Total elements count in hash table is " + demo.size());
        System.out.println("Element count in bucket 1 is " + demo.size(1));
        System.out.println("Search 33 and return:\n" + demo.search(33));
        demo.remove(33);
        System.out.println("After remove, total element count in hash table is " + demo.size());
        
        demo.ifreHash();        
        System.out.println("After re-hash, element count in bucket 2 is " + demo.size(2));
        
        System.out.println("Bucket 0 root value is " + demo.getTree(0).root.value);
        System.out.println("After re-hash, total buckets in the hash table is " + demo.getTree().length);        
        System.out.println("Bucket 3 root left value is " + demo.getTree(3).root.left.value);
        System.out.println(demo.element);
        
        
    }
    
}
