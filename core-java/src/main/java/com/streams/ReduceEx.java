package com.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceEx {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3,4,5);

        int result = ints.stream().reduce(1,(a,b)-> a+b);
        System.out.println(result);

        ints.stream().reduce((a,b) -> a+b).ifPresent((e-> System.out.println(e)));

        List<Dish> dishes = Arrays.asList(
                new Dish("biryani", 1000),
                new Dish("gulab", 900),
                new Dish("fish", 200),
                new Dish("Dosa", 100)
        );

        // count number of dishes
        System.out.println(dishes.stream().count());

        System.out.println(dishes.stream().collect(Collectors.counting()));

        // find highest calorie dish
        Comparator comparator = Comparator.comparingInt(Dish::getCalories);
        System.out.println(dishes.stream().max(comparator));

        System.out.println(dishes.stream().min(Comparator.comparing(Dish::getCalories)));
    }



}
