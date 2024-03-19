package om.dev.bitManipulation;

public class SetSpecificBit {

	// Changed bit at position pos and resultant bit is OR of 1 and position value
	public static void main(String[] args) {
		long num = 9;
		int pos = 1;

		System.out.println(pos + "th bit of " + num + " is reset so new number is " + ((num | (1 << pos))));
	}
}
