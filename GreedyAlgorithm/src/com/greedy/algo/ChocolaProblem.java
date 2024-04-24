package com.greedy.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ChocolaProblem {

	public static void main(String[] args) {
		int row = 4, col = 6;
		Integer costVert[] = {2,1,3,1,4}; //m-1
		Integer costHor[]  = {4,1,2};
		
		Arrays.sort(costVert, Collections.reverseOrder());
		Arrays.sort(costHor, Collections.reverseOrder());
		
		int h=0, v=0; //horizontal and Vertical Pointers
		int hp=1, vp=1; //horizontal and Vertical Pieces
		int cost=0;
		
		while(h<costHor.length && v<costVert.length) {
			if(costVert[v] <= costHor[h]) { //horizontal cut
				cost += costHor[h]*vp;
				h++;
				hp++;
			} else { //vertical cut
				cost += costVert[v]*hp;
				v++;
				vp++;
			}
		}
		
		/*
		 * If there are any horizontal pieces remains
		 */
		while(h<costHor.length) {
			cost += costHor[h]*vp;
			h++;
			hp++;
		}
		
		/*
		 * If there are any vertical pieces remains
		 */
		while(v<costVert.length) {
			cost += costVert[v]*hp;
			v++;
			vp++;
		}
		
		System.out.println("Minimum cost of cuts required :- "+cost);
	}
}
