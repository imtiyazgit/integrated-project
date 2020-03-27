package algos.number.reverse;

public class ReverseANumber {

    // time complexity - O(n) where n is the number of digits
    private static int reverse(int n) {
        int result=0;

        while (n != 0) {
            // If n is negative, n%10 is the negative of least signficant digit. For eample, -256%10 == -6
            int remainder = n %10;

            result = (result * 10) + remainder;

            n = n/10;
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println("Reverse==="+reverse(1234));

        System.out.println("Reverse==="+reverse(-341));
    }
}
