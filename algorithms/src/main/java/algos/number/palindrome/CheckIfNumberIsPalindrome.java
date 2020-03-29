package algos.number.palindrome;

public class CheckIfNumberIsPalindrome {

    private static boolean isPalindromeString(String str) {

        char[] chars = str.toCharArray();
        int end=chars.length-1;
        int start=0;

        while (start<end) {

            if (chars[start] != chars[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;

    }

    // 456
    private static boolean isPalindrome(int n) {
        int temp = n;

        int rev =0 ;

        while (n>0) {

            int remainder = (n % 10);

            rev = (rev * 10) + remainder;

            n = n/10;
        }

        if( rev == temp) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("Is palindrome=="+isPalindrome(12321));

        System.out.println("Is palindrome=="+isPalindromeString("1312"));
    }
}
