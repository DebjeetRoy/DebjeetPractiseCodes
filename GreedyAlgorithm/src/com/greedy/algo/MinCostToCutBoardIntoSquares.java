package com.greedy.algo;

import java.util.Arrays;
import java.util.Collections;

public class MinCostToCutBoardIntoSquares {
	public static int minCostToCutBoard(int[] hI, int[] vI, int M, int N) {
		int hor = 1, ver = 1;

		Integer[] h = Arrays.stream(hI).boxed().toArray(Integer[]::new);
		Integer[] v = Arrays.stream(vI).boxed().toArray(Integer[]::new);

		Arrays.sort(h, Collections.reverseOrder());
		Arrays.sort(v, Collections.reverseOrder());

		int cost = 0;
		int i = 0, j = 0; // i => vertical, j => horizontal

		while (i < N && j < M) {
			if (h[j] < v[i]) {
				cost += hor * v[i];
				ver++;
				i++;
			} else {
				cost += ver * h[j];
				hor++;
				j++;
			}
		}

		int totalVerticalCost = 0;
		while (i < N) {
			totalVerticalCost += v[i];
			i++;
		}
		cost += totalVerticalCost * hor;

		int totalHorizontalCost = 0;
		while (j < M) {
			totalHorizontalCost += h[j];
			j++;
		}
		cost += totalHorizontalCost * ver;
		// Integer i1 = Integer.valueOf(totalHorizontalCost);

		return cost;
	}

	public static void main(String[] args) {
//		int[] h = { 4, 1, 2 };
//		int[] v = { 2, 1, 3, 1, 4 };
		int[] h = { 1, 5, 4, 7, 5, 6, 6 };
		int[] v = { 3, 1, 2, 6, 7, 8, 1 };
		int M = h.length;
		int N = v.length;

		System.out.println(minCostToCutBoard(h, v, M, N));
	}
}
