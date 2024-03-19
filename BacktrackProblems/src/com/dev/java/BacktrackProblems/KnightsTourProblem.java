package com.dev.java.BacktrackProblems;

public class KnightsTourProblem {

	public static void main(String[] args) {
		int n = 4;
		int m = 5;
		int a[][] = knightsTour(n, m);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}

	static int[][] knightsTour(int n, int m) {
		int a[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = -1;
			}
		}
		a[0][0] = 0;
		int moveX[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int moveY[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		knightsTourHelper(n, m, a, moveX, moveY, 0, 0, 1);

		if (m > 1 && a[0][1] == -1) {
			a[0][0] = -1;
		}
		if (n > 1 && a[1][0] == -1) {
			a[0][0] = -1;
		}
		return a;
	}

	static boolean knightsTourHelper(int n, int m, int[][] arr, int[] moveX, int[] moveY, int currX, int currY,
			int step) {
		// Base case
		if (step == n * m) {
			return true;
		}

		// Algo
		for (int i = 0; i < 8; i++) {
			int nextX = currX + moveX[i];
			int nextY = currY + moveY[i];

			if (isValid(n, m, arr, nextX, nextY)) {
				arr[nextX][nextY] = step;

				boolean isTourDone = knightsTourHelper(n, m, arr, moveX, moveY, nextX, nextY, step + 1);

				if (isTourDone) {
					return true;
				} else {
					arr[nextX][nextY] = -1; // Backtrack
				}
			}
		}
		return false;
	}

	public static boolean isValid(int n, int m, int[][] arr, int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < m && arr[x][y] == -1;
	}
}
