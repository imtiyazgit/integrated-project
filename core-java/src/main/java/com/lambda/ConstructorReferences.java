package com.lambda;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ConstructorReferences {

    static class Flower {
        int name;
        int weight;

        public Flower() {
        }

        public Flower(int name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        // See constructors take arguments and return its instance
        // So, you can use Function<T,R>
        // If constructors has two arguments, use BiFunction<T,U,R>

        Supplier<Flower> supplier = () -> new Flower();
        BiFunction<Integer, Integer, Flower> biFunction = (i1, i2) -> new Flower(i1, i2);

        System.out.println(supplier.get());
        System.out.println(biFunction.apply(2,3));


        //-----------
        Supplier<Flower> supplier1 = Flower::new;
        System.out.println(supplier1);

        BiFunction<Integer, Integer, Flower> biFunction1 = Flower::new;
        System.out.println(biFunction1);
    }
}
