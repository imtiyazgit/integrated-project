package algos.string.longestbalancedparanethesis;

import java.util.Stack;

/**
 * Problem Statement: Find length of the longest balanced parenthesis in a string.
 * Given a string consisting of opening and closing parenthesis, find the length of the longest balanced parenthesis in it.
 *
 * () - 2
 * ()((( - 2
 * ()))) - 2
 * ()() - 4
 * (()) - 4
 * (())() - 6
 * (()))( - 4
 */
public class LongestBalancedParenthesis {

    private static int longestLengthOfBalancedParenthesis(String str) {
        // This is basically about striking out the valid matching paranthesis and finding the length from that ith to the last peek of stack

        Stack<Integer> stack = new Stack();
        stack.push(-1);

        int maxLengthOfBalancedParenthesis = 0;

        for (int i = 0; i < str.toCharArray().length; i++) {

            if(str.charAt(i) == '(') {
                stack.push(i); // push the index value of it
            } else {
                stack.pop(); // since you found just delete the last pushed index value

                // Now peek the stack and subtract it from current index and this will give you maxLengthOfBalancedParenthesis so far

                if (!stack.isEmpty()) {
                    maxLengthOfBalancedParenthesis = i - stack.peek();
                    //maxLengthOfBalancedParenthesis = Math.max(maxLengthOfBalancedParenthesis, i - stack.peek()); // Not sure why we need to do max here. It just works without it
                } else {
                    // When closing brackets are more, you will end up here. just add to the stack
                    stack.push(i);
                }

            }

        }

        return maxLengthOfBalancedParenthesis;

    }

    public static void main(String[] args) {

        String str1= "()";
        System.out.println(longestLengthOfBalancedParenthesis(str1)); // 2

        String str2= "()(((";
        System.out.println(longestLengthOfBalancedParenthesis(str2)); // 2


        String str3= "())))";
        System.out.println(longestLengthOfBalancedParenthesis(str3)); //2

        String str4 = "()()";
        System.out.println(longestLengthOfBalancedParenthesis(str4)); //4

        String str5 = "(())()";
        System.out.println(longestLengthOfBalancedParenthesis(str5));//6

        String str6 = "(()))(";
        System.out.println(longestLengthOfBalancedParenthesis(str6));//4
    }


}
