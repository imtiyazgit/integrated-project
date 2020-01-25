package algos.array.duplicates;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedArray {


    /**
     * TimeComplexity: O(nlogn) for sorting
     * SpaceComplexity: O(n) for additional array
     *
     */
    private static int[] removeDuplicatesInPlace(int[] arr) {

        // first sort the array
        Arrays.sort(arr);

        // For inplace have two pointers at the beginning, and increment the i, j

        int i=0; // this is the index used to set elements. We dont want to copy the duplicate, so dont increment, if there is same element
        int j=1; // increment always

        while (j<arr.length) {
            if(arr[i] != arr[j]) {
                arr[++i] = arr[j++];
            } else {
                j++;
            }
        }

        // Duplicates elements are removed up until i index. After that we dont need any elements. So create a array new
        int[] results = new int[i+1];
        for (int k = 0; k <= i; k++) {
            results[k] = arr[k];
        }
        return results;
    }

    /**
     * TimeComplexity: O(n)
     * SpaceComplexity: O(n)
     *
     */
    private static Integer[] removeDuplicatesUsingHashMap(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }

        }

        return map.keySet().toArray(new Integer[map.keySet().size()]);

    }


    /**
     * TimeComplexity: O(n)
     * SpaceComplexity: O(n)
     */
    private static Integer[] removeDuplicatesUsingSet(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if(set.add(arr[i])) {
                // added successfuly since element does not exist
            } else {
                System.out.println("Duplicate element found. Not added");
            }
        }

        return set.toArray(new Integer[set.size()]);
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,1,1,4,3,5,7,8,3,1,2,10,10};

        System.out.println(Arrays.toString(removeDuplicatesInPlace(arr)));

        System.out.println("----------------");

        int[] arr2 = {3,2,4,1,1,4,3,5,7,8,3,1,2,10,10};

        System.out.println(Arrays.toString(removeDuplicatesUsingHashMap(arr2)));

        System.out.println("----------------");

        int[] arr3 = {3,2,4,1,1,4,3,5,7,8,3,1,2,10,10};

        System.out.println(Arrays.toString(removeDuplicatesUsingSet(arr3)));
    }
}

/**
 // {1,2,3,3,4,5,4,6,6,6,7}
 // Remove duplicates from this array without Java collection api
 // check if the array is sorted or not.
 // Solution-1
 // 1. Arrays.sort
 // 2. You need to create a new array
 // 3. Iterate and copy only the element which is not equal to previous element

 import java.util.Arrays;

 public class RemoveDuplicatesFromUnSortedArray {
 static int[] sortAndCopyToANewArray(int[] arr) {
 Arrays.sort(arr);

 int[] result = new int[arr.length];

 int previous = arr[0];
 result[0] = previous;
 int num=1; // since first element is already set
 for (int i=1; i<arr.length;i++) {
 if (arr[i] != previous) {
 result[num++] = arr[i];
 }
 previous = arr[i];
 }

 // remove 0 elements which are after num
 result = Arrays.copyOf(result, num);
 return result;
 }

 public static void main(String[] args) {
 int[] arr = {1,2,3,3,4,5,4,6,6,6,7};
 int[] result = sortAndCopyToANewArray(arr);
 System.out.println(Arrays.toString(result));
 }
 }**/