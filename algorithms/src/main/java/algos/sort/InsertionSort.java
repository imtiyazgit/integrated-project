package algos.sort;

import java.util.Arrays;

/**
 * How you arrange cards. Lets say you have 3, 6, 9. Now you have card 7. You will move 9 and insert 8 after 6.
 * This is the same logic you need to follow in insertion algos.sort for sortnng
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            int current = arr[i];
            int j = i-1;

            while (j>=0 && arr[j] > current) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4, 7,3,5};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
