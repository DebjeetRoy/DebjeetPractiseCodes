package com.dev.Graph_AnujBhaiya;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
	public static void main(String[] args) {
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		int V = 6;

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		KruskalAlgoMST.addEdge(graph, 0, 1, 1);
		KruskalAlgoMST.addEdge(graph, 0, 4, 1);
		KruskalAlgoMST.addEdge(graph, 1, 2, 2);
		KruskalAlgoMST.addEdge(graph, 4, 1, 2);
		KruskalAlgoMST.addEdge(graph, 3, 4, 2);
		KruskalAlgoMST.addEdge(graph, 3, 1, 3);
		KruskalAlgoMST.addEdge(graph, 2, 3, 3);
		KruskalAlgoMST.addEdge(graph, 5, 1, 5);
		KruskalAlgoMST.addEdge(graph, 3, 5, 6);
		KruskalAlgoMST.addEdge(graph, 5, 4, 6);
		KruskalAlgoMST.addEdge(graph, 5, 0, 9);

		System.out.println(mstPrims(graph, V));
	}

	static int mstPrims(ArrayList<ArrayList<Pair>> graph, int V) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(-1, 0, 0));
		boolean vis[] = new boolean[V];
		int ans = 0;
		// vis[0] = true;

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (vis[curr.dest]) {
				continue;
			}
			vis[curr.dest] = true;
			ans += curr.wt;
			ArrayList<Pair> currNeighbour = graph.get(curr.dest);

			for (Pair pair : currNeighbour) {
				if (!vis[pair.v]) {
					pq.add(new Edge(curr.dest, pair.v, pair.w));
				}
			}
		}
		return ans;
	}
}
