package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("tt", "", "oo");

        // Get list of integers where each int represents length of that string
        List<Integer> listOfInts = map(listOfStrings, (String s) -> s.length());
        System.out.println(listOfInts);

    }

    public static <T, R> List<R> map(List<T> list, Function<T,R> function) {
        List<R> result = new ArrayList<>();
        for(T t: list) {
            result.add(function.apply(t));
        }
        return result;
    }

}
