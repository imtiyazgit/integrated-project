package algos.array.firstlastpositionsortedarray;

import java.util.Arrays;

public class FindFirstLastPositionOfTargetInSortedArray {

    // [5,7,7,8,8,8,8,8,10]
    // result: [3,7]
    public static int[] searchRange(int[] nums, int target) {
         int[] results = new int[2];
        results[0] = findStartingIndex(nums, target);
        results[1] = findEndingIndex(nums, target);
        return results;
    }

    public static int findStartingIndex(int[] nums, int target) {
        int result=-1;
        int start=0;
        int end=nums.length-1;

        while(start <= end) {
            int middle = start + (end-start) /2; // same as (start+end)/2, but this is more efficient from stackoverflow perspective

            if(nums[middle] >= target) {
                // search left side
                end = middle-1;
            } else {
                start = middle+1;
            }

            if(nums[middle] == target) {
                result = middle;
            }
        }
        return result;
    }


    public static int findEndingIndex(int[] nums, int target) {
        int result=-1;
        int start = 0;
        int end = nums.length-1;
        int middle;

        while(start <= end) {
            middle = start+ (end-start)/2; // same as (start+end)/2, but this is more efficient from stackoverflow perspective

            if(nums[middle] <= target) {
                // right side search
                start = middle+1;
            } else {
                // exist in left side
                end = middle-1;
            }

            if(nums[middle] == target) {
                result = middle;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] input = new int[]{5,7,7,8,8,8,8,8,10};
        int[] result = searchRange(input, 8);
        System.out.println(Arrays.toString(result)) ;
    }



}
