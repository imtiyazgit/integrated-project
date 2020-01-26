package algos.array.intersection;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeSortedArrays {

    /**
     * TimeComplexity: O(n3) and you are not making use of the fact that the arrays are sorted
     */
    private static List<Integer> intersectionUsingThreeLoops(int[] a, int[] b, int[] c) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < c.length; k++) {
                    if(a[i] == b[j] && b[j] == c[k]) {
                        results.add(a[i]);
                    }
                }
            }
        }

        return results;
    }

    private static List<Integer> intersection(int[] a, int[] b, int[] c) {

        List<Integer> results = new ArrayList<>();
        int aIndex =0, bIndex=0, cIndex=0;

        // intersection means, element should be present in all arrays. Any of the array reaching to end, there is
        // no possibility of any common elements further
        while(aIndex < a.length && bIndex < b.length && cIndex < c.length) {

            // Look after this comparision. you cant do a=b=c in java. You must use a==b && b ==c
            if(a[aIndex] == b[bIndex] && b[bIndex] == c[cIndex]) {
                results.add(a[aIndex]);
                aIndex++; bIndex++; cIndex++;
                continue;
            } else if(a[aIndex] < b[bIndex]) {
                aIndex++;
            } else if(b[bIndex] < c[cIndex]) {
                bIndex++;
            } else {
                cIndex++;
            }
        }

        return results;

    }

    public static void main(String[] args) {
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.println(intersection(ar1, ar2, ar3));
        System.out.println(intersectionUsingThreeLoops(ar1, ar2, ar3));
    }


}

/**
 package algos.array;

 public class IntersectionOfThreeSortedArrays {
 static void intersect(int[] arr1, int[] arr2, int[] arr3) {
 int i=0, j=0, k=0;

 while (i<arr1.length && j<arr2.length && k<arr3.length) {
 if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
 System.out.println(arr1[i]);
 i++;j++;k++;
 }
 else if (arr1[i] < arr2[j]) {
 i++;
 } else if (arr2[j] < arr3[k]) {
 j++;
 } else {
 k++;
 }
 }
 }

 public static void main(String[] args) {
 int[] i1 = {1,2,3,5,8,9};
 int[] i2 = {2,5,7,9};
 int[] i3 = {2,9,10};

 intersect(i1, i2, i3);
 }
 }
**/