package com.zjl.study.clone.shallowCopy;

/**
 * 对象中全部是基本类型
 * ClassName : Teacher
 * @author 张江立
 * @date 2019年6月14日 下午4:10:48
 *
 */
public class Teacher implements Cloneable {
	private String name;
	private int age;
	
	public Teacher(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
}
