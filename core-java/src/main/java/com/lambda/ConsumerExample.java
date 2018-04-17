package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("tt", "", "oo");

        // consumer.. just take the string and print
        forEach(listOfStrings, (String s) -> System.out.println(s));

    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for(T t: list) {
            consumer.accept(t);
        }
    }
}
