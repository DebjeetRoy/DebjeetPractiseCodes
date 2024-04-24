package com.dev.Graph;

import java.util.ArrayList;

public class CycleDetectionDirected extends AdjacecyListGraphCreation {

	public static void createGraphNc(ArrayList<Edge>[] graph) {
		// 0 vertex
		graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 2, 1));

		// 1 vertex
		graph[1].add(new Edge(1, 3, 1));

		// 2 vertex
		graph[2].add(new Edge(2, 1, 1));
	}
	
	public static void createGraphC(ArrayList<Edge>[] graph) {
		// 0 vertex
		graph[0].add(new Edge(0, 2, 1));

		// 1 vertex
		graph[1].add(new Edge(1, 0, 1));

		// 2 vertex
		graph[2].add(new Edge(2, 3, 1));
		
		// 2 vertex
		graph[3].add(new Edge(3, 0, 1));
	}

	public static boolean detectCycle(ArrayList<Edge>[] graph) {//O(V+E)
		boolean[] vis = new boolean[graph.length];
		boolean[] stack = new boolean[graph.length];
		
		for (int i = 0; i < graph.length; i++) {
			if (!vis[i]) {
				if (detectCycleUtil(graph, vis, i, stack)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, boolean[] stack	) {
		vis[curr] = true;
		stack[curr] = true;

		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);

			if(stack[e.destination]) {
				return true;
			} else if(!vis[e.destination] && detectCycleUtil(graph, vis, e.destination, stack)) {
				return true;
			}
		}
		stack[curr] = false;
		return false;
	}

	public static void main(String[] args) {
//		/*     
//		 * 		  0
//		 *   (D) / \(D)
//		 *      2   1
//		 *   (D) \ /(D)
//		 *        3
//		 * 	   
//		 *    No Cycle Graph  
//		 */
		int V = 4;
//		ArrayList<Edge>[] graphNc = new ArrayList[V];
//		for (int i = 0; i < V; i++) {
//			graphNc[i] = new ArrayList<>();
//		}
//		createGraphNc(graphNc);
//		System.out.println(detectCycle(graphNc));
		
		/*     
		 * 		  0<----1
		 *       ↙⬆
		 *     ↙  ⬆ 
		 *    2   ⬆
		 *     ↘  ⬆
		 *      ↘ ⬆
		 *       3
		 * 	    
		 *    Cyclic Graph  
		 */
		ArrayList<Edge>[] graphC = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			graphC[i] = new ArrayList<>();
		}
		createGraphC(graphC);

		System.out.println(detectCycle(graphC));
	}
}
