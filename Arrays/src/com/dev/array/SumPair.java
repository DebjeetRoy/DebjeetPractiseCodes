package com.dev.array;

import java.util.ArrayList;
import java.util.List;

public class SumPair {

	public static void main(String[] args) {
		List<Integer> values = new ArrayList<>();

		values.add(1);
		values.add(2);
		values.add(3);
		values.add(4);
		values.add(5);
		values.add(6);

		Boolean pairsExists = pairSum(values, 10);
		System.out.println("Pair possible :- " + pairsExists);

		pairsExists = pairSumTwoPointer(values, 4);
		System.out.println("Pair possible by two pointer approach :- " + pairsExists);

		List<Integer> rotatedValues = new ArrayList<>();

		rotatedValues.add(11);
		rotatedValues.add(15);
		rotatedValues.add(6);
		rotatedValues.add(8);
		rotatedValues.add(9);
		rotatedValues.add(10);

		pairsExists = sortedRotatedArraySum(rotatedValues, 19);
		System.out.println("Pair possible by Sorted Rotated Array Sum approach :- " + pairsExists);
	}

	/*
	 * Rotated Array
	 */
	private static Boolean sortedRotatedArraySum(List<Integer> rotatedValues, int target) {
		int size = rotatedValues.size();
		int lp = 0, rp = size - 1;
		int bp = -1;
		for (int i = 0; i < size; i++) {
			if ((i + 1) <= size - 1 && rotatedValues.get(i) > rotatedValues.get(i + 1)) {
				bp = i;
				break;
			}
		}
		rp = bp; // largest
		lp = bp + 1; // smallest

		while (lp != rp) {
			if (rotatedValues.get(lp) + rotatedValues.get(rp) == target) {
				return true;
			} else if (rotatedValues.get(lp) + rotatedValues.get(rp) < target) {
				lp = (lp + 1) % size;
			} else {
				rp = (size + rp - 1) % size;
			}
		}
		return false;
	}

	/*
	 * Two Pointer Approach
	 */
	private static Boolean pairSumTwoPointer(List<Integer> values, int target) {
		int lp = 0, rp = values.size() - 1;
		while (lp != rp) {
			if (values.get(lp) + values.get(rp) == target) {
				return true;
			} else if (values.get(lp) + values.get(rp) < target) {
				lp++;
			} else {
				rp--;
			}
		}
		return false;
	}

	/*
	 * Brute force technique
	 */
	private static Boolean pairSum(List<Integer> values, int sumTarget) {
		boolean pair = false;
		for (int i = 0; i < values.size(); i++) {
			for (int j = i + 1; j < values.size(); j++) {
				if (values.get(i) + values.get(j) == sumTarget) {
					pair = true;
				}
			}
		}

		return pair;
	}
}
