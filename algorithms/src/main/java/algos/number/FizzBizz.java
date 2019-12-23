package algos.number;

public class FizzBizz {

    private static void fizzBizz(int x) {
        for (int i=1; i<= x; i++) {
            if (i%3 == 0 && i%5 == 0) {
                System.out.println("FizzBizz");
                continue;
            }

            if (i%3 == 0) {
                System.out.println("Fizz");
                continue;
            }

            if (i%5 == 0) {
                System.out.println("Buzz");
                continue;
            }

            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        fizzBizz(20);
    }
}
