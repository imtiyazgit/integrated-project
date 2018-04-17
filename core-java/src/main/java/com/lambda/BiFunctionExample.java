package com.lambda;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        String str = "Hello";
        Integer in = 2;

        System.out.println(getSomeOtherValue(str, in, (String inStr, Integer inInt) -> "some"));
    }

    public static String getSomeOtherValue(String str, Integer in, BiFunction<String, Integer, String> biFunction) {
        return biFunction.apply(str, in);
    }
}
