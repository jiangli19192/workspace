package com.zjl.bean;

public class Person {
	private String name;
	private Integer age;
	
	public Person() {
		super();
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	Integer getAge() {
		return age;
	}

	void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
