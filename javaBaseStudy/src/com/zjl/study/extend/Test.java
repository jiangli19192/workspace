package com.zjl.study.extend;

public class Test {
	
	
	public static void add(ParentClass parentClass){
		ChildrenClass1 aa = (ChildrenClass1)parentClass;
		
		System.out.println("age1=" + aa.getAge1() + ";  name1=" + aa.getName1());
	}
	
	public static void add2(ParentClass parentClass){
		ChildrenClass2 aa = (ChildrenClass2)parentClass;
		
		System.out.println("age1=" + aa.getAge2() + ";  name1=" + aa.getName2());
	}
	
	
	public static void main(String[] args) {
		ChildrenClass1 class1 = new ChildrenClass1();
		class1.setAge(0);
		class1.setName("name");
		
		class1.setAge1(1);
		class1.setName1("name1");
		
		
		ChildrenClass2 class2 = new ChildrenClass2();
		class2.setAge(0);
		class2.setName("name");
		
		
		class2.setAge2(2);
		class2.setName2("name2");
		
		Test.add(class1);
		Test.add2(class2);
	}
}
