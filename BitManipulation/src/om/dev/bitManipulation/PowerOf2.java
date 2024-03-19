package om.dev.bitManipulation;

public class PowerOf2 {

	public static boolean isPowerOf2BruteForce(long n) {
		if (n == 0)
			return false;

		while (n != 1) {
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}
		return true;
	}

	public static boolean isPowerOf2(long n) {
		int count = 0;
		while (n > 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		if (count == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOf2BruteForce(15));
		System.out.println(isPowerOf2(15));
	}
}
