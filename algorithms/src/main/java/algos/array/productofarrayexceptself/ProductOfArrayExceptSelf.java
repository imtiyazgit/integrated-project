package algos.array.productofarrayexceptself;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // 1    2   3   4   -- nums
    // 1    1   2   6     -- left product
    // 24   12  4   1    -- right product
    // 24   12  8   6

    // time complexity: O(1)
    // space complexity: O(n)
    public static int[] productExceptSelf1(int[] nums) {
        int[] left_products = new int[nums.length];
        int[] right_products = new int[nums.length];
        int[] result = new int[nums.length];

        left_products[0] = 1;
        right_products[nums.length-1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left_products[i] = left_products[i-1]  * nums[i-1];
        }

        for (int i = nums.length-2; i >=0; i--) {
            right_products[i] = right_products[i+1]  * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left_products[i] * right_products[i];
        }

        return result;
    }

    // 1    2   3   4   -- nums
    // 1    1   2   6     -- result product first stores left products
    // 24   12  4   1    -- R
    // 24   12    8   6
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1]  * nums[i-1];
        }

        int R =1;
        for (int i = nums.length-1; i >=0; i--) {
            result[i] = result[i] * R;
            R = R * nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(result));
    }
}
