package com.dev.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateChunkOfArrays {
	public static void main(String[] args) {
		int chunkSize = 3;
		int[] original = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

//		List<int[]> al = chunkArray(original, chunkSize);
//		for (int[] ele : al) {
//			System.out.println(Arrays.toString(ele));
//		}

		List<int[]> res = chunkArrayOptimized(original, chunkSize);
		for (int[] ele : res) {
			System.out.println(Arrays.toString(ele));
		}
	}

	private static List<int[]> chunkArray(int[] arr, int chunkSize) {
		List<int[]> res = new ArrayList<>();
		for (int i = 0; i < arr.length; i += chunkSize) {
			int endIndex = Math.min(i + chunkSize, arr.length);
			int[] a = new int[endIndex - i];

			for (int j = i; j < endIndex; j++) {
				a[j - i] = arr[j];
			}
			res.add(a);
		}
		return res;
	}

	private static List<int[]> chunkArrayOptimized(int[] arr, int chunkSize) {
		List<int[]> res = new ArrayList<>();
		for (int i = 0; i < arr.length; i += chunkSize) {
			int endIndex = Math.min(i + chunkSize, arr.length);
			int[] a = Arrays.copyOfRange(arr, i, endIndex);

			res.add(a);
		}
		return res;
	}
}
