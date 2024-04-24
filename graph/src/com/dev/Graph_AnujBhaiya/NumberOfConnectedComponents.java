package com.dev.Graph_AnujBhaiya;

import java.util.ArrayList;

public class NumberOfConnectedComponents {
	static void addEdge(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
		if (graph.get(src).contains(dest)) {
			return;
		}
		// Bi-directional
		graph.get(src).add(dest);
		graph.get(dest).add(src);
	}

	/*
	 * TC : O(V+E) SC : O(V)
	 */
	static int noOfConnectedComponents(ArrayList<ArrayList<Integer>> graph, int V) {
		boolean[] vis = new boolean[V];
		int count = 0;

		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				count++;
				CreateGraph_DFS.dfs(graph, vis, i);
			}
		}
		System.out.println();
		return count;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int V = 6;

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
//		addEdge(graph, 5, 2);
//		addEdge(graph, 1, 5);
//		addEdge(graph, 7, 4);
//		addEdge(graph, 3, 6);
		addEdge(graph, 1, 2);
		addEdge(graph, 3, 4);

		System.out.println("Number of connected components :- " + noOfConnectedComponents(graph, V));
	}
}
