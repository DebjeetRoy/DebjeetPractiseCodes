package com.dev.Graph_AnujBhaiya;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_1 {

	// Topological Sorting BFS
	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		// Form a Graph
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		int indegree[] = new int[numCourses];
		// Calculating indegree of each vertices
		for (int i = 0; i < numCourses; i++) {
			for (int ele : adj.get(i)) {
				indegree[ele]++;
			}
		}

		// Adding the vertices to queue whose indegree is 0
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		List<Integer> topo = new ArrayList<>();

		while (!q.isEmpty()) {
			int ele = q.peek();
			q.remove();
			topo.add(ele);

			for (int i : adj.get(ele)) {
				indegree[i]--;
				if (indegree[i] == 0) {
					q.add(i);
				}
			}
		}

		if (topo.size() == numCourses)
			return true;

		return false;
	}

	public static void main(String[] args) {
		int numCourses = 2;
		int prerequisites[][] = { { 1, 0 }, { 0, 1 } };

		System.out.println(canFinish(numCourses, prerequisites));
	}
}
