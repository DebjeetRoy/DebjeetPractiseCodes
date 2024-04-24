package com.java.dev.DisjointSets;

public class MainClass {
	public static void main(String[] args) {
		int n = 8;
		DisjointSetOperations ds = new DisjointSetOperations(n);

		ds.union(0, 3);
		ds.union(1, 3);
		ds.union(5, 4);
		ds.union(1, 3);
		ds.union(0, 1);

		System.out.println(ds.count);
	}
}
