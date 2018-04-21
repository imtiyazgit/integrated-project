package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("tt", "", "oo");

        // list of non empty strings only
        List<String> nonEmptyList = filter(listOfStrings, (String s) -> !s.isEmpty());
        System.out.println(nonEmptyList);

        // list of non empty strings and which end with t
        Predicate<String> predicate = s -> !s.isEmpty();
        Predicate<String> finalPredicate = predicate.and(s->s.endsWith("t"));
        List<String> result = filter(listOfStrings, predicate.and(finalPredicate));

        System.out.println(result);

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for(T t : list) {
            if(predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
