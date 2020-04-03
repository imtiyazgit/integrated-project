package algos.array.segregateusingpivot.dutchflag;

import java.util.Arrays;

public class MoveRsToLeftGInMiddleBToRight {

    private static void moveRsToLeftGsInMiddleBtoRight(char[] arr) {
        int start=0;
        int end=arr.length-1;
        int index=0;

        while(index<=end && start<=end) {
            if(arr[index] == 'R') {
                swap(arr, index, start);
                index++;
                start++;
            } else if(arr[index] == 'B') {
                swap(arr, index, end);
                end--;
                // Here is the catch, do not increment index as we want to check the element after swapping again to see if its R or G or B
            } else {
                // this is G should be in middle.
                index++;
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        char[] arr = new char[] {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        moveRsToLeftGsInMiddleBtoRight(arr);
        System.out.println(Arrays.toString(arr));

    }
}
