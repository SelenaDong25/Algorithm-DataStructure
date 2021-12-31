/*
 * class of static search methods
 */
package searching;

/**
 *
 * @author Thomas.Abbott
 * 
 * LwtSearch has two search methods, linearSearch and binarySearch. Each method
 * takes an int array and a search key. If the search key is found, the index 
 * into the array is returned. If the search key is not found, the public value 
 * NOTFOUND (set to -1) is returned. 
 * 
 * In addition, a public static int, compareCt is set by both methods, indicating
 * how many compare operations were needed to either locate the search key, or
 * determine that the search key is not in the array.
 */
public class LwtSearch {

    public static final int NOTFOUND = -1;
    public static int compareCt = 0;
    
    
    // linear search
    public static int linearSearch(int[] haystack, int needle){
        compareCt = 0;
        for( int i = 0; i < haystack.length; i++ ) {
            compareCt++;
            if( haystack[i] == needle) {
                return i;
            }
        }
        return NOTFOUND;
    }
    
    // TODO - implement a recursive binary search algorithm. Do not change the name
	// or the parameters to this method. 
    public static int binarySearch(int[] haystack, int needle) {
        return NOTFOUND;
    }
}
