package algos.string.nextpermutation;

import java.util.Arrays;

public class Solution {

    // 6 2 1 5 4 3 0
    //     3 5 4 1 0
    //     3 0 1 4 5
    public void nextPermutation(int[] nums) {

        // find the planting from backwards
        int i = nums.length-2;
        while(i>0) {
            if(nums[i+1] < nums[i]) {
                i--;
            } else {
                break;
            }
        }

        // your planting is at 1. i.e. i is at 2
        // now in remaining elements find element which is greater than 1
        int j=nums.length-1;
        while(j>=0 && nums[j] <= nums[i]) {
            j--;
        }

        //now swap with i and j
        swap(nums, i, j);

        // now reverse elements from i+1 to end
        reverse(nums, i+1);
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i) {
        int j= nums.length-1;

        while(i<j) {
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] input = new int[]{6,2,1,5,4,3,0};
        int[] input = new int[]{1,2,3};
        solution.nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }
}