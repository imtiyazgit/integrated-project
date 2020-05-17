package algos.string.palindrome;

public class StringPalindromeIgnoreOtherCharsWhileComparisonCaseInsensitive {

    /**
     * Time complexity: We spend O(1) per character. So overall time complexity is O(n)
     */
    private static boolean isStringPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(i < j) {

            // Skip non alpha numeric character at i
            while(!Character.isLetterOrDigit(i) && i < j) {
                i++;
            }

            // Skip non alpha numeric character at j
            while(!Character.isLetterOrDigit(j) && i < j) {
                j--;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++; // You can move to above if loop as i++ and j-- to simplify further
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "A123Ba";
        System.out.println(isStringPalindrome(str)); // true
    }
}
