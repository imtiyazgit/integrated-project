package algos.string.lookandsay;

/**
 *
 * Problem: Given an input integer e.g.3, in the look and say sequence, return its nth look and say sequence
 *
1 * 1                    one 1
2 * 11                   two 1s
3 * 21                   one 2; one 1
4 * 1211                 three 1s ; one 2
5 * 11112    goes on
 */
public class LookAndSay {

    private static String lookAndSay(int n) {
        String result = "1";

        // Iterating n-1 times starting from 1
        // For input n with value 2, you need to send previous number i.e. 1
        for (int i = 1; i < n; i++) {
            // Input 1 --> 1
            // Input 11 --> 21
            result = nextNumber(result);
        }

        return result;

    }

    // For input 11, you need to respond with 21 i.e. count of chars and append that char
    // 11
    // 21
    // 1211
    // 111221
    private static String nextNumber(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            int count = 1;
            // Loop until there is a diff in characters
            while( i+1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
                ++count;
                i++;
            }
            result.append(count).append(str.charAt(i));
        }

        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(lookAndSay(1)); //1
        System.out.println(lookAndSay(2)); //11
        System.out.println(lookAndSay(3)); //21
        System.out.println(lookAndSay(4));// 1211
        System.out.println(lookAndSay(5));//111221
        System.out.println(lookAndSay(6));//312211
    }
}
