package algos.array2d.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    // 1 3
    // 2 6
    // 8 10
    //15 18
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <=1) {
            return intervals;
        }

        Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> output_arr = new ArrayList();
        int[] current_interval = intervals[0];
        output_arr.add(current_interval);

        for(int[] interval:intervals) {
            int current_begin = current_interval[0];
            int current_end = current_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if(current_end >= next_begin) {
                // overlap
                current_interval[1] = Math.max(current_end, next_end);
            } else {
                // no overlap.. continue loop
                current_interval = interval;
                output_arr.add(current_interval);
            }
        }

        return output_arr.toArray(new int[output_arr.size()][]);


    }

    public static void main(String[] args) {
        int[][] input = new int[4][2];
        input[0][0] = 1;
        input[0][1] = 3;

        input[1][0] = 2;
        input[1][1] = 6;

        input[2][0] = 8;
        input[2][1] = 10;

        input[3][0] = 15;
        input[3][1] = 18;

        int[][] result = merge(input);
        System.out.println(result);
    }
}
