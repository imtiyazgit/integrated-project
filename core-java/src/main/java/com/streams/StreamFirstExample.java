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

    }
}


class Dish {
    private String name;
    private int calories;

    public Dish(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
