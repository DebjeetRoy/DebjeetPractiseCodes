package com.dev.java.String;

public class StringBufferImpl {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("Hi ");
		System.out.println("Hashcode of original StringBuffer " + sb.hashCode());

		String str = new String("Hello ");
		System.out.println("Hashcode of original String " + str.hashCode());

		sb = sb.append("StringBuffer");
		System.out.println(sb);
		System.out.println("Hashcode of appended StringBuffer " + sb.hashCode());

		str = str.concat("String");
		System.out.println(str);
		System.out.println("Hashcode of appended String " + str.hashCode());
	}
}
