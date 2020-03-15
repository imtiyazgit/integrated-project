package algos.array.smallestandlargest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthSmallestElement {


    private static int findKthSmallest(int[] a, int k) {

        Arrays.sort(a);

        return a[k-1];
    }


    private static int findKthSmallestUsingMinHeap(int[] a, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();

        for(int i:a) {
            minHeap.add(i);
        }

        while(k-1 >0) { // You can replace simply with --k
            minHeap.poll();
            k--; // poll k times to find kth smallest
        }

        return minHeap.peek();

    }

    private static int findKthSmallestUsingMaxHeap(int[] a, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for(int i:a) {
            maxHeap.add(i);
        }

        int diffTimes = maxHeap.size() - k - 1;

        while(--diffTimes > 0) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 9, 4};

        System.out.println(findKthSmallest(arr, 2));

        System.out.println(findKthSmallestUsingMinHeap(arr, 2));

        System.out.println(findKthSmallestUsingMaxHeap(arr, 2));
    }
}
