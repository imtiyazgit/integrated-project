package algos.bitoperations;

public class LeftShiftRightShift {
    public static void main(String[] args) {

        // When you right shift, you loose bits. So divide 2^number = 2^3
        System.out.println(8 >> 3); // 8 / 8 = 1

        // When you left shift, you gain the bits. So you multiply 2^number
        System.out.println(16<<2); //16*2^2 = 16*4=64


        int a = -10; // 00001010
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a>>2); //delete right 2 bits... 000010 .. answer 2

        int a2 = -1;
        System.out.println(a2>>>20);
    }
}
