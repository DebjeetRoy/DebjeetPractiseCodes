package com.dev.java.BacktrackProblems;

/*
 * Time complexity of n queen problem = n!
 */
public class NqueensProblem {
	static int count = 0;

	public static void main(String[] args) {
		int n = 4;

		char[][] chessBoard = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chessBoard[i][j] = 'x';
			}
		}
		nQueens(chessBoard, 0);
		System.out.println("Total ways to solve " + n + " board length problem is:" + count);
//
//		if (nQueens(chessBoard, 0)) {
//			System.out.println("Solution is possible");
//			printBoard(chessBoard);
//		} else {
//			System.out.println("Solution is not possible");
//		}
	}

	/*
	 * n-queens business logic
	 */
	private static void nQueens(char[][] chessBoard, int row) {
		// base case
		if (row == chessBoard.length) {
			printBoard(chessBoard);
			count++;
			return;
		}

		// Checking from Column side
		for (int col = 0; col < chessBoard.length; col++) {
			if (isSafe(chessBoard, row, col)) {
				chessBoard[row][col] = 'Q';
				nQueens(chessBoard, row + 1); // functionc call
				chessBoard[row][col] = 'x'; // backtracking
			}
		}
	}

	/*
	 * n-queens possible solutions check logic
	 */
//	private static boolean nQueensSol(char[][] chessBoard, int row) {
//		// base case
//		if (row == chessBoard.length) {
//			return true;
//		}
//
//		// Checking from Column side
//		for (int col = 0; col < chessBoard.length; col++) {
//			if (isSafe(chessBoard, row, col)) {
//				chessBoard[row][col] = 'Q';
//				if (nQueensSol(chessBoard, row + 1)) {
//					return true;
//				}
//				chessBoard[row][col] = 'x'; // backtracking
//			}
//		}
//		return false;
//	}

	/*
	 * Printing Board positions
	 */
	public static void printBoard(char chessBoard[][]) {
		System.out.println("--------Chessboard----------");
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard.length; j++) {
				System.out.print(chessBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * Checking whether queen is safe at this position or not
	 */
	private static boolean isSafe(char[][] chessBoard, int row, int col) {
		// Vertical Up
		for (int i = row - 1; i >= 0; i--) {
			if (chessBoard[i][col] == 'Q') {
				return false;
			}
		}

		// Diagonal LeftUp
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chessBoard[i][j] == 'Q') {
				return false;
			}
		}

		// Diagonal RightUp
		for (int i = row - 1, j = col + 1; i >= 0 && j < chessBoard.length; i--, j++) {
			if (chessBoard[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}
}
