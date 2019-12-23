package algos.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutations {


    // {1,2,3} - swapping by itself
    // {1,3,2}
    private static List<int[]> permutations(int[] a) {
        List<int[]> results = new ArrayList<>();
        permutations(a, 0, results);
        return results;
    }


    private static void permutations(int[] a, int start, List<int[]> results) {
        if (start >= a.length) {
            results.add(a.clone());
        } else {
            for (int i = start; i < a.length; i++) {
                swap(a, start, i);
                permutations(a, start + 1, results);
                swap(a, start, i);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        for(int[] a :permutations(new int[]{1,2,3})) {
            System.out.println(Arrays.toString(a));
        }
    }
}
