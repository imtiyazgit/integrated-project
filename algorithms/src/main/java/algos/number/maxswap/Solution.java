package algos.number.maxswap;

import java.util.Arrays;

public class Solution {
    public static int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

    public static int maximumSwap2(int num) {
        char[] charArray = Integer.toString(num).toCharArray();
        int[] maxSoFar = new int[charArray.length];
        int[] indexes =  new int[charArray.length];
        Arrays.fill(maxSoFar, Integer.MIN_VALUE);
        Arrays.fill(indexes, -1);

        for (int i = charArray.length-2; i >=0 ; i--) {
            int current = charArray[i] - '0';
            int next = charArray[i+1] - '0';
            if(current < next) {
                maxSoFar[i] = next;
                indexes[i] = i;
            } else if(current < maxSoFar[i+1]) {
                maxSoFar[i] = maxSoFar[i+1];
                indexes[i] = indexes[i+1];
            }
        }

        for (int i = 0; i < charArray.length; i++) {

            if(charArray[i] - '0' < maxSoFar[i]) {
                swap(charArray, i , indexes[i]);
                return Integer.valueOf(new String(charArray));
            }
        }

        return num;
    }

    // 9    6   3   8
    // -    8   8    -    maxSoFar
    // -    3   3        indexes
    public static int maximumSwap3(int num) {
        char[] charArray = Integer.valueOf(num).toString().toCharArray();
        int[] maxSoFar = new int[charArray.length];
        int[] indexes = new int[charArray.length];
        Arrays.fill(maxSoFar, Integer.MIN_VALUE);
        Arrays.fill(indexes, -1);

        for(int i=charArray.length-2; i>=0; i--) {
            int current = charArray[i] - '0';
            int next = charArray[i+1] - '0';


            if(current < maxSoFar[i+1]) {
                // if current is less than max so far found, then max so far at this location is max found so far
                maxSoFar[i] = maxSoFar[i+1];
                indexes[i] = indexes[i+1];
            } else if(current < next) {
                // next element is max
                maxSoFar[i] = next;
                indexes[i] = i+1;
            }
        }

        for(int i=0;i<charArray.length;i++) {
            int cur = charArray[i] - '0';
            if(cur < maxSoFar[i]) {
                // swap it only once and return
                // swap ith index with indexes[i]
                swap3(charArray, i, indexes[i]);
                return Integer.valueOf(new String(charArray));
            }
        }

        return num;
    }

    private static void swap3(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap3(
                98368));
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
                    charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
