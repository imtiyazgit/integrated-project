package algos.array.shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ProblemStatement: Given an array {3,6,1,2,8,4}, shuffle such that b[0] < b[1] > b[2] <b[3]
 * Less than and greater than
 *
 * Solution#1. Sort it and then swap pairs such that elements are arranged <, >, <, >, <, >, etc
 * Solution#2 Just rearrange based on index where you are at
 */
public class PairsLessThanAndGreaterThan {

    /**
     * Time complexity: O(nlogn)
     * @param arr
     */
    private static void sortAndSwap(int[] arr) {
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if(i%2 == 0) {
                swap(arr, i, i-1);
            }
        }
    }

    // {3,6,1,2,8,4} And goal is <, >, <, >, etc
    // Look at the even location and write code
    // Look at odd location and write code
    // You dont need to sort or something.. Just if its even location
    private static void rearrange(List<Integer> A) {

        for (int i = 1; i < A.size(); i++) {

            // At even locations, if previous element is greater than the current element, swap it
            if (i%2 == 1 && A.get(i-1) > A.get(i) ) {
                Collections.swap(A, i-1, i);
            }

            // At odd location, if previous element is less than the current element, swap it
            if (i%2 == 0 && A.get(i-1) < A.get(i)) {
                Collections.swap(A, i-1, i);
            }

            // Once you wrote above if conditions, these can be merged into a single if loop with swap inside the if
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,1,2,8,4};

        sortAndSwap(arr);

        System.out.println(Arrays.toString(arr));

        //
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(6);
        A.add(1);
        A.add(2);
        A.add(8);
        A.add(4);

        rearrange(A);
        System.out.println(A.toString());


    }
}
