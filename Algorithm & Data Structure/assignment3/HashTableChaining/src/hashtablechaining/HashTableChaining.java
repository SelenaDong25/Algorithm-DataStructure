/*
 * CSD335-ALGORITHM & DATA STRUCTURE
 * ASSIGNMENT 4
 * XIN DONG ON MAY 11, 2020.
 */
package hashtablechaining;


public class HashTableChaining {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // initialize a hash table with 5 buckets
        HashTable demo = new HashTable(5);
        //add 4 numbers and display table size
        demo.insert(14);
        demo.insert(11);
        demo.insert(13);
        demo.insert(23);
        System.out.println("Hash Table contain total " + demo.size() + " elements");
        System.out.println("Hush table bucket 3 contain " + demo.size(3)+ " element");
        System.out.println("Hash Table is\n" + demo.ifreHash());
        
        //add more numbers and display new hash table and size
        demo.insert(30);
        demo.insert(31);
        demo.insert(44);
        demo.insert(15);
        demo.insert(11);       
        System.out.println("After add more elements, hash table is\n" + demo);
        System.out.println("Hash Table contain total " + demo.size() + " elements");
        
        //remove specific number and display updated hash table
        demo.remove(11);  
        System.out.println("After remove 11, hash table is\n" + demo);
        System.out.println("Searched number is " + demo.search(11));
        
        //define if the hash table need to be resized, display updated hash table and size
        System.out.println("Hash table after resize is \n" + demo.ifreHash());
        System.out.println("Hush table bucket 3 contain " + demo.size(3)+ " element");
        System.out.println("Hash Table contain total " + demo.size() + " elements");
        
        
        
    }
    
}
