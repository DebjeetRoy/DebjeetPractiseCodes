package com.dev.Graph_AnujBhaiya;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CreateGraph_BFS {
	static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
		if (graph.get(a).contains(b))
			return;

		// Bi-directional
		graph.get(a).add(b);
		graph.get(b).add(a);
	}

	static void addEdgeMatrix(int[] graphMat[], int a, int b) {
		graphMat[a][b] = 1;
		graphMat[b][a] = 1;
	}

	static void bfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis) {
		Queue<Integer> queue = new LinkedList<>();

		vis[src] = true;
		queue.add(src);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr + " ");

			// Visiting neighbours
			for (int neighbour : graph.get(curr)) {
				if (!vis[neighbour]) {
					queue.add(neighbour);
					vis[neighbour] = true;
				}
			}
		}
		System.out.println();
	}

	// Path from source to destination
	static void bfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis, int[] dist, int[] prec) {
		Queue<Integer> queue = new LinkedList<>();

		vis[src] = true;
		dist[src] = 0;
		prec[src] = -1;

		queue.add(src);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr + " ");

			// Visiting neighbours
			for (int neighbour : graph.get(curr)) {
				if (!vis[neighbour]) {
					queue.add(neighbour);
					vis[neighbour] = true;
					dist[neighbour] = dist[curr] + 1;
					prec[neighbour] = curr;
				}
			}
		}
		System.out.println();
	}

	static void findPath(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
		int V = 4;
		boolean[] vis = new boolean[V];
		int[] dist = new int[V];
		int[] prec = new int[V];
		bfs(graph, src, vis, dist, prec);
		while (dest != -1) {
			System.out.println(dest);
			dest = prec[dest];
		}
	}

	public static void main(String[] args) {
		// Adjacency List technique
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int V = 4;
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		// Adjacency Matrix(Not preferred)
		int graphMat[][] = new int[V][V];

		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 0, 3);
		addEdge(graph, 1, 2);

		boolean[] vis = new boolean[V];
		bfs(graph, 3, vis);

		// System.out.println("Shortest Path -");
		// findPath(graph, 3, 1);
	}
}
