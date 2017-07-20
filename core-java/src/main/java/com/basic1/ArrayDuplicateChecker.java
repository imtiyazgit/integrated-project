package com.basic1;

import java.util.Arrays;

/**
 * Created by imtiyaz on 7/19/17.
 */
public class ArrayDuplicateChecker {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4};

        int[] result = new int[arr.length];

        int index = 0;
        for (int i=0 ; i< arr.length ; i++) {
            System.out.println(arr.length + "and i:"+i);
            if (arr.length == i) {
                break;
            }
            if (arr[i] != arr[i+1]) {
                result [index++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
