package om.dev.bitManipulation;

public class FastExponentiation {
	// TC : O(log n)
	public static int fastExponent(int a, int n) {
		int ans = 1;
		while (n > 0) {
			if ((n & 1) != 0) {// Check LSB
				ans *= a;
			}
			a *= a;
			n >>= 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		int base = 3;
		int exponent = 10;

		System.out.println(fastExponent(base, exponent));
	}
}
