package com.dev.array;

public class LeaderInArrayProblem {

	public static int[] leaderOptim(int[] a) {
		int n = a.length;
		int[] ans = new int[n];
		int currLeader = a[n - 1];
		ans[n - 1] = currLeader; // last element is always a leader

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] > currLeader) {
				currLeader = a[i];
				ans[i] = currLeader;
			}
		}
		return ans;
	}

	public static int[] leaderInArray(int[] a) {
		int[] ans = new int[a.length];
		int n = a.length;

		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = i + 1; j < n; j++) {
				if (a[j] >= a[i]) {
					flag = true;
					break;
				}
			}
			if (flag == false)
				ans[i] = a[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 10, 4, 0, 6, 3, 2 };
		// int[] ans = leaderInArray(arr);
		int[] ans = leaderOptim(arr);

		for (int ele : ans) {

			System.out.print(ele + " ");
		}
	}
}
