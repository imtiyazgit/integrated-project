package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFirstExample {



    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(
                new Dish("biryani", 1000),
                new Dish("gulab", 900),
                new Dish("fish", 200),
                new Dish("Dosa", 100)
        );

        List<String> dishNames = dishes.stream().filter(
                dish -> {
                    System.out.println("filtering "+dish.getName());
                    return dish.getCalories() > 100;
                }
        ).map(
                d -> {
                    System.out.println("mapping "+d.getName());
                    return d.getName();
                }
        ).limit(6).collect(Collectors.toList());

        System.out.println(dishNames);

        System.out.println("No of elements in list "+dishes.stream().count());

        System.out.println("Print each eleemnt of list usings streams");

        dishes.stream().map(Dish::getName).forEach(System.out::println);
    }
}


