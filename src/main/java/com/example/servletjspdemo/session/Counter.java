package com.example.servletjspdemo.session;

public class Counter {
	private int value;
	
	public Counter () {
		this.value = 0;
	}
	
	public int get() {
		return value;
	}
	
	public void set(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.value);
	}
}