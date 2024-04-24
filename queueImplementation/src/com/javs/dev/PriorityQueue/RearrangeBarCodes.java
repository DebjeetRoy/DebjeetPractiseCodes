package com.javs.dev.PriorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeBarCodes {
	public static int[] rearrangeBarcodes(int[] barcodes) {
		// You can code here
		int n = barcodes.length;
		int[] res = new int[n];
		Map<Integer, Integer> map = new HashMap<>();

		for (int b : barcodes) {
			map.put(b, map.getOrDefault(b, 0) + 1);
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
		maxHeap.addAll(map.keySet());

		int index = 0;
		while (maxHeap.size() > 0) {
			int a = maxHeap.poll();
			res[index++] = a;
			if (maxHeap.size() == 0)
				break;

			int b = maxHeap.poll();
			res[index++] = b;

			update(map, maxHeap, a);
			update(map, maxHeap, b);
		}
		return res;
	}

	public static void update(Map<Integer, Integer> map, PriorityQueue<Integer> maxHeap, int a) {
		if (map.get(a) == 1) {
			map.remove(a);
		} else {
			map.put(a, map.get(a) - 1);
			maxHeap.offer(a);
		}
	}

	public static int[] rearrangeBarcodesSimplified(int[] barcodes) {
		Arrays.sort(barcodes);
		int i = 0;
		int j = barcodes.length - 1;
		while (i < j) {
			int temp = barcodes[i];
			barcodes[i] = barcodes[j];
			barcodes[j] = temp;
			i += 2;
			j -= 2;
		}
		return barcodes;
	}

	public static void main(String[] args) {
		int[] barcodes = { 1, 1, 1, 2, 2, 2 };
		int[] res = rearrangeBarcodes(barcodes);
		int[] alternateSol = rearrangeBarcodesSimplified(barcodes);

		for (int ele : res) {
			System.out.print(ele + " ");
		}
		System.out.println();

		System.out.println("Alternate Solution :- ");

		for (int ele : alternateSol) {
			System.out.print(ele + " ");
		}
	}
}
