package algos.string.licencekeyformatting;

import java.util.Stack;

public class Solution {
    //5F3Z-2e-9-w
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder result = new StringBuilder();
        int count=0;

        int i=S.length()-1;
        while(i>=0) {
            char c = Character.toUpperCase(S.charAt(i));
            if(c == '-') {
                // skip this and do not add to the result. dont change count as this is not part of group
                i--;
            } else if(count== K) {
                result.insert(0, "-");
                count = 0;
            } else {
                result.insert(0, c);
                i--;
                // every time we insert, count of characters in group should be increased
                count++;
            }


        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
