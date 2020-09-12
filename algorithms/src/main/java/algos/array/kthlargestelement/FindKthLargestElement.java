package algos.array.kthlargestelement;

//[3,2,1,5,6,4]
// 1 2 3 4 5 6 , k 2 , return 5


import java.util.Arrays;
import java.util.PriorityQueue;

// [3,2,3,1,2,4,5,5,6] and k = 4
// 1 2 2 3 3 4 5 5 6 , return 4
public class FindKthLargestElement {

    // o(nlogn)
    public static int findKthSol1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //(o(n)
    public static int findKthLargestElement(int[] nums, int k) {


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++) {
            minHeap.add(nums[i]);

            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }

        return minHeap.remove();
    }

    public static void main(String[] args) {
        /*int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargestElement(nums, 4));*/

        int[] nums2 = new int[] {3,2,1,5,6,4};
        System.out.println(findKthLargestElement(nums2, 2));
    }

}
