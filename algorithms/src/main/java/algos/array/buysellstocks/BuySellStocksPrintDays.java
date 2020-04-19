package algos.array.buysellstocks;


import java.util.ArrayList;
import java.util.List;

class Stock {
    int buy;
    int sell;
}

public class BuySellStocksPrintDays {

    private static List<Stock> maxProfit(int[] prices) {
        int localMinima = Integer.MAX_VALUE;
        int localMaxima = Integer.MIN_VALUE;
        List<Stock> resultStockPrices = new ArrayList<>();
        Stock stock;

        int i=0;
       while(i < prices.length) {

            while(i < prices.length && prices[i] < localMinima) { // See the condition here. i < prices.length.. If you reverse this, prices[i] will throw array out of bounds of exception
                localMinima = prices[i++];
            }


            while(i < prices.length && prices[i] > localMaxima) {
                localMaxima = prices[i++];
            }

            stock = new Stock();
            stock.buy = localMinima;
            stock.sell = localMaxima;
            resultStockPrices.add(stock);
        }

        return resultStockPrices;
    }

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};

        List<Stock> resultStockPrices = maxProfit(prices);

        for (Stock stock: resultStockPrices) {
            System.out.println("Buy stock at "+ stock.buy +" and sell at "+ stock.sell);
        }

    }
}
