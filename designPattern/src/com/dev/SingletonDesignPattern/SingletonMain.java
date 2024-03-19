package com.dev.SingletonDesignPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class SingletonMain {
	public static void main(String[] args) throws Exception {

		Singleton instance1 = Singleton.getInstance();
		System.out.println("Original hashcode : " + instance1.hashCode());

		/*
		 * Checking Reflection breaking
		 */
		checkForReflection(instance1);

		/*
		 * Check Serialization and Deserialization
		 */
		checkForDeserialization(instance1);

		/*
		 * Check for cloning
		 */
		checkForCloning(instance1);
	}

	private static void checkForCloning(Singleton instance1) throws CloneNotSupportedException {
		System.out.println("New Hashcode : " + instance1.clone().hashCode());
	}

	private static void checkForDeserialization(Singleton instance1) throws IOException, ClassNotFoundException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("A:\\Serialization.txt"));
		objectOutputStream.writeObject(instance1);
		objectOutputStream.close();

		// Deserialization
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("A:\\Serialization.txt"));
		Singleton brokenSingleton = (Singleton) objectInputStream.readObject();
		objectInputStream.close();

		System.out.println("New Hashcode : " + brokenSingleton.hashCode());
	}

	private static void checkForReflection(Singleton instance1) throws Exception {
		Singleton reflectionInstance = null;

		Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		reflectionInstance = (Singleton) constructor.newInstance();
		System.out.println("New Hashcode : " + reflectionInstance.hashCode());
	}
}
