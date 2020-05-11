package algos.string.conversion;

/**
 * "123" -> 123
 *  Elegant solution is: runningSum * 10 + 1 = 1 because running sum is zero initially
 *                       1 * 10 + 2 = 12
 *                       12 * 10 + 3 = 123
 *
 */
public class StringToInt {

    private static int convertToInt(String s) {
        if(s==null || s.length() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        boolean isNegative = false;
        if(s.charAt(0) == '-') {
            isNegative = true;
            s = s.substring(1);
        }

        int runningSumOrResult=0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            runningSumOrResult = runningSumOrResult*10 + c - '0'; // character addition here uses ascii value.. subtract 48 or - '0'
        }

        // Below code also works if you want to use reduce of streams
        //return s.chars().reduce(0, (runningSumOrResult, c) -> runningSumOrResult* 10+c-'0');


        return isNegative ? -1 * runningSumOrResult : runningSumOrResult;
    }

    public static void main(String[] args) {
        int result1 = convertToInt("123");
        System.out.println(result1);

        int result2 = convertToInt("0");
        System.out.println(result2);

        int result3 = convertToInt("-123");
        System.out.println(result3);
    }
}
