package algos.string.decodestring;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString {

    //Input: s = "3[a]2[bc]"
    //Output: "aaabcbc"
    public static String decodeString(String s) {
        Stack<Integer> counts = new Stack();
        Stack<String> strings = new Stack();
        String res = "";
        int index = 0;

        while(index <s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                //23
                int num = 0;
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                counts.push(num);
            } else if (s.charAt(index) == '[') {
                strings.push(res);
                res = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(strings.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            } else {
                res += s.charAt(index);
                index++;
            }
        }
        return res;
    }

    public static String decodeStringPractice(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<String> strings =new ArrayDeque<>();
        String result = "";
        int index=0;

        while(index < s.length()) {

            // if its digit
            if(Character.isDigit(s.charAt(index))) {
                int num=0;

                while(Character.isDigit(s.charAt(index))) {
                    num = num*10 + s.charAt(index) - '0';
                    index++;
                }

                // you have num now, push it to counts stack
                counts.addFirst(num);
            } else if(s.charAt(index) == '[') {
                strings.addFirst(result);
                result = "";
                index++;
            } else if(s.charAt(index) == ']') {
                int count = counts.removeFirst();
                StringBuilder tempString = new StringBuilder();
                for(int j=0;j<count;j++) {
                    tempString.append(result);
                }
                result = strings.removeFirst() + tempString;

                index++;
            } else {
                // letter
                result += s.charAt(index);
                index++;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(decodeStringPractice("3[a]2[bc]"));
    }

}
