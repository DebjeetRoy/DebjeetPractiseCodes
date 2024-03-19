package com.dev.java.BacktrackProblems;

public class GridWays {

	public static void main(String[] args) {
		int rows =3, col = 3;
		System.out.println("Number of Possible Ways to reach Target: " +gridways(0,0,rows, col));	
	}

	private static int gridways(int m, int n, int rows, int col) {
		//base case
		if(m == rows-1 && n == col-1) {
			return 1; // recursion call not needed
		} else if(m == rows || n == rows) {
			return 0; // Recursion not needed
		}
		
		int way1 = gridways(m, n+1, rows, col); //For Right movement
		int way2 = gridways(m+1, n, rows, col); //For Down movement
		return way1+way2;
	}
}
