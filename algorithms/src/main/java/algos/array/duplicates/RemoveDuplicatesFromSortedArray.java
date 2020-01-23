package algos.array.duplicates;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,5,5};

        // Have two counters, i pointing to first index and j next index
        // Logic is simple. We copy the second element to itself if they are not same. and increment both counters
        // If the elements are same, i remains at same locaiton since we dont want to copy and just increase j
        int i=0;
        int j=1;

        while(j<arr.length) {

            if(arr[i] != arr[j]) {
                arr[++i] = arr[j++];
            } else {
                j++;
            }

        }

        // We dont want to have the remaining elements which are beyond j since we have already removed duplicates
        // so create a result array and copy elements upto j
        int[] result = new int[i+1];
        for (int k = 0; k < result.length; k++) {
            result[k] = arr[k];
        }

        System.out.println(Arrays.toString(result));
    }
}


/**
 // Problem: In a sorted array with duplicates, remove all duplicates
 // For example: {1,5,5,6,9,9} result = {1,5,6,9}
 // Solution-1: Extra space You can create another array, check if previous element is same as this element,
 // If elements different, add the current element, to a another result array.
 // This solution uses a another array for result

 // Solution-2: Maintain two counters, i and j.
 // Iterator all the elements using i and compare the previous elements using j
 // If elements are same, then just increase.
 // Otherwise, set the element which is at i to jth location.
 // So, by the time, the array iteration completes, elements until j would have already done with sorting
 // Rest of the elements, we dont want. So, just copy elements until j, to a result array

 public class RemoveDuplicatesFromSortedArray {
 static int[] removeDuplicatesInPlace(int[] input) {
 int i = 1; // Move from one, leaving the first element as it is
 int j = 0; // As we move on, when you find a mismatch between elements, replace at this index with the current element

 while(i < input.length){
 if(input[i] == input[j]){
 i++;
 }else{
 input[++j] = input[i++];
 }
 }

 // Already removed duplicates within this j elements. So, after j index, we don't want
 int[] output = new int[j+1]; // Earlier, j started from 0. So add 1 here for length.
 for(int k=0; k<output.length; k++){
 output[k] = input[k];
 }

 return output;
 }

 public static void main(String a[]){
 int[] input1 = {2,3,6,6,8,9,10,10,10,12,12};
 int[] output = removeDuplicatesInPlace(input1);
 for(int i:output){
 System.out.print(i+" ");
 }
 }

 }**/