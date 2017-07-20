package algos.array;

// Find repeated/duplicate numbers in an array if it contains multiple duplicate
// Solution-0 By looping twice, comparing, you can print duplicate elements
// Solution-1, use set.add(elem) which returns false if element already exist
// Solution-2, use hashmap


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicatesInArray {

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
        //findDuplicatesUsingSet(arr);
        findDuplicatesUsingHashMap(arr);
    }
}
