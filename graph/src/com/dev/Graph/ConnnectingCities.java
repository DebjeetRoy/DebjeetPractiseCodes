package com.dev.Graph;

import java.util.PriorityQueue;

public class ConnnectingCities {
	static class Edge implements Comparable<Edge> {
		int dest;
		int cost;

		public Edge(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	/*
	 * Connect cities problem using Prim's algo as its a MST problem(Min Spanning
	 * Tree)
	 */
	private static int connectingCities(int[][] cities) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] vis = new boolean[cities.length];

		pq.add(new Edge(0, 0));
		int finalCost = 0;

		while (!pq.isEmpty()) {
			Edge curr = pq.remove();

			if (!vis[curr.dest]) {
				vis[curr.dest] = true;
				finalCost += curr.cost;

				// Going through all neighbours
				for (int i = 0; i < cities[curr.dest].length; i++) {
					// Checking if edge exists
					if (cities[curr.dest][i] != 0) // it should not point to source again
						pq.add(new Edge(i, cities[curr.dest][i]));
				}
			}
		}

		return finalCost;
	}

	public static void main(String[] args) {
		int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 },
				{ 4, 7, 0, 0, 0 } };

		int minConnect = connectingCities(cities);

		System.out.println("Min no of connecting cities = " + minConnect);
	}
}
