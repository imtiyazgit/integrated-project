package com.withoutbuiltinfunctions;

// Without string.reverse, reverse a string
// Solution-1 - use string to array and iterator backwards
// Solution-2 - Using recursive function
public class StringReverseUsingIteration {
    public static void main(String[] args) {
        String str = "Hello";
        char[] arr = str.toCharArray();
        String result="";
        for (int i=arr.length-1; i>=0;i--) {
            result += arr[i];
        }

        System.out.println(result);
    }
}
