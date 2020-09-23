package algos.string.numWaysToDecode;

import java.util.HashMap;

public class Solution2 {

    public static int numDecodings(String s) {
        if(s==null || s.length() == 0) {
            return 0;
        }

        return recursiveWithMemo(0, s);
    }

    public static int recursiveWithMemo(int index, String s) {
        if(index == s.length()) {
            return 1;
        }

        if (index == s.length()-1) {
            return 1;
        }

        if(s.charAt(index) == '0') {
            return 0;
        }

        int ans = recursiveWithMemo(index+1, s);
        if(Integer.parseInt(s.substring(index, index+2)) <= 26) {
            ans += recursiveWithMemo(index+2, s);
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(numDecodings("0"));
    }
}

