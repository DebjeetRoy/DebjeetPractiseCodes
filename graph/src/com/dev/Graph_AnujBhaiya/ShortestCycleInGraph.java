package com.dev.Graph_AnujBhaiya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestCycleInGraph {
	// Do with BFS
	public static int findShortestCycle(int n, int[][] edges) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int arr[] : edges) {
			adj.get(arr[0]).add(arr[1]);
			adj.get(arr[1]).add(arr[0]);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int[] dist = new int[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			int[] par = new int[n];
			Arrays.fill(par, -1);
			dist[i] = 0;
			Queue<Integer> pq = new LinkedList<Integer>();
			pq.add(i);

			while (!pq.isEmpty()) {
				int curr = pq.poll();
				for (int neighbour : adj.get(curr)) {
					if (dist[neighbour] == Integer.MAX_VALUE) {
						dist[neighbour] = dist[curr] + 1;
						par[neighbour] = curr;
						pq.add(neighbour);
					} else if (par[curr] != neighbour && par[neighbour] != curr) {
						ans = Math.min(ans, dist[curr] + dist[neighbour] + 1);
					}
				}
			}
		}
		return (ans == Integer.MAX_VALUE ? -1 : ans);
	}

	public static void main(String[] args) {
		int n = 7;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 3 } };

		System.out.println(findShortestCycle(n, edges));
	}
}
