package com.dev.Graph;

import java.util.ArrayList;

public class AllPathFrpmSrctoDest extends AdjacecyListGraphCreation {
	private static void createGraph(ArrayList<Edge>[] graph) {
		// Vertex 0
		graph[0].add(new Edge(0, 3, 1));

		// Vertex 2
		graph[2].add(new Edge(2, 3, 1));

		// Vertex 3
		graph[3].add(new Edge(3, 1, 1));

		// Vertex 4
		graph[4].add(new Edge(4, 1, 1));
		graph[4].add(new Edge(4, 0, 1));

		// Vertex 5
		graph[5].add(new Edge(5, 0, 1));
		graph[5].add(new Edge(5, 2, 1));

	}

	//O(V^V) - exponential TC
	public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
		if (src == dest) {
			System.out.println(path + dest);
		}
		for (int i = 0; i < graph[src].size(); i++) {
			Edge e = graph[src].get(i);
			printAllPath(graph, e.destination, dest, path + src);
		}
	}

	public static void main(String[] args) {
		int V = 6;
		/*
		 * 5 ---> 0 <-- 4
		 * |      |     |
		 * ↓      ↓     ↓ 
		 * 2 ---> 3 --> 1
		 */
		ArrayList<Edge>[] graph = new ArrayList[V];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		int src = 5;
		int dest = 1;
		createGraph(graph);
		printAllPath(graph, src, dest, "");
	}
}
