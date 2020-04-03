package algos.array.segregateusingpivot.dutchflag;

import java.util.Arrays;

/**
 * Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.
 */
public class MoveZerosToLeftTwosToRightOnesInMiddle {


    private static void segregateZerosToLeftTwosToRight(int[] arr) {
        int start =0; // start is the maintainer of zeros
        int end=arr.length-1; // end is the maintainer of twos

        // we dont care about ones. If you take care of zeros and twos, automatically ones are in middle
        int index=0; // this is the iterator

        while(index<=end && start<=end) {
            if(arr[index]==0) {
                // If at any element is zero, then swap at beginning with start
                swap(arr, index, start);
                //now move forward
                index++;
                start++; // start is set here, so move forward
            } else if(arr[index] == 2) {
                // Remember we only check for 0 and 2.. Automatically 2's are taken care
                // move to end
                swap(arr, index, end);
                end--;
                // Here is the catch.. We should not increment index.. Because we want to check the element swapped is 0 or 1 or 2
            } else {
                // if 1 is found, just increment index. leave it where it is..
                index++;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2,0,0,2,0,1};
        segregateZerosToLeftTwosToRight(arr);
        System.out.println(Arrays.toString(arr));
    }

}
