package algos.recursion;

/**
 * ProblemStatement: Given an array, check if it is in sorted order using recursion
 *
 *
 */

public class CheckGivenArraysIsInSortedOrder {


    private static boolean isArraySorted(int[] arr, int n) {
        if(n==1) {
            return true;
        }

        return arr[n-1] > arr[n] ? false : isArraySorted(arr, n-1);
    }


    /*private static boolean checkIfSorted(int[] arr, int index1, int index2) {
        if(index2 == arr.length) {
            return true;
        }

        if(arr[index1] > arr[index2]) {
            return false;
        }

        index1 = index2;
        index2= index2+1;

        return checkIfSorted(arr, index1, index2);
    }*/

    public static void main(String[] args) {

        int[] arr = new int[] {1,3,4,5,6};

        boolean result = isArraySorted(arr, arr.length-1);

        System.out.println(result);

    }
}
