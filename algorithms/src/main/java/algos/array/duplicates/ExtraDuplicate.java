package algos.array.duplicates;

// Find duplicate number from the array. Exact one duplicate
// Duplicate = arraySum - n(n+1)/2
public class ExtraDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,10,11};
        int length = arr.length-1;
        int expectedSum = length * (length+1) / 2;
        int totalSum=0;
        for (int i:arr) {
            totalSum+=i;
        }
        int duplicate = totalSum - expectedSum;
        System.out.println(duplicate);
    }
}
