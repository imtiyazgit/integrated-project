package algos.array.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem Statement:
 */
public class ApplyPermutation {

    /**
     * With additional space
     * Time complexity: O(n)
     * Space Complexity: O(n)
     */
    // a, b, c, d
    // 2  0  1  3  -- Apply this perm. Meaning you basically move element at the given perm location
    //       a       a should be moved to 2nd location
    // b     a       b is moved to 0 location
    // b  c  a       c is moved to 1 location
    // b  c  a  d    d is stayed at 3 location
    private static char[] applyPermWithAdditionalSpace(char[] arr, int[] applyPermArr) {
        char[] resultArr = new char[arr.length];

        for (int i = 0; i < applyPermArr.length; i++) {
            // You basically need to get value of applyPerm and in resultArr at that element set current arr value
            resultArr[applyPermArr[i]] = arr[i];
        }

        return resultArr;

    }

    /**
     *
     * Technique here is that, swap the perm array as well. You keep swapping with perm value until you get ith index value.
     *
     */
    private static void applyPermutation(List<Integer> perm, List<Character> A) {
        for (int i = 0; i < A.size(); i++) {
            while(perm.get(i) != i) {
                Collections.swap(A, i, perm.get(i));
                Collections.swap(perm, i, perm.get(i));
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[] {'a', 'b', 'c', 'd'};
        int[] applyPerm = new int[] {2,0,1,3};

        System.out.println(applyPermWithAdditionalSpace(chars, applyPerm));

        List<Character> listOfInputChars = new ArrayList<>();
        listOfInputChars.add('a');
        listOfInputChars.add('b');
        listOfInputChars.add('c');
        listOfInputChars.add('d');


        //-----------

        List<Integer> perm = new ArrayList<>();
        perm.add(2);
        perm.add(0);
        perm.add(1);
        perm.add(3);

        applyPermutation(perm, listOfInputChars);

        System.out.println(listOfInputChars.toString());
    }
}
