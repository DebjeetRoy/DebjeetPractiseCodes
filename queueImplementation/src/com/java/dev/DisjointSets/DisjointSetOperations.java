package com.java.dev.DisjointSets;

public class DisjointSetOperations {
	int p[];
	int n;
	int r[];
	int count;

	public DisjointSetOperations(int n) {
		this.n = n;
		p = new int[n];
		r = new int[n];
		count = n;

		for (int i = 0; i < n; i++) {
			p[i] = i;
			r[i] = i;
		}
	}

	// TC = O(n) in worst case
	public int find(int a) {
		if (p[a] != a) {
			return find(p[a]);
		}
		return a;
	}

	// O(k)
	public int findWithPathCompression(int a) {
		if (p[a] != a) {
			int root = find(p[a]);
			p[a] = root; // path compression
			return root;
		}
		return a;
	}

	// O(k*N)
	public void union(int a, int b) {
		int ra = findWithPathCompression(a);
		int rb = findWithPathCompression(b);

		if (ra != rb) {
			count--;
			if (ra < rb)
				p[ra] = p[rb];
			else if (ra > rb)
				p[rb] = p[ra];
			else {
				p[ra] = rb;
				p[rb]++;
			}
		}
	}
}
