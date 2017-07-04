package main.java.com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by imtiyaz on 6/4/16.
 */
public class LambdaTest3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[] {
                "test", null, "test3", "test4"
        });

        List<String> nonEmptyList = filter(list, (String item) -> item != null);
        System.out.println(nonEmptyList);
    }

    static List<String> filter(List<String> list, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
