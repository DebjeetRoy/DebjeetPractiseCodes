package com.dev.Graph;

import java.util.ArrayList;

public class BellmanFordAlgo extends AdjacecyListGraphCreation {
	private static void createGraph(ArrayList<Edge>[] graph) {
		// Vertex 0
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		// Vertex 1
		graph[1].add(new Edge(1, 2, -4));

		// Vertex 2
		graph[2].add(new Edge(2, 3, 2));

		// Vertex 3
		graph[3].add(new Edge(3, 4, 4));

		// Vertex 4
		graph[4].add(new Edge(4, 1, -1));
	}

	/*
	 * Bellman Ford Algo
	 */
	public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
		int[] dist = new int[graph.length];
		for (int i = 0; i < dist.length; i++) {
			if (i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		int V = graph.length;

		// O(V*E)
		// Algo = O(V), i loop is for number of iterations.
		for (int i = 0; i < V - 1; i++) {
			// Edges - O(E)
			// Getting all possible Vertices below at a source
			for (int j = 0; j < graph.length; j++) {
				// Getting all edges for a particular vertex j
				for (int k = 0; k < graph[j].size(); k++) {
					// Getting edges from current vertex;
					Edge e = graph[j].get(k);
					int u = e.source;
					int v = e.destination;
					int wt = e.weight;

					// Relaxation steps;
					if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
						dist[v] = dist[u] + wt;
					}
				}
			}
		}
		// print graph
		for (int i = 0; i < dist.length; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int V = 5;
		ArrayList<Edge>[] graph = new ArrayList[V];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		int src = 0;
		createGraph(graph);
		bellmanFord(graph, src);
	}
}
