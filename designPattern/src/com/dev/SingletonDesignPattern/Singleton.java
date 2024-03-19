package com.dev.SingletonDesignPattern;

import java.io.Serializable;

/*
 * Double check locking and synchronized block is used. but here instance will
 * be created in CPU cache as every CPU will have its own cache stored for
 * thread operations and in main memory instance is stored as null so to resolve
 * this issue, data member reference is set as volatile. All threads one by one
 * will check in main memory and there instance will be stored as null as its
 * stored in CPU cache only. So we have to make use of volatile data member to
 * create instance in main memory.
 * 
 * After volatile, all write done by Thread1 is done then only read operation is
 * performed so that another thread doesn't snatch instances of another thread.
 */
public class Singleton implements Serializable, Cloneable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Singleton() {
		if (ref != null) {
			throw new IllegalStateException("Object can't be created using Reflection");
		}
	}

	/*
	 * Use of volatile keyword creates an instance in main memory so that first
	 * write operation will perform by 1 thread then read operation will be
	 * performed by another. It guarantees visibilty of changes to one thread by
	 * another.
	 */
	private static volatile Singleton ref;

	public static Singleton getInstance() {
		if (ref == null) {
			synchronized (Singleton.class) {
				// Double check locking
				if (ref == null) {
					ref = new Singleton();
				}
			}
		}
		return ref;
	}

	// implement readResolve() for deserialization
	protected Object readResolve() {
		return ref;
	}

	// Avoid cloning
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// throw new CloneNotSupportedException();
		return ref;
	}
}
