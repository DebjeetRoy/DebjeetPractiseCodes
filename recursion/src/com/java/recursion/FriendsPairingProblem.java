package com.java.recursion;

public class FriendsPairingProblem {
	public static void main(String[] args) {
		int n = 3;

		System.out.println(friendsPairing(n));
	}

	public static int friendsPairing(int n) {
		if (n == 1 || n == 2) {
			return n;
		}

		// single choice
		int way1 = friendsPairing(n - 1);

		// pairs
		int way2 = (n - 1) * friendsPairing(n - 2);

		return way1 + way2;
	}
}
