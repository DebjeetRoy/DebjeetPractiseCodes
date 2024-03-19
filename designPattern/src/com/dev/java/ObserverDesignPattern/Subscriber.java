package com.dev.java.ObserverDesignPattern;

public class Subscriber {
	private String name;
	private Channel channel;

	public Subscriber(String name) {
		this.name = name;
	}

	public void update() {
		System.out.println("Hey " + name + ", Channel 1 got new video -> " + channel.title);
	}

	public void subscribeChannel(Channel ch) {
		channel = ch;
	}
}
