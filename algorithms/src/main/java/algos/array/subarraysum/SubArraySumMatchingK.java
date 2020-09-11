package algos.array.subarraysum;

import java.util.HashMap;

public class SubArraySumMatchingK {

    public static void main(String[] args) {
        //int[] nums = new int[]{1, 1, 1};
        int[] nums = new int[]{3, 4, 7,2,-3,1,4,2};

        System.out.println(subarraySum(nums, 7));


    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count =0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}
