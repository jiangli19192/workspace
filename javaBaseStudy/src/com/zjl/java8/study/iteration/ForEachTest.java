package com.zjl.java8.study.iteration;

import java.util.ArrayList;
import java.util.List;

public class ForEachTest {

	public static void main(String[] args) {
		ForEachTest t = new ForEachTest();
//		t.test();
		t.test2();
	}

	private void test() {
		// 补全代码
		List<Student> students = init();
		
		students.stream().forEach(student -> {
			System.out.println("姓名：" + student.getStuName() + ";年龄：" + student.getAge() + ";国籍："+ student.getCountry());
		});
	}
	
	private void test2() {
		List<Student> students = init();
		students.forEach(student -> {
			if (student.getAge() == 22) {
				return;
			}
			
			System.out.println("姓名：" + student.getStuName() + ";年龄：" + student.getAge() + ";国籍："+ student.getCountry());
		});
		
		System.out.println("---------------------------------------------------");
		
		for(Student student : students) {
			if (student.getAge() == 22) {
				continue;
			}
			
			System.out.println("姓名：" + student.getStuName() + ";年龄：" + student.getAge() + ";国籍："+ student.getCountry());
		}
	}

	private List<Student> init() {
		List<Student> students = new ArrayList<>();
		Student stu = new Student();
		stu.setStuName("stu1");
		stu.setAge(22);
		stu.setCountry("China");
		students.add(stu);
		stu = new Student();
		stu.setStuName("stu2");
		stu.setAge(25);
		stu.setCountry("USA");
		students.add(stu);
		stu = new Student();
		stu.setStuName("stu3");
		stu.setAge(23);
		stu.setCountry("China");
		students.add(stu);
		return students;
	}
	
	class Student {
		String stuName;
		int age;
		String country;

		public String getStuName() {
			return stuName;
		}

		public void setStuName(String stuName) {
			this.stuName = stuName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
	}
}
