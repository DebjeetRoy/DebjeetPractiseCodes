package com.java.SerDeserInheritance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7866138041514167856L;
	int i;

	public A(int i) {
		this.i = i;
	}
}

class B extends A {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5179303293185995547L;
	int j;

	public B(int i, int j) {
		super(i);
		this.j = j;
	}
}

public class SerializedSuperclass {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		B b1 = new B(10, 20);

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
		B b2 = (B) ois.readObject();

		// closing streams
		ois.close();
		fis.close();

		System.out.println("Object has been deserialized");

		System.out.println("i = " + b2.i);
		System.out.println("j = " + b2.j);
	}
}
