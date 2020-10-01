package algos.array.intersectionandunion;

import java.util.*;

/**
 * Find common elements or intersection of two arrays
 *
 */
public class IntersectionOfTwoSortedArrays {

    /**
     * TimeComplexity: O(n2)
     * You are not making use of the fact that the arrays are sorted.
     */
    private static Integer[] intersectionUsingTwoLoops(int[] a, int[] b) {

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length ; j++) {
                if (a[i] == b[j]) {
                    results.add(a[i]);
                }
            }
        }

        return results.toArray(new Integer[results.size()]);
    }

    /**
     *
     * TimeComplexity: O(a+b), we are going through elements of a and b array once
     * SpaceComplexity: For results, I am storing in list. In worst case, it could have O(n)
     */
    private static Integer[] intersection(int[] a, int[] b) {

        List<Integer> results = new ArrayList<>();

        int aIndex=0, bIndex =0;

        // intersection means, element should be present in all arrays. so use and condition
        while(aIndex < a.length && bIndex < b.length) {

            if(a[aIndex] == b[bIndex] ) {
                results.add(a[aIndex]);
                // Once intersection found, increase both counters
                aIndex++;
                bIndex++;
                continue;
            } else if(a[aIndex] < b[bIndex]) {
                aIndex++;
            } else {
                bIndex++;
            }
        }

        return results.toArray(new Integer[results.size()]);

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6};

        System.out.println(Arrays.toString(intersectionUsingTwoLoops(arr1, arr2)));
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }


}


/**
 * package algos.array;

 public class IntersectionOfTwoSortedArrays {
 static void intersection(int[] arr1, int[] arr2) {
 int i=0;
 int j=0;
 while (i<arr1.length && j<arr2.length) {
 if (arr1[i] < arr2[j]) {
 // dont print anything here. Its a intersection
 i++;
 } else if (arr1[i] > arr2[j]) {
 j++;
 } else {
 System.out.println(arr1[i]);
 i++; j++;
 }
 }
 }

 public static void main(String[] args) {
 int[] i1 = {1,2,3,5,8,9};
 int[] i2 = {2,5,7,9};

 intersection(i1, i2);
 }
 }

 */
