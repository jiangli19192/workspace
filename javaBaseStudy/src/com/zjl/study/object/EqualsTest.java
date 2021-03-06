package com.zjl.study.object;

public class EqualsTest {
	private String id;
	
	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}
	
	public static void main(String[] args) {
		EqualsTest test = new EqualsTest();
//		test.testEqualsByObject();
		test.testEqualsByString();
	}
	
	private void testEqualsByObject() {
		EqualsTest test1 = new EqualsTest();
		EqualsTest test2 = new EqualsTest();
		
		System.out.println("两个对象的引用不相同：" + test1.equals(test2));
		
		EqualsTest test3 = test1;
		System.out.println("两个对象的引用相同：" + test3.equals(test1));
	}
	
	/**
	 * https://blog.csdn.net/qq_20032995/article/details/52141577
	 */
	private void testEqualsByString() {
		String a = "abc";
		String b = "abc";
		
		System.out.println(a.equals(b));
		
		String c = new String("abc");
		String d = new String("abc");
		
		System.out.println(c.equals(d));
	}
}
