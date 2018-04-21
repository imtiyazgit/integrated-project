package com.streams;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        // Lets say you have list of two strings.

        List<String> strings = Arrays.asList("abca", "dcaf");

        // Now you have to want have unique elements
        strings.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);


        List<Integer[]> listOfIntArr = Arrays.asList(
                new Integer[] {1,2},
                new Integer[] {3,4}
            );

        // i want to print array elements

        listOfIntArr.stream().flatMap(Arrays::stream).forEach(System.out::println);
    }
}
