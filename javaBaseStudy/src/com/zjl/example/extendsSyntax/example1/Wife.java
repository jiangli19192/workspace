package com.zjl.example.extendsSyntax.example1;

public class Wife extends Person{
	private Husband husband;
	
	public Wife() {
		super("cxl");
		System.out.println("Wife Constructor......");
	}
	
	public static void main(String[] args) {
		Wife wife = new Wife();
	}
}
