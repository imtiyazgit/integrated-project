package algos.number.numToRoman;

import java.util.Map;

/**
 * Your input is roman and you need to return its corresponding int
 * The roman input is of decreasing order
 * <p>
 * L - 50
 * LX - 60
 * DL - 550
 * etc
 * <p>
 * Exceptions:
 * I can immediately precede V and X e.g. IV or IX
 * X can immediately precede L and C
 * C can immediately precede D and M
 * <p>
 * Back to back exceptions IXC not allowed. CDM not allowed
 */
public class RomanToInteger {
    private static Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    // MCMIV
    private static int romanToIntFromBackside(String roman) {
        if (roman == null || roman.length() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        // First add the last element
        int result = map.get(roman.charAt(roman.length() - 1));

        // Last index 'V' is already fetched. So, start from length-2 i.e. at I
        for (int i = roman.length() - 2; i >= 0; i--) {
            int rightSideElement = map.get(roman.charAt(i + 1));
            int thisElement = map.get(roman.charAt(i));


            // MCMIV.. If I is greater, then add. If not subtract
            if (thisElement > rightSideElement) {
                // Roman should be increasing from backside, therefore just add
                result += thisElement;
            } else {
                // if this element is less as compared to its right, then its an exception.. so subtract
                result -= thisElement;
            }

        }

        return result;

    }


    // From left to right..
    private static int romanToInt2(String roman) {
        int result = 0;

        for (int i = 0; i < roman.length(); i++) {
            if (i + 1 < roman.length() && roman.charAt(i) < roman.charAt(i + 1)) {
                // IX .. Get difference and add
                int diff = (int) map.get(roman.charAt(i + 1)) - (int) map.get(roman.charAt(i));
                result += diff;
                i++;
                continue;
            }

            result += (int) map.get(roman.charAt(i));

        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(romanToInt("L")); // 50
//        System.out.println(romanToInt("LX")); // 60
//        System.out.println(romanToInt("DL")); // 550
        //System.out.println(romanToInt("LIX")); // 59
        // System.out.println(romanToInt("MCMIV")); // 1904

        System.out.println(romanToIntFromBackside("L")); // 50
        System.out.println(romanToIntFromBackside("LX")); // 60
        System.out.println(romanToIntFromBackside("DL")); // 550
        System.out.println(romanToIntFromBackside("LIX")); // 59
        System.out.println(romanToIntFromBackside("MCMIV")); // 1904
    }
}
