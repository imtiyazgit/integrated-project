package algos.string;

/**
 * Problem: How many ways to decode this message. A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26

 Given an encoded message containing digits, determine the total number of ways to decode it.

 Examples: 12
 Can be decode as 1 or 12 i.e. A or L. So 2 is the answer.

 */

public class NumWaysDecode {

    /**
     * decode("") - 1
     * decode("0) - 1
     * decode("27") - 1
     * decode("12") - 2
     * @param message
     * @return
     */
    private static int decode(String message) {

        // Base condition when "" -> num ways to decode this "" is 1
        if (message.length() == 0) {
            return 1;
        }

        int sum =0;
        // now calculate head and tail: head is from 0 to 1 and tail is remaining
        for (int start = 1; start <= message.length(); start++) {
            String head = message.substring(0, start);
            String tail = message.substring(start);

            if (Integer.parseInt(head) > 26) {
                break;
            }

            sum = sum + decode(tail);

        }

        return sum;
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < dp.length ; i++) {
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigits = Integer.valueOf(s.substring(i-2, i));
            if(oneDigit >= 1) {
                dp[i] += dp[i-1];
            }

            if(twoDigits >= 10 && twoDigits <=26) {
                dp[i] += dp[i-2];
            }
            
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        // Go in order
        String str = "";
        //System.out.println(decode(str)); // Prints 1

        str = "0";
        //System.out.println(decode(str)); // Prints 1

        str = "27";
        System.out.println(numDecodings(str)); // Prints 1

        str = "12";
        //System.out.println(decode(str)); // Prints 2

    }

}
