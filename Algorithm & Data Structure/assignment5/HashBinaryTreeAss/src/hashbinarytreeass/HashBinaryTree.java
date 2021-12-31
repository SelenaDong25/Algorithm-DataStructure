/*
 * CSD335-ALGORITHM & DATA STRUCTURE
 * ASSIGNMENT 5
 * XIN DONG ON MAY 20, 2020.
 */
package hashbinarytreeass;

import java.util.LinkedList;
public class HashBinaryTree {
    private int tableSize;    
    private Tree[] bucketList; 
    //this linked list store all the added data with original adding sequence
    public LinkedList<Integer> element = new LinkedList();
    
    // constructor
    public HashBinaryTree (int sz) {
        tableSize = sz;
        bucketList = new Tree[tableSize];
        
        for (int i = 0; i <bucketList.length; i++){
            bucketList[i] = null;            
        }        
    }
    /**
     * The method insert an array list into hash table
     * @param array is an array of Integer object
    */
    public void insert(Integer[] array){
        for(int i = 0; i < array.length; i++){
            this.insert(array[i]);            
        }
    }
    /**
     * The insert method inserts an element.
     * @param key The key to insert.
     */   
    public void insert(Integer key) {
        int bucketIndex;
        bucketIndex = hash(key);
        //if the bucket is empty, create a new tree    
        if(bucketList[bucketIndex] == null) {
            bucketList[bucketIndex] = new Tree(key);
            bucketList[bucketIndex].root.left = null;
            bucketList[bucketIndex].root.right = null;
        }        
        else{
            Node cur = bucketList[bucketIndex].root;
            Node keyNode = new Node(key);
            while (cur != null) {
                if (key < cur.value) {
                    if (cur.left == null) {
                        cur.left = keyNode;
                        cur = null;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if (cur.right == null) {
                        cur.right = keyNode;
                        cur = null;
                    } else {
                        cur = cur.right;
                    }
                }
            }
            keyNode.left = null;
            keyNode.right = null;
        }
        addElement(key);
    }
    /**
     * The method to add the key into element list whenever a key is inserted into a hash table
     * @param key is the key inserted into hash table
    */
    public void addElement(Integer key){
        element.add(key);       
    }
    /**
     * The method to remove the key from element list whenever a key is removed from a hash table
     * @param key is the key removed from hash table
    */
    public void removeElement(Integer key){
        element.remove(key);       
    }
    /**
     * The method to get the element list 
     * @return element list
    */
    public LinkedList getElement(){
        return element;
    }

    /**
     * The hash method find a bucket for key.
     * @param key is number to be assigned.
     * @return bucket index.
     */     
    public int hash( Integer key ) {
        return key.hashCode() % tableSize;
    }
    /**
     * The loadFactor method find current hash table load factor.
     * @return current load factor.
     */    
    public double loadFactor() {
        return (this.size()) / ((double)tableSize);
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0;  i < tableSize; i++){
            str.append(bucketList[i] + "\n");
        }        
        return str.toString();
    }
    /**
     * The size method count total elements in the hash table.
     * @return total count.
     */    
    public int size() {
        int size = 0;        
        for (int i = 0; i < tableSize; i++){
            if(bucketList[i] != null){
                size += size(bucketList[i].root);
            }           
        }
        return size;
    }
    /**
     * The size method count total element within one specific bucket.
     * @param index define the bucket position.
     * @return total element within this bucket.
     */ 
    public int size(int index){
        if (bucketList[index] == null){
            return 0;        
        }
        else{
            return size(bucketList[index].root);
        }
        
    }
    /**
     * The private size method count node when it is not null.
     * @return node count.
     */ 
    private int size(Node node) {
        if (node == null) {
            return (0);
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }
    /**
     * The search method search if the key is in the hash table.
     * @param key is the value to be searched.
     * @return searched key if it's in the hash table, otherwise return null.
     */ 
    public Integer search(Integer key) {
        int bucketIndex = hash(key);
        Node cur = bucketList[bucketIndex].root;
        while (cur != null) {
            if (key == cur.value) {
                return cur.value;
            } else if (key < cur.value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    /**
     * The method mainly calls private remove method
     * @param key define the value which to be removed
     * */
    public void remove(int key) 
    { 
        int bucketIndex = hash(key);
        Node root = bucketList[bucketIndex].root;

        remove(root, key);
        removeElement(key);
    } 
  
    /**
     * The method to remove a key value node from a tree
     * @param root define any "root" node within the tree
     * @param key define the value which to be removed
     * @return "root" node.
     */
    private Node remove(Node root, int key) 
    { 
        // Base Case: If the tree is empty 
        if (root == null)  return root; 
  
        // Otherwise, recur down the tree 
        if (key < root.value) 
            root.left = remove(root.left, key); 
        else if (key > root.value) 
            root.right = remove(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.value = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = remove(root.right, root.value); 
        } 
  
        return root; 
    } 
    /**
     * The method to find minimum value from left child nodes. 
     * @param root define any node within the tree
     * @return minimum value.
     */
    private int minValue(Node root) 
    { 
        int minv = root.value; 
        while (root.left != null) 
        { 
            minv = root.left.value; 
            root = root.left; 
        } 
        return minv; 
    }
/**
     * The ifreHash method define if the hash table need resize. 
     * @return the new hash table if resized, return original hash table if not resized.
     */ 
    public HashBinaryTree ifreHash(){
        if(this.loadFactor()>=1.0)
            return this.reHash();
        else
            return this;
    }
    /**
     * The reHash method resize the original hash table and assign all numbers 
     * into new buckets
     * @return resized hash table with all elements assigned
     */     
    private HashBinaryTree reHash(){
        int reHashSize = this.getRehashSize();
        Tree[] rehashTree = new Tree[reHashSize];
        //HashBinaryTree rehashTable = new HashBinaryTree(reHashSize);
        tableSize = reHashSize;
        bucketList = rehashTree;
        HashBinaryTree rehashTable = this;
        int length = element.size();
        for (int i = 0; i < length; i++){           
            rehashTable.insert(element.pollFirst());           
        }
        return rehashTable;               
    }
    /**
     * The getRehashSize method get new size number for hash table. This number
     * is greater than or equal to two times of original table size and is a prime number
     * @return new hash table size
     */ 
    private int getRehashSize() {
        int sz = tableSize;
        int reHashSize = sz * 2 + 1;
        while (!isPrime(reHashSize)) {
            reHashSize++;
        }return reHashSize ;        
    }
    /**
     * The isPrime method determine if a number is a prime number or not
     * @return true if number is prime, otherwise return false.
     */    
    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;

        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) { // number is perfectly divisible - no prime 
                return false;
            }
        }
        return true;
    }
    /**
     * The method get tree array in the hash table
     * @return tree array.
     */
    public Tree[] getTree(){
        return this.bucketList;
    }
    /**
     * The method get tree at specified index in the hash table
     * @param index define the specified bucket index position
     * @return tree .
     */
    public Tree getTree(int index){
        return this.bucketList[index];
    }

}

