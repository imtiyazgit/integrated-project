package algos.bitoperations.countbits;

public class CountBits {
    public static short countBits(int x) {
        short numBits = 0;

        while (x != 0) {
            numBits += (x & 1); // x&1 returns 1 if its last digit is 1
            x >>= 1; // loose rightmost bit as we are done with it
        }

        return numBits;
    }
    public static void main(String[] args) {
        System.out.println(countBits(10));
    }
}
