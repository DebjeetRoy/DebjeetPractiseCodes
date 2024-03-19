package com.dev.array;

public class BuyAndSellStocks {

	private static int buySellStocks(int[] prices) {
		int buyerPrice = Integer.MAX_VALUE;
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (buyerPrice < prices[i]) {
				profit = Math.max(profit, prices[i] - buyerPrice);
			} else {
				buyerPrice = prices[i];
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		final int prices[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println("Maximum profit for the given price ranges : " + buySellStocks(prices));
	}
}
