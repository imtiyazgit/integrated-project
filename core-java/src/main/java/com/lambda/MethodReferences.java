package com.lambda;

import java.util.function.Function;

public class MethodReferences {

    public static void main(String[] args) {

        String input = "eee";

        Function<String, Integer> functionLambda = str -> str.length();
        System.out.println(functionLambda.apply(input));

        //-------

        Function<String, Integer> methodRef = String::length;
        System.out.println(methodRef.apply("ttt"));
    }
}
