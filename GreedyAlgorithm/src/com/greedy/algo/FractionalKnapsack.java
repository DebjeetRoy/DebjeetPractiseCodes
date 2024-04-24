package com.greedy.algo;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

	public static void main(String[] args) {
		int val[] = {60, 100, 120};
		int weight[] = {10, 20, 30};
		int W = 50;
		
		// 0th column - ID and 1st column is ratio
		double ratio[][] = new double[val.length][2];
		
		for(int i=0; i< val.length; i++) {
			ratio[i][0] = i;
			ratio[i][1] = val[i]/(double)weight[i];
		}
		//sorted in ascending order
		Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
		
		int capacity = W;
		int finalVal = 0;
		
		// fetching data in Descending order
		for(int i = ratio.length-1; i>=0; i--) {
			int idx = (int) ratio[i][0];
			
			//include full item
			if(capacity >= weight[idx]) {
				finalVal += val[idx];
				capacity -= weight[idx];
			} else {
				//include fractional item
				finalVal += ratio[i][1] * capacity;
				capacity=0;
				break;
			}
		}
		System.out.println("Final Value :- "+finalVal);
	}
}
