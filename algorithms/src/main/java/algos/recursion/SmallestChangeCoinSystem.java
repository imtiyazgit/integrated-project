package algos.recursion;

/**
 * ProblemStatement: Given an input x, write a function to determine minimum number of coins required to make that exact amount of change.
 * Solution:
 * We can solve this using recursive.
 * For example 32, coins = {25, 10, 5, 1} => 32 - 25 >0 => repeat(32-25, coins) and return +1 from recursive frame
 *
 */
public class SmallestChangeCoinSystem {

    private static int change(int amount, int[] coins) {

        // Base Condition
        if (amount == 0) {
            return 0;
        }

        int minNoOfCoins = amount;

        for (int coin: coins) {

            // amount is bigger than the coin
            if(amount - coin > 0) {

                int tempMinNoOfCoins = change(amount-coin, coins);
                if (minNoOfCoins > tempMinNoOfCoins + 1) {
                    minNoOfCoins = tempMinNoOfCoins + 1;
                }
            }

        }
        return minNoOfCoins;
    }

    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        System.out.println(change(33, coins));

    }
}
