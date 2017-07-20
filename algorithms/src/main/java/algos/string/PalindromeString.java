package algos.string;

// check if input String is Palindrome or not without using String builder reverse method
// solution - Iterate through half loop and compare first and last characters in each iteration
public class PalindromeString {
    public static void main(String[] args) {
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
}
