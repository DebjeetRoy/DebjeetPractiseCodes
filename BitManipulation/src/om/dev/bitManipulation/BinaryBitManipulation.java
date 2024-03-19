package om.dev.bitManipulation;

public class BinaryBitManipulation {

	public static void main(String[] args) {
		int a = -1;
		int b = 2; // (Shift 'b' times)

		System.out.println("AND operation of " + a + " and " + b + " = " + (a & b));
		System.out.println("OR operation of " + a + " and " + b + " = " + (a | b));
		System.out.println("XOR operation of " + a + " and " + b + " = " + (a ^ b));

		System.out.println("Left shift of " + a + " by " + b + " = " + (a << b));
		System.out.println("Right shift of " + a + " by " + b + " = " + (a >> b));

		System.out.println("1's commpliment : " + (~a));
	}
}
