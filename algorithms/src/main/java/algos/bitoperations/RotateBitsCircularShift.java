package algos.bitoperations;

public class RotateBitsCircularShift {

    private static final int circularLeftShift(int n, int k) {

        return n << k | n >> 32 -k;
    }

    private static final int circularRightShift(int n, int k) {
        return n >> k | n << 32 - k;
    }

    public static void main(String[] args) {
        int a = 1122334543;

        System.out.println("Input:             "+ toBinaryString(a));

        System.out.println("After Left  Shift: " +toBinaryString(circularLeftShift(a, 3))); // First 3 digits should be in last 3 digits in same order

        System.out.println("After Right Shift: " +toBinaryString(circularRightShift(a, 3)));  // Last 3 digits should be in first 3 digits in same order



    }

    private static String toBinaryString(int n) {
        return String.format("%32s",Integer.toBinaryString(n)).replaceAll(" ", "0");
    }
}

