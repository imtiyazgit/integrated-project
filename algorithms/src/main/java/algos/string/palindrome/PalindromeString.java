package algos.string.palindrome;

// check if input String is Palindrome or not without using String builder reverse method
// solution - Iterate through half loop and compare first and last characters in each iteration
public class PalindromeString {
    public static void main2(String[] args) {
        String testStr = "A1B1A";

        boolean result = false;
        for (int i=0;i<testStr.length()/2;i++) {
            if (testStr.charAt(i) == testStr.charAt(testStr.length()-i-1)) {
                result = true;
            }
        }

        if (result) {
            System.out.println("Yes, Palindrome!");
        } else {
            System.out.println("No!");
        }
    }


    private static boolean isPalindrome(String str) {

        for (int i = 0, j = str.length()-1; i < str.length() && j >0 ; i++, j--) {
            if(str.charAt(i) !=  str.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A1B1A"));
        System.out.println(isPalindrome("A1B1Ar"));
    }
}
