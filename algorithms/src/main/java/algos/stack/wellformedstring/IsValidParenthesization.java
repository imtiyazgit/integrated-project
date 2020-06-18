package algos.stack.wellformedstring;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

public class IsValidParenthesization {

    public static Map<Character, Character> LOOKUP = Map.of('{', '}', '(', ')', '[', ']');

    // ()
    // {()}
    public static boolean isValidParanthesization(String s) {
        Deque<Character> stack = new ArrayDeque();

        for (int i = 0; i < s.length(); i++) {

            // if map contains this opening bracket, add to stack
            if(LOOKUP.containsKey(s.charAt(i))) {
                stack.addFirst(s.charAt(i));
            } else {
                // closing bracket. When a closing bracket found, stack can not be empty
                if (stack.isEmpty()) {
                    return false;
                } else {
                    // stack exist. The top element must be matching closing bracket
                    // If char is ).. Stack top must be ( .. Get stack's top's lookup i.e. ) and compare with )
                    if (LOOKUP.get(stack.peek()) == s.charAt(i)) {
                        stack.removeFirst();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "-()";
        String test2 = "([";
        String test3 = "([])";
        String test4 = "({}{)";
        String test5 = "{[]()}";

        System.out.println(isValidParanthesization(test1));
        System.out.println(isValidParanthesization(test2));
        System.out.println(isValidParanthesization(test3));
        System.out.println(isValidParanthesization(test4));
        System.out.println(isValidParanthesization(test5));
    }

}
