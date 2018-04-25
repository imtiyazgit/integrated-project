package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {
    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(
                new Dish("biryani", 1000),
                new Dish("gulab", 900),
                new Dish("fish", 200),
                new Dish("Dosa", 100)
        );


        System.out.println(dishes.stream().mapToInt(dish->dish.getCalories()).sum());

        dishes.stream().mapToInt(dish->dish.getCalories()).max().ifPresent(System.out::println);

        IntStream stream = IntStream.rangeClosed(1, 100).filter(x->x%2==0);
        System.out.println(stream.count());


        Stream<int[]> triples = IntStream.rangeClosed(1,100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a,100)
                        .filter(b-> Math.sqrt(a*a + b*b) %1 ==0 )
                        .mapToObj(b -> new int[] {a,b,(int) Math.sqrt(a*a+b*b)})
                );

        triples.limit(5).forEach(t-> System.out.println(t[0] + ","+ t[1] +","+ t[2]));



    }
}
