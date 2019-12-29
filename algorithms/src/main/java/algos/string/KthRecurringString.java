package algos.string;

import java.util.HashMap;
import java.util.Map;

public class KthRecurringString {

    private static String recurringString(String[] words, int frequency) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s: words) {
            Integer freq = map.get(s);
            if (freq == null) freq = 0;
            map.put(s, ++freq);
        }

        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            if(entry.getValue() == frequency) {
                return entry.getKey();
            }
        }

        return null;

    }

    public static void main(String[] args) {
        String str = "a a b ";

        System.out.println(recurringString(str.split(" "), 1));

    }
}
