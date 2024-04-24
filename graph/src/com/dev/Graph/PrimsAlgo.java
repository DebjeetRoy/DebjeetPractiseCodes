package com.dev.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo extends AdjacecyListGraphCreation {
	private static void createGraph(ArrayList<Edge>[] graph) {
		// Vertex 0
		graph[0].add(new Edge(0, 1, 10));
		graph[0].add(new Edge(0, 2, 15));
		graph[0].add(new Edge(0, 3, 30));

		// Vertex 1
		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 3, 40));

		// Vertex 2
		graph[2].add(new Edge(2, 0, 15));
		graph[2].add(new Edge(2, 3, 50));

		// Vertex 3
		graph[3].add(new Edge(3, 0, 30));
		graph[3].add(new Edge(3, 1, 40));
		graph[3].add(new Edge(3, 2, 50));
	}

	static class Pair implements Comparable<Pair> {
		int vertex;
		int cost;

		public Pair(int v, int c) {
			this.vertex = v;
			this.cost = c;
		}

		@Override
		public int compareTo(Pair o) {
			return this.cost - o.cost;
		}
	}

	public static void prims(ArrayList<Edge>[] graph) {
		boolean[] vis = new boolean[graph.length];
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		pq.add(new Pair(0, 0));
		int finalCost = 0; // MST cost or total min weight

		while (!pq.isEmpty()) {
			Pair curr = pq.remove();
			if (!vis[curr.vertex]) {
				vis[curr.vertex] = true;
				finalCost += curr.cost;

				for (int i = 0; i < graph[curr.vertex].size(); i++) {
					Edge e = graph[curr.vertex].get(i);
					pq.add(new Pair(e.destination, e.weight));
				}
			}
		}
		System.out.println("Final(min) cost of MST = " + finalCost);
	}

	public static void main(String[] args) {
		int V = 4;
		ArrayList<Edge>[] graph = new ArrayList[V];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		createGraph(graph);
		prims(graph);
	}
}
