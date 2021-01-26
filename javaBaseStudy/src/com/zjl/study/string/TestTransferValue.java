package com.zjl.study.string;

import com.zjl.study.string.entity.Person;

/**
 * 1.值传递，引用传递
 * 2.变量方法的作用域
 * ClassName : TestTransferValue
 * @author 张江立
 * @date 2020年2月27日 下午11:18:04
 *
 */
public class TestTransferValue {
	private int age = 1;
	
	/**
	 * 传值
	 * @param age
	 */
	public void changeValue1(int age) {
		this.age = age;
		age = 30;
	}
	
	/**
	 * 传引用
	 * @param person
	 */
	public void changeValue2(Person person) {
		person.setPersonName("xxx");
	}
	
	/**
	 * 传引用
	 * @param str
	 */
	public void changeValue3(String str) {
		str = "xxx";
	}
	
	/**
	 * 输出结果：
	 * 20
	 * xxx
	 * abc
	 * @param args
	 */
	public static void main(String[] args) {
		TestTransferValue test = new TestTransferValue();
		
		int age = 20;
		test.changeValue1(age);
		System.out.println(age);
		
		Person person = new Person("abc");
		test.changeValue2(person);
		System.out.println(person.getPersonName());
		
		String str = "abc";
		test.changeValue3(str);
		System.out.println(str);
		
		System.out.println(test.age);
	}

}
