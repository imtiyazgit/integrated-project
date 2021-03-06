package algos.sort;

import java.util.Arrays;

// Quick sort is very efficient for small arrays. Worst case n2 and average case nlogn
// Arrays.sort uses internally quick sort
// How it works:
// It uses a Pivot and recursion logic.
// First set the pivot to end element
// Then use two variables i and j
// j is used to iterate all the elements
// i is initially set to 0 index and will only incremented if the **jth element is less than the pivot
// If any of the element arr[j] is less than pivot, swap i and j elements and increment i
// Once the iteration of j is complete, you need to swap i with end element
// Note, also you need to have this logic as part of recursion
public class QuickSort {
	
	public void sort(Integer[] data) {
		quicksort(data, 0, data.length-1);
	}
	
	public void quicksort(Integer[] data, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(data, start, end);
			quicksort(data, start, pivotIndex-1);
			quicksort(data, pivotIndex+1, end);
		}
	}
	
	private int partition(Integer[] data, int start, int end) {
		int pivot = data[end];
		int i = start;
		// iterate through the elements using j and compare with pivot
		for (int j = start; j <= end - 1; j++) {
			if (data[j] < pivot) {
				// if the element is less than pivot, swap ***i with j*** elements
				int tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
				i++;
			}
		}
		// swap end element at i element so that element to the left of this ith element are less and right are more
		data[end] = data[i];
		data[i] = pivot;
		return i;
	}
	
	public static void main(String[] args) {
		//Integer[] data = {17, 25,5,7,2,18,23,12,18};
		Integer[] data = {7,6,4,11};
		new QuickSort().sort(data);
		System.out.println(Arrays.toString(data));
	}
	
}
