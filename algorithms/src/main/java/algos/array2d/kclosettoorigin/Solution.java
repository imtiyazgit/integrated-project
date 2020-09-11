package algos.array2d.kclosettoorigin;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static int[][] findKClosestToOrigin(int[][] points, int K) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) ->
                (y[0] * y[0] + y[1] * y[1] - (x[0] * x[0] + x[1] * x[1]))
        );

        for(int[] coord : points) {
            maxHeap.add(coord);
            if(maxHeap.size() > K) {
                maxHeap.remove();
            }
        }

        int[][] results = new int[K][2];

        for(int i=0; i< K; i++) {
            results[i] = maxHeap.remove();
        }

        return results;
    }

    public static void main(String[] args) {
        int[][] points= new int[4][2];
        points[0][0] = 0;
        points[0][1] = 3;

        points[1][0] = 2;
        points[1][1] = 2;

        points[2][0] = 3;
        points[2][1] = -3;

        points[3][0] = -1;
        points[3][1] = -3;

        int[][] results = findKClosestToOrigin(points, 3);
        for(int[] result: results) {
            System.out.println(Arrays.toString(result));
        }
    }
}
