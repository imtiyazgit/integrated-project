package algos.number.palindrome;

public class CheckIfNumberIsPalindrome {

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
        int test = 12321;

        System.out.println("Is palindrome=="+isPalindrome(test));
    }
}
