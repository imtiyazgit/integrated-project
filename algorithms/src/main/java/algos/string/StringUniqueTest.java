package algos.string;

/**
 * Created by imtiyaz on 6/11/16.
 */
public class StringUniqueTest {

    static boolean isStringContainsUniqueChars(String str) {
        boolean[] storage = new boolean[256];
        for (int i=0; i<str.length(); i++) {
            int c = str.charAt(i);
            if (storage[c]) {
                return false;
            }
            storage[c] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "helo89";
        System.out.println(isStringContainsUniqueChars(s));
    }
}
