package com.dev.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort extends AdjacecyListGraphCreation {

	private static void createGraph(ArrayList<Edge>[] graph) {
		// Vertex 2
		graph[2].add(new Edge(2, 3, 1));

		// Vertex 3
		graph[3].add(new Edge(3, 1, 1));

		// Vertex 4
		graph[4].add(new Edge(4, 1, 1));
		graph[4].add(new Edge(4, 0, 1));

		// Vertex 4
		graph[5].add(new Edge(5, 0, 1));
		graph[5].add(new Edge(5, 2, 1));

	}

	/*
	 * Topological Sorting
	 */
	public static void topologySort(ArrayList<Edge>[] graph) {
		boolean vis[] = new boolean[graph.length];
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < graph.length; i++) {
			if (!vis[i]) {
				topSortUtil(graph, i, vis, s);// modified DFS
			}
		}
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}

	/*
	 * Modified DFS
	 */
	private static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
		vis[curr] = true;
		// Calling neighbours which are not true
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);

			if (!vis[e.destination]) {
				topSortUtil(graph, e.destination, vis, s);
			}
		}
		s.push(curr);
	}

	public static void main(String[] args) {
		int V = 6;
		/*
		 * 5 ---> 0 <-- 4
		 * |            |
		 * ↓            ↓ 
		 * 2 ---> 3 --> 1
		 */
		ArrayList<Edge>[] graph = new ArrayList[V];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		createGraph(graph);
		topologySort(graph);
	}
}
