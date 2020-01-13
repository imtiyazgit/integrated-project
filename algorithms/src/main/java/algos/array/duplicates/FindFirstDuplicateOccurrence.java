package algos.array.duplicates;

import java.util.HashMap;
import java.util.Map;

public class FindFirstDuplicateOccurrence {

    /**
     * TimeComplexity: O(n2)
     * SpaceComplexity: O(1)
     */
    private static int findFirstDuplicateUsingTwoLoops(int[] arr) {

        for (int i = 0; i < arr.length ; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    return arr[i];
                }
                continue;
            }
        }

        return -1;
    }

    /**
     * TimeComplexity: O(n)
     * SpaceComplexity: O(n)
     */
    private static int findFirstDuplicateOccurrence(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
            int currentValue = hashMap.get(arr[i]);
            if(currentValue > 1) {
                return arr[i];
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,5,4,3};

        System.out.println(findFirstDuplicateOccurrence(arr));
        System.out.println(findFirstDuplicateUsingTwoLoops(arr));
    }
}
