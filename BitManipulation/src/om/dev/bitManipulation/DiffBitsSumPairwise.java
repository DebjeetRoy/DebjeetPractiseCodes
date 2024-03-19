package om.dev.bitManipulation;

public class DiffBitsSumPairwise {

	public static int diffBitsSumPairOptimized(int[] a) {
		int n = a.length;
		int ans = 0;

		for (int i = 0; i < 32; i++) {
			int k = 0;
			for (int e : a) {
				if ((e & (1 << i)) != 0) {
					k++;
				}
			}
			ans += k * (n - k) * 2;
		}
		return ans;
	}

	public static int diffBitsSumPair(int[] a) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int res = a[i] ^ a[j];
				count += countSetBits(res);
			}
		}
		return count;
	}

	public static int countSetBits(int n) {
		// base case
		if (n == 0)
			return 0;

		else {
			// if last bit set add 1 else add 0
			return (n & 1) + countSetBits(n >> 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5 };
		System.out.println("Different Bit Sum Pairwise :" + diffBitsSumPair(arr));

		System.out.println(diffBitsSumPairOptimized(arr));
	}
}
