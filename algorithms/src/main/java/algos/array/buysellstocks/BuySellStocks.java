package algos.array.buysellstocks;

/**
 * Best time to buy and sell stocks:

 Problem Statement: Say you have an array for which the ith element is the price of stock on ith day.
 If you were to permit to complete at most one trasaction i.e. one sell and one buy, design algorithm to find max profit.
 Note you can not sell stock before you buy.

 */
public class BuySellStocks {

    private static int maxProfitTwoLoops(int[] prices) {

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i +1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, diff);
            }
        }
        return maxProfit;
    }

    private static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // First set min price if todays price is less. If todays price is less, you cant have profit.
            if(minPrice < prices[i]) {
                minPrice = prices[i];
            } else if(prices[i] - minPrice > maxProfit) {
                // if you are here, this means, todays price is definitely more than the min price. Also, diff is greater than maxprofit you calculated here. So update it
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};

        System.out.println(maxProfitTwoLoops(arr));
        System.out.println(maxProfit(arr));
    }
}
