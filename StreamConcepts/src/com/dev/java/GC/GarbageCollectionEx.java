package com.dev.java.GC;

class Demo {
	int x = 50;

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Object is getting removed from heap");
	}
}

public class GarbageCollectionEx {
	public static void main(String[] args) {
		Demo ref = new Demo();
		ref.x = 50;
		System.out.println(ref.x);

		ref = null;
		System.gc();
		System.runFinalization();
	}
}
