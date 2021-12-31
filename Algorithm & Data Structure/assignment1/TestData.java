/*
 * Generate test data for search algorithms
 */
package searching;

import java.util.Random;

/**
 *
 * @author Thomas.Abbott
 */
public class TestData {
    private static final int IncLimit = 7;  // biggest gap between any two ints
    private static Random rand;

    // return a value to be used as a search key
    public static int getNeedle(int max) {
        rand = new Random();
        return rand.nextInt(max);
    }

    // return an array of sorted ints, no duplicate values, and
    // random increments between any two elements in the array
    public static int[] sortedNonSequentialInts(int sz) {
        rand = new Random();
        int[] ary = new int[sz];
        int accum = 0;

        ary[0] = rand.nextInt(IncLimit);
        for (int i = 1; i < sz; i++) {
            ary[i] = ary[i - 1] + rand.nextInt(IncLimit) + 1;
        }
        return ary;
    }

    // return an array of shuffled ints, no duplicate values
    public static int[] randomizedInts(int sz) {
        int[] intArray = sortedNonSequentialInts(sz);
        
        for (int i = intArray.length - 1; i > 1; i--) {
            int r = rand.nextInt(i - 1);
            int tmp = intArray[i];
            intArray[i] = intArray[r];
            intArray[r] = tmp;
        }
        return intArray;
    }
}
