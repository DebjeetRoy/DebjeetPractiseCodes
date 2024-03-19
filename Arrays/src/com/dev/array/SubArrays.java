package com.dev.array;

public class SubArrays {
	public static void main(String[] args) {
		int[] values = { -1, 2, 3, -4, 6, 9 };
		int countPairs = printSubArraysAndPairCount(values);

		System.out.println("Total no of pairs of subarrays is : " + countPairs);

		int maxSum = maxSumSubArray(values);
		System.out.println("Maximum subarray sum is : " + maxSum);

		System.out.println("-----------Prefix Sum Approach to reduce the time complexity----------");

		int prefixSumMax = prefixSum(values);
		System.out.println();
		System.out.println("Maximum subarray sum using Prefix Sum Approach is : " + prefixSumMax);

		System.out.println();
		maxSum = kadanes(values);
		System.out.println("Maximum sum of subarray using Kadane's algo : " + maxSum);
	}

	/*
	 * Prefix Sum approach
	 */
	private static int prefixSum(int[] values) { // TC = O(n^2)
		int max = Integer.MIN_VALUE;
		int currSum = 0;
		int[] prefix = new int[values.length];
		prefix[0] = values[0];

		// Calculate prefix array
		for (int i = 1; i < values.length; i++) {
			prefix[i] = prefix[i - 1] + values[i];
		}
		for (int i = 0; i < values.length; i++) {
			int start = i;
			for (int j = i; j < values.length; j++) {
				int end = j;
				currSum = 0;
				currSum = (start == 0) ? prefix[start] : (prefix[end] - prefix[start - 1]);
				if (currSum > max) {
					max = currSum;
				}
			}
		}
		return max;
	}

	/*
	 * Kadane's Algo
	 */
	private static int kadanes(int[] value) { // TC = O(n)
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;

		for (int i = 0; i < value.length; i++) {
			currSum += value[i];
			if (currSum < 0) {
				currSum = 0;
			}
			if (currSum > maxSum) {
				maxSum = currSum;
			}
		}
		return maxSum;
	}

	/*
	 * Finding maximum sum of a subaaray among all subarrays.
	 */
	private static int maxSumSubArray(int[] values) { // TC = O(n^3)
		int currSum = 0;
		int max = Integer.MIN_VALUE;

		System.out.println("All Subarray Sum : ");
		for (int i = 0; i < values.length; i++) {
			for (int j = i; j < values.length; j++) {
				currSum = 0;
				for (int start = i; start <= j; start++) {
					currSum += values[start];
				}
				System.out.println(currSum);
				if (currSum > max) {
					max = currSum;
				}
			}
			System.out.println();
		}
		return max;
	}

	/*
	 * Method to print all possible subarrays in a given array and total no. of
	 * pairs
	 */
	private static int printSubArraysAndPairCount(int[] values) {
		int countPairs = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = i; j < values.length; j++) {
				System.out.print("(");
				for (int k = i; k <= j; k++) {
					System.out.print(values[k]);
					if (k < j) {
						System.out.print(" ");
					}
				}
				countPairs++;
				System.out.print(")");
			}
			System.out.println();
		}
		return countPairs;
	}
}
