package com.zjl.java8.study.defaultMethod;

public class Test implements Bird {

	public static void main(String[] args) {
		Test t = new Test();
		t.test();
		t.fly();
	}

	private void test() {
		System.out.println("Hello...");
	}
}