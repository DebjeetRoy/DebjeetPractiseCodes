package com.javs.dev.PriorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

public class CombinationSumNmax {

	/*
	 * We have to print N elements whose sum is maximum in 2 arrays combination
	 */
	static int[] combinationSum(int[] a, int[] b) {
		int n = a.length;
		int ans[] = new int[n];

		int i = 0; // for a
		int j = 0; // for b

		Integer[] a1 = Arrays.stream(a).boxed().toArray(Integer[]::new);
		Integer[] b1 = Arrays.stream(b).boxed().toArray(Integer[]::new);

		Arrays.sort(a1, Collections.reverseOrder());
		Arrays.sort(b1, Collections.reverseOrder());

		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o2.sum - o1.sum);
		HashSet<Data> set = new HashSet<>();

		Data firstData = new Data(a1[i] + b1[j], i, j);
		pq.add(firstData);
		set.add(firstData);

		for (int ind = 0; ind < n; ind++) {
			Data data = pq.poll();
			ans[ind] = data.sum;
			i = data.i;
			j = data.j;

			if (j + 1 < n) {
				Data d1 = new Data(a1[i] + b1[j + 1], i, j + 1);
				if (!set.contains(d1)) {
					pq.add(d1);
					set.add(d1);
				}
			}

			if (i + 1 < n) {
				Data d2 = new Data(a1[i + 1] + b1[j], i + 1, j);
				if (!set.contains(d2)) {
					pq.add(d2);
					set.add(d2);
				}
			}
		}
		return ans;
	}

	static class Data {
		int sum;
		int i, j;

		public Data(int sum, int i, int j) {
			this.sum = sum;
			this.i = i;
			this.j = j;
		}

		@Override
		public int hashCode() {
			return Objects.hash(i, j, sum);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Data other = (Data) obj;
			return i == other.i && j == other.j && sum == other.sum;
		}

		@Override
		public String toString() {
			return "Data [sum=" + sum + ", i=" + i + ", j=" + j + "]";
		}
	}

	public static void main(String[] args) {
		int[] a = { 9, 4, 3, 2 };
		int[] b = { 4, 0, -2, -4 };

		int[] ans = combinationSum(a, b);

		for (Integer e : ans) {
			System.out.print(e + " ");
		}
	}
}
