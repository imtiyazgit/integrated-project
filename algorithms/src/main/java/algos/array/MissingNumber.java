package algos.array;

// Find Missing Number on Integer Array of 1 to 100
// Missing number = n (n+1)/2 - totalSumOfArray
public class MissingNumber {

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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7,8};
        System.out.println(findMissingNumberUsingSummation(arr));
        System.out.println(findMissingNumberUsingBooleanArray(arr));
    }
}
