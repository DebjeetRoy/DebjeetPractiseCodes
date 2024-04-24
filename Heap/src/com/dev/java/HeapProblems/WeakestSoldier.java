package com.dev.java.HeapProblems;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class WeakestSoldier {
	static class Row implements Comparable<Row> {
		int idx;
		int soldierCount;

		public Row(int idx, int soldierCount) {
			this.idx = idx;
			this.soldierCount = soldierCount;
		}
		
		/*
		 * If soldiers count is same then sort on basis of index
		 * and if count differs than sort on basis of number of soldiers.
		 */
		@Override
		public int compareTo(Row row) {
			return (this.soldierCount - row.soldierCount) == 0 ? (this.idx - row.idx)
					: (this.soldierCount - row.soldierCount);
		}
	}

	public static void main(String[] args) {
		int m = 4, n = 3, k = 2;
		PriorityQueue<Row> pq = new PriorityQueue<>();

		int[][] army = {{1,0,0,0},
				        {1,1,1,1},
		                {1,0,0,0},
		                {1,0,0,1}};
		
		int count = 0;
		for(int i=0; i<army.length; i++) {
			for(int j=0;j<army[0].length;j++) {
				count += army[i][j] == 1?1:0;
			}
			pq.add(new Row(i, count));
		}
		for(int i=0; i<k; i++) {
			System.out.print("R"+pq.remove().idx+" ");
		}
	}
}