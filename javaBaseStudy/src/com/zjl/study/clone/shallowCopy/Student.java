package com.zjl.study.clone.shallowCopy;

/**
 * 学生类
 * ClassName : Student
 * @author 张江立
 * @date 2019年6月14日 下午4:13:00
 *
 */
public class Student {
	private String name;
	private int age;
	
	public Student(String name, int age) {
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

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}
}
