package com.dev.Graph_AnujBhaiya;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class CreateGraph_DFS {
	static void addEdge(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
		if (graph.get(src).contains(dest)) {
			return;
		}
		// Bi-directional
		graph.get(src).add(dest);
		graph.get(dest).add(src);
	}

	// Depth First Search
	static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int curr) {
		vis[curr] = true;
		System.out.print(curr + " ");
		for (int neighbour : graph.get(curr)) {
			if (!vis[neighbour]) {
				dfs(graph, vis, neighbour);
			}
		}
	}

	/*
	 * DFS calculated using our own created stack(Iterative approach)
	 */
	static void dfsIterative(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int curr) {
		vis[curr] = true;

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(curr);

		while (!stack.isEmpty()) {
			int ele = stack.pop();
			System.out.print(ele + " ");

			for (int neighbour : graph.get(ele)) {
				if (!vis[neighbour]) {
					stack.push(neighbour);
					vis[neighbour] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int V = 8;

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 5, 2);
		addEdge(graph, 1, 5);
		addEdge(graph, 7, 5);
		addEdge(graph, 7, 4);
		addEdge(graph, 7, 6);
		addEdge(graph, 3, 6);

		boolean[] vis = new boolean[V];
		System.out.println("---------Recursive Approach------------");
		dfs(graph, vis, 0);

		System.out.println("---------Iterative Approach------------");
		// dfsIterative(graph, vis, 0);
	}
}
