package com.javs.dev.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Time Complexity: O(n log k), where n is the size of the array and 
 * k is the number of elements to be returned. The priority queue 
 * takes O(log k) time to insert an element and O(log k) time to 
 * remove the top element. Therefore, traversing through the array and 
 * inserting elements into the priority queue takes O(n log k) time. 
 * Popping elements from the priority queue and pushing them into the 
 * result vector takes O(k log k) time. Therefore, the total time complexity 
 * is O(n log k + k log k) which is equivalent to O(n log k).
   
 * Auxiliary Space: O(k), as we are using a priority queue of size k+1 
 * and a vector of size k to store the result.
 */
public class FindClosestElement {
	// Create pair class which implements Comparable
	// interface
	static class Pair implements Comparable<Pair> {
		int absDiff;
		int ind;

		Pair(int f, int s) {
			absDiff = f;
			ind = s;
		}

		public int compareTo(Pair o) {
			// If there are two elements with the same
			// difference with X, the greater element is
			// given priority.
			if (absDiff == o.absDiff)
				return ind - o.ind;
			else
				return o.absDiff - absDiff;
		}
	}

	public static List<Integer> findClosestElements(int[] nums, int k, int x) {
		// You can code here
		int n = nums.length;
		List<Integer> res = new ArrayList<>();

		if (k == 1) {
			res.add(x);
			return res;
		}

		PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int diff = Math.abs(nums[i] - x);
			// if nums[i] == x then no need to consider that element
			// if (diff != 0)
			maxHeap.add(new Pair(diff, i));
			// if maxheap size exceeds k then remove the element with maximum absolute
			// difference
			if (maxHeap.size() > k)
				maxHeap.poll();
		}
		int ans[] = new int[k];
		int j = 0;
		while (!maxHeap.isEmpty()) {
			// Add the remaining elements to the answer
			ans[j] = nums[maxHeap.poll().ind];
			j++;
		}

		for (int ele : ans) {
			res.add(ele);
		}
		Collections.sort(res);
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { -1, -2, 3, 4, 5 };
		int k = 4;
		int x = -1;

		List<Integer> res = findClosestElements(arr, k, x);
		for (Integer ele : res) {
			System.out.print(ele + " ");
		}
	}
}
