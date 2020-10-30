package algos.array.facebook.probability;

import java.util.*;

public class Solution {

    int[] cs;
    Random random;

    public Solution() {
    }

    private void populateCSArray(int[] A) {
        cs = new int[A.length];
        cs[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            cs[i] = cs[i - 1] + cs[i];
        }
        random = new Random();
    }

    String getProbability(String[] cityName, int[] A) {
        if (cityName == null || cityName.length == 0 || A == null || A.length == 0) {
            return null;
        }

        int randInt = 1 + random.nextInt(cs[cs.length - 1]);

        int start = 0;
        int end = cs.length - 1;

        int result = 0;

        while (start < end) {
            int middle = start + (end - start) / 2;

            if (cs[middle] > randInt) {
                // search left side
                end = middle;
            }

            if (cs[middle] < randInt) {
                // search right side
                start = middle + 1;
            }

            if (cs[middle] == randInt) {
                return cityName[middle];
            }

        }

        return cityName[end];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.populateCSArray(new int[]{7, 5, 8});
        System.out.println(solution.getProbability(new String[]{"NY", "SF", "LA"}, new int[]{7, 5, 8}));
    }

}
