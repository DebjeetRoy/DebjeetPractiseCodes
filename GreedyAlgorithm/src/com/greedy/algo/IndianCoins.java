package com.greedy.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IndianCoins {
	public static void main(String[] args) { //TC = O(nlogn)
		
		Integer[] coins = {1,2,5,10,20,50,100,500,2000};
		double value = 9000;
		
		Arrays.sort(coins, Comparator.reverseOrder());
		
		List<Integer> coinsList = new ArrayList<>();
		int countCoins = 0;
		for(int i=0; i<coins.length; i++) {
			if(value >= coins[i]) {
				while(value >= coins[i]) {
					countCoins++;
					coinsList.add(coins[i]);
					value = value - coins[i];
				}
			}
			//if(countCoins !=0)
			//System.out.println("Denomination of "+coins[i]+" is required "+count+" times");
		}
		System.out.println("Total min coins "+countCoins);
		
		for(int i=0; i<coinsList.size(); i++) {
			System.out.print(coinsList.get(i)+" ");
		}
	}
}
