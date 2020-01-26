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


/**
 package algos.array;

 public class UnionOfSortedArrays {

 static void union(int[] arr1, int[] arr2) {
 int i=0;
 int j=0;
 while (i < arr1.length && j < arr2.length) {
 if (arr1[i] < arr2[j]) {
 System.out.println(arr1[i]);
 i++;
 } else if (arr1[i] > arr2[j]) {
 System.out.println(arr2[j]);
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

 union(i1, i2);
 }
 }
**/