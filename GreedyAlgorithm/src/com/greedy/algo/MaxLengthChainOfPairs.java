package com.greedy.algo;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainOfPairs {

	public static void main(String[] args) { // TC = O(nlogn)
		//First is start and 2nd is end of chain
		int[][] pairs = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};
		
		Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
		int chainLen = 1;
		int chainEnd = pairs[0][1]; //Last selected pair end or chain end
		
		for(int i=0; i< pairs.length; i++) {
			if(pairs[i][0] > chainEnd) {
				chainLen++;
				chainEnd = pairs[i][1];
			}
		}
		System.out.println("Max lenght of pairs of Chain is :- "+chainLen);
	}

}
