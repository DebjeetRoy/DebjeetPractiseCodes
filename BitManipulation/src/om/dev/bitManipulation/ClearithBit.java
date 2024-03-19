package om.dev.bitManipulation;

public class ClearithBit {
	public static void main(String[] args) {
		long num = 10;
		int pos = 1;

		int n = 3;
		int i = 1, j = 2;

		System.out.println("Clearing in range of " + i + " and " + j + " = " + clearRangeOfBits(n, i, j));

		// System.out.println(pos + "th bit of " + num + " is cleared so new number is "
		// + ((num & (~(1 << pos)))));
	}

	// 0 based index
	// 0<= i < j < 31
	public static int clearRangeOfBits(int n, int i, int j) {
		int a = (~0 << (j + 1));
		int b = (1 << i) - 1;

		int mask = a | b;
		return n & mask;
	}
}
