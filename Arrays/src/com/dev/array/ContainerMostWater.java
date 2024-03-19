package com.dev.array;

import java.util.ArrayList;
import java.util.List;

public class ContainerMostWater {
	public static void main(String[] args) {
		// height[] = {1,8,6,2,5,4,8,3,7};
		List<Integer> height = new ArrayList<>();
		height.add(1);
		height.add(8);
		height.add(6);
		height.add(2);
		height.add(5);
		height.add(4);
		height.add(8);
		height.add(3);
		height.add(7);

		int maxAreaContainerValue = containerWithMostWaterBF(height);

		System.out.println("Maximum Area Stored value -> " + maxAreaContainerValue);

		maxAreaContainerValue = pointerTechniqueMostWater(height);

		System.out.println("Maximum Area Stored value(Optimized) -> " + maxAreaContainerValue);
	}

	/*
	 * 2 Pointer Technique
	 */
	private static int pointerTechniqueMostWater(List<Integer> height) {
		int maxWater = Integer.MIN_VALUE;
		int lp = 0, rp = height.size() - 1;
		while (lp < rp) {
			int ht = Math.min(height.get(lp), height.get(rp));
			int width = rp - lp;
			int currWater = ht * width;
			maxWater = Math.max(maxWater, currWater);

			if (height.get(lp) < height.get(rp)) {
				lp++;
			} else {
				rp--;
			}
		}
		return maxWater;
	}

	/*
	 * Brute Force technique (Formulae :- width * min(h1,h2))
	 */
	private static int containerWithMostWaterBF(List<Integer> height) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < height.size(); i++) {
			for (int j = i + 1; j < height.size(); j++) {
				int width = j - i;
				int minHeight = Math.min(height.get(i), height.get(j));
				int areaOccupied = width * minHeight;

				max = Math.max(max, areaOccupied);
			}
		}
		return max;
	}
}
