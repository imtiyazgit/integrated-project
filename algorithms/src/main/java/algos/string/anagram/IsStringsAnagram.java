package algos.string.anagram;

public class IsStringsAnagram {

    private static boolean isAnagram(String s1, String s2) {

        if (s1 == null || s2 == null) {
            throw new NullPointerException("Input string can not be null");
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] letters = new int[256];

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for (char c : s1.toCharArray()) {
            letters[c]++; // letters[asciivalueofa i.e. 97] returns 0. So letters[97] = letters[97] + 1; i.e. letters[97] = 1
        }

        for (char c : s2.toCharArray()) {
            letters[c]--;
        }

        for (int letter: letters) {
            if (letter != 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aab", "aba"));
    }
}
