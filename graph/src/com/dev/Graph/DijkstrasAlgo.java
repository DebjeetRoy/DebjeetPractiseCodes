package com.dev.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo extends AdjacecyListGraphCreation {
	static class Pair implements Comparable<Pair> {
		int node;
		int path;

		public Pair(int node, int path) {
			super();
			this.node = node;
			this.path = path;
		}

		@Override
		public int compareTo(Pair pair) {
			return this.path - pair.path; // Path based sorting for my pairs
		}
	}

	private static void createGraph(ArrayList<Edge>[] graph) {
		// Vertex 0
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		// Vertex 1
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 7));

		// Vertex 2
		graph[2].add(new Edge(2, 4, 3));

		// Vertex 3
		graph[3].add(new Edge(3, 5, 1));

		// Vertex 4
		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));
	}

	/*
	 * Dijkstras Algo where TC: V+ElogV
	 */
	public static void dijkstras(ArrayList<Edge>[] graph, int src) {
		int dist[] = new int[graph.length]; // dist[i] - src -> i
		for (int i = 0; i < graph.length; i++) {
			if (i != src) {
				dist[i] = Integer.MAX_VALUE; // +infinity is set for all except source
			}
		}

		boolean[] vis = new boolean[graph.length];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, 0));

		// loop
		while (!pq.isEmpty()) {
			Pair curr = pq.remove();
			if (!vis[curr.node]) {
				vis[curr.node] = true;

				// neighbours
				for (int i = 0; i < graph[curr.node].size(); i++) {
					Edge e = graph[curr.node].get(i);
					int u = e.source;
					int v = e.destination;
					int wt = e.weight;

					if (dist[u] + wt < dist[v]) {
						dist[v] = dist[u] + wt;
						pq.add(new Pair(v, dist[v]));
					}
				}
			}
		}
		// Print All sources to vertices shortest distance
		for (int i = 0; i < dist.length; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int V = 6;
		ArrayList<Edge>[] graph = new ArrayList[V];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		int src = 0;
		createGraph(graph);

		dijkstras(graph, src);
	}
}
