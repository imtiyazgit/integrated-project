package com.streams.ch6;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class JoiningTest {
    public static final List<Dish> menu =
            asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
        fromMenuPrintAllDishNames();

        totalCalories();
    }

    public static void fromMenuPrintAllDishNames() {
        // From menu, print all dish names

        String allDishNames = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(allDishNames);


    }

    public static void totalCalories() {
        System.out.println(menu.stream().mapToInt(Dish::getCalories).sum());

        // in reality it is only reduction process which you can do using reducing function

        int sum = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i,j) -> i+j));
        System.out.println(sum);
    }
}
