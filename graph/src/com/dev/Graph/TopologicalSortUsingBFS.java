package com.dev.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFS extends AdjacecyListGraphCreation{
	private static void createGraph(ArrayList<Edge>[] graph) {
		// Vertex 2
		graph[2].add(new Edge(2, 3, 1));

		// Vertex 3
		graph[3].add(new Edge(3, 1, 1));

		// Vertex 4
		graph[4].add(new Edge(4, 1, 1));
		graph[4].add(new Edge(4, 0, 1));

		// Vertex 4
		graph[5].add(new Edge(5, 0, 1));
		graph[5].add(new Edge(5, 2, 1));

	}
	
	//Calculate indegree at each vertices
	public static void calcIndegree(ArrayList<Edge> graph[], int inDegree[]) {
		for(int i=0; i<graph.length; i++) {
			int v=i; //Vertex is at ith position
			for(int j=0; j<graph[v].size(); j++) {
				Edge e = graph[v].get(j);
				inDegree[e.destination]++;
			}
		}
	}
	
	public static void topSort(ArrayList<Edge> graph[]) {
		int[] indeg = new int[graph.length];
		calcIndegree(graph, indeg);
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<indeg.length; i++) {
			if(indeg[i] == 0) {
				q.add(i);
			}
		}
		
		//BFS
		while(!q.isEmpty()) {
			int curr = q.remove();
			System.out.print(curr +" "); //toplology sort print
			
			for(int i=0; i<graph[curr].size(); i++) {
				Edge e = graph[curr].get(i);
				indeg[e.destination]--;
				if(indeg[e.destination] == 0) {
					q.add(e.destination);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int V = 6;
		/*
		 * 5 ---> 0 <-- 4
		 * |            |
		 * ↓            ↓ 
		 * 2 ---> 3 --> 1
		 */
		ArrayList<Edge>[] graph = new ArrayList[V];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		createGraph(graph);
		topSort(graph);
	}
}
