package algos.array;

// Revision

// Find repeated/duplicate numbers in an array if it contains multiple duplicate
// Solution-0 By looping twice, comparing, you can print duplicate elements
// Solution-1, use set.add(elem) which returns false if element already exist
// Solution-2, use hashmap


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicatesInArray {

    // Time complexity - O(n2)
    static void findDuplicatesUsingTwoLoops(int[] arr) {
        for (int i=0; i< arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate found ->"+arr[i]);
                }
            }
        }
    }

    // If array is sorted, then just compare next element
    static void findDuplicateElementsSortFirst(List<Integer> list) {
        Collections.sort(list);

        for (int i = 0; i < list.size() -1; i++) {
            if(list.get(i) == list.get(i+1)) {
                System.out.println("Duplicate found ->"+list.get(i));
            }
        }
    }

    static void findDuplicatesUsingSet(int[] arr)  {
        Set set = new HashSet();
        for (int i=0; i<arr.length; i++) {
            if (set.add(arr[i]) == false) {
                System.out.println("Duplicate found ->"+arr[i]);
            }
        }
    }

    static void findDuplicatesUsingHashMap(int[] arr) {
         Map map = new HashMap();
        for (int i=0;i<arr.length;i++) {
            map.put(arr[i], map.get(arr[i]) != null ? (Integer)map.get(arr[i])+1 : 1);
        }

        Set<Map.Entry> set = map.entrySet();
        for (Map.Entry entry : set) {
            if ( (Integer)entry.getValue() > 1) {
                System.out.println("Duplicate element ->"+entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,5,6,7,8,8};
        findDuplicateElementsSortFirst(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        //findDuplicatesUsingTwoLoops(arr);
        //findDuplicatesUsingSet(arr);
        //findDuplicatesUsingHashMap(arr);
    }
}
