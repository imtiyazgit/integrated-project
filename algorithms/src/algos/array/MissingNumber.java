package algos.array;

// Find Missing Number on Integer Array of 1 to 100
// Missing number = n (n+1)/2 - totalSumOfArray
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6,7, 8,9};
        int length=arr.length+1;
        int expectedSum = length * (1 + length)/2;
        int totalSum=0;
        for (int i:arr) {
            totalSum += i;
        }
        int missingNumber = expectedSum - totalSum;
        System.out.println(missingNumber);
    }
}
