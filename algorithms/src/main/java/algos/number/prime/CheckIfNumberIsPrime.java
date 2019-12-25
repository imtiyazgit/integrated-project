package algos.number.prime;

/**
 * 'A prime number is a number which is divisible by only two numbers: 1 and itself.
 * So, if any number is divisible by any other number, it is not a prime number.
 * We only have to loop through 2 to half of num, because no number is divisible by more than its half.
 *
 */
public class CheckIfNumberIsPrime {

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n/2; i++) {
            if (n%i == 0) {
                //if its divisible by any number, then its not prime
                return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 17;
        System.out.println("Is number prime="+isPrime(n));

    }
}
