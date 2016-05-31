package com.basic1;

public class StringToInteger {
    public static void main(String[] args) {
        String str = "-12345";
        boolean isNegative = false;
        int start = 0;
        char[] charArr = str.toCharArray();
        if (charArr[0] == '-') {
            isNegative = true;
            start = 1;
        }

        int result = 0;
        while (start < charArr.length) {
            result = result * 10 + (charArr[start] - '0'); // This part is key. If you subtract 1 with '0' you get 1.
            // Or if you subtract 1 from 48, you get 1. Note that '0' = 48 ascii code
            start++;
        }

        if (isNegative) {
            result *= -1;
        }

        System.out.println(result);

    }
}
