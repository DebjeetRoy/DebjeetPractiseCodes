package com.greedy.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * TC = O(nlogn)
 */
public class Nactivity {
	public static void main(String[] args) {
		int[] start = {1, 3, 0, 5, 8, 5};
		int[] end   = {2, 4, 6, 7, 9, 9};
		
		//sorting
		int[][] activities = new int[start.length][3];
		for(int i=0; i<start.length; i++) {
			activities[i][0] = i;
			activities[i][1] = start[i];
			activities[i][2] = end[i];
		}
		
		//sort
		//'0' - index, '1' - start, '2' - end of 2D matrix
		Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
		
		//end time basis sorted
		int maxact = 0;
		List<Integer> ans = new ArrayList<Integer>();
		
		//1st activity
		maxact = 1;
		ans.add(0);
		int lastend = end[0];
		
		for(int i=0; i<end.length; i++) {
			if(start[i] > lastend) {
				maxact++;
				ans.add(activities[i][0]);
				lastend = activities[i][2];
			}
		}
		System.out.println("Number of Activities : "+maxact);
		
		for(int i=0; i<ans.size(); i++) {
			System.out.print("A"+ans.get(i)+" ");
		}
	}
}
