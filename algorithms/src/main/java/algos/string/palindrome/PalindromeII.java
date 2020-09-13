package algos.string.palindrome;

public class PalindromeII {

    public static boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                return helper(s, i+1, j) || helper(s, i, j-1);
            }
            i++;
            j--;
        }

        return true;
    }

    public static boolean helper(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("raceca2r"));
    }
}
