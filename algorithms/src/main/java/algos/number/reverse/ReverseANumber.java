package algos.number.reverse;

public class ReverseANumber {

    // 1234
    private static int reverse(int n) {
        int result=0;

        while(n>0) {
            int remainder = n %10;

            result = (result * 10) + remainder;

            n = n/10;
        }

        return result;
    }


    public static void main(String[] args) {
        int test = 1234;

        System.out.println("Reverse==="+reverse(test));
    }
}
