package algos.string.runlengthcompression;

/**
 * Problem: aaaabbbccdddd
 * output: 4a3b2c24d
 */
public class RunLengthCompression {

    // input aaaabbbccdddd output: 4a3b2cdd
    private static String encoding(String s) {
        StringBuilder result = new StringBuilder();

        int count=1;
        // Note: Iteration is upto length+1 here because to get the correct count for last digit
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i-1)) {
                result.append(count).append(s.charAt(i-1));
                count = 1;
            } else { // s.chartAt(i) == s.chartAt(i-1)
                ++count;
            }
        }

        return result.toString();

    }

    // input 4a3b2c4d.. output
    private static String decoding(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                count = s.charAt(i) - '0'; // String characters return ascii values. To get actual int value you need to subtract '0' from it
            } else {
                while(count>0) {
                    result.append(s.charAt(i));
                    count--;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(encoding("aaaabbbccdddd")); // 4a3b2c4d

        System.out.println(decoding("4a3b2c4d")); // aaaabbbccdddd
    }
}
