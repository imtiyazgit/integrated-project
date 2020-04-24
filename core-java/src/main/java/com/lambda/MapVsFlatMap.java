package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

    private static void map() {
        // convert from list of string numbers to integers using map
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");

        List<Integer> result = list1.stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(result);


    }

    private static void flatMap() {
        // convert list of list of strings to list of strings. Only use flat Map
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        List<String> list2 = new ArrayList<>();
        list2.add("3");

        List<List<String>> list = Arrays.asList(list1, list2);

        System.out.println(list); //[[1, 2], [3]]

        List<String> flattenedList = list.stream().flatMap(x -> x.stream()).collect(Collectors.toList()); // drain elements from x stream

        System.out.println(flattenedList.toString()); //[1, 2, 3]
    }

    public static void main(String[] args) {

        System.out.println("Map---");
        map();

        System.out.println("FlatMap----");
        flatMap();

    }
}
