package com.streams;

import java.util.Arrays;
import java.util.List;

public class findOp {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(3,3,3,3);

        ints.stream().filter(e -> e == 3).findAny().ifPresent((e) -> System.out.println(e));

        ints.stream().filter(e -> e == 3).findFirst().ifPresent((e) -> System.out.println(e));

        if(ints.stream().anyMatch(e->e==3)) {
            System.out.println("Match found");
        }

        if(ints.stream().allMatch(e->e==3)) {
            System.out.println("All matched.. great");
        }

        if(ints.stream().noneMatch(e->e==4)) {
            System.out.println("Yes, none match");
        }
    }


}
