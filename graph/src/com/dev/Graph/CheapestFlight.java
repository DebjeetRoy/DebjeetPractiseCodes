package com.dev.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlight extends AdjacecyListGraphCreation {

	// Graph Creation for cheapest flight with atmost k stops
	private static void createGraph(int[][] flights, ArrayList<Edge>[] graph) {

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < flights.length; i++) {
			int src = flights[i][0];
			int dest = flights[i][1];
			int cost = flights[i][2];

			Edge e = new Edge(src, dest, cost);
			graph[src].add(e);
		}
	}

	static class Info {
		int vertex;
		int cost;
		int stops;

		public Info(int vertex, int cost, int stops) {
			this.vertex = vertex;
			this.cost = cost;
			this.stops = stops;
		}
	}

	/*
	 * Cheapest flight using Queue as sorting is based on stops which happens
	 * automatically so Priority Queue is not required here.
	 */
	public static int cheapestFlight(int n, int[][] flights, int src, int dest, int k) {
		ArrayList<Edge>[] graph = new ArrayList[n];
		createGraph(flights, graph);

		int[] dist = new int[n];

		// Setting vertices as infinity apart from source node which is zero
		for (int i = 0; i < graph.length; i++) {
			if (i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(src, 0, 0));

		while (!q.isEmpty()) {
			Info curr = q.remove();
			if (curr.stops > k) {
				break;
			}

			for (int i = 0; i < graph[curr.vertex].size(); i++) {
				Edge e = graph[curr.vertex].get(i);
				int u = e.source;
				int v = e.destination;
				int wt = e.weight;

				// dist[u] should be replaced by curr.cost to handle corner case scenario.
				if (dist[u] != Integer.MAX_VALUE && curr.cost + e.weight < dist[v] && curr.stops <= k) {
					dist[v] = curr.cost + wt;
					q.add(new Info(v, dist[v], curr.stops + 1));
				}
			}
		}
		if (dist[dest] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return dist[dest];
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 1, 3, 600 }, { 2, 0, 100 }, { 2, 3, 200 } };
		int src = 0;
		int dest = 3;
		int k = 1;

		int dist = cheapestFlight(n, flights, src, dest, k);
		System.out.println("Cheapest flight from " + src + " to " + dest + " = " + dist);
	}
}
