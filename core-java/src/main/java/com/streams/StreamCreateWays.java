package com.streams;

import java.util.stream.Stream;

public class StreamCreateWays {
    public static void main(String[] args) {
        Stream<String> st = Stream.of("a", "b");
        //st.filter(s-> s=="a").forEach(System.out::println);
        st.map(t->t +"1").forEach(System.out::println);
    }
}
