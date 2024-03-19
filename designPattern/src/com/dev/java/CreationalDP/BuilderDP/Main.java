package com.dev.java.CreationalDP.BuilderDP;

public class Main {

	// Ordering of Sequence doesn't matter
	// We can create immutable class
	// It solved issue of Factory DP where order sequence in constructor should be
	// known.
	public static void main(String[] args) {
		User user = new User.UserBuilder().setEmailId("deb@gmail.com")
		                      .setUserId("DEB100")
		                      .setUserName("Debjeet")
		                      .build();
		
		System.out.println(user);
		
		User user2 = User.UserBuilder.builder()
		.setEmailId("abc@gmail.com")
		.setUserId("ABC")
		.setUserName("ABC")
		.build();
		
		System.out.println(user2);
	}

}
