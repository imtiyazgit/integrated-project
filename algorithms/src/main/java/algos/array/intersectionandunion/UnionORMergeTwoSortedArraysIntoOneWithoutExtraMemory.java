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
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p= m + n -1;

        // Since we are working from backwords, use aIndex >0 and bIndex>0 on while breaking condition
        while(p1>=0 && p2>=0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }

        // copy missing elements
        while(p1>=0) {
            nums1[p--] = nums1[p1--];
        }

        while(p2>=0) {
            nums1[p--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
//        int[] a = {3,5,6,0,0,0};
//        int[] b = {1};
//merge(a, 3, b, 1);
        int[] a = {1,2,3,0,0,0  };
        int[] b = {2,5,6};

        merge(a, 3, b, 3);

        System.out.println(Arrays.toString(a));
    }

}
