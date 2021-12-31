
package hashex;
import java.util.LinkedList;

public class ChainingHashTable {
    private int elementCt;
    private int tableSize;

    private LinkedList<Integer>[] hashTable;
    
    public ChainingHashTable (int size) {
        elementCt = 0;
        tableSize = size;
        hashTable = new LinkedList[tableSize];
    }
    
    public void insert(Integer item) {
        int hIndex = hash(item);

        if(hashTable[hIndex] == null) {
            hashTable[hIndex] = new LinkedList<>();
        }

        hashTable[hIndex].add(0, item);
        elementCt++;
    }
    
    public int hash( Integer item ) {
        return item.hashCode() % tableSize;
    }
    
    public double getLoadingFactor() {
        return ((double)elementCt) / ((double)tableSize);
    }
}
