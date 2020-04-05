package algos.bitoperations.xor;

public class XorExamples {

    public static void main(String[] args) {
        // Xor means ^
        // One of the bit has to be 1 to make the result 1
        // If both are 1, then result is 0

        // 1010
        // 1000
        // 0010
        System.out.println(10 ^ 8);

        // determine if two integers are having opposite signs
        // typically used as +/- results in -.... -,- results in +, etc
        // For this scenario, xor is ideal
        int num1 = 21;
        int num2 = -3;
        boolean havingOppositeSigns = (num1 ^ num2) < 0;
        System.out.println(havingOppositeSigns);
    }
}
