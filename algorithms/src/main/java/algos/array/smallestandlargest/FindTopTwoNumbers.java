package algos.array.smallestandlargest;

public class FindTopTwoNumbers {

    public static void main(String[] args) {
        int[] arr = {4,2,5,6,10,9,4,4,5,6,7};

        int max = arr[0];
        int prev_max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                prev_max = max;
                max = arr[i];
            } else if (prev_max < arr[i]) {
                // since array is unsorted, the prev_max can be less than in upcoming elements, so check and set accordingly
                prev_max = arr[i];
            }
        }

        System.out.println("Max is"+max);
        System.out.println("Prev Max is "+prev_max);
    }
}


/**
 package algos.array;

 // Given a un sorted array, find two top most numbers
 // Solution: Set max1 if the current element is higher than it.
 // Set max2 = max1 first
 public class FindTopTwoNumbers {
 public static void main(String[] args) {
 int[] arr = {2,1,3,4,8,5,5,9};

 int max1 = arr[0];
 int max2 = max1;
 for (int i=1;i<arr.length;i++) {
 if (arr[i] > max1) {
 max2 = max1;
 max1 = arr[i];
 } else if (max2 > arr[i]) {
 max2 = arr[i];
 }
 }

 System.out.println("Max1="+max1);
 System.out.println("Max2="+max2);

 }
 }
**/