package algos.array.intersectionandunion;

import java.util.Arrays;

/**
 * Solution:
 * For this question, you need to have 3 counters, which iterates over first array, second array and result array
 * Think about like this: Look at first two elements of first array and first elements of second array
 * Next, compare arr1.elem1 < arr2.elem1, if true, add arr1.elem1 into result and increment arr1 counter
 * Note now, the second counter is still points to arr2.elem1 only
 * Now, compare arr2.elem2 with arr2.elem1, if false, increase counter of arr2. Thats it.
 * Once all such comparisons are done, left over elements just add to the result.
 */

public class UnionORMergeTwoSortedArraysIntoOneWithAdditionalSpace {
    public static void main(String[] args) {
        int[] arr1 = {1,4,6,7,8,9};
        int[] arr2 = {2,3,5};
        int[] result = merge(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int i = 0; int j=0; int k=0;

        while (i<arr1.length && j<arr2.length) {
            if(arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }


        // Above code is up until intersection of elements and remaining elements are missed
        // Remaining elements of the larger array needs to be added as this is a union
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;

    }
}


/**
 package algos.array.intersectionandunion;

 import java.util.ArrayList;
 import java.util.List;

 public class UnionOfTwoSortedArrays {

 // Time Complexity: O(m+n)
 private static List<Integer> union(int[] a, int[] b) {

 List<Integer> results = new ArrayList<>();

 int aIndex = 0, bIndex = 0;

 while(aIndex < a.length && bIndex < b.length) {

 if (a[aIndex] == b[bIndex]) {
 results.add(a[aIndex]);
 aIndex++;
 bIndex++;
 continue;
 } else if(a[aIndex] < b[bIndex]) {
 results.add(a[aIndex]);
 aIndex++;
 } else if(a[aIndex] > b[bIndex]) {
 results.add(b[bIndex]);
 bIndex++;
 }
 }


 // Above code is up until intersection of elements and remaining elements are missed
 // Remaining elements of the larger array needs to be added as this is a union
 while(aIndex < a.length) {
 results.add(a[aIndex]);
 aIndex++;
 }

 while(bIndex < b.length) {
 results.add(b[bIndex]);
 bIndex++;
 }

 return results;

 }

 public static void main(String[] args) {
 int[] arr1 = {1, 3, 4, 5, 7};
 int[] arr2 = {2, 3, 5, 6};

 System.out.println(union(arr1, arr2));
 }
 }


**/