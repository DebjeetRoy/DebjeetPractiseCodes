package om.dev.bitManipulation;

public class StringFromSubstring {

	// Brute Force Approach TC : O(n^2)
	public boolean repeatedSubstringPattern(String s) {
		int n = s.length();

		for (int len = 1; len <= n / 2; len++) {
			if (n % len == 0) {
				String sub = s.substring(0, len);
				StringBuilder repeated = new StringBuilder();
				for (int i = 0; i < n / len; i++) {
					repeated.append(sub);
				}
				if (repeated.toString().equals(s)) {
					return true;
				}
			}
		}

		return false;
	}

	// A utility function to fill lps[] or compute
	// prefix function used in KMP string matching
	// algorithm.
	static void computeLPSArray(String str, int M, int lps[]) {
		// length of the previous
		// longest prefix suffix
		int len = 0;
		lps[0] = 0; // lps[0] is always 0
		int i = 1;

		// the loop calculates lps[i]
		// for i = 1 to M-1
		while (i < M) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i++] = len;
			} else {
				if (len != 0) {
					// This is tricky. Consider the
					// example AAACAAAA and i = 7.
					len = lps[len - 1];

					// Also, note that we do
					// not increment i here
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}

	// Returns true if str is repetition of
	// one of its substrings else return false.
	static boolean isRepeat(String str) {
		// Find length of string and create
		// an array to store lps values used in KMP
		int n = str.length();
		int lps[] = new int[n];

		// Preprocess the pattern (calculate lps[] array)
		computeLPSArray(str, n, lps);

		// Find length of longest suffix
		// which is also prefix of str.
		int len = lps[n - 1];

		// If there exist a suffix which is also
		// prefix AND Length of the remaining substring
		// divides total length, then str[0..n-len-1]
		// is the substring that repeats n/(n-len)
		// times (Readers can print substring and
		// value of n/(n-len) for more clarity.
		return (len > 0 && n % (n - len) == 0) ? true : false;
	}

	public static void main(String[] args) {
		String str = "abcabc";
		System.out.println(isRepeat(str));
	}
}
