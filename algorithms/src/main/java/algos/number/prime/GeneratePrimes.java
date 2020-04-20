package algos.number.prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratePrimes {

    private static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();

        // Include 0 as well.. thats why n+1
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n+1, true));

        // 0 is not prime
        isPrime.set(0, false);
        // 1 is not prime
        isPrime.set(1, false);
        // We set all other elements as true

        // Condition must be <= as we need to include 17 itself. We accommmodated the array accordingly to include zero as well
        for (int p = 2; p <= n; p++) {

            // Check if the element is prime
            if(isPrime.get(p)) {
                // If this element is prime, add to result
                primes.add(p);

                // Now strike out remaining elements which are multiples of this prime. Multiples of prime
                for (int j = p * 2; j <= n; j += p) {
                    isPrime.set(j, false);
                }
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        int num = 17;

        List<Integer> primes = generatePrimes(num);

        System.out.println(primes.toString());

    }
}
