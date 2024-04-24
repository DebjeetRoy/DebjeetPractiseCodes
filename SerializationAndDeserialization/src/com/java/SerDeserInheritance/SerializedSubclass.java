package com.java.SerDeserInheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class C {
	int i;

	public C(int i) {
		this.i = i;
	}

	// Default constructor JVM searches for during runtime
	// execute instance control flow
	public C() {
		i = 50;
		System.out.println("C's class constructor called");
	}
}

class D extends C implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8625219244807097376L;
	int j;

	public D(int i, int j) {
		super(i);
		this.j = j;
	}
}

public class SerializedSubclass {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		D b1 = new D(10, 20);

		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);

		/* Serializing B's(subclass) object */

		// Saving of object in a file
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// Method for serialization of B's class object
		oos.writeObject(b1);

		// closing streams
		oos.close();
		fos.close();

		System.out.println("Object has been serialized");

		/* De-Serializing B's(subclass) object */

		// Reading the object from a file
		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// Method for de-serialization of B's class object
		D b2 = (D) ois.readObject();

		// closing streams
		ois.close();
		fis.close();

		System.out.println("Object has been deserialized");

		System.out.println("i = " + b2.i);
		System.out.println("j = " + b2.j);
	}
}
