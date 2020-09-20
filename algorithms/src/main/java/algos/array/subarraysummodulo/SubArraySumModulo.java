package algos.array.subarraysummodulo;

import java.util.HashMap;

public class SubArraySumModulo {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap< >();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,18,7,24};
        System.out.println(checkSubarraySum(nums, 6));

    }
}
