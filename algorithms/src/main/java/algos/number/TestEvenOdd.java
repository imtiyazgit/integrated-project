package algos.number;

// How to identify a given positive decimal number as even/odd without using % or / operator ?
// solution - subtract the given number by 2 in while loop until the num >=2
// results in a number which should be either 0 or 1
// If 0 it is even number. If 1 it should be a odd number
public class TestEvenOdd {
    public static void main(String[] args) {
        int num = 7;

        while (num >=2) {
            num = num-2;
        }

        if (num ==1) {
            System.out.println("its odd number");
        } else if (num ==0) {
            System.out.println("its even number");
        }
    }
}
