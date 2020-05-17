package algos.string.reverse;

import java.util.Arrays;

public class ReverseWordsTest {

    private static void reverseWords(char[] chars) {
        // reverse entire string
        reverse(chars, 0, chars.length-1);

        int length = chars.length;
        int start=0;
        int finish=0;

        while(start < length) {

            // Set start now
            while(start<finish) {
                ++start;
            }

            // Ignore spaces
            while(start < length && chars[start] == ' ') {
                ++start;
            }


            // Start can go ahead. So you need adjust finish too
            while (finish < start) {
                ++finish;
            }

            // Set finish
            while(finish < length && chars[finish] != ' ') {
                ++finish;
            }

            reverse(chars, start, finish-1);
        }

    }

    private static void reverse(char[] input, int startIdx, int endIdx) {
        while(startIdx < endIdx) {
            char c =  input[startIdx];
            input[startIdx++] = input[endIdx];
            input[endIdx--] = c;
        }
    }

    public static void main(String[] args) {
        String input = "I am Imtiyaz";
        char[] chars = input.toCharArray();
        reverseWords(chars);
        System.out.println(Arrays.toString(chars));
    }
}
