package algos.array.duplicates;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: In the array, all elements are duplicated except one, Find missing duplicate
 *
 */
public class FindMissingDuplicate {

    private static void findMissingDuplicateUsingHashMap(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>(arr.length);

        for(int i=0; i<arr.length; i++) {

            if (countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("Missing duplicate element is "+entry.getKey());
            }
        }
    }

    private static void findMissingDuplicateUsingTwoLoops(int[] arr) {
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            for (j = 0; j < arr.length; j++) {
                if ( i == j) {
                    continue;
                }

                if (arr[i] == arr[j]) {
                    // Match exist. Dont continue j till end. No need too
                    break;
                }
            }

            // if match not there, j would have been executed till end
            if (j == arr.length) {
                System.out.println("Missing duplicate element is"+arr[i]);
            }
        }
    }

    // naive solution is use Hash Table ..space complexity - O(n)
    // better solutiion - XOR
    // A^A = 0 and A^B^A = B, so if we XOR all the elements, answer will be the
    // missing no
    public static int find(int[] A) {
        int miss = A[0]; // if we have only one element, the missing no will be
        // that no
        for (int i = 1; i < A.length; i++) {
            miss = miss ^ A[i];
        }
        return miss;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,2,4,3,5,5};


        findMissingDuplicateUsingHashMap(arr);

        findMissingDuplicateUsingTwoLoops(arr);

        int[] A = { 2, 1, 3, 5, 5, 3, 2, 1, 6, 7, 7, 8, 8 };
        System.out.println("Missing duplicate is " + find(arr));

    }
}
