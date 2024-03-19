package com.dev.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
	public static List<Integer> majorityElement(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			map.put(a[i], !map.containsKey(a[i]) ? 1 : map.get(a[i]) + 1);
		}

		for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
			if (mp.getValue() > a.length / 2) {
				count++;
			}
		}
		if (count > 0) {
			ArrayList<Integer> ans = new ArrayList<>();
			for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
				if (mp.getValue() > a.length / 2) {
					ans.add(mp.getKey());
				}
			}
			return ans;
		}
		return Collections.emptyList();
	}

	// Bayer's Moore algorithm
	public static int majorityElementOptimized(int[] arr) {
		// 3 3 4
		int res = 0, count = 0;
		for (int i : arr) {
			if (count == 0) {
				res = i;
			}
			count = (i == res) ? count + 1 : count - 1;
		}
		return res;
	}

	public static int mooreVotingAlgo(int[] a) {
		int majorityEle = a[0];
		int count = 0;
		int size = a.length;

		for (int i = 0; i < size; i++) {
			if (a[i] == majorityEle) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majorityEle = a[i];
				count = 1;
			}
		}

		// Checking whether the element is truly a majority element or not
		int frequency = 0;
		for (int e : a) {
			if (e == majorityEle) {
				frequency++;
			}
		}

		return frequency > size / 2 ? majorityEle : -1;
	}

	public static void main(String[] args) {
		int[] arr2 = { 3, 3, 4, 2, 4, 3, 2, 3, 3 };
		int[] arr = { 1, 2 };
		List<Integer> majorityEle = majorityElement(arr);
		System.out.println("Majority elements in the given array whose frequency is > (length_of_array/2) =>");

		if (majorityEle.size() > 0) {
			for (int ele : majorityEle) {
				System.out.println(ele);
			}
		} else {
			System.out.println("No Majority element present !!");
		}

		int[] arr1 = { 1, 2 };
		System.out.println("Bayer's Moore Algorithm => ");
		System.out.println("Majority Element : " + majorityElementOptimized(arr1));

		System.out.println("Moore's Voting Algorithm...");
		System.out.println("Majority Element : " + mooreVotingAlgo(arr2));
	}
}
