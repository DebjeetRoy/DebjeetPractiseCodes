package om.dev.modularArithematic;

public class MonotoneIncreasingDigits {

	public static int monotoneIncreasingDigits(int n) {
		// You can code here
		if (n <= 109) {
			return n - 1;
		}

		String str = n + "";
		int storedIndex = 0;

		for (int i = str.length() - 1; i >= 0; i--) {
			if (i > 0 && (str.charAt(i - 1) > str.charAt(i)) && (str.charAt(i - 1) != str.charAt(i))) {
				storedIndex = i - 1;
			} else if (i > 0 && i + 1 < str.length() && (str.charAt(i - 1) == str.charAt(i))
					&& ((str.charAt(i) > str.charAt(i + 1)))) {
				storedIndex = i - 1;
			}
		}

		if (storedIndex == 0)
			return n;

		char[] ch = str.toCharArray();
		String s = "";
		for (int i = 0; i < ch.length; i++) {
			if (i == storedIndex) {
				s = s + ((ch[i] - '0') - 1);
			} else if (i < storedIndex) {
				s = s + ch[i];
			} else {
				int num = 9 - (ch[i] - '0');
				s = s + ((ch[i] - '0') + num);
			}
		}
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		System.out.println(monotoneIncreasingDigits(117753939));
	}
}
