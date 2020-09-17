package algos.number.randompickwithweight;

import java.util.Random;

public class Solution {

    int[] cf;

    public Solution(int[] w) {
        cf = new int[w.length];
        cf[0] = w[0];

        for(int i=1;i<w.length;i++) {
            cf[i] = cf[i-1] + w[i];
        }
    }

    // linear search of index O(n)
    public int pickIndexLinearSearch() {
        int target = new Random().nextInt(1+cf.length);
        for(int i=0;i<cf.length;i++) {
            if(cf[i] > target) {
                return i;
            }
        }
        return 0;
    }

    public int pickIndex() {
        int target = 1 + new Random().nextInt(cf[cf.length-1]);
        int left =0;
        int right = cf.length-1;

        while(left < right){
            int mid = left + (right-left) /2;

            if(cf[mid] == target) {
                return mid;
            }

            if(cf[mid] < target){
                left = mid + 1;
            } else {
                right= mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,3});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }
}
