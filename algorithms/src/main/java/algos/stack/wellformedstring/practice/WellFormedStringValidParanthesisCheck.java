package algos.stack.wellformedstring.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

// ()
// [()]
// [{}{}()]
// {[){
public class WellFormedStringValidParanthesisCheck {

    static Map<Character, Character> LOOKUP = Map.of('(', ')', '{', '}', '[', ']');

    public static boolean isWellFormed(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            // If the character is a opening bracket from lookup, push it onto a stack
            if (LOOKUP.containsKey(s.charAt(i))) {
                stack.addFirst(s.charAt(i));
            } else {
                // Must be a closing bracket. When a closing bracket is found, stack must be non empty.
                if (stack.isEmpty()) {
                    return false;
                } else {
                    // if incoming closing bracket is ), then stack's top must be (
                    // So, stack's top's lookup value is ) and then compare with incoming )
                    if(LOOKUP.get(stack.peek()) == s.charAt(i)) {
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

        System.out.println(isWellFormed(test1)); // false
        System.out.println(isWellFormed(test2)); // false
        System.out.println(isWellFormed(test3)); // true
        System.out.println(isWellFormed(test4)); // false
        System.out.println(isWellFormed(test5)); // true
    }

}
