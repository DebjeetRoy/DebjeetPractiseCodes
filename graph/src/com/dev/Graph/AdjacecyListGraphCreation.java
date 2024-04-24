package com.dev.Graph;

import java.util.ArrayList;

public class AdjacecyListGraphCreation {
	static class Edge {
		int source;
		int destination;
		int weight;

		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		/*     (5)
		 * 	0 ---- 1
		 *     (1)/ \(3)
		 *       /   \
		 * 	    2 --- 3
		 *      | (1)
		 *   (2)|
		 *      |
		 *      4
		 */
		int V = 5;
		ArrayList<Edge>[] graph = new ArrayList[V]; //null -> empty array list
		
		for(int i=0; i<V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		//0 vertex
		graph[0].add(new Edge(0,1,5));
		
		//1 vertex
		graph[1].add(new Edge(1,0,5));
		graph[1].add(new Edge(1,2,1));
		graph[1].add(new Edge(1,3,3));
		
		//2 vertex
		graph[2].add(new Edge(2,1,1));
		graph[2].add(new Edge(2,3,1));
		graph[2].add(new Edge(2,4,2));
		
		//3 vertex
		graph[3].add(new Edge(3,1,3));
		graph[3].add(new Edge(3,2,1));
		
		//4 vertex
		graph[4].add(new Edge(4,2,2));
		
		//print all neighbours of 2(all destinations are neighbours)
		System.out.println("All neighbours of 2 are -> ");
		for(int i=0; i<graph[2].size(); i++) {
			Edge e = graph[2].get(i);
			System.out.println(e.destination);
		}
	}
}
