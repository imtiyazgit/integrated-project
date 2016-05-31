package algos.array;

public class FindSmallestGreatestInArr {
    public static void main(String[] args) {
        int[] arr = {4, 1, 8, 3, 10};
        int smallest = arr[0];
        int largest = arr[0];

        for (int i=1;i<arr.length;i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
            else if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        System.out.println("Smallest="+smallest);
        System.out.println("Largest="+largest);
    }
}
