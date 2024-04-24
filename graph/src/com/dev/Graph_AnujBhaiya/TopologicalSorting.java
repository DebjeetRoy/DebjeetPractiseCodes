package com.dev.Graph_AnujBhaiya;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {
	// Added Edge data
	static void addEdge(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
		if (graph.get(src).contains(dest)) {
			return;
		}
		// Uni-directional
		graph.get(src).add(dest);
	}

	// Depth First Search(Modified)
	static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int curr, ArrayDeque<Integer> ansStack) {
		vis[curr] = true;
		// System.out.print(curr + " ");
		for (int neighbour : graph.get(curr)) {
			if (!vis[neighbour]) {
				dfs(graph, vis, neighbour, ansStack);
			}
		}
		ansStack.push(curr);
	}

	// Works with only DAG(Directed Acyclic Graph)
	// There should be minimum one vertex with 0 indegree.
	static void topologicalOrdering(ArrayList<ArrayList<Integer>> graph, int V) {
		boolean[] visited = new boolean[V];
		ArrayDeque<Integer> ansStack = new ArrayDeque<>();

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(graph, visited, i, ansStack);
			}
		}
		while (!ansStack.isEmpty()) {
			System.out.print(ansStack.pop() + " ");
		}
	}

	// any edge from u->v will go such that u<v always is implemented using Kahn's
	// algo
	/*
	 * TC = O(V+E), SC = O(V)
	 */
	static void topologicalOrderingKahnAlgo(ArrayList<ArrayList<Integer>> graph, int V) {
		Queue<Integer> q = new LinkedList<>();
		int[] indegree = new int[V];

		// Calculating indegree of each vertices
		for (int i = 0; i < V; i++) {
			for (int e : graph.get(i)) {
				indegree[e]++;
			}
		}

		// Adding the vertices to queue whose indegree is 0
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");

			// Reducing indegree count once that vertex is removed from graph
			for (int neighbour : graph.get(curr)) {
				indegree[neighbour]--;
				// if neighbour has indegree = 0 then add it to queue
				if (indegree[neighbour] == 0) {
					q.add(neighbour);
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int V = 6;

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		addEdge(graph, 0, 2);
		addEdge(graph, 0, 3);
		addEdge(graph, 2, 3);
		addEdge(graph, 2, 1);
		addEdge(graph, 3, 1);
		addEdge(graph, 5, 1);
		addEdge(graph, 4, 1);
		addEdge(graph, 4, 5);

		// topologicalOrdering(graph, V);
		topologicalOrderingKahnAlgo(graph, V);
	}
}
