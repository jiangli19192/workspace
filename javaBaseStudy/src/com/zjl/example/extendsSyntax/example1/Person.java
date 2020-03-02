package com.zjl.example.extendsSyntax.example1;

public class Person {
	protected String name;
	protected int age;
	protected String sex;
	
	Person() {
		System.out.println("Person Default Constrctor.");
	}
	
	Person(String name) {
		System.out.println("Person Constrctor------" + name);
	}
}
