package com.dev.Graph;

import java.util.ArrayList;

public class CycleDetectionUndirected extends AdjacecyListGraphCreation {

	public static void createGraph(ArrayList<Edge>[] graph) {
		// 0 vertex
		graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 2, 1));
		graph[0].add(new Edge(0, 3, 1));

		// 1 vertex
		graph[1].add(new Edge(1, 0, 1));
		graph[1].add(new Edge(1, 2, 1));

		// 2 vertex
		graph[2].add(new Edge(2, 0, 1));
		graph[2].add(new Edge(2, 1, 1));

		// 3 vertex
		graph[3].add(new Edge(3, 0, 1));
		graph[3].add(new Edge(3, 4, 1));

		// 4 vertex
		graph[4].add(new Edge(4, 3, 1));
	}

	public static boolean detectCycle(ArrayList<Edge>[] graph) {//O(V+E)
		boolean[] vis = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (!vis[i]) {
				if (detectCycleUtil(graph, vis, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent) {
		vis[curr] = true;

		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);

			// Case-3 ->
			if (!vis[e.destination]) {
				if(detectCycleUtil(graph, vis, e.destination, curr)) {
				return true;
				}
			}

			// Case-1 ->
			else if (vis[e.destination] && e.destination != parent) {
				return true;
			}

			// Case-2 -> do nothing so continue

		}
		return false;
	}

	public static void main(String[] args) {
		/*     
		 * 		  0---3
		 *      / |   | 
		 *     1  |   | 
		 * 	    \ |   4
		 *        2   
		 *      
		 */
		int V = 5;
		ArrayList<Edge>[] graph = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		createGraph(graph);

		System.out.println(detectCycle(graph));
	}
}
