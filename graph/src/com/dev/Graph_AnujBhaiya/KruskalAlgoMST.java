package com.dev.Graph_AnujBhaiya;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgoMST {
	public static void main(String[] args) {
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		int V = 6;
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		addEdge(graph, 0, 1, 1);
		addEdge(graph, 0, 4, 1);
		addEdge(graph, 1, 2, 2);
		addEdge(graph, 4, 1, 2);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 3, 1, 3);
		addEdge(graph, 2, 3, 3);
		addEdge(graph, 5, 1, 5);
		addEdge(graph, 3, 5, 6);
		addEdge(graph, 5, 4, 6);
		addEdge(graph, 5, 0, 9);

		System.out.println(mstKruskals(graph));
	}

	/*
	 * TC : O(Elog E), SC : O(E+V)
	 */
	static int mstKruskals(ArrayList<ArrayList<Pair>> graph) {
		ArrayList<Edge> edges = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			ArrayList<Pair> adj = graph.get(i);
			for (Pair p : adj) {
				edges.add(new Edge(i, p.v, p.w));
			}
		}
		// sort edges according to the weight
		Collections.sort(edges);
		int V = graph.size();
		DisjointSet ds = new DisjointSet(V);
		int ans = 0;
		int count = 0;
		for (Edge curr : edges) {
			int src = curr.src;
			int dest = curr.dest;

			int findSrc = ds.find(src);
			int findDest = ds.find(dest);

			if (findSrc != findDest) {
				ans += curr.wt;
				count++;
				// If there are V vertices so we have to go till V-1 edges.
				if (count == V - 1)
					break;
				ds.union(src, dest);
			}
		}
		return ans;
	}

	static void addEdge(ArrayList<ArrayList<Pair>> graph, int src, int dest, int wt) {
		graph.get(src).add(new Pair(dest, wt));
		graph.get(dest).add(new Pair(src, wt));
	}
}

class Edge implements Comparable<Edge> {
	int src, dest, wt;

	public Edge(int src, int dest, int wt) {
		this.src = src;
		this.dest = dest;
		this.wt = wt;
	}

	@Override
	public int compareTo(Edge o) {
		return this.wt - o.wt;
	}
}

class Pair {
	int v, w;

	public Pair(int v, int w) {
		this.v = v;
		this.w = w;
	}
}
