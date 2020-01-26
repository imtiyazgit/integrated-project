package algos.array.intersectionandunion;

import java.util.Arrays;

public class UnionORMergeTwoSortedArraysIntoOneWithoutExtraMemory {
  /**
     * int[] a = {1,3,5,0,0,0};
     *                 ^     ^
     * int[] b = {2,4,6};
     *                 ^
     * You are merging b elements onto a and therefore, nothing is returned. There is no new array you are calcuating here.
     */
    private static void merge(int[] a, int[] b, int aLength, int bLength) {
        // a1Length is at 5. Take that as input and calculate aIndex
        // a2Length also take as input.
        // Find mergeIndex which should be last element i.e. 0 in this case. which is a1Length + a2Length -1
        // Also calculate bIndex

        int aIndex = aLength-1;
        int bIndex = bLength -1;
        int mergeIndex= aLength + bLength -1;

        // Since we are working from backwords, use aIndex >0 and bIndex>0 on while breaking condition
        while(aIndex >0 && bIndex>0) {

            // Compare aIndex element with bIndex element. If b is greater, then copy that onto mergeIndex and decrement both mergeIndex and bIndex.
            if (a[aIndex] < b[bIndex]) {
                a[mergeIndex] = b[bIndex];
                bIndex--;
            } else {
                a[mergeIndex] = a[aIndex];
                aIndex--;
            }

            mergeIndex--;
        }

        System.out.println(Arrays.toString(a));

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 0, 0, 0,0,0,0,0};
        int[] b = {2, 4, 6, 7,8, 9, 10};

        merge(a, b, 3, 7);
    }

}
