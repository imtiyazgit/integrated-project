package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareOfEachNumber {
    public static void main(String[] args) {
       /* List<Integer> integerList = Arrays.asList(1,2,3,4,5);

        integerList.stream().map(i -> i*i).forEach(System.out::println);*/

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);

        List<int[]> result = list1.stream().flatMap(
                i -> list2.stream().map(j-> new int[]{i,j})
        ).collect(Collectors.toList());

        result.stream().map(arr-> Arrays.toString(arr)).forEach(System.out::println);

    }
}
