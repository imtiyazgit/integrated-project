package algos.array.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    public static void main(String[] args) {
        int[] arr = {-4, -1, -1, 0, 1, 2};
        List<int[]> results = threeSum(arr);
        for(int[] array:results) {
            System.out.println(Arrays.toString(array));
        }
    }
}

