package com.va.core;

public class VAException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1052502090635923933L;

	public VAException() {
	}

	public VAException(String msg) {
		super(msg);
	}

	public VAException(String msg, Throwable t) {
		super(msg, t);
	}

	public VAException(Throwable t) {
		super(t);
	}
}
