package om.dev.bitManipulation;

import java.util.Arrays;

public class SieveOfErastothenes {

	public static boolean[] sieveOfErastothenes(int n) {
		boolean isPrime[] = new boolean[n + 1];

		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i <= n; i++) {
			for (int j = 2 * i; j <= n; j += i)
				isPrime[j] = false;
		}
		return isPrime;
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

//	public static int[] primeQueries(int[][] q) {
//
//	}

	public static void main(String[] args) {
		int n = 100;

		boolean isPrime[] = sieveOfErastothenes(n);
		for (int i = 0; i <= n; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}
}
