package com.dev.TwoDarray;

import java.util.Scanner;

public class Add2Matrix {
	public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		int n = matrix.length;
		int m = matrix[0].length;
		Scanner in = new Scanner(System.in);

		System.out.println("1st Matrix ->");
		int[][] matrixA = printMatrixAData(matrix, n, m, in);

		System.out.println("2nd Matrix ->");
		int[][] matrixB = printMatrixBData(matrix, n, m, in);

		add2Matrix(matrixA, matrixB);
	}

	private static void add2Matrix(int[][] matrixA, int[][] matrixB) {
		int finalMatrix[][] = new int[3][3];
		System.out.println("Final matrix after addition => ");
		for (int i = 0; i < finalMatrix.length; i++) {
			for (int j = 0; j < finalMatrix[0].length; j++) {
				finalMatrix[i][j] = matrixA[i][j] - matrixB[i][j];
				System.out.print(finalMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] printMatrixAData(int[][] matrix, int n, int m, Scanner in) {
		System.out.println("Enter elements of 1st 3X3 array matrix : ");

		// Fetching inputs from user
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		// Printing
		System.out.println("Matrix A => ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}

	private static int[][] printMatrixBData(int[][] matrix, int n, int m, Scanner in) {
		System.out.println("Enter elements of 2nd 3X3 array matrix : ");

		// Fetching inputs from user
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		// Printing
		System.out.println("Matrix B => ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}
}
