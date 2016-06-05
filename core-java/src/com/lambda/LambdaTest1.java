package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by imtiyaz on 30/05/16.
 */
public class LambdaTest1 {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("red", "10"),
                new Apple("green", "12"),
                new Apple("red", "7"),
                new Apple("green", "5"));

        // filter apples which are green
        List<Apple> greenApples = filter(list,  (Apple apple) -> apple.getColor().equals("green"));
        System.out.println(Arrays.toString(greenApples.toArray()));

        // filter apples which are red
        List<Apple> redApples = filter(list, (Apple apple) -> apple.getColor().equals("red"));
        System.out.println(Arrays.toString(redApples.toArray()));
    }

    private static List<Apple> filter(List<Apple> list, Predicate<Apple> predicate) {
        List<Apple> results = new ArrayList<Apple>();
        for (Apple apple : list) {
            if (predicate.test(apple)) {
                results.add(apple);
            }
        }
        return results;
    }
}
