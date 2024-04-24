package com.dev.Graph_AnujBhaiya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DjkstrasAlgo {
	// TC = O(ElogE)
	// SC = O(E+V)
	static int[] minDistance(ArrayList<ArrayList<Pair>> graph, int src, int V) {
		int[] ans = new int[V];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[src] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(-1, src, 0));
		boolean[] vis = new boolean[V];

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int curr = edge.dest;
			if (vis[curr])
				continue;

			vis[curr] = true;
			ArrayList<Pair> curNeighbours = graph.get(curr);
			for (Pair neigbour : curNeighbours) {
				if (!vis[neigbour.v]) {
					if (ans[curr] != Integer.MAX_VALUE && ans[neigbour.v] > ans[curr] + neigbour.w) {
						ans[neigbour.v] = ans[curr] + neigbour.w;
						pq.add(new Edge(curr, neigbour.v, ans[neigbour.v]));
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		int V = 6;

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		KruskalAlgoMST.addEdge(graph, 0, 1, 1);
		KruskalAlgoMST.addEdge(graph, 0, 4, 1);
		KruskalAlgoMST.addEdge(graph, 1, 2, 2);
		KruskalAlgoMST.addEdge(graph, 4, 1, 2);
		KruskalAlgoMST.addEdge(graph, 3, 4, 2);
		KruskalAlgoMST.addEdge(graph, 3, 1, 3);
		KruskalAlgoMST.addEdge(graph, 2, 3, 3);
		KruskalAlgoMST.addEdge(graph, 5, 1, 5);
		KruskalAlgoMST.addEdge(graph, 3, 5, 6);
		KruskalAlgoMST.addEdge(graph, 5, 4, 6);
		KruskalAlgoMST.addEdge(graph, 5, 0, 9);

		int[] ans = minDistance(graph, 0, V);

		for (int i = 0; i < V; i++) {
			System.out.println("0 -> " + i + " = " + ans[i]);
		}
	}
}
