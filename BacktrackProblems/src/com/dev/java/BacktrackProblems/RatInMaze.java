package com.dev.java.BacktrackProblems;

import java.util.ArrayList;
import java.util.List;

//TC = O(3^(row*col)), SC = O(n^2) -> visited[] and stack
public class RatInMaze {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1, 0 }, { 1, 0, 0, 1 }, { 1, 1, 0, 0 }, { 1, 1, 1, 1 } };
		int row = matrix.length;
		int col = matrix[0].length;

		boolean[][] visited = new boolean[row][col];
		visited[0][0] = true;
		List<String> al = new ArrayList<>();

		System.out.println("Printing all the ways for Rat to reach their destination => ");
		al = ratInMaze(matrix, visited, "", row, col, 0, 0, al);

		for (String i : al) {
			System.out.println(i);
		}
	}

	/*
	 * Checking the validity of the path
	 */
	public static boolean isValid(int[][] mat, boolean[][] visited, int row, int col, int i, int j) {
		if (i < row && i >= 0 && j < col && j >= 0 && mat[i][j] == 1 && !visited[i][j] && mat[0][0] != 0) {
			return true;
		}
		return false;
	}

	/*
	 * Backtrack algo
	 */
	public static List<String> ratInMaze(int[][] mat, boolean[][] visited, String path, int row, int col, int i, int j,
			List<String> al) {

		// Base case condition is reached where rat has reached it's destination.
		if (i == row - 1 && j == col - 1) {
			al.add(path);
			return al;
		}

		// Down
		if (isValid(mat, visited, row, col, i + 1, j)) {
			visited[i + 1][j] = true;
			ratInMaze(mat, visited, path + 'D', row, col, i + 1, j, al);
			visited[i + 1][j] = false;
		}

		// Left D L R U
		if (isValid(mat, visited, row, col, i, j - 1)) {
			visited[i][j - 1] = true;
			ratInMaze(mat, visited, path + 'L', row, col, i, j - 1, al);
			visited[i][j - 1] = false;
		}

		// Right
		if (isValid(mat, visited, row, col, i, j + 1)) {
			visited[i][j + 1] = true;
			ratInMaze(mat, visited, path + 'R', row, col, i, j + 1, al);
			visited[i][j + 1] = false;
		}

		// Up
		if (isValid(mat, visited, row, col, i - 1, j)) {
			visited[i - 1][j] = true;
			ratInMaze(mat, visited, path + 'U', row, col, i - 1, j, al);
			visited[i - 1][j] = false;
		}
		return al;
	}
}
