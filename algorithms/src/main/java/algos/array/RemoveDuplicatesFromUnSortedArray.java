package algos.array;

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
}
