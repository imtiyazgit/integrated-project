package algos.string.sinusoidal;

/**
 * Problem: Hello World!
 *   e         _       l
 * H   l    o    W   r   d
 *       l         o        !
 *
 * Output: e_lHloWrdlo!
 */
public class SinuSoidalWaveEquation {

    // Time Complexity: O(n)
    private static String sinusoidal(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < s.length(); i = i + 4) {
            result.append(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i = i + 2) {
            result.append(s.charAt(i));
        }

        for (int i = 3; i < s.length(); i = i + 4) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(sinusoidal("Hello World!")); // e lHlowrdlo!
    }
}
