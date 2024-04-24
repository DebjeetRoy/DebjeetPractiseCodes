package com.dev.hashSet;

import java.util.ArrayList;

public class SubarrayWithGivenSum {
	// Sliding WIndow
	public static ArrayList<Integer> subarraySum(int[] arr, int n, int target) {
		// You can code here
		int currentSum = arr[0], start = 0, i;
		ArrayList<Integer> al = new ArrayList<>();

		// Pick a starting point
		for (i = 1; i <= n; i++) {
			// If currentSum exceeds the sum,
			// then remove the starting elements
			while (currentSum > target && start < i - 1) {
				currentSum = currentSum - arr[start];
				start++;
			}

			// If currentSum becomes equal to sum,
			// then return true
			if (currentSum == target) {
				int p = i - 1;
				System.out.println("Sum found between indexes " + start + " and " + p);
				if (arr[start] == 0)
					al.add(start + 2);
				else
					al.add(start + 1);
				al.add(p + 1);
				return al;
			}

			// Add this element to curr_sum
			if (i < n)
				currentSum = currentSum + arr[i];
		}
		System.out.println("No subarray found");
		al.add(-1);
		return al;
	}

	public static void main(String[] args) {
		int[] arr = { 83, 29, 59, 65, 20, 17, 23, 76, 77, 21, 89, 10, 73, 98, 14, 97, 34, 61, 82, 48, 97 };
		int len = arr.length;
		int target = 98;

		ArrayList<Integer> res = subarraySum(arr, len, target);

		res.stream().forEach(System.out::println);
	}
}
