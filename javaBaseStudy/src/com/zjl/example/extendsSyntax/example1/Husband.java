package com.zjl.example.extendsSyntax.example1;

public class Husband extends Person {
	private Wife wife;
	
	Husband() {
		System.out.println("Husband Constructor......");
	}
	
	Husband(String name) {
		super(name);
		System.out.println("Husband Constructor......Husband name=" + name);
	}

	public static void main(String[] args) {
		Husband husband = new Husband();
		Husband husband_2 = new Husband("zjl");
	}

}
