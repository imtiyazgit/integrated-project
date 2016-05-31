package algos.sort;

import java.util.Arrays;

public class SelectionSort {
    static void selectionSort(int[] arr) {
        for (int i=0;i<arr.length-1;i++) {
            int minIndex = i;

            for (int j=i+1;j<arr.length;j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4, 7,3,5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
