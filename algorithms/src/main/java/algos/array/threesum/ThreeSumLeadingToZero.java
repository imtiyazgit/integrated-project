package algos.array.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ThreeSum:

 Problem: Given an array of integers, find any 3 numbers which adds upto zero.
 E.g.
 {-4, -1, -1, 0, 1, 2}
 Results:
 [-1, -1, 2]
 [-1, 0, 1]


 QuestionsToAsk:
 Can the array contain duplicates?
 Is the array sorted?


 Approach:
 BruteForce approach: You can have 3 loops one pointing to the first index, second loop pointing to the j=i+1 and third loop pointing to k=j+1 and summing up which equals to zero then add that array to the list.
 TimeComplexity: O(n3) as there are 3 loops

 O(n2) approach:
 First sort the array
 Now have the first pointer to the first element
 Now have a second loop which starts from start = i+1 to end= array.length-1
 // {-4, -1, -1, 0, 1, 2}
 ^   ^                 ^
 If sum of start+end i.e. -1+2=-1 is less than zero, increase start. Because you want more, so shift right on axis. I.e .increasing.
 If sum of start+end i.e. -1+2=1 is greater than zero, then decrease end.
 If sum==0, then take arr[i], arr[start], arr[end] and add to List<int[]>
 You will aslo see a commented out code below i.e. actually increasing the start if the next element is same. Same for end if the before element is same, then decrease the index more
 */
public class ThreeSumLeadingToZero {

    // {-4, -1, -1, 0, 1, 2}
    //  ^    ^            ^
    private static List<int[]> threeSum(int[] arr) {
        List<int[]> results = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {

            // Set start to next element and end to last element
            if (i == 0 || arr[i] > arr[i - 1]) {
                int start = i + 1;
                int end = arr.length - 1;
                while (start < end) {
                    int sum = arr[i] + arr[start] + arr[end];
                    if (sum == 0) {
                        results.add(new int[]{arr[i], arr[start], arr[end]});
                    }

                    if (sum < 0) {
                        // make sum bigger by moving the start to right. Make sure its not same
                        /*int currentStart = start;
                        while (arr[currentStart] == arr[start] && start < end) {
                            start++;
                        }*/
                        start++;
                    } else {
                        /*int currentEnd = end;
                        // sum > 0.. Decrease end
                        while (arr[end] == arr[currentEnd] && start < end) {
                            end--;
                        }*/
                        end--;
                    }


                }
            }

        }
        return results;
    }

    public static List<List<Integer>> threeSumPractice(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            if(i >0 && nums[i] == nums[i-1]) {
                continue;
            }

            int low = i+1;
            int high = nums.length-1;

            while(low<high) {
                int sumToLookInSubset = 0-nums[i];
                if(sumToLookInSubset == nums[low] + nums[high]) {
                    results.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low<high && nums[low] == nums[low+1]) {
                        low++;
                    }
                    while(low<high && nums[high] == nums[high-1]) {
                        high--;
                    }
                    low++;
                    high--;
                }
                if(nums[low] + nums[high] > sumToLookInSubset) {
                    high--;
                }
                if(nums[low] + nums[high] < sumToLookInSubset) {
                    low++;
                }

            }
        }


        return results;

    }

    public static void main(String[] args) {
                int[] arr = {-4, -1, -1, -1, -1, 0, 1, 2};
        List<List<Integer>> results = threeSumPractice(arr);
        for(List<Integer> res:results) {
            System.out.println(res);
        }
    }

    public static void main2(String[] args) {
        int[] arr = {-4, -1, -1, 0, 1, 2};
        List<int[]> results = threeSum(arr);
        for(int[] array:results) {
            System.out.println(Arrays.toString(array));
        }
    }
}

