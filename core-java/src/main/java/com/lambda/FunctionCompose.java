package com.lambda;

import java.util.function.Function;

public class FunctionCompose {

    public static void main(String[] args) {
        // string addheader
        // string checkspell
        // string addfooter always 3 steps

        Function<String, String> addHeader = str -> str + "1 - ";

        Function<String, String> checkSpell = str -> str + "2 - ";

        Function<String, String> addFooter = str -> str + "3 -";

        Function<String, String> finalFunction = addHeader.andThen(checkSpell).andThen(addFooter);

        System.out.println(finalFunction.apply("Start"));
    }
}
