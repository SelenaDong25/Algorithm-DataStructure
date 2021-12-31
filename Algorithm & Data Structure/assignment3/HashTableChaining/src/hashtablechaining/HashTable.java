/*
 * CSD335-ALGORITHM & DATA STRUCTURE
 * ASSIGNMENT 4
 * XIN DONG ON MAY 11, 2020.
 */
package hashtablechaining;


import java.util.LinkedList;

public class HashTable {
    private int elementCt;
    private int tableSize;

    private LinkedList<Integer>[] hashArray;
    
    public HashTable (int sz) {
        elementCt = 0;
        tableSize = sz;
        hashArray = new LinkedList[tableSize];
    }
    /**
     * The insert method inserts an element.
     * @param key The key to insert.
     */    
    public void insert(Integer key) {
        int hIndex;
        hIndex = hash(key);
        //if the bucket is empty, create a new linked list    
        if(hashArray[hIndex] == null) {
            hashArray[hIndex] = new LinkedList<>();
        }
        // add key item to the corresponded bucket
        hashArray[hIndex].add(0, key);
        elementCt++;
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
        return ((double)elementCt) / ((double)tableSize);
    }
    /**
     * The remove method remove key from hash table.
     * @param key is number to be removed.
     */     
    public void remove(Integer key){
        int hIndex = hash(key);

        if (hashArray[hIndex].contains(key)){
            hashArray[hIndex].remove(key);
            elementCt--;
        }
    }
    /**
     * The search method search if the key is in the hash table.
     * @param key is number to be searched.
     * @return searched key if it's in the hash table, otherwise return null.
     */ 
    public Integer search(Integer key){
        int hIndex = hash(key);
        if (hashArray[hIndex].contains(key)){
            return key;
        }
        else
            return null;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0;  i < tableSize; i++){
            str.append(hashArray[i] + "\n");
        }        
        return str.toString();
    }
    /**
     * The size method count total elements in the hash table.
     * @return total count.
     */ 
    public int size() {
        int count = 0;
        for (int i = 0; i < tableSize; i++) {
            if (hashArray[i] == null) {
                count += 0;
            } else {
                count += hashArray[i].size();
            }
        }
        return count;
    }
    /**
     * The size method count total element within one specific bucket.
     * @param index define the bucket position.
     * @return total element within this bucket.
     */ 
    public int size(int index){
        if (hashArray[index] == null)
            return 0;
        else
            return hashArray[index].size();
    }
    /**
     * The ifreHash method define if the hash table need resize. 
     * @return the new hash table if resized, return original hash table if not resized.
     */ 
    public HashTable ifreHash(){
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
    private HashTable reHash(){
        int reHashSize = this.getRehashSize();
        LinkedList<Integer> element = new LinkedList<Integer>();

        int temp = 0;
        for(int j = 0; j < this.hashArray.length; j++)           
            while (this.size(j) != 0){
                temp = this.hashArray[j].poll();
                element.add(temp);}

        LinkedList<Integer>[] rehashArray = new LinkedList[reHashSize];
        HashTable rehashTable = new HashTable(reHashSize);
        tableSize = reHashSize;
        hashArray = rehashArray;
        rehashTable = this;
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
}
