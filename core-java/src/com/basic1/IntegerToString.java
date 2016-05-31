package com.basic1;

public class IntegerToString {
    public static void main(String[] args) {
        int num = -12345;
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = num * -1;
        }

        char[] tmp = new char[11];
        int i=0;
        while (num != 0) {
            int lastDigit = num%10;
            tmp[i++] = (char)(lastDigit + 48); // By adding 48, you convert the integer to char
            num = num/10; // This would exclude the last digit every time from the number
        }

        StringBuffer sb = new StringBuffer();
        if (isNegative) {
            sb.append("-");
        }

        while (i>0) {
            sb.append(tmp[--i]);
        }

        System.out.println(sb.toString());
    }
}
