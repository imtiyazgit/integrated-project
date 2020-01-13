package algos.number.noofdigitsinainteger;

import java.util.Arrays;

public class NoOfEvenAndOddDigitsInANumber {

    private static int[] noOfEvenOrOddUsingIterative(int n) {

        if(n==0) {
            return new int[] {1,0};
        }

        int[] arr = new int[2];
        // first element represents no of even digits
        // second element represents no of odd digits

        while(n>0) {

            int lastDigit = n%10;
            if(lastDigit%2 == 0) {
                arr[0] = arr[0] + 1;
            } else {
                arr[1] = arr[1] + 1;
            }

            n = n/10;
        }

        return arr;
    }

    public static void main(String[] args) {
        int i = 123456;

        // no of odd 3
        // no of even 3

        System.out.println(Arrays.toString(noOfEvenOrOddUsingIterative(i)));
    }
}
