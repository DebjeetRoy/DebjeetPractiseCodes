package om.dev.bitManipulation;

public class findLocation {

	public static int findLocation(String s, String x) {
		// You can code here
		if (s.length() < x.length()) {
			return -1;
		}
		int subStringLength = x.length();
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			int j = i;
			int k = 0;
			while (k != x.length() - 1) {
				if (j + k < s.length() && s.charAt(j) == x.charAt(k)) {
					count++;
					j++;
					k++;
				} else {
					k++;
				}
			}
			if (count == subStringLength) {
				return s.length() - count;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String s = "codingshuttle";
		String x = "shuttle";

		System.out.println(findLocation(s, x));
	}
}
