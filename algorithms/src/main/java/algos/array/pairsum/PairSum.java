package algos.array.pairsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Print all pairs of an array with given sum
 *
 * Input: {1,5,7,-1,5}, sum =-6, output= {1,5} , {7,-1}, {1,5}
 */
public class PairSum {

    private static List<int[]> findPairsUsingTwoLoops(int[] arr, int sum) {
        List<int[]> results = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            for (int j=i+1; j < arr.length ; j++) {
                if (arr[i] + arr[j] == sum) {
                    results.add(new int[] {arr[i], arr[j]});
                }
            }
        }

        return results;
    }


    /**
     * Have two indexes, one at end and one at beginning
     * travese till middle while leftInde < rightIndex
     * if the sum of leftIndexEle and rightIndexEle == su, you found pair,
     * if its greater, then decrement rightIndex
     * if its lesseser, increment leftIndex
     */
    private static List<int[]> findPairs(int[] arr, int sum) {
        Arrays.sort(arr);

        List<int[]> results = new ArrayList<>();
        int leftIndex =0;
        int rightIndex = arr.length -1;

        while (leftIndex < rightIndex) {
            if(arr[leftIndex] + arr[rightIndex] > sum) {
                rightIndex--;
            } else if(arr[leftIndex] + arr[rightIndex] < sum) {
                leftIndex++;
            } else {
                results.add(new int[] {arr[leftIndex], arr[rightIndex]});
                // You can either do left index ++ or right index --, doesnt matter
                leftIndex++;
            }
        }

        return results;
    }

    /**
     * As you traerse through array, add matchingpair, pair to the hashmap. As you are traversing through rthe rest of
     * elements, if you find the elements as key, then thats the pair
     */
    private static List<int[]> findPairsUsingHashMap(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();

        List<int[]> results = new ArrayList<>();

        for(int ele: arr) {
            if(map.containsKey(ele)) {
                // this is the pair we already put
                results.add(new int[] {ele, map.get(ele)});
            }

            map.put(sum-ele, ele);
        }

        return results;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,-1,5};

        List<int[]> results = findPairsUsingTwoLoops(arr, 6);

        for (int[] i : results) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println("---------------");

        results = findPairs(arr, 6);

        for (int[] i : results) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println("---------------");

        results = findPairsUsingHashMap(arr, 6);

        for (int[] i : results) {
            System.out.println(Arrays.toString(i));
        }



    }
}
