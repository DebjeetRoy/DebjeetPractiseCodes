package com.dev.array;

public class KthRotationOfArray {
	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 21, 3 };
		int k = 3;

//		int[] arr1 = leftRotate(a, k);
//		int[][] ans = multipleLeftRotations(a, b);
//
//		for (int[] data : ans) {
//			for (int ele : data) {
//				System.out.print(ele + " ");
//			}
//			System.out.println();
//		}

		// leftRotate_Tc_On_SC_On(a, 3);
		leftRotate_Tc_On_SC_O1(a, 3);
	}

	private static void leftRotate_Tc_On_SC_O1(int[] arr, int d) {
		if (d == 0)
			return;
		int n = arr.length;

		// If rotating factor is > array length
		d = d % n;

		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n - 1);

		// Printing array
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void rightRotate_Tc_On_SC_O1(int[] arr, int d) {
		if (d == 0)
			return;
		int n = arr.length;

		// If rotating factor is > array length
		d = d % n;

		reverse(arr, 0, n - 1);
		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);

		// Printing array
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void reverse(int[] arr, int low, int high) {
		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;

			low++;
			high--;
		}
	}

	private static void leftRotate_Tc_On_SC_On(int[] arr, int d) {
		int temp[] = new int[d];
		int n = arr.length;

		for (int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}
		for (int i = d; i < n; i++) {
			arr[i - d] = arr[i];
		}
		for (int i = 0; i < d; i++) {
			arr[n - d + i] = temp[i];
		}

		// Printing array
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static int[] leftRotate(int[] arr, int k) {
		int n = arr.length;
		for (int i = 0; i < k; i++) {
			int temp = arr[0];
			for (int j = 0; j < n - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[n - 1] = temp;
		}
		return arr;
	}

	private static int[][] multipleLeftRotations(int[] a, int[] b) {
		int n = a.length;
		int m = b.length;

		int[][] ans = new int[m][n];
		int[] temp = new int[2 * n];

		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
			temp[i + n] = a[i];
		}

		for (int i = 0; i < m; i++) {
			int numberOfRotation = b[i] % n;
			for (int j = 0; j < n; j++) {
				ans[i][j] = temp[j + numberOfRotation];
			}
		}
		return ans;
	}
}
