package com.imtiyaz.examples;

/**
 * Created by imtiyaz on 04/03/16.
 */
public class TEst {
    public static void main(String[] args) {
        int[] arr = {2,1,15,10};

        int max =0;

        for (int i=0;i<arr.length;i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
