package algos.string.hashing;

public class StringSubstringSearch {

    private static int PRIME = 101;

    // t = ImtiyazBaigMoghal
    // p = Baig
    // Return index 7
    private static int search(char[] t, char[] p) {
        String s = new String(t);
        int n = t.length;

        int m = p.length;
        long patternHash = hash(p, 0, p.length);
        System.out.format("%s hash is %d \n", new String(p), patternHash );

        // Get m characters by looping text.. So you iterate n-m times, since last m characters you dont need to iterate
        for (int i = 0; i <= n-m; i++) {
            long substringHash = hash(t, i, i+m);
            String tempSub = s.substring(i, i+m);
            System.out.format("substring %s hash is %d \n", s.substring(i, i+m), substringHash);

            if(patternHash == substringHash) {
                return i;
            }

        }

        return -1;
    }

    // a * prime^0 + b * prime^1 + etc
    private static long hash(char[] c, int start, int end) {
        long hash = 0;

        for (int i = start; i < end; i++) {
            hash+= c[i] * Math.pow(PRIME, i);
        }

        return hash;
    }

    public static void main(String[] args) {
        System.out.println(search("ImtiyazBaigMoghal".toCharArray(), "Baig".toCharArray()));
    }
}
