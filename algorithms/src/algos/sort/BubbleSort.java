package algos.sort;

import java.util.Arrays;

/**
 * Created by SG0222221 on 1/9/2016.
 */
public class BubbleSort {
    static void sort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i;j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] =arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {5, 3, 8, 2, 7, 1, 4, 6, 54, 30};
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}
