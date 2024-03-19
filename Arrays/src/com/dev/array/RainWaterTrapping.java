package com.dev.array;

public class RainWaterTrapping {
	public static int trapping(int[] height) { // TC = O(n)
		final int ht = height.length;

		// calculate maximum of left boundary
		final int[] leftMax = new int[ht];
		leftMax[0] = height[0];
		for (int i = 1; i < ht; i++) {
			leftMax[i] = Math.max(height[i], leftMax[i - 1]);
		}

		// calculate maximum of right boundary
		final int[] rightMax = new int[ht];
		rightMax[ht - 1] = height[ht - 1];
		for (int i = ht - 2; i >= 0; i--) {
			rightMax[i] = Math.max(height[i], rightMax[i + 1]);
		}

		int trappedWater = 0;
		for (int i = 0; i < ht; i++) {
			// calculate water level = minimum of above two maximums
			final int waterLevel = Math.min(leftMax[i], rightMax[i]);

			// trapped water += (water level - height of bar)*width of a bar
			trappedWater += waterLevel - height[i];
		}
		return trappedWater;
	}

	public static void main(String[] args) {
		final int[] height = { 4, 2, 0, 6, 3, 2, 5 };
		System.out.println("Amount of units of water covered by buildings is : " + trapping(height));
	}
}
