package algos.bitoperations.logicaland;

public class BitwiseAnd {

    public static void main(String[] args) {
        int n = 3;

        System.out.println(n&0); // If n is even, then last digit is 0.. So, its 0.. If n is odd, then last digit is 1 and you are doing &0 so it returns 0. In both cases it returns 0
        System.out.println(n&1); // If n even, then last digit is 0. So, its 0.. If n is odd, then last digit is 1 and you are doing &1 so it returns 1.

        if( (n&1) == 0) {
            System.out.println("Its even");
        } else {
            System.out.println("Its Odd");
        }


        System.out.println(1&1); // 0001 returns 1 as its right most bit is 1
        System.out.println(2&1); // 0010 returns 0 as its right most bit is 0
        System.out.println(3&1); // 0011 returns 1 as its right most bit is 1
        System.out.println(4&1); // 0100 returns 0 as its right most bit is 0
    }
}
