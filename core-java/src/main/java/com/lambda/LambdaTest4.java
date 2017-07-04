package main.java.com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Print elements of list using lambda
 */
public class LambdaTest4 {

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T obj:list) {
            consumer.accept(obj);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{
                "test", null, "test3", "test4"
        });

        forEach(list, (String str) -> {System.out.println(str);});
    }
}
