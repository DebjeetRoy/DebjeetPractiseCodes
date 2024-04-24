package com.dev.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph extends AdjacecyListGraphCreation {

	public static void createGraph(ArrayList<Edge>[] graph) {
		// 0 vertex
		graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 2, 1));

		// 1 vertex
		graph[1].add(new Edge(1, 3, 1));
		graph[1].add(new Edge(1, 0, 1));

		// 2 vertex
		graph[2].add(new Edge(2, 0, 1));
		graph[2].add(new Edge(2, 4, 1));

		// 3 vertex
		graph[3].add(new Edge(3, 1, 1));
		graph[3].add(new Edge(3, 4, 1));

		// 4 vertex
		graph[4].add(new Edge(4, 2, 1));
		graph[4].add(new Edge(4, 3, 1));
	}

	/*
	 * To check if the graph is Bipartite
	 */
	public static boolean isBipartite(ArrayList<Edge>[] graph) {
		int[] col = new int[graph.length];
		for (int i = 0; i < col.length; i++) {
			col[i] = -1; // no colour
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < graph.length; i++) {
			if (col[i] == -1) { //BFS
				q.add(i);	
				col[i] = 0; // RED
				while (!q.isEmpty()) {
					int curr = q.remove();
					for (int j = 0; j < graph[curr].size(); j++) {
						Edge e = graph[curr].get(j); //e.destination

						// Colour not there
						if (col[e.destination] == -1) {
							// assign opposite colour
							int nextCol = col[curr] == 0 ? 1 : 0;
							col[e.destination] = nextCol;
							q.add(e.destination);
						} else if (col[e.destination] == col[curr]) {
							return false; // Not Bipartite as same colour for adjacent nodes
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		/*     
		 * 	   0------2
		 *    /      / 
		 *   /      / 
		 * 	1      4
		 *   \    /
		 *    \  /   
		 *      3
		 */
		int V = 5;
		ArrayList<Edge>[] graph = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		createGraph(graph);

		boolean checkForBipartite = isBipartite(graph);

		if (checkForBipartite) {
			System.out.println("Graph is Bipartite");
		} else {
			System.out.println("Graph is Not a Bipartite");
		}
	}
}
