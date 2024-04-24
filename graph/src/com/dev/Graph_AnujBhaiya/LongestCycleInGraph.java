package com.dev.Graph_AnujBhaiya;

import java.util.Arrays;

public class LongestCycleInGraph {
	private static int res;

	private static void dfs(int u, int[] edges, boolean[] visited, boolean[] inRecursion, int[] count) {
		if (u != -1) {
			visited[u] = inRecursion[u] = true;
			int v = edges[u];
			if (v != -1 && !visited[v]) {
				count[v] = count[u] + 1;
				dfs(v, edges, visited, inRecursion, count);
			} else if (v != -1 && inRecursion[v]) { // cycle hai and inRecursion wala true hona chahiye
				res = Math.max(res, count[u] - count[v] + 1);
			}
			inRecursion[u] = false;
		}
	}

	// Use DFS
	public static int longestCycle(int[] edges) {
		// You can code here
		int n = edges.length;
		res = -1;
		boolean visited[] = new boolean[n];
		boolean inRecursion[] = new boolean[n];
		int count[] = new int[n];
		Arrays.fill(count, 1);

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, edges, visited, inRecursion, count);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int edges[] = { 3, 3, 4, 2, 3 };

		System.out.println(longestCycle(edges));
	}
}
