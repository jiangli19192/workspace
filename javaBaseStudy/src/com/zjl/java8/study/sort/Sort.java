package com.zjl.java8.study.sort;

public class Sort {
	private int one;
	private int two;
	private int three;
	private String name;
	
	public Sort(String name) {
		this.name = name;
	}
	
	public Sort(int one, int two, int three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}
	

	int getOne() {
		return one;
	}

	void setOne(int one) {
		this.one = one;
	}

	int getTwo() {
		return two;
	}

	void setTwo(int two) {
		this.two = two;
	}

	int getThree() {
		return three;
	}

	void setThree(int three) {
		this.three = three;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
