/*
CSD335 - Algorithm & Data Structure
Assignment 1
Student: Xin Dong
April 20, 2020

This program is written by using instructor provided base code and added 
additional block code and method.
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
        compareCt = 0;

        int result = Recursive(needle,haystack, 0, haystack.length - 1);
        if (result != -1){
            return result;
        }
        else   
            return NOTFOUND;
    }
    /**
    This method is created to run recursive binary search with four parameters. 
    @param search define the search key.
    @param array define a list which will be searched.
    @param start define the list starting index.
    @param end define the list ending index.
    @return search result.
    **/
    private static int Recursive(int search, int[] array, int start, int end) {

        int middle = (start + end) / 2;

        if (end < start) {
            return -1;
        }

        if (search < array[middle]) {
            compareCt++;
            return Recursive(search, array, start, middle - 1);
        }

        else if (search > array[middle]) {
            compareCt++;
            return Recursive(search, array, middle + 1, end);
        }

        else if (search == array[middle]) {
            compareCt++;
            return middle;
        }
        else
            compareCt++;
            return -1;
    }
}
