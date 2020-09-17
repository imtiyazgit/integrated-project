package algos.array2d.intervalintesection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    public static int[][] intervalIntersection(int[][] A, int[][] B) {

        int i=0;
        int j=0;
        List<int[]> results = new ArrayList<>();

        while(i<A.length && j<B.length) {

            if(A[i][0] <= B[j][1] && B[j][0] <= A[i][1]){
                int[] intersect = new int[2];
                intersect[0] = Math.max(A[i][0], B[j][0]);
                intersect[1] = Math.min(A[i][1], B[j][1]);
                results.add(intersect);
            }

            // increment either i or j
            if(B[j][1] >= A[i][1]) {
                // there are other intervals in A which could interset B. Increment i
                i++;
            } else {
                j++;
            }
        }

        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        int[][] A = {
                {0, 2},
                {5, 10},
                {13, 23},
                {24, 25}};
        int[][] B = {
                {1, 5},
                {8, 12},
                {15, 24},
                {25, 26}};

        for(int[] ar: intervalIntersection(A, B)) {
            System.out.println(Arrays.toString(ar));
        }
    }
}
