/*
 * Assignment 1 
 * 
 * Linear search times vs. Binary search times
 */
package searching;

import java.util.Random;

/**
 *
 * @author Thomas.Abbott
 */
public class SearchExamples {
    private static final int SampleSize = 100;             // no. of times to run the search on each dataset size
    private static final int InitialDataSetSize = 1024;    // Initial array size to search
    private static final int MaxDataSetSize = (int) Math.pow(2.0, 25); // array size limit

    private static Random rand = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // get average search time on each array size using a linear search
        for (int dsSize = InitialDataSetSize; dsSize < MaxDataSetSize; dsSize *= 2) {
            long avg = usingLinearSearch(SampleSize, dsSize); // just checking
            System.out.println("Linear Search on data set size " + dsSize + " average time = " + avg);
        }

        System.out.println();

        // get average search time on each array size using a binary search
        for (int dsSize = InitialDataSetSize; dsSize < MaxDataSetSize; dsSize *= 2) {
            long avg = usingBinarySearch(SampleSize, dsSize); // just checking
            System.out.println("Binary Search on data set size " + dsSize + " average time = " + avg);
        }
    }

    private static long usingLinearSearch(int sampleSize, int dataSetSize) {
        int[] haystack = TestData.sortedNonSequentialInts(dataSetSize);
        long compareCt = 0;

        for (int i = 0; i < sampleSize; i++) {
            int needle = rand.nextInt(haystack.length);   // random value 
            LwtSearch.linearSearch(haystack, needle);
            compareCt += LwtSearch.compareCt;
        }
        return compareCt / sampleSize;
    }

    private static long usingBinarySearch(int sampleSize, int dataSetSize) {
		// TODO - add code here that is analogous to the method, usingLinearSearch(...), 
		// with the most significant difference being it uses a binarySearch instead of
		// a linear search
        return 0;
    }

    // debugging 
    private static void printTestData(int[] td) {
        int colct = 0;
        System.out.print("haystack: ");
        for (int n : td) {
            if (colct >= 25) {
                colct = 0;
                System.out.print("\n          ");
            }
            System.out.print(n + " ");
            colct++;
        }
        System.out.println("");
    }
}
