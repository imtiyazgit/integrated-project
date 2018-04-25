package com.streams;

import java.util.Arrays;
import java.util.List;

public class ReduceEx {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1,2,3,4,5);

        int result = ints.stream().reduce(1,(a,b)-> a+b);
        System.out.println(result);

        ints.stream().reduce((a,b) -> a+b).ifPresent((e-> System.out.println(e)));



    }



}
