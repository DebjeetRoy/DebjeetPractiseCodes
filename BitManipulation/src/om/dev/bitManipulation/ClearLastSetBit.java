package om.dev.bitManipulation;

public class ClearLastSetBit {

	public static int clearLastSetBit(int n) {
		return n & (n - 1);
	}

	public static void main(String[] args) {
		int n = 14;
		System.out.println(clearLastSetBit(n));
	}
}
