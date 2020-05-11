package algos.string.conversion;

/**
 * 0 -> "0"
 * -123 -> "-123"
 * 123 -> "123"
 */
public class IntToString {

    private static String intToString(int x) {
        boolean negative = false;
        if (x <0) {
            negative = true;
            x = Math.abs(x); // We dont want minus - to operate when we are fetching remainders
        }

        StringBuilder result = new StringBuilder();

        // Get last digits. We want to run this in do while so that we handle input 0 to the function by running do at least once
        do {
            int lastDigit = x%10;
            result.append(lastDigit);
            x = x/10;
        } while (x != 0);

        // So far you got the digits in reverse order in the result
        // If it is negative also add - to the end, so that when reversed, it has proper sign
        if (negative) {
            result.append("-");
        }

        return result.reverse().toString();

    }

    public static void main(String[] args) {
        String result = intToString(12345);
        System.out.println(result);

        String result2 = intToString(-12345);
        System.out.println(result2);

        String result3 = intToString(0);
        System.out.println(result3);
    }
}
