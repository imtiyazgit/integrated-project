package algos.string.hashing;

public class StringHash {
    private static int PRIME = 101;

    // abc
    // a * prime^0 + b*prime^1 + c*prime^2
    private static long createHash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i) * Math.pow(PRIME, i);
        }

        return hash;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(createHash("abc"));
        }

    }
}
