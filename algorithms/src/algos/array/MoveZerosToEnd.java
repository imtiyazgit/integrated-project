package algos.array;

// {2,0,4,5,0,0,7} Move zeros to end
// Iterate the array and maintain a counter
// If element not zero, put the element in the counter and increment it.
// At the end, while (counter < length), add only zeros

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {2,0,4,5,0,0,7};
        int length = arr.length;
        int counter = 0;

        for (int i=0; i<length; i++) {
            if (arr[i] != 0) {
                arr[counter++] = arr[i];
            }
        }

        while (counter < length) {
            arr[counter++] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }
}
