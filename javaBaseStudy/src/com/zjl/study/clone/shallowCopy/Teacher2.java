package com.zjl.study.clone.shallowCopy;

/**
 * 对象中含有引用类型
 * ClassName : Teacher
 * @author 张江立
 * @date 2019年6月14日 下午4:10:48
 *
 */
public class Teacher2 implements Cloneable {
	private String name;
	private int age;
	private Student student;
	
	public Teacher2(String name, int age, Student student) {
		super();
		this.name = name;
		this.age = age;
		this.student = student;
	}
	
	// 覆盖
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
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

	Student getStudent() {
		return student;
	}

	void setStudent(Student student) {
		this.student = student;
	}
}
