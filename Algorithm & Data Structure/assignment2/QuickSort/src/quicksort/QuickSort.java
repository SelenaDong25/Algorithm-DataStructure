/*
CSD335 - Algorithm & Data Structure
Assignment 2
Student: Xin Dong
April 29, 2020
 */
package quicksort;

/**
 *
 * @author dx200
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // call function to sort 4 set of data and compare the time running
        int[] data = Testdata.sortedNonSequentialInts(1000000);
        long t1 = System.nanoTime();
        QuickSort(data,0,data.length-1); 
        long t2 = System.nanoTime();
        System.out.println("Sort ascending data spend " + (t2 - t1) + " nanosecond.");

        data = Testdata.randomizedInts(1000000);
        long t3 = System.nanoTime();
        QuickSort(data,0,data.length-1);  
        long t4 = System.nanoTime();
        System.out.println("Sort random data spend " + (t4 - t3) + " nanosecond.");

        data = Testdata.sortedDescendingInts(1000000);
        long t5 = System.nanoTime();
        QuickSort(data,0,data.length-1); 
        long t6 = System.nanoTime();
        System.out.println("Sort descending data spend " + (t6 - t5) + " nanosecond.");

        data = Testdata.nearSortedInts(1000000);
        long t7 = System.nanoTime();
        QuickSort(data,0,data.length-1);  
        long t8 = System.nanoTime();
        System.out.println("Sort near sorted data spend " + (t8 - t7) + " nanosecond.");

    }
    /**
    This method is created to create two partitions from provided data. 
    @param array define a list which will be partitioned.
    @param i define the list starting index.
    @param k define the list ending index.
    @return last element in low partition.
    **/
    public static int Partition(int[] array, int i, int k) {
        int l, h, midpoint, pivot, temp = 0;
        boolean done = false;

        midpoint = i + (k - i) / 2;
        pivot = array[midpoint];

        l = i;
        h = k;

        while (!done) {
            // Increment l while numbers[l] < pivot
            while (array[l] < pivot) {
                ++l;
            }

            // Decrement h while pivot < numbers[h]
            while (pivot < array[h]) {
                --h;
            }

            // If there are zero or one elements remaining,
            // all numbers are partitioned. Return h
            if (l >= h) {
                done = true;
            } else {
                // Swap numbers[l] and numbers[h],
                // update l and h
                temp = array[l];
                array[l] = array[h];
                array[h] = temp;

                ++l;
                --h;
            }
        }
        return h;
    }
    /**
    This method use QuickSort algorithm recursively sort partitioned data 
    When data size is smaller than 20, use SelectionSort algorithm to sort the remaining data
    @param array define the data will be sorted.
    @param i define the list starting index.
    @param k define the list ending index.
    **/
    public static void QuickSort(int[] array, int i, int k) {
        int j = 0;
        // Base case: If there are 1 or zero elements to sort,
        // partition is already sorted
        if (i >= k) {
            return;
        }

        // Partition the data within the array. Value j returned
        // from partitioning is location of last element in low partition.
        j = Partition(array, i, k);
        
        // Recursively sort low partition (i to j) and
        // high partition (j + 1 to k)
        if (k - i > 20){
            QuickSort(array, i, j);
            QuickSort(array, j + 1, k);            
        }
        else{
            int m = i; int n = k;
            SelectionSort(array, m, n);
        }        
    }
    /**
    This method is to sort data using SelectionSort algorithm.
    @param array define the data will be sorted.
    @param m define the start index of data to be sorted.
    @param n define the end index of data to be sorted.
    **/    
    public static void SelectionSort(int[] array, int m, int n) {
        int j,indexSmallest, temp = 0;

        for (int i = m; i < n; ++i) {
            // Find index of smallest remaining element
            indexSmallest = i;
            for (j = i + 1; j < n+1; ++j) {

                if (array[j] < array[indexSmallest]) {
                    indexSmallest = j;
                }
            }
            // Swap array[i] and array[indexSmallest]
            temp = array[i];
            array[i] = array[indexSmallest];
            array[indexSmallest] = temp;
        }
    }
}
 
    

