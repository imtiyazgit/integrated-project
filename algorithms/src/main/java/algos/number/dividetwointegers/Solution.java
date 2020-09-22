package algos.number.dividetwointegers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static int HALF_INT_MIN = -1073741824;


    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
                //-2147483648 if this is the dividend, you cant do negatiion on this. Java simply ignores. Below code fails
            //-1
            return Integer.MAX_VALUE;
        }
        int negatives = 0;
        if (dividend < 0) {
            negatives++;
            dividend = -dividend;
        }

        if (divisor < 0) {
            negatives++;
            divisor = -divisor;
        }

        int quotient = 0;
        while (dividend - divisor >= 0) {
            quotient++;
            dividend -= divisor;
        }

        if (negatives == 1) {
            return -1 * quotient;
        }
        return quotient;
    }

    public static int divide2(int dividend, int divisor) {
        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives.
         * Also, we count the number of negatives signs. */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int quotient = 0;
        /* Once the divisor is bigger than the current dividend,
         * we can't fit any more copies of the divisor into it. */
        while (divisor >= dividend) {
            /* We know it'll fit at least once as divivend >= divisor.
             * Note: We use a negative powerOfTwo as it's possible we might have
             * the case divide(INT_MIN, -1). */
            int powerOfTwo = -1;
            int value = divisor;
            /* Check if double the current value is too big. If not, continue doubling.
             * If it is too big, stop doubling and continue with the next step */
            while (value >= HALF_INT_MIN && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            // We have been able to subtract divisor another powerOfTwo times.
            quotient += powerOfTwo;
            // Remove value so far so that we can continue the process with remainder.
            dividend -= value;
        }

        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }


    public static int divide3(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            //-2147483648 if this is the dividend, you cant do negatiion on this. Java simply ignores. Below code fails
            //-1
            return Integer.MAX_VALUE;
        }
        int negatives = 0;
        if (dividend < 0) {
            negatives++;
            dividend = -dividend;
        }

        if (divisor < 0) {
            negatives++;
            divisor = -divisor;
        }

        int quotient = 0;
        /* Once the divisor is bigger than the current dividend,
         * we can't fit any more copies of the divisor into it. */
        while (dividend >= divisor) {
            /* Now that we're in the loop, we know it'll fit at least once as
             * divivend >= divisor */
            int powerOfTwo = 1;
            int value = quotient;
            /* Check if double the current value is too big. If not, continue doubling.
             * If it is too big, stop doubling and continue with the next step */
            while (value + value < dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            // We have been able to subtract divisor another powerOfTwo times.
            quotient += powerOfTwo;
            // Remove value so far so that we can continue the process with remainder.
            dividend -= value;
        }

        if (negatives == 1) {
            return -1 * quotient;
        }
        return quotient;
    }

    public static int divide4(int dividend, int divisor) {
        List<Integer> doubles = new ArrayList<>();
        List<Integer> powersOfTwo = new ArrayList<>();

        int powerOfTwo = 1;

        /* Nothing too exciting here, we're just making a list of doubles of 1 and
         * the divisor. This is pretty much the same as Approach 2, except we're
         * actually storing the values this time. */
        while (divisor <= dividend) {
            powersOfTwo.add(powerOfTwo);
            doubles.add(divisor);
            powerOfTwo += powerOfTwo;
            divisor += divisor;
        }

        int quotient = 0;
        /* Go from largest double to smallest, checking if the current double fits.
         * into the remainder of the dividend */
        for (int i = doubles.size() - 1; i >= 0; i--) {
            if (doubles.get(i) <= dividend) {
                // If it does fit, add the current powerOfTwo to the quotient.
                quotient += powersOfTwo.get(i);
                // Update dividend to take into account the bit we've now removed.
                dividend -= doubles.get(i);
            }
        }

        return quotient;
    }

    public static int divideTest(int dividend, int divisor) {
        int negatives = 2;
        if(dividend > 0) {
            negatives--;
            dividend = -dividend;
        }

        if(divisor < 0) {
            negatives--;
            divisor = -divisor;
        }

        int quotient = 0;

        // your result is already negative one of negative number case

        while(divisor >= dividend) {
            int powerOfTwo = -1;
            int value = divisor;

            while(value + value >= dividend) {
                value +=value;
                powerOfTwo +=powerOfTwo;
            }

            quotient += powerOfTwo;
            dividend -= value;
        }


        if(negatives != 1) {
            quotient = -quotient;
        }

        return quotient;
    }

    public static void main(String[] args) {
        System.out.println(divide2(10, 3));
    }
}
