package com.dev.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends AdjacecyListGraphCreation {
	
	public static void createGraph(ArrayList<Edge>[] graph) {
		// 0 vertex
		graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 2, 1));
		
		// 1 vertex
		graph[1].add(new Edge(1, 0, 1));
		graph[1].add(new Edge(1, 3, 1));
		
		//2 vertex
		graph[2].add(new Edge(2, 0, 1));
		graph[2].add(new Edge(2, 4, 1));
		
		//3 vertex
		graph[3].add(new Edge(3, 1, 1));
		graph[3].add(new Edge(3, 4, 1));
		graph[3].add(new Edge(3, 5, 1));
		
		// 4 vertex
		graph[4].add(new Edge(4, 2, 1));
		graph[4].add(new Edge(4, 3, 1));
		graph[4].add(new Edge(4, 5, 1));
		
		//5 vertex
		graph[5].add(new Edge(5, 3, 1));
		graph[5].add(new Edge(5, 4, 1));
		graph[5].add(new Edge(5, 6, 1));
		
		//6 vertex
		graph[6].add(new Edge(6, 5, 1));
	}
	
	/*
	 * Breadth First Search
	 */
	public static void bfs(ArrayList<Edge>[] graph) { //O(V+E)
		Queue<Integer> queue = new LinkedList<>();
		boolean vis[] = new boolean[graph.length];
		queue.add(0); //source 0 is added first
		
		while(!queue.isEmpty()) {
			int curr = queue.remove();
			
			if(!vis[curr]) {
				vis[curr]=true;
				System.out.print(curr+" ");
				for(int i=0; i< graph[curr].size(); i++) {
					queue.add(graph[curr].get(i).destination);
				}
			}
		}
	}
	
	/*
	 * Depth First Search
	 */
	public static void dfs(ArrayList<Edge>graph[], int curr, boolean[] vis) {
		//visit 
		// TC : O(V+E)
		System.out.print(curr+" ");
		vis[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.destination]) {
				dfs(graph, e.destination, vis);
			}
		}
	}
	
	public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
		if(src == dest) {
			return true;
		}
		vis[src] = true;
		for(int i=0; i<graph[src].size(); i++) {
			Edge e = graph[src].get(i);
			//e.dest = my neighbour
			if(!vis[e.destination] && hasPath(graph, e.destination, dest, vis)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		/*     
		 * 		  1---3
		 *       /    | \
		 *      0     |  5 -- 6
		 * 	     \    | /
		 *        2---4
		 *      
		 */
		int V = 7;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V]; //null -> empty array list
		
		for(int i=0; i<V; i++) {
			graph[i] = new ArrayList<>();
		}
		createGraph(graph); 
		
		System.out.println("BFS of this graph => ");
		bfs(graph);
		
		System.out.println();
		System.out.println("DFS of this graph is => ");
		dfs(graph, 0,new boolean[V]);
		
		System.out.println();
		int src = 0; int dest = 7;
		
		if(hasPath(graph, src,dest, new boolean[V])) {
			System.out.println("Path exists from "+src+" to "+dest);
		} else {
			System.out.println("Path doesn't exists from "+src+" to "+dest);
		}
	}
}
