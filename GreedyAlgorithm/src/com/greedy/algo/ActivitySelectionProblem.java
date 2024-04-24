package com.greedy.algo;

import java.util.Arrays;

public class ActivitySelectionProblem {
	static class Activity {
		int start, finish;

		public Activity(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
	}

	// O(nlogn)
	public static int activitySelection(int[] s, int[] f) {
		int len = s.length;
		int count = 1;
		Activity[] activities = new Activity[len];

		// Creating activities
		for (int i = 0; i < len; i++) {
			activities[i] = new Activity(s[i], f[i]);
		}

		// Sorting based on finish
		Arrays.sort(activities, (o1, o2) -> o1.finish - o2.finish);
		int currFinish = activities[0].finish;

		for (int i = 1; i < len; i++) {
			if (activities[i].start >= currFinish) {
				count++;
				currFinish = activities[i].finish;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] start = { 5, 10, 20, 30, 42, 45 };
		int[] finish = { 15, 25, 35, 40, 50, 55 };

		System.out.println(activitySelection(start, finish));
	}
}
