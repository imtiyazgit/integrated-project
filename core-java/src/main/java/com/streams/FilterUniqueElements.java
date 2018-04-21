package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterUniqueElements {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3,3,3,4,5);

        ints.stream().distinct().forEach(System.out::println);


        List<Dish> dishes = Arrays.asList(
                new Dish("biryani", 1000),
                new Dish("gulab", 900),
                new Dish("fish", 200),
                new Dish("Dosa", 100)
        );

        List<Dish> result = dishes.stream().limit(2).collect(Collectors.toList());
        System.out.println(result);
    }
}
