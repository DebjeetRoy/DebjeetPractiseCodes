package com.dev.java.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Channel {
	private List<Subscriber> subs = new ArrayList<>();
	String title;

	public void subscribe(Subscriber sub) {
		subs.add(sub);
	}

	public void unSubscribe(Subscriber sub) {
		subs.remove(sub);
	}

	// We will notify to each subscriber regarding Update
	public void notifySubscriber() {
		for (Subscriber subscriber : subs) {
			subscriber.update();
		}
	}

	public void upload(String title) {
		this.title = title;
		notifySubscriber();
	}

}
