package algos.array.missingnumbers;

// Find Missing Number on Integer Array of 1 to 100
// Missing number = n (n+1)/2 - totalSumOfArray
public class OneMissingNumber {

    public static int findMissingNumberIfArraySorted(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            int cur = arr[i];
            int next = arr[i+1];
            if(cur != next -1) {
                return cur + 1;
            }
        }
        return -1;
    }

    public static int findMissingNumberUsingSummation(int[] arr) {
        int length=arr.length+1; // One number is missing. Thats why add +1 here
        int expectedSum = length * (1 + length)/2;
        int totalSum=0;
        for (int i:arr) {
            totalSum += i;
        }
        int missingNumber = expectedSum - totalSum;
        return missingNumber;
    }


    private static int findMissingNumberUsingBooleanArray(int[] arr) {

        int result = -1;

        boolean[] visited = new boolean[arr[arr.length-1]];

        for (int i = 1; i < arr.length; i++) {
            visited[arr[i-1]] = true;
        }

        for (int i = 1; i < visited.length; i++) {
            if(!visited[i]) {
                result = i;
                break;
            }
        }
        return result;
    }


    private static int findMissingNumberUsingXor(int[] arr) {
        // This arr is missing one element. So, when calculating ideal sum or total xor MUST USE arr.length+1

        int idealXorSum = 0;
        int arrXorSum = 0;

        for (int i = 1; i <= arr.length+1; i++) { // Ideal sum, start from 1 to arr.length+1 as one number is missing
            // Using only indexes here for ideal sum calculation. Thats why start from 1
            idealXorSum = idealXorSum ^ i;
        }

        for(int i:arr) {
            // Use actual elements and find sum
            arrXorSum = arrXorSum ^ i;
        }

        return idealXorSum ^ arrXorSum;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7,8};
        System.out.println(findMissingNumberUsingSummation(arr));
        System.out.println(findMissingNumberUsingBooleanArray(arr));
        System.out.println(findMissingNumberIfArraySorted(arr));
        System.out.println(findMissingNumberUsingXor(arr));
    }
}
