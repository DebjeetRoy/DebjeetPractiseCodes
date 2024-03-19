package com.dev.java.ObserverDesignPattern;

public class Youtube {

	public static void main(String[] args) {
		Channel channel = new Channel();

		Subscriber sub1 = new Subscriber("Rajesh");
		Subscriber sub2 = new Subscriber("Suresh");
		Subscriber sub3 = new Subscriber("Gyana");
		Subscriber sub4 = new Subscriber("Mahesh");
		Subscriber sub5 = new Subscriber("Arijeet");

		channel.subscribe(sub1);
		channel.subscribe(sub2);
		channel.subscribe(sub3);
		channel.subscribe(sub4);
		channel.subscribe(sub5);

		sub1.subscribeChannel(channel);
		sub2.subscribeChannel(channel);
		sub3.subscribeChannel(channel);
		sub4.subscribeChannel(channel);
		sub5.subscribeChannel(channel);

		channel.unSubscribe(sub2);

		channel.upload("Java new video !!");
		// channel.notifySubscriber();
	}

}
