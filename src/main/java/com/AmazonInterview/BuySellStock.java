package com.AmazonInterview;

public class BuySellStock {
    static class Trade{
        int buyDay;
        int sellDay;
        int buyPrice;
        int sellPrice;
    }

    // Driver method
    public static void main(String[] args) {
        int[] prices =  {100, 180, 260, 310, 40, 535, 695};
        findMaximumProfit(prices, prices.length);
    }


    public static void findMaximumProfit(int[] prices, int n){
        Trade[] trades = new Trade[n];
        int count = 0;
        int i = 0 ;
        while(i < n-1){
            Trade trade = new Trade();
            if(n == 1)
                break;

            // Local minima
            while(i < n-1 && prices[i+1] <= prices[i])
                i++;

            if (i == n-1)
                break;

            trade.buyDay = i;
            trade.buyPrice = prices[i];
            i++;
            //Local maxima
            while(i < n-1 && prices[i] >= prices[i - 1])
                i++;

            trade.sellDay = i;
            trade.sellPrice = prices[i];

            trades[count] = trade;
            System.out.println("bought on " + trade.buyDay + " day at price " + trade.buyPrice );
            System.out.println("Sold on " + trade.sellDay + " day at price " + trade.sellPrice );
            count++;
        }
    }


}
