package om.dev.modularArithematic;

public class AddSubMulDiv {
	static int m = (int) (1e9 + 7);

	// (a+b)%m = (a%m + b%m)%m
	public static int addm(int a, int b) {
		return (a % m + b % m) % m;
	}

	public static int multm(int a, int b) {
		return (int) (((long) a % m * (long) b % m) % m);
	}

	public static int subm(int a, int b) {
		return (a % m - b % m + m) % m;
	}

	public static int divdm(int a, int b) {
		// return (a % m * fastpower(b, m - 2) % m) % m;
		return multm(a, fastpower(b, m - 2));
	}

	public static int inverse(int a) {
		return fastpower(a, m - 2);
	}

	public static int fastpower(int a, int b) {
		int res = 1;
		while (b > 0) {
			if ((b & 1) != 0) {// b is odd
				res = multm(res, a);
			}
			a = multm(a, a);
			b = b >> 1;// b=b/2
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("Add : " + addm(5, 4));
		System.out.println("Sub : " + subm(5, 4));
		System.out.println("Mult : " + multm(5, 4));
		System.out.println("Div : " + divdm(5, 2));
		System.out.println("FastPower : " + fastpower(5, 4));
		System.out.println("Inverse : " + inverse(3));
	}
}
