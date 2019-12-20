package algos.string;

import java.util.HashMap;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        String str = "ABCBCCB";

        System.out.println(findFirstRecurringCharacter(str));
    }

    private static Character findFirstRecurringCharacter(String str) {
        HashMap<Character, Integer> visitorMap = new HashMap<>();

        for(Character c : str.toCharArray()) {

            if(visitorMap.get(c) != null) {
                return c;
            }
            visitorMap.put(c, 1);
        }
        return null;
    }
}
