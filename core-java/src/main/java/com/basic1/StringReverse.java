package com.basic1;

/**
 * Created by imtiyaz on 7/19/17.
 */
public class StringReverse {

    private String reverse(String input) {
        if (input.length() == 1) {
            return input;
        }
        return reverse(input.substring(1))+input.charAt(0) ;
    }

    public static void main(String[] args) {
        /*String input ="hello";
        char[] inputArr = input.toCharArray();
        char[] resultArr = new char[inputArr.length];
        int index = 0;
        for (int i = inputArr.length; i > 0; i--) {
            resultArr[index] = inputArr[i-1];
            index++;
        }
        System.out.println(resultArr);*/
        String input = "hello";
        System.out.println(input);
        StringReverse obj = new StringReverse();
        String result = obj.reverse(input);
        System.out.println(result);

    }

}
