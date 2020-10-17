package algos.string.backspacestringcompare;

import java.util.*;

public class Solution {

    public static boolean backspaceCompare2(String S, String T) {
        return build(S).equals(build(T));
    }

    private static String build(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c: S.toCharArray()) {
            if(c == '#' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack);
    }

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }

    // input:  S = "ab#c", T = "ad#c"
    public static boolean backspaceComparePractice(String S, String T) {

        int i=S.length()-1;
        int j=T.length()-1;
        int sSkipCount=0;
        int tSkipCount=0;

        while(i>=0 || j>=0) {

            // find the actual character for S
            while(i>=0) {
                if(S.charAt(i) == '#') {
                    sSkipCount++;
                    i--;
                } else if(sSkipCount > 0) {
                    sSkipCount--;
                    i--;
                }
            }

            while(j>=0) {
                if(T.charAt(j) == '#') {
                    tSkipCount++;
                    j--;
                } else if(tSkipCount >0) {
                    tSkipCount--;
                    j--;
                }
            }

            // now chars at i and j must be equal
            if(i>=0 && j >=0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            // check if one string is of less length
            if( (i>=0 && j<0) || (i<0 && j>=0)) return false;

            i--;
            j--;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(backspaceComparePractice("ab##", "c#d#"));
    }
}
