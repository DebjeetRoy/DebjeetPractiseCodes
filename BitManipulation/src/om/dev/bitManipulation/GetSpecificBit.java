package om.dev.bitManipulation;

public class GetSpecificBit {

	public static void main(String[] args) {
		long num = 15;
		int i = 3;

		// Left shift 1 by i and doing AND operation with number
		// and then checking whether AND with 1 is 0 or more than 0
		// if 0 -> ith bit is 0 or else it's 1
		System.out.println(i + "th bit of " + num + " is " + ((num & (1 << i)) != 0 ? 1 : 0));
	}
}
