package com.dev.java17.Sealed;

sealed class A permits B, C {
	A() {
		System.out.println("Constructor of Sealed class A");
	}

	public void test() {
		System.out.println("test() of Sealed class A");
	}
}

sealed class B extends A permits D {
	B() {
		System.out.println("Constructor of Sealed class B");
	}

	public void test() {
		System.out.println("test() of Sealed class B");
	}
}

final class C extends A {
	C() {
		System.out.println("Constructor of final class C");
	}

	public void test() {
		System.out.println("test() of final class C");
	}
}

non-sealed class D extends B {
	D() {
		System.out.println("Constructor of Non-Sealed class D");
	}

	public void test() {
		System.out.println("test() of Non-Sealed class D");
	}
}

sealed interface X permits Y {
	public default void test() {
		System.out.println("test() of Sealed interface X");
	}
}

non-sealed interface Y extends X {
	public static void sealedTest() {
		System.out.println("test() of Non-Sealed interface Y");
	}
}

public class SealedClassImpl {
	public static void main(String[] args) {
		D d = new D();
		d.test();
		System.out.println(" ----------------------- ");
		C c = new C();
		c.test();
	}
}
