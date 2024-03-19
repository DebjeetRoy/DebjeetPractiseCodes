package om.dev.bitManipulation;

public class DivideIntegers {
	public static int divideIntegers(int dividend, int divisor) {
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		int ans = 0;

		if (dividend > 0)
			divisor = divisor > 0 ? divisor : (-1) * divisor;
		if (dividend < 0 && divisor < 0) {
			dividend = (-1) * dividend;
			divisor = (-1) * divisor;
		}
		if (dividend < 0) {
			dividend = (-1) * dividend;
		}

		while (dividend > divisor) {
			int i = 0;
			int temp = divisor;
			while (dividend > (temp << 1)) {
				temp = temp << 1;
				i++;
			}
			ans += (1 << i);
			dividend = dividend - temp;
		}
		return ans * sign;
	}

	public static void main(String[] args) {
		int dividend = -501;
		int divisor = 78;

		System.out.println(divideIntegers(dividend, divisor));
	}
}
