package om.dev.bitManipulation;

public class OddEven {

	public static void main(String[] args) {
		long num = 451;

		String binString = decimalToBinary(num);
		System.out.println("Binary Representation for " + num + " = " + binString);

		String oddEven = checkOddEven(num, binString);

		if (oddEven.equals("Even")) {
			System.out.println(num + " is even");
		} else {
			System.out.println(num + " is odd");
		}
	}

	public static String decimalToBinary(long num) {
		long temp = num;
		StringBuffer sb1 = new StringBuffer();

		int rem = 0;
		while (temp != 0) {
			rem = (int) (temp % 2);
			temp = temp / 2;
			sb1.append(rem);
		}
		String binString = sb1.reverse().toString();
		return binString;
	}

	/*
	 * We have to do BITWISE AND with 1 to check for odd-even if result is having 1
	 * at LSB - odd or else even
	 */
	private static String checkOddEven(long originalNum, String binString) {
		int i = Integer.parseInt(binString);
		return (i & 1) == 0 ? "Even" : "Odd";
	}
}
