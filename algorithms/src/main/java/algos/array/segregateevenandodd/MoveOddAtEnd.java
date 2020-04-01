package algos.array.segregateevenandodd;

import java.util.Arrays;

public class MoveOddAtEnd {

    private static void moveOddAtEndInPlaceWithoutExtraSpace(int[] arr, int length) {
        if(length == 0) {
            throw new IllegalArgumentException();
        }

        int start =0;
        int end = length-1;

        while(start < end) {
            if(arr[start] %2 == 0) {
                // If its even, go on
                start++;
            } else {
                swap(arr, start, end);
                end--;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6,7,8};
        moveOddAtEndInPlaceWithoutExtraSpace(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
