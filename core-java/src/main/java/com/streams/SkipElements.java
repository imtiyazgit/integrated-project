package com.streams;

import java.util.Arrays;
import java.util.List;

public class SkipElements {
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1,2,3,4,5,6);
        elements.stream().skip(2).forEach(System.out::println);



    }
}
