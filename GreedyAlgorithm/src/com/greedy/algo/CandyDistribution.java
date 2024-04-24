package com.greedy.algo;

import java.util.Arrays;

/*
 * There are N children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:

Each child must have atleast one candy.
Children with a higher rating get more candies than neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.
 */

public class CandyDistribution {
	public static int candyDistribution(int[] a) {
		int n = a.length;
		int[] candy = new int[n];
		Arrays.fill(candy, 1);

		// Left to Right pass
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			}
		}

		// Right to Left pass
		for (int i = n - 2; i >= 0; i--) {
			if (a[i] > a[i + 1] && candy[i] <= candy[i + 1]) {
				candy[i] = candy[i + 1] + 1;
			}
		}
		int sum = 0;
		for (int e : candy) {
			sum += e;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] a = { 3, 1, 4, 2, 1, 3 };
		System.out.println(candyDistribution(a));
	}
}
