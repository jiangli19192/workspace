package com.zjl.example.serializable.entry;

import java.io.Serializable;

public class Person  implements Serializable{

	/**
	 * 
	 * serialVersionUID 
	 * long
	 */
	private static final long serialVersionUID = -7543777699522489738L;
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void resetName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[姓名=" + name + ", 年龄=" + age + "]";
	}
}
